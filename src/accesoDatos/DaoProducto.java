/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Usuario;
import logica.*;

/**
 *
 * @author Fabian
 */
public class DaoProducto {
 FachadaBD fachada;
 
 
    public DaoProducto() {
  fachada = new FachadaBD();
    }
   
    
    
    public int guardarProducto( Producto p){
		String sql_guardar;
		int numeroFilas = 0;
		System.out.println("codigo en guardar producto: "+p.getCodigo());
		sql_guardar = "INSERT INTO productos VALUES ('"+
				p.getNombre() + "', '" + p.getCategoria() +  "', '" +
				p.getImagen() + "', '" + p.getCodigo() + "', '" + p.getCantidad() + "', '" + p.getPrecioProveedor() + "', '" + 
				p.getPrecioVenta()  + "');";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_guardar); 
			System.out.println("up " + numeroFilas);
			conn.close();
			return numeroFilas;
			
		} catch ( SQLException e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		return -1;
		
	}
    
    
    
     public int registrarVenta (int codigoVenta, int codigoProducto, int cantidadVendida, String fecha){
		String sql_guardar;
		int numeroFilas = 0;
//		System.out.println("codigo en guardar producto: "+p.getCodigo());
		sql_guardar = "INSERT INTO ventas VALUES ('"+
				codigoVenta + "', '" + codigoProducto +  "', '" +
				cantidadVendida + "', '" + fecha +"');";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_guardar); 
			System.out.println("up " + numeroFilas);
//			conn.close();
			return numeroFilas;
			
		} catch ( SQLException e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		return -1;
		
	}
    
    public int modificarProducto(String nombre, String categoria, String imagen, int codigo, 
                                int cantidad, double precioProveedor,double precioVenta){
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE productos set nombre='" + nombre + "', categoria='" + categoria +
				"', imagen='" + imagen+ "', cantidad='" + cantidad +
				"', precioproveedor='" + precioProveedor + "', precioventa='" + precioVenta +"' WHERE codigo='"+ codigo +"'";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_modificar);
			System.out.println("up " + numeroFilas);
			conn.close();
			return numeroFilas;
		} catch ( SQLException e){
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		
		return -1;
	}//Fin del metodo modificar
    
    
    
    
    
    
       public int modificarCantidadProducto(int codigo, 
                                int cantidad) {
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE productos set cantidad="+"cantidad -" + cantidad +
				" WHERE codigo='"+ codigo +"'";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_modificar);
			System.out.println("up " + numeroFilas);
//			conn.close();
			return numeroFilas;
		} catch ( SQLException e){
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		
		return -1;
	}//Fin del metodo modificar
    
    
    
    
    
    public String consultarMaxProducto(){
		String resultado = "";
		String sql_select;
		
		sql_select="SELECT MAX(codigo) FROM  productos;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
    
    
    
    
    
    
    
    
    
    public String consultarGananciaPorFecha(String inicio, String fechafin){
		String resultado = "";
		String sql_select;
		
		sql_select="select SUM\n" +
"  ((precioventa*unidadesvendidas) - (precioproveedor*unidadesvendidas)) as ganancia\n" +
"from (SELECT  precioproveedor, codigoventa, nombre, unidadesvendidas,precioventa, fecha\n" +
"    FROM ventas v, productos p\n" +
"    WHERE p.codigo = v.codigo_producto and (fecha>= '" + inicio + "' and fecha <='"+fechafin+"') ) as foo;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
    
    
    
     public String consultarCapitalPorFecha(String inicio, String fechafin){
		String resultado = "";
		String sql_select;
		
		sql_select="select SUM\n" +
"  ((precioproveedor*unidadesvendidas)) as ganancia\n" +
"from (SELECT  precioproveedor, codigoventa, nombre, unidadesvendidas,precioventa, fecha\n" +
"    FROM ventas v, productos p\n" +
"    WHERE p.codigo = v.codigo_producto and (fecha>= '" + inicio + "' and fecha <='"+fechafin+"') ) as foo;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
     
     
     
     
       
    public String consultarTotalPorFecha(String inicio, String fechafin){
		String resultado = "";
		String sql_select;
		
		sql_select="select SUM\n" +
"  ((precioventa*unidadesvendidas)) as ganancia\n" +
"from (SELECT  precioproveedor, codigoventa, nombre, unidadesvendidas,precioventa, fecha\n" +
"    FROM ventas v, productos p\n" +
"    WHERE p.codigo = v.codigo_producto and (fecha>= '" + inicio + "' and fecha <='"+fechafin+"') ) as foo;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
    
    
    
    
        public String consultarVentasPorFecha(String inicio, String fechafin){
		String resultado = "";
		String sql_select;
		
		sql_select=" SELECT COUNT (foo)\n" +
"from (SELECT Distinct codigoventa,  fecha "+
"    FROM ventas v, productos p\n" +
"    WHERE p.codigo = v.codigo_producto and (fecha>= '" + inicio + "' and fecha <='"+fechafin+"') ) as foo;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       public String consultarMaxFactura(){
		String resultado = "";
		String sql_select;
		
		sql_select="SELECT MAX(codigoventa) FROM  ventas;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
       
       
       
       
       
          public String consultarCategorias(){
		String resultado = "";
		String sql_select;
		
		sql_select=" SELECT   DISTINCT categoria   FROM  productos;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	System.out.println("ok");
            	resultado = tabla.getString(1);
            	
            }
            //return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return resultado;
	}
    
       
       
           public ArrayList<Producto> consultarCategoriaConMatriz(){
		
		String sql_select;
		
		ArrayList<Producto> miLista = new ArrayList<Producto>();
		
		Producto u;
                Producto todo;	
                todo = new Producto();
                todo.setNombre("todo");

                
                sql_select="";
	
		sql_select=" SELECT   DISTINCT categoria   FROM  productos;";
                
               
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
          miLista.add(todo);
            while(tabla.next()){
            	u = new Producto();
            	
                u.setNombre(tabla.getString("categoria"));
        
            	miLista.add(u);
            }
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
                //cierra conexion para arreglar fallo de maximo en multiples conexiones
                //chequear con SELECT * FROM pg_stat_activity;
                fachada.closeConection(fachada.getConnetion());
		return miLista;
                
                
               
	}
       
       
       
       
       
       
       
       
       
       
    
    public Producto consultarProducto( int codigo ){
		Producto u = new Producto();
		String sql_select;
		
		sql_select="SELECT nombre, categoria, imagen, cantidad, precioproveedor, precioventa  FROM  productos WHERE codigo = '" + codigo + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
        	
            while(tabla.next()){
            	u.setNombre(tabla.getString(1));
            	u.setCategoria(tabla.getString(2));
            	u.setImagen(tabla.getString(3));
            	u.setCantidad(tabla.getInt(4));
            	u.setPrecioProveedor(tabla.getDouble(5));
            	u.setPrecioVenta(tabla.getDouble(6));
            	
            	
            	System.out.println("ok");
            }
            //return u;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return u;
	}
    
    
    public static boolean isNumeric(String str) {
		
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
        
    }
    public ArrayList<Producto> consultarProductoConMatriz(int tipo, String Busqueda){
		
		String sql_select;
		
		ArrayList<Producto> miLista = new ArrayList<Producto>();
		
		Producto u;
                sql_select="";
		if (tipo ==1) {
		sql_select="SELECT imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa FROM productos ";
                }
                if (tipo ==2) {
                    if  (isNumeric(Busqueda)) {
                 sql_select="SELECT imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa FROM productos "
                                + "WHERE codigo =" + Busqueda;	
                }
                    else {
                        sql_select="SELECT imagen, nombre, categoria,  codigo, cantidad, precioproveedor, precioventa FROM productos "
                                + "WHERE nombre ILIKE '%" + Busqueda + "%' or  categoria ILIKE '%" + Busqueda + "%'";   
                    }
                }
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
          
            while(tabla.next()){
            	u = new Producto();
            	u.setImagen(tabla.getString("imagen"));
                u.setNombre(tabla.getString("nombre"));
                u.setCategoria(tabla.getString("categoria"));
            	u.setCodigo(tabla.getInt("codigo"));
                u.setCantidad(tabla.getInt("cantidad"));
                u.setPrecioProveedor(tabla.getInt("precioproveedor"));
                u.setPrecioVenta(tabla.getInt("precioventa"));
            	miLista.add(u);
            }
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
                //cierra conexion para arreglar fallo de maximo en multiples conexiones
                //chequear con SELECT * FROM pg_stat_activity;
                fachada.closeConection(fachada.getConnetion());
		return miLista;
                
                
               
	}
    
    
   	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    } 
    
}
