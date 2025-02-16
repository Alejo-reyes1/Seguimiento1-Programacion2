package model;

import java.util.ArrayList;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;
    private ArrayList<Usuario> usuariosAsociados;

    public VehiculoCarga(String placa, String modelo, String marca, String color, String numeroChasis,
                         double capacidadCarga, int numeroEjes) {
        super(placa, modelo, marca, color, numeroChasis);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
        this.setUsuariosAsociados(new ArrayList<>());
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public ArrayList<Usuario> getUsuariosAsociados() {
        return usuariosAsociados;
    }

    public void setUsuariosAsociados(ArrayList<Usuario> usuariosAsociados) {
        this.usuariosAsociados = usuariosAsociados;
    }
}
