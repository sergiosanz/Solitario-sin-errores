package solitario;

import java.awt.*;
import java.applet.*;

	public class Solitario extends Applet{
		public static final int NUM_CARTAS = 52;
		public static final int CPP=13;
		String nombres[]={"_of_clubs.png","_of_diamonds.png","_of_hearts.png","_of_spades.png"};
		Image imgReverso;
		Rectangle reverso;
		Image imagenes[];
		Baraja baraja;
		java.util.List<Carta> cartasExtraidas;
		public void init() {
				
			 	imagenes = new Image[NUM_CARTAS];
		    	for(int i=0; i<4; i++)
		    		for(int j=0;j<CPP;j++)
		    			imagenes[(i*CPP)+j]=getImage(getCodeBase(),"cartas/"+(j+1)+nombres[i]);
		    	imgReverso=getImage(getCodeBase(),"cartas/reverso.png");
		    	reverso=new Rectangle(20,20,70,120);
		      	baraja=new Baraja(imagenes);
		    	baraja.barajar();
		    	cartasExtraidas=new java.util.ArrayList();
		    }
		    
		public void paint(Graphics g){
			g.setColor(Color.green);
			g.fillRect(0, 0, 900, 700);
			g.drawImage(imgReverso , 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
			for (int i = 0; i < cartasExtraidas.size(); i++) {
				cartasExtraidas.get(i).dibujar(g,this);
			}
			

	}
		public boolean mouseDown(Event ev, int x, int y){
			if(reverso.contains(x,y)){
				cartasExtraidas.add(baraja.sacar());
				cartasExtraidas.get(cartasExtraidas.size()-1).setPosx(110);
				cartasExtraidas.get(cartasExtraidas.size()-1).setPosy(20);
				repaint();
			}
			return true;
		}
		
}	