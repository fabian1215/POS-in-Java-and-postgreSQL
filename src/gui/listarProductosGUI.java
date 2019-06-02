/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Fabian
 */
//public class listarProductosGUI {
//    
//}


/**
 * @author Fabian Ovalle
 */

import accesoDatos.DaoProducto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import accesoDatos.DaoUsuario;
import controlador.ControladorProducto;
import controlador.ControladorUsuario;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;

import logica.Usuario;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import logica.Producto;


public class  listarProductosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario, campoNombres,campoApellidos,campoCedula,campoTelefono,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JButton botonActualizar;
	private JButton botonCancelar,botonBuscar;
	        String[] opcionesTipoU = {"GERENTE", "OPERADOR"};
                  String[] opcionesEstado = {"ACTIVO", "INACTIVO"};
               
    //Se inicia el objeto ControladorModificarUsuario
    ControladorProducto controladorProducto;
    private Login usuarioLogeado;
    private JPasswordField campoConfirmacion;
    private JLabel lblConfirmacion;
    private JPasswordField campoPassword;
    private JSeparator separator;
    private JLabel lblNewLabel;
    private  DefaultTableModel model;
    private JTable table;
      private JTextField campoBusqueda;
      
	private JScrollPane miScroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listarProductosGUI frame = new listarProductosGUI();
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
	public  listarProductosGUI() {
		setResizable(false);
		
		controladorProducto = new ControladorProducto();
		setLocationRelativeTo(null);
		setTitle("Inventario de productos: ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 50, 700, 650);
		setBackground(new Color(0, 153, 255));
		setForeground(new Color(30, 144, 255));
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
               //prueba para imag enes
                	String titulos[] = {
				"Imagen", "Nombre", "Categoria", "Codigo", "Cantidad"
                        , "Precio Proveedor", "Precio Venta"
		};
		Object informacion[][] = obtenerMatriz();
                 model = new DefaultTableModel(informacion, titulos)
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };  
            
               
               
                
		JLabel Modifique = new JLabel("Inventario de productos: ");
		Modifique.setBounds(15, 11, 300, 50);
        Modifique.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        
    
                campoBusqueda = new JTextField("Buscar Articulo...");
         contentPane.add(campoBusqueda);
                campoBusqueda.setBounds(15, 70, 200, 25);
           
  botonBuscar = new JButton("Buscar");
      botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
     botonBuscar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
//    		  botonCancelarActionPerformed(evt);
      			}
      		});
     
      botonBuscar.setForeground(new Color(255, 255, 255));
	   botonBuscar.setBackground(new Color(0, 0, 0));
	   botonBuscar.setBounds(216, 70, 100, 25);
	  contentPane.add( botonBuscar);
     
     
     
        contentPane.add(Modifique);
        
        //Se establece la etiqueta Titulos
//        String resultadoEt = controladorUsuario.ListarUsuario();
                  
      
      //Se establece el boton Cancelar
      botonCancelar = new JButton("  <---  Atras");
      botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
      botonCancelar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
    		  botonCancelarActionPerformed(evt);
      			}
      		});
      botonCancelar.setMnemonic('C');
	  botonCancelar.setForeground(new Color(255, 255, 255));
	  botonCancelar.setBackground(new Color(0, 0, 0));
	  botonCancelar.setBounds(540, 580, 120, 33);
	  contentPane.add(botonCancelar);
	  
	  //Se establece el Scroll
	  miScroll = new JScrollPane();
	  miScroll.setBackground(new Color(255, 255, 255));
	  miScroll.setBounds(20, 130, 650, 440);
	  contentPane.add(miScroll);
	  
	//Se establece la Tabla
	construirTabla();
	
	}
	
	//Metodo para contruir la tabla
	private void construirTabla(){
//            imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa
		String titulos[] = {
				"Imagen", "Nombre", "Categoria", "Codigo", "Cantidad"
                        , "Precio Proveedor", "Precio Venta"
		};
		Object informacion[][] = obtenerMatriz();
		table = new JTable(model);
		table.setBackground(new Color(255, 255, 255));
		table.getColumnModel().getColumn(0).setPreferredWidth(598);

                 table.setRowHeight(70);
                
                
		table.getColumnModel().getColumn(1).setPreferredWidth(1400);
		table.getColumnModel().getColumn(2).setPreferredWidth(800);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
                table.getColumnModel().getColumn(4).setPreferredWidth(500);
                 table.getColumnModel().getColumn(5).setPreferredWidth(1000);
                  table.getColumnModel().getColumn(6).setPreferredWidth(1000);
                  
		miScroll.setViewportView(table);
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	
	//Metodo para obtener una matriz con informacion de los Usuarios para llenar la tabla
	private Object[][] obtenerMatriz(){
		
		DaoProducto daoProducto = new DaoProducto();
		
		ArrayList<Producto>miLista = daoProducto.consultarProductoConMatriz(1,"");
		
		Object matrizInfo[][] = new Object[miLista.size()][7];
		
		for (int i=0; i<miLista.size(); i++) {
                      ImageIcon imageIcon = new ImageIcon(new ImageIcon(miLista.get(i).getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
			JLabel  Imagen = new JLabel();
                        Imagen.setIcon(imageIcon);
//                        Imagen.setBounds(100, 100, 540, 350);
                        contentPane.add(Imagen);
                      matrizInfo[i][0] =   imageIcon;
//                                 miLista.get(i).getImagen();
                          
                       

                        
                        
			matrizInfo[i][1] = miLista.get(i).getNombre();
			matrizInfo[i][2] = miLista.get(i).getCategoria();
			matrizInfo[i][3] = miLista.get(i).getCodigo();
                        matrizInfo[i][4] = miLista.get(i).getCantidad();
                        matrizInfo[i][5] = miLista.get(i).getPrecioProveedor();
                        matrizInfo[i][6] = miLista.get(i).getPrecioVenta();
                          
		}
//                String value = table.getModel().getValueAt(row, column).toString();
		return matrizInfo;
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
			controladorProducto.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			dispose();		
		}
}

