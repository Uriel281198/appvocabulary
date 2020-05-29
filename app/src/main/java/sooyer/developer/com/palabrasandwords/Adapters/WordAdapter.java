package sooyer.developer.com.palabrasandwords.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Common.Common;
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
        if (Common.istrue!=false){
            lwtrad.setText(mWordList.get(position).getTraslate());
        }else{
            lwtrad.setText("");
        }

        TextView lweje = v.findViewById(R.id.lWEjemplo);
        ImageView backround = v.findViewById(R.id.imageView3);
        backround.setImageDrawable(mcontext.getResources().getDrawable(mWordList.get(position).getColor()));
        lwpalabra.setText(mWordList.get(position).getWord().toUpperCase());
        lwpalabra.setTextColor(mcontext.getResources().getColor(mWordList.get(position).getTextcolor()));


        v.setTag(mWordList.get(position).getId());

        return v;

    }
}
