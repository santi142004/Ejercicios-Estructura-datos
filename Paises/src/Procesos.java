
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {

	ModeloDatos miData;
	ArrayList<String> listCiudades;

	public Procesos() {
		miData = new ModeloDatos();
		iniciar();

	}

	private void iniciar() {

		String str = "1. Registrar Paises\n";
		str += "2. Consultar pais y sus ciudades\n";
		str += "3. Consultar Ciudades\n";
		str += "4. Salir\n";

		int opc = 0;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(str));
			crearMenu(opc);
		} while (opc != 4);

	}

	private void crearMenu(int opc) {

		switch (opc) {
		case 1:
			ingresarDatos();
			break;
		case 2:
			consultarPorPaisCiudades();
			break;
		case 3:
			consultarPorPais();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Has salido exitosamente");
			break;
		default:
			break;
		}

	}

	private void consultarPorPais() {
		String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad a buscar");
		miData.buscarCiudad(ciudad, listCiudades);
		
	}

	private void consultarPorPaisCiudades() {
		
		String pais = JOptionPane.showInputDialog("Ingrese el pais para consultar sus ciudades");
		miData.buscarPais(pais);
		
	}

	private void ingresarDatos() {

		String nuevoPais;
		String ingresar = "";

		do {

			nuevoPais = JOptionPane.showInputDialog("Ingrese un pais");
			listCiudades = new ArrayList<>();
			ingresarCiudades();
			miData.guardarDatos(nuevoPais, listCiudades);
			ingresar = JOptionPane.showInputDialog("Quiere ingresar otro pais? si/no");

		} while (ingresar.equalsIgnoreCase("si"));

	}

	private void ingresarCiudades() {

		int cont = 1;
		String ciudad = "";
		String otraC = "";
		do {
			ciudad = JOptionPane.showInputDialog("Ingrese la ciudad " + cont);
			listCiudades.add(ciudad);
			otraC = JOptionPane.showInputDialog("¿Quiere ingresar otra ciudad?");
			cont++;
		} while (otraC.equalsIgnoreCase("si"));

	}


}