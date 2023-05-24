import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ModeloDatos {

	HashMap<String, ArrayList<String>> mapPaises;

	public ModeloDatos() {
		mapPaises = new HashMap<String, ArrayList<String>>();
	}

	public void guardarDatos(String nuevoPais, ArrayList<String> listCiudades) {

		mapPaises.put(nuevoPais, listCiudades);
		JOptionPane.showMessageDialog(null, "Registro existoso!");
		JOptionPane.showMessageDialog(null, mapPaises + "\n");
	}

	public void buscarPais(String pais) {

		if (mapPaises.containsKey(pais)) {
			JOptionPane.showMessageDialog(null, mapPaises.get(pais));
		}

	}

	public void buscarCiudad(String ciudad, ArrayList<String> listCiudades) {
boolean preg=false;
		for (String pais : mapPaises.keySet()) {
			for (int i = 0; i < mapPaises.get(pais).size(); i++) {
				if (mapPaises.get(pais).get(i).equalsIgnoreCase(ciudad)) {
					preg= true;
					System.out.println("la ciudad " +ciudad+ " se encuentra en: " +pais);
				}
			} 
			if (preg) {
				System.out.println("no existe");
			}
		}
	}

}