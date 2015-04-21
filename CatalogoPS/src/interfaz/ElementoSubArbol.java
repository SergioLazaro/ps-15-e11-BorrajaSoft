package interfaz;

import java.util.ArrayList;

public class ElementoSubArbol {
	
	private String tipoPrenda;
	private ArrayList<String> estilos;
	
	public ElementoSubArbol(String tipoPrenda, ArrayList<String> estilos) {
		this.tipoPrenda = tipoPrenda;
		this.estilos = estilos;
	}

	public String getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public ArrayList<String> getEstilos() {
		return estilos;
	}

	public void setEstilos(ArrayList<String> estilos) {
		this.estilos = estilos;
	}
	
	
	
	
}
