package sooyer.developer.com.palabrasandwords.Activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import sooyer.developer.com.palabrasandwords.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setToolbar("TEST",true);

        findViewById(R.id.btn_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));
            }
        });
    }


    public void setToolbar(String name,Boolean up){
        Toolbar toolbar =  findViewById(R.id.toolbarword);
        TextView titulo = findViewById(R.id.titulowords);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);
        titulo.setText(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);

    }
}
