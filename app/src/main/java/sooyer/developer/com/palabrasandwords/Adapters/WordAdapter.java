package sooyer.developer.com.palabrasandwords.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Models.Word;
import sooyer.developer.com.palabrasandwords.R;

/**
 * Created by Uriel on 05/05/2019.
 */

public class WordAdapter extends BaseAdapter {

    public Context mcontext;
    private List<Word> mWordList;

    public WordAdapter(Context mcontext, List<Word> mWordList) {
        this.mcontext = mcontext;
        this.mWordList = mWordList;
    }

    @Override
    public int getCount() {
        return mWordList.size();
    }

    @Override
    public Object getItem(int position) {
        return mWordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mcontext, R.layout.layout_item_word,null);
        TextView lwpalabra = v.findViewById(R.id.lWPalabra);
        TextView lwtrad = v.findViewById(R.id.lWTraduccion);
        TextView lweje = v.findViewById(R.id.lWEjemplo);

        lwpalabra.setText(mWordList.get(position).getWord());
        lwtrad.setText(mWordList.get(position).getTraslate());
        lweje.setText(mWordList.get(position).getExample());

        v.setTag(mWordList.get(position).getId());

        return v;

    }
}
