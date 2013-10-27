package biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Manejador {
    PrintWriter pf;
    FileReader fr;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    void crear(){ 
        try{
            pf = new PrintWriter(new FileWriter("contadores.txt",true));
            pf.close();
            System.out.println("Archivo contadores.txt se genero o existe...");
        }catch (Exception e){
            System.out.println("Error en creacion de archivo.\nError: "+e);
        }
    }
    
    int[] leerNum() throws IOException{
        int[] num = new int[3];
        
        fr = new FileReader("contadores.txt");
        BufferedReader brf = new BufferedReader(fr);
        String linea;
        while((linea = brf.readLine())!=null){
            String[] datos = linea.split("-");
            
            if (datos.length==1){
                return num=null;
            }else{
                num[0]=Integer.parseInt(datos[0]);
                num[1]=Integer.parseInt(datos[1]);
                num[2]=Integer.parseInt(datos[2]);
            }
        }
        
        return num;
    }
    
}
