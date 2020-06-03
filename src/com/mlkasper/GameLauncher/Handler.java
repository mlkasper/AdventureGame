package com.mlkasper.GameLauncher;

import java.awt.Graphics;
import java.util.LinkedList;

import com.mlkasper.GameObject.GameObject;

/*
 * Object Handler: Renders each object to the screen. 
 * 
 * File Name: Handler.java
 * @author Michael Kasper
 * Created: 6/2/2020
 * Last Modified: 6/3/2020
 * 
 */

public class Handler {
	
	public LinkedList<GameObject> objects = new LinkedList<GameObject>(); 
	
	/*
	 * Loops though each object
	 */
	public void tick() {
		for(int i = 0; i < objects.size(); i++ ) {
			GameObject tempObject = objects.get(i); 
			tempObject.tick(); 
		}		
	}
	
	/**
	 * Renders each object in the GameObjects LinkedList
	 * @param g Graphic that you would like to render to the screen.
	 */
	public void render(Graphics g) {
		for ( int i = 0; i < objects.size(); i++ ) {
			GameObject tempObject = objects.get(i); 
			tempObject.render(g); 
		}
	}
	/**
	 * Adds an object to the GameObjects LinkedList
	 * @param GameObject to add.
	 */
	public void addObject(GameObject object) {
		this.objects.add(object); 
	}
	
	/**
	 * Removes an object from the GameObjects LinkedList
	 * @param GameObject to remove. 
	 */
	public void removeObject(GameObject object) { 
		this.objects.remove(object);
	}
}
