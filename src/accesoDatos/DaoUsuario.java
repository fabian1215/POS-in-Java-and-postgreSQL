package accesoDatos;
/**
 * 
 * @author juan diego ordonnez
 *
 */

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import logica.*;

public class DaoUsuario {
	
	FachadaBD fachada;

	public DaoUsuario() {
             fachada = new FachadaBD();
		// TODO Auto-generated constructor stub
		
	}
	
	//Metodo encargado de guardar los datos del Usuario en la base de datos
	public int guardarUsuario( Usuario u ){
		String sql_guardar;
		int numeroFilas = 0;
		
		sql_guardar = "INSERT INTO usuario VALUES ('"+
				u.getNombre() + "', '" + u.getApellido() +  "', '" +
				u.getCedula() + "', '" + u.getNick() + "', '" + u.getContrasenna() + "', '" + u.getTelefono() + "', '" + 
				u.getTipo() + "', '" + u.getEstado() + "', '" + u.getEmail() + "');";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_guardar); 
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
		
	}//Fin del m�todo guardar
	
	//Metodo encargado de Modificar los datos del Usuario en la base de datos
	public int modificarUsuario(String nombre, String apellido, String cedula, String contrasenna, String telefono,
			 String estado, String email){
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE usuario set nombre='" + nombre + "', apellido='" + apellido +
				"', contrasenna='" + contrasenna + "', telefono='" + telefono +
				"', estado='" + estado + "', email='" + email + "' WHERE cedula='"+ cedula +"'";
		
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
	}//Fin del metodo modificar
	
	//Metodo que se encarga de Consultar los datos de un Usario en la base de datos
	public Usuario consultarUsuario( String cedula ){
		Usuario u = new Usuario();
		String sql_select;
		
		sql_select="SELECT nombre, apellido, nick, contrasenna, telefono, tipo, estado, email FROM  usuario WHERE cedula = '" + cedula + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
        	
            while(tabla.next()){
            	u.setNombre(tabla.getString(1));
            	u.setApellido(tabla.getString(2));
            	u.setNick(tabla.getString(3));
            	u.setContrasenna(tabla.getString(4));
            	u.setTelefono(tabla.getString(5));
            	u.setTipo(tabla.getString(6));
            	u.setEstado(tabla.getString(7));
            	u.setEmail(tabla.getString(8));
            	
            	System.out.println("ok");
            }
            //return u;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return u;
	}
        
        
        
       public Usuario usuarioPorNombre( String nick ){
		Usuario u = new Usuario();
		String sql_select;
		
		sql_select="SELECT nombre, apellido,  contrasenna, telefono, tipo, estado, email, cedula FROM  usuario WHERE nick = '" + nick + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
        	
            while(tabla.next()){
               
            	u.setNombre(tabla.getString(1));
            	u.setApellido(tabla.getString(2));
            
            	u.setContrasenna(tabla.getString(3));
                	
            	u.setTelefono(tabla.getString(4));
               
            	
            	u.setEstado(tabla.getString(6));
            	u.setEmail(tabla.getString(7));
            	 u.setCedula(tabla.getString(8));
            	System.out.println("ok");
            }
            //return u;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return u;
	} 
        
        
        
        
	
	//Metodo que se encarga de Listar los Usuarios que estan registrados en el sistema
	public String listarUsuario(){
		Usuario u = new Usuario();
		String sql_select;
		
		String listaEmail="";
		String listaNick="";
		String listaFinal="";
		String listaTipo="";
		String listaEstado="";
		
		sql_select="SELECT nombre, apellido, nick, telefono, tipo, estado, email FROM  usuario ";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	listaNick= tabla.getString("nick");
                listaEmail= tabla.getString( "email");
                listaTipo= tabla.getString( "tipo");
           	 	listaEstado = tabla.getString("estado");
           	 	
           	 listaFinal= " " + listaFinal +"<TR>" + "<TD>" +listaNick+  "</TD>"+  "<TD>" +listaTipo+  "</TD>" + "<TD>" + listaEstado  +  "</TD>" +   "   "+  "<TD>" + listaEmail +  "</TD>"+ "</TR>"+ "<br>";
            }
            return listaFinal; 
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		
		catch(Exception e){ System.out.println(e); }
        return null;
	}
	
	//Metodo que se encarga de Consultar los Usuarios que estan registrados en el sistema
	public ArrayList<Usuario> consultarUsuarioConMatriz(){
		
		String sql_select;
		
		ArrayList<Usuario> miLista = new ArrayList<Usuario>();
		
		Usuario u;
		
		sql_select="SELECT nick, tipo, estado, email,nombre,apellido, cedula FROM usuario ";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
          
            while(tabla.next()){
            	u = new Usuario();
            	u.setNick(tabla.getString("nick"));
                u.setTipo(tabla.getString("tipo"));
                u.setEstado(tabla.getString("estado"));
            	u.setEmail(tabla.getString("email"));
                u.setCedula(tabla.getString("cedula"));
                u.setNombre(tabla.getString("nombre"));
                u.setApellido(tabla.getString("apellido"));
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
		
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
