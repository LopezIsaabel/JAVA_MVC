/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionConsola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author izabe
 */
public class colegioDao {

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
                System.out.println("*********");
                System.out.println("Codigo:" + rs.getInt(1));
                System.out.println("Nombre:" + rs.getString(2));
                System.out.println("Direccion: " + rs.getString(3));
                System.out.println("Telefono: " + rs.getInt(4));

            }
        } catch (Exception e) {
        }
    }

    public void crear(int codigo, String nombre, String direccion, int telefono) {
        String sql = "insert into alumnos(codigo, nombre, direccion, telefono) values(?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error");
            System.out.println(e);
        }

    }

    public void modificar(int codigo, String nombre, String direccion, int telefono) {
        String sql = "update alumnos set nombre=?, direccion=?, telefono=? where codigo=?";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            ps.setInt(4, codigo);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void eliminar(int codigo) {
        String sql = "Delete from alumnos where codigo=" + codigo + ";";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void buscar(int codigo){
    String sql="select * from alumnos where codigo= "+codigo;
        try {
            con= acceso.Conectar();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            if (rs.next()) {                
                
            }else{
                System.out.println("Nombre: "+rs.getString(2));
            }
        } catch (Exception e) {
        }
    }
    
   
    public static void main(String[] args) {
        colegioDao cl = new colegioDao();
        cl.listar();
        System.out.println("//////////////////");
        cl.eliminar(2);
        //cl.modificar(2, "Jorge", "Quiche", 47259836);

        //cl.crear(2, "James", "Santa Rosa", 345269875);
        cl.listar();
    }
}
