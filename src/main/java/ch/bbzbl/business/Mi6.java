package ch.bbzbl.business;


import java.util.ArrayList;

import ch.bbzbl.data.AgentDAO;
import ch.bbzbl.data.AgentDBDAOImpl;
import ch.bbzbl.data.AgentDummyDAOImpl;
import ch.bbzbl.entity.Agent;

public class Mi6 {
 
	private AgentDAO agentDAO;
	
	public Mi6(){
		//agentDAO = new AgentDBDAOImpl();
		agentDAO = new AgentDummyDAOImpl();
	}
	
	public boolean addAgent(Agent agent) {
		return agentDAO.addAgent(agent);
	}
	
	public ArrayList<Agent> getAgents() {
		return this.agentDAO.getAllAgents();
	}
}
 
