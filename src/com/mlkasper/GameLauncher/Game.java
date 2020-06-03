package com.mlkasper.GameLauncher;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.mlkasper.GameObject.ObjectIDs;
import com.mlkasper.GameObject.Player;
import com.mlkasper.Input.KeyboardInput;

/**
 * 
 * File Name: Game.java
 * @author Michael Kasper
 * Created: 06/02/2020
 * Last Update: 06/02/2020
 * 
*/
public class Game extends Canvas implements Runnable { 
    
   
	private static final long serialVersionUID = -2483618384688292109L;

	public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9; //16:9 aspect ratio
    
    private Thread thread; 
    private boolean running = false; //checks if game is running
    
    
    private Handler handler; 
    
    
    /**
     * Constructor
     */
    public Game() {
    	
    	handler = new Handler(); 
    	this.addKeyListener( new KeyboardInput(handler) ); //keyboard input
        new Window(WIDTH, HEIGHT, "Game", this); 
        
        
        handler.addObject(new Player(100, 100, ObjectIDs.Player)); //test object
    }
    
    /**
     * Creates an instance of the game that runs on a thread. 
     */
    public synchronized void start() { 
        thread = new Thread(this); 
        thread.start(); 
        running = true; 
    }
    /**
     * Stops an instance of the game on a given thread. 
     */
    public synchronized void stop() { 
    	try { 
    		thread.join(); 
    		running = false; 
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Game loop.
     */
    public void run() { 
        long lastTime = System.nanoTime(); 
        double amountOfTicks = 60.0; 
        double ns = 1000000000 / amountOfTicks; 
        double delta = 0.0; 
        long timer = System.currentTimeMillis(); 
        int frames = 0; 
        
        while( running ) {
        	long startTime = System.nanoTime(); 
        	delta += (startTime - lastTime) / ns; 
        	lastTime = startTime;
        	
        	while ( delta >= 1 ) {
        		tick(); 
        		delta--; 
        	}
        	if ( running ) {
        		render(); 
        	}
        	frames++; 
        	
        	if(System.currentTimeMillis() - timer > 1000 ) {
        		timer += 1000; 
        		//System.out.println("Frames Per Second: " + frames); 
        		frames = 0; 
        	}
        }
        
        stop(); 
    }
    
    /**
     * 
     */
    private void tick() { 
    	handler.tick(); 
    }
    
    /**
     * Renders the images on the screen. 
     */
    private void render() { 
    	BufferStrategy bs = this.getBufferStrategy(); 
    	if(bs == null) {
    		this.createBufferStrategy(3);
    		return; 	
    	}
    	
    	Graphics g = bs.getDrawGraphics(); 
    	
    	g.setColor(Color.red);
    	g.fillRect(0,  0,  WIDTH,  HEIGHT);
    	
    	handler.render(g); 
    	
    	g.dispose();
    	bs.show();
    }
    
    /**
     * 
     * @param args
     */
    
    public static void main(String args[]) {
        new Game(); 
    }
    
}	
