/**
 * 
 */
package v1;

import java.util.Scanner;

/**
 * 
 */
public class PartidaDardos {

	private static int puntuacionRecord;
	private static String nombreJugadorRecord;

	public static void comprobarRecord(int puntuacionActual, String name) {
		if (puntuacionRecord < puntuacionActual) {
			System.out.println("\n¡RECORD DE PUNTOS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + puntuacionRecord
					+ " y pertecia a " + nombreJugadorRecord);
			puntuacionRecord = puntuacionActual;
			nombreJugadorRecord = name;
			System.out.println("El nuevo record es: " + puntuacionRecord + "\nEl record lo ha superado el jugador "
					+ nombreJugadorRecord);
		}
	}

	private static int recordDianas;
	private static String jugadorRecordDianas;

	public static void comprobarNDianas(int NDianas, String name) {
		if (recordDianas < NDianas) {
			System.out.println("\n¡RECORD DE DIANAS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + recordDianas
					+ " y pertecia a " + jugadorRecordDianas);
			recordDianas = NDianas;
			jugadorRecordDianas = name;
			System.out.println("El nuevo record es: " + recordDianas + "\nEl record lo ha superado el jugador "
					+ jugadorRecordDianas);
		}
	}

	static int numeroDeRondas = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String reinicio = "si";
		do {
			System.out.println("Introduce tu nombre:");
			String name = sc.nextLine();
			Jugador player1 = new Jugador(name);
			System.out.println("Introduce tu nombre:");
			name = sc.nextLine();
			Jugador player2 = new Jugador(name);

			for (int i = 0; i < numeroDeRondas; i++) {
				player1.jugarTurno(i);
				player2.jugarTurno(i);
			}
			player1.mostrarPuntuacion();
			player2.mostrarPuntuacion();

			// COMPROBAMOS QUIEN HA GANADO
			int puntuacion1 = player1.calcularPuntuacion();
			int puntuacion2 = player2.calcularPuntuacion();
			System.out.println("\n");
			if (puntuacion1 > puntuacion2) {
				System.out.println("Ha ganado: " + player1.getName());
				comprobarRecord(puntuacion1, player1.getName());
			} else if (puntuacion1 < puntuacion2) {
				System.out.println("Ha ganado: " + player2.getName());
				comprobarRecord(puntuacion2, player2.getName());
			} else {
				System.out.println("Los dos jugadores han conseguido la misma puntuación");
				comprobarRecord(puntuacion1, player1.getName() + " y " + player2.getName());
			}

			// COMPROBAMOS EL NUMERO DE DIANAS
			System.out.println("\n");
			int dianasP1 = player1.calcularDianas();
			int dianasP2 = player2.calcularDianas();

			if (dianasP1 > dianasP2) {
				System.out.println("Ha dado más veces a la diana: " + player1.getName());
				comprobarNDianas(dianasP1, player1.getName());
			} else if (dianasP1 < dianasP2) {
				System.out.println("Ha dado más veces a la diana: " + player2.getName());
				comprobarNDianas(dianasP2, player2.getName());
			} else {
				System.out.println("Han empatado en el numero de dianas los dos jugadores");
				comprobarNDianas(dianasP1, player1.getName() + " y " + player2.getName());
			}

			System.out.print("\n¿Quieres reiniciar la partida? ");
			reinicio = sc.nextLine().toLowerCase();
		} while (reinicio.equals("si"));

	}

}
