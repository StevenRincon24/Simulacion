package Model;

import java.util.ArrayList;

public class Management {
	
	private ArrayList<Proceeding> proceedingsList;
	private ArrayList<Person> personList;
	private ArrayList<Passerby> passerbyList;
	private Thread threadGeneratePerson;
	private Thread threadGeneratePasserby;
	
	public Management(){
		proceedingsList = new ArrayList<Proceeding>();
		passerbyList = new ArrayList<Passerby>();
		threadGeneratePasserby = new Thread(new RunnableGeneratePasserby(this));
		threadGeneratePasserby.start();
		personList = new ArrayList<Person>();
		threadGeneratePerson = new Thread(new RunnableGeneratePerson(this));
		threadGeneratePerson.start();
	}
	
	public void addPerson(Person person) {
		personList.add(person);
	}
	
	public void deletePerson(Person person) {
		personList.remove(person);
	}
	
	public void addpasserby(Passerby passerby) {
		passerbyList.add(passerby);
	}
	
	public void deletepasserby(Passerby passerby) {
		passerbyList.remove(passerby);
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}
	
	public ArrayList<Passerby> getPasserbyList() {
		return passerbyList;
	}
	
	

}
