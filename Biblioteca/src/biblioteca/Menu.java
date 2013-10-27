package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    
    
    void menu() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Lista l = new Lista();
        String op;
        boolean salir;
        
        do{
        System.out.println("--------------------------------");
        System.out.println("--------------MENU--------------");
        System.out.println("--------------------------------");
        System.out.println("1.-Ingresar niño.");
        System.out.println("2.-Ver lista de niños.");
        System.out.println("3.-Buscar.");
        System.out.println("4.-Borrar.");
        System.out.println("5.-Circular.");
        System.out.println("6.-Generar orden de lectura.");
        System.out.println(".-Ver lista por orden de lectura.");
        System.out.println("7.-Salir");
        System.out.println("--------------------------------");
        op=br.readLine();
        
        switch(op){
            case "1":
                l.llenar();
                salir = false;
                break;
            case "2":
                l.mostrar();
                salir = false;
                break;
            case "3":
                l.buscar();
                salir = false;
                break;
            case "4":
                l.eliminar();
                salir = false;
                break;
            case "5":
                l.circular();
                salir = false;
                break;
            case "6":
                l.contarB();
                l.mostrarB();
                salir = false;
                break;
            case "7":
                salir = true;
                break;
            default :
                System.out.println("Opcion invalida...");
                salir = false;
        }
        
        }while(!salir);
        
        
    }
}
