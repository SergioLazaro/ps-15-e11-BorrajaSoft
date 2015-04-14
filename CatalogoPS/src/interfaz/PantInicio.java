package interfaz;

import BD.*;
import Facade.*;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.BorderLayout;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.AbstractListModel;

import java.awt.Color;

import javax.swing.JMenuItem;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.Point;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.JLayeredPane;
import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PantInicio {

	private JFrame frameRopaUltracool;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private static JTextField textField;
	private static JButton botonBuscar;
	private static ArrayList<Pyme> pymeArray;
	private static ArrayList<Prenda> prendaArray;
	private static DataExtraction data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		data = new DataExtraction();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantInicio window = new PantInicio();
					window.frameRopaUltracool.setVisible(true);
					botonBuscar.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){
							String text = textField.getText();
							
							try {
								prendaArray = data.lookingForPrenda(text);
								pymeArray = data.lookingForPymes(text);
								textField.setText("");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					});
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public PantInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRopaUltracool = new JFrame();
		frameRopaUltracool.setIconImage(Toolkit.getDefaultToolkit().getImage(PantInicio.class.getResource("/imagenes/ImagenEmpresa.jpg")));
		frameRopaUltracool.setTitle("ROPA ULTRA-COOL");
		frameRopaUltracool.setBounds(100, 100, 717, 484);
		frameRopaUltracool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRopaUltracool.getContentPane().setLayout(null);
		layeredPane.setBounds(0, 0, 701, 445);
		frameRopaUltracool.getContentPane().add(layeredPane);
		
		botonBuscar = new JButton("");
		botonBuscar.setIcon(new ImageIcon(PantInicio.class.getResource("/imagenes/buscar.jpg")));
		botonBuscar.setBounds(681, 101, 20, 20);
		layeredPane.add(botonBuscar);
		
		JScrollPane scrollArbolSeleccion = new JScrollPane();
		scrollArbolSeleccion.setBounds(0, 124, 174, 322);
		layeredPane.add(scrollArbolSeleccion);
		
		JTree arbolSeleccion = new JTree();
		arbolSeleccion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollArbolSeleccion.setViewportView(arbolSeleccion);
		arbolSeleccion.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Ropa") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Pantalones");
						node_2 = new DefaultMutableTreeNode("estilo");
							node_2.add(new DefaultMutableTreeNode("corto"));
							node_2.add(new DefaultMutableTreeNode("largo"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("material");
							node_2.add(new DefaultMutableTreeNode("pana"));
							node_2.add(new DefaultMutableTreeNode("vaquero"));
							node_2.add(new DefaultMutableTreeNode("algod\u00F3n"));
							node_2.add(new DefaultMutableTreeNode("lino"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("color");
							node_2.add(new DefaultMutableTreeNode("azul"));
							node_2.add(new DefaultMutableTreeNode("verde"));
							node_2.add(new DefaultMutableTreeNode("rojo"));
							node_2.add(new DefaultMutableTreeNode("negro"));
							node_2.add(new DefaultMutableTreeNode("blanco"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Camisetas");
						node_2 = new DefaultMutableTreeNode("estilo");
							node_2.add(new DefaultMutableTreeNode("manga corta"));
							node_2.add(new DefaultMutableTreeNode("manga larga"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("material");
							node_2.add(new DefaultMutableTreeNode("pana"));
							node_2.add(new DefaultMutableTreeNode("vaquero"));
							node_2.add(new DefaultMutableTreeNode("algod\u00F3n"));
							node_2.add(new DefaultMutableTreeNode("lino"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("color");
							node_2.add(new DefaultMutableTreeNode("azul"));
							node_2.add(new DefaultMutableTreeNode("verde"));
							node_2.add(new DefaultMutableTreeNode("rojo"));
							node_2.add(new DefaultMutableTreeNode("negro"));
							node_2.add(new DefaultMutableTreeNode("blanco"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Chaquetas");
						node_2 = new DefaultMutableTreeNode("estilo");
							node_2.add(new DefaultMutableTreeNode("botones"));
							node_2.add(new DefaultMutableTreeNode("cremallera"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("material");
							node_2.add(new DefaultMutableTreeNode("pana"));
							node_2.add(new DefaultMutableTreeNode("vaquera"));
							node_2.add(new DefaultMutableTreeNode("algod\u00F3n"));
							node_2.add(new DefaultMutableTreeNode("lana"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("color");
							node_2.add(new DefaultMutableTreeNode("azul"));
							node_2.add(new DefaultMutableTreeNode("verde"));
							node_2.add(new DefaultMutableTreeNode("rojo"));
							node_2.add(new DefaultMutableTreeNode("negro"));
							node_2.add(new DefaultMutableTreeNode("blanco"));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		
		JScrollPane scrollCarroCompra = new JScrollPane();
		scrollCarroCompra.setBounds(463, 124, 238, 167);
		layeredPane.add(scrollCarroCompra);
		
		JList listaCarroCompra = new JList();
		listaCarroCompra.setModel(new AbstractListModel() {
			String[] values = new String[] {"CARRO DE LA COMPRA:", "-Camiseta vaquera T42", "-Pantalones vaqueros T40 azules"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaCarroCompra.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollCarroCompra.setViewportView(listaCarroCompra);
		listaCarroCompra.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollHistorial = new JScrollPane();
		scrollHistorial.setBounds(464, 290, 237, 155);
		layeredPane.add(scrollHistorial);
		
		JList listaHistorial = new JList();
		listaHistorial.setModel(new AbstractListModel() {
			String[] values = new String[] {"HISTORIAL:", "-Bragatanga roja licra T.XXL", "-Pantalones vaqueros T.42 rojo"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaHistorial.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollHistorial.setViewportView(listaHistorial);
		listaHistorial.setBackground(new Color(204, 255, 204));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PantInicio.class.getResource("/imagenes/logo.jpg")));
		btnNewButton.setBounds(105, 11, 227, 102);
		layeredPane.add(btnNewButton);
		
		//barra de busqueda
		textField = new JTextField();
		textField.setBounds(464, 101, 214, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(173, 124, 292, 102);
		layeredPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 225, 295, 221);
		layeredPane.add(scrollPane);
		
		JList list = new JList();
		list.setBackground(new Color(255, 215, 0));
		list.setForeground(Color.BLACK);
		scrollPane.setViewportView(list);
	}
}

