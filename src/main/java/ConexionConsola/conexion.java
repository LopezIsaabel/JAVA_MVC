/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionConsola;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author izabe
 */
public class conexion {
     Connection con;
    String url="jdbc:mysql://localhost:3306/colegio";
    String user="root";
    String pass="";
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
           
        } catch (Exception e) {
            System.err.println("Error");
            System.out.println(e);
        }      
        return con;
}
}
