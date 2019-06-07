package sooyer.developer.com.palabrasandwords.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by Uriel on 30/04/2019.
 */
@Entity(tableName = "words")
public class Word  {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "word")
    private String word;

    @ColumnInfo(name = "traslate")
    private String traslate;

    @ColumnInfo(name = "example")
    private String example;

    @ColumnInfo(name = "color")
    private int color;


    @ColumnInfo(name = "texto")
    private int textcolor;

    public Word() {
    }

    public int getTextcolor() {
        return textcolor;
    }

    public void setTextcolor(int textcolor) {
        this.textcolor = textcolor;
    }

    @Ignore
    public Word(String word, String traslate, String example,int color,int textcolor) {
        this.word = word;
        this.traslate = traslate;
        this.example = example;
        this.color = color;
        this.textcolor = textcolor;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTraslate() {
        return traslate;
    }

    public void setTraslate(String traslate) {
        this.traslate = traslate;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return new StringBuilder(word).append("\n").append(traslate).append("\n").append(example).toString();
    }
}
