
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Procesos {

	String nombre = "";
	double imc, peso, talla;
	ArrayList<String> nombresList;
	ArrayList<String> resultadosList;

	public Procesos() {
		nombresList = new ArrayList<String>();
		resultadosList = new ArrayList<String>();
		iniciar();
	}

	public void iniciar() {

		String menu = "MENU\n";
		menu = "1. Ingresar Datos.\n";
		menu += "2. Consultar IMC\n";
		menu += "3. Mostrar lista\n";
		menu += "4. Buscar por nombre\n";
		menu += "5. Actualizar persona\n";
		menu += "6. Eliminar persona\n";
		menu += "7. Salir";

		int opc = 0;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			crearMenu(opc);
		} while (opc != 7);
	}

	private void crearMenu(int opc) {

		switch (opc) {
		case 1:
			ingresarDatos();
			break;
		case 2:
			if (validarLlenado()) {
				consultarIMC();
			}
			break;
		case 3:
			if (validarLlenado()) {
				imprimirListas();
			}
			break;
		case 4:
			if (validarLlenado()) {
				consultarPorNombre();
			}
			break;
		case 5:
			if (validarLlenado()) {
				actualizar();
			}
			break;
		case 6:
			if(validarLlenado()) {
				eliminar();
			}
			break;
		case 7:
			break;
		default:
			JOptionPane.showMessageDialog(null, "No existe el codigo");
			break;
		}

	}

	private boolean validarLlenado() {
		if (!nombresList.isEmpty()) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Tiene que ingresar datos");
		return false;
	}

	private void consultarPorNombre() {

		String nombreConsulta = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		if (nombresList.contains(nombreConsulta)) {
			for (int i = 0; i < nombresList.size(); i++) {
				if (nombresList.get(i).equalsIgnoreCase(nombreConsulta)) {
					System.out.println("Si existe " + nombreConsulta + "," + " tiene " + resultadosList.get(i));
				}
			}

			System.out.println("Imprime usando foreach");
			for (String elemento : nombresList) {
				int pos = nombresList.indexOf(elemento);
				if (nombresList.get(pos).equalsIgnoreCase(nombreConsulta)) {
					System.out.println(elemento + ", resultado= " + resultadosList.get(pos));

				}
			}

		} else {
			System.out.println("NO existe");
		}

	}

	public void imprimirListas() {

		String lista = "";

		for (int i = 0; i < nombresList.size(); i++) {
			lista += nombresList.get(i) + ", resultado: " + resultadosList.get(i) + "\n";

		}

		JOptionPane.showMessageDialog(null, lista);
	}

	private void ingresarDatos() {

		String ingresarMas = "";

		do {

			nombre = JOptionPane.showInputDialog("Ingrese el nombre");
			nombresList.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));

			ingresarMas = JOptionPane.showInputDialog("Quieres ingresar otra persona? si/no");

			calcularIMC();

		} while (ingresarMas.equalsIgnoreCase("si"));

	}

	private void calcularIMC() {

		String result = "";
		imc = peso / (talla * talla);

		if (imc < 18) {
			result = ("Anorexia");
		} else if (imc >= 18 && imc < 20) {
			result = ("Delgadez");
		} else if (imc >= 20 && imc < 27) {
			result = ("Normalidad");
		} else if (imc >= 27 && imc < 30) {
			result = ("Obesidad 1");
		} else if (imc >= 30 && imc < 35) {
			result = ("Obesidad 2");
		} else if (imc >= 35 && imc < 40) {
			result = ("Obesidad 3");
		} else if (imc >= 40) {
			result = ("Obesidad Morbida");
		}

		resultadosList.add(result);

	}

	private void consultarIMC() {

		String nombre = JOptionPane
				.showInputDialog("Ingrese el nombre de la persona a la cual desea calcularle el IMC");

		for (int i = 0; i < nombresList.size(); i++) {

			if (nombresList.get(i).contains(nombre)) {
				JOptionPane.showMessageDialog(null, "El resultado es: " + resultadosList.get(i));
				
			}
		}

	}
	
	private void actualizar() {
	    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona a actualizar");

	    if (nombresList.contains(nombre)) {
	        for (int i = 0; i < nombresList.size(); i++) {
	            if (nombresList.get(i).equalsIgnoreCase(nombre)) {
	            	String nuevonomb = JOptionPane.showInputDialog("Ingrese nombre nuevo");
					nombresList.set(i, nuevonomb);
					System.out.println(nombresList);
	                peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso"));
	                talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva talla"));

	                calcularIMC(); 

	                JOptionPane.showMessageDialog(null, "Persona actualizada correctamente");
	                return; 
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "La persona no existe");
	    }
	}

	private void eliminar() {
	    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona a eliminar");

	    if (nombresList.contains(nombre)) {
	        int indice = -1;

	        for (int i = 0; i < nombresList.size(); i++) {
	            if (nombresList.get(i).equalsIgnoreCase(nombre)) {
	                indice = i;
	                break;
	            }
	        }

	        if (indice != -1) {
	            nombresList.remove(indice);
	            resultadosList.remove(indice);
	            JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "La persona no existe");
	    }
	}

}


