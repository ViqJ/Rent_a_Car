// Se importan las librerias necesarias
import java.util.Scanner;

/**
 * Clase con diferentes utilidades de usuario.
 * Contiene metodos para distintos casos.
 *
 * @author JJ
 * @version 1.0
 */
public class Utilidades {

    private static Scanner entrada = new Scanner(System.in);

    /**
     * Obtiene un valor entero valido y mayor o igual a un minimo.
     * @param valormin  Valor minimo aceptado.
     * @param consulta  Consulta para el usuario.
     * @return El valor entero ingresado por el usuario.
         */
    public static int getInt(int valormin, String consulta){
        int valor = 0;
        while(true){
            System.out.print(consulta);
            if(entrada.hasNextInt()){
                valor = entrada.nextInt();
                if(valor>=valormin) break;
                System.out.println("Valor no valido");
            }else{
            System.out.println("Valor no valido");
            entrada.next();
            }
        }
        return valor;
    }

    /**
     * Obtiene un valor entero valido y menor o igual a un maximo.
     * @param consulta  Consulta para el usuario.
     * @param valormax  Valor maximo aceptado.
     * @return El valor entero ingresado por el usuario.
         */
    public static int getInt(String consulta,int valormax){
        int valor = 0;
        while(true){
            System.out.print(consulta);
            if(entrada.hasNextInt()){
                valor = entrada.nextInt();
                if(valor<=valormax) break;
                System.out.println("Valor no valido");
            }else{
            System.out.println("Valor no valido");
            entrada.next();
            }
        }
        return valor;
    }

    /**
     * Obtiene un valor entero valido entre un rango.
     * @param consulta  Consulta para el usuario.
     * @param valormin  Valor minimo aceptado.
     * @param valormax  Valor maximo aceptado.
     * @return El valor entero ingresado por el usuario.
         */
    public static int getInt(String consulta,int valormin,int valormax){
        int valor = 0;
        while(true){
            System.out.print(consulta);
            if(entrada.hasNextInt()){
                valor = entrada.nextInt();
                if(valor>=valormin&&valor<=valormax) break;
                System.out.println("Valor no valido");
            }else{
            System.out.println("Valor no valido");
            entrada.next();
            }
        }
        return valor;
    }


    /**
     * Obtiene un valor entero valido de una lista de valores posibles
     * @param consulta Consulta para el usuario.
     * @param valoresPosibles Lista de valores posibles.
     * @return El valor entero valido ingresado por el usuario.
     */
    public static int getInt(String consulta,int [] valoresPosibles){
        int valor = 0;
        boolean valorValido = false;
        while(true){
            System.out.print(consulta);
            if(entrada.hasNextInt()){
                valor = entrada.nextInt();
                for(int i=0;i<valoresPosibles.length;i++){
                    if(valor==valoresPosibles[i]){
                        valorValido = true;
                        break;
                    }
                }
                if(valorValido) break;
                System.out.println("Valor no valido");
            }else{
            System.out.println("Valor no valido");
            entrada.next();
            }
        }
        return valor;
    }


    /**
     * Obtiene un string valido.
     * @param consulta Consulta para el usuario.
     * @param permitirNum true si permite numeros, false si quiere numeros.
     * @return El String ingresado por el usuario.
     */
    public static String getString(String consulta,boolean permitirNum){
        String palabra;
        while(true){
            System.out.print(consulta);
                if(entrada.hasNextInt()&&!permitirNum){
                    System.out.println("Valor no valido");
                    entrada.next();
                    continue;
                }
                palabra = entrada.next();
                break;
        }
        return palabra;
    }

    /**
     * Obtiene un String valido de una lista de valores posibles
     * @param consulta Consulta para el usuario.
     * @param valoresPosibles Lista de valores posibles.
     * @return El String ingresado por el usuario.
     */
    public static String getString(String consulta,String [] valoresPosibles){
        String palabra;
        boolean valorValido = false;
        while(true){
            System.out.print(consulta);
            palabra = entrada.next();
            for(int i=0;i<valoresPosibles.length;i++){
                if(palabra.equals(valoresPosibles[i])){
                    valorValido = true;
                    break;
                }
            }
            if(valorValido) break;
            System.out.println("Valor no valido");
        }
        return palabra;
    }

    /**
     * Obtiene un char valido.
     * @param consulta Consulta para el usuario.
     * @param permitirNum true permite numeros, false si no quiere numeros.
     * @return El char ingresado por el usuario.
     */
    public static char getChar(String consulta,boolean permitirNum){
        String palabra;
        while(true){
            System.out.print(consulta);
                if(entrada.hasNextInt()&&!permitirNum){
                    System.out.println("Valor no valido");
                    entrada.next();
                    continue;
                }
                palabra = entrada.next();
                if(palabra.length()==1){
                break;
                }else{
                System.out.println("Valor no valido");
                }
        }
        return palabra.charAt(0);
    }

    /**
     * Obtiene un char valido de una lista de valores posibles
     * @param consulta Consulta para el usuario.
     * @param valoresPosibles Lista de valores posibles.
     * @return El char valido ingresado por el usuario.
     */
    public static char getChar(String consulta,char [] valoresPosibles){
        String palabra;
        boolean valorValido = false;
        while(true){
            System.out.print(consulta);
            palabra = entrada.next();
            if(palabra.length()==1){
            for(int i=0;i<valoresPosibles.length;i++){
                if(palabra.charAt(0)==(valoresPosibles[i])){
                    valorValido = true;
                    break;
                }
            }
            if(valorValido) break;
            System.out.println("Valor no valido");
            }else{
                System.out.println("Valor no valido");
            }
        }
        return palabra.charAt(0);
    }
    

    /**
     * Imprime datos de una lista que representan un menu
     * @param menu Menu a mostrar.
     */
    public static void imprimirMenu(String[] menu,String titulo){
        if(titulo!=null)System.out.println("    "+titulo+"    ");
        for(int i=0;i<menu.length;i++){
            System.out.println(menu[i]);
        }
    }

}
