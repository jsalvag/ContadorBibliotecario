package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class nodo{
    String nom, ape, cole;
    int turno;
    nodo sig, ante;
}

public class Lista {
    nodo L, aux, aux2, ult, contB1, contB2, orden;
    int cant, t;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Manejador ar = new Manejador();
    
    public Lista(){
        L=null;
        cant=0;
        orden=null;
        t=0;
        ar.crear();
        
    }
    
    void llenar() throws IOException{
        int[] n = ar.leerNum();
        int a = n[0];
        for(int i=0;i<a;i++){
            nodo nv = new nodo();
            System.out.println("Ingrese los datos del niño");
            System.out.print("Nombre: ");
            nv.nom=br.readLine();
            System.out.print("Apellido: ");
            nv.ape=br.readLine();
            System.out.print("Colegio: ");
            nv.cole=br.readLine();
            nv.turno=0;
            nv.ante=null;
            nv.sig=null;

            if(L==null){
                L=nv;
            }else{
                aux=L;
                while(aux.sig!=null){
                    aux=aux.sig;
                }
                nodo ant=aux;
                aux.sig=nv;
                nv.ante=ant;
            }

            ult=nv;
            System.out.println("Ultimo: "+ult.nom);
            cant++;
        }
        
    }
    
    void mostrar(){
        if(L!=null){
            aux=L;
            String data="";

            while((aux.sig!=null)&&(aux.sig!=L)){
                data += "\nNombre: "+aux.nom+"\nApellido: "+aux.ape+"\nColegio: "+aux.cole+"\n--------------------------------";
                aux=aux.sig;
            }
            data += "\nNombre: "+aux.nom+"\nApellido: "+aux.ape+"\nColegio: "+aux.cole+"\n--------------------------------";
            System.out.println("Lista de niños para la lectura\n--------------------------------"+data);

            ult = aux;
            System.out.println("L->"+L.nom);
            System.out.println("Ult->"+ult.nom);
        }else{
            System.err.println("Lista vacia...");
        }
    }
    
    void circular(){
        if(L!=null){
            aux=L;
            ult.sig = aux;
            aux.ante =ult;
            System.out.println("Lista circular completada.");
            System.out.println("L-->"+L.nom+" -- ante: "+L.ante.nom+" -- sig: "+L.sig.nom);
            System.out.println("Ult-->"+ult.nom+" -- ante: "+ult.ante.nom+" -- sig: "+ult.sig.nom);
        }else{
            System.err.println("Lista esta vacia...");
        }
        
    }
    
    void buscar() throws IOException{
        if(L!=null){
            aux=L;
            String nomb;
            System.out.print("Nombre a buscar: ");
            nomb=br.readLine();
            while((!nomb.equals(aux.nom))&&(aux.sig!=L)){
                aux=aux.sig;
            }
            if(nomb.equals(aux.nom)){
                System.out.println("Nombre: "+aux.nom);
                System.out.println("Apellido: "+aux.ape);
                System.out.println("Colegio: "+aux.cole);
            }else{
                System.err.println("No se encontro el nombre...");
            }
        }else{
            System.err.println("Lista vacia...");
        }
    }
    
    void eliminar() throws IOException{
        if(L!=null){
            aux=L;
            nodo temSig, temAnt;
            String nomb;
            System.out.print("Nombre a eliminar: ");
            nomb=br.readLine();
            if(nomb.equals(L.nom)){
                L=aux.sig;
            }
            while((!nomb.equals(aux.nom))&&(aux.sig!=L)){
                aux=aux.sig;
            }
            if(nomb.equals(aux.nom)){
                temSig = aux.sig;
                temAnt = aux.ante;

                if((temAnt!=L)&&(temSig!=L)){
                    temSig.ante = temAnt;
                    temAnt.sig = temSig;
                }else{
                    L=null;
                }
            }else{
                System.err.println("No se encontro el nombre...");
            }
            cant--;
        }else{
            System.err.println("Lista vacia...");
        }
    }
    
    void contarB() throws IOException{
        circular();
        int[] n = ar.leerNum();
        int a = n[1];
        int b = n[2];
        
        contB1=L;
        contB2=L;
        
        while(L!=null){
            
            for(int i=0;i<a;i++){
                contB1=contB1.sig;
            }
            for(int i=0;i<b;i++){
                contB2=contB2.ante;
            }
            if(contB1==contB2){
                t++;
                insertar(contB1,t);
                contB1=contB1.sig;
                contB2=contB2.ante;
                eliminarB(contB1.ante);
            }else{
                t++;
                insertar(contB1,t);
                contB1=contB1.sig;
                eliminarB(contB1.ante);
                
                insertar(contB2,t);
                contB2=contB2.sig;
                eliminarB(contB2.ante);
                
            }
        }
    }
    
    void eliminarB(nodo nomb){
        if(L!=null){
            aux=L;
            while(aux!=nomb){
                aux=aux.sig;
            }
            nodo ant,sig;
            if(nomb==L){
                L=L.sig;
            }
            if((aux.sig!=aux)&&(aux.ante!=aux)){
                ant = aux.ante;
                sig = aux.sig;
                ant.sig = sig;
                sig.ante = ant;
            }else{
                L=null;
            }
        }else{
            System.out.println("Lista vacia...");
        }
    }
    
    void mostrarB(){
        if(orden!=null){
            aux=orden;
            String data="";

            while((aux.sig!=null)&&(aux.sig!=orden)){
                data += "\nTurno #"+aux.turno+"\nNombre: "+aux.nom+"\nApellido: "+aux.ape+"\nColegio: "+aux.cole+"\n--------------------------------";
                aux=aux.sig;
            }
            data += "\nTurno #"+aux.turno+"\nNombre: "+aux.nom+"\nApellido: "+aux.ape+"\nColegio: "+aux.cole+"\n--------------------------------";
            System.out.println("Lista de niños para la lectura\n--------------------------------"+data);
        }else{
            System.err.println("Lista para orden de lactura vacia...");
        }
    }

    void insertar(nodo temp, int turno) {
        nodo nuevo = new nodo();
        
        nuevo.nom = temp.nom;
        nuevo.ape = temp.ape;
        nuevo.cole = temp.cole;
        nuevo.turno = turno;
        nuevo.sig = null;
        nuevo.ante = null;
        
        aux2=orden;
        
        if(aux2!=null){
            while(aux2.sig!=null){
                aux2=aux2.sig;
            }
            aux2.sig=nuevo;
        }else{
            orden=nuevo;
        }
    }
}
