/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
/**
 * 

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
import javax.swing.JButton;

import controlador.ControladorProveedor;
import controlador.ControladorUsuario;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;
import logica.Evento;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 *
 * @author usuario
 */
public class ModificarProveedor extends JFrame {
    private JPanel contentPane;
	private JTextField campoNombre,campoCiudad,campoDescripcion,campoDireccion,campoTelefono;
        	private JButton botonActualizar;
	private JButton botonCancelar;
        ControladorProveedor controladorEvento;
           private JLabel Nota;
    private boolean habilitar;
    
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProveedor frame = new ModificarProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
        public ModificarProveedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarProveedor.class.getResource("/imagen/ruedas-dentadas-icono-de-lupa.png")));
		setResizable(false);
		
		controladorEvento = new ControladorProveedor();
		habilitar = false;
		
		setTitle("Modificar Datos Del provedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 204, 51));
		setForeground(new Color(30, 144, 255));
		setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Modifique = new JLabel("Modificar los datos del proveedor");
		Modifique.setBounds(46, 11, 274, 33);
        Modifique.setFont(new Font("Serif", Font.BOLD, 17));
                    
                
        contentPane.add(Modifique);
               
        
		//Campo texto del Usuario
		campoNombre = new JTextField();
		campoNombre.setForeground(new Color(0, 0, 0));
//		campoUsuario.setBackground(new Color(255, 215, 0));
		campoNombre.setBounds(160, 55, 122, 20);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
		
        //Se establece la etiqueta Usuario
		JLabel lblNombre = new JLabel("Nombre Proveedor:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(40, 57, 140, 14);
		contentPane.add(lblNombre);
                
               
                        
                        
                        
		//Se establece la etiqueta contrasenna
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiudad.setBounds(21, 183, 82, 14);
		contentPane.add(lblCiudad);
		
                
                
                
                campoCiudad = new JTextField();
//		campoNombres.setEditable(true);
		campoCiudad.setForeground(new Color(0, 0, 0));
//		campoNombres.setBackground(new Color(255, 215, 0));
			campoCiudad.setBounds(113, 180, 122, 20);
		contentPane.add(campoCiudad);
		campoCiudad.setColumns(10);
	
	      
                	
               
        //Se establece la etiqueta nombres
		JLabel lbldescripcion = new JLabel("Descripcion:");
		lbldescripcion.setBounds(21, 210, 78, 25);
		lbldescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lbldescripcion);
		
        //Campo texto de nombres
		campoDescripcion = new JTextField();
//		campoNombres.setEditable(true);
		campoDescripcion.setForeground(new Color(0, 0, 0));
//		campoNombres.setBackground(new Color(255, 215, 0));
		campoDescripcion.setBounds(113, 208, 122, 20);
		contentPane.add(campoDescripcion);
		
                   
        //Se establece la etiqueta apellidos
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(21, 240, 72, 14);
		contentPane.add(lblDireccion);
		
        //Campo texto de nombres
		campoDireccion = new JTextField();
//		campoApellidos.setEditable(false);
		campoDireccion.setForeground(new Color(0, 0, 0));
//		campoApellidos.setBackground(new Color(255, 215, 0));
		campoDireccion.setBounds(113, 238, 122, 20);
		contentPane.add(campoDireccion);
		campoDireccion.setColumns(10);
		

		//OpcionesTipoU
        //Se establece el tipo de Usuario 
		campoTelefono = new JTextField();
//		campoTelefono.setBackground(new Color(255, 215, 0));
		campoTelefono.setBounds(113, 268, 122, 20);
		contentPane.add(campoTelefono);
		campoTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(20, 268, 83, 20);
		contentPane.add(lblTelefono);
		
//	
                
       
		       
		//Se establece el boton Ingresar
		botonActualizar = new JButton("Actualizar");
		botonActualizar.setEnabled(habilitar);
                botonActualizar.setBackground(new Color(59, 154, 131));
		botonActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botonActualizar.setForeground(new Color(255, 255, 255));
		botonActualizar.setMnemonic('A');
		botonActualizar.setToolTipText("");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonActualizarActionPerformed(evt);
			}
		});
		
//		botonActualizar.setBackground(new Color(0, 0, 0));
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
		botonCancelar.setBackground(new Color(0, 0, 0));
		botonCancelar.setBounds(163, 389, 97, 33);
                botonCancelar.setBackground(new Color(186, 0, 22));
		contentPane.add(botonCancelar);
		
		JButton btnBuscar = new JButton("Consultar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonConsultarActionPerformed(evt);
			}
		});
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setMnemonic('o');
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBounds(310, 48, 97, 33);
		contentPane.add(btnBuscar);
		
		Nota = new JLabel("Nota: Para modificar un proveedor, se debe primero consultar para verificar \r\nque este registrado.");
		Nota.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Nota.setForeground(Color.BLUE);
		Nota.setBounds(21, 81, 400, 33);
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
		lblimagen.setBounds(264, 149, 149, 167);
//		contentPane.add(lblimagen);
		
		
		
	}
        private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorEvento.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
	}
	
	//Metodo que se encargar del evento del boton consultar
	private void botonConsultarActionPerformed( ActionEvent evt ){
		String nombre;
		nombre = campoNombre.getText();
		
		Evento u;
		u = new Evento();
		u = controladorEvento.consultarProveedor(nombre);
		if ( u.getNombre() == null  ) {
			JOptionPane.showMessageDialog(null, "El proovedor no se encuentra registrado en el Sistema", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
                    campoNombre.setEditable(false);
                    botonActualizar.setEnabled(false);
			campoCiudad.setText(u.getCiudad());
			campoDescripcion.setText(u.getDescripcion());
			campoDireccion.setText(u.getDireccion());
			campoTelefono.setText(u.getTelefono());
			
			habilitar = true;
			botonActualizar.setEnabled(habilitar);
		}
	}
	
	
	//Metodo que se encarga del evento del boton Ingresar
	private void botonActualizarActionPerformed (ActionEvent evt ){
		String nombre, ciudad  , descripcion, direccion, telefono;
			
		nombre = campoNombre.getText();
                 
		ciudad = campoCiudad.getText();
		descripcion = campoDescripcion.getText();
		direccion = campoDireccion.getText();
		telefono = campoTelefono.getText();
		
		
		int numFilas = controladorEvento.ModificarProveedor( nombre, ciudad,descripcion, direccion, telefono);
		
		System.out.println ("Filas "+ numFilas);
		
		if ( campoNombre.getText().equals("") || campoCiudad.getText().equals("") || campoDescripcion.getText().equals("") || 
				campoDireccion.getText().equals("") || 	campoTelefono.getText().equals("") )
		{
				JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
				} else if ( numFilas == 1 ){
					JOptionPane.showMessageDialog(null, "El proveedor se ha modificado!", "Modificaci�n Exitosa", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
						JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar el proveedor en el Sistema", "Fallo en la Modificaci�n", JOptionPane.ERROR_MESSAGE);
					}
			}
        
}
