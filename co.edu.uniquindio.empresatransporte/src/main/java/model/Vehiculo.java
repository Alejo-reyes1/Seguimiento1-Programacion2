package model;

import java.util.ArrayList;

public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private String numeroChasis;
    private ArrayList<Propietario> propietariosAsociados;
    private Propietario propietarioPrincipal;

    public Vehiculo(String placa, String modelo, String marca, String color, String numeroChasis) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.numeroChasis = numeroChasis;
        this.propietariosAsociados=new ArrayList<>();
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getNumeroChasis() {
        return numeroChasis;
    }
    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }
    public Propietario getPropietarioPrincipal() {
        return propietarioPrincipal;
    }
    public void setPropietarioPrincipal(Propietario propietarioPrincipal) {
        this.propietarioPrincipal = propietarioPrincipal;
    }
    public ArrayList<Propietario> getPropietariosAsociados() {
        return propietariosAsociados;
    }
    public void setPropietariosAsociados(ArrayList<Propietario> propietariosAsociados) {
        this.propietariosAsociados = propietariosAsociados;
    }
    public void asociarPropietario(Propietario p) {
        this.propietariosAsociados.add(p);
    }

}
