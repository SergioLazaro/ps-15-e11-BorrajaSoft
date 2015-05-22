package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import facade.DataExtraction;
import facade.DataInsertion;

public class PopUpWarnings {
	
	//Table selection
	private JLabel tableLabel;
	private DataInsertion dataInsertion;
	private DataExtraction dataExtraction;
	private JTextField textField;
	private ArrayList<String> array;
	private JList<String> list;
	private DefaultListModel<String> model;
	private JScrollPane scrollPane;
	private static int minStock = 5;

	
	public PopUpWarnings(){
		dataInsertion = new DataInsertion();
		dataExtraction = new DataExtraction();
		model = new DefaultListModel<String>();
		
		SpringLayout layout = new SpringLayout();
		
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,145));
        panel.setLayout(new BorderLayout());
        
        tableLabel = new JLabel("New minimum stock: ");
        
        //Textfield
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150,23));

        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(tableLabel);
        northPanel.add(textField);
        panel.add(northPanel, BorderLayout.PAGE_START);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(173, 225, 385, 480);
        panel.add(scrollPane, BorderLayout.CENTER);

        array = dataExtraction.getWarnings(minStock);
        for(String s : array){
        	model.addElement(s);
        }
        list = new JList<String>(model);
        scrollPane.setViewportView(list);
        list.setVisible(true);
        
        String[] options = new String[] { "Confirm margin", "Cancel" };
        int option = JOptionPane.showOptionDialog(null, panel, "Check warnings",
        		JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        
        
        String line = "";
        if (option == 0) // pressing OK button
        {
           line = textField.getText();
           if(line.length() > 0){
        	   minStock = Integer.parseInt(line);
           }
        }
        
	}

}
