package sooyer.developer.com.palabrasandwords.Models;

/**
 * Created by Uriel on 28/04/2019.
 */

public class Category {
    private String name;
    private int icon;
    private int total;
    private int background;
    private int Color;


    public Category(String name, int icon, int total, int background, int color) {
        this.name = name;
        this.icon = icon;
        this.total = total;
        this.background = background;
        Color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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