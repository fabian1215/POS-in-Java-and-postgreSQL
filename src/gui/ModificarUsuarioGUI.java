package gui;
/**
 * 
 * @author Fabian Ovalle
 * @author juan diego
 *
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controlador.ControladorUsuario;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;
import logica.Usuario;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ModificarUsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario,campoNombres,campoApellidos,campoCedula,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JPasswordField campoPassword;
	private JButton botonActualizar;
	private JButton botonCancelar;
//	        String[] opcionesTipoU = {"vendedor", "administrador"};
                  String[] opcionesEstado = {"ACTIVO", "INACTIVO"};
	
	//Se inicia el objeto ControladorModificarUsuario
    ControladorUsuario controladorUsuario;
    private JLabel Nota;
    private boolean habilitar;
    private JTextField campoTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuarioGUI frame = new ModificarUsuarioGUI();
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
	public ModificarUsuarioGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarUsuarioGUI.class.getResource("/imagen/ruedas-dentadas-icono-de-lupa.png")));
		setResizable(false);
		
		controladorUsuario = new ControladorUsuario();
		habilitar = false;
		
		setTitle("Modificar Datos De Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 204, 51));
		setForeground(new Color(30, 144, 255));
		setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Modifique = new JLabel("Modificar los datos del usuario");
		Modifique.setBounds(46, 11, 274, 33);
        Modifique.setFont(new Font("Serif", Font.BOLD, 17));
                    
                
        contentPane.add(Modifique);
               
                
		//Campo texto del Usuario
		campoUsuario = new JTextField();
//		campoUsuario.setEditable(false);
		campoUsuario.setForeground(new Color(0, 0, 0));
//		campoUsuario.setBackground(new Color(255, 215, 0));
		campoUsuario.setBounds(113, 149, 122, 20);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
        //Se establece la etiqueta Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(21, 152, 59, 14);
		contentPane.add(lblUsuario);
                
		//Se establece la etiqueta contrasenna
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(21, 183, 82, 14);
		contentPane.add(lblContrasea);
		
		//Se establece el campo de texto Contrasenna
		campoPassword = new JPasswordField();
//		campoPassword.setBackground(new Color(255, 215, 0));
		campoPassword.setBounds(113, 180, 122, 20);
		contentPane.add(campoPassword);
		
                
                 
        //Se establece la etiqueta nombres
		JLabel lblnombres = new JLabel("Nombres:");
		lblnombres.setBounds(21, 210, 72, 14);
		lblnombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblnombres);
		
        //Campo texto de nombres
		campoNombres = new JTextField();
//		campoNombres.setEditable(true);
		campoNombres.setForeground(new Color(0, 0, 0));
//		campoNombres.setBackground(new Color(255, 215, 0));
		campoNombres.setBounds(113, 208, 122, 20);
		contentPane.add(campoNombres);
		campoUsuario.setColumns(10);
		
                
        //Se establece la etiqueta apellidos
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(21, 240, 72, 14);
		contentPane.add(lblApellidos);
		
        //Campo texto de nombres
		campoApellidos = new JTextField();
//		campoApellidos.setEditable(false);
		campoApellidos.setForeground(new Color(0, 0, 0));
//		campoApellidos.setBackground(new Color(255, 215, 0));
		campoApellidos.setBounds(113, 238, 122, 20);
		contentPane.add(campoApellidos);
		campoApellidos.setColumns(10);
		

		//OpcionesTipoU
        //Se establece el tipo de Usuario 
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(21, 303, 72, 14);
//		contentPane.add(lblTipo);

		//comboBox tipo de usuario 
//		tipoUsuario = new JComboBox(opcionesTipoU);
//		tipoUsuario.setForeground(new Color(0, 0, 0));
////		tipoUsuario.setBackground(new Color(204, 255, 255));
//		tipoUsuario.setBounds(113, 300, 122, 20);
////		contentPane.add(tipoUsuario);
                
        //Se establece el estado  de Usuario 
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(21, 331, 72, 14);
		contentPane.add(lblEstado);
        
		//comboBox estado de usuario 
		tipoEstado = new JComboBox(opcionesEstado);
		tipoEstado.setForeground(new Color(0, 0, 0));
//		tipoEstado.setBackground(new Color(204, 255, 255));
		tipoEstado.setBounds(113, 329, 122, 20);
		contentPane.add(tipoEstado);
                
        //Se establece la etiqueta  cedula
		JLabel lblCedula = new JLabel("Cedula :");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(46, 57, 72, 14);
		contentPane.add(lblCedula);

		//Campo texto de cedula
		campoCedula = new JTextField();
		campoCedula.setForeground(new Color(0, 0, 0));
//		campoCedula.setBackground(new Color(255, 215, 0));
		campoCedula.setBounds(119, 55, 122, 20);
		contentPane.add(campoCedula);
		campoCedula.setColumns(10);
		        
        //Se establece la etiqueta  Email
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(21, 360, 72, 14);
		contentPane.add(lblEmail);
        
		//Campo texto de nombres
		campoEmail = new JTextField();
		campoEmail.setForeground(new Color(0, 0, 0));
//		campoEmail.setBackground(new Color(255, 215, 0));
		campoEmail.setBounds(89, 358, 171, 20);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		       
		//Se establece el boton Ingresar
		botonActualizar = new JButton("Actualizar");
		botonActualizar.setEnabled(habilitar);
		botonActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonActualizar.setForeground(new Color(255, 255, 255));
		botonActualizar.setMnemonic('A');
		botonActualizar.setToolTipText("");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonActualizarActionPerformed(evt);
			}
		});
		
		botonActualizar.setBackground(new Color(59, 154, 131));
		botonActualizar.setBounds(56, 389, 97, 33);
		contentPane.add(botonActualizar);
		
		//Se establece el boton Cancelar
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		
		botonCancelar.setMnemonic('C');
		botonCancelar.setForeground(new Color(255, 255, 255));
		botonCancelar.setBackground(new Color(186, 0, 22));
		botonCancelar.setBounds(163, 389, 97, 33);
		contentPane.add(botonCancelar);
		
		JButton btnBuscar = new JButton("Consultar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonConsultarActionPerformed(evt);
			}
		});
                
                
                JButton btnBuscar2 = new JButton("Consultar");
		btnBuscar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonConsultar2ActionPerformed(evt);
			}
		});
                
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setMnemonic('o');
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBounds(294, 48, 97, 33);
		contentPane.add(btnBuscar);
                
                
               btnBuscar2.setBackground(Color.BLACK);
		btnBuscar2.setMnemonic('o');
		btnBuscar2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar2.setForeground(Color.WHITE);
		btnBuscar2.setBounds(294, 140, 97, 33);
		contentPane.add(btnBuscar2); 
                
                
		
		Nota = new JLabel("<html> Nota: Para modificar un Usuario, se debe primero    consultar por la cedula o el nombre  <br> para verificar que este registrado </html>  " );
             
		Nota.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Nota.setForeground(Color.BLUE);
		Nota.setBounds(21, 81, 385, 33);
		contentPane.add(Nota);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 125, 375, 2);
		contentPane.add(separator);
		
		JLabel lblimagen = new JLabel();
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/ruedas-dentadas-c-rculo-rojo-icono.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(150, -1, Image.SCALE_DEFAULT));
		//lblimagen.setIcon(new ImageIcon(ModificarUsuarioGUI.class.getResource("/imagen/ruedas-dentadas-c-rculo-rojo-icono.png")));
		lblimagen.setIcon(temp);
		lblimagen.setSize(new Dimension(150, 150));
		lblimagen.setPreferredSize(new Dimension(150, 150));
		lblimagen.setBounds(264, 180, 149, 167);
//		contentPane.add(lblimagen);
		
		campoTelefono = new JTextField();
//		campoTelefono.setBackground(new Color(255, 215, 0));
		campoTelefono.setBounds(113, 269, 122, 20);
		contentPane.add(campoTelefono);
		campoTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(20, 268, 83, 20);
		contentPane.add(lblTelefono);
		
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorUsuario.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
	}
	
	//Metodo que se encargar del evento del boton consultar
	private void botonConsultarActionPerformed( ActionEvent evt ){
		String cedula;
		cedula = campoCedula.getText();
		
		Usuario u;
		u = new Usuario();
		u = controladorUsuario.consultarUsuario(cedula);
		if ( u.getNombre() == null  ) {
			JOptionPane.showMessageDialog(null, "El Usuario no se encuentra registrado en el Sistema", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
			botonActualizar.setEnabled(false);
		} else {
                    campoUsuario.setEditable(false);
                    campoCedula.setEditable(false);
			campoNombres.setText(u.getNombre());
			campoApellidos.setText(u.getApellido());
			campoPassword.setText(u.getContrasenna());
			campoUsuario.setText(u.getNick());
			campoTelefono.setText(u.getTelefono());
			campoEmail.setText(u.getEmail());
//			tipoUsuario.setSelectedItem(u.getTipo());
			tipoEstado.setSelectedItem(u.getEstado());
			habilitar = true;
			botonActualizar.setEnabled(habilitar);
		}
	}
	
        
        
        //Metodo que se encargar del evento del boton consultar
	private void botonConsultar2ActionPerformed( ActionEvent evt ){
		String nick;
		nick = campoUsuario.getText();
		
		Usuario u;
		u = new Usuario();
		u = controladorUsuario.usuarioPorNombre(nick);
		if ( u.getNombre() == null  ) {
			JOptionPane.showMessageDialog(null, "El Usuario no se encuentra registrado en el Sistema", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
			botonActualizar.setEnabled(false);
		} else {
                    campoUsuario.setEditable(false);
                    campoCedula.setEditable(false);
			campoNombres.setText(u.getNombre());
			campoApellidos.setText(u.getApellido());
			campoPassword.setText(u.getContrasenna());
//			campoUsuario.setText(u.getNick());
			campoTelefono.setText(u.getTelefono());
			campoEmail.setText(u.getEmail());
//			tipoUsuario.setSelectedItem(u.getTipo());
			tipoEstado.setSelectedItem(u.getEstado());
                        campoCedula.setText(u.getCedula());
			habilitar = true;
			botonActualizar.setEnabled(habilitar);
		}
	}
        
        
        
        
	
	//Metodo que se encarga del evento del boton Ingresar
	private void botonActualizarActionPerformed (ActionEvent evt ){
		String nombre, apellido, cedula, contra, telefono, estado, email;
			
		nombre = campoNombres.getText();
		apellido = campoApellidos.getText();
		cedula = campoCedula.getText();
		contra = String.valueOf(campoPassword.getPassword());
		telefono = campoTelefono.getText();
//		tipo = (String) tipoUsuario.getSelectedItem();
		estado = (String) tipoEstado.getSelectedItem();
		email = campoEmail.getText();
		
		int numFilas = controladorUsuario.modificarUsuario( nombre, apellido,cedula, contra, telefono, estado, email);
		
		System.out.println ("Filas "+ numFilas);
		
		if ( campoUsuario.getText().equals("") || (String.valueOf(campoPassword.getPassword())).equals("") ||
				campoNombres.getText().equals("") || campoApellidos.getText().equals("") || 
				campoCedula.getText().equals("") || campoEmail.getText().equals("") || 
				campoTelefono.getText().equals("") )
		{
				JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
				} else if ( numFilas == 1 ){
					JOptionPane.showMessageDialog(null, "El Usuario se ha modificado!", "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
						JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar el Usuario en el Sistema", "Fallo en la Modificacion", JOptionPane.ERROR_MESSAGE);
					}
			}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
