/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD11_10;

import ConexionConsola.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author izabe
 */
public class crud_funcion {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();
   
    public void listar() {
        String sql = "select * from alumnos";
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("************************");
                System.out.println("Codigo:" + rs.getInt(1));
                System.out.println("Nombre:" + rs.getString(2));
                System.out.println("Cantidad:" + rs.getInt(3));
                System.out.println("Lugar de fabricacion: " + rs.getString(4));
                System.out.println("Fecha: " + rs.getString(5));

            }
        } catch (Exception e) {
        }
    }
    
    
        public void crear(int codigo, String nombre, int cantidad, String lugar, String fecha) {
        String sql = "insert into alumnos(codigo, nombre,cantidad, lugar, fecha) values(?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, cantidad);
            ps.setString(4, lugar);
            ps.setString(5, fecha);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error");
            System.out.println(e);
        }

    }
        
         public void modificar(int codigo, String nombre, int cantidad, String lugar, String fecha) {
        String sql = "update alumnos set nombre=?, cantidad=?, lugar=?, fecha=? where codigo=?";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setString(3, lugar);
            ps.setString(4, fecha);
            ps.setInt(5, codigo);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
          public void eliminar(int codigo) {
        String sql = "Delete from productos where codigo=" + codigo + ";";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
}
