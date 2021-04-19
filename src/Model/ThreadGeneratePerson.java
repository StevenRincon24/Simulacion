package Model;

import java.awt.Color;

public class ThreadGeneratePerson implements Runnable{

	private Management management;
	
	public ThreadGeneratePerson(Management management) {
		this.management = management;
	}
	
	@Override
	public void run() {
		Person person;
		int id;
		Color color;
		int nameIndex;
		try {
			while (true) {
				if (management.getPersonList().size()<20) {
					id = (int)(Math.random()*(999999999+1)+1000000000);
					color = new Color((int)(Math.random()*(256)),(int)(Math.random()*(256)),(int)(Math.random()*(256)));
					nameIndex = (int)(Math.random()*(Names.values().length));
					person = new Person(""+id, ""+Names.values()[nameIndex], color);
					person.setX((int)(Math.random()*(460+1)));
					person.setY((int)(Math.random()*(440+1)));
					management.addPerson(person);
				}
				Thread.sleep((int)(Math.random()*(8000+1)+2300));//2.3s a 8s
			}
		} catch (Exception e) {}
	}

}
