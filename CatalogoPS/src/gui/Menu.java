package gui;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import facade.DataExtraction;

public class Menu {
   // TODO Maybe create methods instead of having everything in the Constructor?
   private DataExtraction data = new DataExtraction();
   private JPanel layeredPane;
   private JTree selectionTree;

   /**
    * Generates a menu and adds it to [panel]
    * 
    * @param panel
    *           The JlayeredPane to which the menu is added
    */
   public Menu() {
      layeredPane = HomeWindow.getLayeredPane();
      JScrollPane scrollSelectionTree = new JScrollPane();
      scrollSelectionTree.setBounds(0, 124, 174, 581);
      layeredPane.add(scrollSelectionTree);
      selectionTree = new JTree();
      selectionTree.setBackground(Colors.COMBOBOX_BACKGROUND);
      selectionTree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      scrollSelectionTree.setViewportView(selectionTree);
      try {
         DefaultTreeModel DTM = new DefaultTreeModel(new DefaultMutableTreeNode("Clothes") {
            private static final long serialVersionUID = 1L;
            {
               DefaultTreeCellRenderer renderers = (DefaultTreeCellRenderer) selectionTree
                        .getCellRenderer();
               renderers.setBackgroundNonSelectionColor(Colors.PANEL_BACKGROUND);
               // renderers.setTextSelectionColor(Color.white);
               renderers.setBackgroundSelectionColor(Colors.LIST_SELECTION);
               renderers.setBorderSelectionColor(Color.black);
               // Obtain the elements of the tree
               ArrayList<String> array = data.getProductType();
               DefaultMutableTreeNode nodes[] = new DefaultMutableTreeNode[array.size()];
               String name = "";
               // Navigate through the tree and create parent nodes
               for (int i = 0; i < array.size(); i++) {
                  name = array.get(i);
                  nodes[i] = new DefaultMutableTreeNode(name);
               }
               // Add parent nodes
               for (int i = 0; i < nodes.length; i++) {
                  add(nodes[i]);
               }
               ElementoSubArbol lista[] = new ElementoSubArbol[nodes.length];
               ArrayList<String> tipos; // aux variable
               String prenda;
               for (int i = 0; i < nodes.length; i++) {
                  // For each element, navigate through all possible styles
                  prenda = array.get(i);
                  tipos = data.getStyleProduct(prenda);
                  lista[i] = new ElementoSubArbol(prenda, tipos);
               }
               int i, j;
               for (i = 0; i < lista.length; i++) {
                  tipos = lista[i].getEstilos();
                  for (j = 0; j < tipos.size(); j++) {
                     nodes[i].add(new DefaultMutableTreeNode(tipos.get(j)));
                  }
               }
            }
         });
         selectionTree.setModel(DTM);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   /**
    * Get the JTree associated with the menu. This method is intended to be used for defining
    * actionListeners.
    * 
    * @return The JTree selected.
    */
   public JTree getTree() {
      return selectionTree;
   }
}
