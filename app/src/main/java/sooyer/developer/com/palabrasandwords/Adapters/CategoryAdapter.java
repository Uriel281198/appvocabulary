package sooyer.developer.com.palabrasandwords.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Activities.BoardActivity;
import sooyer.developer.com.palabrasandwords.Activities.Word_Activity;
import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.ViewHolders.*;
import sooyer.developer.com.palabrasandwords.R;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>  {
    private Context nCtx;
    private List<Category> categoryList;
    ItemClickListener itemClickListener;

    public CategoryAdapter(Context nCtx, List<Category> categoryList) {
        this.nCtx = nCtx;
        this.categoryList = categoryList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(nCtx);
        View view = inflater.inflate(sooyer.developer.com.palabrasandwords.R.layout.layout_item_categorias,null);
        return new  CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);

        holder.name.setText(category.getName().toUpperCase());
        holder.total.setText(String.valueOf(category.getTotal()));
        holder.background.setImageDrawable(nCtx.getResources().getDrawable(category.getBackground(),null));
        holder.icon.setImageDrawable(nCtx.getResources().getDrawable(category.getIcon(),null));
        holder.name.setTextColor(nCtx.getResources().getColor(category.getColor()));
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position == 0)
                    nCtx.startActivity(new Intent(nCtx,Word_Activity.class));
                else if (position == 1)
                    nCtx.startActivity(new Intent(nCtx,BoardActivity.class));
                else
                    Toast.makeText(nCtx, "Pressed on other side", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }




}
