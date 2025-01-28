package tarea04;

import java.util.Scanner;

/**
 * Ejercicio 1. Comprimir cadenas.
 * 
 * Programa que pide una cadena y comprime caracteres repetidos consecutivos, 
 * indicando cuántas veces se repiten. Si un carácter solo aparece una vez, no se  
 * añade el número.
 * Se debe verificar con una expresión regular que la cadena es de solo texto.
 * Si la cadena comprimida no es más corta que la original, se imprime la original.
 * No se debe utilizar la clase StringBuilder.
 * 
 * @author profesorado
 */

public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String PATRON = "[a-zA-Z]+";        
        
        // Variables de entrada
        String cadena;
        
        // Variables de salida
        String cadenaComprimida;
        
        // Variables auxiliares
        int longitud;
        int contador;
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 1. Comprimir cadenas.");
        System.out.println("-------------------------------");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Pedimos la cadena al usuario
        System.out.print("Escribe una cadena de texto: ");
        cadena = teclado.nextLine();
        
        // Limpiamos la cadena de espacios y verificamos que son letras
        cadena = cadena.trim();
        
        //Sólo si la cadena es válida entramos a realizar comprobaciones
        if (cadena.matches(PATRON)) {
            // Obtenemos la longitud de la cadena
            longitud = cadena.length();

            // Recorremos la cadena buscando repeticiones
            cadenaComprimida = "";
            contador = 1;
            for (int bucle = 1; bucle < longitud; bucle++) { 
                if (cadena.charAt(bucle) == cadena.charAt(bucle - 1)) {
                    contador++;
                } else {
                    cadenaComprimida += cadena.charAt(bucle - 1);
                    if (contador > 1) {
                        cadenaComprimida += contador;
                    }
                    contador = 1; // Reiniciamos el contador
                }
            }

            // Agregamos el último carácter
            cadenaComprimida += cadena.charAt(longitud - 1);
            if (contador > 1) {
                cadenaComprimida += contador;
            }

            //----------------------------------------------
            //              Salida de resultados 
            //----------------------------------------------
            System.out.println();
            System.out.println("RESULTADO");
            System.out.println("---------");

            // Imprimimos la cadena resultante
            // Comprobando si la cadena comprimida es igual o más larga para imprimir un resultado u otro
            System.out.printf("Cadena comprimida: %s\n\n", (cadenaComprimida.length() < cadena.length()) ? cadenaComprimida : cadena);
            
        } else {    // Si la cadena no es válida, mostramos un mensaje y el programa termina
                    //(no porque lo terminemos abruptamente, sino porque no hay más líneas que ejecutar)
            System.out.println("Error: Solo se permiten letras.");
        }
    }
}
