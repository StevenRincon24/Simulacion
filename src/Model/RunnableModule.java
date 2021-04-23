package Model;

public class RunnableModule implements Runnable{

	private int timeExpected;
	private int timeWorked;
	private int breakTime;
	private Proceeding proceeding;
	private Management management;
	
	public RunnableModule(Proceeding proceeding, Management management) {
		timeExpected = 8000;
		timeWorked = 0;
		breakTime = 0;
		this.proceeding = proceeding;
		this.management = management;
	}
	
	@Override
	public void run() {
			while (true) {
				while(timeWorked<=timeExpected && proceeding.getPerson()!=null) {
					try {
						timeWorked += 10;
						Thread.sleep(10);
					} catch (Exception e) {}
				}
				management.nextPerson(proceeding);
				timeWorked = 0;
				while(breakTime<=2000 && proceeding.getPerson()==null) {
					try {
						breakTime  += 10;
						Thread.sleep(10);
					} catch (Exception e) {}
				}
				breakTime = 0;
			}
	}
	
}
