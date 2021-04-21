package Model;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
		int moduleIndex;
		Calendar calendar = new GregorianCalendar();
		Date date;
		try {
			while (true) {
				if (management.getPersonList().size()<28) {
					id = (int)(Math.random()*(999999999+1)+1000000000);
					color = new Color((int)(Math.random()*(256)),(int)(Math.random()*(256)),(int)(Math.random()*(256)));
					nameIndex = (int)(Math.random()*(Name.values().length));
					do {
						moduleIndex = (int)(Math.random()*(Module.values().length));
					}while(!checkModule(Module.values()[moduleIndex]));
					do {
						calendar.set(Calendar.YEAR, (int)(Math.random()*((2021-19)-(2021-80))+(2021-80)));
						calendar.set(Calendar.DAY_OF_YEAR, (int)(Math.random()*(calendar.getActualMaximum(Calendar.DAY_OF_YEAR)))+1);
						calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
						date= new Date(calendar.get(Calendar.YEAR)-1900, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_YEAR));
					}while(Module.values()[moduleIndex]==Module.ModuleThree && !checkAge(calendar.get(Calendar.YEAR)));
					person = new Person(""+id, Name.values()[nameIndex], color, Module.values()[moduleIndex], date);
					management.addPerson(person);
				}else {
					System.out.println("FULL");
				}
				Thread.sleep((int)(Math.random()*(6000+1)+2300));//2.3s a 6s
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private boolean checkModule(Module module) {
		ArrayList<Person> personList = management.getPersonList();
		int countModule1= 0;
		int countModule2= 0;
		int countModule3 = 0;
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getModule()==Module.ModuleOne) {
				countModule1++;
			}else if(personList.get(i).getModule()==Module.ModuleTwo) {
				countModule2++;
			}else {
				countModule3++;
			}
		}
		
		if(module==Module.ModuleOne && countModule1<6) {
			System.out.println("1::"+countModule1+"   2::"+countModule2+"   3::"+countModule3);
			return true;
		}else if(module==Module.ModuleTwo && countModule2<6) {
			System.out.println("1::"+countModule1+"   2::"+countModule2+"   3::"+countModule3);
			return true;
		}else if(module==Module.ModuleThree && countModule3<16) {
			System.out.println("1::"+countModule1+"   2::"+countModule2+"   3::"+countModule3);
			return true;
		}
		
		return false;
	}
	
	private boolean checkAge(int year) {
		ArrayList<Person> personList = management.getPersonList();
		int adult = 0;
		int young = 0;
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).isAdult() && personList.get(i).getModule()==Module.ModuleThree) {
				adult++;
			}else if(personList.get(i).getModule()==Module.ModuleThree) {
				young++;
			}
		}
		System.out.println(year);
		if (adult<4 && year<=1961) {
			return true;
		}else if (young<12 && year>1961) {
			return true;
		}
		System.out.println("AGAIN");
		return false;
	}

}
