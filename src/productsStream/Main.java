

package productsStream;

import java.io.*;

/**
 * @author Xavier
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        DataInputStream ent=null;
        File f=new File("productos.txt");
        Product p1 = new Product("cod1","parafusos",3);
        Product p2 = new Product("cod2","cravos",4);
        Product p3 = new Product();
        ArchManager.escribirArchivo(f,p1);
        ArchManager.agregarArchivo(f,p2);
        try {
            ent = new DataInputStream(new FileInputStream(f));
        }catch (IOException e){
            System.out.println("Error al abrir el archivo");
        }
        System.out.println("Lista de productos en el fichero productos.txt:");
        try {
            do {
                ArchManager.leerArchivo(ent, p3);
                System.out.println(p3.getCodigo() + ", " + p3.getDescripcion() + ", " + p3.getPrecio());
            } while (ent.available() != 0);
            if(ent.available() == 0){
                ent.close();
            }
        }catch (IOException e2){
            System.out.println("Error al operar con el archivo");
        }

    }
}
