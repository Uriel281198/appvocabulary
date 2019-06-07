package sooyer.developer.com.palabrasandwords.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import sooyer.developer.com.palabrasandwords.Models.Word;

import static sooyer.developer.com.palabrasandwords.Local.WordDatabase.DATABASE_VERSION;

@Database(entities = Word.class,version = DATABASE_VERSION)

public abstract class WordDatabase extends RoomDatabase{

    public  static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME ="BASE-ROOM";

    public  abstract WordDao WordDAO();
    private static  WordDatabase mInstance;

    public static WordDatabase getInstance(Context context){
        if (mInstance==null){
            mInstance = Room.databaseBuilder(context,WordDatabase.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();}
        return mInstance;}}



