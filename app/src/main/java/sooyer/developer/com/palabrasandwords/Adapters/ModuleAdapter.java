package sooyer.developer.com.palabrasandwords.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Activities.Word_Activity;
import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.Models.Module;
import sooyer.developer.com.palabrasandwords.R;
import sooyer.developer.com.palabrasandwords.ViewHolders.CategoryViewHolder;
import sooyer.developer.com.palabrasandwords.ViewHolders.ModuleViewHolder;


public class ModuleAdapter extends RecyclerView.Adapter<ModuleViewHolder> {
    private Context nCtx;
    private List<Module> ModuleList;
    ItemClickListener itemClickListener;


    public ModuleAdapter(Context nCtx, List<Module> ModuleList) {
        this.nCtx = nCtx;
        this.ModuleList = ModuleList;
    }
    @Override
    public ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(nCtx);
        View view = inflater.inflate(R.layout.layout_item_module,null);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ModuleViewHolder holder, int position) {
        Module module = ModuleList.get(position);
        holder.name.setText(module.getNombre());
        holder.background.setImageDrawable(nCtx.getResources().getDrawable(module.getBackground(),null));
        holder.name.setTextColor(nCtx.getResources().getColor(module.getColor()));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                switch (position){
                    case 0:
                        Toast.makeText(nCtx, "Noppp", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(nCtx, "Noppp", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return ModuleList.size();
    }
}
