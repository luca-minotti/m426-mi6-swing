package ch.bbzbl.data;

import java.util.*;

import ch.bbzbl.entity.Agent;

// Aoeoeo
public interface AgentDAO {
	boolean addAgent(Agent agentDTO);
	ArrayList<Agent> getAllAgents();
}
