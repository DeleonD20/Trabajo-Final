package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import database.Conexion;

import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Objetos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	protected RgObjetos RgObjetos;
	protected seleccion Back;
	private JButton btnNewButton;
	protected Objetos Objetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Objetos frame = new Objetos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Objetos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RgObjetos = new RgObjetos();
				RgObjetos.setVisible(true);
				
			}
		});
		
		table = new JTable();
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAgregar, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAgregar, -6, SpringLayout.NORTH, table);
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, 106, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, 9, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, table, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, table, -9, SpringLayout.EAST, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(btnAgregar);
		contentPane.add(table);
		
		Conexion con = new Conexion();
		Connection conexion = con.getConexion();
		String sql = "SELECT * FROM objetos";
		
		Statement st;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Marca");
		model.addColumn("Categoria");
		model.addColumn("Precio");
		model.addColumn("Cantidad");
		
		table.setModel(model);
		String[] dato = new String[5];
		
		try {
			st = conexion.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while (result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				dato[3]=result.getString(4);
				dato[4]=result.getString(5);
				model.addRow(dato);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 0, SpringLayout.NORTH, btnAgregar);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 9, SpringLayout.EAST, btnAgregar);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 0, SpringLayout.NORTH, btnAgregar);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 6, SpringLayout.EAST, btnModificar);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("volver");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVolver, 0, SpringLayout.EAST, btnAgregar);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Back = new seleccion();
				Back.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVolver, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVolver, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnVolver, 16, SpringLayout.NORTH, contentPane);
		contentPane.add(btnVolver);
		
		btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Objetos = new Objetos();
				Objetos.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 11, SpringLayout.SOUTH, btnVolver);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnVolver);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 27, SpringLayout.SOUTH, btnVolver);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnAgregar);
		contentPane.add(btnNewButton);
	
		
		

	}
	
}

