package gui;
/**
 * 
 * @author David Mera
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controlador.ControladorUsuario;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;
import logica.Usuario;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class CrearUsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario, campoNombres,campoApellidos,campoCedula,campoTelefono,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JButton botonActualizar;
	private JButton botonCancelar;
	        String[] opcionesTipoU = {"GERENTE", "vendedor"};
                  String[] opcionesEstado = {"ACTIVO", "INACTIVO"};
               
    //Se inicia el objeto ControladorModificarUsuario
    ControladorUsuario controladorUsuario;
    private Login usuarioLogeado;
    private JPasswordField campoConfirmacion;
    private JLabel lblConfirmacion;
    private JPasswordField campoPassword;
    private JSeparator separator;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuarioGUI frame = new CrearUsuarioGUI();
					frame.setVisible(true);
//					frame.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearUsuarioGUI() {
		setResizable(false);
		
		controladorUsuario = new ControladorUsuario();
		
		setTitle("Crear Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 480);
//		setBackground(new Color(0, 153, 255));
		setForeground(new Color(30, 144, 255));
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel Modifique = new JLabel("Crear un usuario");
		Modifique.setBounds(15, 11, 300, 50);
        Modifique.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        contentPane.add(Modifique);
        
        
		//Campo texto del Usuario
		campoUsuario = new JTextField();
		campoUsuario.setCaretColor(new Color(204, 0, 0));
		campoUsuario.setDisabledTextColor(Color.ORANGE);
		campoUsuario.setName("");
		campoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		campoUsuario.setForeground(new Color(0, 0, 0));
//		campoUsuario.setBackground(new Color(204, 255, 255));
		campoUsuario.setBounds(117, 72, 122, 20);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
        //Se establece la etiqueta Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(25, 75, 59, 14);
		contentPane.add(lblUsuario);
                
		//Se establece la etiqueta contrasenna
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(25, 106, 82, 14);
		contentPane.add(lblContrasea);
		
                
                 
        //Se establece la etiqueta nombres
		JLabel lblnombres = new JLabel("Nombres:");
		lblnombres.setBounds(258, 75, 72, 14);
		lblnombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblnombres);
		
        //Campo texto de nombres
		campoNombres = new JTextField();
		campoNombres.setForeground(new Color(0, 0, 0));
//		campoNombres.setBackground(new Color(204, 255, 255));
		campoNombres.setBounds(340, 72, 122, 20);
		contentPane.add(campoNombres);
		campoUsuario.setColumns(10);
		
                
        //Se establece la etiqueta apellidos
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(258, 105, 72, 14);
		contentPane.add(lblApellidos);
		
        //Campo texto de nombres
		campoApellidos = new JTextField();
		campoApellidos.setForeground(new Color(0, 0, 0));
//		campoApellidos.setBackground(new Color(204, 255, 255));
		campoApellidos.setBounds(340, 102, 122, 20);
		contentPane.add(campoApellidos);
		campoApellidos.setColumns(10);
		

		//OpcionesTipoU
        //Se establece el tipo de Usuario 
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(47, 204, 72, 14);
//		contentPane.add(lblTipo);

		//comboBox tipo de usuario 
		tipoUsuario = new JComboBox(opcionesTipoU);
		tipoUsuario.setForeground(new Color(0, 0, 0));
//		tipoUsuario.setBackground(new Color(204, 255, 255));
		tipoUsuario.setBounds(139, 201, 122, 20);
//		contentPane.add(tipoUsuario);
                
        //Se establece el estado  de Usuario 
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(47, 245, 72, 14);
//		contentPane.add(lblEstado);
        
		//comboBox estado de usuario 
		tipoEstado = new JComboBox(opcionesEstado);
		tipoEstado.setForeground(new Color(0, 0, 0));
//		tipoEstado.setBackground(new Color(204, 255, 255));
		tipoEstado.setBounds(139, 243, 122, 20);
//		contentPane.add(tipoEstado);
                
        //Se establece la etiqueta  cedula
		JLabel lblCedula = new JLabel("Cedula :");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(258, 134, 72, 14);
		contentPane.add(lblCedula);

		//Campo texto de cedula
		campoCedula = new JTextField();
		campoCedula.setForeground(new Color(0, 0, 0));
//		campoCedula.setBackground(new Color(204, 255, 255));
		campoCedula.setBounds(340, 132, 122, 20);
		contentPane.add(campoCedula);
		campoCedula.setColumns(10);
		        
        //Se establece la etiqueta  Email
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(37, 240, 72, 14);
		contentPane.add(lblEmail);
        
		//Campo texto de email
		campoEmail = new JTextField();
		campoEmail.setForeground(new Color(0, 0, 0));
//		campoEmail.setBackground(new Color(204, 255, 255));
		campoEmail.setBounds(129, 237, 122, 20);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		
		//Se establece la etiqueta  telefono
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(37, 203, 72, 14);
		contentPane.add(lblTelefono);
		
		//Campo texto de telefono
		campoTelefono = new JTextField();
		campoTelefono.setForeground(new Color(0, 0, 0));
//		campoTelefono.setBackground(new Color(204, 255, 255));
		campoTelefono.setBounds(129, 200, 122, 20);
		contentPane.add(campoTelefono);
		campoTelefono.setColumns(10);
		       
		//Se establece el boton Ingresar
		botonActualizar = new JButton("Crear");
		botonActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonActualizar.setForeground(new Color(255, 255,255));
		botonActualizar.setMnemonic('A');
		botonActualizar.setToolTipText("");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCrearActionPerformed(evt);
			}
		});
		
		botonActualizar.setBackground(new Color(59, 154, 131));
		botonActualizar.setBounds(92, 385, 97, 33);
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
		botonCancelar.setBounds(281, 385, 97, 33);
		contentPane.add(botonCancelar);
		
		//Se establece campo de texto confirmacion
		campoConfirmacion = new JPasswordField();
//		campoConfirmacion.setBackground(new Color(204, 255, 255));
		campoConfirmacion.setBounds(117, 133, 122, 20);
		contentPane.add(campoConfirmacion);
		campoConfirmacion.setColumns(10);
		
		//Se establece etiqueta Confirmacion
		lblConfirmacion = new JLabel("Confirmacion:");
		lblConfirmacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmacion.setBounds(25, 136, 97, 14);
		contentPane.add(lblConfirmacion);
		
		//Se establece campo de texto password
		campoPassword = new JPasswordField();
//		campoPassword.setBackground(new Color(204, 255, 255));
		campoPassword.setToolTipText("minimo 8 caracteres ");
		campoPassword.setBounds(117, 103, 122, 20);
		contentPane.add(campoPassword);
		
		separator = new JSeparator();
		separator.setBounds(29, 165, 412, 2);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("");
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/agregausuario.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(150, -1, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(temp);
		lblNewLabel.setSize(new Dimension(150, 150));
		lblNewLabel.setPreferredSize(new Dimension(150, 150));
		lblNewLabel.setBounds(288, 190, 150, 150);
		contentPane.add(lblNewLabel);
                
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorUsuario.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
			}
	//Metodo que se encarga de validar si el parametro de entrada es un numero
	public static boolean isNumeric(String str) {
			
		return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
	        
	}
			
	//Metodo que se encarga del evento del boton Ingresar
	private void botonCrearActionPerformed (ActionEvent evt ){
		String nick, contra, confirmacion, nombre, apellido, tipo, estado, cedula, email, telefono;
				
		nick = campoUsuario.getText();
		contra = String.valueOf(campoPassword.getPassword());
		confirmacion = String.valueOf(campoConfirmacion.getPassword());
		nombre = campoNombres.getText();
		apellido = campoApellidos.getText();
		cedula = campoCedula.getText();
		email = campoEmail.getText();
//		tipo = (String) tipoUsuario.getSelectedItem();
//		estado = (String) tipoEstado.getSelectedItem();
                tipo = "vendedor";
                estado= "ACTIVO";
		telefono = campoTelefono.getText();
				
				
		if ( campoUsuario.getText().equals("") || (String.valueOf(campoPassword.getPassword())).equals("") ||
				(String.valueOf(campoConfirmacion.getPassword())).equals("") || campoNombres.getText().equals("") || 
				campoApellidos.getText().equals("") || campoCedula.getText().equals("") || 
				campoEmail.getText().equals("") || campoTelefono.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
		}else if ( ( String.valueOf(campoPassword.getPassword()).equals(String.valueOf(campoConfirmacion.getPassword())) )  == false){
				JOptionPane.showMessageDialog(null, "La Contraseña no coincide con la Confirmación, digite de nuevo", "Contraseña Invalida", JOptionPane.ERROR_MESSAGE);
		} else if (isNumeric(cedula)== false) {
			JOptionPane.showMessageDialog(null, "Por favor digite números para la cedula", "Dato_Invalido", JOptionPane.WARNING_MESSAGE);
		} else {
			controladorUsuario.insertarUsuario(nombre, apellido, cedula, nick, contra, telefono, tipo, estado, email);
//			JOptionPane.showMessageDialog(null, "Usuario registrado como " + tipo);
                        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
			dispose();
		}
				
	}
}
