package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorProveedor;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;

public class CrearEventoGUI extends JFrame {
    	private static final long serialVersionUID = 1L;
        
private JPanel contentPane;

	ControladorProveedor controladorProveedor;

	
	private JTextField campoNombre;
        private JTextField campoCiudad;
	private JTextField campoDescripcion;
	private JTextField campoDireccion;
	private JTextField campoTelefono;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearEventoGUI frame = new CrearEventoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

        //Se inicia el objeto ControladorModificarSede

	public CrearEventoGUI() {
	controladorProveedor = new ControladorProveedor();
                setResizable(false);
                setTitle("Crear Proveedor:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNonbre = new JLabel("Nombre :");
		lblNonbre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNonbre.setBounds(53, 57, 101, 14);
		contentPane.add(lblNonbre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(186, 55, 161, 20);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
                
              
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiudad.setBounds(53, 82, 101, 14);
		contentPane.add(lblCiudad);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescripcion.setBounds(53, 111, 101, 14);
		contentPane.add(lblDescripcion);
		
		  JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(53, 136, 101, 14);
		contentPane.add(lblDireccion);
		
                JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(53, 160, 101, 14);
		contentPane.add(lblTelefono);
                
         
		campoCiudad = new JTextField();
		campoCiudad.setBounds(186, 81, 161, 20);
		contentPane.add(campoCiudad);
		campoCiudad.setColumns(10);
		
		campoDescripcion = new JTextField();
		campoDescripcion.setBounds(186, 108, 161, 20);
		contentPane.add(campoDescripcion);
		campoDescripcion.setColumns(10);
		
		campoDireccion = new JTextField();
		campoDireccion.setBounds(186, 134, 161, 20);
		contentPane.add(campoDireccion);
		campoDireccion.setColumns(10);
		
                 campoTelefono = new JTextField();
		campoTelefono.setBounds(186, 160, 161, 20);
		contentPane.add(campoTelefono);
		campoTelefono.setColumns(10);
                
                
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonGuardarActionPerformed(evt);
			}
		});
		
		btnGuardar.setBackground(new Color(59, 154, 131));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setMnemonic('G');
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBounds(104, 200, 92, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		
		btnCancelar.setBackground(new Color(186, 0, 22));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setMnemonic('C');
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBounds(220, 200, 92, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblEvento = new JLabel("Proveedor");
		lblEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvento.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEvento.setBounds(108, 11, 191, 35);
		contentPane.add(lblEvento);
	
                
                
	}
        
        private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorProveedor.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
	}
	
  
     
        
       private void botonGuardarActionPerformed (ActionEvent evt ){
			String nombre, ciudad, descripcion, direccion,telefono;
				int numFilas=0;
			nombre = campoNombre.getText();
			ciudad = campoCiudad.getText();
			descripcion = campoDescripcion.getText();
			direccion = campoDireccion.getText();
                        telefono = campoTelefono.getText();
				
			if (nombre.isEmpty() || ciudad.isEmpty() || descripcion.isEmpty() || direccion.isEmpty()|| telefono.isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor recuerde llenar todos los campos", "Campos_Vacios", JOptionPane.WARNING_MESSAGE);
			
			}    else {
				controladorProveedor.insertarEvento(nombre, ciudad, descripcion, direccion,telefono);
                JOptionPane.showMessageDialog(null, "Se creo el Proveedor correctamente", "Proceso_Exitoso", JOptionPane.PLAIN_MESSAGE);
                dispose();
			}
		} 



}
        
