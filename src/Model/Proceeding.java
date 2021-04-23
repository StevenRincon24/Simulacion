package Model;

public class Proceeding {
    private Module module;
    private Person person;
    private Thread tWork;

    public Proceeding(Module module, Management management) {
        this.module = module;
        person = null;
        tWork = new Thread(new RunnableModule(this, management));
        tWork.start();
    }

    public Module getModule() {
        return module;
    }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
