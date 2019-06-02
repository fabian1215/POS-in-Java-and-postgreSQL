/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
/**
 * @author juan diego ordonnez
 */

import accesoDatos.DaoProducto;
import com.toedter.calendar.JDateChooser;
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
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class VerReportesGUI  extends JFrame {
    private JPanel contentPane;
    DaoProducto daoProducto = new DaoProducto();
    private JDateChooser campoFechaInsc,campoFechaFinal;
    private String fecha, fechaFinal;
     private JLabel totalLabel,numeroVentas,numeroGanancias,numeroCapital;
     private double total,ganancias,capital;
     private int ventas;
     private NumberFormat formatter;
         private String totalString,ventasString,ganaciasString,capitalString;
         private JButton botonBuscar,botonCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerReportesGUI frame = new VerReportesGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    
    public VerReportesGUI() {
              total=0;
              ventas=0;
              ganancias=0;
              capital=0;
               setResizable(false);
        botonBuscar = new JButton();
        botonCancelar = new JButton();
        formatter = NumberFormat.getInstance();
         botonCancelar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
               botonCancelarActionPerformed(evt);

      			}
      		});
        totalString = formatter.format(total);
        
        ventasString = (""+ventas);
            ganaciasString  = formatter.format(ganancias);
          capitalString    = formatter.format(capital);
        
        campoFechaInsc = new JDateChooser();
        campoFechaInsc.setDateFormatString("yyyy-MM-d");
        campoFechaInsc.setBounds(110, 23, 120, 20);
       
        
        campoFechaFinal = new JDateChooser();
        campoFechaFinal.setDateFormatString("yyyy-MM-d");
        campoFechaFinal.setBounds(330, 23, 120, 20);
    
        
        
        
        
        
        
        
        
        String formato = campoFechaInsc.getDateFormatString();
		Date date = (Date) campoFechaInsc.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
	if(campoFechaInsc.getDate() != null){
            fecha = String.valueOf(sdf.format(date));
        }
		else{
  
    fecha="";
}
        
        
        
         String formato2 = campoFechaFinal.getDateFormatString();
		Date date2 = (Date) campoFechaFinal.getDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat(formato2);
	if(campoFechaFinal.getDate() != null){
            fechaFinal = String.valueOf(sdf.format(date2));
           
        }
		else{
  
    fechaFinal="";
}
        
        
        
        
        
                
        
        
//        
//		daoProducto.consultarCapitalPorFecha("2018-02-01", "2018-07-03");
//                 JOptionPane.showMessageDialog(null, "capital por fecha" + daoProducto.consultarCapitalPorFecha("2018-02-01", "2018-07-03")
//                    );  
//                 
//                 
//                 
//                  JOptionPane.showMessageDialog(null, "total por fecha " + daoProducto.consultarTotalPorFecha("2018-02-01", "2018-07-03")
//                    );  
//                  
//                  
//                   JOptionPane.showMessageDialog(null, "Ganancia por fecha " + daoProducto.consultarGananciaPorFecha("2018-02-01", "2018-07-03")
//                    );  
		setResizable(true);
		setTitle("Ver Reportes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setPreferredSize(new Dimension(770,560));
		setBounds(200, 90, 770,590);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 JLabel background1 = new JLabel(new ImageIcon("src/imagen/reporteventas.png"));
                 background1.setBounds(0, 0, 770,560);
           contentPane.add(campoFechaInsc);  
           contentPane.add(campoFechaFinal);
           
           
           
           
           
          totalLabel = new JLabel("$ " + totalString);
              totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
          totalLabel.setBounds(114, 156, 400, 20);
      
          contentPane.add(totalLabel);
          
        numeroVentas = new JLabel(" " + ventasString);
          numeroVentas.setFont(new Font("Arial", Font.BOLD, 18));
         numeroVentas.setBounds(165, 207, 400, 20);
         
        contentPane.add( numeroVentas);
        
        
          numeroGanancias  =  new JLabel("$ " +  ganaciasString);   
          
          numeroGanancias.setFont(new Font("Arial", Font.BOLD, 18));
         numeroGanancias.setBounds(200,323, 400, 20);
         
        contentPane.add(numeroGanancias);
          
          
          
                 
        
            numeroCapital =  new JLabel("$ " +  capitalString);   
        
            numeroCapital.setFont(new Font("Arial", Font.BOLD, 18));
        numeroCapital.setBounds(200,273, 400, 20);
         
        contentPane.add(numeroCapital);
          
          
                     botonBuscar.setBounds(492,10, 60, 46);
                     botonBuscar.setContentAreaFilled(false);
                     botonBuscar.setBorder(new EmptyBorder(5, 5, 5, 5));
                      botonBuscar.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt) {
               botonBuscarActionPerformed(evt);

      			}
      		});
                     
           contentPane.add(botonBuscar);
           
           
           
           
            botonCancelar.setBounds(55,470, 83, 60);
                     botonCancelar.setContentAreaFilled(false);
                     botonCancelar.setBorder(new EmptyBorder(5, 5, 5, 5));
                     
           contentPane.add(botonCancelar);
           
           
           
           
		contentPane.add(background1);
                
                
                
                
                
                
                 
                 int width = contentPane.getSize().width;
		int height = contentPane.getSize().height;
                 
                }
    
     private void botonBuscarActionPerformed( ActionEvent evt ){
	     String formato2 = campoFechaFinal.getDateFormatString();
		Date date2 = (Date) campoFechaFinal.getDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat(formato2);
	if(campoFechaFinal.getDate() != null){
            fechaFinal = String.valueOf(sdf2.format(date2));
//             JOptionPane.showMessageDialog(null, ""+fechaFinal+"");
        }
		else{
  
    fechaFinal="";
}
        
        
                String formato = campoFechaInsc.getDateFormatString();
		Date date = (Date) campoFechaInsc.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
	if(campoFechaInsc.getDate() != null){
            fecha = String.valueOf(sdf.format(date));
        }
		else{
  
    fecha="";
}
         
         
         if (fecha.equals("")==false && fechaFinal.equals("") ==false) {
     if    ( daoProducto.consultarCapitalPorFecha(fecha, fechaFinal) !=null) {
         
         capital= Double.parseDouble(daoProducto.consultarCapitalPorFecha(fecha, fechaFinal));
            capitalString    = formatter.format(capital);
        
            numeroCapital.setText ("$ " +  capitalString);   
            
            
            
            
            ganancias= Double.parseDouble(daoProducto.consultarGananciaPorFecha(fecha, fechaFinal));
              ganaciasString    = formatter.format(ganancias);
        
            numeroGanancias.setText ("$ " +  ganaciasString);   
            
            
            
            
             total= Double.parseDouble(daoProducto.consultarTotalPorFecha(fecha, fechaFinal));
              totalString    = formatter.format(total);
        
            totalLabel.setText ("$ " +  totalString);   
            
            
     
                    
                    
                       ventas= Integer.parseInt(daoProducto.consultarVentasPorFecha(fecha, fechaFinal));
                                   ventasString = (""+ventas);

            numeroVentas.setText (" " +  ventasString);   
            
     } else {
            ventas=0;
             capital=0;
             ganancias=0;
             total=0;
             
               totalLabel.setText ("$ " +  total);   
             numeroGanancias.setText ("$ " +  ganancias); 
              numeroCapital.setText ("$ " +  capital);   
             numeroVentas.setText (" " +  ventas);   
     }
     
     
       
          totalString = formatter.format(total);
        
        ventasString = (""+ventas);
        ganaciasString  = formatter.format(ganancias);
        capitalString    = formatter.format(capital);
          
          
         } else {
             
             ventas=0;
             capital=0;
             ganancias=0;
             total=0;
             
               totalLabel.setText ("$ " +  total);   
             numeroGanancias.setText ("$ " +  ganancias); 
              numeroCapital.setText ("$ " +  capital);   
             numeroVentas.setText (" " +  ventas);   
            
              JOptionPane.showMessageDialog(null, "Por favor seleccione un intervalo de tiempo valido");
         }
         
       
          
          
          
          
		}
        
    private void botonCancelarActionPerformed( ActionEvent evt ){
			daoProducto.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			dispose();		
		}
    
}
