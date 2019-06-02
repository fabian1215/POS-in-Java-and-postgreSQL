package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import logica.*;
import logica.Evento;

public class DaoProveedor {
	
	FachadaBD fachada;

	public DaoProveedor() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	public int guardarEvento( Evento p ){
		String sql_guardar;
        int numFilas=0;
        
        sql_guardar="INSERT INTO proveedor VALUES ('" +
                p.getNombre() + "', '" + p.getCiudad() + "', '" + 
        		p.getDescripcion() + "', '" + p.getDireccion() +  "', '" + p.getTelefono() + "')";
        
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
	}//Fin del metodo guardar
	
        public int ModificarProveedor(String nombre, String ciudad, String descripcion, String direccion, String telefono){
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE proveedor set ciudad='" + ciudad + "', descripcion='" + descripcion +
				"', direccion='" + direccion + "', telefono='" + telefono + "' WHERE nombre='"+ nombre +"'";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_modificar);
			System.out.println("up " + numeroFilas);
			conn.close();
			return numeroFilas;
		} catch ( SQLException e){
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		
		return -1;
	}
        
        
        public Evento consultarProveedor( String nombre ){
		Evento u = new Evento();
		String sql_select;
		
		sql_select="SELECT nombre, ciudad, descripcion, direccion, telefono FROM  proveedor WHERE nombre = '" + nombre + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
        	
            while(tabla.next()){
            	u.setNombre(tabla.getString(1));
                u.setCiudad(tabla.getString(2));
                u.setDescripcion(tabla.getString(3));
            	u.setDireccion(tabla.getString(4));
            	u.setTelefono(tabla.getString(5));
            	
            	
            	System.out.println("ok");
            }
            //return u;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return u;
	}
        
        public String ListarProveedor(){
		Evento u = new Evento();
		String sql_select;
	
		String listaNombre="";
                String listaCiudad="";
                String listaDescripcion="";
		String listaDireccion="";
		String listaTelefono="";
			String listaFinal="";
		sql_select="SELECT nombre, ciudad, descripcion, direccion, telefono FROM  proveedor ";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	listaNombre= tabla.getString("nombre");
                listaCiudad= tabla.getString( "ciudad");
                listaDescripcion = tabla.getString("descripcion");
                listaDireccion= tabla.getString( "direccion");
           	 listaTelefono = tabla.getString("telefono");
           	 listaFinal= " " + listaFinal +"<TR>" + "<TD>" +listaNombre+  "</TD>"+  "<TD>" +listaCiudad+  "</TD>" + "<TD>" + listaDescripcion  +  "</TD>" +   "   "+  "<TD>" + listaDireccion +  "</TD>"+"<TD>" + listaTelefono +  "</TD>"+ "</TR>"+ "<br>";
            }
            return listaFinal; 
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		
		catch(Exception e){ System.out.println(e); }
        return null;
	}
        
       public String consultarListaEventos(){
		
		String sql_select;
		
	       String nombreEvento="";
		String listaEventos="";
		sql_select="SELECT nombre  FROM  evento";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	nombreEvento= tabla.getString("nombre");
              
           	 	
           	 listaEventos= listaEventos + nombreEvento+  ",";
            }
            return listaEventos; 
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		
		catch(Exception e){ System.out.println(e); }
        return null;
	}
       
        
        
   	
//-------------------------------------------------------------------------------------------
	
	
	
	//----------------------------------------------------------------------------------------------------------
	
	
        
        public ArrayList<Evento> consultarEventoConMatriz(){
		
		String sql_select;
		
		ArrayList<Evento> miLista = new ArrayList<Evento>();
		
		Evento u;
		
		sql_select="SELECT nombre, ciudad, descripcion, direccion , telefono FROM proveedor ";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
          
            while(tabla.next()){
            	u = new Evento();
            	u.setNombre(tabla.getString("nombre"));
                u.setCiudad(tabla.getString("ciudad"));
                u.setDescripcion(tabla.getString("descripcion"));
                u.setDireccion(tabla.getString("direccion"));
                  u.setTelefono(tabla.getString("telefono"));   
            	
            	
            	
               
            	miLista.add(u);
            }
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return miLista;
	}
		
        
        
        
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

        
        
        
    public static void main(String[] args) {
        
        
       
       DaoProveedor  dao = new DaoProveedor();
      
        
   System.out.println(dao.consultarListaEventos());
        
    }
}
