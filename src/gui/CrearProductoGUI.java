package gui;
/**
 * @author juan diego ordonnez
 */

import controlador.ControladorProducto;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;




import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;



public class CrearProductoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoNombre;
	private JTextField CampoCategoria;
	private JTextField campoNumero;
	private JTextField CampoCuidad;
        private JTextField CampoCantidad, CampoPrecioProveedor,CampoPrecioVenta;
	private JButton btnCrear;
        private JLabel Imagen;
//          private JFrame frame;
  private JTextField txtPath;
	
	ControladorProducto controladorProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProductoGUI frame1 = new CrearProductoGUI();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearProductoGUI() {
            controladorProducto   = new ControladorProducto();
		setResizable(false);
		setTitle("Agregar nuevo producto:");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 50,500, 660);
             
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLosNuevos = new JLabel("Ingrese los datos del nuevo producto:");
		lblIngreseLosNuevos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIngreseLosNuevos.setBounds(10, 8, 342, 30);
		contentPane.add(lblIngreseLosNuevos);
		
		JLabel lblNombreProducto = new JLabel("Nombre producto:");
		lblNombreProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreProducto.setBounds(42, 70, 116, 30);
		contentPane.add(lblNombreProducto);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoria.setBounds(42, 107, 116, 30);
		contentPane.add(lblCategoria);
		
		JLabel lblCodigoProducto = new JLabel("Codigo:");
		lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigoProducto.setBounds(42, 143, 116, 30);
		contentPane.add(lblCodigoProducto);
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImagen.setBounds(42, 176, 116, 30);
		contentPane.add(lblImagen);
                
                
                JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(42, 365, 116, 30);
		contentPane.add(lblCantidad);
                
                CampoCantidad = new JTextField();
		CampoCantidad.setBounds(168, 367, 100, 20);
		contentPane.add(CampoCantidad);
		CampoCantidad.setColumns(10);
                
                
                
                JLabel lblProveedor = new JLabel("Precio proveedor:");
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProveedor.setBounds(42, 399, 116, 30);
		contentPane.add(lblProveedor);
                
                
		CampoPrecioProveedor = new JTextField();
		CampoPrecioProveedor.setBounds(168, 402, 100, 20);
		contentPane.add(CampoPrecioProveedor);
		CampoPrecioProveedor.setColumns(10);
		
                
                
                
                 JLabel lblVenta = new JLabel("Precio venta:");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVenta.setBounds(42, 435, 116, 30);
		contentPane.add(lblVenta);
                
                
                
		CampoPrecioVenta = new JTextField();
		CampoPrecioVenta.setBounds(168, 437, 100, 20);
		contentPane.add(CampoPrecioVenta );
		CampoPrecioVenta.setColumns(10);
		
                
                
		campoNombre = new JTextField();
		campoNombre.setBounds(168, 75, 100, 20);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
		
		CampoCategoria = new JTextField("");
		CampoCategoria.setBounds(168, 112, 100, 20);
		contentPane.add(CampoCategoria);
		CampoCategoria.setColumns(10);
		
		int num = controladorProducto.consultarMaxProducto();
		
		campoNumero = new JTextField();
		campoNumero.setText(""+(num+1));
		campoNumero.setEnabled(false);
		campoNumero.setBounds(168, 148, 100, 20);
		contentPane.add(campoNumero);
		campoNumero.setColumns(10);
//		 JOptionPane.showMessageDialog(null, "codigo=" + campoNumero.getText(), "Producto creado", JOptionPane.WARNING_MESSAGE);
		CampoCuidad = new JTextField("asdas");
		CampoCuidad.setBounds(168, 182, 100, 20);
//		contentPane.add(CampoCuidad);
		CampoCuidad.setColumns(10);
		
		 Imagen = new JLabel();
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/noimagen.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(130, -1, Image.SCALE_DEFAULT));
		Imagen.setIcon(temp);
		Imagen.setSize(new Dimension(130, 130));
		Imagen.setPreferredSize(new Dimension(130, 130));
		Imagen.setBounds(153, 212, 130, 130);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	        Imagen.setBorder(border);
		contentPane.add(Imagen);
                
                
                  txtPath = new JTextField();
    txtPath.setBounds(168, 182, 100, 20);
    contentPane.add(txtPath);
    txtPath.setColumns(10);
		
    JButton btnBrowse = new JButton("Examinar...");
//    setBounds(168, 182, 100, 20);
    btnBrowse.setBounds(280, 180, 100, 23);
    contentPane.add(btnBrowse);
		
    btnBrowse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG", "jpg", "gif", "png");
        fileChooser.setFileFilter(filter);

        
        
        // For Directory
//        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // For File
        //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.setAcceptAllFileFilterUsed(false);

        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
          txtPath.setText(fileChooser.getSelectedFile().toString());
          
       ImageIcon imageIcon = new ImageIcon(new ImageIcon(txtPath.getText()).getImage().getScaledInstance(130,130, Image.SCALE_DEFAULT));
       Imagen.setIcon(imageIcon);    
          
        
        }
      }
    });
                
                
                
                
                
                
                
                
                
                
		
		btnCrear = new JButton("Crear");
		btnCrear.setEnabled(true);
		btnCrear.setMnemonic('A');
		btnCrear.setBackground(new Color(59, 154, 131));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCrearActionPerformed(evt);
			}
		});
		btnCrear.setBounds(20, 550, 116, 34);
		contentPane.add(btnCrear);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('n');
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(186, 0, 22));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		btnCancelar.setBounds(168, 550, 121, 34);
		contentPane.add(btnCancelar);
		
		JButton btnConsultar = new JButton("Consultar");
	
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(0, 0, 0));
		btnConsultar.setMnemonic('C');
//		btnConsultar.setBounds(168, 227, 121, 34);
		contentPane.add(btnConsultar);
		
		JLabel lblNota = new JLabel("Nota: llene todos los datos requeridos.");
		lblNota.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNota.setBounds(10, 49, 342, 14);
		contentPane.add(lblNota);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		dispose();
	}
        public static boolean isNumeric(String str) {
		
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
        
    }
	
	        
//         insertarProducto( String nombre, String categoria, String imagen, int codigo,
//                int cantidad, double precioProveedor, double precioVenta )
	
	//Metodo que se encarga del evento del boton Crear
	private void botonCrearActionPerformed( ActionEvent evt ){
            
		String nombre, categoria, imagen;
                int cantidad = 0, codigo =0;
                double precioProveedor = 0, precioVenta= 0;
		
                nombre = campoNombre.getText();
		categoria = CampoCategoria.getText();
                imagen = txtPath.getText();
            
                codigo = Integer.parseInt(campoNumero.getText());
                if ((CampoCantidad.getText().equals("")==false)) {
                     cantidad = Integer.parseInt(CampoCantidad.getText()); 
                }
              
                  if ((CampoPrecioProveedor.getText().equals("")==false)) {
                      precioProveedor = Integer.parseInt(CampoPrecioProveedor.getText());
                  }
		if ((CampoPrecioVenta.getText().equals("")==false)) {
                precioVenta = Integer.parseInt(CampoPrecioVenta.getText());
		 }
// 	JOptionPane.showMessageDialog(null,""+ nombre + direccion + numeroSede + imagen);
		if ( campoNombre.getText().equals("") || CampoCantidad.getText().equals("") ||
				CampoPrecioProveedor.getText().equals("") || CampoPrecioVenta.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
		} else {
		int numFilas = controladorProducto.insertarProducto(nombre, categoria, imagen, codigo,
                         cantidad,precioProveedor,precioVenta);
               if(numFilas>0) {
		 JOptionPane.showMessageDialog(null, "El producto ha sido creado.", "Producto creado", JOptionPane.WARNING_MESSAGE);
		 dispose();
                }
		}
		
	}
	
	//

}