package com.mlkasper.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mlkasper.GameLauncher.Handler;
import com.mlkasper.GameObject.GameObject;
import com.mlkasper.GameObject.ObjectIDs;

/**
 * File Name: KeyboardInput.java
 * 
 * @author Michael Kasper
 * Created: 6/3/2020
 * Date Modified: 6/3/2020
 *
 */

public class KeyboardInput extends KeyAdapter {
	
	private Handler handler; 
	
	public KeyboardInput(Handler handler) {
		this.handler = handler; 
	}

	public void keyPressed(KeyEvent e) {
		
		int keyPressed = e.getKeyCode();
		
		System.out.println(keyPressed); 
		
		for(int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i); 
			
			if(tempObject.getId() == ObjectIDs.Player) {
				//game control for players. 
				
				if(keyPressed == KeyEvent.VK_W)  tempObject.setVelY(-5);
				if(keyPressed == KeyEvent.VK_S)  tempObject.setVelY(5);
				if(keyPressed == KeyEvent.VK_A)  tempObject.setVelX(-5);
				if(keyPressed == KeyEvent.VK_D)  tempObject.setVelX(5);
			
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int keyPressed = e.getKeyCode(); 
		for(int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i); 
			
			if(tempObject.getId() == ObjectIDs.Player) {
				//game control for players. 
				
				if(keyPressed == KeyEvent.VK_W)  tempObject.setVelY(0);
				if(keyPressed == KeyEvent.VK_S)  tempObject.setVelY(0);
				if(keyPressed == KeyEvent.VK_A)  tempObject.setVelX(0);
				if(keyPressed == KeyEvent.VK_D)  tempObject.setVelX(0);
			
			}
		}
	}
	
}
