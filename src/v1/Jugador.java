/**
 * 
 */
package v1;

import java.util.*;

/**
 * 
 */
public class Jugador {

	private String name;

	private int[] puntuacion = new int[PartidaDardos.numeroDeRondas];

	private String[] resultadosPartida = new String[PartidaDardos.numeroDeRondas];

	public Jugador(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void jugarTurno(int i) {
		Random random = new Random();

		System.out.println("Turno de " + name + ". Lanza un dardo.");

		int puntuacion = random.nextInt(20) + 1;
		int multiplicador = random.nextInt(6) + 1;

		switch (multiplicador) {
		case 1, 2, 3, 4:
			puntuacion = puntuacion * 1;
			resultadosPartida[i] = "-";
			break;
		case 5:
			puntuacion = 25;
			resultadosPartida[i] = "D";
			break;
		case 6:
			puntuacion = 50;
			resultadosPartida[i] = "D";
			break;
		case 0:
			puntuacion = puntuacion * 0;
			resultadosPartida[i] = "-";
			break;
		default:
			break;
		}
		System.out.println("La puntuacion obtenida es: " + puntuacion);
		this.puntuacion[i] = puntuacion;
	}

	public int calcularPuntuacion() {
		int suma = 0;
		for (int i = 0; i < puntuacion.length; i++) {
			suma = suma + puntuacion[i];
		}
		return suma;
	}

	public void mostrarPuntuacion() {
		System.out.println("\nPuntuacion de "+name);
		System.out.println(Arrays.toString(puntuacion));
		System.out.println(Arrays.toString(resultadosPartida));
		System.out.println("La puntuación total de "+name+" es: "+calcularPuntuacion());
	}
	
	public int calcularDianas() {
		int dianas = 0;
		for (int i = 0; i < resultadosPartida.length; i++) {
			if(resultadosPartida[i] == "D") {
				dianas++;
			}
		}
		return dianas;
	}
	public void reiniciarPartida() {
		
	}

}
