package sooyer.developer.com.palabrasandwords.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import  android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import sooyer.developer.com.palabrasandwords.Adapters.BoardAdapter;
import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.Models.Word;
import sooyer.developer.com.palabrasandwords.R;

public class BoardActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    List<Board> boardAdapterList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        setToolbar("Board",true);

        boardAdapterList =  new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerboard);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        boardAdapterList.add(new Board("KNOsdsW","Saber","I KNOW",R.raw.sound_short));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));
        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));

        boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));boardAdapterList.add(new Board("Nose","Saber","I KNOW",R.raw.sound));



        BoardAdapter adapter = new BoardAdapter(this,boardAdapterList);
        recyclerView.setAdapter(adapter);



    }

    public void setToolbar(String name,Boolean up){
        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);

    }
}
