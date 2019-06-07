package sooyer.developer.com.palabrasandwords.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sooyer.developer.com.palabrasandwords.Activities.BoardActivity;
import sooyer.developer.com.palabrasandwords.Activities.Word_Activity;
import sooyer.developer.com.palabrasandwords.Interface.ItemClickListener;
import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.ViewHolders.*;
import sooyer.developer.com.palabrasandwords.R;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>  {
    private Context nCtx;
    private List<Category> categoryList;
    
    int sounds[ ]= {R.raw.be,R.raw.beat,R.raw.become,R.raw.begin,R.raw.bend
            ,R.raw.bet,R.raw.bite,R.raw.breakk,R.raw.bring,R.raw.bring,R.raw.build

    };
    int color[] = {R.drawable.gradienterojo_opaco,R.drawable.gradientazul_opaco,R.drawable.gradientgris_opaco,R.drawable.gradienteverde_opaco,R.drawable.gradientcgris};
    int coloText[] ={R.color.colorRosaOpaco,R.color.colorAzulOpaco,R.color.colorMoradoOpaco,R.color.colorVerdeOpaco,R.color.colorAZpaco};
    ItemClickListener itemClickListener;


    List<Board> lista;

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

                switch (position){
                    case 0:
                        nCtx.startActivity(new Intent(nCtx, Word_Activity.class));
                        break;
                    case 1:
                        irregularVerbs();
                        gotoBoard(nCtx,lista,"IRREGULAR VERBS");
                        break;
                    case 2:
                        Home();
                        gotoBoard(nCtx,lista,"HOME");
                        break;
                    case 3:
                        dining();
                        gotoBoard(nCtx,lista,"DINING ROOM");
                    case 4:
                        KITCHEN();
                        gotoBoard(nCtx,lista,"KITCHEN");
                    default:
                        Toast.makeText(nCtx, "Noppp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void irregularVerbs() {
        lista = new ArrayList<>();

        lista.add(new Board("BE",    "SER/ESTAR/EXISTIR", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Board("BEAT",  "BATIR/RITMO/GOLPEAR", "I KNOW", sounds[1], color[0],      coloText[0]));
        lista.add(new Board("BECOME","VOLVERSE/CONVERTIRSE", "I KNOW", sounds[2], color[0],     coloText[0]));
        lista.add(new Board("BEGIN", "EMPEZAR/COMENZAR", "I KNOW", sounds[3], color[0],         coloText[0]));
        lista.add(new Board("BEND",  "CURVA/DOBLAR", "I KNOW", sounds[4], color[0],             coloText[0]));
        lista.add(new Board("BET",   "APUESTA/APOSTAR", "I KNOW", sounds[5], color[0],          coloText[0]));
        lista.add(new Board("BITE",  "MORDEDURA/BOCADO", "I KNOW", sounds[6], color[1], coloText[1]));
        lista.add(new Board("BLOW",  "SOPLO/VOLAR/SOPLAR", "I KNOW", sounds[7], color[1], coloText[1]));
        lista.add(new Board("BREAK", "DESCANSO/ROMPER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("BRING", "TRAER/LLEVAR/PROVOCAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("BUILD", "CONSTRUIR/EDIFICAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("BURST", "RAFAGA/EXPLOSION", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("BUY",   "COMPRAR/SOBORNAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("CAN",   "PODER/SABER", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("CATCH", "CAPTURA/COGER/ATRAPAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("CHOOSE","ESCOGER/ELEGIR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("COME",  "VEN/VENIR/LLEGAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("COST",  "COSTO/COSTAR/PRECIO", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("CUT",   "CORTAR/REDUCIR/RECORTAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("DEAL",  "ACUERDO/NEGOCIAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("DIG",   "CAVAR/EXCAVAR/REMOVER", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("DO",    "HACER/REALIZAR/ACTUAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("DRAW",  "DIBUJAR/SACAR/TRAZAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("DRINK", "DRINK/TOMAR/EMPINAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("EAT",   "COMER/CONSUMIR/DEVORAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("FALL",  "CAER/BAJAR/OTOÑO", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("FEED",  "ALIMENTAR/DAR DE COMER", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("FEEL",  "SENTIR/SENSACION/PALPAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("FIGHT", "LUCHAR/COMBATIR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("FIND",  "ENCONTRAR/HALLAR", "I KNOW", sounds[0], color[4], coloText[4]));

        lista.add(new Board("FLY",   "VOLAR/HUIR/PILOTEAR", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Board("FORGET","OLVIDAR/DEJAR", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Board("FORGIVE","PERDONAR/DISCULPAR", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Board("FREEZE","CONGELAR/CONGELARSE", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Board("GET",   "OBTENER/CONSEGUIR", "I KNOW", sounds[0], color[0],    coloText[0]));
        lista.add(new Board("GIVE",  "DAR/OFRECER/PRESTAR", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Board("GO",    "IR/PASAR/SALIR", "I KNOW", sounds[0], color[1],       coloText[1]));
        lista.add(new Board("GROW",  "CRECER/CULTIVAR/CRIAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("HANG",  "COLGAR/MANIR", "", sounds[0], color[1], coloText[1]));
        lista.add(new Board("HAVE",  "TENER/HABER/POSEER", "I KNOW", sounds[0], color[1],    coloText[1]));
        lista.add(new Board("HEAR",  "OIR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("HIDE",  "ESCONDER/DISIMULAR", "I KNOW", sounds[0], color[1],   coloText[1]));
        lista.add(new Board("HIT",   "GOLPEAR/GOLPE/IMPACTO", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("HOLD",  "SONTENER/MANTENER", "I KNOW", sounds[0], color[2],        coloText[2]));
        lista.add(new Board("HURT",  "HERIR/DAÑO/LASTIMAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("KEEP",  "MANTENER/TENER/GUARDAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("KNOW",  "SABER/CONOCER", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("LAY",   "TUMBAR A", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("LEAD",  "DIRIGIR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("LEAVE", "SALIR/DEJAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("LEND",  "PRESTAR/DAR/EMPRESTAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("LET",   "DEJAR/ALQUILER/PERMITIR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("LIE",   "MENTIR/EMBUSTE", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("LOSE",  "PERDER/SERVENCIDO", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("MAKE",  "HACER/EFECTUAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("MEAN",  "SIGNIFICAR/SUPONER", "I KNOW", sounds[0], color[4], coloText[4]));


        //OTHER V_V
        lista.add(new Board("MEET", "CONOCER/REUNIRSE", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("MUST", "DEBER/TENER QUE", "", sounds[0], color[4], coloText[4]));
        lista.add(new Board("PAY", "PAGAR/ABONAR/SALARIO", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("PUT", "PONER/COLOCAR/DEJAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("READ", "LEER/INTERPRETAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("RIDE", "MONTAR/PASEO/VIAJAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("RING", "SONAR/TOCAR/LLAMAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("RISE", "ASCENDER/SUBIR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("RUN", "CORRER/EJECUTAR", "", sounds[0], color[0], coloText[0]));
        lista.add(new Board("SAY", "DECIR/AFIRMAR/EXPRESAR", "I KNOW", sounds[0], color[0], coloText[0]));

        lista.add(new Board("SEE", "VER/MIRAR/CONSULTAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("SELL", "VENDER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("SEND", "ENVIAR/MANDAR/EMITIR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("SET", "ESTABLECER/CONJUNTO", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("SHAKE", "SACUDIR/AGITAR/MENEAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("SHINE", "BRILLAR/RESPLANDECER/LUCIR", "I KNOW", sounds[0], color[1], coloText[1]));

        lista.add(new Board("SHOOT", "DISPARAR/TIRAR/LANZAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("SHOW", "MOSTRAR/ESPECTACULO", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("SHRINK", "ENCOGER/CONTRAER", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("SHUT", "CERRAR/CERRARSE", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("SING", "CANTAR/SILBAR/ZUMBAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("SINK", "HUNDIR/CAER/HUNDIRSE", "I KNOW", sounds[0], color[2], coloText[2]));

        lista.add(new Board("SIT", "SENTARSE/QUEDARSE/POSAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("SLEEP", "DORMIR/ENTUMECERSE", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("SLIDE", "DESLIZARSE/DESLIZAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("SPEAK", "HABLAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("SPEND", "GASTAR/AGOTAR/PASAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("SPLIT", "DIVIDIRSE/PARTIR/DIVISION", "I KNOW", sounds[0], color[3], coloText[3]));

        lista.add(new Board("SPREAD", "DIFUNDIR/PROPAGAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("STAND", "ESTAR/AGUANTAR/TOLERAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("STEAL", "ROBAR/HURTAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("STICK", "PEGARSE/PEGAR/ADHERIRSE", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("SWEAR", "JURAR/MALDECIR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Board("SWIM", "NADAR", "I KNOW", sounds[0], color[4], coloText[4]));

        lista.add(new Board("TAKE", "TOMAR/LLEVAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("TEACH", "ENSEÑAR/DAR/SERPROFESOR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("TEAR", "RASGAR/ARRANCAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("TELL", "CONTAR/DECIR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("THINK", "PENSAR/CREER/CONSIDERAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Board("THROW", "LANZAR/TIRAR/ARROJAR", "I KNOW", sounds[0], color[0], coloText[0]));

        lista.add(new Board("UNDERSTAND", "ENTENDER/COMPRENDER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("WAKE", "DESPERTAR/VELAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("WEAR", "USAR/PONSERSE/VESTIR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("WIN", "GANAR/ALCANZAR/VENCER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("WRITE", "ESCRIBIR/COMPONER", "I KNOW", sounds[0], color[1], coloText[1]));
    }
        
    public void Home(){
        lista = new ArrayList<>();
        lista.add(new Board("room",    "habitación", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Board("balcony",  "balcony", "I KNOW", sounds[0], color[0],      coloText[0]));
        lista.add(new Board("bathroom","baño", "I KNOW", sounds[0], color[0],     coloText[0]));
        lista.add(new Board("bedroom", "dormitorio", "I KNOW", sounds[0], color[0],         coloText[0]));
        lista.add(new Board("dining room",  "comedor", "I KNOW", sounds[0], color[0],             coloText[0]));
        lista.add(new Board("living room",   "salón", "I KNOW", sounds[0], color[0],          coloText[0]));
        lista.add(new Board("sitting room",  "sala de estar", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("garage",  "garaje", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("kitchen", "cocina", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("basement", "sótano", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("cellar", "bodega", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("attic", "ático", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("study",   "estudio", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("toilet",   "toilette", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("door", "puerta", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("doorbell","timbre", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("doormat",  "felpudo", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("letter box",  "buzón", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("window",   "ventana", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("roof",  "techo", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("chimney",   "chimenea", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("staircase/stairs",    "escalera", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("flat (GB)",  "departamento", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Board("apartment (US)", "departamento", "I KNOW", sounds[0], color[3], coloText[3]));
    }
    public void dining(){
        lista = new ArrayList<>();
        lista.add(new Board("dining room","comedor", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Board("living room",  "salón", "I KNOW", sounds[0], color[0],      coloText[0]));
        lista.add(new Board("table","mesa", "I KNOW", sounds[0], color[0],     coloText[0]));
        lista.add(new Board("chair", "silla", "I KNOW", sounds[0], color[0],         coloText[0]));
        lista.add(new Board("armchair",  "sillón", "I KNOW", sounds[0], color[0],             coloText[0]));
        lista.add(new Board("sofa / settee (GB)",   "sofá", "I KNOW", sounds[0], color[0],          coloText[0]));
        lista.add(new Board("floor",  "piso", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("ceiling",  "techo", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("rug", "alfombra", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("carpet", "alfombra fija", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("fireplace", "chimenea", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("radiator", "radiador", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("lamp",   "lámpara", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("light",   "luz", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("curtain", "cortina", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("wall","pared", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("wallpaper",  "papel de pared", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("television",  "televisor", "I KNOW", sounds[0], color[2], coloText[2]));
    }



    public void KITCHEN(){
        lista = new ArrayList<>();
        lista.add(new Board("kitchen","CONINA", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Board("fridge",  "heladera", "I KNOW", sounds[0], color[0],      coloText[0]));
        lista.add(new Board("oven","horno", "I KNOW", sounds[0], color[0],     coloText[0]));
        lista.add(new Board("microwave oven", "horno de microondas", "I KNOW", sounds[0], color[0],         coloText[0]));
        lista.add(new Board("dishwasher",  "lavavajillas", "I KNOW", sounds[0], color[0],             coloText[0]));
        lista.add(new Board("washing machine","lavarropas", "I KNOW", sounds[0], color[0],          coloText[0]));
        lista.add(new Board("ironing board",  "tabla de planchar", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("toaster",  "tostadora", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("liquidizer(GB)", "licuadora", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("blender (US)", "licuadora", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("mixer", "batidora", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("broom", "escoba", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("sink",   "LAVAMANOS", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("tap",   "GRIFO", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("waste bin", "cortina", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("worktop","MESADA", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("tea towel",  "paño, repasador", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("frying pan",  "sartén", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("saucepan","cacerola", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Board("pressure cooker",  "olla a presión", "I KNOW", sounds[0], color[0],      coloText[0]));
        lista.add(new Board("kettle","hervidor, pava", "I KNOW", sounds[0], color[0],     coloText[0]));
        lista.add(new Board("bowl", "bol", "I KNOW", sounds[0], color[0],         coloText[0]));
        lista.add(new Board("tin opener", "abrelatas", "I KNOW", sounds[0], color[0],         coloText[0]));
        lista.add(new Board("corkscrew",  "sacacorchos", "I KNOW", sounds[0], color[0],             coloText[0]));
        lista.add(new Board("FORK","tenedor", "I KNOW", sounds[0], color[0],          coloText[0]));
        lista.add(new Board("knife", "cuchillo", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("spoon", "cuchara", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("teaspoon", "cucharita", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("cutlery drawer", "cajón de los cubiertos", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Board("cup",   "taza", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("glass",   "vaso", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("saucer", "plato", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("jug","jarra", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("coffeepot",  "jarra para café", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Board("coffee maker",  "cafetera", "I KNOW", sounds[0], color[2], coloText[2]));
    }



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
