package com.mlkasper.GameObject;

import java.awt.Graphics;

/** 
 * File Name: GameObject.java
 * 
 * @author Michael Kasper
 * Created: 6/2/2020
 * Last Modified: 6/3/2020
 * 
 *
 */


public abstract class GameObject {
	
	protected int xPos, yPos; 

	protected int velX, velY; 
	protected ObjectIDs id; 
	
	/*
	 * Constructor
	 */
	public GameObject(int xPos, int yPos, ObjectIDs id) {
		this.xPos = xPos; 
		this.yPos = yPos; 
		this.id = id; 
	}
	
	/**
	 * Can be used for multiple things, including changing position of GameObject.
	 */
	public abstract void tick(); 
	
	/**
	 * 
	 * @param g Graphics to render. 
	 */
	public abstract void render(Graphics g);
	
	/**
	 * 
	 * @return X position of object. 
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * 
	 * @param xPos New X position. 
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	/**
	 * 
	 * @return Y position of object. 
	 */
	public int getyPos() {
		return yPos;
	}
	
	/**
	 * 
	 * @param yPos New Y position. 
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	
	/**
	 * 
	 * @return X Velocity. 
	 */
	public int getVelX() {
		return velX;
	}
	
	/**
	 * 
	 * @param velX New X velocity. 
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * 
	 * @return Y Velocity. 
	 */
	public int getVelY() {
		return velY;
	}

	/**
	 * 
	 * @param velY New Y velocity. 
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}

	/**
	 * 
	 * @return Returns GameObject ID.
	 */
	public ObjectIDs getId() {
		return id;
	}

}
