package Model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Management {
	
	private ArrayList<Proceeding> proceedingsList;
	private ArrayList<LinkedList<Person>> queueList;
	private ArrayList<Person> personList;
	private ArrayList<Passerby> passerbyList;
	private Thread threadGeneratePerson;
	private Thread threadGeneratePasserby;
	private int gTurn;
	private int aTurn;
	
	public Management(){
		proceedingsList = new ArrayList<Proceeding>();
		proceedingsList.add(new Proceeding(Module.ModuleOne, this));
		proceedingsList.add(new Proceeding(Module.ModuleTwo, this));	//[0]  Module 1 //[1]  Module 2 //[2]  Module 3
		proceedingsList.add(new Proceeding(Module.ModuleThree, this));
		
		queueList= new ArrayList<LinkedList<Person>>();
		queueList.add(new LinkedList<Person>());
		queueList.add(new LinkedList<Person>());	//[0]  Module 1 //[1]  Module 2 //[2]  Module 3
		queueList.add(new LinkedList<Person>());
		
		passerbyList = new ArrayList<Passerby>();
		threadGeneratePasserby = new Thread(new RunnableGeneratePasserby(this));
		threadGeneratePasserby.start();
		
		personList = new ArrayList<Person>();
		threadGeneratePerson = new Thread(new RunnableGeneratePerson(this));
		threadGeneratePerson.start();
		
		gTurn = 0;
		aTurn = 0;
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
	
	public void setTurn(Person person) {
		if (person.getModule()==Module.ModuleOne) {
			gTurn++;
			person.setTurn(gTurn);
			queueList.get(0).add(person);
		}else if (person.getModule()==Module.ModuleTwo) {
			aTurn++;
			person.setTurn(aTurn);
			queueList.get(1).add(person);
		}else{
			queueList.get(2).add(person);
		}
	}
	
	public int getQueuePosition(Person person) {
		if (person.getModule()==Module.ModuleOne) {
			for (int i=0; i<queueList.get(0).size(); i++) {
				if (queueList.get(0).get(i)==person) {
					return i+1;
				}
			}
		}else if(person.getModule()==Module.ModuleTwo) {
			for (int i=0; i<queueList.get(1).size(); i++) {
				if (queueList.get(1).get(i)==person) {
					return i+1;
				}
			}
		}else {
			for (int i=0; i<queueList.get(2).size(); i++) {
				if (queueList.get(2).get(i)==person) {
					return i+1;
				}
			}
			for (int i=0; i<queueList.get(3).size(); i++) {
				if (queueList.get(3).get(i)==person) {
					return i+1;
				}
			}
		}
		return -1;
	}
	
	public boolean isAModuleFree(Person person) {
		if (person.getModule()==Module.ModuleOne && proceedingsList.get(0).getPerson()==null) {
			return true;
		}else if(person.getModule()==Module.ModuleTwo && proceedingsList.get(1).getPerson()==null) {
			return true;
		}else if(person.getModule()==Module.ModuleThree && proceedingsList.get(2).getPerson()==null) {
			return true;
		}
		return false;
	}
	
	public boolean waiting(Person person) {
		if(getQueuePosition(person) == 1 && isAModuleFree(person)) {
			return false;
		}
		return true;
	}
	
	public void nextPerson(Proceeding proceeding) {
		if (proceeding.getModule()==Module.ModuleOne) {
			proceedingsList.get(0).setPerson(null);
		}else if (proceeding.getModule()==Module.ModuleTwo) {
			proceedingsList.get(1).setPerson(null);
		}else{
			proceedingsList.get(2).setPerson(null);
		}
	}
	
	public void goToModule(Person person) {
		if (person.getModule()==Module.ModuleOne) {
			proceedingsList.get(0).setPerson(queueList.get(0).poll());
		}else if (person.getModule()==Module.ModuleTwo) {
			proceedingsList.get(1).setPerson(queueList.get(1).poll());
		}else{
			proceedingsList.get(2).setPerson(queueList.get(2).poll());
		}
	}
	
	public boolean waitBeingServed(Person person) {
		if(person.getModule()==Module.ModuleThree && proceedingsList.get(2).getPerson()==null) {
			return true;
		}
		return false;
	}
}
