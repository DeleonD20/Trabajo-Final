package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Hash;
import database.dbInsert;
import database.usuariosdb;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtRgUser;
	private JPasswordField txtRgPassword2;
	private JPasswordField txtRgPassword;
	protected Login LoginRg;
	private JTextField txtNombre;
	private JTextField txtCorreoElectronico;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel TtlRegister = new JLabel("Registrarse");
		TtlRegister.setHorizontalAlignment(SwingConstants.CENTER);
		TtlRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel TtlRgUser = new JLabel("Usuario");
		TtlRgUser.setHorizontalAlignment(SwingConstants.CENTER);
		TtlRgUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtRgUser = new JTextField();
		txtRgUser.setColumns(10);
		
		JLabel TtlRgPassword = new JLabel("Contrase\u00F1a");
		TtlRgPassword.setHorizontalAlignment(SwingConstants.CENTER);
		TtlRgPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel TtlRgPassword2 = new JLabel("Repetir contrase\u00F1a");
		TtlRgPassword2.setFont(new Font("Tahoma", Font.BOLD, 14));
		TtlRgPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRgRegister = new JButton("Registrarse");
		btnRgRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			usuariosdb modsql = new usuariosdb();
			dbInsert mod = new dbInsert();
			
			String pass = new String(txtRgPassword.getPassword());
			String pass2 = new String(txtRgPassword2.getPassword());
			
			if(txtRgUser.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "debe insertar un nombre de usuario");
			}
			
			else if(txtRgPassword.equals(0)) {
				JOptionPane.showMessageDialog(null, "debe insertar una contraseña");
			}
			
			else if(txtNombre.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "debe insertar un nombre");
			}
			
			else if(txtApellido.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "debe insertar un apellido");
			}
			
			else if(txtCorreoElectronico.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "debe insertar un Email");
			}
			
			else if(pass.equals(pass2)) {
				modsql.setUsuario(txtRgUser.getText());
				modsql.setPassword(pass);
				modsql.setNombre(txtNombre.getText());
				modsql.setApellido(txtApellido.getText());
				modsql.setCorreo(txtCorreoElectronico.getText());
				setVisible(false);
				Login Login = new Login();
				Login.setVisible(true);
				
				
				if(mod.registrar(modsql)) {
					JOptionPane.showMessageDialog(null,"Registro completado");
				}else {
					JOptionPane.showMessageDialog(null,"Debe completar todos los campos");
				}
				
			} else {
				JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
			}
			}
		});
		btnRgRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtRgPassword2 = new JPasswordField();
		
		txtRgPassword = new JPasswordField();
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setColumns(10);
		
		JLabel TtlCorreoElectronico = new JLabel("Correo electronico");
		TtlCorreoElectronico.setHorizontalAlignment(SwingConstants.CENTER);
		TtlCorreoElectronico.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel TtlApellido = new JLabel("Apellido");
		TtlApellido.setHorizontalAlignment(SwingConstants.CENTER);
		TtlApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel TtlNombre = new JLabel("Nombre");
		TtlNombre.setHorizontalAlignment(SwingConstants.CENTER);
		TtlNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginRg = new Login();
				LoginRg.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addComponent(TtlRegister, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addComponent(TtlRgUser, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(txtRgUser, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addComponent(TtlNombre, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addComponent(TtlApellido, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addComponent(TtlCorreoElectronico, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(txtCorreoElectronico, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addComponent(TtlRgPassword, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(txtRgPassword, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addComponent(TtlRgPassword2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(txtRgPassword2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(btnRgRegister, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(TtlRegister, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(TtlRgUser, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtRgUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(TtlNombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(TtlApellido, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(TtlCorreoElectronico, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(txtCorreoElectronico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(TtlRgPassword, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtRgPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(TtlRgPassword2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtRgPassword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnRgRegister, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
