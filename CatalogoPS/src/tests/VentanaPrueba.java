package tests;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class VentanaPrueba {

	private JFrame frmVentana;
	private JTextField txtRopitaOnline;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba window = new VentanaPrueba();
					window.frmVentana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVentana = new JFrame();
		frmVentana.setTitle("Ventana");
		frmVentana.setBounds(100, 100, 706, 479);
		frmVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentana.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Botoncillo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 128, 157);
		addPopup(frmVentana.getContentPane(), popupMenu);
		btnNewButton.setBounds(244, 190, 111, 36);
		frmVentana.getContentPane().add(btnNewButton);
		
		txtRopitaOnline = new JTextField();
		txtRopitaOnline.setText("Victorcico gay");
		txtRopitaOnline.setBounds(158, 56, 86, 20);
		frmVentana.getContentPane().add(txtRopitaOnline);
		txtRopitaOnline.setColumns(10);
		
		JTextPane txtpnRopaOnlne = new JTextPane();
		txtpnRopaOnlne.setText("Toni bebe");
		txtpnRopaOnlne.setBounds(357, 56, 86, 20);
		frmVentana.getContentPane().add(txtpnRopaOnlne);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(0, 0, 109, 23);
		frmVentana.getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblHola = new JLabel("Hola");
		lblHola.setBounds(228, 114, 46, 14);
		frmVentana.getContentPane().add(lblHola);
		
		table = new JTable();
		table.setBounds(158, 321, 146, -76);
		frmVentana.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 350, 116, -95);
		frmVentana.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBounds(503, 191, -76, -49);
		frmVentana.getContentPane().add(table_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

