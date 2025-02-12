package ch.bbzbl.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ch.bbzbl.entity.Agent;

public class AgentDBDAOImpl implements AgentDAO {
	
	// attributes used for data connection
	private String conStr = "jdbc:mariadb://localhost:3306/agentdb?user=root";
	private Connection con;
	private Statement s;
	private PreparedStatement ps;
	private ResultSet rs;
		
	// methods
	public ArrayList<Agent> getAllAgents(){
		ArrayList<Agent> agentList = null;
		try {
			// get data connection and data statement
			con = DriverManager.getConnection(this.conStr);
			s = con.createStatement();
			// instantiate the vector imgNames to store 
			// image file names
			agentList = new ArrayList<Agent>();
			// get content of data table t_agent in result set rs
			rs = s.executeQuery("select * from t_agent");
			// create an AgentDTO with tuple data of t_agent
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String firstName = rs.getString(3);
				String codeName = rs.getString(4);
				int age = rs.getInt(5);
				boolean licenceToKill = rs.getBoolean(6);
				Agent agentDTO = new Agent(id, name, firstName, 
										codeName, age, licenceToKill);
				agentList.add(agentDTO);
			}
			
			// close data statement and data connection
			s.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return agentList;
	}
	
	public boolean addAgent(Agent agentDTO){
		try {
			// get data connection and data statement
			con = DriverManager.getConnection(this.conStr);
			
			String sql = 
				"insert into t_agent" +
			    "(name, firstname, codename, age, licencetokill)" +
			    "values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, agentDTO.getName());
			ps.setString(2, agentDTO.getFirstName());
			ps.setString(3, agentDTO.getCodeName());
			ps.setInt(4, agentDTO.getAge());
			ps.setBoolean(5, agentDTO.isLicenceToKill());
			
			ps.execute();
			// close data statement and data connection
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			return false;
		}
		return true;
	}
}

