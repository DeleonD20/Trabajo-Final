package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import database.Conexion;
import database.ConexionMySQL;
import database.dbInsert;
import database.usuariosdb;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class Principal extends JFrame {
	private JTable table;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnElimTodo;
	private JButton btnRegresar;
	private JLabel lbliD;
	private JTextField textID;
	private JLabel lblNewLabel;
	protected seleccion seleccion;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(new Rectangle(200, 100, 600, 400));
		setTitle("Manejo de datos");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textID.setText(table.getValueAt(row, 0).toString());
				txtUsuario.setText(table.getValueAt(row, 1).toString());
				txtPassword.setText(table.getValueAt(row, 2).toString());
				txtNombre.setText(table.getValueAt(row, 3).toString());
				txtApellido.setText(table.getValueAt(row, 4).toString());
				txtEmail.setText(table.getValueAt(row, 5).toString());
				

			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"id", "Usuario", "Password", "Nombre", "Apellido", "Email"
			}
		));
		table.setBackground(UIManager.getColor("Table.light"));
		table.setColumnSelectionAllowed(true);
		
		Conexion con = new Conexion();
		Connection conexion = con.getConexion();
		
		String sql = "SELECT * FROM Users";
		Statement st;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Usuario");
		model.addColumn("Password");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Email");
		
		table.setModel(model);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuariosdb modsql = new usuariosdb();
				dbInsert mod = new dbInsert();
				
				if(txtUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un nombre de usuario");
				}
				
				else if(txtPassword.equals(0)) {
					JOptionPane.showMessageDialog(null, "debe insertar una contraseña");
				}
				
				else if(txtNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un nombre");
				}
				
				else if(txtApellido.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un apellido");
				}
				
				else if(txtEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un Email");
				}
				
				else{
					modsql.setUsuario(txtUsuario.getText());
					modsql.setPassword(txtPassword.getText());
					modsql.setNombre(txtNombre.getText());
					modsql.setApellido(txtApellido.getText());
					modsql.setCorreo(txtEmail.getText());					
					
					
					
					if(mod.registrar(modsql)) {
						JOptionPane.showMessageDialog(null,"Registro insertado");
						setVisible(false);
						setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Debe completar todos los campos");
					}
				}
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConexionMySQL con = new ConexionMySQL();
					String id = textID.getText();
					Statement st = conexion.createStatement();
					
					con.ConectarBasedeDatos();
					
					String SQL2 = "DELETE FROM users WHERE ID="+id;

					st.executeUpdate(SQL2);
					JOptionPane.showMessageDialog(null, "El usuario se ha eliminado con exito");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConexionMySQL con = new ConexionMySQL();
					String u = txtUsuario.getText();
					String p = txtPassword.getText();
					String n = txtNombre.getText();
					String a = txtApellido.getText();
					String e1 = txtEmail.getText();
					String id = textID.getText();
					Statement st = conexion.createStatement();
					
					con.ConectarBasedeDatos();
					
					String SQL2 = "UPDATE users SET Usuario='"+u+"',Password='"+p+"',Nombre='"+n+"',Apellido='"+a+"',Email='"+e1+"'WHERE ID="+id;

					st.executeUpdate(SQL2);
					JOptionPane.showMessageDialog(null, "El usuario se ha editado con exito");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				

			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnElimTodo = new JButton("Truncar");
		btnElimTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConexionMySQL con = new ConexionMySQL();
					Statement st = conexion.createStatement();
					
					con.ConectarBasedeDatos();
					
					String SQL2 = "TRUNCATE users";

					st.executeUpdate(SQL2);
					JOptionPane.showMessageDialog(null, "La tabla se ha eliminado con exito");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnElimTodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				seleccion = new seleccion();
				seleccion.setVisible(true);
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lbliD = new JLabel("ID");
		lbliD.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setColumns(10);
		
		lblNewLabel = new JLabel("Para manejar la tabla seleccione la columna");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnRegresar)
									.addPreferredGap(ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblApellido)
											.addGap(18)
											.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNombre)
											.addGap(18)
											.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblUsuario)
											.addGap(18)
											.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblEmail)
											.addGap(18)
											.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPassword)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lbliD)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnInsertar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnEliminar)
										.addComponent(btnElimTodo))
									.addGap(218)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNombre)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnRegresar))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblUsuario)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPassword)
										.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbliD)))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblApellido)
									.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnModificar)
								.addComponent(btnEliminar))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInsertar)
								.addComponent(btnElimTodo))
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtNombre, txtApellido, txtUsuario, txtPassword, txtEmail, textID});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnInsertar, btnEliminar, btnModificar, btnElimTodo});
		getContentPane().setLayout(groupLayout);
		
		String[] dato = new String[6];
		
		try {
			st = conexion.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while (result.next()) {
				dato[0] = result.getString(1);
				dato[1] = result.getString(2);
				dato[2] = result.getString(3);
				dato[3] = result.getString(4);
				dato[4] = result.getString(5);
				dato[5] = result.getString(6);
				model.addRow(dato);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
