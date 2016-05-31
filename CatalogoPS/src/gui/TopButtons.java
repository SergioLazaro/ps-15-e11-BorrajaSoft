/**
* Version 1
* Author: Sergio
*/

package gui;

import facade.DataInsertion;
import facade.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Class that manages the buttons (and their listeners) that appear on the Product 
 * which is being selected in the Top panel.
 */
@SuppressWarnings("serial")
public class TopButtons extends JPanel implements ActionListener {
   
   private int idUser;
   private Product product;
   
   protected int maxClothes;
   protected RightPanel shCart;
   protected CenterPanel center;
   protected JButton buy;
   protected JButton minus;
   protected JButton plus;
   protected JButton remove;
   protected JTextField quantity;
   

   /**
    * Constructor method. 
    * 
    * @param max The maximum number of items.
    * @param product The product ID.
    * @param idUser The user ID
    * @param mode The user mode: normal or administrator.
    */
   public TopButtons(int max, Product product, int idUser, int mode) {
	    //Setting-up the attributes
		maxClothes = max;
		this.product = product;
		this.idUser = idUser;
		this.shCart = HomeWindow.getRight();
		this.center = HomeWindow.getCenter();
		
		//Setting-up the JPanel
		setBackground(Colors.TOP_BUTTONS_BACKGROUND);
		
		//Setting-up minus JButton
		minus = new JButton("-");
		minus.setActionCommand("less");
		minus.addActionListener(this);
		
		//Setting-up plus JButton
		plus = new JButton("+");
		plus.setActionCommand("more");
		plus.addActionListener(this);
		
		//Setting-up buy JButton
		buy = new JButton("Add");
		buy.setActionCommand("buy");
		buy.addActionListener(this);
		
		//Setting-up remove JButton
		remove = new JButton("Remove");
		remove.setActionCommand("remove");
		remove.addActionListener(this);
		
		//Setting-up quantity TextField
		quantity = new JTextField();
		quantity.setBounds(10, 10, 10, 10);
		quantity.setColumns(4);
		quantity.addActionListener(this);
		quantity.setText(String.valueOf(maxClothes));
		
		//Call to the method which add different listeners
		addQuantityListener();
		
		//Adding the different objects to Jpanel
		setOpaque(true);
		add(minus);
		add(quantity);
		add(plus);
		System.out.println();
		
		// Check if one of the necessary panels for adding elements to the cart is null
		if (mode == 0)
		 add(buy);
		else {
		 add(remove);
		 remove.setEnabled(true);
		}
   }

   /**
    * Creates the behaviour for actions related to update user shopping cart.  
	* @param evt must be a semantic event which indicates that a component-defined action ocurred.
    */
   public void actionPerformed(ActionEvent evt) {
      int num;
      DataInsertion data = HomeWindow.getDataIn();
      try {
         num = Integer.parseInt(quantity.getText());
         if (num > maxClothes)
            num = maxClothes;
         switch (evt.getActionCommand()) {
            case "less":
               num--;
               break;
            case "more":
               num++;
               break;
            case "buy":
               // Insert into shoppingCart List
               data.updateProductStock(num, maxClothes, product, idUser);
               // Update top frame
               maxClothes -= num;
               // Update shoppingCart on RightPanel
               shCart.updateShoppingCart();
               center.update();
               break;
            case "remove":
               // Remove from shoppingCart List
               data.updateProductStock(-num, maxClothes, product, idUser);
               maxClothes -= num;
               shCart.updateShoppingCart();
               center.update();
               break;
         }
         quantity.setText(String.valueOf(num));
      } catch (NumberFormatException e) {
         quantity.setText(String.valueOf(0));
      }
   }

   /**
    * Method for enabling/disabling the buttons when the text contained in the JTextField changes.
    * It enables/disables the buttons by checking if the number of clothes is in the range
    * [0..maxClothes]. If not, it sets the value to the nearest correct number.
    */
   private void addQuantityListener() {
      quantity.getDocument().addDocumentListener(new DocumentListener() {
         public void changedUpdate(DocumentEvent e) {
            event();
         }

         public void insertUpdate(DocumentEvent e) {
            event();
         }

         public void removeUpdate(DocumentEvent e) {
            event();
         }

         /**
          * Method that implements the Listener of the JTextField Basically, it manages the buttons
          * enable/disable and checks if the number of clothes is in the range [0..maxClothes]. If
          * not, it sets the value with the nearest correct number.
          */
         private void event() {
            int num;
            try {
               num = Integer.parseInt(quantity.getText());
               if (num <= 0) { //If num <= 0 just allow to increase
                  plus.setEnabled(true);
                  minus.setEnabled(false);
                  buy.setEnabled(false);
                  remove.setEnabled(false);
                  if (num < 0) {
                     javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                           quantity.setText(String.valueOf(0));
                        }
                     });
                  }
               } else if (num >= maxClothes) {	//If num >= 0 just allow to decrement
                  plus.setEnabled(false);
                  minus.setEnabled(true);
                  buy.setEnabled(true);
                  remove.setEnabled(true);
                  if (num > maxClothes) {
                     javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                           quantity.setText(String.valueOf(maxClothes));
                        }
                     });
                  }
               } else { //Otherwise, we allow every possibility
                  plus.setEnabled(true);
                  minus.setEnabled(true);
                  buy.setEnabled(true);
                  remove.setEnabled(true);
               }
            } catch (NumberFormatException e) {
               minus.setEnabled(false);
               plus.setEnabled(true);
               buy.setEnabled(false);
               remove.setEnabled(false);
            }
         }
      });
   }
}
