package service;

import model.*;

import javax.swing.*;

public class mainTransporte {

    public static void main (String[] args){
        EmpresaTransporte empresaTransporte=datosPrueba();
        menu(empresaTransporte);
    }

    public static void menu(EmpresaTransporte empresaTransporte) {
        String menuPrincipal=mensajeMenu();
        int opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null,menuPrincipal));
            opcionMenu(opcionSeleccionada,empresaTransporte);
        } while (opcionSeleccionada <8);
    }

    private static String mensajeMenu() {
        String mensaje="Menu principal\n"+
                "Ingrese el numero correspondiente a la gestion deseada\n"+ "1.Crear propietario\n"+ "2.Crear vehiculo carga\n"+
                "3.Asociar un propietario con un vehiculo\n"+ "4.Agregar usuario a vehiculo transportista\n"+
                "5.Calcular el total de pasajeros transportados en un día\n"+"6.lista usuarios que superan un peso\n"+
                "7.propietarios mayores a 40 años\n"+"8.Salir del programa\n";

        return mensaje;
    }

    private static EmpresaTransporte datosPrueba() {
        EmpresaTransporte empresaTransporte= new EmpresaTransporte("mi empresa");
        Usuario usuario1 = new Usuario("Carlos", 25, 70.5);
        Usuario usuario2 = new Usuario("Ana", 42, 60.2);
        Propietario propietario1 = new Propietario("Carlos Pérez", "1234567890", "carlos.perez@email.com", "25", "0987654321");
        Propietario propietario2 = new Propietario("Ana Gómez", "0987654321", "ana.gomez@email.com", "42", "0912345678");
        VehiculoCarga vehiculo1 = new VehiculoCarga("ABC123", "2021", "Volvo", "Blanco", "CHS123456789", 15000, 4);
        VehiculoTransporte vehiculo3 = new VehiculoTransporte("VAN789", "2022", "Hyundai", "Azul", "CHS5566778899", 15);
        VehiculoTransporte vehiculoTransporte1= new VehiculoTransporte("asd123");
        empresaTransporte.agregarVehiculoTransportador(vehiculoTransporte1);
        empresaTransporte.agregarUsuario(usuario2);
        empresaTransporte.agregarUsuario(usuario1);
        empresaTransporte.agregarPropietario(propietario2);
        empresaTransporte.agregarPropietario(propietario1);
        empresaTransporte.agregarVehiculoCarga(vehiculo1);
        empresaTransporte.agregarVehiculoTransportador(vehiculo3);
        empresaTransporte.asociarUsuarioConVehiculoTransporte(vehiculo3, usuario2);

        return empresaTransporte;
    }

    private static void opcionMenu(int opcionSeleccionada, EmpresaTransporte empresaTransporte) {
        switch(opcionSeleccionada) {
            case 1:
                crearPropietario(empresaTransporte);
                break;
            case 2:
                crearVehiculoCarga(empresaTransporte);
                break;
            case 3:
                asociarVehiculoPropietario(empresaTransporte);
                break;
            case 4:
                agregarUsuarioVehiculoTransportador(empresaTransporte);
                break;
            case 5:
                calcularPasajerosTransportados(empresaTransporte);
                break;
            case 6:
                usuariosConPesoSuperiorA(empresaTransporte);
                break;
            case 7:
                numeroPropietariosMayor40(empresaTransporte);
                break;
        }
    }

    private static void numeroPropietariosMayor40(EmpresaTransporte empresaTransporte) {
        JOptionPane.showMessageDialog(null,"La cantidad de propietarios mayores a 40 años es de "
                + empresaTransporte.numeroPropietariosMayor40());
    }

    private static void usuariosConPesoSuperiorA(EmpresaTransporte empresaTransporte) {
        int pesoSuperior=Integer.parseInt(JOptionPane.showInputDialog("Peso Superior A"));
        JOptionPane.showMessageDialog(null,"los usuarios con peso superior a "+pesoSuperior+
                "KG son\n"+empresaTransporte.listaUsuariosConPesoSuperior(pesoSuperior));
    }

    private static void agregarUsuarioVehiculoTransportador(EmpresaTransporte empresaTransporte) {
        String nombre=JOptionPane.showInputDialog("nombre del usuario que desea agregar al vehiculo transportista");
        int edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del usuario"));
        double peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del usuario"));
        Usuario newUsuario=new Usuario(nombre,edad,peso);
        empresaTransporte.agregarUsuario(newUsuario);
        String placa=JOptionPane.showInputDialog("Ingrese la placa del vehiculo transportista, los vehiculos registrados son\n"+empresaTransporte.listaVehiculosTransporte());
        VehiculoTransporte vehiculo=empresaTransporte.buscarVehiculoTransporte(placa);
        JOptionPane.showMessageDialog(null, "El usuario fue asociado exitosamente y actualmente cuenta con un transporte de "+vehiculo.calcularPasajerosTransportados());
    }

    private static void calcularPasajerosTransportados(EmpresaTransporte empresaTransporte) {
        JOptionPane.showMessageDialog(null,"la Lista de vehiculos transportista son\n"+empresaTransporte.listaVehiculosTransporte());
        String placaVehiculo=JOptionPane.showInputDialog("Ingrese la placa del vehiculo transportador");
        VehiculoTransporte vehiculo=empresaTransporte.buscarVehiculoTransporte(placaVehiculo);
        JOptionPane.showMessageDialog(null, "La cantidad de pasajeros que ha transportado el vehiculo con placas "+ vehiculo.getPlaca()+" es de:\n"+
                vehiculo.calcularPasajerosTransportados());
    }

    private static void crearPropietario(EmpresaTransporte empresaTransporte) {
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del propietario a crear");
        String cedula=JOptionPane.showInputDialog("Ingrese la cedula del propietario a crear");
        String email=JOptionPane.showInputDialog("Ingrese el email del propietario a crear");
        String edad=JOptionPane.showInputDialog("Ingrese la edad del propietario a crear");
        String celular=JOptionPane.showInputDialog("Ingrese el celular del propietario a crear");
        Propietario newPropietario= new Propietario(nombre, cedula, email, edad, celular);
        empresaTransporte.agregarPropietario(newPropietario);
        JOptionPane.showMessageDialog(null, "El propietario con identificacion " +newPropietario.getCedula()+" fue agregado exitosamente");
    }
    private static void crearVehiculoCarga(EmpresaTransporte empresaTransporte) {
        String placa=JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
        String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
        String marca=JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
        String color=JOptionPane.showInputDialog("Ingrese el color del vehiculo");
        String numeroChasis=JOptionPane.showInputDialog("Ingrese el numero de chasis del vehiculo");
        double capacidadCarga=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del vehiuclo"));
        int numeroEjes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes del vehiculo"));
        VehiculoCarga newVehiculo= new VehiculoCarga(placa, modelo, marca, color, numeroChasis, capacidadCarga, numeroEjes);
        empresaTransporte.agregarVehiculoCarga(newVehiculo);
        JOptionPane.showMessageDialog(null, "El vehiculo con placa " +newVehiculo.getPlaca()+" fue agregado exitosamente");
    }

    private static void asociarVehiculoPropietario(EmpresaTransporte empresaTransporte) {

        String identificacionPropietario=JOptionPane.showInputDialog("Ingrese la cedula del propietario");
        String placaVehiculo=JOptionPane.showInputDialog("Ingrese la placa del vehiculo a asociar con el propietario");
        Propietario propietario=empresaTransporte.buscarPropietario(identificacionPropietario);
        VehiculoCarga vehiculo=empresaTransporte.buscarVehiculoCarga(placaVehiculo);
        empresaTransporte.asociarVehiculoConductor(vehiculo, propietario);
        JOptionPane.showMessageDialog(null, "El propietario fue asociado exitosamente con el vehiculo y esta es su lista de vehiculos asociados "+propietario.listaVehiculosAsociados());

    }
}

