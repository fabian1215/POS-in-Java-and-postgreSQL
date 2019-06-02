package gui;
/**
 *@author juan diego ordonnez
 */

import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Image;
import controlador.ControladorLogin;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logica.Login;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.*;


public class LoginGUI extends JFrame {

	/**
	 * 
	 */
    public Image background;
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private JButton botonIngresar;
	private JButton botonCancelar;
	
	ControladorLogin controladorLogin;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Constructor
	 */
        
           //fondo de jframe
//	public void paintComponent(Graphics g) {
// 
//		/* Obtenemos el tamaño del panel para hacer que se ajuste a este
//		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
//		int width = this.getSize().width;
//		int height = this.getSize().height;
// 
//		// Mandamos que pinte la imagen en el panel
//		if (this.background != null) {
//			g.drawImage(this.background, 0, 0, width, height, null);
//		}
// 
//		contentPane.paintComponent(g);
//	}
// 
//	// Metodo donde le pasaremos la dirección de la imagen a cargar.
//	public void setBackground(String imagePath) {
//		
//		// Construimos la imagen y se la asignamos al atributo background.
//		contentPane.setOpaque(false);
//		contentPane.background = new ImageIcon(imagePath).getImage();
//		repaint();
//	}
	public  LoginGUI()  {
		
		controladorLogin = new ControladorLogin();
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/imagen/favicon2.jpg")));
		setTitle("ACCESO AL SISTEMA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,612,527);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 153, 255));
//		contentPane.setForeground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
                
		contentPane.setLayout(null);
             
                JLabel background1 = new JLabel(new ImageIcon("src/imagen/fondofinal2.png"));

                background1.setBounds(0, 0, 612,527);
              
 
		int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
                
		//Campo texto del Usuario
		campoUsuario = new JTextField("");
		campoUsuario.setSelectionColor(new Color(124, 252, 0));
	campoUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		campoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		//PromptSupport.setPrompt();
//		campoUsuario.setForeground(Color.WHITE);
//		campoUsuario.setBackground(new Color(0, 0, 0));
		campoUsuario.setBounds(148, 255, 286, 45);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
				
		//Se establece la etiqueta Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(74, 111, 83, 14);
//		contentPane.add(lblUsuario);
				
		//Se establece la etiqueta contrasenna
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(74, 141, 95, 14);
//		contentPane.add(lblContrasea);
//				
		//Se establece el campo de texto Contrasenna
		campoPassword = new JPasswordField();
		campoPassword.setSelectionColor(new Color(124, 252, 0));
                campoPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		campoPassword.setCaretColor(new Color(255, 255, 0));
		campoPassword.setDisabledTextColor(new Color(128, 128, 128));
//		campoPassword.setForeground(Color.WHITE);
//		campoPassword.setBackground(new Color(0, 0, 0));
                
                
                
		campoPassword.setBounds(148, 311, 286, 45);
		contentPane.add(campoPassword);
				
		//Se establece el boton Ingresar
		botonIngresar = new JButton();
		botonIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonIngresar.setForeground(new Color(255, 255, 255));
		botonIngresar.setMnemonic('I');
		botonIngresar.setToolTipText("");
                botonIngresar.setOpaque(false);
botonIngresar.setContentAreaFilled(false);
//botonIngresar.setBorderPainted(false);
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonIngresarActionPerformed(evt);
			}
		});
		botonIngresar.setBackground(new Color(0, 0, 0));
		botonIngresar.setBounds(142, 365,326, 47);
               
              
		contentPane.add(botonIngresar);
				
		//Se establece el boton Cancelar
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		botonCancelar.setMnemonic('C');
		botonCancelar.setForeground(new Color(255, 255, 255));
		botonCancelar.setBackground(new Color(0, 0, 0));
		botonCancelar.setBounds(204, 190, 97, 33);
//		contentPane.add(botonCancelar);
				
		lblNewLabel = new JLabel("New label");
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/admin-button-icon-md.png"));
		//ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/images.jpg"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(100, -1, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(temp);
		lblNewLabel.setBounds(155, 5, 170, 134);
		lblNewLabel.setSize(new Dimension(100, 100));
		lblNewLabel.setPreferredSize(new Dimension(100, 100));
//		contentPane.add(lblNewLabel);
                contentPane.add(background1);
	}
	
	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
	
        
     
        
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorLogin.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		//dispose();
		System.exit(0);
	}
	
	//Metodo que se encarga del evento del boton Ingresar
	private void botonIngresarActionPerformed (ActionEvent evt ){
		String nick, contra, tipo;
		
		nick = campoUsuario.getText();
		contra = String.valueOf(campoPassword.getPassword());
		
		Login l;
		
		l = controladorLogin.consultarLogin(nick, contra);
		tipo = l.getTipo();
		if ( campoUsuario.getText().equals("") || (String.valueOf(campoPassword.getPassword())).equals("") ){
			JOptionPane.showMessageDialog(null, "Por favor llene los campos", "Campos_Vacios", JOptionPane.WARNING_MESSAGE);
		} else if ( l.equals(null) ){
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña inconrrecta");
		} else if ( (tipo!=null) && tipo.equals("administrador") ){//Codigo para abrir la aplicacion dependiendo del perfil del usuario
			
				JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "Login Exitoso - Administrador", JOptionPane.INFORMATION_MESSAGE);
				/*PanelAdministradorGUI aplicacion1 = new PanelAdministradorGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();*/
				
				PanelAdministradorGUI aplicacion1 = new PanelAdministradorGUI();
				aplicacion1.setVisible(true);
				aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
				
		} else if ( (tipo!=null) && tipo.equals("vendedor") ){
				JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "Login Exitoso - Vendedor", JOptionPane.INFORMATION_MESSAGE);
                                
                                
                                RegistrarVentaGUI aplicacion2 = new RegistrarVentaGUI();
				aplicacion2.setVisible(true);
				aplicacion2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
				/*PanelGerenteGUI aplicacion1 = new PanelGerenteGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();*/
				
////				PanelGerenteGUI aplicacion1 = new PanelGerenteGUI();
//				aplicacion1.setVisible(true);
//				aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
				
		} else if ((tipo!=null) && tipo.equals("vendedor")){
			JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
				/*PanelOperadorGUI aplicacion1 = new PanelOperadorGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();*/
				
//				PanelOperadorGUI aplicacion1 = new PanelOperadorGUI();
//				aplicacion1.setVisible(true);
//				aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
				
			} else if ( (tipo==null) ){
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña inconrrecta", "Datos_Invalidos", JOptionPane.ERROR_MESSAGE);
			}
		}

}