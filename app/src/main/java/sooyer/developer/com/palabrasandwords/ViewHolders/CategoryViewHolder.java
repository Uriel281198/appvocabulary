package sooyer.developer.com.palabrasandwords.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.R;

/**
 * Created by Uriel on 29/04/2019.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name;
    public ImageView icon,background;
    public TextView total;
    public String Color;
    public ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CategoryViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        icon = itemView.findViewById(R.id.icon);
        total = itemView.findViewById(R.id.total);
        background = itemView.findViewById(R.id.background);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }
}