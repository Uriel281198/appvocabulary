package sooyer.developer.com.palabrasandwords.Models;

import java.io.Serializable;

/**
 * Created by Uriel on 28/04/2019.
 */

public class Board implements Serializable
{
    private String palabra;
    private String traduccion;
    private String ejemplo;

    private int audio;
    private int color;
    private int colortexto;
    public Board(String palabra, String traduccion, String ejemplo, int audio,int color,int colortexto)  {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.ejemplo = ejemplo;
        this.audio = audio;
        this.color =color;
        this.colortexto = colortexto;
    }

    public int getColortexto() {
        return colortexto;
    }

    public void setColortexto(int colortexto) {
        this.colortexto = colortexto;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
