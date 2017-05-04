package solitario;

import java.applet.Applet;
import java.awt.*;

public class Solitario extends Applet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int NUM_CARTAS = 52;
	public static final int NUM_PALOS = 4;
	public static final int CPP=13;
	Image imagen;
    Graphics noseve;
    Image fondo;
	String nombres[]={"_of_clubs.png","_of_diamonds.png","_of_hearts.png","_of_spades.png"};
	Image imagenes[];
	Baraja baraja;
	Image imgReverso;
	Rectangle reverso;
	//List<Carta> cartasExtraidas;
	MazoSecundario mazoB;
	Carta activa;
	MazoPalo mPalos[];
	
	public void init() {
		imagen = createImage(700, 700);
    	noseve = imagen.getGraphics();
		imagenes = new Image[NUM_CARTAS];
		fondo = getImage(getCodeBase(),"Cartas/tapete.jpg");
		imgReverso = getImage(getCodeBase(),"Cartas/reverso.png");
		for(int i=0; i<NUM_PALOS; i++)
			for(int j=0;j<CPP;j++)
				imagenes[(i*CPP)+j]= getImage(getCodeBase(),"cartas/"+(j+1)+nombres[i]);
		baraja = new Baraja(imagenes);
		reverso = new Rectangle(20, 20, 70,120);
		baraja.barajar();
		mazoB = new MazoSecundario();
		mPalos = new MazoPalo[NUM_PALOS];
		for (int i = 0; i < mPalos.length; i++) {
			mPalos[i] = new MazoPalo(300 + (i*100));
		}
	}

	public void paint(Graphics g){
		noseve.setColor(Color.green);
		noseve.fillRect(0, 0, 700, 700);
		noseve.drawImage(fondo, 0, 0, 700, 700, this);
		noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
		for (int i = 0; i < NUM_PALOS; i++) {
			mPalos[i].mostrar(noseve, this);
		}
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
			boolean encontrado = false;
			for (int i = 0; i < mPalos.length; i++) {
				if(mPalos[i].intersects(activa)){
					mPalos[i].anadir(mazoB.extraer());
					mazoB.eliminar();
					encontrado = true;
					break;
				}
			}
			if(encontrado)
				mazoB.recolocar();
			activa = null;
			repaint();
		}
		
		return true;
	}
}