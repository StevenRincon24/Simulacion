package Model;

import java.awt.Color;

public class Person {
    private String personID;
    private String personName;
    private Color color;
    private int x;
    private int y;
    private Thread tMovement;
    

    public Person(String personID, String personName, Color color) {
        this.personID = personID;
        this.personName = personName;
        this.color = color;
        x=450;
        y=600;
        tMovement = new Thread(new ThreadMovement(this));
        tMovement.start();
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personID;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
