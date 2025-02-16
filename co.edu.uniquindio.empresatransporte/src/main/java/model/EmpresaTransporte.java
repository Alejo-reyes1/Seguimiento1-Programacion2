package model;

import java.util.ArrayList;

public class EmpresaTransporte {
    private String nombre;
    private ArrayList<Propietario> listaPropietarios;
    private ArrayList<VehiculoCarga> listaVehiculosCarga;
    private ArrayList<VehiculoTransporte> listaVehiculosTransporte;
    private ArrayList<Usuario> listausuarios;

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
        this.listaPropietarios =new ArrayList<>();
        this.listaVehiculosCarga =new ArrayList<>();
        this.listaVehiculosTransporte =new ArrayList<>();
        this.listausuarios =new ArrayList<>();
    }

    public ArrayList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(ArrayList<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public ArrayList<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(ArrayList<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public ArrayList<VehiculoTransporte> getListaVehiculosTransporte() {
        return listaVehiculosTransporte;
    }

    public void setListaVehiculosTransporte(ArrayList<VehiculoTransporte> listaVehiculosTransporte) {
        this.listaVehiculosTransporte = listaVehiculosTransporte;
    }

    public ArrayList<Usuario> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(ArrayList<Usuario> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos para agregar objetos a sus respectivas listas

    public void agregarUsuario(Usuario u) {
        this.listausuarios.add(u);
    }
    public void agregarVehiculoCarga(VehiculoCarga v) {
        this.listaVehiculosCarga.add(v);
    }
    public void agregarVehiculoTransportador(VehiculoTransporte v) {
        this.listaVehiculosTransporte.add(v);
    }
    public void agregarPropietario(Propietario p) {
        this.listaPropietarios.add(p);
    }

    //Metodos para buscar objetos de la lista

    public Propietario buscarPropietario(String cedula) {
        for(Propietario p:this.listaPropietarios) {
            if(p.getCedula().equalsIgnoreCase(cedula)) {
                return p;
            }
        }
        return null;
    }
    public VehiculoCarga buscarVehiculoCarga(String placa) {
        for(VehiculoCarga v:this.listaVehiculosCarga) {
            if(v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public VehiculoTransporte buscarVehiculoTransporte(String placa) {
        for(VehiculoTransporte v:this.listaVehiculosTransporte) {
            if(v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public void asociarVehiculoConductor(Vehiculo v, Propietario p) {
        p.asociarVehiculo(v);
        v.asociarPropietario(p);
    }

    public String listaVehiculosTransporte() {
        String listaVehiculos="";
        for(VehiculoTransporte v:this.listaVehiculosTransporte) {
            listaVehiculos+=v.getPlaca()+"\n";
        }
        return listaVehiculos;
    }
    public void asociarUsuarioConVehiculoTransporte(VehiculoTransporte vehiculo,Usuario usuario) {
        vehiculo.asociarUsuarioPasajero(usuario);
    }


}
