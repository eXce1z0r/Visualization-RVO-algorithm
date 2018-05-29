package Visualization;

import java.awt.Color;

import javax.swing.JFrame;

public class AppWindow extends JFrame
{
	private String title = "RVO - 2 Visualization";
	private int window_width = 800;
	private int window_heigth = 600;
	
	public AppWindow()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(window_width, window_heigth);
		this.setLocationRelativeTo(null);
		this.setTitle(title);
		this.setBackground(Color.BLACK);
		this.getContentPane().setBackground(Color.GRAY);
		this.setVisible(true);
	}
}
