package gui;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import façade.DataExtraction;

/**
 * Class that manages the Right panels in the GUI
 * @author Hijus
 *
 */
public class Right {

	private JLayeredPane layeredPane;
	private DefaultListModel mCart; // To be used, to update
	private DefaultListModel mHistory;
	private JList shoppingCartList;
	private JList historyList;
	private int idUser;
	private DataExtraction data;
	
	/**
	 * -- Constructor --
	 * @param panel - main panel of the application
	 * @param usr - user identifier, obtained on login
	 */
	public Right(JLayeredPane panel, int usr){
		layeredPane = panel;
		idUser = usr;
		data = new DataExtraction();
		mCart = new DefaultListModel();
		mHistory = new DefaultListModel();
		initialize();
	}
	
	/**
	 * Method that generates both the Shopping Cart and the History Panels in the GUI
	 */
	private void initialize(){
		JScrollPane shoppingCartScroll = new JScrollPane();
		shoppingCartScroll.setBounds(463, 124, 238, 167);
		layeredPane.add(shoppingCartScroll);
		
		//Taking the pyme's shopping cart
		ArrayList<String> array = null;
		try {
			array = data.gettingShoppingCart(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(array!=null){
			for (Object o : array){
				mCart.addElement(o);
			}
			
		}
		shoppingCartList = new JList<>(mCart);
		
		shoppingCartList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shoppingCartScroll.setViewportView(shoppingCartList);
		shoppingCartList.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollHistory = new JScrollPane();
		scrollHistory.setBounds(464, 290, 237, 155);
		layeredPane.add(scrollHistory);
		
		//Taking the worker historical registry
		try {
			array = data.gettingHistorical(idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(array!=null){
			for (Object o : array){
				mHistory.addElement(o);
			}
			
		}
		historyList = new JList(mHistory);
		
		historyList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollHistory.setViewportView(historyList);
		historyList.setBackground(new Color(204, 255, 204));
	}
}
