package logica;
/**
 * 
 * @author juan diego ordonnez
 *
 */

public class Usuario {
	
	String nombre, apellido, cedula, nick;
	String contrasenna, telefono, tipo;
	String estado, email;
	
	//Constructor
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para conseguir el nombre del usuario
	public String getNombre(){
		return nombre;
	}
	
	//Metodo para conseguir el apellido del usuario
	public String getApellido(){
		return apellido;
	}
	
	//Metodo para conseguir la cedula del usuario
	public String getCedula(){
		return cedula;
	}
	
	//Metodo para conseguir el nick del usuario
		public String getNick(){
			return nick;
		}
	
	//Metodo para conseguir la contrasenna del usuario
	public String getContrasenna(){
		return contrasenna;
	}
	
	//Metodo para conseguir el telefono del usuario
	public String getTelefono(){
		return telefono;
	}
	
	//Metodo para conseguir el tipo del usuario
	public String getTipo(){
		return tipo;
	}
	
	//Metodo para conseguir el estado del usuario
	public String getEstado(){
		return estado;
	}
	
	//Metodo para conseguir el email del usuario
	public String getEmail(){
		return email;
	}
	
	//Metodo para asignar el nombre del usuario
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	//Metodo para asignar el apellido del usuario
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	
	//Metodo para asignar la cedula del usuario
	public void setCedula(String cedula){
		this.cedula = cedula;
	}
	
	//Metodo para asignar la contrasenna del usuario
	public void setContrasenna(String contrasenna){
		this.contrasenna = contrasenna;
	}
	
	//Metodo para asignar el nick del usuario
		public void setNick(String nick){
			this.nick = nick;
		}
	
	//Metodo para asignar el telefono del usuario
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	
	//Metodo para asignar el tipo del usuario
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	//Metodo para asignar el estado del usuario
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	//Metodo para asignar el email del usuario
	public void setEmail(String email){
		this.email = email;
	}

}//Fin de la clase Usuario
