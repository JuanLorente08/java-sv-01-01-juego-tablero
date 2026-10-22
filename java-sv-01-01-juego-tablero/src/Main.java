import javax.swing.table.TableColumn;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args ){
        char[][] matriz = new char [10][10];
        int vidas = 5;
        for (int fila=0 ; fila< matriz.length ; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = '*';
            }
        }

        char YODA = 'Y';
        matriz[0][0] = YODA;

        char FINAL = 'F';
        matriz[9][9] = FINAL;

        Random aleatorio = new Random();
        int filaRandom = aleatorio.nextInt(10);
        int columnaRandom = aleatorio.nextInt(10);
        for (int i = 0; i < 5; i++) {
            do {
                filaRandom = aleatorio.nextInt(10);
                columnaRandom = aleatorio.nextInt(10);
            } while (matriz[filaRandom][columnaRandom] !='*');
            matriz[filaRandom][columnaRandom] = 'M';

        }

        int filaAleatoria2 = aleatorio.nextInt(10);
        int columnaAleatoria2 = aleatorio.nextInt(10);
        for (int i = 0; i < 5; i++) {
            do {
                filaAleatoria2 = aleatorio.nextInt(10);
                columnaAleatoria2 = aleatorio.nextInt(10);
            } while (matriz[filaAleatoria2][columnaAleatoria2] !='*');
            matriz[filaAleatoria2][columnaAleatoria2] = 'P';

        }

        System.out.println("Tu juagadro se encuetra en la casilla 0,0");
        System.out.println("Te puedes desplazar con la teclas W A S D");
        Scanner sc = new Scanner(System.in);

        int filaYoda = 0;
        int columnaYoda = 0;
        boolean partidaTerminada = false;
        while (vidas > 0 && !partidaTerminada){
            System.out.println("The quedan " + vidas + " vidas");
            System.out.print("Dime una letra:");
            char desplazamiento = sc.next().toUpperCase().charAt(0);
            System.out.println("La letra elegida es " + desplazamiento);

            int nuevaFila = filaYoda;
            int nuevaColumna = columnaYoda;

            if (desplazamiento == 'D') {
                nuevaColumna++;
                if (nuevaColumna>9){
                    System.out.println("Fuera del tablero");
                    nuevaColumna--;
                }
            } else if (desplazamiento == 'S') {
                nuevaFila++;
                if (nuevaFila>9){
                    System.out.println("Fuera del tablero");
                    nuevaFila--;
                }
            } else if (desplazamiento == 'W') {
                nuevaFila--;
                if (nuevaFila>0){
                    System.out.println("Fuera del tablero");
                    nuevaFila++;
                }
            } else if (desplazamiento == 'A'){
                nuevaColumna--;
                if (nuevaColumna>0){
                    System.out.println("Fuera del tablero");
                    nuevaColumna++;
                }
            } else {
                System.out.println("Movimiento no válido. Usa W, A, S o D.");
                continue;
            }

            // Comprueba los límites antes de acceder a la matriz.
            if (nuevaFila < 0 || nuevaFila >= matriz.length ||
                    nuevaColumna < 0 || nuevaColumna >= matriz[0].length) {
                System.out.println("¡No puedes salirte del tablero!");
                continue;
            }

            matriz[filaYoda][columnaYoda] = '*';
            filaYoda = nuevaFila;
            columnaYoda = nuevaColumna;

            if (matriz[filaYoda][columnaYoda] == 'M'){
                vidas--;
            }
            if (matriz[filaYoda][columnaYoda] == 'P'){
                vidas++;
            }
            if (matriz[filaYoda][columnaYoda] == 'F') {
                partidaTerminada = true;
                System.out.println("¡Has llegado a la meta!");
            }
            matriz[filaYoda][columnaYoda] = YODA;
            // imprimir la matriz
            for (int fila=0; fila< matriz.length; fila++){
                for (int columna=0 ; columna < matriz[fila].length; columna++){
                    System.out.print(matriz[fila][columna] + " ");
                }
                System.out.println();
            }
        }
        if (vidas <= 0) {
            System.out.println("Te has quedado sin vidas. Fin de la partida.");
        }
        sc.close();
    }
}
