package sooyer.developer.com.palabrasandwords.Activities;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Space;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;
import java.util.List;
import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Fragments.CategoryFragment;
import sooyer.developer.com.palabrasandwords.Fragments.ConfiguracionFragment;
import sooyer.developer.com.palabrasandwords.Fragments.ModuleFragment;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.R;

import static sooyer.developer.com.palabrasandwords.Common.Common.changeThemeGlobal;
import static sooyer.developer.com.palabrasandwords.Common.Common.colorTheme;

public class HomeActivity extends AppCompatActivity {
    //BootomNavigation
    private SpaceNavigationView spaceNavigationView;
    Fragment selectfragment  =  null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        colorTheme = loadDataPreferens();
        changeThemeGlobal(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar("Vocabulary",false);
        spaceNavigationView =  findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.home));
        spaceNavigationView.addSpaceItem(new SpaceItem("SEARCH", R.drawable.home));
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Intent i = new Intent(HomeActivity.this,Word_Activity.class);
                startActivity(i);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                switch (itemIndex){
                    case 0:
                        Toast.makeText(HomeActivity.this, "Im here ", Toast.LENGTH_SHORT).show();
                        selectfragment = new CategoryFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
                    break;
                    case 1:
                        selectfragment  = new ModuleFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
                     break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
                return ;
            }
            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                switch (itemIndex){
                    case 0:
                        Toast.makeText(HomeActivity.this, "Im here ", Toast.LENGTH_SHORT).show();
                        selectfragment = new CategoryFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
                        break;
                    case 1:
                        selectfragment  = new ModuleFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new CategoryFragment()).commit();
    }

    //Menu Create and Select
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_Config:
                selectfragment =  new ConfiguracionFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectfragment).commit();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
            }
    }

    public void setToolbar(String name,Boolean up){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);
    }
    public void changeTheme(){
        if (colorTheme == 1){
            Toast.makeText(this, "Si hay", Toast.LENGTH_SHORT).show();
            setTheme(R.style.RedThme);
        }else if(colorTheme == 2){
            setTheme(R.style.AppTheme);
        }
    }

    public  int  loadDataPreferens(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        int nuevoColor = sharedPreferences .getInt("color_selected",0);
        Toast.makeText(this, ""+nuevoColor, Toast.LENGTH_SHORT).show();
        return nuevoColor;

    }
}
