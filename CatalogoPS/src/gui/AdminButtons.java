package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AdminButtons extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	//Admin buttons
	  private JButton insertButton;
	  private JButton updateButton;
	  private JButton deleteButton;
	  private JPanel layeredPane;
	  
	  public AdminButtons(){
		  layeredPane = HomeWindow.getLayeredPane();
		  this.setBounds(400, 20, 160, 90);
		  this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		  //Insert button
		  insertButton = new JButton("Insert element");
		  insertButton.setActionCommand("insert");
		  insertButton.addActionListener(this);
		  
		  //Update button
		  updateButton = new JButton("Update element");
		  updateButton.setActionCommand("update");
		  updateButton.addActionListener(this);
		  
		  //Delete button
		  deleteButton = new JButton("Delete element");
		  deleteButton.setActionCommand("delete");
		  deleteButton.addActionListener(this);
		  
		  setOpaque(true);
		  
		  add(insertButton);
		  add(updateButton);
		  add(deleteButton);
//		  setLayout(new BoxLayout());
		  layeredPane.add(this);
	  }

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		switch (evt.getActionCommand()) {
		case "insert":
			@SuppressWarnings("unused")
			PopUpInsert insert = new PopUpInsert();
			break;
		case "update":
			@SuppressWarnings("unused")
			PopUpUpdate update = new PopUpUpdate();
			break;
		case "delete":
			@SuppressWarnings("unused")
			PopUpDelete delete = new PopUpDelete();
			break;
		}
	}
}
