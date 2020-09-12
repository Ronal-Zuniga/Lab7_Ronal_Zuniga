
package lab.pkg7_ronalzuniga;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminEmpleados {
    private ArrayList <Empleado> e = new ArrayList();
    private File archivo = null;

    public adminEmpleados(String path) {
        archivo = new File(path);
    }

    public ArrayList<Empleado> getE() {
        return e;
    }

    public void setE(ArrayList<Empleado> e) {
        this.e = e;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setEmpleado(Empleado em){
        this.e.add(em);
    }
    
    public void cargarArchivo() {
        try {            
            e = new ArrayList();
            Empleado temp;
            if (archivo.exists()) {
                  FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Empleado) objeto.readObject()) != null) {
                        e.add(temp);
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
            for (Empleado t : e) {
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
