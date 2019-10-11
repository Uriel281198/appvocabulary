package sooyer.developer.com.palabrasandwords.Models;

/**
 * Created by Uriel on 15/07/2019.
 */

public class Module {
    private String nombre;

    private int background;
    private int Color;


    public Module() {
    }

    public Module(String nombre, int background, int color) {
        this.nombre = nombre;
        this.background = background;
        Color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }
}
