package gui;

/**
 * @author Fabian Ovalle
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import accesoDatos.DaoUsuario;
import controlador.ControladorUsuario;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;

import logica.Usuario;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class ListarUsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario, campoNombres,campoApellidos,campoCedula,campoTelefono,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JButton botonActualizar;
	private JButton botonCancelar;
	        String[] opcionesTipoU = {"GERENTE", "OPERADOR"};
                  String[] opcionesEstado = {"ACTIVO", "INACTIVO"};
               
    //Se inicia el objeto ControladorModificarUsuario
    ControladorUsuario controladorUsuario;
    private Login usuarioLogeado;
    private JPasswordField campoConfirmacion;
    private JLabel lblConfirmacion;
    private JPasswordField campoPassword;
    private JSeparator separator;
    private JLabel lblNewLabel;
    
    private JTable table;
	private JScrollPane miScroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuarioGUI frame = new ListarUsuarioGUI();
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
	public ListarUsuarioGUI() {
		setResizable(false);
		
		controladorUsuario = new ControladorUsuario();
		
		setTitle("Listar Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 450);
		setBackground(new Color(0, 153, 255));
		setForeground(new Color(30, 144, 255));
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel Modifique = new JLabel("Lista de usuarios:");
		Modifique.setBounds(15, 11, 300, 50);
        Modifique.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        contentPane.add(Modifique);
        
        //Se establece la etiqueta Titulos
        String resultadoEt = controladorUsuario.ListarUsuario();
                  
      
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
	  botonCancelar.setBounds(340, 340,120, 60);
	  contentPane.add(botonCancelar);
	  
	  //Se establece el Scroll
	  miScroll = new JScrollPane();
	  miScroll.setBackground(new Color(255, 255, 255));
	  miScroll.setBounds(20, 70, 600, 200);
	  contentPane.add(miScroll);
	  
	//Se establece la Tabla
	construirTabla();
	
	}
	
	//Metodo para contruir la tabla
	private void construirTabla(){
		String titulos[] = {
				"Nick", "Tipo", "Estado", "Email", "Cedula", "Nombre", "apellido"
		};
		String informacion[][] = obtenerMatriz();
		table = new JTable(informacion, titulos);
		table.setBackground(new Color(255, 255, 255));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(310);
               table.getColumnModel().getColumn(4).setPreferredWidth(200);
               table.getColumnModel().getColumn(5).setPreferredWidth(160);
                table.getColumnModel().getColumn(6).setPreferredWidth(240);
		miScroll.setViewportView(table);
	}
	
	//Metodo para obtener una matriz con informacion de los Usuarios para llenar la tabla
	private String[][] obtenerMatriz(){
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		ArrayList<Usuario>miLista = daoUsuario.consultarUsuarioConMatriz();
		
		String matrizInfo[][] = new String[miLista.size()][7];
		
		for (int i=0; i<miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getNick();
			matrizInfo[i][1] = miLista.get(i).getTipo();
			matrizInfo[i][2] = miLista.get(i).getEstado();
			matrizInfo[i][3] = miLista.get(i).getEmail();
                        matrizInfo[i][4] = miLista.get(i).getCedula();
                        matrizInfo[i][5] = miLista.get(i).getNombre();
                        matrizInfo[i][6] = miLista.get(i).getApellido();
		}
		return matrizInfo;
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
			controladorUsuario.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			dispose();		
		}
}

