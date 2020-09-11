package lab.pkg7_ronalzuniga;

import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class adminBarra1 extends Thread {

    private JProgressBar barra;
    private JTable tabla;
    private int limite;
    private ArrayList<Carro> c;
    private boolean vive;

    public adminBarra1(JProgressBar barra, JTable tabla, int limite, ArrayList<Carro> c) {
        this.barra = barra;
        this.tabla = tabla;
        this.limite = limite;
        this.c = c;
        vive = true;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public ArrayList<Carro> getC() {
        return c;
    }

    public void setC(ArrayList<Carro> c) {
        this.c = c;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    @Override
    public void run() {
        double t = 0;
        while (vive) {
            for (int i = 0; i < limite; i++) {
                barra.setValue(0);
                while (barra.getValue() <= 100) {
                    barra.setValue(barra.getValue() + 1);
                }
                Carro cr = c.get(i);
                if (cr.getSize().equals("Pequeño")) {
                    t = 1.5 * cr.getNivelsucio();
                }
                if (cr.getSize().equals("Mediano")) {
                    t = 1.8 * cr.getNivelsucio();
                }
                if (cr.getSize().equals("Grande")) {
                    t = 2.2 * cr.getNivelsucio();
                }

                Object[] o = {
                    cr.getPlaca(),
                    cr.getSize(),
                    cr.getNivelsucio(),
                    t
                };
                DefaultTableModel md = (DefaultTableModel) tabla.getModel();
                md.addRow(o);
                tabla.setModel(md);
                if (i == limite) {
                    vive = false;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }

}
