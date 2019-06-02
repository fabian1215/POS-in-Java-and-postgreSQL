package controlador;

import logica.Usuario;
import accesoDatos.DaoUsuario;

/**
 * 
 * @author juan diego ordonnez
 *
 */

public class ControladorUsuario {
	
	DaoUsuario daoUsuario;

	//Constructor
	public ControladorUsuario() {
		// TODO Auto-generated constructor stub
		daoUsuario = new DaoUsuario();
	}
	
	//Metodo que se encarga de Insentar los datos del Usuario en la base de datos
	public int insertarUsuario( String nombre, String apellido, String cedula, String nick, String contrasenna,
			String telefono, String tipo, String estado, String email ){
		
		Usuario u = new Usuario();
		
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setCedula(cedula);
		u.setNick(nick);
		u.setContrasenna(contrasenna);
		u.setTelefono(telefono);
		u.setTipo(tipo);
		u.setEstado(estado);
		u.setEmail(email);
		
		//Se llama al dao para guardar
		System.out.println("Se va a insertar un Usuario");
		
		int result = daoUsuario.guardarUsuario(u);
		
		System.out.println("Se inserto un nuevo Usuario");
		
		return result;
	}//Fin del metodo guardar
	
	//Metodo que se encarga de Modificar los datos del Usuario en la base de datos
	public int modificarUsuario( String nombre, String apellido,String cedula, String contrasenna,
			String telefono, String estado, String email ){
		
		//se llama al dao para modificar
		System.out.println("Se va a modificar un Usuario");
		
		int result = daoUsuario.modificarUsuario(nombre, apellido, cedula, contrasenna, telefono,  estado, email);
		
		System.out.println("Se modifico el Usuario");
		
		return result;
	}//Fin del metodo modificar
	
	//Metodo que se encarga de Consultar los datos de un Usuario
	public Usuario consultarUsuario( String cedula ){
		
		Usuario u = new Usuario();
		
		System.out.println("Se va a consultar un Usuario");
		
		//Se llama al dao para consultar
		u = daoUsuario.consultarUsuario(cedula);
		
		return u;
		
	}//Fin del metodo consultar
	
        
        
      public Usuario usuarioPorNombre ( String nick ){
		
		Usuario u = new Usuario();
		
		System.out.println("Se va a consultar un Usuario");
		
		//Se llama al dao para consultar
		u = daoUsuario.usuarioPorNombre(nick);
		
		return u;
		
	}  
        
        
        
	//Metodo que se encarga de Listar todos los usuarios del sistema
	public String ListarUsuario(){
		String resultado="";
		
		System.out.println("Se va a listar los Usuario");
		
		//Se llama al dao para listar
		resultado = daoUsuario.listarUsuario();
		
		return resultado;
	}
	
	//Metodo para cerrar la conexion con la base de datos
	public void cerrarConexionBD(){
        daoUsuario.cerrarConexionBD();
    }

}
