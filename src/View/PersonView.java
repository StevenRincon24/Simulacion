package View;

import java.awt.Color;


public class PersonView{

    private Color color;
    private int x;
    private int y;
    private String name;
    private String id;

    public PersonView(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public PersonView(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



}
