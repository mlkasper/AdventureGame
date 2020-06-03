package com.mlkasper.GameObject;

import java.awt.Color;
import java.awt.Graphics;

/**
 * File Name: Player.java
 * @author Michael Kasper
 * Created: 6/2/2020
 * Last Modified: 6/2/2020
 *
 */

public class Player extends GameObject {
	/*
	 * Player GameObject constructor. 
	 */
	public Player(int xPos, int yPos, ObjectIDs id) {
		super(xPos, yPos, id);
		

	}

    /**
     * Changes the position of the object. 
     */
	public void tick() {
		// TODO Auto-generated method stub
		xPos += velX; 
		yPos += velY; 
	}
	
	/**
	 * Render the Player Game Object. 
	 */
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(xPos, yPos, 32, 32);
	}

}
