package solitario;

import java.awt.*;
import java.applet.*;

public class Carta extends Rectangle{

	public static final int ANCHURA = 100;
	public static final int ALTURA = 200;
	public static final int NEGRO = 1;
	public static final int ROJO = 2;
	public static final int TREBOLES = 0;
	public static final int DIAMANTES = 1;
	public static final int CORAZONES = 2;
	public static final int PICAS= 3;
	private Image imagen;
	private int valor;
	private int color;
	private int palo;
	
	public Carta(Image img,int v, int p, int c) {
		super(-200, -200, ANCHURA, ALTURA);
		imagen=img;
		valor = v;
		color = c;
		palo = p;
	}
	public void dibujar(Graphics g, Applet a){
		g.drawImage(imagen, 100, 200,a);
	}
	public int getValor() {
		return valor;
	}

	public int getColor() {
		return color;
	}

	public int getPalo() {
		return palo;
	}
	public Image getImagen() {
		return imagen;
	}

}

