package Model;

public class RunnablePersonMovement implements Runnable{

	private Person person;
	private Management management;
	
	public RunnablePersonMovement(Person person, Management management) {
		this.person = person;
		this.management = management;
	}
	
	@Override
	public void run() {
		try {
			person.setY((int)(Math.random()*(575+1-470)+470));
			if (person.isComingFromRightSide()) {
				person.setX(730);
				left(330);
			}else {
				person.setX(-30);
				right(330);
			}
			up(395);
			management.setTurn(person);
			if (person.getModule()!=Module.ModuleThree) {
				Thread.sleep(2000);
				left(190);
				up(300);
				if (person.getModule()==Module.ModuleOne) {
					up(147);
				}
				if (management.waiting(person)) {
					chairs();
				}
			}else {
				if (person.isAdult()) {
					right(637);
					up(200);
				}else {
					right(597);
				}
			}
			goToModule();
			management.goToModule(person);
			waitBeingServed();
			if (person.getModule()!=Module.ModuleThree) {
				right(190);
				down(395);
				right(260);
			}
			down((int)(Math.random()*(575+1-470)+470));
			if (person.isComingFromRightSide()) {
				left(-30);
			}else {
				right(780);
			}
			management.deletePerson(person);	
		} catch (Exception e) {}
	}
	
	public void crazyMode() {
		boolean right = true;
		boolean down = true;
		person.setX((int)(Math.random()*(460+1)));
		person.setY((int)(Math.random()*(440+1)));

		while(true) {
			try {
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
			} catch (Exception e) {}
		}
	}
	
	private void left(int limit) {
		while (person.getX()>limit) {
			try {
				person.setX(person.getX()-1);
				Thread.sleep(15);
			} catch (Exception e) {}
		}
	}
	
	private void right(int limit) {
		while (person.getX()<limit) {
			try {
				person.setX(person.getX()+1);
				Thread.sleep(15);
			} catch (Exception e) {}
		}
	}
	
	private void up(int limit) {
		while (person.getY()>limit) {
			try {
				person.setY(person.getY()-1);
				Thread.sleep(15);
			} catch (Exception e) {}
		}
	}
	
	private void down(int limit) {
		while (person.getY()<limit) {
			try {
				person.setY(person.getY()+1);
				Thread.sleep(15);
			} catch (Exception e) {}
		}
	}
	
	private void waiting() {
		while(management.waiting(person)) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
	
	private void goToModule() {
		if (person.getModule()!=Module.ModuleThree) {
			left(47);
			if (person.getModule()==Module.ModuleOne) {
				up(90);
			}
		}else {
			
		}
	}
	
	private void chairs() {
		if (person.getChairPosition()<4) {
			up(person.getY()+5-(person.getChairPosition()*40));
			right(237);
		}else{
			right(317);
			up(person.getY()+5-((person.getChairPosition()-3)*40));
			left(277);
		}
		waiting();
		if (person.getChairPosition()<4) {
			left(190);
			down(person.getY()-5+(person.getChairPosition()*40));
		}else{
			right(317);
			down(person.getY()-5+((person.getChairPosition()-3)*40));
		}
	}
	
	private void waitBeingServed() {
		while(!management.waitBeingServed(person)) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
}
