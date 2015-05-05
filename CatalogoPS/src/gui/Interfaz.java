package gui;

/*
 * DEPRECATED -- FOR TEST ONLY
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;

public class Interfaz {

	private JFrame frmCatlogoTextil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmCatlogoTextil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCatlogoTextil = new JFrame();
		frmCatlogoTextil.setTitle("Cat\u00E1logo textil");
		frmCatlogoTextil.setBounds(100, 100, 723, 490);
		frmCatlogoTextil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCatlogoTextil.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(40, 83, -155, -36);
		frmCatlogoTextil.getContentPane().add(splitPane);
	}
}
