/**
 * 
 */
package bonus;

import java.util.*;

/**
 * 
 */
public class PartidaDardos {

	private static int puntuacionRecord;
	private static String nombreJugadorRecord = "Aun no se ha superado";

	private static int recordDianas;
	private static String jugadorRecordDianas = "Aun no se ha superado";
	
	private static int recordRondas501;
	private static String precordRondas501 = "Aun no se ha superado";

	/**
	 * COMPROBAMOS SI SE HA SUPERADO EL RECORD Y MOSTRAMOS LA INFORMACIÓN
	 * 
	 * @param player Recibe un parametro de tipo jugador para luego si necesitamos
	 *               el nombre la puntuación o similar la extraemos de la clase
	 *               Jugador
	 * @return Devuelve un boolean por si se cumple o no la condición. En el caso de
	 *         este metodo no lo voy a usar posteriormente ya que el metodo
	 *         actualiza los records
	 */
	public static boolean comprobarRecord(Jugador player) {
		if (player.calcularPuntuacion() > puntuacionRecord) {
			System.out.println("\n¡RECORD DE PUNTOS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + puntuacionRecord
					+ " y pertenecia a " + nombreJugadorRecord);
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

	/**
	 * COMPROBAMOS SI SE HA SUPERADO EL RECORD DE DIANAS Y MOSTRAMOS LA INFORMACIÓN
	 * 
	 * @param player Recibe un parametro de tipo jugador para luego si necesitamos
	 *               el nombre la puntuación o similar la extraemos de la clase
	 *               Jugador
	 * @return Devuelve un boolean por si se cumple o no la condición. En el caso de
	 *         este metodo no lo voy a usar posteriormente ya que el metodo
	 *         actualiza los records
	 */
	public static boolean comprobarDianas(Jugador player) {
		if (player.calcularDianas() > recordDianas) {
			System.out.println("\n¡RECORD DE DIANAS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + recordDianas
					+ " y pertenecia a " + jugadorRecordDianas);
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
	
	/**
	 * COMPROBAMOS SI SE HA SUPERADO EL RECORD DE DIANAS Y MOSTRAMOS LA INFORMACIÓN
	 * 
	 * @param player Recibe un parametro de tipo jugador para luego si necesitamos
	 *               el nombre la puntuación o similar la extraemos de la clase
	 *               Jugador
	 * @return Devuelve un boolean por si se cumple o no la condición. En el caso de
	 *         este metodo no lo voy a usar posteriormente ya que el metodo
	 *         actualiza los records
	 */
	public static boolean comprobarRondas501(Jugador player, int rondas) {
		if (player.calcularDianas() > recordDianas) {
			System.out.println("\n¡RECORD DE RONDAS!");
			System.out.println("Se ha superado el record registrado.\nActualmente era de " + recordRondas501
					+ " y pertenecia a " + precordRondas501);
			recordRondas501 = rondas;
			jugadorRecordDianas = player.getName();
			System.out.println("El nuevo record es: " + recordRondas501 + "\nEl record lo ha superado el jugador "
					+ precordRondas501);
			return true;
		} else {
			System.out.println("No se ha superado el record de dianas");
			return false;
		}
	}

	private static int numeroDeRondas = 10;

	public static void setnumeroDeRondas(int nRondas) {
		numeroDeRondas = nRondas;
	}

	public static int getnumeroDeRondas() {
		return numeroDeRondas;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String reinicio;
		do {
			//PEDIMOS LOS NOMBRES DE LOS JUGADORES
			System.out.print("Introduce tu nombre: ");
			String name = sc.nextLine();
			Jugador player1 = new Jugador(name);
			System.out.print("Introduce tu nombre: ");
			name = sc.nextLine();
			Jugador player2 = new Jugador(name);
			
			//MENU DEL MODO DE JUEGO
			int modoJuego;
			System.out.println("-------------------------");
			System.out.println("¡Bienvenido a DAWR-DOS1!\nIntroduce el numero del modo al que quieres jugar");
			System.out.println("1. Partida normal a 10\n2. Partida a 501");
			System.out.print("\n¿A que modo quieres jugar? ");
			modoJuego = sc.nextInt();

			//El modoJuego == 1, es el primer modo el normal a 10 rondas
			//El modoJuego == 2, es el segundo modo de juego a 501
			if (modoJuego == 1) {
				for (int i = 0; i < numeroDeRondas; i++) {
					player1.jugarTurno(i);
					player2.jugarTurno(i);
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
				}
			} else if (modoJuego == 2) {
				int i = 0;
				//Llamamos a los metodos correspondientes para jugar partida
				//Comprobamos que si el primer jugador ha llegado a 501 no juega su partida el segundo jugador
				//
				do {
					if (player1.calcularPuntuacion() < 501 && player2.calcularPuntuacion() < 501) {
						player1.jugarTurno(i);
					}
					if (player1.calcularPuntuacion() < 501 && player2.calcularPuntuacion() < 501) {
						player2.jugarTurno(i);
					}
					i++;
				} while ( player1.calcularPuntuacion() < 501 && player2.calcularPuntuacion() < 501 );
				System.out.println("Uno de los jugadores ha alcanzado o superado 501 puntos");
				//Llamamos al metodo mostrar puntuacion
				player1.mostrarPuntuacion();
				player2.mostrarPuntuacion();
				
				// COMPROBAMOS QUIEN HA GANADO Y TAMBIÉN COMPROBAMOS EL RECORD DE RONDAS
				int puntuacion1 = player1.calcularPuntuacion();
				int puntuacion2 = player2.calcularPuntuacion();
				System.out.println("\n");
				if (puntuacion1 > puntuacion2) {
					System.out.println("Ha ganado: " + player1.getName());
					comprobarRondas501(player1, i+1);
				} else if (puntuacion1 < puntuacion2) {
					System.out.println("Ha ganado: " + player2.getName());
					comprobarRondas501(player2, i+1);
				} else {
					System.out.println("Los dos jugadores han conseguido la misma puntuación.\nSe va a guardar el nombre del primer jugador");
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
					System.out.println("Han empatado en el numero de dianas los dos jugadores.\nSe va a guardar el nombre del primer jugador");
					comprobarDianas(player1);
				}
			}
			//Preguntamos si quiere reiniciar y convertimos la respuesta a minusculas para aceptar todas las conbinaciones
			//posibles de decir "si"
			System.out.print("\n¿Quieres reiniciar la partida? ");
			sc.nextLine();
			reinicio = sc.nextLine().toLowerCase();
			if(!reinicio.equals("si")) {
				System.out.println("Gracias por jugar a DAWR-DOS1\nEsperamos verte de vuelta pronto.");
			}
		} while (reinicio.equals("si"));
		sc.close();

	}

}
