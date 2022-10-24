/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD11_10;

import java.util.Scanner;

/**
 *
 * @author izabe
 */
public class menu {

    crud_funcion cr = new crud_funcion();
    Scanner sp = new Scanner(System.in);

    public void menu() {
        System.out.println("--------------");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Crear Productos ");
        System.out.println("3 Modificar Productos");
        System.out.println("4. Eliminar Productos");
        System.out.println("5. Salir");

        int uso = sp.nextInt();

        switch (uso) {
            case 1:
                System.out.println("******Productos existentes*****");
                cr.listar();
                break;
            case 2:
                Boolean salir = true;

                do {
                    Scanner sp2 = new Scanner(System.in);
                    System.out.println("Ingrese el codigo");
                    int codigo = sp.nextInt();
                    sp.nextLine();
                    System.out.println("Ingrese el nombre");
                    String nombre = sp.nextLine();
                    System.out.println("Ingrese la cantidad");
                    int cantidad = sp.nextInt();
                    sp.nextLine();
                    System.out.println("Ingrese el lugar de fabricacion");
                    String lugar = sp2.nextLine();
                    System.out.println("Ingrese fecha de ingreso");
                    String fecha = sp2.nextLine();

                    cr.crear(codigo, nombre, cantidad, lugar, fecha);

                    System.out.println("Deseas ingresar mas Productos?");
                    System.out.println("1 para continuar y 0 para salir");
                    if (sp2.nextInt() != 1) {
                        salir = false;
                    }
                } while (salir);

                break;
            case 3:
                System.out.println("******Productos existentes******");
                cr.listar();
                System.out.println("Ingrese el codigo del producto a modificar");
                int mdf = sp.nextInt();
                sp.nextLine();
                Scanner sp2 = new Scanner(System.in);

                System.out.println("Ingrese nombre del producto");
                String nombre = sp.nextLine();

                System.out.println("Ingrese cantidad de ingreso");
                int cantidad = sp2.nextInt();
                sp.nextLine();
                System.out.println("Ingrese lugar de fabricacion");
                String lugar = sp2.nextLine();

                System.out.println("Ingrese fecha de ingreso");
                String fecha = sp2.nextLine();

                cr.modificar(mdf, nombre, cantidad, lugar, fecha);
                break;
            case 4:
                System.out.println("******Productos existentes******");
                cr.listar();

                System.out.println("Ingrese el codigo del producto que desea eliminar");
                cr.eliminar(sp.nextInt());

                break;
            case 5:
                System.exit(0);
                break;

            default:
                throw new AssertionError();
        }

    }

    public static void main(String[] args) {
        menu m = new menu();
        while (true) {
            m.menu();
        }
    }
}
