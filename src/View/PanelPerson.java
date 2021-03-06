package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelPerson extends JPanel{
	
	private ArrayList<PersonView> personList;
	private Image auxDraw;
	private Graphics2D auxGraph;
	
	public PanelPerson() {
		personList = new ArrayList<PersonView>();
	}

	public void setPersonList(ArrayList<PersonView> personList) {
		this.personList = personList;
	}

	@Override
	public void paint(Graphics g) {
		//limpiar fondo
		auxDraw = createImage(this.getWidth(), this.getHeight());
		auxGraph = ((Graphics2D)(auxDraw.getGraphics()));
		auxGraph.setStroke(new BasicStroke(5f));
		auxGraph.setColor(Color.DARK_GRAY);
		auxGraph.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//modulos
		
		auxGraph.setColor(new Color(0, 175, 70));
		auxGraph.drawRect(20, 20, 125, 60);
		auxGraph.drawString("Prestamos", 50, 55);
		auxGraph.setColor(new Color(59, 131, 189));
		auxGraph.drawRect(510, 100, 165, 60);
		auxGraph.drawString("Retiros y Consignaciones", 525, 140);
		auxGraph.setColor(Color.ORANGE);
		auxGraph.drawRect(20, 325, 120, 60);
		auxGraph.drawString("Asesoria", 60, 360);
		auxGraph.setColor(Color.YELLOW);
		auxGraph.drawRect(270, 335, 90, 50);
		auxGraph.drawString("Ticked", 295, 365);
		
		//decoracion
		auxGraph.setColor(Color.MAGENTA);
		auxGraph.drawRect(510, 20, 165, 80);
		auxGraph.drawString("Bobeda", 560, 70);
		auxGraph.setColor(new Color(194, 155, 97));
		auxGraph.drawLine(230, 470, 230, 450);
		auxGraph.drawLine(400, 470, 400, 450);
		auxGraph.setColor(Color.LIGHT_GRAY);
		auxGraph.drawLine(510, 200, 510, 360);
		auxGraph.drawLine(550, 200, 550, 320);
		auxGraph.drawLine(510, 360, 590, 360);
		auxGraph.drawLine(590, 240, 590, 360);
		auxGraph.drawLine(550, 200, 630, 200);
		auxGraph.drawLine(630, 200, 630, 360);
		auxGraph.drawLine(670, 200, 670, 360);
		auxGraph.setColor(new Color(45, 87, 44));
		auxGraph.fillRect(350, 20, 50, 120);
		auxGraph.fillRect(350, 180, 50, 120);
		auxGraph.setColor(new Color(146, 41, 42));
		auxGraph.fillRect(230, 20, 80, 120);
		auxGraph.fillRect(230, 180, 80, 120);
		auxGraph.setColor(new Color(180, 25, 25));
		auxGraph.drawLine(232, 20, 306, 20);
		auxGraph.drawLine(232, 60, 306, 60);
		auxGraph.drawLine(232, 100, 306, 100);
		auxGraph.drawLine(232, 140, 306, 140);
		auxGraph.drawLine(270, 20, 270, 140);
		auxGraph.drawLine(232, 180, 306, 180);
		auxGraph.drawLine(232, 220, 306, 220);
		auxGraph.drawLine(232, 260, 306, 260);
		auxGraph.drawLine(232, 300, 306, 300);
		auxGraph.drawLine(270, 180, 270, 300);
		
		if (personList.size()>0) {
			for (int i = 0; i < personList.size(); i++) {
				auxGraph.setColor(personList.get(i).getColor());
				auxGraph.fillOval(personList.get(i).getX(), personList.get(i).getY(), 25, 25);
			}
		}
		g.drawImage(auxDraw, 0, 0, this);
	}
	
}
