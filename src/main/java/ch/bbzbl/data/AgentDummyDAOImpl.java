package ch.bbzbl.data;

import java.util.ArrayList;
import java.util.Vector;

import ch.bbzbl.entity.Agent;


public class AgentDummyDAOImpl implements AgentDAO {
	
	private static int agentCount = 0;
	private ArrayList<Agent> agentDTOs;
	
	public AgentDummyDAOImpl(){
		agentDTOs = new ArrayList<Agent>();
		agentDTOs.add(new Agent(++agentCount, "Bond", "James", 
				             "007", 28, true));
		agentDTOs.add(new Agent(++agentCount, "Blondy", "Gitta", 
	             "008", 25, true));
		agentDTOs.add(new Agent(++agentCount, "Brand", "Jacky", 
	             "009", 33, true));
		agentDTOs.add(new Agent(++agentCount, "Rüdisüli", "Hansli", 
	             "001", 22, false));
		agentDTOs.add(new Agent(++agentCount, "Stutz", "Godfried", 
	             "002", 20, false));
	}
	
	@Override
	public boolean addAgent(Agent agentDTO) {
		agentDTO.setId(++agentCount);
		return agentDTOs.add(agentDTO);
	}

	@Override
	public ArrayList<Agent> getAllAgents() {
		return (ArrayList<Agent>) agentDTOs.clone();
	}

}
