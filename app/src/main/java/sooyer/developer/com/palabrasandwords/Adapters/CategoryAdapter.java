package sooyer.developer.com.palabrasandwords.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sooyer.developer.com.palabrasandwords.Activities.BoardActivity;
import sooyer.developer.com.palabrasandwords.Activities.Word_Activity;
import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.Models.Verbs;
import sooyer.developer.com.palabrasandwords.R;
import sooyer.developer.com.palabrasandwords.ViewHolders.CategoryViewHolder;

import static sooyer.developer.com.palabrasandwords.Resources.Resources.getIrregular;
import static sooyer.developer.com.palabrasandwords.Resources.Resources.soundsGlobal;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>  {
    private Context nCtx;
    private List<Category> categoryList;


    int color[] = {R.drawable.gradienterojo_opaco,R.drawable.gradientazul_opaco,R.drawable.gradientgris_opaco,R.drawable.gradienteverde_opaco,R.drawable.gradientcgris};
    int coloText[] ={R.color.colorRosaOpaco,R.color.colorAzulOpaco,R.color.colorMoradoOpaco,R.color.colorVerdeOpaco,R.color.colorAZpaco};
    ItemClickListener itemClickListener;


    List<Board> lista;
    List<Verbs> verbs;

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
        holder.total.setTextColor(nCtx.getResources().getColor(category.getColor()));
        holder.background.setImageDrawable(nCtx.getResources().getDrawable(category.getBackground(),null));
        holder.icon.setImageDrawable(nCtx.getResources().getDrawable(category.getIcon(),null));
        holder.name.setTextColor(nCtx.getResources().getColor(category.getColor()));
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch (position){
                    case 0:
                        nCtx.startActivity(new Intent(nCtx, Word_Activity.class));
                        break;
                    case 1:
                        irregularVerbs();
                        gotoBoard(nCtx,lista,"IRREGULAR VERBS");
                        break;
                    default:
                        Toast.makeText(nCtx, "Noppp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void irregularVerbs() {

        lista = getIrregular();



   }
    /*
    public void Home(){
        lista = new ArrayList<>();
        lista.add(new Board("room",    "habitación", "I KNOW", soundsGlobal[0], color[0],        coloText[0]));
        lista.add(new Board("balcony",  "balcon", "I KNOW", soundsGlobal[0], color[0],      coloText[0]));
        lista.add(new Board("bathroom","baño", "I KNOW", soundsGlobal[0], color[0],     coloText[0]));
        lista.add(new Board("bedroom", "dormitorio", "I KNOW", soundsGlobal[0], color[0],         coloText[0]));
        lista.add(new Board("dining room",  "comedor", "I KNOW", soundsGlobal[0], color[0],             coloText[0]));
    }*/

    public void gotoBoard(Context ctx,List<Board> lista,String titulo ){
        Intent intent = new Intent(ctx,BoardActivity.class);
        irregularVerbs();
        intent.putExtra("list", (Serializable) lista);
        intent.putExtra("titulo",titulo);
        ctx.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


}
