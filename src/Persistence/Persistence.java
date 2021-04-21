package Persistence;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Model.Passerby;
import Model.Person;
import View.PersonView;


/**
 * The Class Persistence.
 */
public class Persistence {
	
//-----------------------------------------------------------------------------------PERSON-------------------------------------------	
	public void uploadPersons(ArrayList<Person> personList, ArrayList<Passerby> passerbyList) {
		FileWriter fwFileWriter = null;
		try {
			fwFileWriter = new FileWriter("files/personList.txt");
			BufferedWriter bwWrite = new BufferedWriter(fwFileWriter);

			if (personList.size()>0) {
				for (int i = 0; i < personList.size(); i++) {
					bwWrite.write(personList.get(i).getColor().getRed()+";P;"+personList.get(i).getColor().getGreen()+";P;"+
								  personList.get(i).getColor().getBlue()+";P;"+personList.get(i).getX()+";P;"+personList.get(i).getY()+"\n");
				}
			}
			if (passerbyList.size()>0) {
				for (int i = 0; i < passerbyList.size(); i++) {
					bwWrite.write(passerbyList.get(i).getColor().getRed()+";P;"+passerbyList.get(i).getColor().getGreen()+";P;"+
							passerbyList.get(i).getColor().getBlue()+";P;"+passerbyList.get(i).getX()+";P;"+passerbyList.get(i).getY()+"\n");
				}
			}
			bwWrite.close();
//			System.out.println("EL ARCHIVO \"personList.txt\" FUE CREADO CORRECTAMENTE");
		} catch (IOException e) {
			System.out.println("ARCHIVO \"personList.txt\" NO EXISTE");
		} finally {
			if (fwFileWriter != null) {
				try {
					fwFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<PersonView> downloadPerson() {
		ArrayList<PersonView> personList = new ArrayList<PersonView>();
		try {
			File file = new File("files/personList.txt");
			Scanner sc = new Scanner(file);
			Color color;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner delimiting = new Scanner(line);
				delimiting.useDelimiter("\\s*;P;\\s*");
				
				color = new Color(Integer.parseInt(delimiting.next()), Integer.parseInt(delimiting.next()), Integer.parseInt(delimiting.next()));
				PersonView Person = new PersonView(color, Integer.parseInt(delimiting.next()), Integer.parseInt(delimiting.next()));
				personList.add(Person);	
			}
		} catch (FileNotFoundException e) {
			System.out.println("EL ARCHIVO \"personList.txt\" NO EXISTE ");
		}
		
		return personList;
	}
	
}
