/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


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



import accesoDatos.DaoProveedor;
import accesoDatos.DaoUsuario;
import controlador.ControladorProveedor;
import controlador.ControladorUsuario;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;

import logica.Evento;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import logica.Usuario;

/**
 *
 * @author usuario
 */
public class ListarProveedorGUI extends JFrame { 
    private JPanel contentPane;
	private JTextField campoNombre, campoCiudad,campoDescripcion,campoDireccion,campoTelefono;

	private JButton botonActualizar;
	private JButton botonCancelar;
        ControladorProveedor controladorProveedor;
         private Login usuarioLogeado;
        private JTable table;
	private JScrollPane miScroll;
            private JSeparator separator;
    private JLabel lblNewLabel;
        
        	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProveedorGUI frame = new ListarProveedorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        
                
                
              public ListarProveedorGUI() {
		setResizable(false);
		
		controladorProveedor = new ControladorProveedor();
		
		setTitle("Listar Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 350);
		setBackground(new Color(0, 153, 255));
		setForeground(new Color(30, 144, 255));
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel Modifique = new JLabel("Lista de Proovedores:");
		Modifique.setBounds(15, 11, 300, 50);
        Modifique.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        contentPane.add(Modifique);
        
        //Se establece la etiqueta Titulos
        String resultadoEt = controladorProveedor.ListarProveedor();
                  
      
      //Se establece el boton Cancelar
      botonCancelar = new JButton();
      botonCancelar.setIcon(new ImageIcon("src/imagen/iratras.png"));
      botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
      botonCancelar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
    		  botonCancelarActionPerformed(evt);
      			}
      		});
      botonCancelar.setMnemonic('C');
      botonCancelar.setContentAreaFilled(false);
      botonCancelar.setBorder(new EmptyBorder(5, 5, 5, 5));
	  botonCancelar.setForeground(new Color(255, 255, 255));
//	  botonCancelar.setBackground(new Color(0, 0, 0));
	  botonCancelar.setBounds(340, 210, 120, 60);
	  contentPane.add(botonCancelar);
	  
	  //Se establece el Scroll
	  miScroll = new JScrollPane();
	  miScroll.setBackground(new Color(255, 255, 255));
	  miScroll.setBounds(20, 70, 436, 100);
	  contentPane.add(miScroll);
	  
	//Se establece la Tabla
	construirTabla();
	
	}  
                
           private void construirTabla(){
		String titulos[] = {
				"Nombre", "Ciudad", "Descripcion", "Direccion", "Telefono"
		};
		String informacion[][] = obtenerMatriz();
		table = new JTable(informacion, titulos);
		table.setBackground(new Color(255, 255, 255));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
               table.getColumnModel().getColumn(4).setPreferredWidth(200);
		miScroll.setViewportView(table);
	} 
           
           
           private String[][] obtenerMatriz(){
		
		DaoProveedor daoProveedor = new DaoProveedor();
		
		ArrayList<Evento>miLista = daoProveedor.consultarEventoConMatriz();
		
		String matrizInfo[][] = new String[miLista.size()][5];
		
		for (int i=0; i<miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getNombre();
			matrizInfo[i][1] = miLista.get(i).getCiudad();
			matrizInfo[i][2] = miLista.get(i).getDescripcion();
			matrizInfo[i][3] = miLista.get(i).getDireccion();
                        matrizInfo[i][4] = miLista.get(i).getTelefono();
		}
		return matrizInfo;
	}
                
                private void botonCancelarActionPerformed( ActionEvent evt ){
			controladorProveedor.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			dispose();		
		}
}
