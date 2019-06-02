package logica;

/**
 * 
 * @author juan diego
 *
 */

public class Login {
	
	String nick;
	String contrasenna;
	String tipo;

	//Constructor
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNick(){
		return nick;
	}
	
	public String getcontrasenna(){
		return contrasenna;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public void setNick(String nick){
		this.nick = nick;
	}
	
	public void setContrasenna(String contra){
		this.contrasenna = contra;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}

}//Fin de la clase Login
