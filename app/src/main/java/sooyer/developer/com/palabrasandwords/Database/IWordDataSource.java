package sooyer.developer.com.palabrasandwords.Database;

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

public interface IWordDataSource {

    Flowable<Word> getWordById(int wordId);
    Flowable<List<Word>> getAllWord();
    Flowable<List<Word>> getword();
    void insertWord(Word...words);
    void updateWord(Word...words);
    void deleteWord(Word...words);

    @Query("Delete from words")
    void deleteAllWords();


}
