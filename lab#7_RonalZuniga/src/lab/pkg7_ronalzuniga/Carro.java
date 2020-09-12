
package lab.pkg7_ronalzuniga;

import java.io.Serializable;

public class Carro implements Serializable{
    private int placa;
    private String size;
    private int puertas;
    private int nivelsucio;

    public Carro() {
    }

    public Carro(int placa, String size, int puertas, int nivelsucio) {
        this.placa = placa;
        this.size = size;
        this.puertas = puertas;
        this.nivelsucio = nivelsucio;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getNivelsucio() {
        return nivelsucio;
    }

    public void setNivelsucio(int nivelsucio) {
        this.nivelsucio = nivelsucio;
    }

    @Override
    public String toString() {
        return Integer.toString(placa);
    }
    
}
