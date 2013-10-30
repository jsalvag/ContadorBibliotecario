
package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteca {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Lista l = new Lista();
        String op;
        boolean salir;
        
        do{
            System.out.println("--------------------------------");
            System.out.println("--------------MENU--------------");
            System.out.println("--------------------------------");
            System.out.println("1.-Ingresar ninos.");
            System.out.println("2.-Ver lista de ninos.");
            System.out.println("3.-Generar orden de lectura.");
            System.out.println("4.-Ver lista por orden de lectura.");
            System.out.println("5.-Salir");
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
                    l.contarB();
                    salir = false;
                    break;
                case "4":
                    l.mostrarB();
                    salir = false;
                    break;
                case "5":
                    salir = true;
                    break;
                default :
                    System.out.println("Opcion invalida...");
                    salir = false;
            }
        }while(!salir);
    }
}
