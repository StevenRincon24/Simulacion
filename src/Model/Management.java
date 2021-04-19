package Model;

import java.util.ArrayList;

public class Management {
	
	private ArrayList<Proceeding> proceedingsList;
	private ArrayList<Person> personList;
	private Thread tGeneratePerson;
	
	public Management(){
		personList = new ArrayList<Person>();
		proceedingsList = new ArrayList<Proceeding>();
		tGeneratePerson = new Thread(new ThreadGeneratePerson(this));
		tGeneratePerson.start();
	}
	
	public void addPerson(Person person) {
		personList.add(person);
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}
	
	

}
