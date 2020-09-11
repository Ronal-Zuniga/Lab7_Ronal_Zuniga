
package lab.pkg7_ronalzuniga;

import java.util.ArrayList;

public class Cliente extends Persona{
    private ArrayList <Carro> carro_cliente;

    public Cliente() {
        super();
    }

    public Cliente(ArrayList<Carro> carro_cliente, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.carro_cliente = carro_cliente;
    }

    public ArrayList<Carro> getCarro_cliente() {
        return carro_cliente;
    }

    public void setCarro_cliente(ArrayList<Carro> carro_cliente) {
        this.carro_cliente = carro_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "carro_cliente=" + carro_cliente + '}';
    }
    
}
