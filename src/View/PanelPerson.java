package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelPerson extends JPanel{
	
	private ArrayList<PersonView> personList;
	private Image auxDraw;
	private Graphics auxGraph;
	
	public PanelPerson() {
		personList = new ArrayList<PersonView>();
		setBackground(new Color(0,0,0,0));
	}

	public void setPersonList(ArrayList<PersonView> personList) {
		this.personList = personList;
	}

	@Override
	public void paint(Graphics g) {
		if (personList.size()>0) {
			auxDraw = createImage(this.getWidth(), this.getHeight());
			auxGraph = auxDraw.getGraphics();
			for (int i = 0; i < personList.size(); i++) {
				auxGraph.setColor(personList.get(i).getColor());
				auxGraph.fillOval(personList.get(i).getX(), personList.get(i).getY(), 25, 25);
			}
		}
		g.drawImage(auxDraw, 0, 0, this);
	}
	
}
