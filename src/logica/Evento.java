package logica;

public class Evento {
        String nombre ,ciudad, descripcion, direccion , telefono;
	
	public Evento() {
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
        public void setCiudad(String ciudad){
		this.ciudad = ciudad;
	}
        
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	
	
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	
	public String getNombre(){
		return nombre;
	}
	
       public String getCiudad(){
	return ciudad;
	}
        
       	
	public String getDescripcion(){
		return descripcion;
	}
	
       
	public String getDireccion(){
		return direccion;
	}
	


	public String getTelefono(){
		return telefono;
	}

}
