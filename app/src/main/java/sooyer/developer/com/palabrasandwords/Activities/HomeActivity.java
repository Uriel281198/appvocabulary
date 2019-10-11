package sooyer.developer.com.palabrasandwords.Activities;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;
import java.util.List;
import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Fragments.CategoryFragment;
import sooyer.developer.com.palabrasandwords.Fragments.ModuleFragment;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.R;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Category> categoryAdapterList ;
    SpaceNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar("Vocabulario and Vocabary",false);

        navigationView = findViewById(R.id.space);
        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.famyly));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.famyly));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            Fragment selectfragment  =  null;
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(HomeActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, Word_Activity.class));
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex){
                    case 0:
                        selectfragment = new CategoryFragment();
                        Toast.makeText(HomeActivity.this, "Hola0 ", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        selectfragment  = new ModuleFragment();
                        Toast.makeText(HomeActivity.this, "Hola1 ", Toast.LENGTH_SHORT).show();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(HomeActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

         /* BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
          bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
*/

          getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new CategoryFragment()).commit();
    }
/*
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectfragment  =  null;

                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selectfragment = new CategoryFragment();
                            break;
                        case R.id.navigation_dashboard:
                            selectfragment  = new ModuleFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();

                    return true;
                }
            };

*/
    public void setToolbar(String name,Boolean up){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);
    }

}

/*
<android.support.design.widget.BottomNavigationView
        android:layout_above="@+id/space"
        android:id="@+id/navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        app:itemIconTint="@color/colorWhite"
        app:itemTextColor="@color/colorWhite"
        android:background="@color/colorPrimary"
        app:menu="@menu/menu_bottom" />
*/