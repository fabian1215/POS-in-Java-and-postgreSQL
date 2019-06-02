package controlador;

import javax.swing.JOptionPane;

import accesoDatos.DaoProveedor;

import logica.Evento;

import logica.Usuario;


public class ControladorProveedor {
	
	DaoProveedor daoProveedor;

	public ControladorProveedor() {
		// TODO Auto-generated constructor stub
		daoProveedor= new DaoProveedor();
	}
	//-------------------------------------------------------------------------------------------
	
        
        
        
        public int insertarEvento( String nombre, String ciudad, String descripcion, String direccion ,String telefono){
		Evento p = new Evento();
		
		p.setNombre(nombre);
		p.setCiudad(ciudad);
		p.setDescripcion(descripcion);
		p.setDireccion(direccion);
                p.setTelefono(telefono);
		
		//Se llama al dao para guardar
        System.out.println("Se va a insertar un Proveedor");
        
        int result = daoProveedor.guardarEvento(p);

        System.out.println("Se inserto un nuevo Proveedor");
        
        return result;
	}
        
        
        public int ModificarProveedor( String nombre, String ciudad, String descripcion, String direccion, String telefono ){
		
		//se llama al dao para modificar
		System.out.println("Se va a modificar un Proveedor");
		
		int result = daoProveedor.ModificarProveedor(nombre, ciudad, descripcion, direccion, telefono);
                
		
		System.out.println("Se modifico el Proveedor");
		
		return result;
	}//Fin del metodo modificar
        
        public Evento consultarProveedor( String nombre ){
		
		Evento u = new Evento();
		
		System.out.println("Se va a consultar un Usuario");
		
		//Se llama al dao para consultar
		u = daoProveedor.consultarProveedor(nombre);
		
		return u;
		
	}
        
        
	public String ListarProveedor(){
		String resultado="";
		
		System.out.println("Se va a listar los Proveedores");
		
		//Se llama al dao para listar
		resultado = daoProveedor.ListarProveedor();
		
		return resultado;
	}
	

	//-------------------------------------------------------------------------------------------

	//Metodo para cerrar la conexion
	public void cerrarConexionBD(){
        daoProveedor.cerrarConexionBD();
	}
	//-------------------------------------------------------------------------------------------

}
