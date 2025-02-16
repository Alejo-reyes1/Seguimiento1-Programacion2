package model;

import java.util.ArrayList;

public class VehiculoTransporte extends Vehiculo {
    private int maximoPasajeros;
    private ArrayList<Usuario> usuarioAsociados;

    public VehiculoTransporte(String placa, String modelo, String marca, String color, String numeroChasis,
                              int maximoPasajeros) {
        super(placa, modelo, marca, color, numeroChasis);
        this.maximoPasajeros = maximoPasajeros;
        this.usuarioAsociados=new ArrayList<>();
    }

    public int getMaximoPasajeros() {
        return maximoPasajeros;
    }

    public void setMaximoPasajeros(int maximoPasajeros) {
        this.maximoPasajeros = maximoPasajeros;
    }
    public int calcularPasajerosTransportados() {
        int pasajerosTransportados=this.usuarioAsociados.size();
        return pasajerosTransportados+1;
    }
    public void asociarUsuarioPasajero(Usuario u) {
        this.usuarioAsociados.add(u);
    }
}
