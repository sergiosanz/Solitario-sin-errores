package solitario;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solitario extends Applet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int NUM_CARTAS = 52;
	public static final int CPP=13;
	Image imagen;
    Graphics noseve;
	String nombres[]={"_of_clubs.png","_of_diamonds.png","_of_hearts.png","_of_spades.png"};
	Image imagenes[];
	Baraja baraja;
	Image imgReverso;
	Rectangle reverso;
	List<Carta> cartasExtraidas;
	Carta activa;
	
	public void init() {
		imagen = createImage(700, 700);
    	noseve = imagen.getGraphics();
		imagenes = new Image[NUM_CARTAS];
		imgReverso = getImage(getCodeBase(),"Cartas/reverso.png");
		for(int i=0; i<4; i++)
			for(int j=0;j<13;j++)
				imagenes[(i*CPP)+j]= getImage(getCodeBase(),"cartas/"+(j+1)+nombres[i]);
		baraja = new Baraja(imagenes);
		reverso = new Rectangle(20, 20, 70,120);
		baraja.barajar();
		cartasExtraidas = new ArrayList<Carta>();
	}

	public void paint(Graphics g){
		noseve.setColor(Color.green);
		noseve.fillRect(0, 0, 700, 700);
		noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
		for (int i = 0; i < cartasExtraidas.size(); i++)
			cartasExtraidas.get(i).dibujar(noseve, this);
		if(activa != null)
			activa.dibujar(g, this);
		g.drawImage(imagen, 0, 0, this);
		
	}
	
	public void update(Graphics g){
    	paint(g);
    }
	
	public boolean mouseDown(Event e, int x, int y){
		if(reverso.contains(x,y)){
			cartasExtraidas.add(baraja.sacar());
			cartasExtraidas.get(cartasExtraidas.size()-1).setPosx(110);
			cartasExtraidas.get(cartasExtraidas.size()-1).setPosy(20);
		}
		if(cartasExtraidas.get(cartasExtraidas.size()-1).contains(x,y)){
			activa = cartasExtraidas.get(cartasExtraidas.size()-1);
			//cartasExtraidas.remove(cartasExtraidas.size()-1);
		}
		repaint();
		return true;
	}
	
	public boolean mouseDrag(Event e, int x, int y){
		if(activa != null){
			activa.setPosx(x - Carta.ANCHURA/2);
			activa.setPosy(y - Carta.ALTURA/2);
			repaint();
		}
		return true;
	}
	
	public boolean mouseUp(Event e, int x, int y){
		if(activa != null){
			activa.setPosx(110);
			activa.setPosy(20);
			repaint();
			//cartasExtraidas.add(activa);
			activa = null;
		}
		return true;
	}
}