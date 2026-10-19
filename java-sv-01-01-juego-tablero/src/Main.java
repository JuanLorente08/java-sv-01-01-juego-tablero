import javax.swing.table.TableColumn;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args ){
        char[][] matriz = new char [10][10];
        int vidas = 10;
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
        matriz[filaRandom][columnaRandom] = 'M';

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
        System.out.println("dime una letra: ");
        char desplazamiento = sc.next().charAt(0);
        System.out.println("La letra elegida es " + desplazamiento );

        int filaYoda = 0;
        int columnaYoda = 0;
        matriz[filaYoda][columnaYoda] = YODA;
        if (desplazamiento == 'D'){
            columnaYoda = columnaYoda + 1;
            matriz[filaYoda][columnaYoda] = YODA;
        }

        for (int fila=0; fila< matriz.length; fila++){
            for (int columna=0 ; columna < matriz[fila].length; columna++){
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println();
        }


    }
}