package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.dbInsert;
import database.Objetosdb;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RgObjetos extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textCategoria;
	private JTextField textPrecio;
	private JTextField textCantidad;
	private JButton Aceptar;
	private JButton btnCancelar;
	protected Objetos Objetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RgObjetos frame = new RgObjetos();
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
	public RgObjetos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		
		Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Objetosdb modsql = new Objetosdb();
				dbInsert mod = new dbInsert();
				
				if(textNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un nombre de usuario");
				}
				
				else if(textMarca.equals(0)) {
					JOptionPane.showMessageDialog(null, "debe insertar una contraseña");
				}
				
				else if(textCategoria.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un nombre");
				}
				
				else if(textPrecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un apellido");
				}
				
				else if(textCantidad.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe insertar un Email");
				}
				
				else {
					modsql.setNombre(textNombre.getText());
					modsql.setMarca(textMarca.getText());
					modsql.setCategoria(textCategoria.getText());
					modsql.setPrecio(textPrecio.getText());
					modsql.setCantidad(textCantidad.getText());
					setVisible(false);
					Objetos Objetos = new Objetos();
					Objetos.setVisible(true);

					
					if(mod.registrar2(modsql)) {
						JOptionPane.showMessageDialog(null,"Registro completado");
					}else {
						JOptionPane.showMessageDialog(null,"Debe completar todos los campos");
					}
					
			
	
				}
			
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Objetos = new Objetos();
				Objetos.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCategoria, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(textMarca, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Aceptar)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNombre)
							.addGap(7)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Aceptar)
						.addComponent(btnCancelar)))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {lblNombre, lblMarca, lblCategoria, lblPrecio, lblCantidad});
		contentPane.setLayout(gl_contentPane);
	}
}
