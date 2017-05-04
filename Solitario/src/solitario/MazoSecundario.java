package solitario;

import java.util.List;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class MazoSecundario {
	List<Carta> mazo;
	public static final int POSICIONX = 110;
	public static final int POSICIONY= 20;
	
	public MazoSecundario(){
		mazo = new ArrayList<Carta>();
	}
	
	public void mostrar(Graphics g, Applet a){
		for (int i = 0; i < mazo.size(); i++) {
			mazo.get(i).dibujar(g, a);
		}
	}
	
	public void anadir(Carta carta){
		mazo.add(carta);
	}
	
	public Carta extraer(){
		return mazo.get(mazo.size()-1);
	}
	
	public void eliminar(){
		mazo.remove(mazo.size()-1);
	}
	
	public void recolocar(){
		mazo.get(mazo.size()-1).setPosx(POSICIONX);
		mazo.get(mazo.size()-1).setPosy(POSICIONY);
	}

}
