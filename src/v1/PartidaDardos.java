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
	private static String nombreJugadorRecord = "Aun no se ha superado";
	
	private static int recordDianas;
	private static String jugadorRecordDianas = "Aun no se ha superado";
	
	/**COMPROBAMOS SI SE HA SUPERADO EL RECORD Y MOSTRAMOS LA INFORMACIÓN
	 * @param player Recibe un parametro de tipo jugador para luego si necesitamos el nombre
	 * la puntuación o similar la extraemos de la clase Jugador */
	public static boolean comprobarRecord(Jugador player) {
		if (player.calcularPuntuacion() > puntuacionRecord) {
			System.out.println("\n¡RECORD DE PUNTOS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + puntuacionRecord
					+ " y pertecia a " + nombreJugadorRecord);
			puntuacionRecord = player.calcularPuntuacion();
			nombreJugadorRecord = player.getName();
			System.out.println("El nuevo record es: " + puntuacionRecord + "\nEl record lo ha superado el jugador "
					+ nombreJugadorRecord);
			return true;
		} else {
			System.out.println("No se ha superado el record de puntos");
			return false;
		}
	}
	
	/**COMPROBAMOS SI SE HA SUPERADO EL RECORD DE DIANAS Y MOSTRAMOS LA INFORMACIÓN
	 * @param player Recibe un parametro de tipo jugador para luego si necesitamos el nombre
	 * la puntuación o similar la extraemos de la clase Jugador */
	public static boolean comprobarDianas(Jugador player) {
		if (player.calcularDianas() > recordDianas) {
			System.out.println("\n¡RECORD DE DIANAS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + recordDianas
					+ " y pertecia a " + jugadorRecordDianas);
			recordDianas = player.calcularDianas();
			jugadorRecordDianas = player.getName();
			System.out.println("El nuevo record es: " + recordDianas + "\nEl record lo ha superado el jugador "
					+ jugadorRecordDianas);
			return true;
		} else {
			System.out.println("No se ha superado el record de dianas");
			return false;
		}
	}
	
	static int numeroDeRondas = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String reinicio = "si";
		do {
			System.out.println("Introduce el nombre del primer jugador: ");
			String name = sc.nextLine();
			Jugador player1 = new Jugador(name);
			System.out.println("Introduce el nombre del segundo jugador: ");
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
				comprobarRecord(player1);
			} else if (puntuacion1 < puntuacion2) {
				System.out.println("Ha ganado: " + player2.getName());
				comprobarRecord(player2);
			} else {
				System.out.println("Los dos jugadores han conseguido la misma puntuación");
				comprobarRecord(player1);
			}

			// COMPROBAMOS EL NUMERO DE DIANAS
			System.out.println("\n");
			int dianasP1 = player1.calcularDianas();
			int dianasP2 = player2.calcularDianas();

			if (dianasP1 > dianasP2) {
				System.out.println("Ha dado más veces a la diana: " + player1.getName());
				comprobarDianas(player1);
			} else if (dianasP1 < dianasP2) {
				System.out.println("Ha dado más veces a la diana: " + player2.getName());
				comprobarDianas(player2);
			} else {
				System.out.println("Han empatado en el numero de dianas los dos jugadores");
				comprobarDianas(player1);
			}
			//Preguntamos si quiere reiniciar y convertimos la respuesta a minusculas para aceptar todas las conbinaciones
			//posibles de decir "si"
			System.out.print("\n¿Quieres reiniciar la partida? ");
			reinicio = sc.nextLine().toLowerCase();
		} while (reinicio.equals("si"));
		sc.close();

	}

}
