import javax.swing.JOptionPane;

public class Procesos {
	String nombres[], resultados[];
	double peso, talla, imc;
	int tam;
	String result = "";

	public void inicar() {
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
    private void eliminar() {
        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la persona a eliminar");

        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombreEliminar)) {
                nombres[i] = null;
                resultados[i] = null;
                JOptionPane.showMessageDialog(null, "Persona eliminada exitosamente.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con ese nombre.");
    }

    private void actualizar() {
        String nombreActualizar = JOptionPane.showInputDialog("Ingrese el nombre de la persona a actualizar");

        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombreActualizar)) {
                nombres[i] = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso"));
                talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva talla"));
                calcularIMC();
                resultados[i] = result;
                JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con ese nombre.");
    }
	public boolean validarLlenado() {
		if (nombres != null) {
			return true;
		} else {
			System.out.println("Debe llenar datos");
			return false;
		}
	}

	private void ingresarDatos() {
		 tam= Integer.parseInt(JOptionPane.showInputDialog("Ingresa cantidad de personas"));
		nombres= new String[tam];
		resultados= new String[tam];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre");
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
			calcularIMC();
			resultados[i] = result;}
		}
		
	
	private void calcularIMC() {

		
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
		
	}	
	private void consultarIMC() {
		String nombre = JOptionPane
				.showInputDialog("Ingrese el nombre de la persona a la cual desea calcularle el IMC");

		for (int i = 0; i < nombres.length; i++) {

			if (nombres[i].contains(nombre)) {
				JOptionPane.showMessageDialog(null, "El resultado de " +nombre+ " es: "  + resultados[i]);
			
			}
		}
		
	}
	private void imprimirListas() {
		String lista = "";

		for (int i = 0; i < nombres.length; i++) {
			lista += nombres[i] + ", resultado: " + resultados[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, lista);
	}
	
	private void consultarPorNombre() {
		String nombreConsulta = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		for (int i = 0; i < nombres.length; i++) {
		if (nombres[i].equalsIgnoreCase(nombreConsulta)|| nombres[i].contains(nombreConsulta)) {
					System.out.println("Si existe " + nombreConsulta + "," + " tiene " + resultados[i]);
				
			}
		}
	}

}
