package accesoDatos;

/**
 * 
 * @author juan diego ordo�ez
 * @version 20 octubre
 *
 */

import java.sql.*;

public class FachadaBD {
	
	String url, usuario, password;
	Connection conexion = null;
	Statement instrucion;
	ResultSet tabla;

	/**
	 * Constructor
	 * Se le asignan los valores para hacer la conexi�n a la base de datos
	 */
	public FachadaBD() {
		// TODO Auto-generated constructor stub
	url = "jdbc:postgresql://localhost:5432/postgres";
	usuario = "postgres";
	password = "102030naval";
	
	}
	
	public Connection conectar(){
		try {
			//Se carga el drive
			Class.forName("org.postgresql.Driver");
			
		} catch ( Exception e) {
			System.out.println( "No se pudo cargar el driver" );
		}
		
		try {
			//Crear el objeto de de conexion a la base de datos
			conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println( "Conexion Abierta" );
			
			return conexion;
		} catch ( Exception e ) {
			System.out.println( "No se pudo abrir la base de datos" );
                        
    e.printStackTrace();
			return null;
		}
	}//Fin del metodo conectar
	
	public Connection getConnetion(){
		if (conexion == null){
			return this.conectar();
		} 
		else{
			return conexion;
		}
	}
	
	public void closeConection (Connection c){
		try{
			if (conexion!=null){
				c.close();
                                
			} 
		} catch (Exception e){
			System.out.println("No se pudo cerrar");
		}
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		FachadaBD aplicacion = new FachadaBD();
		aplicacion.conectar();
	}

}//Fin de la clase Fachada
