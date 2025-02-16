package model;

import java.util.ArrayList;

public class Propietario {
    private String nombre;
    private String cedula;
    private String email;
    private String edad;
    private String celular;
    private ArrayList<Vehiculo> vehiculosAsociados;
    private Vehiculo vehiculoPrincipal;

    public Propietario(String nombre, String cedula, String email, String edad, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.edad = edad;
        this.celular = celular;
        this.vehiculosAsociados=new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public ArrayList<Vehiculo> getVehiculosAsociados() {
        return vehiculosAsociados;
    }
    public void setVehiculosAsociados(ArrayList<Vehiculo> vehiculosAsociados) {
        this.vehiculosAsociados = vehiculosAsociados;
    }
    public Vehiculo getVehiculoPrincipal() {
        return vehiculoPrincipal;
    }
    public void setVehiculoPrincipal(Vehiculo vehiculoPrincipal) {
        this.vehiculoPrincipal = vehiculoPrincipal;
    }
    public void asociarVehiculo(Vehiculo v) {
        this.vehiculosAsociados.add(v);
    }
    public String listaVehiculosAsociados() {
        String listaVehiculos="\n";
        for(Vehiculo v:this.vehiculosAsociados) {
            listaVehiculos+=v.getPlaca()+"\n";
        }
        return listaVehiculos;
    }



}
