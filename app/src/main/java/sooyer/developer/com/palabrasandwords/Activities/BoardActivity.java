package sooyer.developer.com.palabrasandwords.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import  android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sooyer.developer.com.palabrasandwords.Adapters.BoardAdapter;
import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.Models.Word;
import sooyer.developer.com.palabrasandwords.R;

public class BoardActivity extends AppCompatActivity  {
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


        EditText search = findViewById(R.id.search);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                filter(s.toString());
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });




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
        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);

    }
}
