package com.mlkasper.GameLauncher;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 
 * File Name: Window.java
 * 
 * @author Michael Kasper 
 * Created: 06/02/2020 
 * Last Update: 06/02/2020
 * 
 * Methods:
 * 
 * Window: Creates a Window for our game to run in.
 */
public class Window extends Canvas {


	private static final long serialVersionUID = 620734103494470826L;

	public Window(int width, int height, String frameTitle, Game game) {

		JFrame gameFrame = new JFrame(frameTitle);

		gameFrame.setPreferredSize(new Dimension(width, height));
		gameFrame.setMaximumSize(new Dimension(width, height));
		gameFrame.setMinimumSize(new Dimension(width, height));

		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.add(game);
		gameFrame.setVisible(true);

		game.start();

	}

}
