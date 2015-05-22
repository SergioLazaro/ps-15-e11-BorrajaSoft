package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;

import facade.Customer;
import facade.DataExtraction;
import facade.DataInsertion;
import facade.Order;
import facade.ProductOrder;

public class OrderWindow {

	private static DataExtraction data;
	private static DataInsertion dataIns;
	private ArrayList<ProductOrder> orderArray;
	private static JList<ProductOrder> orderList;
	private static DefaultListModel<ProductOrder> mOrder; // To be used, to
															// update
	private Order myOrder;
	private JPanel panel;

	public OrderWindow(Order myOrder) throws IOException {
		this.myOrder = myOrder;
		data = new DataExtraction();
		dataIns = new DataInsertion();
		mOrder = new DefaultListModel<ProductOrder>();

		inicializate();
	}

	public void inicializate() throws IOException {
		SpringLayout layout = new SpringLayout();

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		panel.setLayout(layout);

		JLabel msg = new JLabel("Product ID | Brand | Name | Price | Num. Items");
		panel.add(msg);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(300, 250));
		//scroll.setBounds(558, 124, 300, 250);
		panel.add(scroll);
		
		layout.putConstraint(SpringLayout.NORTH, scroll, 5, SpringLayout.SOUTH, msg);

		orderArray = null;
		try {
			orderArray = data.getProductsFromOrder(myOrder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (orderArray != null) {
			for (ProductOrder o : orderArray) {
				mOrder.addElement(o);
			}

		}

		orderList = new JList<>(mOrder);

		orderList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		scroll.setViewportView(orderList);
		orderList.setBackground(new Color(255, 255, 255));
		
		
		String date = myOrder.getDate();
		Date d;
		int numDays = 0;
		try {
			
			Date currentDate = new Date();
		    String date2 = (currentDate.getYear()+1900) + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate();

			
			SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
			
			long d1=formater.parse(date).getTime();
			long d2=formater.parse(date2).getTime();

			numDays = (int) (Math.abs((d1-d2)/(1000*60*60*24)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		if (numDays > 15) {
			JLabel msg2 = new JLabel("You can't cancell this record");
			panel.add(msg2);
			layout.putConstraint(SpringLayout.NORTH, msg2, 5, SpringLayout.SOUTH, scroll);
			
			
			String[] options = new String[] { "Print", "Ok" };
			int option = JOptionPane.showOptionDialog(null, panel, "My order",
					JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					options, options[0]);
			if (option == 0) // print order
			{
				generateFileChooser();
				inicializate();
			}
		}
		else {
			String[] options = new String[] { "Cancel order", "Print", "Ok" };
			int option = JOptionPane.showOptionDialog(null, panel, "My order",
					JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					options, options[0]);
			
			if (option == 0) {		// Delete the order form the DB
				dataIns.deleteOrder(myOrder, orderArray);
				inicializateEnd();
				HomeWindow.getCenter().update();
			}
			else if (option == 1) // print order
			{
				generateFileChooser();
				inicializate();
			}
		}

		
		
	}

	
	
	public void inicializateEnd() {
		SpringLayout layout = new SpringLayout();

		panel = new JPanel();
		panel.setLayout(layout);

		JLabel msg = new JLabel("Your order has been removed");
		panel.add(msg);

		String[] options = new String[] { "Ok" };
		int option = JOptionPane.showOptionDialog(null, panel, "My order",
				JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
				options, options[0]);
		
		if (option == 0) {		// Exit
			
		}
	}
	
	
	/**
	 * Generate an emergent window to chose a file to save
	 * @throws IOException
	 */
	public void generateFileChooser() throws IOException {
		System.out.println("Guardando recibo");
		JFileChooser saveFile = new JFileChooser();
		saveFile.addChoosableFileFilter(new FileFilter() {

			String description = "Sorted Files (*.txt)";// the filter you see
			String extension = "txt";// the filter passed to program

			@Override
			public boolean accept(File f) {
				if (f == null)
					return false;
				if (f.isDirectory())
					return true;
				return f.getName().toLowerCase().endsWith(extension);
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return description;
			}
		});

		// saveFile.showSaveDialog(null);
		saveFile.setDialogTitle("Specify a file to save");
		// saveFile.setCurrentDirectory(new File("*.txt"));

		int userSelection = saveFile.showSaveDialog(panel);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = saveFile.getSelectedFile();
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());

			String path = fileToSave.getAbsolutePath();
			printRecord(path);
		}
	}

	/**
	 * Print the current record in a File
	 * @param path
	 * @throws IOException
	 */
	public void printRecord(String path) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		
		try {
			Customer user = data.getCustomerInfo(myOrder.getCustomerID());
			
			bw.write("BorrajaSoft\n");
			bw.write("Textile Manager                           Order: #" + myOrder.getOrderID() + "  -  " + myOrder.getDate() + "\n");
			bw.write("===================================================================\n\n");
			bw.write(user.getSurname() + ", " + user.getName() + "\n");
			bw.write(user.getMailAddress() + "\n");
			bw.write(user.getDeliveringAddress() + "\n");
			bw.write("===================================================================\n");
			bw.write("===================================================================\n\n\n");
			bw.write("Product Id | Brand | Name | Price | Cuantity\n");
			bw.write("-------------------------------------------------------------------\n");

			for (ProductOrder po : orderArray) {
				bw.write(po + "\n");
			}
			
			bw.write("-------------------------------------------------------------------\n\n");
			bw.write("                                             Total price: " + myOrder.getTotalPrice() + " €");
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		bw.close();
	}

}
