package gui;

/*
 * File: ElementoSubArbol.java
 * Version: 1.0
 * Author: Sergio Lázaro
 */
 
import java.util.ArrayList;

public class ElementoSubArbol {
   private ArrayList<String> estilos;
   private String tipoPrenda;

   public ElementoSubArbol(String tipoPrenda, ArrayList<String> estilos) {
      this.tipoPrenda = tipoPrenda;
      this.estilos = estilos;
   }

   public ArrayList<String> getEstilos() {
      return estilos;
   }

   public String getTipoPrenda() {
      return tipoPrenda;
   }

   public void setEstilos(ArrayList<String> estilos) {
      this.estilos = estilos;
   }

   public void setTipoPrenda(String tipoPrenda) {
      this.tipoPrenda = tipoPrenda;
   }
}
