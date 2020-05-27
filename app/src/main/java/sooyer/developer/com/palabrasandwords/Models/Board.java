package sooyer.developer.com.palabrasandwords.Models;

import java.io.Serializable;

/**
 * Created by Uriel on 28/04/2019.sss
 */

public class Board implements Serializable
{
    private String palabra;
    private String traduccion;
    private String simplePast;
    private String pastParticple;

    public Board(String palabra, String traduccion, String simplePast, String pastParticple,String simplePastP,String pastParticpleP, int audio, int color, int colortexto) {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.simplePast = simplePast;
        this.pastParticple = pastParticple;
        this.audio = audio;
        this.color = color;
        this.colortexto = colortexto;
    }

    public Board(String beat, String s, String i_know, int i, int i1, int i2) {
    }

    public String getPalabra() {
        return palabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public String getSimplePast() {
        return simplePast;
    }

    public String getPastParticple() {
        return pastParticple;
    }

    public int getAudio() {
        return audio;
    }

    public int getColor() {
        return color;
    }

    public int getColortexto() {
        return colortexto;
    }

    private int audio;
    private int color;
    private int colortexto;

}
