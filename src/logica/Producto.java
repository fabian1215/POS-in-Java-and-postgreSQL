/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


public class Producto {
	
	String nombre, categoria,imagen;
	
 double precioProveedor, precioVenta;
	int  cantidad,codigo;
	//Constructor
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para conseguir el nombre del usuario
	public String getNombre(){
		return nombre;
	}
        public int getCodigo(){
		return codigo;
	}
        
            public int getCantidad(){
		return cantidad;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public String getImagen(){
		return imagen;
	}
	
	public double getPrecioProveedor()  {
           return precioProveedor; 
        }
        
        public double getPrecioVenta()  {
           return precioVenta; 
        }
          
        
         public int GetCantidad()  {
           return cantidad; 
        }
                
	
	
	//Metodo para asignar el nombre del usuario
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	//Metodo para asignar el apellido del usuario
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	//Metodo para asignar la cedula del usuario
	public void setImagen(String imagen){
		this.imagen = imagen;
	}
	
	//Metodo para asignar la contrasenna del usuario
	public void setPrecioProveedor(double precioProveedor){
		this.precioProveedor = precioProveedor;
	}
	
	public void setPrecioVenta(double precioVenta){
		this.precioVenta = precioVenta;
	}
	//Metodo para asignar el telefono del usuario
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
        public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	

}//Fin de la clase Usuario
