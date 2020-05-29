package sooyer.developer.com.palabrasandwords.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import sooyer.developer.com.palabrasandwords.Models.Word;

/**
 * Created by Uriel on 30/04/2019.
 */
@Dao
public interface WordDao {
    @Query("Select *from words where id=:wordId")
    Flowable<Word> getWordById(int wordId);

    @Query("Select * from words")
    Flowable<List<Word>> getAllWord();

    @Insert
    void insertWord(Word...words);

    @Update
    void updateWord(Word...words);

    @Delete
    void deleteWord(Word...words);

    @Query("Delete from words")
    void deleteAllWords();


}
