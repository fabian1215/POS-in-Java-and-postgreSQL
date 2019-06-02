package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelAdministradorGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdministradorGUI frame = new PanelAdministradorGUI();
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
	public PanelAdministradorGUI() {
              
        
		setResizable(false);
		setTitle("Panel De  Usuario Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setPreferredSize(new Dimension(960,560));
		setBounds(100,100, 960,560);
		contentPane = new JPanel();
//		contentPane.setBackground(new Color(0, 51, 204));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
              
		contentPane.setLayout(null);
		 JLabel background1 = new JLabel(new ImageIcon("src/imagen/panelregistrar.png"));
                 background1.setBounds(0, 0, 960,560);
		JLabel lblNewLabel = new JLabel("Gestion de Usuarios:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(52, 22, 246, 21);
//		contentPane.add(lblNewLabel);
	
		JButton btnCrearUsuario = new JButton();
		btnCrearUsuario.setMnemonic('C');
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCrearUsuarioActionPerformed(evt);
			}
		});
		btnCrearUsuario.setForeground(new Color(255, 255, 255));
		btnCrearUsuario.setBackground(new Color(0, 0, 0));
		btnCrearUsuario.setBounds(162, 135, 180, 32);
                   btnCrearUsuario.setOpaque(false);
btnCrearUsuario.setContentAreaFilled(false);
		contentPane.add(btnCrearUsuario);
		
		JButton btnModificarUsuario = new JButton();
		btnModificarUsuario.setMnemonic('M');
		btnModificarUsuario.setBackground(new Color(0, 0, 0));
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonModificarUsuarioActionPerformed(evt);
			}
		});
                
                 btnModificarUsuario.setOpaque(false);
btnModificarUsuario.setContentAreaFilled(false);
		btnModificarUsuario.setForeground(new Color(255, 255, 255));
		btnModificarUsuario.setBounds(162, 176, 180, 32);
		contentPane.add(btnModificarUsuario);
                
                
                		JButton btnAgregarProducto = new JButton();
                                btnAgregarProducto.setMnemonic('O');
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAgregarProductoActionPerformed(evt);
			}
		});
                                
btnAgregarProducto.setForeground(new Color(255, 255, 255));
btnAgregarProducto.setBackground(new Color(0, 0, 0));
		btnAgregarProducto.setBounds(152, 365, 180, 32);
                   btnAgregarProducto.setOpaque(false);
btnAgregarProducto.setContentAreaFilled(false);
              contentPane.add(btnAgregarProducto);
              
              
              
              JButton btnModificarProducto = new JButton();
                btnModificarProducto.setOpaque(false);
btnModificarProducto.setContentAreaFilled(false);
btnModificarProducto.setForeground(new Color(255, 255, 255));
		btnModificarProducto.setBounds(155, 405, 180, 32);
                btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnModificarProductoActionPerformed(evt);
			}
		});
              contentPane.add(btnModificarProducto);
              
              
              JButton btnVerProducto = new JButton();
                                btnVerProducto.setMnemonic('O');
		btnVerProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnVerProductoActionPerformed(evt);
			}
		});
                                
btnVerProducto.setForeground(new Color(255, 255, 255));
btnVerProducto.setBackground(new Color(0, 0, 0));
		btnVerProducto.setBounds(155, 445, 180, 32);
                   btnVerProducto.setOpaque(false);
btnVerProducto.setContentAreaFilled(false);
              contentPane.add(btnVerProducto);
              
            
              
              
              
              JButton btnAgregarProvedor = new JButton();
              btnAgregarProvedor.setMnemonic('L');
		btnAgregarProvedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAgregarProvedorActionPerformed(evt);
			}
		});
                btnAgregarProvedor.setOpaque(false);
btnAgregarProvedor.setContentAreaFilled(false);
btnAgregarProvedor.setForeground(new Color(255, 255, 255));
		btnAgregarProvedor.setBounds(430, 135, 180, 32);
              contentPane.add(btnAgregarProvedor);
              
              JButton btnModificarProvedor = new JButton();
               btnModificarProvedor.setMnemonic('L');
		btnModificarProvedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnModificarProvedorActionPerformed(evt);
			}
		});
                btnModificarProvedor.setOpaque(false);
btnModificarProvedor.setContentAreaFilled(false);
btnModificarProvedor.setForeground(new Color(255, 255, 255));
		btnModificarProvedor.setBounds(430, 174, 180, 32);
              contentPane.add(btnModificarProvedor);
              
              JButton btnVerProvedores = new JButton();
               btnVerProvedores.setMnemonic('L');
		btnVerProvedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnVerProvedoresActionPerformed(evt);
			}
		});
                btnVerProvedores.setOpaque(false);
btnVerProvedores.setContentAreaFilled(false);
btnVerProvedores.setForeground(new Color(255, 255, 255));
		btnVerProvedores.setBounds(430, 215, 180, 32);
              contentPane.add(btnVerProvedores);
              
              JButton btnVerReportes = new JButton();
                 btnVerReportes.setMnemonic('O');
		btnVerReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnVerReportesActionPerformed(evt);
			}
		});
                btnVerReportes.setOpaque(false);
btnVerReportes.setContentAreaFilled(false);
btnVerReportes.setForeground(new Color(255, 255, 255));
btnVerReportes.setBounds(430, 363, 180, 32);
              contentPane.add(btnVerReportes);
              
            
             JButton btnRegistrarVenta = new JButton();
               
		btnRegistrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnRegistrarVentaActionPerformed(evt);
			}
		});
                
                
                
                
                btnRegistrarVenta.setOpaque(false);
btnRegistrarVenta.setContentAreaFilled(false);
btnRegistrarVenta.setForeground(new Color(255, 255, 255));
		btnRegistrarVenta.setBounds(430, 404, 180, 32);
              contentPane.add(btnRegistrarVenta);   
              
              
              
              
              
              
              
		
		JButton btnVerUsuario = new JButton();
                  btnVerUsuario.setOpaque(false);
btnVerUsuario.setContentAreaFilled(false);
		btnVerUsuario.setMnemonic('V');
		btnVerUsuario.setForeground(new Color(255, 255, 255));
		btnVerUsuario.setBackground(new Color(0, 0, 0));
		btnVerUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonVerUsuarioActionPerformed(evt);
			}
		});
		btnVerUsuario.setBounds(162, 215, 180, 32);
		contentPane.add(btnVerUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		btnSalir.setMnemonic('S');
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setBounds(115, 217, 96, 23);
//		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/41f9B0mX7fL.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(140, -1, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(temp);
		lblNewLabel_1.setSize(new Dimension(140, 150));
		lblNewLabel_1.setPreferredSize(new Dimension(140, 140));
		lblNewLabel_1.setBounds(261, 65, 140, 140);
//		contentPane.add(lblNewLabel_1);
                contentPane.setOpaque(true);
                background1.setOpaque(true);
                   contentPane.add(background1);
	}
	
	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCrearUsuarioActionPerformed( ActionEvent evt ){
		CrearUsuarioGUI aplicacion1 = new CrearUsuarioGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		
		aplicacion1.setVisible(true);
		dispose();
	}
        
        	//Metodo que se encarga del evento del boton Cancelar
	private void btnRegistrarVentaActionPerformed( ActionEvent evt ){
		RegistrarVentaGUI aplicacion1 = new RegistrarVentaGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		
		aplicacion1.setVisible(true);
		dispose();
	}
        
        
        
        
        
	
        
        private void btnAgregarProvedorActionPerformed( ActionEvent evt ){
		CrearEventoGUI aplicacion1 = new CrearEventoGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		
		aplicacion1.setVisible(true);
		dispose();
	}
        
         private void btnModificarProvedorActionPerformed( ActionEvent evt ){
		ModificarProveedor aplicacion1 = new ModificarProveedor(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		
		aplicacion1.setVisible(true);
		dispose();
	}
        
        
	//Metodo que se encarga del evento del boton Cancelar
	private void botonModificarUsuarioActionPerformed( ActionEvent evt ){
		ModificarUsuarioGUI aplicacion1 = new ModificarUsuarioGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}
	
	//Metodo que se encarga del evento del boton VerUsuario
	private void botonVerUsuarioActionPerformed(ActionEvent evt){
		ListarUsuarioGUI aplicacion1 = new ListarUsuarioGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}
        
        	private void btnVerProvedoresActionPerformed(ActionEvent evt){
		ListarProveedorGUI aplicacion1 = new ListarProveedorGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}
                
                
                	private void btnAgregarProductoActionPerformed(ActionEvent evt){
		CrearProductoGUI aplicacion1 = new CrearProductoGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}
                        
                  	private void btnVerProductoActionPerformed(ActionEvent evt){
		UltimoverProductosGUI aplicacion1 = new UltimoverProductosGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}       
                        
                        
               private void btnModificarProductoActionPerformed(ActionEvent evt){
		ModificarProductoGUI aplicacion3 = new ModificarProductoGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion3.setVisible(true);
		dispose();
	}           
                        
                        
                        
                        
                        
         
                      	private void btnVerReportesActionPerformed(ActionEvent evt){
		VerReportesGUI aplicacion1 = new VerReportesGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}             
               
                        
}
