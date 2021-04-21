package Model;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {
    private String personID;
    private Name personName;
    private Date date;
    private Module module;
    private Color color;
    private int x;
    private int y;
    private Thread tMovement;
    private boolean comingFromRightSide;

    public Person(String personID, Name personName, Color color, Module module, Date date, boolean comingFromRightSide, Management management) {
        this.personID = personID;
        this.personName = personName;
        this.date = date;
        this.module = module;
        this.color = color;
        x=330;
        this.comingFromRightSide = comingFromRightSide;
        tMovement = new Thread(new RunnablePersonMovement(this, management));
        tMovement.start();
    }

    public String getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personID;
    }
    
	public Module getModule() {
		return module;
	}

	public boolean isAdult() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println(""+sdf.format(date));
		int period = Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
//		System.out.println(period);
		if(period>=60) {
			return true;
		}
		return false;
	}
	
	public boolean isComingFromRightSide() {
		return comingFromRightSide;
	}

	public Date getDate() {
		return date;
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
