package sooyer.developer.com.palabrasandwords.Adapters;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Activities.DetailBoardActivity;
import sooyer.developer.com.palabrasandwords.Activities.Word_Activity;
import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private Context nCtx;
    private List<Board> BoardList;
    SoundPool sp;
    int audio [ ] = {R.raw.sound,R.raw.sound_short};
    int sonido;
    ItemClickListener itemClickListener;
    public View mView;

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
        final Board board = BoardList.get(position);
        holder.name.setText(board.getPalabra());
        holder.traduccion.setText(board.getTraduccion());
        final LayoutInflater inflater = LayoutInflater.from(nCtx);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(nCtx);
                View vista = inflater.inflate(R.layout.dialog_board,null);
                mbuilder.setView(vista);
                final AlertDialog dialog = mbuilder.create();
                dialog.show();
                TextView txtp =  vista.findViewById(R.id.txtpalabra_board);
                TextView txtt =  vista.findViewById(R.id.txttraduccion_board);
                TextView txte =  vista.findViewById(R.id.txtejemplo_board);
                Button btn = vista.findViewById(R.id.btn_sound);
                txtp.setText(board.getPalabra());
                txtt.setText(board.getTraduccion());
                txte.setText(board.getEjemplo());

                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build();

                sp = new SoundPool.Builder()
                        .setMaxStreams(10)
                        .build();

                sonido = sp.load(nCtx,board.getAudio(),1);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(nCtx, "gig", Toast.LENGTH_SHORT).show();
                        sp.play(sonido,1,1,1,1,1);
                    }
                });


/*
                Intent go_detail = new Intent(nCtx, DetailBoardActivity.class);
                go_detail.putExtra("wo",board.getPalabra());
                go_detail.putExtra("so",board.getAudio());
                nCtx.startActivity(go_detail);

*/


            }
        });
    }
    public int  musica(){
        int audio [ ] = {R.raw.sound,R.raw.sound_short};

        return  sonido;
    }
    //Toast.makeText(nCtx, "clicked"+position, Toast.LENGTH_SHORT).show();

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

