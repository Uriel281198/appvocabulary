package sooyer.developer.com.palabrasandwords.Activities;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import sooyer.developer.com.palabrasandwords.R;

public class MainActivity extends AppCompatActivity {
    Context context=this;
    String textToBeTranslated;
    String languagePair;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.trasla);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);

        /*

        textToBeTranslated = "Hello world, yeah I know it is stereotye.";
        languagePair = "en-fr"; //English to French ("<source_language>-<target_language>")
        //Executing the translation function


        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Translate(textToBeTranslated, languagePair);
                Toast.makeText(context, "pres", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void Translate(String textToBeTranslated,String languagePair){
        TranslatorBackgroundTask translatorBackgroundTask= new TranslatorBackgroundTask(context);
        translatorBackgroundTask.execute(textToBeTranslated,languagePair);
    }

    public class TranslatorBackgroundTask extends AsyncTask<String, Void, String> {
        //Declare Context
        Context ctx;

        //Set Context
        public TranslatorBackgroundTask(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        protected String doInBackground(String... params) {
            //String variables
            String textToBeTranslated = params[0];
            String languagePair = params[1];

            String jsonString;

            try {
                //Set up the translation call URL
                String yandexKey = "trnsl.1.1.20190515T160909Z.009c417fac077dbe.57dfb0e48a7e5a2d5ec60abe061552bcc9145f28";
                String yandexUrl = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + yandexKey
                        + "&text=" + textToBeTranslated + "&lang=" + languagePair;
                URL yandexTranslateURL = new URL(yandexUrl);

                //Set Http Conncection, Input Stream, and Buffered Reader
                HttpURLConnection httpJsonConnection = (HttpURLConnection) yandexTranslateURL.openConnection();
                InputStream inputStream = httpJsonConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                //Set string builder and insert retrieved JSON result into it
                StringBuilder jsonStringBuilder = new StringBuilder();
                while ((jsonString = bufferedReader.readLine()) != null) {
                    jsonStringBuilder.append(jsonString + "\n");
                }

                //Close and disconnect
                bufferedReader.close();
                inputStream.close();
                httpJsonConnection.disconnect();

                //Making result human readable
                String resultString = jsonStringBuilder.toString().trim();
                //Getting the characters between [ and ]
                resultString = resultString.substring(resultString.indexOf('[') + 1);
                resultString = resultString.substring(0, resultString.indexOf("]"));
                //Getting the characters between " and "
                resultString = resultString.substring(resultString.indexOf("\"") + 1);
                resultString = resultString.substring(0, resultString.indexOf("\""));

                Log.d("Translation Result:", resultString);

                return resultString;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            txt.setText(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }*/
    }
}