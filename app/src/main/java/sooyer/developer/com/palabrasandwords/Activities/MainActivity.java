package sooyer.developer.com.palabrasandwords.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import sooyer.developer.com.palabrasandwords.Fragments.CategoryFragment;
import sooyer.developer.com.palabrasandwords.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }




    private void loadAllTemas(){
        String jsonSTR = loadJson("temas.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonSTR);
            JSONArray jsonArray = jsonObject.getJSONArray("temas");
        }catch (JSONException e){
            e.printStackTrace();

        }
    }

    private String loadJson(String file){
        String json = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte [] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }




    public void showToas(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_error_layout,(ViewGroup) findViewById(R.id.toast_root));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
    }
}