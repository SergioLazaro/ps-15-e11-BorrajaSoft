package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

import façade.Product;

/**
 * Class that manages the Bottom-Center Panel in the GUI
 * 
 * @author Hijus
 *
 */
public class CenterPanel {
	private JLayeredPane layeredPane;
	private DefaultListModel<Product> model;
	private JList<Product> list;
	
	/**
	 * -- Constructor --
	 * Creates the Bottom-Center Panel
	 * @param parent
	 * @param scroll
	 * @param array
	 */
	public CenterPanel(JLayeredPane parent, ArrayList<Product> array) {
		this.layeredPane = parent;
		model = new DefaultListModel<Product>();
		if(array!=null){
			for(Product o : array){
				model.addElement(o);
			}
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 225, 291, 221);
		layeredPane.add(scrollPane);
		
		list = new JList<Product>(model);
		list.setBackground(new Color(255, 215,0)); // yellow
		//list.setBackground(Color.BLUE);//new Color(255, 215, 0));
		list.setForeground(Color.BLACK);
		scrollPane.setViewportView(list);
		list.setVisible(true);
	}
	
	public void update(ArrayList<Product> array){
		list.setVisible(false);
		if(array!=null){
			for(Product o : array){
				model.addElement(o);
			}
		}
		list.setVisible(true);
	}
	
	public void replace(ArrayList<Product> array){
		model.clear();
		if(array!=null){
			for(Product o : array){
				model.addElement(o);
			}
		}
		list.updateUI();
	}

	public JList<Product> getList() {
		return list;
	}
	
	/**
	 * Method that implements the actionListener over the CenterPanelList (Center)
	 * @param evt - event
	 */
	public void centerValueChanged(ListSelectionEvent evt, TopPanel top) {
		// TODO Auto-generated method stub
		if(!evt.getValueIsAdjusting()){
			try{
				JList<?> prueba = (JList<?>) evt.getSource();
				if (prueba == null){
					System.out.println("\nla lista es nula");
				}
				System.out.println("\nLa lista es " + prueba);
				Product select = (Product) prueba.getSelectedValue();
				if (select == null){
					System.out.println("la prenda es nula");
				}
				else{
					System.out.println(select);
					top.update(select);
				}
	//			Prenda select = (Prenda) ((JList<Prenda>) evt.getSource()).getSelectedValue();
	//			String selectString = select.toString();
	//			System.out.print("Elemento seleccionado: ");
	//			System.out.println(selectString);
			}catch(NullPointerException e){
				e.printStackTrace();
			}
		}	
	}
	

}
