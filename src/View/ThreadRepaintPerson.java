package View;

import Controller.Controller;

public class ThreadRepaintPerson implements Runnable{
	
	private Controller controller;
	private PanelPerson ppPanelPerson;
	
	public ThreadRepaintPerson(PanelPerson ppPanelPerson) {
		this.ppPanelPerson = ppPanelPerson;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				controller.setPersistencePerson();
				ppPanelPerson.setPersonList(controller.getPersistenceView());
				ppPanelPerson.repaint();
				Thread.sleep(15);
			}
		} catch (Exception e) {}
		
	}
	
	public void assignController(Controller controller) {
		this.controller = controller;
	}

}
