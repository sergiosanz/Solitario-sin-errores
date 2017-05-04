package solitario;

import java.applet.Applet;
import java.awt.*;

public class MazoPalo extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	java.util.List<Carta> mazo;
	public static final int POSICIONY = 20;
	int palo = -1;
	
	public MazoPalo(int px){
		super(px, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
		mazo = new java.util.ArrayList<Carta>();
	}
	
	public boolean anadir(Carta carta){
		if(palo != -1 || carta.getPalo() == palo){
			mazo.add(carta);
			recolocar();
		}else{
			palo = carta.getPalo();
			mazo.add(carta);
			recolocar();
		}
		
	}
	
	public Carta extraer(){
		return mazo.get(mazo.size()-1);
	}
	
	public void recolocar(){
		mazo.get(mazo.size()-1).setPosx(x);
		mazo.get(mazo.size()-1).setPosy(y);
	}
	
	public void mostrar(Graphics g, Applet a){
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		for (int i = 0; i < mazo.size(); i++) {
			mazo.get(i).dibujar(g, a);
		}
	}
}
