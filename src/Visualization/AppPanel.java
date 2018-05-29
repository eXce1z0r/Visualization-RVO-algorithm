package Visualization;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import edu.unc.cs.gamma.rvo.Circle;
import edu.unc.cs.gamma.rvo.Simulator;

public class AppPanel extends JPanel implements Runnable
{
	
	private Circle circle = new Circle();
	private boolean mainLoopFlag = true;
	
	private int agent_width = 5;
	private int agent_height = 5;
	private int agent_radius = 5;
	
	private int agentGoalX = 0;
	private int agentGoalY = 0;
	
	private Random random = new Random();
	private boolean firstGoalSetFlag = true;
	private boolean firstLoopStarter = true;
	
	//FPS Options	
	private long framerate = 1000/1000;// fps amount depends from second value	
	private boolean frameStartUpdate = true;
	private long frameStart = 0;
	private long frameCount = 0;
	private long elapsedTime;	
	private long totalElapsedTime = 0;
	private long reportedFramerate = 0;
	private long FPS = 30;
	
	
	public AppPanel()
	{
		this.setBackground(Color.WHITE);
	}	

	@Override
	protected void paintComponent(Graphics g) 
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
				
		for (int i = 0; i < Simulator.instance.getNumObstacleVertices(); i=i+4)
		{
			//System.out.println("1");
			g.setColor(Color.BLACK);
			
			g.drawRect((int)Simulator.instance.getObstacleVertex(i).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i).getY()*(-1), agent_width, agent_height);
			g.drawLine((int)Simulator.instance.getObstacleVertex(i).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i).getY()*(-1), (int)Simulator.instance.getObstacleVertex(i+1).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i+1).getY()*(-1));
			
			g.drawRect((int)Simulator.instance.getObstacleVertex(i+1).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i+1).getY()*(-1), agent_width, agent_height);
			g.drawLine(((int)Simulator.instance.getObstacleVertex(i+1).getX()-agent_width)*(-1), (int)Simulator.instance.getObstacleVertex(i+1).getY()*(-1), ((int)Simulator.instance.getObstacleVertex(i+2).getX()-agent_width)*(-1), (int)Simulator.instance.getObstacleVertex(i+3).getY()*(-1));
			
			g.drawRect((int)Simulator.instance.getObstacleVertex(i+2).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i+2).getY()*(-1), agent_width, agent_height);
			g.drawLine((int)Simulator.instance.getObstacleVertex(i+2).getX()*(-1), ((int)Simulator.instance.getObstacleVertex(i+2).getY()-agent_height)*(-1), (int)Simulator.instance.getObstacleVertex(i+3).getX()*(-1), ((int)Simulator.instance.getObstacleVertex(i+3).getY()-agent_height)*(-1));
			
			g.drawRect((int)Simulator.instance.getObstacleVertex(i+3).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i+3).getY()*(-1), agent_width, agent_height);
			g.drawLine((int)Simulator.instance.getObstacleVertex(i+3).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i+3).getY()*(-1), (int)Simulator.instance.getObstacleVertex(i).getX()*(-1), (int)Simulator.instance.getObstacleVertex(i).getY()*(-1));
			
			/*java.awt.Graphics2D g2g = (java.awt.Graphics2D)g;
			g2g.dra*/
		}
		
		
		/*for(int i = 0; i< Simulator.instance.getNumObstacleVertices(); i++)
		{		
			g.fillRect((int)Simulator.instance.getObstacleVertex(i).getX(), (int)Simulator.instance.getObstacleVertex(i).getY() , 100, 100);
		}*/
		
		for(int i = 0; i< Simulator.instance.getNumAgents(); i++)
		{
			//java.awt.Graphics2D g2 = (java.awt.Graphics2D)g;
			
			g.setColor(Simulator.instance.getAgentColor(i));
			g.drawOval((int)circle.getPositionForVisualizationAgentWithId(i).getX()*(-1), (int)circle.getPositionForVisualizationAgentWithId(i).getY()*(-1), agent_width, agent_height);
			
			/*System.out.println("Bird X:"+(int)Simulator.instance.getAgentPosition(i).getX()+"; Bird Y:"+(int)Simulator.instance.getAgentPosition(i).getY());
			
			g.drawOval((int)Simulator.instance.getAgentPosition(i).getX(), (int)Simulator.instance.getAgentPosition(i).getY(), agent_width, agent_height);
			
			System.out.println(" {"+(int)Simulator.instance.getAgentPosition(i).getX()+", "+ (int)Simulator.instance.getAgentPosition(i).getY()+"}");*/
			//g.drawOval(0, 0, agent_width, agent_height);
		}
	}
	
	private int randomVal(int val)
	{
		return random.nextInt(val);
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		//System.out.println(Simulator.instance.getNumAgents());
		/*Simulator.instance.setAgentDefaults(2, 5, 1, 1, agent_radius, 2, new Vector2D(50, 50));
		Simulator.instance.addAgent(new Vector2D(10, 10));
		
        while(true)
        {
        	System.out.println(Simulator.instance.getNumAgents());
    		frameStart = System.currentTimeMillis();
	    	if(this.getWidth() > 0)
	    	{
	    		agentGoalX = this.getWidth();//randomVal(this.getWidth());
	    	}
	    	if(this.getHeight() > 0)
	    	{
	    		agentGoalY = this.getHeight();//randomVal(this.getHeight());
	    	}
	        if(true)
	        {
		        //repaint begin        	
			    System.out.println("TEST: this.getWidth() = "+this.getWidth()+"; this.getHeight() = "+this.getHeight());
			    System.out.println("TEST: X = "+agentGoalX+"; Y = "+agentGoalY);
			        	
			    //circle.setAgentGoal(new Vector2D(agentGoalX, agentGoalY));
			            
			    this.repaint();
			    Simulator.instance.doStep();
			    //repaint ends
	        }
        }*/

        // Set up the scenario.
		while(mainLoopFlag)
		{
			if((this.getWidth() > 0)&&(this.getHeight() > 0))
			{
				mainLoopFlag = false;
				//System.out.println(this.getWidth()+"; "+ this.getHeight());
				
				circle.setPanelSize(this.getWidth(), this.getHeight());				
		        circle.setupScenario(agent_radius);
		
		        // Perform (and manipulate) the simulation.
		        do 
		        {
		        	//System.out.println(this.getWidth()+"; "+ this.getHeight());
		            circle.updateVisualization();
		            this.repaint();
		            circle.setPreferredVelocities();
		            Simulator.instance.doStep();
		        }
		        while (!circle.reachedGoal());	
			}
		}
	}
}
