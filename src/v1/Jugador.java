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

	/**Este metodo se encarga de realizar la partida y obtener y guardar los resultados para cada´
	 * jugador. Este se ejecuta una sola  vez para conseguir que juegen una partida cada uno.
	 * 
	 * @param i Recibe el numero de la tirada. Y lo guarda en el array en la casilla correspodiente.
	 * En caso de reinicio de partida el guardara los resultados en la posicion 0 en adelante ya que el
	 * bucle FOR del main vuelve a 0 la variable que recibe este metodo
	 */
	public void jugarTurno(int i) {
		Random random = new Random();
		Scanner tecla = new Scanner(System.in);

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
			puntuacion = 0;
			resultadosPartida[i] = "-";
			break;
		default:
			break;
		}
		System.out.println("La puntuacion obtenida es: " + puntuacion);
		this.puntuacion[i] = puntuacion;
		tecla.nextLine();
	}

	/**
	 * Este medodo calcula la puntuacion recorriendo el array global y sumando cada casilla
	 * del array puntuacion, lo suma y lo devuelve
	 * @return Devuelve un int que dice el resultado del jugador
	 */
	public int calcularPuntuacion() {
		int suma = 0;
		for (int i = 0; i < puntuacion.length; i++) {
			suma = suma + puntuacion[i];
		}
		return suma;
	}

	/**Aqui tenemos el metodo mostrar puntuacion que mostramos el contenido del array y la puntuacion 
	 * total llamando al metodo calcularPuntuacion.
	 */
	public void mostrarPuntuacion() {
		System.out.println("\nPuntuacion de "+name);
		System.out.println(Arrays.toString(puntuacion));
		System.out.println(Arrays.toString(resultadosPartida));
		System.out.println("La puntuación total de "+name+" es: "+calcularPuntuacion());
	}
	
	/**Este metodo calcula el numero total de dianas recorriendo el array de resultadosPartida
	 * y comprobando que si pone D es diana y sumamos 1 al contador del numero total de dianas
	 * @return Devuelve el entero que es el total de veces que hemos dado a la diana
	 */
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
