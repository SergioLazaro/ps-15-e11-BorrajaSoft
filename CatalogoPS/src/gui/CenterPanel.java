package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

import facade.Product;

/**
 * Class that manages the Bottom-center Panel in the GUI.
 */
public class CenterPanel {
   private JPanel layeredPane;
   private DefaultListModel<Product> model;
   private JList<Product> list;
   private String comboBoxOption = "Nombre (a-z)";
   private String orderBy;
   private boolean asc;

   /**
    * Constructor. Creates the bottom center panel.
    * 
    * @param parent The principal banner.
    * @param array The list of products to show in the panel.
    */
   public CenterPanel(ArrayList<Product> array) {
	  orderBy = "alpha";
	  asc = true;
      layeredPane = HomeWindow.getLayeredPane();
      model = new DefaultListModel<Product>();
      if (array != null) {
         for (Product o : array) {
            model.addElement(o);
         }
      }
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(173, 225, 385, 480);
      layeredPane.add(scrollPane);

      list = new JList<Product>(model);
      list.setBackground(new Color(255, 215, 0)); // yellow
      // list.setBackground(Color.BLUE);//new Color(255, 215, 0));
      
      //Add mouse listener to list
      list.addMouseListener(new MouseAdapter() {
    	    public void mouseClicked(MouseEvent evt) {
    	        customMouseHandler(evt);
    	    }
    	});
      
      list.setForeground(Color.BLACK);
      scrollPane.setViewportView(list);
      list.setVisible(true);
      
      //ComboBox configuration
      String[] options = {"Nombre (a-z)", "Nombre (z-a)","Precio ascendente","Precio descendente"};
      JComboBox<String> comboBox = new JComboBox<String>(options);
      scrollPane.setColumnHeaderView(comboBox);
      comboBox.addActionListener (new ActionListener () {
    	    public void actionPerformed(ActionEvent e) {
    	    	customComboBoxHandler(e);
    	    }
    	});
   }
   
   private void customComboBoxHandler(ActionEvent evt){
	   JComboBox cb = (JComboBox)evt.getSource();
   	
	   	try{
	   		System.err.println();
	   		if(!comboBoxOption.equalsIgnoreCase((String)cb.getSelectedItem())){
	   		//Update list
		   		comboBoxOption = (String)cb.getSelectedItem();
		   		if(comboBoxOption.equalsIgnoreCase("Nombre (a-z)")){
		   			orderBy = "name";
		   			asc = true;
		   		}
		   		else if(comboBoxOption.equalsIgnoreCase("Nombre (z-a)")){
		   			orderBy = "name";
		   			asc = false;
		   		}
		   		else if(comboBoxOption.equalsIgnoreCase("Precio ascendente")){
		   			orderBy = "price";
		   			asc = true;
		   		}
		   		else if(comboBoxOption.equalsIgnoreCase("Precio descendente")){
		   			orderBy = "price";
		   			asc = false;
		   		}
		   		update();
	   		}
	   	}catch(NullPointerException e){
	   		System.err.println("Error estupido");
	   	}
   }
   
   /**
    * Custom mouse handler for the elements clicked on the center JList
    * @param evt
    */
	private void customMouseHandler(MouseEvent evt) {
		System.out.println("ENTRO AL HANDLER");
		@SuppressWarnings("unchecked")
		JList<Product> list = (JList<Product>)evt.getSource();
		if (evt.getClickCount() != 0) {
            Product selected = list.getSelectedValue();
            if(selected!=null) HomeWindow.getTop().update(selected);
        }					
	}
	
   /**
    * Add a list of products to the panel.
    * 
    * @param array A list of products.
    */
   public void update() {
	   model.clear();
      ArrayList<Product> array;
	try {
		array = HomeWindow.getData().basicSearchProducts(HomeWindow.getLastSearch(), orderBy, asc);
	} catch (SQLException e) {
		e.printStackTrace();
		array = new ArrayList<Product>();
	}
      if (array != null) {
         for (Product o : array) {
            model.addElement(o);
         }
      }
      list.updateUI();
   }

   /**
    * Updates the list of products of the panel.
    * 
    * @param array The new list of products.
    */
   public void replace(ArrayList<Product> array) {
      model.clear();
      if (array != null) {
         for (Product o : array) {
            model.addElement(o);
         }
      }
      list.updateUI();
   }

   /**
    * Return the list of products in the panel.
    * 
    * @return A list of products.
    */
   public JList<Product> getList() {
      return list;
   }

   /**
    * 
    * Method that implements the actionListener over the CenterPanelList (Center)
    * 
    * @param evt Event to search.
    * @param top The principal panel.
    */
   public void centerValueChanged(ListSelectionEvent evt) {
	   
      // TODO Auto-generated method stub
      if (!evt.getValueIsAdjusting()) {
         try {
            JList<?> prueba = (JList<?>) evt.getSource();
            if (prueba == null) {
               System.out.println("\nla lista es nula");
            }
            Product select = (Product) prueba.getSelectedValue();
            if (select == null) {
               System.out.println("la prenda es nula");
            } else {
               System.out.println(select);
               HomeWindow.getTop().update(select);
            }
         } catch (NullPointerException e) {
            e.printStackTrace();
         }
      }
   }

}
