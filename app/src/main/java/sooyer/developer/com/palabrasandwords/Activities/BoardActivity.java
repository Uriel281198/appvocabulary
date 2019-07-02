package sooyer.developer.com.palabrasandwords.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sooyer.developer.com.palabrasandwords.Adapters.BoardAdapter;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.R;

public class BoardActivity extends AppCompatActivity  implements android.support.v7.widget.SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    ArrayList<Board> boardAdapterList ;
    BoardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        setContentView(R.layout.activity_board);
        setToolbar(i.getExtras().getString("titulo"),true);
        boardAdapterList =  new ArrayList<>();
        boardAdapterList= (ArrayList<Board>)i.getSerializableExtra("list");
        List<ArrayList<Board>> targetList = Arrays.asList(boardAdapterList);

        recyclerView = findViewById(R.id.recyclerboard);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter = new BoardAdapter(this,boardAdapterList);
        recyclerView.setAdapter(adapter);
    }

    private  void filter(String text){
        ArrayList<Board> filter = new ArrayList<>();
        for(Board item : boardAdapterList){
            if (item.getPalabra().toUpperCase().contains(text.toUpperCase()) || item.getTraduccion().toUpperCase().contains(text.toUpperCase()) ) {
                filter.add(item);
            }else if(text.isEmpty()){
            }
        }
        adapter.filterList(filter);

    }


    public void setToolbar(String name,Boolean up){
        Toolbar toolbar =  findViewById(R.id.toolbarword);
        TextView titulo = findViewById(R.id.titulowords);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);
        titulo.setText(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toUpperCase();
        ArrayList<Board> filter = new ArrayList<>();
        for(Board item : boardAdapterList){
            if (item.getPalabra().toUpperCase().contains(userInput.toUpperCase()) || item.getTraduccion().toUpperCase().contains(userInput.toUpperCase()) ) {
                filter.add(item);
            }else if(userInput.isEmpty()){
            }
        }
        adapter.filterList(filter);
        return true;
    }
}
