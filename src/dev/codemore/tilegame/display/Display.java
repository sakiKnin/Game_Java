package dev.codemore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	//definiramo okvir
	private JFrame frame;
	// definiramo canvas
	private Canvas canvas;
	// definiramo ime i varijable okvira
	private String title;
	private int width, height;
	
	// postavljamo varijable u konstruktoru
	public Display(String title, int width, int height){
		this.height=height;
		this.width=width;
		this.title=title;
		// pozivamo funkciju koja definira okvir
		createDisplay();
		
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		// postavljamo dužinu i širinu prozora
		frame.setSize(width, height);
		// osiguravamo da se aplikacija ugasi po zatvaranju prozora
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ugasi resize prozora
		frame.setResizable(false);
		// pozicionirajmo ekran na sredinu
		frame.setLocationRelativeTo(null);
		// postavljamo vidljivos okvira na "true"
		frame.setVisible(true);
		
		canvas = new Canvas();
		// postavljanje dimenzija canvasa
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		// postavljamo kako bi KeyManager radio
		canvas.setFocusable(false);
		frame.add(canvas);
		// povećat će okvir kako bi vidili cijeli canvas
		frame.pack();
		}
	// funkcija za dobavljanje canvasa u drugim klasam
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
}
