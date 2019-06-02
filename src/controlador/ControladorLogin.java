package controlador;

/**
 * 
 * @author juan diego
 *
 */

import java.util.Vector;

import accesoDatos.*;
import logica.*;

public class ControladorLogin {
	
	DaoLogin daoLogin;

	public ControladorLogin() {
		// TODO Auto-generated constructor stub
		daoLogin = new DaoLogin();
	}
	
	public Login consultarLogin(String nick, String contra){
		Vector v = new Vector();
		
		Login l = new Login();
		
		System.out.println("Se va a consultar un Usuario");
		
		l = daoLogin.consultarLogin(nick,contra);
		
		return l;
		
	}
	
	public void cerrarConexionBD(){
        daoLogin.cerrarConexionBD();
    }

}
