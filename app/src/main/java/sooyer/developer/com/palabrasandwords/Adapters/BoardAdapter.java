package sooyer.developer.com.palabrasandwords.Adapters;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sooyer.developer.com.palabrasandwords.Activities.HomeActivity;
import sooyer.developer.com.palabrasandwords.Activities.MainActivity;
import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.Models.Verbs;
import sooyer.developer.com.palabrasandwords.R;
import sooyer.developer.com.palabrasandwords.Util.RemindNotificacion;

import static android.content.Context.ALARM_SERVICE;
import static sooyer.developer.com.palabrasandwords.Common.Common.showTraslate;
import static sooyer.developer.com.palabrasandwords.Resources.Resources.listLearning;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private Context nCtx;
    private List<Board> BoardList;
    private List<Board> BoardListFull;
    SoundPool sp;
    int audio [ ] = {};
    int sonido;
    private EditText txtpalabra , txttraduccion;
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
        holder.name.setTextColor(nCtx.getResources().getColor(board.getColortexto()));
        holder.name.setText(board.getPalabra().toUpperCase());

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = 60;
        if (showTraslate != false){
            //holder.traduccion.setGravity(Gravity.CENTER);
            holder.traduccion.setText(board.getTraduccion().toLowerCase());
            holder.traduccion.setVisibility(View.VISIBLE);
            holder.name.setTextSize(20);
            int hd = (int) holder.name.getTextSize();
        }else{
            holder.traduccion.setVisibility(View.GONE);
            holder.name.setTextSize(24);
           /* LinearLayout.LayoutParams lp = new
                    LinearLayout.LayoutParams(width,height);
            lp.setMargins(0,0,50,0);

            holder.name.setLayoutParams(lp);
            //holder.name.setGravity(Gravity.CENTER);
*/

        }

        holder.fondo.setImageDrawable(nCtx.getResources().getDrawable(board.getColor()));

        final LayoutInflater inflater = LayoutInflater.from(nCtx);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {


                    final AlertDialog.Builder mbuilder = new AlertDialog.Builder(nCtx);
                    View vista = inflater.inflate(R.layout.dialog_board,null);
                    mbuilder.setView(vista);
                    final AlertDialog dialog = mbuilder.create();
                    dialog.show();

                    TextView txtp =  vista.findViewById(R.id.txtpalabra_board);
                    TextView txtt =  vista.findViewById(R.id.txttraduccion_board);
                    TextView txte =  vista.findViewById(R.id.txtejemplo_board);
                    TextView txte2 =  vista.findViewById(R.id.txtejemplo_board2);
                    TextView txtpastap2 =  vista.findViewById(R.id.txtsimplepast2);
                    TextView txtpastpa =  vista.findViewById(R.id.txtsimplepast);
                    ImageView img = vista.findViewById(R.id.dialog_back);
                    final Switch  isLearning = vista.findViewById(R.id.isLearning);
                    Button btn = vista.findViewById(R.id.btn_sound);
                    Button btnCloseAlert = vista.findViewById(R.id.close_alert);
                    txtpastpa.setText(board.getPastParticple().toUpperCase());
                    txtpastpa.setTextColor(nCtx.getResources().getColor(board.getColortexto()));
                    txte.setTextColor(nCtx.getResources().getColor(board.getColortexto()));
                    txte2.setText(board.getSimplePastP());
                    txtpastap2.setText(board.getPastParticpleP());
                    txte2.setTextColor(nCtx.getResources().getColor(board.getColortexto()));
                    txtpastap2.setTextColor(nCtx.getResources().getColor(board.getColortexto()));
                    txtp.setText(board.getPalabra().toUpperCase());
                    txte.setText(board.getSimplePast().toUpperCase());
                    txtp.setTextColor(nCtx.getResources().getColor(board.getColortexto()));
                    txtt.setText(board.getTraduccion().toUpperCase());
                    isLearning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isLearning.isChecked()){
                                listLearning.add(new Verbs(board.getPalabra(),board.getTraduccion()));
                                Toast.makeText(nCtx, listLearning.get(0).getWord(), Toast.LENGTH_SHORT).show();

                                Toast.makeText(nCtx, "Send", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(nCtx, RemindNotificacion.class);
                                PendingIntent pendingIntent = PendingIntent.getBroadcast(nCtx,0,intent,0);
                                AlarmManager alarmManager = (AlarmManager) nCtx.getSystemService(ALARM_SERVICE);


                                long timeAtClick = System.currentTimeMillis();
                                long tenSeconds = 1000*10;
                                alarmManager.setExact(
                                        AlarmManager.RTC_WAKEUP
                                        ,timeAtClick+tenSeconds,
                                        pendingIntent
                                );

                            }else{
                                Toast.makeText(nCtx, "Apagado", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    img.setImageDrawable(nCtx.getResources().getDrawable(board.getColor()));

                    AudioAttributes audioAttributes = new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build();

                    sp = new SoundPool.Builder()
                            .setMaxStreams(150)
                            .build();

                    sonido = sp.load(nCtx,board.getAudio(),1);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(nCtx, "gig", Toast.LENGTH_SHORT).show();
                            sp.play(sonido,1,1,2,0,1);

                        }
                    });

                    btnCloseAlert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
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
    //Toast.makeText(nCtx, "clicked"+position, Toast.LENGTH_SHORT).show();

    @Override
    public int getItemCount() {
        return BoardList.size();

    }
    public void filterList(ArrayList<Board> filter){
        BoardList= filter;
        notifyDataSetChanged();

    }
    public class BoardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView traduccion;
        ImageView fondo;
        ItemClickListener itemClickListener;
        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
        public BoardViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_board);
            traduccion = itemView.findViewById(R.id.traduccion);
            fondo = itemView.findViewById(R.id.background_board);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
    public void updateList(List<Board> newList){
        BoardList = newList;
        notifyDataSetChanged();
    }
}


class Remind extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent resultIntent = new Intent(context, HomeActivity.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify")
                .setSmallIcon(R.drawable.view)
                .setContentTitle("Yes it can")
                .setContentText("Hey")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify(200,builder.build());
    }
}

