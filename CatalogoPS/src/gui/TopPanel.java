/**
* Version 1
* Author: Sergio
*/

package gui;

import facade.DataExtraction;
import facade.Product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.border.Border;

public class TopPanel {
	private int idUser;	
	private CenterPanel centerPanel;
	private JPanel jp1;
	private JPanel layeredPane;
	private JScrollPane scrollPane1;

   /**
    * Creates the top panel of the GUI.
    * @param idUser is equals to user ID
    */
   public TopPanel(int idUser) {
	  this.idUser = idUser;
      layeredPane = HomeWindow.getLayeredPane();
      centerPanel = HomeWindow.getCenter();
      initialize();
      
   }

   /**
    * Method that updates the top panel with an element selected from the center panel or the
    * history panel.
    * 
    * Important: The image used for the default image should no be larger than the JScrollPane that
    * contains the image (291x102). Otherwise, the image will need to be scrolled to see it in full
    * size. Also, the image must be in a jpg format named like this: icon_"name_of_the_product".jpg
    * where "name_of_the_product" corresponds to the full name of the product, this is, name and the
    * brand
    * 
    * @param p is the product to modify.
    */
   public void update(Product p) {
      jp1 = new JPanel(new BorderLayout(20, 0));
      jp1.setBackground(Colors.TOP_BUTTONS_BACKGROUND);
      // Search & add the image
      DataExtraction d = HomeWindow.getDataEx();
      try {
         jp1.add(new JLabel(new ImageIcon(HomeWindow.class.getResource(d.getProductPath(p
                  .getProductTypeID())))), BorderLayout.LINE_START);
      } catch (NullPointerException e) {
         jp1.add(new JLabel(new ImageIcon(HomeWindow.class.getResource("/photos/no_image.jpg"))),
                  BorderLayout.LINE_START);
      }
      // Add padding
      Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
      jp1.setBorder(paddingBorder);
      // Add the name and buttons
      jp1.add(new JLabel(p.getProductID() + " , " + p.getName()), BorderLayout.CENTER);
      scrollPane1.setViewportView(jp1);
      JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      jp2.add(new TopButtons(p.getStock(), p, idUser, 0));
      System.out.println("centerPANEL ES " + centerPanel);
      jp2.setBackground(Colors.TOP_BUTTONS_BACKGROUND);
      jp1.add(jp2, BorderLayout.PAGE_END);
      // scan.close();
   }

   /**
    * Update the product in the shopping cart.
    * @param p is the product in the shopping cart.
    */
   public void updateFromCart(Product p) {
      DataExtraction d = HomeWindow.getDataEx();
      jp1 = new JPanel(new BorderLayout(20, 0));
      jp1.add(new JLabel(new ImageIcon(HomeWindow.class.getResource(d.getProductPath(p
               .getProductTypeID())))), BorderLayout.LINE_START);
      jp1.setBackground(Colors.TOP_BUTTONS_BACKGROUND);
      // Add padding
      Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
      jp1.setBorder(paddingBorder);
      // Add the name and buttons
      jp1.add(new JLabel(p.getProductID() + " , " + p.getName()), BorderLayout.CENTER);
      scrollPane1.setViewportView(jp1);
      JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      jp2.add(new TopButtons(d.getStackFromCart(p.getProductID(), idUser), p, idUser, 1));
      jp2.setBackground(Colors.TOP_BUTTONS_BACKGROUND);
      jp1.add(jp2, BorderLayout.PAGE_END);
   }

   /**
    * Method that initialises the top panel
    * 
    * Important: The image used for the default image should no be larger that the JScrollPane that
    * contains the image (291x102). Otherwise, the image will need to be scrolled to see it in full
    * size.
    */
   private void initialize() {
      scrollPane1 = new JScrollPane();
      scrollPane1.setBounds(173, 124, 385, 102);
      layeredPane.add(scrollPane1);
      // // first line
      jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      jp1.setBackground(Colors.TOP_BUTTONS_BACKGROUND);
      jp1.add(new JLabel(new ImageIcon(HomeWindow.class.getResource("/photos/LookingFor.jpg"))));
      jp1.add(new JLabel(" Seleccionar prenda "));
      // second line
      scrollPane1.setViewportView(jp1);
      jp1.setVisible(true);
   }
}
