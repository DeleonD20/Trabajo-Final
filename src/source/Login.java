package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.dbInsert;
import database.usuariosdb;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import database.Conexion.*;
import database.ConexionMySQL;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField TxtPassword;
	protected Register RegistroUser;
	protected seleccion Principalwnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Ttllogin = new JLabel("Iniciar Seccion");
		Ttllogin.setHorizontalAlignment(SwingConstants.CENTER);
		Ttllogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ttllogin.setBounds(111, 11, 212, 23);
		contentPane.add(Ttllogin);
		
		JLabel TtlUser = new JLabel("Usuario");
		TtlUser.setHorizontalAlignment(SwingConstants.CENTER);
		TtlUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		TtlUser.setBounds(178, 63, 78, 14);
		contentPane.add(TtlUser);
		
		JLabel TtPassword = new JLabel("Contrase\u00F1a");
		TtPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		TtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		TtPassword.setBounds(162, 119, 110, 14);
		contentPane.add(TtPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(142, 88, 150, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		TxtPassword = new JPasswordField();
		TxtPassword.setBounds(142, 144, 150, 20);
		contentPane.add(TxtPassword);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConexionMySQL con = new ConexionMySQL();
					String u = txtUser.getText();
					String p = TxtPassword.getText();
					con.ConectarBasedeDatos();
					
					String SQL = "SELECT Usuario, Password FROM Users WHERE Usuario='"+u+"'AND Password='"+p+"'";
					con.resultado = con.sentencia.executeQuery(SQL);
					if(con.resultado.next()) {
						setVisible(false);
						Principalwnd = new seleccion();
						Principalwnd.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "El usuario o contraseña esta incorrecto");
					}
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEntrar.setBounds(162, 175, 110, 37);
		contentPane.add(btnEntrar);
		
		JLabel TtlRegister = new JLabel("No tienes cuenta?");
		TtlRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TtlRegister.setBounds(312, 202, 100, 14);
		contentPane.add(TtlRegister);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				RegistroUser = new Register();
				RegistroUser.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(307, 227, 110, 23);
		contentPane.add(btnNewButton_1);
	}
}
