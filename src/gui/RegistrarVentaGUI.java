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
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.AbstractAction;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Producto;


public class  RegistrarVentaGUI extends JFrame {
    
         
private Object matrizInfo[][];
private Object matrizVenta[][];
private Object categoriaInfo[][];
private ArrayList<Producto>miListaVenta;
private ArrayList<Producto>miLista;
//lista que guarda cambios en busquedas antes de enviar a la base de datos
private ArrayList<Producto>miListaTemporal;
private ArrayList<Producto>listaCategoria;
	private JPanel contentPane;
	private JTextField campoUsuario, campoNombres,campoApellidos,campoCedula,campoTelefono,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JButton botonActualizar;
	private JButton botonCancelar,botonBuscar, botonRegistrarVenta, botonCancelarVenta;
	        String[] opcionesTipoU = {"GERENTE", "OPERADOR"};
                  String[] opcionesEstado = {"ACTIVO", "INACTIVO"};
               
    //Se inicia el objeto ControladorModificarUsuario
    ControladorProducto controladorProducto;
    private Login usuarioLogeado;
    private JPasswordField campoConfirmacion;
    private JLabel lblConfirmacion;
    private JPasswordField campoPassword;
    private JSeparator separator;
    private JLabel lblNewLabel, totalLabel;
    private  DefaultTableModel model, modelVenta, modelCategorias;
    private JTable table,tableVenta, tableCategorias;
    private String moneyString;
      private JTextField campoBusqueda;
      private double total=0;
      int maximoFactura;
	private JScrollPane miScroll;
        private JScrollPane miScrollVenta;
          private JScrollPane miScrollCategorias;
             private JTextField campoPrecioAct;
   private JTextField campoPrecioVent;
       private double resultado;
        private   JLabel etiquetaResultado;
     
          
private NumberFormat formatter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVentaGUI frame = new RegistrarVentaGUI();
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
	public  RegistrarVentaGUI() {
                    etiquetaResultado = new JLabel("$ " + resultado );
                    
            UIManager.put("ToolTip.font",  new FontUIResource("SansSerif", Font.BOLD, 17));
formatter = NumberFormat.getInstance();
            setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarVentaGUI.class.getResource("/imagen/iconventa.png")));
		setResizable(false);
                
               moneyString = formatter.format(total);
System.out.println(moneyString);
                     campoPrecioAct = new JTextField ("");
                     campoPrecioVent  = new JTextField ("");
                     
                     
                        campoPrecioAct.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
     if ((campoPrecioAct.getText().equals("")== false)&& total!=0  && (isNumeric(campoPrecioAct.getText()))) {
        calculaGanancia( Double.parseDouble(campoPrecioVent.getText()),
               total
                 );
         etiquetaResultado.setText("$ "  + resultado );
        
    } 
     
     
     
    }
    public void removeUpdate(DocumentEvent e) {
    if ((campoPrecioAct.getText().equals("")== false)&& total!=0  && (isNumeric(campoPrecioAct.getText()))) {
      
             calculaGanancia( Double.parseDouble(campoPrecioAct.getText()),
                total
                 );
               etiquetaResultado.setText("$ "  + resultado);
                  
    }
    }
    public void insertUpdate(DocumentEvent e) {
        if ((campoPrecioAct.getText().equals("")== false)&& total!=0  && (isNumeric(campoPrecioAct.getText()))) {
      
             calculaGanancia( Double.parseDouble(campoPrecioAct.getText()),
                total
                 );
               etiquetaResultado.setText("$ "  + resultado);
                  
    }
    }
  }
);
                totalLabel = new JLabel("$ " + moneyString);
              
                 
                //listaventa pruebas
		miListaVenta = new ArrayList<Producto>();
                miListaTemporal = new ArrayList<Producto>();
		controladorProducto = new ControladorProducto();
                
                
                listaCategoria = new ArrayList<Producto>();
		setLocationRelativeTo(null);
		setTitle("Inventario de productos: ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		setBackground(new Color(0, 153, 255));
		setForeground(new Color(30, 144, 255));
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
              
                
                  maximoFactura= controladorProducto.consultarMaxFactura();
               //prueba para imag enes
                	String titulos[] = {
				"Imagen", "Nombre", "Categoria", "Codigo", "Cantidad"
                        ,  "Precio Venta", "Agregar"
		};
                        
                        
                        
                    	String titulosCategoria[] = {
				"Categorias"
		};    
                        
		Object informacion[][] = obtenerMatriz();
                Object informacionVenta[][] = obtenerMatrizVenta();
                  Object informacionCategorias[][] =  matrizCategorias();
                
                 model = new DefaultTableModel(informacion, titulos)
        {
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };  
            
                 
                 
                 
                               modelVenta = new DefaultTableModel(informacionVenta, titulos)
        { 
             @Override
           
    public boolean isCellEditable(int row, int column) {
        
       //all cells false
//        if (column != 3) {
                return false; 
//        }
        

    } 
    
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        }; 
                               
                               
                               
                               
                      
                               modelCategorias = new DefaultTableModel(informacionCategorias, titulosCategoria)
        { 
             @Override
           
    public boolean isCellEditable(int row, int column) {
        
       //all cells false
//        if (column != 3) {
                return false; 
//        }
        

    } 
    
    
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };                  
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
               
               
                
		JLabel Modifique = new JLabel("Inventario de productos: ");
		Modifique.setBounds(15, 11, 300, 50);
        Modifique.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        
        
          
		
             
 
//NumberFormat formatter = NumberFormat.getCurrencyInstance();

                
                
                
                totalLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
                totalLabel.setForeground(new Color(0, 150, 0));
                totalLabel.setBounds(1050, 578, 350, 35);
          contentPane.add(totalLabel);
        
      JLabel background1 = new JLabel(new ImageIcon("src/imagen/ventalimpio.png"));
       background1.setBounds(0, 0, 1366, 768);
                campoBusqueda = new JTextField();
         contentPane.add(campoBusqueda);
                campoBusqueda.setBounds(286, 60, 230, 35);
            campoBusqueda.setToolTipText("Busque el producto que desea, puede buscar por nombre, categoria o codigo");
                  campoBusqueda.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
//     if (campoBusqueda.getText().equals("") ==false ) {
//     construirTabla(2,campoBusqueda.getText());
//    } 
     
     
     
    }
    public void removeUpdate(DocumentEvent e) {
       if (campoBusqueda.getText().equals("") ) {
//  construirTabla(1,"");
         construirTabla(2,"");
    } 
    }
    public void insertUpdate(DocumentEvent e) {
    if (campoBusqueda.getText().equals("") ==false ) {
     construirTabla(2,campoBusqueda.getText());
    }
    }
  }
);  
                
                
                
                
                
                
                
  botonBuscar = new JButton();
      botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
     botonBuscar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
               botonBuscarActionPerformed(evt);

      			}
      		});
     
     
                   
  botonRegistrarVenta = new JButton();
   botonRegistrarVenta.setBounds(793, 645, 216,47);
   botonRegistrarVenta.setContentAreaFilled(false);
   botonRegistrarVenta.setBorder(new EmptyBorder(5, 5, 5, 5));
     contentPane.add( botonRegistrarVenta);
     botonRegistrarVenta.addActionListener(new ActionListener() {
//         	   botonBuscar.setBounds(216, 70, 100, 25);
    	  public void actionPerformed(ActionEvent evt) {
               botonRegistrarVentaActionPerformed(evt);

      			}
      		});
     
     
     
     
     botonCancelarVenta = new JButton();
   botonCancelarVenta.setBounds(1056, 645, 216,47);
   botonCancelarVenta.setContentAreaFilled(false);
  botonCancelarVenta.setBorder(new EmptyBorder(5, 5, 5, 5));
     contentPane.add(botonCancelarVenta);
     botonCancelarVenta.addActionListener(new ActionListener() {
//         	   botonBuscar.setBounds(216, 70, 100, 25);
    	  public void actionPerformed(ActionEvent evt) {
               botonCancelarVentaActionPerformed(evt);

      			}
      		});
     
     
     
     
     
     
     
     
      botonBuscar.setForeground(new Color(255, 255, 255));
	   botonBuscar.setBackground(new Color(0, 0, 0));
	   botonBuscar.setBounds(216, 70, 100, 25);
//	  contentPane.add( botonBuscar);
     
     
     
//        contentPane.add(Modifique);
        
        //Se establece la etiqueta Titulos
//        String resultadoEt = controladorUsuario.ListarUsuario();
                  
      
      //Se establece el boton Cancelar
      botonCancelar = new JButton();
      botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
      botonCancelar.setToolTipText("Ir a la ventana anterior (panel de administrador)");
       botonCancelar.setContentAreaFilled(false);
       botonCancelar.setBorder(new EmptyBorder(5, 5, 5, 5));
      botonCancelar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
    		  botonCancelarActionPerformed(evt);
      			}
      		});
      botonCancelar.setMnemonic('C');
	  botonCancelar.setForeground(new Color(255, 255, 255));
	  botonCancelar.setBackground(new Color(0, 0, 0));
	  botonCancelar.setBounds(63, 635, 80, 60);
	  contentPane.add(botonCancelar);
	  
	  //Se establece el Scroll
	  miScroll = new JScrollPane();
//	  miScroll.setBackground(new Color(255, 255, 255));
	  miScroll.setBounds(208, 130, 483, 440);
          
           etiquetaResultado.setBounds(1055, 365, 640, 370);
           etiquetaResultado.setFont(new Font("Arial", Font.BOLD, 20));
          contentPane.add(etiquetaResultado);
          
          
          miScrollCategorias = new JScrollPane();
//	  miScroll.setBackground(new Color(255, 255, 255));
	  miScrollCategorias.setBounds(23, 130,160, 500);
          contentPane.add(miScrollCategorias);
           miScrollVenta = new JScrollPane();
	  miScrollVenta.setBackground(new Color(255, 255, 255));
	  miScrollVenta.setBounds(712, 130, 640, 370);
             contentPane.add(miScroll);
	  
	  contentPane.add(miScrollVenta);
	   campoPrecioAct.setBounds(1055, 505, 135, 24);
             
           campoPrecioAct.setFont(new Font("Arial", Font.BOLD, 20));
            contentPane.add(campoPrecioAct);
	//Se establece la Tabla
	construirTabla(1,"");
       construirTablaVenta();
        construirTablaCategorias();
	 contentPane.add(background1);
	}
	
	//Metodo para contruir la tabla
        
        
        private void createKeybindings(final JTable table) {
table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
    table.getActionMap().put("Enter", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent evt) {
           
            
             int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
//        if (row >= 0 && col >= 0 ) {
//      String value = table.getModel().getValueAt(row, 3).toString();
// JOptionPane.showMessageDialog(null, "Informacion: " +value + "columna: "+ col +" " + "fila: " + row);
//        }
       pasarTablaVenta( row,col, table);
        }
    });
}
        
        
        
        
          public void calculaGanancia (double cantidadCalcular, double total) {
if (total<= cantidadCalcular ) {
        resultado=  (cantidadCalcular-total);
         campoPrecioAct.setForeground(new Color(0, 135,10));
        
}
else {
//JOptionPane.showMessageDialog(null, "El cliente debe pagar con una cantidad superior, revise el valor ingresado en 'paga con' ");
    resultado=0;
    campoPrecioAct.setForeground(new Color(130, 0,0));
}
    
       
    }
        
        
        
        
        
        
        
	private void construirTabla(int tipo, String Busqueda){
//            imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa
		String titulos[] = {
				"Imagen", "Nombre", "Categoria", "Codigo", "Cantidad"
                        ,  "Precio", "Agregar"
		};
                
//                
//                String titulos[] = {
//				"Imagen", "Nombre", "Categoria", "Codigo", "Cantidad"
//                        , "Precio Proveedor", "Precio Venta"
//		};
             Object[][] informacion = null;
                if (tipo ==1) {
		 informacion = obtenerMatriz();
                }
                if (tipo ==2) {
                  informacion = BusquedaMatriz(Busqueda);  
                }
    
                //se cambia el model;
          model = new DefaultTableModel(informacion, titulos)
        {
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
            // codigo que permite que se vean las imagenes de los articulos
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        }; 
          // codigo que permite que se vean las imagenes de los articulos
		table = new JTable(model);

               
                
//                table.setOpaque(false);
//((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);

                
                
                table.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
         if(evt.getClickCount()==2){
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());
         
//        if (row >= 0 && col >= 0 ) {
//      String value = table.getModel().getValueAt(row, 3).toString();
// JOptionPane.showMessageDialog(null, "Informacion: " +value + "columna: "+ col +" " + "fila: " + row);
//        }
          pasarTablaVenta( row,col, table);
                 if ((campoPrecioAct.getText().equals("")== false)&& total!=0  && isNumeric(campoPrecioAct.getText())) {
      
             calculaGanancia( Double.parseDouble(campoPrecioAct.getText()),
                total
                 );
               etiquetaResultado.setText("$ "  + resultado);
                  
    }
      
                                 }
    }
});	
                createKeybindings(table);
            
		table.setBackground(new Color(255, 255, 255));
		table.getColumnModel().getColumn(0).setPreferredWidth(570);

                 table.setRowHeight(70);
                
                
		table.getColumnModel().getColumn(1).setPreferredWidth(1150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(290);
                table.getColumnModel().getColumn(4).setPreferredWidth(420);
                 table.getColumnModel().getColumn(5).setPreferredWidth(400);
                        table.getColumnModel().getColumn(6).setPreferredWidth(380);
//                  table.getColumnModel().getColumn(6).setPreferredWidth(1000);
                  
		miScroll.setViewportView(table);
               
//                miScroll.setOpaque(false);
//miScroll.getViewport().setOpaque(false);
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        private void construirTablaCategorias(){
//            imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa
		
                
//                
                String titulosCategoria[] = {
				""
		};
             Object[][] informacionCategorias = null;
            
		 informacionCategorias = matrizCategorias();
              
    
                //se cambia el model;
          modelCategorias = new DefaultTableModel(informacionCategorias, titulosCategoria)
        {
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
            // codigo que permite que se vean las imagenes de los articulos
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        }; 
          // codigo que permite que se vean las imagenes de los articulos
		tableCategorias = new JTable(modelCategorias);

               tableCategorias.setFont(new Font("Arial", Font.BOLD, 20));
                
//                table.setOpaque(false);
//((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);

                
                
                tableCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        
        int row = tableCategorias.rowAtPoint(evt.getPoint());
        int col = tableCategorias.columnAtPoint(evt.getPoint());
        
//        if (row >= 0 && col >= 0 ) {
//      String value = table.getModel().getValueAt(row, 3).toString();
// JOptionPane.showMessageDialog(null, "Informacion: " +value + "columna: "+ col +" " + "fila: " + row);
//        }
         if (listaCategoria.get(row).getNombre().equals("todo")) {
           construirTabla(1,"");  
         } else {
            construirTabla(2,listaCategoria.get(row).getNombre());  
         }
      
                              
    }
});	
                createKeybindings(tableCategorias);
            
		tableCategorias.setBackground(new Color(255, 255, 255));
		tableCategorias.getColumnModel().getColumn(0).setPreferredWidth(570);

                 tableCategorias.setRowHeight(50);
                
              
//                  table.getColumnModel().getColumn(6).setPreferredWidth(1000);
                  
		miScrollCategorias.setViewportView(tableCategorias);
               
//                miScroll.setOpaque(false);
//miScroll.getViewport().setOpaque(false);
                 
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        	private void construirTablaVenta(){
//            imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa
		String titulos[] = {
				"Imagen", "Nombre", "Codigo", "Cantidad"
                        ,  "Precio",  "Sub-Total","+ unidad", "- unidad", "Remover"
		};
                
//                
//                String titulos[] = {
//				"Imagen", "Nombre", "Categoria", "Codigo", "Cantidad"
//                        , "Precio Proveedor", "Precio Venta"
//		};
             Object[][] informacionVenta = null;
              
		 informacionVenta = obtenerMatrizVenta();
                
           
            
    
                //se cambia el model;
          modelVenta = new DefaultTableModel(informacionVenta, titulos)
        {
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
////        if (column != 3) {
//         return false;    
//        } else {
            return false;
//        }
        
      
    }
            // codigo que permite que se vean las imagenes de los articulos
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        }; 
          // codigo que permite que se vean las imagenes de los articulos
		tableVenta = new JTable(modelVenta);
           
//                table.setOpaque(false);
//((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);

                
                
                tableVenta.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
//         if(evt.getClickCount()==2){
        int row = tableVenta.rowAtPoint(evt.getPoint());
        int col = tableVenta.columnAtPoint(evt.getPoint());
        if (row >= 0 && col ==6 ) {
       
        
       
//        miListaVenta.get(row).setCantidad(miListaVenta.get(row).getCantidad()+1);
//         tableVenta.getModel().setValueAt(((int)(tableVenta.getModel().getValueAt(row, 3)) +1),row, 3);
         construirTablaVenta();
         
         
         
         //PRUEBA PARA DISMINUIR NUMERO 
          for (int j=0; j<miListaTemporal.size(); j++) {
     for (int i=0; i<miListaVenta.size(); i++) {

        
 if (miListaTemporal.get(j).getCodigo() == miListaVenta.get(row).getCodigo()) {
//      JOptionPane.showMessageDialog(null, "encuentra coincidencia" );
//     JOptionPane.showMessageDialog(null,"encontro igual entre " +   ( miListaTemporal.get(j).getCantidad() ) +
//   " - 1");
     //pronar que la cantidad sea mayor a 0 para quitarle 
     
        if (miListaTemporal.get(j).getCantidad()>0) {
      miListaVenta.get(row).setCantidad(miListaVenta.get(row).getCantidad()+1);
         tableVenta.getModel().setValueAt(((int)(tableVenta.getModel().getValueAt(row, 3)) +1),row, 3);
         
      miListaTemporal.get(j).setCantidad( ( miListaTemporal.get(j).getCantidad() ) -  1   );
      break;
 } 
     else {
   JOptionPane.showMessageDialog(null, "No se  pueden agregar mas unidades de este tipo en una venta, no quedan unidades disponibles  " );  
   break;
           }
 
   
//      JOptionPane.showMessageDialog(null, "cantidad lista temporal nueva: " + ((int)(table.getModel().getValueAt(row, 4))));

    //VA AUMENTANDO DE UNO EN UNO LA CANTIDAD
//     miListaVenta.get(j).setCantidad(miListaVenta.get(j).getCantidad()+1);



 
   }  
}
}  
       construirTablaVenta();
            
     //aqui va el construye tabla
          construirTabla(2,campoBusqueda.getText());
         
        }
        
        
        
        
        
        
        
        
           if (row >= 0 && col ==7 ) {
       
        
       
//        miListaVenta.get(row).setCantidad(miListaVenta.get(row).getCantidad()-1);
//         tableVenta.getModel().setValueAt(((int)(tableVenta.getModel().getValueAt(row, 3)) -1),row, 3);
//         construirTablaVenta();
         
         
         
         //PRUEBA PARA DISMINUIR NUMERO 
          for (int j=0; j<miListaTemporal.size(); j++) {
     for (int i=0; i<miListaVenta.size(); i++) {

          
 if (miListaTemporal.get(j).getCodigo() == miListaVenta.get(row).getCodigo()) {
//      JOptionPane.showMessageDialog(null, "encuentra coincidencia" );
//     JOptionPane.showMessageDialog(null,"encontro igual entre " +   ( miListaTemporal.get(j).getCantidad() ) +
//   " - 1");
     
     
           if (miListaVenta.get(row).getCantidad()>1) {
               
        
         miListaVenta.get(row).setCantidad(miListaVenta.get(row).getCantidad()-1);
         tableVenta.getModel().setValueAt(((int)(tableVenta.getModel().getValueAt(row, 3)) -1),row, 3);
         
         
      miListaTemporal.get(j).setCantidad( ( miListaTemporal.get(j).getCantidad() ) +1   );
      
         } else {
               //BOTON DE SI O NO
               if (JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea retirar el producto de esta venta?", "Confirmar Accion",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
            
           miListaVenta.get(row).setCantidad(miListaVenta.get(row).getCantidad()-1);
         tableVenta.getModel().setValueAt(((int)(tableVenta.getModel().getValueAt(row, 3)) -1),row, 3);
         
         
      miListaTemporal.get(j).setCantidad( ( miListaTemporal.get(j).getCantidad() ) +1   );
      
               miListaTemporal.remove(j);  
               miListaVenta.remove(row);
                   
                   
} else {

}
          
           }
      break;

 }

}
}
   construirTablaVenta();        
          
         
     //aqui va el construye tabla
          construirTabla(2,campoBusqueda.getText());
         
        }
        
        
          if (row >= 0 && col ==8 ) {
 
         //PRUEBA PARA Eliminar numero
          for (int j=0; j<miListaTemporal.size(); j++) {
     for (int i=0; i<miListaVenta.size(); i++) {

          
 if (miListaTemporal.get(j).getCodigo() == miListaVenta.get(row).getCodigo()) {

        
               //BOTON DE SI O NO
               if (JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea retirar el producto de esta venta?", "Confirmar Accion",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
            
        
      
               miListaTemporal.remove(j);  
               miListaVenta.remove(row);
                   
                   
} else {
    // no option
}

           
      break;



 }

}
}
   construirTablaVenta();        
          
         
     //aqui va el construye tabla
          construirTabla(2,campoBusqueda.getText());
          
        
         
        }
        if ((campoPrecioAct.getText().equals("")== false)&& total!=0  && isNumeric(campoPrecioAct.getText())) {
      
             calculaGanancia( Double.parseDouble(campoPrecioAct.getText()),
                total
                 );
               etiquetaResultado.setText("$ "  + resultado);
                  
    }
         
          tableVenta.scrollRectToVisible(tableVenta.getCellRect(row,col, true)); 
        
        ;
//                                 }
    }
});	
                
                
                
       //Comienza construir tabla categoria        
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                createKeybindings(tableVenta);
            
		tableVenta.setBackground(new Color(240, 255, 255));
		tableVenta.getColumnModel().getColumn(0).setPreferredWidth(150);

                 tableVenta.setRowHeight(70);
                
                
		tableVenta.getColumnModel().getColumn(1).setPreferredWidth(280);
		tableVenta.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableVenta.getColumnModel().getColumn(3).setPreferredWidth(130);
                tableVenta.getColumnModel().getColumn(4).setPreferredWidth(130);
                 tableVenta.getColumnModel().getColumn(5).setPreferredWidth(180);
                 
                 //columnas metaforas
                  tableVenta.getColumnModel().getColumn(6).setPreferredWidth(120);
                  tableVenta.getColumnModel().getColumn(7).setPreferredWidth(120);
                    tableVenta.getColumnModel().getColumn(8).setPreferredWidth(120);
//                  table.getColumnModel().getColumn(6).setPreferredWidth(1000);
                  
		miScrollVenta.setViewportView(tableVenta);
//                miScroll.setOpaque(false);
//miScroll.getViewport().setOpaque(false);
	}
        
        
        
        
        
        
        
        
        
        
        
      public static boolean isNumeric(String str) {
		
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
        
    }
        
 
        
        
        
        public void pasarTablaVenta(int row, int col, JTable table) {
            boolean encontrado=false;
            boolean encontradoVenta=false;
            Producto ultimo = new Producto();
            if (row >= 0 && col >= 0 ) {
      String value = table.getModel().getValueAt(row, 3).toString();
// JOptionPane.showMessageDialog(null, "Informacion: " +value + "columna: "+ col +" " + "fila: " + row);
//  table.getModel().setValueAt(((int)(table.getModel().getValueAt(row, 4)) -1),row, 4);

// miListaVenta.add(miLista.get(row));
 if (miListaTemporal.size()>0){
//     JOptionPane.showMessageDialog(null, "entra en if" );
     
   for (int j=0; j<miListaTemporal.size(); j++) {
     for (int i=0; i<miLista.size(); i++) {

          
 if (miListaTemporal.get(j).getCodigo() == miLista.get(row).getCodigo()) {
//      JOptionPane.showMessageDialog(null, "encuentra coincidencia" );
      miListaTemporal.get(j).setCantidad( ((int)(table.getModel().getValueAt(row, 4)))  );
//JOptionPane.showMessageDialog(null,"encontrado" +   encontrado );
     
//      JOptionPane.showMessageDialog(null, "cantidad lista temporal nueva: " + ((int)(table.getModel().getValueAt(row, 4))));
     encontrado=true;
    
    //VA AUMENTANDO DE UNO EN UNO LA CANTIDAD
//     miListaVenta.get(j).setCantidad(miListaVenta.get(j).getCantidad()+1);

 }

}
}
            } else {
     
//       JOptionPane.showMessageDialog(null, "nombre lista por getrow:  " + miLista.get(row).getNombre());
   miLista.get(row).setCantidad( ((int)(table.getModel().getValueAt(row, 4)))  );
  //cuidado al borrar 
//   miListaTemporal.add(miLista.get(row));
//   
//     JOptionPane.showMessageDialog(null, miLista.get(row).getNombre()+ " agregado" );
     
 }
 if (encontrado==false) {
       table.getModel().setValueAt(((int)(table.getModel().getValueAt(row, 4)) -1),row, 4);
//     miListaVenta.add(miLista.get(row));
  Producto tempArticulo  = new Producto();
  tempArticulo.setNombre(miLista.get(row).getNombre());
 tempArticulo.setImagen(miLista.get(row).getImagen());
 tempArticulo.setPrecioVenta(miLista.get(row).getPrecioVenta());
 tempArticulo.setPrecioProveedor(miLista.get(row).getPrecioProveedor());
 tempArticulo.setCategoria(miLista.get(row).getCategoria());
  tempArticulo.setCodigo(miLista.get(row).getCodigo());
  tempArticulo.setCantidad(1);
//      tempArticulo =   miLista.get(row);
   miLista.get(row).setCantidad( ((int)(table.getModel().getValueAt(row, 4)))  );
   miListaTemporal.add(miLista.get(row));
   
   
     
// 
//   miListaVenta.add(miLista.get(row));
     miListaVenta.add(tempArticulo);
  
//     JOptionPane.showMessageDialog(null,"cantidad desde lista venta: " +tempArticulo.getCantidad() );
//      JOptionPane.showMessageDialog(null,tempArticulo.getCantidad() );
 } else {
    
 }
 

 construirTablaVenta();
        } 
        }
	
	//Metodo para obtener una matriz con informacion de los Usuarios para llenar la tabla
        
        
        
//        
//       private void crearMatrizTemporal() {
//           for (int i=0; i<miLista.size() || i<milist.size(); i++) {
//               
//               
//           
//           }
//       }
	private Object[][] obtenerMatriz(){
		
		DaoProducto daoProducto = new DaoProducto();
		
		miLista = daoProducto.consultarProductoConMatriz(1,"");
		
		 matrizInfo = new Object[miLista.size()][7];
		//PRUEBA
//          JOptionPane.showMessageDialog(null, "primer producto "+ (miLista.get(0).getNombre()) );        
                 
                 
                 
		for (int i=0; i<miLista.size(); i++) {
                      ImageIcon imageIcon = new ImageIcon(new ImageIcon(miLista.get(i).getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
			JLabel  Imagen = new JLabel();
                        Imagen.setIcon(imageIcon);
//                        Imagen.setBounds(100, 100, 540, 350);
                        contentPane.add(Imagen);
                      matrizInfo[i][0] =   imageIcon;
//                                 miLista.get(i).getImagen();
                          
                       

                      
                      
                      
//                        for (int j=0; j<miListaTemporal.size(); j++) {
//               
//               
//            if (miListaTemporal.get(j).getCodigo() == miLista.get(i).getCodigo()) {
//                 matrizInfo[i][4] = miLista.get(j).getCantidad();
//                
//            }
//            else matrizInfo[i][4] = miLista.get(i).getCantidad();
//           }
                        
                        
			matrizInfo[i][1] = miLista.get(i).getNombre();
			matrizInfo[i][2] = miLista.get(i).getCategoria();
			matrizInfo[i][3] = miLista.get(i).getCodigo();
//                        matrizInfo[i][4] = miLista.get(i).getCantidad();
                        
                        if (miListaTemporal.size()>0) {
                        
                                  for (int j=0; j<miListaTemporal.size(); j++) {
                                      
                                      
                                      
                                      
               
            if (miListaTemporal.get(j).getCodigo() == miLista.get(i).getCodigo()) {
//                 JOptionPane.showMessageDialog(null, "encontro igual, con cantidad:  " + miListaTemporal.get(j).getCantidad());
                 matrizInfo[i][4] = miListaTemporal.get(j).getCantidad();
//                 break;
                
            }
            else  {
                matrizInfo[i][4] = miLista.get(i).getCantidad();
            }
                                  } 
                        } else {
//                             JOptionPane.showMessageDialog(null, "no hay igual ");
                            matrizInfo[i][4] = miLista.get(i).getCantidad();
                        }        
                        
                        
                        
//                        matrizInfo[i][5] = miLista.get(i).getPrecioProveedor();
//                        matrizInfo[i][5] = miLista.get(i).getPrecioVenta();
                        
                                   matrizInfo[i][5] = miLista.get(i).getPrecioVenta();
 ImageIcon imagenAgregar = new ImageIcon(new ImageIcon("src/imagen/agregar.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
		matrizInfo[i][6] = imagenAgregar;
                
                }
//                String value = table.getModel().getValueAt(row, column).toString();
		return matrizInfo;
	}
        
        
        
        
        
        
      private Object[][] obtenerMatrizVenta(){
		
             
           total=0;
                       moneyString = formatter.format(total);
                       totalLabel.setText("$ " + moneyString);
          
          
//	miListaVenta.add();
		
//		ArrayList<String>miListaVenta = daoProducto.consultarProductoConMatriz(1,"");
		//Estaba en 6
		 matrizVenta = new Object[miListaVenta.size()][9];
		
                       
                                 
		for (int i=0; i<miListaVenta.size(); i++) {
//                    JOptionPane.showMessageDialog(null, "Mi lista venta cantidad :  " + miListaVenta.get(i).getCantidad());
                      ImageIcon imageIcon = new ImageIcon(new ImageIcon(miListaVenta.get(i).getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
			JLabel  Imagen = new JLabel();
                        Imagen.setIcon(imageIcon);
//                        Imagen.setBounds(100, 100, 540, 350);
                        contentPane.add(Imagen);
                      matrizVenta[i][0] =   imageIcon;
//                                 miLista.get(i).getImagen();
                          
                       
//
//JOptionPane.showMessageDialog(null,miListaVenta.get(i).getNombre());
                        
                        
			matrizVenta[i][1] = miListaVenta.get(i).getNombre();
//			matrizVenta[i][2] = miListaVenta.get(i).getCategoria();
			matrizVenta[i][2] = miListaVenta.get(i).getCodigo();
                        matrizVenta[i][3] =  miListaVenta.get(i).getCantidad();
//                        matrizInfo[i][5] = miLista.get(i).getPrecioProveedor();
                        matrizVenta[i][4] = miListaVenta.get(i).getPrecioVenta();
                        matrizVenta[i][5] = ((miListaVenta.get(i).getPrecioVenta())  * (miListaVenta.get(i).getCantidad()));
                        
                        total= total + (double)matrizVenta[i][5];
                         moneyString = formatter.format(total);
                           totalLabel.setText("$ " + moneyString);
                          
                          ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/imagen/add2.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                           
                          matrizVenta[i][6] = imageIcon2;
                          
                          
                          ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("src/imagen/min2.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                           
                          matrizVenta[i][7] = imageIcon3;
                          
                          
                          ImageIcon imageRemover = new ImageIcon(new ImageIcon("src/imagen/remover.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
                           
                          matrizVenta[i][8] = imageRemover;
                          
                          
		}
//                String value = table.getModel().getValueAt(row, column).toString();
		return matrizVenta;
	}  
        
        private Object[][] matrizCategorias(){
            DaoProducto daoProducto = new DaoProducto();
            listaCategoria  = daoProducto.consultarCategoriaConMatriz();
            
             categoriaInfo = new Object[listaCategoria.size()][1];

             for (int i=0; i<listaCategoria.size(); i++) {
                categoriaInfo[i][0] = listaCategoria.get(i).getNombre(); 
//                JOptionPane.showMessageDialog(null, "categoria:" + listaCategoria.get(i).getNombre());
              }
    return categoriaInfo;
                        
                }
        
        
        	private Object[][] BusquedaMatriz(String Busqueda){
                
		
		DaoProducto daoProducto = new DaoProducto();
		miLista  = daoProducto.consultarProductoConMatriz(2,Busqueda);
//		ArrayList<Producto>miLista = daoProducto.consultarProductoConMatriz(2,Busqueda);
		
		 matrizInfo = new Object[miLista.size()][7];
                 
                  if (miListaTemporal.size()>0) {
                        
                 	for (int i=0; i<miLista.size(); i++) {
                             for (int j=0; j<miListaTemporal.size(); j++) {
                                 if (miLista.get(i).getCodigo()==miListaTemporal.get(j).getCodigo() ){
                                   miLista.get(i).setCantidad(miListaTemporal.get(j).getCantidad());
                                 }
                        }
                        }
                  }
		
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
//                        matrizInfo[i][4] = miLista.get(i).getCantidad();
                        
                        
                        
                        
                        
                        
//                        
//                        
//                        
//                        
//                           if (miListaTemporal.size()>0) {
//                        
//                                  for (int j=0; j<miListaTemporal.size(); j++) {
//                                      
//                                      
////                                        JOptionPane.showMessageDialog(null, "nombre producto en lista tempora " + miListaTemporal.get(j).getNombre());
//                                      
////             JOptionPane.showMessageDialog(null, "revisa si son iguales " + miListaTemporal.get(j).getNombre() + "  y  " + miLista.get(i).getNombre());   
//            if (miListaTemporal.get(j).getCodigo() == miLista.get(i).getCodigo()) {
////                 JOptionPane.showMessageDialog(null, "encontro igual, con cantidad:  " + miListaTemporal.get(j).getCantidad());
//                 matrizInfo[i][4] = miListaTemporal.get(j).getCantidad();
////                     miLista.get(i).setCantidad(miListaTemporal.get(j).getCantidad());
//                 //prueba mantener cantidad
////    JOptionPane.showMessageDialog(null,miListaTemporal.get(j).getNombre() + " cantidad temp:" +  miListaTemporal.get(j).getCantidad() );
////                 break;
//                
//            }
//            else  {
//                matrizInfo[i][4] = miLista.get(i).getCantidad();
//            }
//                                  } 
//                        } else {
////                             JOptionPane.showMessageDialog(null, "no hay igual ");
////                            matrizInfo[i][4] = miLista.get(i).getCantidad();
                                matrizInfo[i][4] =  miLista.get(i).getCantidad();
//                        }
//                        
                        
//                        matrizInfo[i][5] = miLista.get(i).getPrecioProveedor();
                        matrizInfo[i][5] = miLista.get(i).getPrecioVenta();
                        ImageIcon imagenAgregar = new ImageIcon(new ImageIcon("src/imagen/agregar.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
		matrizInfo[i][6] = imagenAgregar;
                          
		}
//                String value = table.getModel().getValueAt(row, column).toString();
             
		return matrizInfo;
                
	}
        
        
        
         private void   botonRegistrarVentaActionPerformed( ActionEvent evt ){
              int vendidos =0;
             DaoProducto daoProducto2 = new DaoProducto();
              if ( miListaVenta.isEmpty()){
  JOptionPane.showMessageDialog(null, "Para registrar una venta primero debe agregar articulos a la venta, \n para agregar articulos"
          + " de doble clic en el articulo que desea agregar desde el panel central"
                    );                   
              } else {
                 
//                  String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());               
                  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Calendar cal = Calendar.getInstance();
//System.out.println(dateFormat.format(cal.getTime()));
String fecha =dateFormat.format(cal.getTime());
                  
                  
                  int maximoTemporal = controladorProducto.consultarMaxFactura() +1;
                   int codigoventa=0;
                    for (int i=0; i<miListaVenta.size(); i++) {
                        vendidos=  vendidos +  daoProducto2.registrarVenta (maximoTemporal, miListaVenta.get(i).getCodigo(), miListaVenta.get(i).getCantidad(), fecha);
                        daoProducto2.modificarCantidadProducto(miListaVenta.get(i).getCodigo(), 
                               miListaVenta.get(i).getCantidad());
                        
                        
             
             }
                    if (vendidos == miListaVenta.size()){
JOptionPane.showMessageDialog(null, "La venta se Registro Correctamente en el sistema"); 
  resultado=0;
                             etiquetaResultado.setText("$ "  + resultado);
                             campoPrecioAct.setText("");
                    }
           miListaTemporal.clear();  
              miListaVenta.clear(); 
               construirTablaVenta();        
               construirTabla(2,campoBusqueda.getText());
                     
              }
              
              
           
             
         }
         
         
          
         private void   botonCancelarVentaActionPerformed( ActionEvent evt ){
             if ( miListaVenta.isEmpty()){
                 
                     resultado=0;
                             etiquetaResultado.setText("$ "  + resultado);
                             campoPrecioAct.setText("");
            JOptionPane.showMessageDialog(null, "Actualmente no hay ningun articulo agregado a esta venta, por lo tanto no hay venta para cancelar"
                    );      
                 
                 
             } else {
                        if (JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cancelar esta venta?", "Confirmar Accion",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                           
                            resultado=0;
                             etiquetaResultado.setText("$ "  + resultado);
                             campoPrecioAct.setText("");
                           
                        
              miListaTemporal.clear();  
              miListaVenta.clear(); 
              totalLabel.setText("$ " + moneyString);   
               construirTablaVenta();        
               construirTabla(2,campoBusqueda.getText());
                
} else {

}
             }
        
          
                     
             
         }
         
         
         
        
        private void botonBuscarActionPerformed( ActionEvent evt ){
			
                           construirTabla(2,campoBusqueda.getText());
		}
        
        
        
        
    
        
        
        
        
        
        
        
        
        
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
			controladorProducto.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			dispose();		
		}
        
        
        
        
        
}

