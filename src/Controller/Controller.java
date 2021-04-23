package Controller;

import Model.Management;
import Persistence.Persistence;
import View.PersonView;

import java.util.ArrayList;

public class Controller {

	private Management management;
	private Persistence persistence;
	
	public Controller() {
		management = new Management();
		persistence = new Persistence();
		persistence.createFiles();
	}
	
	public void setPersistencePerson() {
		persistence.uploadPersons(management.getPersonList(), management.getPasserbyList());
	}
	
	public ArrayList<PersonView> getPersistenceView(){
		return persistence.downloadPerson();
	}
}
