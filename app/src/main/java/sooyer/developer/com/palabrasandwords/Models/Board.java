package sooyer.developer.com.palabrasandwords.Models;

/**
 * Created by Uriel on 28/04/2019.
 */

public class Board
{
    private String palabra;
    private String traduccion;
    private String ejemplo;

    public Board(String palabra, String traduccion, String ejemplo) {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.ejemplo = ejemplo;
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
}
