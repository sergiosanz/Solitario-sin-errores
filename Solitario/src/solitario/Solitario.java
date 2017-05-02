package solitario;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class Solitario extends Applet {

	public static final int NUM_CARTAS = 52;
	public static final int CPP = 13;
	String nombres[] = { "_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png" };
	Image imagenes[];
	Image imgReverso;
	Baraja baraja;

	public void init() {

		imagenes = new Image[NUM_CARTAS];
		imgReverso = getImage(getCodeBase(),"cartas/reverso.png");
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < CPP; j++)
				imagenes[(i * CPP) + j] = getImage(getCodeBase(),"cartas/reverso.png");
		baraja = new Baraja(imagenes);
		baraja.barajar();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.green);
		g.fillRect(0, 0, 700, 700);
		g.drawImage(imgReverso, 20, 20, 70, 120, this);
	}
	
	public boolean action(Event ev, Object obj){
		
	}
}
