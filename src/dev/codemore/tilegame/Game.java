package dev.codemore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import dev.codemore.tilegame.display.Display;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.gfx.ImageLoader;
import dev.codemore.tilegame.gfx.SpriteSheet;
import dev.codemore.tilegame.input.KeyManager;
import dev.codemore.tilegame.states.GameState;
import dev.codemore.tilegame.states.MenuState;
import dev.codemore.tilegame.states.State;

// Implementiramo runable jer želimo da se klasa Game pokreće u dretvi
public class Game implements Runnable{
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	// definiramo buffer i graphic object
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	
	private State gameState;
	private State menuState;
	
	// Input
	
	private KeyManager keyManager;
	
	public Game(String title, int width, int height){
		
		this.width=width;
		this.height=height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	private void tick(){
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
		}
	private void render(){
			//dohvaćamo canvas okvira
				bs = display.getCanvas().getBufferStrategy();
			if(bs==null){
				display.getCanvas().createBufferStrategy(3);
				return;
			}
				// inicijaliziramo graphic object
				g = bs.getDrawGraphics();
				// želimo čist ekran prije crtanja 
				g.clearRect(0, 0, width, height);
				// Nacrtaj ovdje!
			
 				if(State.getState() != null)
 					State.getState().render(g);
				//Kraj crtanja!
				bs.show();
				g.dispose();
		}
	
	// moramo definirati funkciju run kako bi dretva radila
	public void run(){
		
		init();
	 	
	 	int fps = 60;
	 	double timePerTick = 1000000000/fps;
	 	double delta = 0;
	 	long now;
	 	long lastTime = System.nanoTime();
	 	long timer = 0;
	 	long ticks = 0;
		
		while(running){
			
			now = System.nanoTime();
	 		delta += (now - lastTime) / timePerTick;
	 		timer += now-lastTime;
	 		lastTime = now;
	 		
	 		if(delta>=1){
	 			tick();
	 			render();
	 			delta--;
	 			ticks++;
	 		}
	 		
	 		if(timer >= 1000000000){
	 			System.out.println("Ticks and Frames: " + ticks);
	 			ticks = 0;
	 			timer = 0;
	 		}
		}
		
		stop();
	}
	public KeyManager getKeyManager(){
			return keyManager;
	}
	// funkcije koje pokreće našu dretvu
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		// thread.start() poziva našu funkciju run
		thread.start();
	}
	
	// funkcija koja zaustavlja našu dretvu
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		    try {
				thread.join();
			} catch (InterruptedException e) {
 				e.printStackTrace();
			}
	}
}
