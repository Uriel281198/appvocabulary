package sooyer.developer.com.palabrasandwords.Activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.R;


public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Category> categoryAdapterList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar("Vocabulario and Vocabary",false);
        categoryAdapterList =  new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        full_list();
        CategoryAdapter adapter = new CategoryAdapter(this,categoryAdapterList);
        recyclerView.setAdapter(adapter);
    }


    public void setToolbar(String name,Boolean up){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);
    }
    public void full_list(){
        categoryAdapterList.add( new Category ("My Words",R.drawable.lista, 2,R.drawable.gradientcrojo,R.color.colorRojo));
        categoryAdapterList.add( new Category ("Irregular verbs",R.drawable.irre,101,R.drawable.gradientcazul,R.color.colorAzul));
        categoryAdapterList.add( new Category ("Home",R.drawable.home,24,R.drawable.gradientcmorado,R.color.colorMorado));
        categoryAdapterList.add( new Category ("Dining Room",R.drawable.dinning,18,R.drawable.gradientcverde,R.color.colorVerde));
        categoryAdapterList.add( new Category ("Kitchen",R.drawable.kitchen,35,R.drawable.gradientcrojo,R.color.colorRojo));
        categoryAdapterList.add( new Category ("ADVERBSOFTIME",R.drawable.time,30,R.drawable.gradientcazul,R.color.colorAzul));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));


    }
}
