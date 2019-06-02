/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.*;
import logica.Producto;

/**
 *
 * @author Fabian
 */
public class ControladorProducto {
    DaoProducto daoProducto;
    
    
    
    public ControladorProducto() {
		// TODO Auto-generated constructor stub
		daoProducto= new DaoProducto();
	}
    
    
    //Metodo que se encarga de Insentar los datos del Usuario en la base de datos
	public int insertarProducto( String nombre, String categoria, String imagen, int codigo,
                int cantidad, double precioProveedor, double precioVenta ){
		
		Producto u = new Producto();
		
		u.setNombre(nombre);
		u.setCategoria(categoria);
		u.setImagen(imagen);
		u.setCodigo(codigo);
                System.out.println("codigo en insertar producto: "+codigo);
		u.setCantidad(cantidad);
		u.setPrecioProveedor(precioProveedor);
		u.setPrecioVenta(precioVenta);
		
		
		//Se llama al dao para guardar
		System.out.println("Se va a insertar un Producto");
		
		int result = daoProducto.guardarProducto(u);
		
		System.out.println("Se inserto un nuevo Producto");
		
		return result;
	}//Fin del metodo guardar
    
    
   	public int consultarMaxProducto(){
		int result = 0;
		String result_string;
		
		result_string = daoProducto.consultarMaxProducto();
                if (result_string == null) {
                    result = 9;
                }
                else {
                    System.out.println("consulta maximo: " +result_string);
		result = Integer.parseInt(result_string);
                }
		
		
		
		return result;
	} 
        
        
        public int consultarMaxFactura(){
		int result = 0;
		String result_string;
		
		result_string = daoProducto.consultarMaxFactura();
                if (result_string == null) {
                    result = 9;
                }
                else {
                    System.out.println("consulta maximo: " +result_string);
		result = Integer.parseInt(result_string);
                }
		
		
		
		return result;
	} 
        
        
        
        public int modificarProducto( String nombre, String categoria, String imagen, int codigo,
                int cantidad, double precioProveedor, double precioVenta ){
		
		//se llama al dao para modificar
		System.out.println("Se va a modificar un ´Producto");
		
		int result = daoProducto.modificarProducto(nombre, categoria, imagen, codigo, cantidad,  precioProveedor,precioVenta);
		
		System.out.println("Se modifico el Producto");
		
		return result;
	}//Fin del metodo modificar
	
     public Producto consultarProducto( int codigo ){
		
		Producto u = new Producto();
		
		System.out.println("Se va a consultar un Producto");
		
		//Se llama al dao para consultar
		u = daoProducto.consultarProducto(codigo);
		
		return u;
		
	}//Fin del metodo consultar
	   
        
   public void cerrarConexionBD(){
        daoProducto.cerrarConexionBD();
    } 
}
