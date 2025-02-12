package ch.bbzbl.entity;

public class Agent {
	
	// attributes
	private int id;
	private String name;
	private String firstName;
	private String codeName;
	private int age;
	private boolean licenceToKill;
	
	
	public Agent() {
		this.name = "Bond";
		this.firstName = "James";
		this.codeName = "007";
		this.age = 33;
		this.licenceToKill = true;
		this.id = 0;
	}

	public Agent(int id, String name, String firstName, 
				 String codeName, int age,
			     boolean licenceToKill) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.codeName = codeName;
		this.age = age;
		this.licenceToKill = licenceToKill;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isLicenceToKill() {
		return licenceToKill;
	}

	public void setLicenceToKill(boolean licenceToKill) {
		this.licenceToKill = licenceToKill;
	}
	
	public String toString(){
		return this.id + ", " + this.name + ", " + this.firstName + ", " +
		       this.codeName + ", " + this.age + ", " + 
		       this.licenceToKill;
	}
	
	
	
	
	

}
