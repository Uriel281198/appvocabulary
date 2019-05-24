package sooyer.developer.com.palabrasandwords.Activities;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sooyer.developer.com.palabrasandwords.R;

public class DetailBoardActivity extends AppCompatActivity {
    TextView word;
    int audio;

    int sonido;
    SoundPool sp;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_board);
        word = findViewById(R.id.word_details);
        btn = findViewById(R.id.btn_repro);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("wo")!= null){
            word.setText(bundle.getString("wo"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            sp = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();
        }else{
            sp = new SoundPool(6, AudioManager.STREAM_MUSIC,1);

        }
        audio = sp.load(this,bundle.getInt("so"),1);
/*
        sonido = bundle.getInt("so");

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

        audio = soundPool.load(this,sonido,1);
*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(audio,1,1,1,1,1);
            }
        });
    }
}
