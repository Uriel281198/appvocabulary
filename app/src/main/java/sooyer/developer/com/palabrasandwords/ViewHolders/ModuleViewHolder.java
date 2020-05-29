package sooyer.developer.com.palabrasandwords.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.R;

/**
 * Created by Uriel on 15/07/2019.
 */

public class ModuleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView name;
    public ImageView background;
    public String Color;
    public ItemClickListener itemClickListener;

    public ModuleViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.namemodul);
        background = itemView.findViewById(R.id.backgroundmodul);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }
}
