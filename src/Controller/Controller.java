package Controller;

import java.util.ArrayList;

import Model.Management;
import Persistence.Persistence;
import View.PersonView;

public class Controller {

	private Management management;
	private Persistence persistence;
	
	public Controller() {
		management = new Management();
		persistence = new Persistence();
	}
	
	public void setPersistencePerson() {
		persistence.uploadPersons(management.getPersonList(), management.getPasserbyList());
	}
	
	public ArrayList<PersonView> getPersistenceView(){
		return persistence.downloadPerson();
	}
}
