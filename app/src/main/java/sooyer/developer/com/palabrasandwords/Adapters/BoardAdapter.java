package sooyer.developer.com.palabrasandwords.Adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private Context nCtx;
    private List<Board> BoardList;
    ItemClickListener itemClickListener;

    public BoardAdapter(Context nCtx, List<Board> boardList) {
        this.nCtx = nCtx;
        this.BoardList = boardList;
    }

    @Override
    public BoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(nCtx);
        View view = inflater.inflate(R.layout.layout_item_board,null);
        return new BoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BoardViewHolder holder, int position) {
        Board board = BoardList.get(position);
        holder.name.setText(board.getPalabra());
        holder.traduccion.setText(board.getTraduccion());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(nCtx, "Hola "+position, Toast.LENGTH_SHORT).show();

            }
        });}

    @Override
    public int getItemCount() {
        return BoardList.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView name;
        TextView traduccion;
        ItemClickListener itemClickListener;


        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
        public BoardViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_board);
            traduccion = itemView.findViewById(R.id.traduccion);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
