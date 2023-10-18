class Principal{

    public static void main(String[] str){
        //Definimos opciones
        String[] menu = new String[] {"1.Ver Vehiculos","2.Alquilar Vehiculo","3.Liberar Vehiculo","4.Agregar nuevo vehiculo","5.Consultar monto recaudado","6.Salir"};
        //Definimos opciones de tipo de vehiculo
        String[] tipoVehiculo = new String[] {"1.Camion de carga","2.Moto","3.Automovil","4.Buseta"};
        //Definimos opciones de tipo de combustible
        String[] tipoCombustible = new String[] {"1.Gasolina","2.Diesel","3.Plus"};
        //Definimos opciones de colores de vehiculos
        String[] coloresVehiculo = new String [] {"1.Azul","2.Rojo","3.Verde"};
        //Encabezado de vehiculos
        String[] encabezadoVehiculos = new String[] {"Id","Tipo","Color","Combustible","Disponible","Asegurado","Cliente","Precio"};
        //Definimos arreglo de vehiculos
        Vehiculo[] vehiculos = new Vehiculo[10];

        //Inicializamos vehiculos
        int contadorVehiculo = 3;
        vehiculos = inicializarVehiculos(vehiculos);

        //Definimos arreglo de clientes
        Cliente[] clientes = new Cliente[10];
        //Encabezado de clientes
        String[] encabezadoClientes = new String[] {"Id","Tipo Persona","Lugar Residencia","Direccion Exacta","Numero Tarjeta","Tipo Tarjeta","Nombre Cliente"};

        //Inicializamos clientes
        clientes = inicializarClientes(clientes);

        int montoRecaudado = 0;//Variable para monto recaudado

        boolean salir = false;//Variable para salir del programa
        while(true){
            Utilidades.imprimirMenu(menu,"Menu");//Mostramos menú a usuario

            //Solicitamos valor de menu al usuario y realizamos método según el caso
            switch(Utilidades.getInt("Digite opción: ",1,menu.length)){
                //Ver Vehiculos
                case 1:
                imprimirVehiculos(vehiculos,encabezadoVehiculos,0);
                break;
                //Alquilar Vehiculo
                case 2:
                //Obtenemos vehiculos disponibles
                Vehiculo[] vehiculosDisponibles = new Vehiculo[10];
                int contadorVehiculosDisponibles = 0;
                for(Vehiculo vehiculo:vehiculos){
                    if(vehiculo!=null){
                        if(vehiculo.getDisponible().equals("Si")){
                            vehiculosDisponibles[contadorVehiculosDisponibles] = vehiculo;
                            contadorVehiculosDisponibles++;
                        }
                    }else{
                        break;
                    }
                }
                //Si no hay vehiculos disponibles
                if(contadorVehiculosDisponibles==0){
                    System.out.println("No hay vehiculos disponibles");
                    break;
                }
                //Mostramos Clientes
                imprimirClientes(clientes,encabezadoClientes,0);
                //Solicitamos cliente al usuario
                int idCliente = Utilidades.getInt("Digite id del cliente: ",1,clientes.length);
                //Mostramos vehiculos disponibles
                imprimirVehiculos(vehiculos,encabezadoVehiculos,0);
                //lista de id de vehiculos disponibles
                int[] idVehiculosDisponibles = new int[contadorVehiculosDisponibles];
                for(int i=0;i<contadorVehiculosDisponibles;i++){
                    idVehiculosDisponibles[i] = vehiculosDisponibles[i].getId();
                }
                //Solicitamos vehiculo al usuario
                int idVehiculo = Utilidades.getInt("Digite id del vehiculo: ",idVehiculosDisponibles);
                montoRecaudado += vehiculos[idVehiculo-1].getPrecio();

                //consultamos si quiere asegurar el vehiculo
                String asegurar = Utilidades.getString("Desea asegurar el vehiculo? Si/No: ",new String[] {"Si","No"});
                //Cambiamos estado del vehiculo
                vehiculos[idVehiculo-1].setDisponible("No");
                //Cambiamos cliente del vehiculo
                vehiculos[idVehiculo-1].setCliente(clientes[idCliente-1].getNombreCliente());
                //Cambiamos estado de asegurado del vehiculo
                vehiculos[idVehiculo-1].setAsegurado(asegurar);
                break;
                //Liberar Vehiculo
                case 3:
                //Obtenemos vehiculos no disponibles
                Vehiculo[] vehiculosNoDisponibles = new Vehiculo[10];
                int contadorVehiculosNoDisponibles = 0;
                for(Vehiculo vehiculo:vehiculos){
                    if(vehiculo!=null){
                        if(vehiculo.getDisponible().equals("No")){
                            vehiculosNoDisponibles[contadorVehiculosNoDisponibles] = vehiculo;
                            contadorVehiculosNoDisponibles++;
                        }
                    }else{
                        break;
                    }
                }
                //Si no hay vehiculos no disponibles
                if(contadorVehiculosNoDisponibles==0){
                    System.out.println("No hay vehiculos no disponibles");
                    break;
                }
                //Mostramos vehiculos no disponibles
                imprimirVehiculos(vehiculos,encabezadoVehiculos,0);
                //lista de id de vehiculos no disponibles
                int[] idVehiculosNoDisponibles = new int[contadorVehiculosNoDisponibles];
                for(int i=0;i<contadorVehiculosNoDisponibles;i++){
                    idVehiculosNoDisponibles[i] = vehiculosNoDisponibles[i].getId();
                }
                //Solicitamos vehiculo al usuario
                int idVehiculoNoDisponible = Utilidades.getInt("Digite id del vehiculo: ",idVehiculosNoDisponibles);
                //Cambiamos estado del vehiculo
                vehiculos[idVehiculoNoDisponible-1].setDisponible("Si");
                //Cambiamos cliente del vehiculo
                vehiculos[idVehiculoNoDisponible-1].setCliente("Ninguno");
                //Cambiamos estado de asegurado del vehiculo
                vehiculos[idVehiculoNoDisponible-1].setAsegurado("No");
                break;
                //Agregar nuevo vehiculo
                case 4:
                //Solicitamos tipo de vehiculo
                Utilidades.imprimirMenu(tipoVehiculo,"Tipo de vehiculo");
                int tipo = Utilidades.getInt("Digite tipo de vehiculo: ",1,tipoVehiculo.length);
                //Solicitamos color de vehiculo
                Utilidades.imprimirMenu(coloresVehiculo,"Color de vehiculo");
                int color = Utilidades.getInt("Digite color de vehiculo: ",1,coloresVehiculo.length);
                //Solicitamos tipo de combustible
                Utilidades.imprimirMenu(tipoCombustible,"Tipo de combustible");
                int combustible = Utilidades.getInt("Digite tipo de combustible: ",1,tipoCombustible.length);
                //Solicitamos precio
                int precio = Utilidades.getInt(1,"Digite precio: ");
                //Agregamos vehiculo
                vehiculos[contadorVehiculo] = new Vehiculo(contadorVehiculo,tipoVehiculo[tipo-1].substring(2),coloresVehiculo[color-1].substring(2),tipoCombustible[combustible-1].substring(2),"Si","No","Ninguno",precio);
                contadorVehiculo++;
                break;
                //Consultar monto recaudado
                case 5:
                System.out.println("El monto recaudado es de: "+montoRecaudado);
                break; 
                //Salir
                case 6:
                salir = true;
                break;
                default:
                System.out.println("Error");
            }
            if(salir) break;

        }

    }

    //Método para inicializar vehiculos
    public static Vehiculo[] inicializarVehiculos(Vehiculo[] vehiculos){
        vehiculos[0] = new Vehiculo(1,"Camion de carga","Rojo","Diesel","Si","No","Ninguno",1000000);
        vehiculos[1] = new Vehiculo(2,"Moto","Azul","Plus","Si","No","Ninguno",6500000);
        vehiculos[2] = new Vehiculo(3,"Automovil","Verde","Gasolina","Si","No","Ninguno",5000000);
        return vehiculos;
    }

    //Método para inicializar clientes
    public static Cliente[] inicializarClientes(Cliente[] clientes){
        clientes[0] = new Cliente(1,"Natural","SanJose","Desamparados",123456789,"MasterCard","Juan");
        clientes[1] = new Cliente(2,"Juridica","Cartago","Basilica",987654321,"Visa","Pedro");
        clientes[2] = new Cliente(3,"Natural","Guanacaste","Liberia",123456789,"Visa","Maria");
        return clientes;
    }


    //Método para imprimir vehiculos
    static void imprimirVehiculos(Vehiculo[] listaActual,String [] encabezado,int espacios){
        //buscamos el mayor tamaño de cada campo de la lista
        for(Vehiculo vehiculo:listaActual){
            if(vehiculo!=null){
                if(vehiculo.getAsegurado().length()>espacios){
                    espacios = vehiculo.getAsegurado().length();
                }
                if(vehiculo.getCombustible().length()>espacios){
                    espacios = vehiculo.getCombustible().length();
                }
                if(vehiculo.getColor().length()>espacios){
                    espacios = vehiculo.getColor().length();
                }
                if(vehiculo.getTipo().length()>espacios){
                    espacios = vehiculo.getTipo().length();
                }
                if(vehiculo.getId()>espacios){
                    espacios = String.valueOf(vehiculo.getId()).length();
                }
                if(vehiculo.getDisponible().length()>espacios){
                    espacios = vehiculo.getDisponible().length();
                }
                if(vehiculo.getCliente().length()>espacios){
                    espacios = vehiculo.getCliente().length();
                }
            }
        }
        //buscamos el mayor tamaño de cada campo del encabezado
        for(String nombre:encabezado){
            if(nombre.length()>espacios){
                espacios = nombre.length();
            }
        }

        //Imprimimos encabezado
        for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
            System.out.print("_");
        }
        System.out.println("");

        System.out.print("|");
        for(String nombre:encabezado){
            System.out.print(nombre);
            for(int i=0;i<espacios-nombre.length();i++){
                System.out.print(" ");
            }
            System.out.print("|");
        }

        //"Id","Tipo","Color","Combustible","Disponible","Asegurado","Cliente"
        System.out.println("");
        for(Vehiculo vehiculo:listaActual){
            if(vehiculo!=null){
                System.out.print("|");
                System.out.print(vehiculo.getId());
                for(int i=0;i<espacios-String.valueOf(vehiculo.getId()).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getTipo());
                for(int i=0;i<espacios-vehiculo.getTipo().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getColor());
                for(int i=0;i<espacios-vehiculo.getColor().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getCombustible());
                for(int i=0;i<espacios-vehiculo.getCombustible().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getDisponible());
                for(int i=0;i<espacios-vehiculo.getDisponible().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getAsegurado());
                for(int i=0;i<espacios-vehiculo.getAsegurado().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getCliente());
                for(int i=0;i<espacios-vehiculo.getCliente().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(vehiculo.getPrecio());
                for(int i=0;i<espacios-String.valueOf(vehiculo.getPrecio()).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println("");
            }else{
                break;
            }

        }
            for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
                System.out.print("-");
            }
                System.out.println("");
    }

    //Método para imprimir clientes
    static void imprimirClientes(Cliente[] listaActual,String [] encabezado,int espacios){
        //buscamos el mayor tamaño de cada campo de la lista
        for(Cliente cliente:listaActual){
            if(cliente!=null){
                if(cliente.getTipoPersona().length()>espacios){
                    espacios = cliente.getTipoPersona().length();
                }
                if(cliente.getLugarResidencia().length()>espacios){
                    espacios = cliente.getLugarResidencia().length();
                }
                if(cliente.getDireccionExacta().length()>espacios){
                    espacios = cliente.getDireccionExacta().length();
                }
                if(String.valueOf(cliente.getNumeroTarjeta()).length()>espacios){
                    espacios = String.valueOf(cliente.getNumeroTarjeta()).length();
                }
                if(cliente.getTipoTarjeta().length()>espacios){
                    espacios = cliente.getTipoTarjeta().length();
                }
                if(cliente.getNombreCliente().length()>espacios){
                    espacios = cliente.getNombreCliente().length();
                }
                if(String.valueOf(cliente.getId()).length()>espacios){
                    espacios = String.valueOf(cliente.getId()).length();
                }
            }
        }
        //buscamos el mayor tamaño de cada campo del encabezado
        for(String nombre:encabezado){
            if(nombre.length()>espacios){
                espacios = nombre.length();
            }
        }

        //Imprimimos encabezado
        for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
            System.out.print("_");
        }
        System.out.println("");

        System.out.print("|");
        for(String nombre:encabezado){
            System.out.print(nombre);
            for(int i=0;i<espacios-nombre.length();i++){
                System.out.print(" ");
            }
            System.out.print("|");
        }

        //"Id","Tipo Persona","Lugar Residencia","Direccion Exacta","Numero Tarjeta","Tipo Tarjeta","Nombre Cliente"
        System.out.println("");
        for(Cliente cliente:listaActual){
            if(cliente!=null){
                System.out.print("|");
                System.out.print(cliente.getId());
                for(int i=0;i<espacios-String.valueOf(cliente.getId()).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(cliente.getTipoPersona());
                for(int i=0;i<espacios-cliente.getTipoPersona().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(cliente.getLugarResidencia());
                for(int i=0;i<espacios-cliente.getLugarResidencia().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(cliente.getDireccionExacta());
                for(int i=0;i<espacios-cliente.getDireccionExacta().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(cliente.getNumeroTarjeta());
                for(int i=0;i<espacios-String.valueOf(cliente.getNumeroTarjeta()).length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(cliente.getTipoTarjeta());
                for(int i=0;i<espacios-cliente.getTipoTarjeta().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(cliente.getNombreCliente());
                for(int i=0;i<espacios-cliente.getNombreCliente().length();i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println("");
            }else{
                break;
            }
        }
            for(int i=0;i<(encabezado.length+1)+(espacios*encabezado.length);i++){
                System.out.print("-");
            }
                System.out.println("");
    }


}
