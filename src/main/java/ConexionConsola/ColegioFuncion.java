/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionConsola;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author izabe
 */
public class ColegioFuncion {

    Scanner sp = new Scanner(System.in);
    colegioDao cl = new colegioDao();

    public void menu() {
        System.out.println("--------------");
        System.out.println("1. Mostrar Alumnos");
        System.out.println("2. Crear Alumnos ");
        System.out.println("3 Modificar Alumnos");
        System.out.println("4. Eliminar Alumnos");
        System.out.println("5. Salir");

        int uso = sp.nextInt();

        switch (uso) {
            case 1:
                System.out.println("------Todos los alumnos ingresados-------");
                cl.listar();
                break;
            case 2:
                Boolean salir = true;

                do {
                    Scanner sp2 = new Scanner(System.in);
                    System.out.println("Ingrese su codigo");
                    int codigo = sp.nextInt();
                    sp.nextLine();
                    System.out.println("Ingrese su nombre");
                    String nombre = sp.nextLine();
                    System.out.println("Ingrese su direccion");
                    String direccion = sp2.nextLine();
                    System.out.println("Ingrese su telefono");
                    int telefono = sp2.nextInt();

                    cl.crear(codigo, nombre, direccion, telefono);

                    System.out.println("Desea ingresar mas Alumnos?");
                    System.out.println("Ingresa 1 para continuar y 0 para salir");
                    if (sp2.nextInt() != 1) {
                        salir = false;
                    }
                } while (salir);

                break;
            case 3:
                System.out.println("------Todos los alumnos ingresados-------");
                cl.listar();
                System.out.println("Ingrese el codigo del alumno a modificar");
                int seleccion = sp.nextInt();
                sp.nextLine();
                Scanner sp2 = new Scanner(System.in);

                System.out.println("Ingrese su nombre");
                String nombre = sp.nextLine();

                System.out.println("Ingrese su direccion");
                String direccion = sp2.nextLine();

                System.out.println("Ingrese su telefono");
                int telefono = sp2.nextInt();

                cl.modificar(seleccion, nombre, direccion, telefono);
                break;
            case 4:
                System.out.println("------Todos los alumnos ingresados-------");
                cl.listar();

                System.out.println("Ingrese el codigo del alumno a eliminar");
                cl.eliminar(sp.nextInt());

                break;
            case 5:
                System.exit(0);
                break;

            default:
                throw new AssertionError();
        }

    }



    public static void main(String[] args) {
        ColegioFuncion cf = new ColegioFuncion();
        while (true) {
            cf.menu();
        }
    }
}
