package sooyer.developer.com.palabrasandwords.Local;

import java.util.List;

import io.reactivex.Flowable;
import sooyer.developer.com.palabrasandwords.Database.IWordDataSource;
import sooyer.developer.com.palabrasandwords.Models.Word;

/**
 * Created by Uriel on 30/04/2019.
 */

public class WordDataSource implements IWordDataSource{

    private WordDao wordDao;
    private static WordDataSource minstance;


    public WordDataSource(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public static WordDataSource getIstance(WordDao wordDao){
        if (minstance==null){
            minstance= new WordDataSource(wordDao);
        }
        return minstance;
    }


    @Override
    public Flowable<Word> getWordById(int wordId) {
        return wordDao.getWordById(wordId);
    }

    @Override
    public Flowable<List<Word>> getAllWord() {
        return wordDao.getAllWord();
    }

    @Override
    public Flowable<List<Word>> getword() {
        return null;
    }

    @Override
    public void insertWord(Word... words) {
        wordDao.insertWord(words);
    }

    @Override
    public void updateWord(Word... words) {
        wordDao.updateWord(words);
    }

    @Override
    public void deleteWord(Word... words) {
        wordDao.deleteWord(words);
    }

    @Override
    public void deleteAllWords() {
        wordDao.deleteAllWords();
    }
}
