
package lab.pkg7_ronalzuniga;

import java.util.ArrayList;

public class Empleado extends Persona{
    private ArrayList <Carro> lavar;

    public Empleado() {
        super();
    }

    public Empleado(ArrayList<Carro> lavar, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.lavar = lavar;
    }

    public ArrayList<Carro> getLavar() {
        return lavar;
    }

    public void setLavar(ArrayList<Carro> lavar) {
        this.lavar = lavar;
    }

    @Override
    public String toString() {
        return "Empleado{" + "lavar=" + lavar + '}';
    }
    
    
}
