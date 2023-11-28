/**
 * 
 */
package v2;

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

	/**
	 * Este metodo se encarga de realizar la partida y obtener y guardar los
	 * resultados para cada´ jugador. Este se ejecuta una sola vez para conseguir
	 * que juegen una partida cada uno.
	 * 
	 * @param i Recibe el numero de la tirada. Y lo guarda en el array en la casilla
	 *          correspodiente. En caso de reinicio de partida el guardara los
	 *          resultados en la posicion 0 en adelante ya que el bucle FOR del main
	 *          vuelve a 0 la variable que recibe este metodo
	 */
	public void jugarTurno(int i) {
		Random random = new Random();
		Scanner tecla = new Scanner(System.in);
		resultadosPartida[i]="";

		System.out.println("Turno de " + name + ". Lanza un dardo.");
		int tresTiradas = 0;
		int puntuacion = 0, global = 0;
		do {
			puntuacion = random.nextInt(20) + 1;
			int multiplicador = random.nextInt(6) + 1;

			switch (multiplicador) {
			case 2, 4:
				puntuacion = puntuacion * 1;
				resultadosPartida[i] = resultadosPartida[i] + "- ";
				break;
			case 1:
				puntuacion = puntuacion * 2;
				resultadosPartida[i] = resultadosPartida[i] + "x2 ";
				break;
			case 3:
				puntuacion = puntuacion * 3;
				resultadosPartida[i] = resultadosPartida[i] + "x3 ";
				break;
			case 5:
				puntuacion = 25;
				resultadosPartida[i] = resultadosPartida[i] + "D ";
				break;
			case 6:
				puntuacion = 50;
				resultadosPartida[i] = resultadosPartida[i] + "D ";
				break;
			case 0:
				puntuacion = puntuacion * 0;
				resultadosPartida[i] = resultadosPartida[i] + "- ";
				break;
			default:
				break;
			} 
			tresTiradas++;
			System.out.println("Resultado de la tirada "+tresTiradas+" es "+puntuacion);
			global = global + puntuacion;
		}while (tresTiradas < 3);
		System.out.println("La puntuacion obtenida en total es: " + global);
		this.puntuacion[i] = global;
		tecla.nextLine();
	}

	/**
	 * Este medodo calcula la puntuacion recorriendo el array global y sumando cada
	 * casilla del array puntuacion, lo suma y lo devuelve
	 * 
	 * @return Devuelve un int que dice el resultado del jugador
	 */
	public int calcularPuntuacion() {
		int suma = 0;
		for (int i = 0; i < puntuacion.length; i++) {
			suma = suma + puntuacion[i];
		}
		return suma;
	}

	/**
	 * Aqui tenemos el metodo mostrar puntuacion que mostramos el contenido del
	 * array y la puntuacion total llamando al metodo calcularPuntuacion.
	 */
	public void mostrarPuntuacion() {
		System.out.println("\nPuntuaciones de " + name);
		System.out.println(Arrays.toString(puntuacion));
		
		System.out.println("\nLa puntuación total de " + name + " es: " + calcularPuntuacion());
		System.out.println(calcularTiradas());
		//System.out.println("Ha dado a la diana: "+numeroDianas+" veces.\nHa sacado doble: "+numeroDobles+" veces.\nHa sacado triple: "+numerotriples+" veces");
	}
	
	public String calcularTiradas() {
		String split = Arrays.toString(resultadosPartida);
		split = split.replaceAll(",", "");
		split = split.replaceAll(" ", "");
		int dianas = 0, dobles = 0, triples = 0;
		String A = "";
		
		for (int i = 0; i < split.length(); i++) {
			A = new StringBuilder(split.charAt(i)).toString();
			if (A.equals("D")) {
				dianas++;
				System.out.println("D");
			}
			if (A.equals("x2")) {
				dobles++;
				System.out.println("x2");
			}
			if (A.equals("x3")) {
				dobles++;
				System.out.println("x3");
			}
		}
		return "Ha sacado "+dianas+" dianas.\nHa sacado "+dobles+" dobles.\nHa sacado "+triples+" triples.";
	}

	/**
	 * Este metodo calcula el numero total de dianas recorriendo el array de
	 * resultadosPartida y comprobando que si pone D es diana y sumamos 1 al
	 * contador del numero total de dianas
	 * 
	 * @return Devuelve el entero que es el total de veces que hemos dado a la diana
	 */
	public int calcularDianas() {
		int dianas = 0;
		for (int i = 0; i < resultadosPartida.length; i++) {
			if (resultadosPartida[i] == "D") {
				dianas++;
			}
		}
		return dianas;
	}

}
