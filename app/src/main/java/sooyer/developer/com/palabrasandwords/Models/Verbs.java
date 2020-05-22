package sooyer.developer.com.palabrasandwords.Models;

import java.util.ArrayList;

/**
 * Created by Uriel on 14/10/2019.
 */

public class Verbs {
    private String palabra;
    private String traduccion;
    private String simple;
    private String participic;
    private int audio;
    private int color;
    private int colortexto;


    public Verbs(String palabra, String traduccion, String simple, String participic, int audio, int color, int colortexto) {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.simple = simple;
        this.participic = participic;
        this.audio = audio;
        this.color = color;
        this.colortexto = colortexto;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public String getParticipic() {
        return participic;
    }

    public void setParticipic(String participic) {
        this.participic = participic;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColortexto() {
        return colortexto;
    }

    public void setColortexto(int colortexto) {
        this.colortexto = colortexto;
    }
}
/*
    public void irregularVerbs() {

        lista = new ArrayList<>();
        lista.add(new Verbs("BE",    "SER/ESTAR/EXISTIR", "WAS/WERE"," BEEN", sounds[0], color[0],        coloText[0]));
        lista.add(new Verbs("BEAT",  "BATIR/RITMO/GOLPEAR", "BEAT","BEATEN", sounds[1], color[0],      coloText[0]));
        lista.add(new Verbs("BECOME","VOLVERSE/CONVERTIRSE", "BECAME","BECOME", sounds[2], color[0],     coloText[0]));
        lista.add(new Verbs("BEGIN", "EMPEZAR/COMENZAR", "BEGAN","BEGUN", sounds[3], color[0],         coloText[0]));
        lista.add(new Verbs("BEND",  "CURVA/DOBLAR", "","", sounds[4], color[0],             coloText[0]));
        lista.add(new Verbs("BET",   "APUESTA/APOSTAR", "BET","BET", sounds[5], color[0],          coloText[0]));

        lista.add(new Verbs("BITE",  "MORDEDURA/BOCADO", "I KNOW", sounds[6], color[1], coloText[1]));
        lista.add(new Verbs("BLOW",  "SOPLO/VOLAR/SOPLAR", "I KNOW", sounds[7], color[1], coloText[1]));
        lista.add(new Verbs("BREAK", "DESCANSO/ROMPER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("BRING", "TRAER/LLEVAR/PROVOCAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("BUILD", "CONSTRUIR/EDIFICAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("BURST", "RAFAGA/EXPLOSION", "I KNOW", sounds[0], color[1], coloText[1]));

        lista.add(new Verbs("BUY",   "COMPRAR/SOBORNAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("CAN",   "PODER/SABER", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("CATCH", "CAPTURA/COGER/ATRAPAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("CHOOSE","ESCOGER/ELEGIR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("COME",  "VEN/VENIR/LLEGAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("COST",  "COSTO/COSTAR/PRECIO", "I KNOW", sounds[0], color[2], coloText[2]));

        lista.add(new Verbs("CUT",   "CORTAR/REDUCIR/RECORTAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("DEAL",  "ACUERDO/NEGOCIAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("DIG",   "CAVAR/EXCAVAR/REMOVER", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("DO",    "HACER/REALIZAR/ACTUAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("DRAW",  "DIBUJAR/SACAR/TRAZAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("DRINK", "DRINK/TOMAR/EMPINAR", "I KNOW", sounds[0], color[3], coloText[3]));

        lista.add(new Verbs("EAT",   "COMER/CONSUMIR/DEVORAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("FALL",  "CAER/BAJAR/OTOÑO", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("FEED",  "ALIMENTAR/DAR DE COMER", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("FEEL",  "SENTIR/SENSACION/PALPAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("FIGHT", "LUCHAR/COMBATIR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("FIND",  "ENCONTRAR/HALLAR", "I KNOW", sounds[0], color[4], coloText[4]));

        lista.add(new Verbs("FLY",   "VOLAR/HUIR/PILOTEAR", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Verbs("FORGET","OLVIDAR/DEJAR", "I KNOW", sounds[0], color[0],        coloText[0]));
        lista.add(new Verbs("FORGIVE","PERDONAR/DISCULPAR", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Verbs("FREEZE","CONGELAR/CONGELARSE", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Verbs("GET",   "OBTENER/CONSEGUIR", "I KNOW", sounds[0], color[0],    coloText[0]));
        lista.add(new Verbs("IS TIME OF TEST",  "GO TO TEST", "I KNOW", sounds[6], color[0], coloText[0]));
        lista.add(new Verbs("GIVE",  "DAR/OFRECER/PRESTAR", "I KNOW", sounds[0], color[0],  coloText[0]));
        lista.add(new Verbs("GO",    "IR/PASAR/SALIR", "I KNOW", sounds[0], color[1],       coloText[1]));
        lista.add(new Verbs("GROW",  "CRECER/CULTIVAR/CRIAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("HANG",  "COLGAR/MANIR", "", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("HAVE",  "TENER/HABER/POSEER", "I KNOW", sounds[0], color[1],    coloText[1]));
        lista.add(new Verbs("HEAR",  "OIR", "I KNOW", sounds[0], color[1], coloText[1]));

        lista.add(new Verbs("HIDE",  "ESCONDER/DISIMULAR", "I KNOW", sounds[0], color[1],   coloText[1]));
        lista.add(new Verbs("HIT",   "GOLPEAR/GOLPE/IMPACTO", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("HOLD",  "SONTENER/MANTENER", "I KNOW", sounds[0], color[2],        coloText[2]));
        lista.add(new Verbs("HURT",  "HERIR/DAÑO/LASTIMAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("KEEP",  "MANTENER/TENER/GUARDAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("KNOW",  "SABER/CONOCER", "I KNOW", sounds[0], color[2], coloText[2]));

        lista.add(new Verbs("LAY",   "TUMBAR A", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("LEAD",  "DIRIGIR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("LEAVE", "SALIR/DEJAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("LEND",  "PRESTAR/DAR/EMPRESTAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("LET",   "DEJAR/ALQUILER/PERMITIR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("LIE",   "MENTIR/EMBUSTE", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("LOSE",  "PERDER/SERVENCIDO", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("MAKE",  "HACER/EFECTUAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("MEAN",  "SIGNIFICAR/SUPONER", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("MEET", "CONOCER/REUNIRSE", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("MUST", "DEBER/TENER QUE", "", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("PAY", "PAGAR/ABONAR/SALARIO", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("PUT", "PONER/COLOCAR/DEJAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("READ", "LEER/INTERPRETAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("RIDE", "MONTAR/PASEO/VIAJAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("RING", "SONAR/TOCAR/LLAMAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("RISE", "ASCENDER/SUBIR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("RUN", "CORRER/EJECUTAR", "", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("SAY", "DECIR/AFIRMAR/EXPRESAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("SEE", "VER/MIRAR/CONSULTAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("SELL", "VENDER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("SEND", "ENVIAR/MANDAR/EMITIR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("SET", "ESTABLECER/CONJUNTO", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("SHAKE", "SACUDIR/AGITAR/MENEAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("SHINE", "BRILLAR/RESPLANDECER/LUCIR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("SHOOT", "DISPARAR/TIRAR/LANZAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("SHOW", "MOSTRAR/ESPECTACULO", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("SHRINK", "ENCOGER/CONTRAER", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("SHUT", "CERRAR/CERRARSE", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("SING", "CANTAR/SILBAR/ZUMBAR", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("SINK", "HUNDIR/CAER/HUNDIRSE", "I KNOW", sounds[0], color[2], coloText[2]));
        lista.add(new Verbs("SIT", "SENTARSE/QUEDARSE/POSAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("SLEEP", "DORMIR/ENTUMECERSE", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("SLIDE", "DESLIZARSE/DESLIZAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("SPEAK", "HABLAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("SPEND", "GASTAR/AGOTAR/PASAR", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("SPLIT", "DIVIDIRSE/PARTIR/DIVISION", "I KNOW", sounds[0], color[3], coloText[3]));
        lista.add(new Verbs("SPREAD", "DIFUNDIR/PROPAGAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("STAND", "ESTAR/AGUANTAR/TOLERAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("STEAL", "ROBAR/HURTAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("STICK", "PEGARSE/PEGAR/ADHERIRSE", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("SWEAR", "JURAR/MALDECIR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("SWIM", "NADAR", "I KNOW", sounds[0], color[4], coloText[4]));
        lista.add(new Verbs("TAKE", "TOMAR/LLEVAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("TEACH", "ENSEÑAR/DAR/SERPROFESOR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("TEAR", "RASGAR/ARRANCAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("TELL", "CONTAR/DECIR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("THINK", "PENSAR/CREER/CONSIDERAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("THROW", "LANZAR/TIRAR/ARROJAR", "I KNOW", sounds[0], color[0], coloText[0]));
        lista.add(new Verbs("UNDERSTAND", "ENTENDER/COMPRENDER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("WAKE", "DESPERTAR/VELAR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("WEAR", "USAR/PONSERSE/VESTIR", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("WIN", "GANAR/ALCANZAR/VENCER", "I KNOW", sounds[0], color[1], coloText[1]));
        lista.add(new Verbs("WRITE", "ESCRIBIR/COMPONER", "I KNOW", sounds[0], color[1], coloText[1]));
    }*/