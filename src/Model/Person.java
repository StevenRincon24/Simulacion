package Model;

public class Person {
    private String Person_ID;
    private String Person_Name;

    public Person(String person_ID, String person_Name) {
        Person_ID = person_ID;
        Person_Name = person_Name;
    }

    public String getPerson_ID() {
        return Person_ID;
    }

    public void setPerson_ID(String person_ID) {
        Person_ID = person_ID;
    }

    public String getPerson_Name() {
        return Person_Name;
    }

    public void setPerson_Name(String person_Name) {
        Person_Name = person_Name;
    }
}
