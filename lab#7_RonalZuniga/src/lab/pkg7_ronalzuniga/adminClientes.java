
package lab.pkg7_ronalzuniga;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminClientes {
    private ArrayList <Cliente> c = new ArrayList();
    private File archivo = null;

    public adminClientes(String path) {
        archivo = new File(path);
    }

    public ArrayList<Cliente> getC() {
        return c;
    }

    public void setC(ArrayList<Cliente> c) {
        this.c = c;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setCliente(Cliente cl){
        this.c.add(cl);
    }
    public void cargarArchivo() {
        try {            
            c = new ArrayList();
            Cliente temp;
            if (archivo.exists()) {
                  FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Cliente) objeto.readObject()) != null) {
                        c.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            } //fin if           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Cliente t : c) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
}
