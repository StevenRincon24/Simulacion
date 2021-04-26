package View;

import java.util.ArrayList;

public class TurnWithPerson {

    private String turno;
    private ArrayList<PersonView> personViews;

    public TurnWithPerson(String turno, ArrayList<PersonView> personViews) {
        this.turno = turno;
        this.personViews = personViews;
    }

    public String getTurno() {
        return turno;
    }

    public ArrayList<PersonView> getPersonViews() {
        return personViews;
    }
}
