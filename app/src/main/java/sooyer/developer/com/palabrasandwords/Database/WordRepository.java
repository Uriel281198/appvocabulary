package sooyer.developer.com.palabrasandwords.Database;

import java.util.List;

import io.reactivex.Flowable;
import sooyer.developer.com.palabrasandwords.Local.WordDataSource;
import sooyer.developer.com.palabrasandwords.Models.Word;

/**
 * Created by Uriel on 30/04/2019.
 */

public class WordRepository implements IWordDataSource {

    private IWordDataSource mLocalDataSource;

    private static WordRepository mInstance;

    public WordRepository(IWordDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static WordRepository getIstance(IWordDataSource mLocalDataSource){
        if (mInstance == null){
            mInstance = new WordRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<Word> getWordById(int wordId) {
        return mLocalDataSource.getWordById(wordId);
    }

    @Override
    public Flowable<List<Word>> getAllWord() {
        return mLocalDataSource.getAllWord();
    }

    @Override
    public Flowable<List<Word>> getword() {
        return null;
    }


    @Override
    public void insertWord(Word... words) {
        mLocalDataSource.insertWord(words);
    }

    @Override
    public void updateWord(Word... words) {
        mLocalDataSource.updateWord(words);
    }

    @Override
    public void deleteWord(Word... words) {
        mLocalDataSource.deleteWord(words);
    }

    @Override
    public void deleteAllWords() {
        mLocalDataSource.deleteAllWords();
    }
}
