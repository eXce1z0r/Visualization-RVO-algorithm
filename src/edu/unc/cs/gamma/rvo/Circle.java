/*
 * Circle.java
 * RVO2 Library Java
 *
 * Copyright 2008 University of North Carolina at Chapel Hill
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Please send all bug reports to <geom@cs.unc.edu>.
 *
 * The authors may be contacted via:
 *
 * Jur van den Berg, Stephen J. Guy, Jamie Snape, Ming C. Lin, Dinesh Manocha
 * Dept. of Computer Science
 * 201 S. Columbia St.
 * Frederick P. Brooks, Jr. Computer Science Bldg.
 * Chapel Hill, N.C. 27599-3175
 * United States of America
 *
 * <http://gamma.cs.unc.edu/RVO2/>
 */

package edu.unc.cs.gamma.rvo;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

// Example showing a demo with "agentAmount" agents initially positioned evenly
// distributed on a circle attempting to move to the antipodal position on the
// circle.
public class Circle {
    // Store the goals of the agents.
    private final List<Vector2D> goals = new ArrayList<>();
    private int agentAmount = 1;
    
    private int panel_width = 0;
    private int panel_height = 0;
    
    private int invis_border = 50;

   private void setupScenario() {
        // Specify the global time step of the simulation.
        //Simulator.instance.setTimeStep(0.25);
    	Simulator.instance.setTimeStep(0.10);

        // Specify the default parameters for agents that are subsequently
        // added.
        Simulator.instance.setAgentDefaults(15.0, 10, 10.0, 10.0, 1.5, 2.0, Vector2D.ZERO);

        // Add agents, specifying their start position, and store their goals on
        // the opposite side of the environment.
        final double angle = 0.008 * FastMath.PI;

        for (int i = 0; i < agentAmount; i++) {
            Simulator.instance.addAgent(new Vector2D(FastMath.cos(i * angle), FastMath.sin(i * angle)).scalarMultiply(200.0));
            goals.add(Simulator.instance.getAgentPosition(i).negate());
        }
    }
    
    public void setupScenario(int agent_radius) 
    {
    // Specify the global time step of the simulation.
	Simulator.instance.setTimeStep(0.01);

    // Specify the default parameters for agents that are subsequently
    // added.
    Simulator.instance.setAgentDefaults(15.0, 10, 10.0, 10.0, agent_radius, 2.0, Vector2D.ZERO);

    // Add agents, specifying their start position, and store their goals on
    // the opposite side of the environment.
    final double angle = 0.008 * FastMath.PI;

    /*for (int i = 0; i < agentAmount; i++) 
    {
        Simulator.instance.addAgent(new Vector2D(FastMath.cos(i * angle), FastMath.sin(i * angle)).scalarMultiply(200.0));
        goals.add(Simulator.instance.getAgentPosition(i).negate());
    }*/
    
    /*//OBSTACLES
    List<Vector2D> topLeftBox = new ArrayList<Vector2D>();
    
    topLeftBox.add(new Vector2D(((panel_width/2)-125), ((panel_height/2)-125)));
    topLeftBox.add(new Vector2D(((panel_width/2)+25), ((panel_height/2)-125)));
    topLeftBox.add(new Vector2D(((panel_width/2)+25), ((panel_height/2)+25)));
    topLeftBox.add(new Vector2D(((panel_width/2)-125), ((panel_height/2)+25)));
    
    Simulator.instance.addObstacle(topLeftBox);
    //Simulator.instance.processObstacles();*/
    
    //LEFT_TOP    
    for(int i = 10; i<= 20; i=i+5)
    {
    	for(int j = 10; j<= 20; j=j+5)
    	{
    		Simulator.instance.addAgent(new Vector2D(-i, -j), Color.BLUE);
    	    goals.add(new Vector2D(-panel_width+invis_border+i, -panel_height+invis_border+j));
    	}    	
    }
    
    //RIGHT_TOP    
    for(int i = panel_width - 10; i <= panel_width; i=i+5)
    {
    	for(int j = 10; j<= 20; j=j+5)
    	{
    		Simulator.instance.addAgent(new Vector2D(-i, -j), Color.RED);//-panel_width+invis_border+i, -j
    	    goals.add(new Vector2D(-invis_border+panel_width-i, -panel_height+invis_border));
    	}    	
    }
    
    //LEFT_BOTTOM
    for(int i = 10; i<= 20; i=i+5)
    {
    	for(int j = panel_height - 10; j<= panel_height; j=j+5)
    	{
    		Simulator.instance.addAgent(new Vector2D(-i, -j), new Color(247,94,37,254));
    	    goals.add(new Vector2D(-panel_width+invis_border, -invis_border+panel_height-j));
    	}    	
    }
    
    //RIGHT_BOTTOM
    for(int i = panel_width - 10; i <= panel_width; i=i+5)
    {
    	for(int j = panel_height - 10; j<= panel_height; j=j+5)
    	{
    		Simulator.instance.addAgent(new Vector2D(-i, -j), Color.GREEN);
    	    goals.add(new Vector2D(-invis_border+panel_width-i, -invis_border+panel_height-j));
    	}    	
    }
    
    //OBSTACLES
    List<Vector2D> topLeftBox = new ArrayList<Vector2D>();
    /*topLeftBox.add(new Vector2D(-((panel_width/2)+200), -((panel_height/2)+200)));
    topLeftBox.add(new Vector2D(-((panel_width/2)+200), -((panel_height/2)+100)));
    topLeftBox.add(new Vector2D(-((panel_width/2)+100), -((panel_height/2)+100)));
    topLeftBox.add(new Vector2D(-((panel_width/2)+100), -((panel_height/2)+200)));
    
    topLeftBox.add(new Vector2D(((panel_width/2)+200), -((panel_height/2)+200)));
    topLeftBox.add(new Vector2D(((panel_width/2)+200), -((panel_height/2)+100)));
    topLeftBox.add(new Vector2D(((panel_width/2)+100), -((panel_height/2)+100)));
    topLeftBox.add(new Vector2D(((panel_width/2)+100), -((panel_height/2)+200)));*/
    
    /*topLeftBox.add(new Vector2D(-((panel_width/2)+200), ((panel_height/2)+200)));
    topLeftBox.add(new Vector2D(-((panel_width/2)+200), ((panel_height/2)+100)));
    topLeftBox.add(new Vector2D(-((panel_width/2)+100), ((panel_height/2)+100)));
    topLeftBox.add(new Vector2D(-((panel_width/2)+100), ((panel_height/2)+200)));*/
    
    /*topLeftBox.add(new Vector2D(((panel_width/2)-125), ((panel_height/2)-125)));
    topLeftBox.add(new Vector2D(((panel_width/2)+25), ((panel_height/2)-125)));
    topLeftBox.add(new Vector2D(((panel_width/2)+25), ((panel_height/2)+25)));
    topLeftBox.add(new Vector2D(((panel_width/2)-125), ((panel_height/2)+25)));*/
    
    /*topLeftBox.add(new Vector2D(((panel_width/2)-125)*(-1), ((panel_height/2)-125)*(-1)));
    topLeftBox.add(new Vector2D(((panel_width/2)+25)*(-1), ((panel_height/2)-125)*(-1)));
    topLeftBox.add(new Vector2D(((panel_width/2)+25)*(-1), ((panel_height/2)+25)*(-1)));
    topLeftBox.add(new Vector2D(((panel_width/2)-125)*(-1), ((panel_height/2)+25)*(-1)));*/
    
    topLeftBox.add(new Vector2D(((panel_width/2)-200)*(-1), ((panel_height/2)-150)*(-1)));
    topLeftBox.add(new Vector2D(((panel_width/2)-25)*(-1), ((panel_height/2)-150)*(-1)));
    topLeftBox.add(new Vector2D(((panel_width/2)-25)*(-1), ((panel_height/2)-25)*(-1)));
    topLeftBox.add(new Vector2D(((panel_width/2)-200)*(-1), ((panel_height/2)-25)*(-1)));    
    Simulator.instance.addObstacle(topLeftBox);
    
    
    List<Vector2D> topRightBox = new ArrayList<Vector2D>();
    topRightBox.add(new Vector2D(((panel_width/2)+25)*(-1), ((panel_height/2)-150)*(-1)));
    topRightBox.add(new Vector2D(((panel_width/2)+200)*(-1), ((panel_height/2)-150)*(-1)));
    topRightBox.add(new Vector2D(((panel_width/2)+200)*(-1), ((panel_height/2)-25)*(-1)));
    topRightBox.add(new Vector2D(((panel_width/2)+25)*(-1), ((panel_height/2)-25)*(-1)));    
    Simulator.instance.addObstacle(topRightBox);
    
    
    List<Vector2D> bottomRightBox = new ArrayList<Vector2D>();
    bottomRightBox.add(new Vector2D(((panel_width/2)+25)*(-1), ((panel_height/2)+25)*(-1)));
    bottomRightBox.add(new Vector2D(((panel_width/2)+200)*(-1), ((panel_height/2)+25)*(-1)));
    bottomRightBox.add(new Vector2D(((panel_width/2)+200)*(-1), ((panel_height/2)+150)*(-1)));
    bottomRightBox.add(new Vector2D(((panel_width/2)+25)*(-1), ((panel_height/2)+150)*(-1)));    
    Simulator.instance.addObstacle(bottomRightBox);
    
    List<Vector2D> bottomLeftBox = new ArrayList<Vector2D>();
    bottomLeftBox.add(new Vector2D(((panel_width/2)-200)*(-1), ((panel_height/2)+25)*(-1)));
    bottomLeftBox.add(new Vector2D(((panel_width/2)-25)*(-1), ((panel_height/2)+25)*(-1)));
    bottomLeftBox.add(new Vector2D(((panel_width/2)-25)*(-1), ((panel_height/2)+150)*(-1)));
    bottomLeftBox.add(new Vector2D(((panel_width/2)-200)*(-1), ((panel_height/2)+150)*(-1)));    
    Simulator.instance.addObstacle(bottomLeftBox);
    
    
    Simulator.instance.processObstacles();
    
    /*Simulator.instance.addAgent(new Vector2D(10, 10));
    goals.add(new Vector2D(-panel_width+invis_border+10, -panel_height+invis_border+10));
    
    Simulator.instance.addAgent(new Vector2D(15, 10));
    goals.add(new Vector2D(-panel_width+invis_border+15, -panel_height+invis_border+10));
    
    Simulator.instance.addAgent(new Vector2D(20, 10));
    goals.add(new Vector2D(-panel_width+invis_border+20, -panel_height+invis_border+10));
    
    Simulator.instance.addAgent(new Vector2D(10, 15));
    goals.add(new Vector2D(-panel_width+invis_border+10, -panel_height+invis_border+15));
    
    Simulator.instance.addAgent(new Vector2D(15, 15));
    goals.add(new Vector2D(-panel_width+invis_border+15, -panel_height+invis_border+15));
    
    Simulator.instance.addAgent(new Vector2D(20, 15));
    goals.add(new Vector2D(-panel_width+invis_border+20, -panel_height+invis_border+15));
    
    Simulator.instance.addAgent(new Vector2D(10, 20));
    goals.add(new Vector2D(-panel_width+invis_border+10, -panel_height+invis_border+20));
    
    Simulator.instance.addAgent(new Vector2D(15, 20));
    goals.add(new Vector2D(-panel_width+invis_border+15, -panel_height+invis_border+20));
    
    Simulator.instance.addAgent(new Vector2D(20, 20));
    goals.add(new Vector2D(-panel_width+invis_border+20, -panel_height+invis_border+20));*/
    
    
    //RIGHT_TOP
    
    /*Simulator.instance.addAgent(new Vector2D(10, 10));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(15, 10));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(20, 10));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(10, 15));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(15, 15));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(20, 15));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(10, 20));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(15, 20));
    goals.add(new Vector2D(-100, -100));
    
    Simulator.instance.addAgent(new Vector2D(20, 20));
    goals.add(new Vector2D(-100, -100));*/
    
    }
    
    /*public ArrayList<Vector2D> getPositionForVisualizationObstacleWithId(int id)
    {
    	return Simulator.instance.getO
    }*/
    
    public Vector2D getPositionForVisualizationAgentWithId(int id)
    {
    	return Simulator.instance.getAgentPosition(id);
    }

    /*private*/public void updateVisualization() {
        // Output the current global time.
        //System.out.print(Simulator.instance.getGlobalTime());

        // Output the current position of all the agents.
        for (int agentNo = 0; agentNo < Simulator.instance.getNumAgents(); agentNo++) {
            //System.out.print(" " + Simulator.instance.getAgentPosition(agentNo));
        }

        //System.out.println();
    }
    
    public void setPanelSize(int panel_width, int panel_height)
    {
    	this.panel_width = panel_width;
    	this.panel_height = panel_height;
    }
    
    public void setAgentAmount(int agentAmount)
    {
    	this.agentAmount = agentAmount;
    }

    /*private*/public void setPreferredVelocities() {
        // Set the preferred velocity to be a vector of unit magnitude (speed)
        // in the direction of the goal.
        for (int agentNo = 0; agentNo < Simulator.instance.getNumAgents(); agentNo++) {
            Vector2D goalVector = goals.get(agentNo).subtract(Simulator.instance.getAgentPosition(agentNo));
            final double lengthSq = goalVector.getNormSq();

            if (lengthSq > 1.0) {
                goalVector = goalVector.scalarMultiply(1.0 / FastMath.sqrt(lengthSq));
            }

            Simulator.instance.setAgentPreferredVelocity(agentNo, goalVector);
        }
    }

    /*private*/public boolean reachedGoal() {
        // Check if all agents have reached their goals.
        for (int agentNo = 0; agentNo < Simulator.instance.getNumAgents(); agentNo++) {
            if (Simulator.instance.getAgentPosition(agentNo).distanceSq(goals.get(agentNo)) > Simulator.instance.getAgentRadius(agentNo) * Simulator.instance.getAgentRadius(agentNo)) {
                return false;
            }
        }

        return true;
    }

    /*public static void main(String[] args) {
        final Circle circle = new Circle();

        // Set up the scenario.
        circle.setupScenario();

        // Perform (and manipulate) the simulation.
        do {
            circle.updateVisualization();
            circle.setPreferredVelocities();
            Simulator.instance.doStep();
        }
        while (!circle.reachedGoal());
    }*/
}
