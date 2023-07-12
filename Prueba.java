package juegoVida;

import java.util.Scanner;

public class Prueba {
	
	
	public static void prueba(int f, int c) {
		String t[][] = new String[f][c]; 
		String[][] t2 = new String[f][c]; // Creamos una tabla identica a la tabla "t", donde escribiremos dependiendo de las condiciones.
		for (int i = 0; i < f; i++) {
			for (int x = 0; x < c; x++) {
				t[i][x] = "·";
			}
		}
		if (f == 4) { // Si la tabla es de 4x4
			t[1][1] = "*";
			t[1][2] = "*";
			t[2][1] = "*";
			t[2][2] = "*";
		} else if (f == 5) { // Si la tabla es de 5x5
			t[2][1] = "*";
			t[2][2] = "*";
			t[2][3] = "*";
		} else if (f == 6) { // Si la tabla es de 6x6
			t[1][1] = "*";
			t[1][2] = "*";
			t[2][1] = "*";
			t[2][2] = "*";
			t[3][3] = "*";
			t[3][4] = "*";
			t[4][3] = "*";
			t[4][4] = "*";
		}
		for (int i = 0; i < f; i++) { // Bucle para rellenar la segunda tabla
			for (int j = 0; j < c; j++) {
				t2[i][j] = t[i][j];
			}
		}

		for (int i = 0; i < 30; i++) { // Creamos un bucle que creara cada generacion (despues de la generacion 0).
			System.out.println("\nGeneración " + i);
			for (int z = 0; z < f ; z++) { // Bucle donde reemplazaremos la tabla t por la tabla t2 despues de cada generacion
				for (int j = 0; j < c; j++) {
					t[z][j] = t2[z][j];
				}
			}
			for (int j = 0; j < f; j++) {
				for (int x = 0; x < c; x++) {
					int contador = 0;
					try {
						if (t[j - 1][x].equals("*")) {
							contador++;
						}
						if (t[j - 1][x - 1].equals("*")) {
							contador++;
						}
						if (t[j - 1][x + 1].equals("*")) {
							contador++;
						}
						if (t[j][x - 1].equals("*")) {
							contador++;
						}
						if (t[j][x + 1].equals("*")) {
							contador++;
						}
						if (t[j + 1][x - 1].equals("*")) {
							contador++;
						}
						if (t[j + 1][x].equals("*")) {
							contador++;
						}
						if (t[j + 1][x + 1].equals("*")) {
							contador++;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					if (t[j][x].equals("*")) {
						if (contador < 2) {
							t2[j][x] = "·";

						} else if (contador > 3) {
							t2[j][x] = "·";
						}
					} else {
						if (contador == 3) {
							t2[j][x] = "*";
						}
					}
				}
			}
			for (int z = 0; z < f; z++) { // Creamos un bucle que se encarga de mostrar la tabla despues de las condiciones
				System.out.println();
				for (int x = 0; x < c; x++) {
					System.out.print(t2[z][x]);
					System.out.print(" ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while (true) {
			System.out.println("¡PRUEBAS DEL JUEGO DE LA VIDA!\n");
			System.out.println("0.- Volver");
			System.out.println("1.- Prueba de Bloque");
			System.out.println("2.- Prueba de Intermitente");
			System.out.println("3.- Prueba de Faro");
			System.out.print("\n¿Que opcion deseas ejecutar?: ");
			int numero = entrada.nextInt();
			System.out.print(
					"\n------------------------------------------------------------------------------------------------------\n");
			if (numero > 4 || numero < 0) { // Mostramos el error en caso de introducir una opcion inexistente
				System.out.println("Error, elija una de las opciones validas");
			} else if (numero == 0) { // Paramos el programa al introducir 0
				System.out.println("¡¿Otra vez aqui?!");
				break;
			} else if (numero == 1) { 
				prueba(4,4);
				System.out.println("\n");
			} else if (numero == 2) { 
				prueba(5,5);
				System.out.println("\n");
			} else if (numero == 3) { 
				prueba(6,6);
				System.out.println("\n");
			}
		}
	}
}