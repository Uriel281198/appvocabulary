package sooyer.developer.com.palabrasandwords.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import sooyer.developer.com.palabrasandwords.Adapters.WordAdapter;
import sooyer.developer.com.palabrasandwords.Database.WordRepository;
import sooyer.developer.com.palabrasandwords.Local.WordDataSource;
import sooyer.developer.com.palabrasandwords.Local.WordDatabase;
import sooyer.developer.com.palabrasandwords.Models.Word;
import sooyer.developer.com.palabrasandwords.R;

public class Word_Activity extends AppCompatActivity {
    FloatingActionButton fab ;
    private ListView lsWord;
    List<Word> wordList= new ArrayList<>();
    WordAdapter adapter;
    private Button btn;
    private Button btncancel;

    private CompositeDisposable compositeDisposable;
    private WordRepository wordRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_);
        setToolbar("INSERT",false);

        compositeDisposable= new CompositeDisposable();
        lsWord= findViewById(R.id.lsWord);
        fab = findViewById(R.id.fab_button);
        adapter = new WordAdapter(getApplicationContext(),wordList);
        registerForContextMenu(lsWord);
        lsWord.setAdapter(adapter);

        WordDatabase wordDatabase = WordDatabase.getInstance(this);
        wordRepository = WordRepository.getIstance(WordDataSource.getIstance(wordDatabase.WordDAO()));
        loadData();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(Word_Activity.this);
                final View mView = getLayoutInflater().inflate(R.layout.dialog_word, null);
                mbuilder.setView(mView);
                final AlertDialog dialog = mbuilder.create();
                dialog.show();

                btn = mView.findViewById(R.id.btn_mostrarinfo);
                btncancel = mView.findViewById(R.id.btn_cancelar);
                btn.setOnClickListener(new View.OnClickListener() {
                    EditText txtpalabra =  mView.findViewById(R.id.txtpalabra);
                    EditText txttraduccion =  mView.findViewById(R.id.txttraduccion);
                    EditText txtejemplo = mView.findViewById(R.id.txtejemplo);

                    @Override
                    public void onClick(View v) {
                        if (TextUtils.isEmpty(txtejemplo.getText()))
                            txtejemplo.setText("There aren´t example");

                        Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
                            @Override
                            public void subscribe(ObservableEmitter<Object> e) throws Exception {

                                Word word = new Word(txtpalabra.getText().toString(),txttraduccion.getText().toString(), txtejemplo.getText().toString());
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
                        dialog.dismiss();

                    }


                });

                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    public void close(AlertDialog dial){

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
}


/*
* Nootas
* ReactiveX es una API que facilita el manejo de
* flujos de datos y eventos, a partir de una
* combinación de el patrón Observer, el patrón Iterator,
* y características de la Programación Funcional.
* */

