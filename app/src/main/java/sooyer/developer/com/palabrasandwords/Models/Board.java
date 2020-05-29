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
    String simplePastP;
    String pastParticpleP;
    int audio;
    int color;
    int colortexto;

    public Board(String palabra, String traduccion, String simplePast, String pastParticple, String simplePastP, String pastParticpleP, int audio, int color, int colortexto) {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.simplePast = simplePast;
        this.pastParticple = pastParticple;
        this.simplePastP = simplePastP;
        this.pastParticpleP = pastParticpleP;
        this.audio = audio;
        this.color = color;
        this.colortexto = colortexto;
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

    public String getSimplePast() {
        return simplePast;
    }

    public void setSimplePast(String simplePast) {
        this.simplePast = simplePast;
    }

    public String getPastParticple() {
        return pastParticple;
    }

    public void setPastParticple(String pastParticple) {
        this.pastParticple = pastParticple;
    }

    public String getSimplePastP() {
        return simplePastP;
    }

    public void setSimplePastP(String simplePastP) {
        this.simplePastP = simplePastP;
    }

    public String getPastParticpleP() {
        return pastParticpleP;
    }

    public void setPastParticpleP(String pastParticpleP) {
        this.pastParticpleP = pastParticpleP;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColortexto() {
        return colortexto;
    }

    public void setColortexto(int colortexto) {
        this.colortexto = colortexto;
    }
}
