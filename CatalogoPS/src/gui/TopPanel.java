package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import façade.Product;

/**
 * Class that manages the Top panel in the GUI
 * @author Hijus
 *
 */
public class TopPanel {

	private JLayeredPane layeredPane;
	private JPanel jp1;
	private JScrollPane scrollPane1;
	
	/**
	 * -- Constructor --
	 * @param panel
	 */
	public TopPanel(JLayeredPane panel){
		layeredPane = panel;
		initialize();
	}
	
	/**
	 * Method that initializes the top panel
	 * 
	 * Important: The image used for the default image should no be larger that the
	 * JScrollPane that contains the image (291x102). Otherwise, the image will need
	 * to be scrolled to see it in full size.
	 */
	private void initialize(){
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(173, 124, 291, 102);
		layeredPane.add(scrollPane1);
		
//		// first line
	   jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//	   jp1.add(new JLabel(new ImageIcon(PantInicio.class.getResource("/imagenes/buscar.jpg"))));
	   jp1.add(new JLabel(" Seleccionar prenda "));
//
//	   // second line
//	   JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
//	   jp2.add(new JLabel(new ImageIcon(PantInicio.class.getResource("/imagenes/icon_pantalon.jpg"))));
//	   jp2.add(new JLabel(" Pantalon"));
//	   

	   scrollPane1.setViewportView(jp1);
	   
	   jp1.setVisible(true);
	}
	
	/**
	 * Method that updates the top panel with an element selected from the center panel or
	 * the history panel.
	 * 
	 * Important: The image used for the default image should no be larger than the
	 * JScrollPane that contains the image (291x102). Otherwise, the image will need
	 * to be scrolled to see it in full size. Also, the image must be in a jpg format
	 * named like this:
	 * 			icon_"name_of_the_product".jpg
	 * where "name_of_the_product" corresponds to the full name of the product, this is,
	 * name and the brand
	 * @param p 
	 */
	public void update(Product p){
		jp1 = new JPanel(new BorderLayout(20,0));
			
		// Search & add the image
		Scanner scan = new Scanner(p.getName());
		String nombre = scan.next();
		if(PantInicio.class.getResource("/photos/icon_" + nombre + ".jpg")==null) {
			jp1.add(new JLabel(new ImageIcon(PantInicio.class.getResource("/photos/no_image.jpg"))), BorderLayout.LINE_START);
		}else{
			jp1.add(new JLabel(new ImageIcon(PantInicio.class.getResource("/photos/icon_" 
					+ nombre + ".jpg"))), BorderLayout.LINE_START);
		}
		
		// Add padding
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,0,0);
		jp1.setBorder(paddingBorder);
		
		// Add the name and buttons
		jp1.add(new JLabel(p.getName()), BorderLayout.CENTER);
		
		scrollPane1.setViewportView(jp1);

		
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp2.add(new TopButtons(p.getStock()));
		
		jp1.add(jp2, BorderLayout.PAGE_END);

		scan.close();
	}
	
	public void updateFromCart(Product p){
		
	}
}
