package tarea04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ejercicio 2. Rotar matrices cuadradas.
 *
 * @author profesorado
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          DECLARACIÓN DE VARIABLES
        //----------------------------------------------
        // Constantes
        final String PATRON = "([a-zA-Z0-9]+,)*[a-zA-Z0-9]+";
        
        //Variables de entrada
        String fila;
        
        //Variables Auxiliares
        String[][] matrizOriginal, matrizRotada;
        String[] elementosFila;
        int tamanoMatriz, tamanoFila;
        Pattern patron;
        Matcher acople;
        boolean filaValida;
                  
        // Variables de Salida
        StringBuilder resultadoMatriz, resultadoMatrizRotada;      
        
        //----------------------------------------------
        //      ENTRADA DE DATOS Y PROCESMIENTO
        //----------------------------------------------
        Scanner teclado = new Scanner(System.in);

        System.out.println("EJERCICIO 2. ROTAR MATRICES CUADRADAS");
        System.out.println("--------------------------------------");
        System.out.println("Introduce los valores de la primera fila separados por comas (ejemplo: 1,2,3): ");
        fila = teclado.nextLine().trim(); //Quitamos los espacios de principio y de fin de la fila leida.
        fila = fila.replaceAll(" ", "");  //Eliminamos todos los espacios que pueda haber en la fila.
        
        patron = Pattern.compile(PATRON);
        acople = patron.matcher(fila);
        filaValida = acople.matches();
        tamanoFila = fila.split(",").length;
        
        if (fila.isEmpty() || tamanoFila <= 1) {
            System.out.println("Error: La matriz no puede ser de tamaño 0x0 ni 1x1.");
        } else if (!filaValida) {
            System.out.println("La fila contiene caracteres no permtidos.");
        } else {
            elementosFila = fila.split(",");
            tamanoMatriz = elementosFila.length;
            System.out.printf("Fila Correcta: Trabajaremos con una matriz de %d x %d.\n", tamanoMatriz, tamanoMatriz);
            matrizOriginal = new String[tamanoMatriz][tamanoMatriz];
            //Cada fila de una matriz es un array de elementos donde cada elemento corresponde a una columna.
            matrizOriginal[0] = elementosFila;
            for (int i=1; i<tamanoMatriz; i++) {
                do {
                    System.out.printf("Introduce los valores de la fila %d separados por comas: \n", (i + 1));
                    fila = teclado.nextLine().trim();
                    fila = fila.replaceAll(" ", "");
                    
                    patron = Pattern.compile(PATRON);
                    acople = patron.matcher(fila);
                    filaValida = acople.matches();
                    tamanoFila = fila.split(",").length;
                    
                    if (tamanoFila != tamanoMatriz)
                        System.out.printf("El número de elementos de la fila debe ser %d.\n", tamanoMatriz);
                    else if (!filaValida)
                        System.out.printf("La fila %d tiene valores no permitidos.\n", (i + 1));
                } while (!filaValida || tamanoFila != tamanoMatriz);
                elementosFila=fila.split(",");
                matrizOriginal[i] = elementosFila; 
            }            
            matrizRotada = new String[tamanoMatriz][tamanoMatriz];
            
            //Construimos la Matriz Rotada 90º.
            //Basicamente se trata de coger cada columna de la matriz original y trasponerla en orden invertido,
            //es decir, cada columna se convertirá en fila de la matriz rotada con los elementosFila en orden invertido.
            for (int i=0; i<tamanoMatriz; i++)
                for (int j=0; j<tamanoMatriz; j++)
                    matrizRotada[j][tamanoMatriz-1-i]= matrizOriginal[i][j];      
            
            
            //----------------------------------------------
            //              SALIDA DE RESULTADOS
            //----------------------------------------------
            resultadoMatriz = new StringBuilder();
            resultadoMatrizRotada = new StringBuilder();
            //Construimos un objeto Stringbuilder almacenamos los elementosFila de cada matriz
            //y para no utilizar dos bucles for adicionales.
            for (int i=0; i<tamanoMatriz; i++) {
                for (int j=0; j<tamanoMatriz; j++) {
                    resultadoMatriz.append(matrizOriginal[i][j]).append(" ");
                    resultadoMatrizRotada.append(matrizRotada[i][j]).append(" ");
                }          
                resultadoMatriz.append("\n");
                resultadoMatrizRotada.append("\n");
            }
            System.out.println();
            System.out.println("RESULTADO");
            System.out.println("---------");
            System.out.println("MATRIZ ORIGINAL");
            System.out.println(resultadoMatriz.toString());
            System.out.println("MATRIZ ROTADA 90º GRADOS");
            System.out.println(resultadoMatrizRotada.toString());
        }
    }
}