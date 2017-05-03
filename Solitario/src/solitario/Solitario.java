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
	MazoSecundario mazoB;
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
		mazoB = new MazoSecundario();
		baraja.barajar();
	}

	public void paint(Graphics g){
		noseve.setColor(Color.green);
		noseve.fillRect(0, 0, 700, 700);
		noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
		mazoB.mostrar(noseve, this);
		if(activa != null)
			activa.dibujar(g, this);
		g.drawImage(imagen, 0, 0, this);
		
	}
	
	public void update(Graphics g){
    	paint(g);
    }
	
	public boolean mouseDown(Event e, int x, int y){
		if(reverso.contains(x,y)){
			mazoB.anadir(baraja.sacar());
			mazoB.recolocar();		
		}
		if(mazoB.extraer().contains(x,y)){
			activa = mazoB.extraer();
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
			mazoB.recolocar();
			activa = null;
			repaint();
		}
		return true;
	}
}