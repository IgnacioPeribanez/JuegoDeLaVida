package juegoVida;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	/**
	 * pre: --- 
	 * Post: Este metodo genera una tripleta y la devuelve.
	 */
	public static Tripleta tripleta(String[][] t,int i, int f, int c, int nuevas) {
		int vivas = 0;
		for (int z = 0; z < f; z++) { // Bucle donde remplazaremos la tabla t por la tabla t2 despues de cada generacion
			for (int j = 0; j < c; j++) {
				if (t[z][j].equals("*")) {
					vivas++;
				}
			}
		}
		Tripleta tri = new Tripleta(i, vivas, nuevas);
		return tri;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo crea las generaciones pertinentes.
	 */
	public static void generaciones(int g, int f, int c) {
		ArrayList<Tripleta> l = new ArrayList<Tripleta>();
		String t[][] = new String[f][c]; 
		String t2[][]  = new String[f][c]; //Creamos una tabla identica a la tabla "t", donde escribiremos dependiendo de las condiciones.
		for (int i = 0; i < f; i++) { // Creamos un bucle que crea la generacion 0 y escribe en la tabla "t2" para que no tenga valor null.
			for (int x = 0; x < c; x++) {
				int numero = (int) Math.floor(Math.random() * 9);
				if (numero == 0 || numero == 1) {
					t[i][x] = "*";
				} else {
					t[i][x] = " ";
				}
				t2[i][x] = t[i][x];
				
			}
		}
		System.out.println("\nGeneración 0");
		for (int z = 0; z < f; z++) { // Creamos un bucle que se encarga de mostrar la generacion 0
			System.out.println();
			for (int x = 0; x < c; x++) {
				System.out.print(t2[z][x]);
				System.out.print(" ");
			}
		}
		System.out.print("\n");
		l.add(tripleta(t, 0, f, c, 0));
		for (int i = 1; i < g; i++) { //Creamos un bucle que creara cada generacion (despues de la generacion 0).
			System.out.println("\nGeneración " + i);
			/**
			 * Bucle donde reemplazaremos la tabla t por la tabla t2 despues de cada generacion, esta programado de manera
			 * que la primera vez que se ejecute el bucle, este no cambie nada.
			 */
			for (int z = 0; z < f; z++) { 
				for (int j = 0; j < c; j++) {
					t[z][j] = t2[z][j];
				}
			}
			int nuevas = 0;
			for (int j = 0; j < f; j++) { // Creamos un bucle que se encarga de determinar el estado de cada celula
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
						/*
						 * El "ArrayIndexOutOfBoundsException" se encarga de evitar 
						 * el error al comparar una celda con otra celda inexsitente.
						 */
						if (t[j][x].equals("*")) {
							if (contador < 2) {
								t2[j][x] = " ";
								
							} else if (contador > 3) {
								t2[j][x] = " ";
								
							}
						} else {
							if (contador == 3) {
							t2[j][x] = "*";
							nuevas ++;
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
			Tripleta triple = tripleta(t2, i, f, c, nuevas); 
			System.out.println("\n\nSobreviven " + triple.getVivas() + " células");
			l.add(triple); // Añadimos la tripleta corresponiente a cada generacion a partir de la 1
			if (triple.getVivas() == 0) { // Si no hay celulas vivas ejecutamos el break.
				System.out.print("\nColonia extinguida\n");
				break;
			}
		}
		for(int i = 0; i < l.size(); i++) { // Bucle para mostrar las tripletas de cada generacion
			System.out.println("\n" + l.get(i));
		}
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo pide por pantalla un numero de filas, un numero de columnas,
	 * un numero de generaciones, y ejecuta los generadores del juego de la vida.
	 */
	public static void aleatorio() {
		int filas = -1;
		int columnas = -1;
		int generaciones = -1;
		Scanner entrada = new Scanner(System.in);
		while (filas < 0) { // Bucle infinito hasta que el numero sea positivo
			System.out.print("Dame un numero de filas: ");
			filas = entrada.nextInt();
		}
		while (columnas < 0) { // Bucle infinito hasta que el numero sea positivo
			System.out.print("Dame un numero de columnas: ");
			columnas = entrada.nextInt();
		}
		while (generaciones < 0) { // Bucle infinito hasta que el numero sea positivo
			System.out.print("Introduce un número de generaciones: ");
			generaciones = entrada.nextInt();
		}
		generaciones(generaciones, filas, columnas);
		System.out.print(
				"\n------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo muestra por pantalla un menú, con el que podemos ejecutar diferentes opciones 
	 * del programa
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¡Bienvenidos al juego de la vida!");
		System.out.print(
				"------------------------------------------------------------------------------------------------------");
		while (true) {
			System.out.println("");
			System.out.println("0.- Apagar programa");
			System.out.println("1.- Generar tablero aleatorio");
			System.out.println("2.- Pruebas");
			System.out.print("\n¿Que opcion deseas ejecutar?: ");
			int numero = entrada.nextInt();
			System.out.println("");
			if (numero > 2 || numero < 0) { // Mostramos el error en caso de introducir una opcion inexistente
				System.out.println("Error, elija una de las opciones validas");
			} else if (numero == 0) { // Paramos el programa al introducir 0
				System.out.print("Has apagado el programa");
				break;
			} else if (numero == 1) { // Llamamos al medodo aleatorio() si el numero es 1
				aleatorio();
			} else if (numero == 2) { // Llamamos al main() de la clase Prueba si el numero es 2
				Prueba.main(args);
			} 
		}
	}
}