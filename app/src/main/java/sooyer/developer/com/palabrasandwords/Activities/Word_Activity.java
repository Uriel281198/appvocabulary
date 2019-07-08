package sooyer.developer.com.palabrasandwords.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import sooyer.developer.com.palabrasandwords.Adapters.WordAdapter;
import sooyer.developer.com.palabrasandwords.Common.Common;
import sooyer.developer.com.palabrasandwords.Database.WordRepository;
import sooyer.developer.com.palabrasandwords.Local.WordDataSource;
import sooyer.developer.com.palabrasandwords.Local.WordDatabase;
import sooyer.developer.com.palabrasandwords.Models.Word;
import sooyer.developer.com.palabrasandwords.R;



public class Word_Activity extends AppCompatActivity {

    private ListView lsWord;
    private List<Word> wordList= new ArrayList<>();
    private WordAdapter adapter;

    //Base de datos
    private CompositeDisposable compositeDisposable;
    private WordRepository wordRepository;

    private Context context=this;
    private FloatingActionButton fab ;
    private Button btnSend,btnCancel,btnTras;

    public View mView;
    private EditText txtpalabra ,txtejemplo, txttraduccion;

    private Button btnmorado;
    private Button btngris;
    private Button btnrojo;
    private Button btnverde;
    private Button btnazul;

    private int indice = 0;
    int color =       R.drawable.gradientcazul;
    int colorTexto =  R.color.colorAzul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_);
        setToolbar("MY WORDS",true);
        compositeDisposable= new CompositeDisposable();
        //Obtenicion id's
        lsWord= findViewById(R.id.lsWord);
        fab = findViewById(R.id.fab_button);
        //Adapatador de palabras
        adapter = new WordAdapter(getApplicationContext(),wordList);
        registerForContextMenu(lsWord);
        lsWord.setAdapter(adapter);

        //Database traer instancia
        WordDatabase wordDatabase = WordDatabase.getInstance(this);
        wordRepository = WordRepository.getIstance(WordDataSource.getIstance(wordDatabase.WordDAO()));
        //Cargar datos de la bd
        loadData();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(Word_Activity.this);
                mView = getLayoutInflater().inflate(R.layout.dialog_word, null);
                mbuilder.setView(mView);

                final AlertDialog dialog = mbuilder.create();
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                getIds();
                btnTras.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!TextUtils.isEmpty(txtpalabra.getText()))
                            Translate(txtpalabra.getText().toString(), Common.LANGUAGE_PAIR);
                        else
                            Toast.makeText(Word_Activity.this, "INSERT A WORD PLEASE", Toast.LENGTH_SHORT).show();
                    }
                });
                btnmorado.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            btnmorado.setBackgroundResource(R.drawable.shape_colorselecc);
                            btngris.setBackgroundResource(R.drawable.shape_gris);
                            btnazul.setBackgroundResource(R.drawable.shape_blue);
                            btnrojo.setBackgroundResource(R.drawable.shape_red);
                            btnverde.setBackgroundResource(R.drawable.shape_green);
                            color =R.drawable.gradientcmorado;
                            colorTexto = R.color.colorMorado;



                    }
                });
                btngris.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnmorado.setBackgroundResource(R.drawable.shape_color);
                        btngris.setBackgroundResource(R.drawable.shape_grisselecc);
                        btnazul.setBackgroundResource(R.drawable.shape_blue);
                        btnrojo.setBackgroundResource(R.drawable.shape_red);
                        btnverde.setBackgroundResource(R.drawable.shape_green);
                        //btngris.setBackgroundColor(ContextCompat.getColor(getBaseContext(),));
                        //btngris.setBackground(getResources().getDrawable(R.drawable.shape_grisselecc));
                        btngris.setBackgroundResource(R.drawable.shape_grisselecc);
                        color =R.drawable.gradientcgris;
                        colorTexto = R.color.colorGris;
                    }
                });
                btnrojo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color =R.drawable.gradientcrojo;
                        colorTexto = R.color.colorRojo;
                        btnmorado.setBackgroundResource(R.drawable.shape_color);
                        btngris.setBackgroundResource(R.drawable.shape_gris);
                        btnazul.setBackgroundResource(R.drawable.shape_blue);
                        btnrojo.setBackgroundResource(R.drawable.shape_redselecc);
                        btnverde.setBackgroundResource(R.drawable.shape_green);

                    }
                });
                btnverde.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color =R.drawable.gradientcverde;
                        colorTexto = R.color.colorVerde;
                        btnmorado.setBackgroundResource(R.drawable.shape_color);
                        btngris.setBackgroundResource(R.drawable.shape_gris);
                        btnazul.setBackgroundResource(R.drawable.shape_blue);
                        btnrojo.setBackgroundResource(R.drawable.shape_red);
                        btnverde.setBackgroundResource(R.drawable.shape_greenselecc);

                    }
                });
                btnazul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color =R.drawable.gradientcazul;
                        colorTexto = R.color.colorAzul;
                        btnmorado.setBackgroundResource(R.drawable.shape_color);
                        btngris.setBackgroundResource(R.drawable.shape_gris);
                        btnazul.setBackgroundResource(R.drawable.shape_blueselecc);
                        btnrojo.setBackgroundResource(R.drawable.shape_red);
                        btnverde.setBackgroundResource(R.drawable.shape_green);

                    }
                });


                btnSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (TextUtils.isEmpty(txtejemplo.getText()))
                            txtejemplo.setText("There aren´t examples");
                        if (TextUtils.isEmpty(txtpalabra.getText()))
                            Toast.makeText(Word_Activity.this, "INSERT A WORD PLEASE", Toast.LENGTH_SHORT).show();

                        Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
                            @Override
                            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                                Word word = new Word(txtpalabra.getText().toString(),txttraduccion.getText().toString(), txtejemplo.getText().toString(),color,colorTexto);
                                wordList.add(word);
                                wordRepository.insertWord(word);
                                e.onComplete();
                            }
                        })
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Consumer<Object>() {

                                    @Override
                                    public void accept(Object o) throws Exception {
                                        Toast.makeText(Word_Activity.this, "Sucecfully", Toast.LENGTH_SHORT).show();
                                        Log.e("lolllll",""+wordList.toString());
                                    }
                                },new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Toast.makeText(Word_Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }, new Action() {
                                    @Override
                                    public void run() throws Exception {
                                        loadData();
                                    }
                                });
                        dialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
            public void getIds(){
                btnSend = mView.findViewById(R.id.btn_mostrarinfo);
                btnCancel = mView.findViewById(R.id.btn_cancelar);
                btnTras = mView.findViewById(R.id.btn_traslate);
                txttraduccion =  mView.findViewById(R.id.txttraduccion);
                txtpalabra =  mView.findViewById(R.id.txtpalabra);
                txtejemplo = mView.findViewById(R.id.txtejemplo);
                btnmorado = mView.findViewById(R.id.send_purple);
                btngris = mView.findViewById(R.id.send_gray);
                btnrojo = mView.findViewById(R.id.send_red);
                btnverde = mView.findViewById(R.id.send_green);
                btnazul = mView.findViewById(R.id.send_blue);
            }
        });
    }

    private void Translate(String textToBeTranslated,String languagePair){
        TranslatorBackgroundTask translatorBackgroundTask= new TranslatorBackgroundTask(context);
        translatorBackgroundTask.execute(textToBeTranslated,languagePair);
    }
    private void loadData() {
        Disposable disposable = wordRepository.getAllWord()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Word>>() {
                               @Override
                               public void accept(List<Word> words) throws Exception {
                                   onGetAllWords(words);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   Toast.makeText(Word_Activity.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                );
        compositeDisposable.add(disposable);
    }

    private void onGetAllWords(List<Word> words) {
        wordList.clear();
        wordList.addAll(words);
        adapter.notifyDataSetChanged();
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    //Menu Selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.clear:
                deleteallUser();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteallUser() {
        Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
               wordRepository.deleteAllWords();
                e.onComplete();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {
                        Toast.makeText(Word_Activity.this, "Adios", Toast.LENGTH_SHORT).show();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(Word_Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        loadData();
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Selcciona alguna accion");
        menu.add(Menu.NONE,0,Menu.NONE,"Update");
        menu.add(Menu.NONE,1,Menu.NONE,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Word word = wordList.get(info.position);
        switch (item.getItemId()){
            case 0:
                final EditText edtext = new EditText(Word_Activity.this);
                edtext.setText(word.getWord());
                edtext.setHint("Enter Your Word");

                final EditText edtraduccion = new EditText(Word_Activity.this);
                edtraduccion.setText(word.getTraslate());
                edtraduccion.setHint("Enter Traslate");

                final Dialog dialog = new Dialog(this);
                new AlertDialog.Builder(Word_Activity.this)
                        .setTitle("Edit")
                        .setMessage("Edit Word")
                        .setView(edtext)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (TextUtils.isEmpty(edtext.getText().toString()))
                                    return;
                                else
                                {
                                    word.setWord(edtext.getText().toString());
                                    updateWord(word);
                                }
                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;
            case 1:
                new AlertDialog.Builder(Word_Activity.this)
                        .setMessage("Delette this")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteWord(word);
                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;
        }
        return true;
    }
    private void deleteWord(final Word word) {
        Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                wordRepository.deleteWord(word);
                e.onComplete();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(Word_Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        loadData();
                    }
                });
        compositeDisposable.add(disposable);
    }
    private void updateWord(final Word word) {
        Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                wordRepository.updateWord(word);
                e.onComplete();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(Word_Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        loadData();
                    }
                });
        compositeDisposable.add(disposable);
    }
    public void setToolbar(String name,Boolean up){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);
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

                Log.d("Translation Resultaaa:", resultString);
                //return jsonStringBuilder.toString().trim();
                return  resultString;
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
            txttraduccion.setText(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}


/*
* Nootas
* ReactiveX es una API que facilita el manejo de
* flujos de datos y eventos, a partir de una
* combinación de el patrón Observer, el patrón Iterator,
* y características de la Programación Funcional.
* */

