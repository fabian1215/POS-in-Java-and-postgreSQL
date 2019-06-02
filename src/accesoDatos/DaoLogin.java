package accesoDatos;

/**
 * 
 * @author juan diego
 *
 */

import java.sql.*;
import javax.swing.JOptionPane;
import logica.*;

public class DaoLogin {
	
	FachadaBD fachada;

	public DaoLogin() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	public Login consultarLogin(String nick, String contra){
		Login l = new Login();
		String sql_select;
		
		sql_select="SELECT nick, contrasenna, tipo FROM " +
				"usuario WHERE nick='" + nick +  "'" + " AND "+ "contrasenna='" + contra + "'";
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	l.setNick(tabla.getString(1));
            	l.setContrasenna(tabla.getString(2));
            	l.setTipo(tabla.getString(3));
            	
            	System.out.println("ok");
            }
            return l;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return null;
	}
	
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }//Metodo cerrar conexion

}
