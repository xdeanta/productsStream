package productsStream;

import java.io.*;
/**
 * @author Xavier
 */
public class ArchManager {

    public static void escribirArchivo(File ent, Product p){
        File f;
        DataOutputStream sal=null;
        try {
            sal = new DataOutputStream(new FileOutputStream(ent));
            sal.writeUTF(p.getCodigo());
            sal.writeUTF(p.getDescripcion());
            sal.writeDouble(p.getPrecio());
        }catch(IOException e){
            System.out.println("hubo un error al abrir el archivo");
        }finally {
            try {
                if (sal != null) {
                    sal.close();
                }
            } catch (IOException e2) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }

    public static void agregarArchivo(File ent, Product p){
        DataOutputStream sal=null;
        try {
            sal = new DataOutputStream(new FileOutputStream(ent,true));
            sal.writeUTF(p.getCodigo());
            sal.writeUTF(p.getDescripcion());
            sal.writeDouble(p.getPrecio());
        }catch(IOException e){
            System.out.println("hubo un error al abrir el archivo");
        }finally {
            try {
                if (sal != null) {
                    sal.close();
                }
            } catch (IOException e2) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }

    public static void leerArchivo(DataInputStream ent, Product p){
        try {
            if(ent.available() != 0){
                p.setCodigo(ent.readUTF());
                p.setDescripcion(ent.readUTF());
                p.setPrecio(ent.readDouble());
            }
        }catch(IOException e){
            System.out.println("hubo un error al abrir el archivo");
        }
    }
}
