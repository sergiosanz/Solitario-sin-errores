package solitario;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public class MazoSecundario {
	java.util.List<Carta> mazoB;
	public static final int POSICIONX = 110;
	public static final int POSICIONY= 20;
	
	public MazoSecundario(){
		mazoB = new ArrayList<Carta>();
	}
	
	public void anadir(Carta carta){
		mazoB.add(carta);
	}
	
	public Carta extraer(){
		return mazoB.get(mazoB.size()-1);
	}
	
	public void remove(){
		mazoB.remove(mazoB.size()-1);
	}
	
	public void recolocar(){
		mazoB.get(mazoB.size()-1).setPosx(POSICIONX);
		mazoB.get(mazoB.size()-1).setPosy(POSICIONY);	
	}
	
	public void mostrar(Graphics g, Applet a){
		for (int i = 0; i < mazoB.size(); i++) {
			mazoB.get(i).dibujar(g, a);
		}
		
	}
}