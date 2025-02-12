package ch.bbzbl.data;

import java.util.*;

import ch.bbzbl.entity.Agent;

// JIAeao
public interface AgentDAO {
	boolean addAgent(Agent agentDTO);
	ArrayList<Agent> getAllAgents();
}
