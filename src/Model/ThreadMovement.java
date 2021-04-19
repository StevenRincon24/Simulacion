package Model;

public class ThreadMovement implements Runnable{

	private Person person;
	private boolean right;
	private boolean down;
	
	public ThreadMovement(Person person) {
		this.person = person;
		right = true;
		down = true;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				
				if (person.getX()==0) {
					right = true;
				}else if (person.getX()==460) {
					right = false;
				}
				if (person.getY()==0) {
					down = true;
				}else if (person.getY()==440) {
					down = false;
				}
				
				if (right) {
					person.setX(person.getX()+1);
				}else {
					person.setX(person.getX()-1);
				}
				
				if (down) {
					person.setY(person.getY()+1);
				}else {
					person.setY(person.getY()-1);
				}
				
				Thread.sleep(15);
			}
		} catch (Exception e) {}
	}

}
