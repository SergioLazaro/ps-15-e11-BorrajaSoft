package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Class that manages the buttons (and their listeners) that appear on the
 * Product being selected in the Top panel
 * 
 * @author Hijus
 *
 */
@SuppressWarnings("serial")
public class TopButtons extends JPanel implements ActionListener {

	protected JButton minus;
	protected JButton plus;
	protected JTextField quantity;
	protected final int maxClothes;

	public TopButtons(int max) {
		maxClothes = max;

		minus = new JButton("-");
		minus.setActionCommand("less");
		minus.addActionListener(this);

		plus = new JButton("+");
		plus.setActionCommand("more");
		plus.addActionListener(this);

		quantity = new JTextField();
		quantity.setBounds(10, 10, 10, 10);
		quantity.setColumns(4);
		quantity.addActionListener(this);
		addQuantityListener();
		quantity.setText(String.valueOf(maxClothes));

		setOpaque(true);

		add(minus);
		add(quantity);
		add(plus);
	}

	/**
	 * Method for enabling/disabling the buttons when
	 * the text contained in the JTextField changes.
	 * It enables/disables the buttons by checking if
	 * the number of clothes is in the range [0..maxClothes].
	 * If not, it sets the value to the nearest correct number.
	 */
	private void addQuantityListener() {
		quantity.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			    event();
			}
			public void removeUpdate(DocumentEvent e) {
				event();
			}
			public void insertUpdate(DocumentEvent e) {
			    event();
			}
			
			/**
			 * Method that implements the Listener of the JTextField
			 * Basically, it manages the buttons enable/disable and
			 * checks if the number of clothes is in the
			 * range [0..maxClothes]. If not, it sets the value with 
			 * the nearest correct number.
			 */
			public void event() {
				int num;
				try{
					num = Integer.parseInt(quantity.getText());
					if (num <= 0){
						plus.setEnabled(true);
						minus.setEnabled(false);
						if (num<0) {
							javax.swing.SwingUtilities.invokeLater(new Runnable() {
					            public void run() {
					    			quantity.setText(String.valueOf(0));
					            	}
					        });
						}
					} else if (num >= maxClothes){
						
						plus.setEnabled(false);
						minus.setEnabled(true);
						if (num>maxClothes) {
							javax.swing.SwingUtilities.invokeLater(new Runnable() {
					            public void run() {
					    			quantity.setText(String.valueOf(maxClothes));
					            	}
					        });						
						}
					} else {
						plus.setEnabled(true);
						minus.setEnabled(true);
					}
					
				} catch (NumberFormatException e) {	
					minus.setEnabled(false);
					plus.setEnabled(true);
				}
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		int num;
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
			}
			
			quantity.setText(String.valueOf(num));
			
		} catch (NumberFormatException e) {
			quantity.setText(String.valueOf(0));
		}
	}

}
