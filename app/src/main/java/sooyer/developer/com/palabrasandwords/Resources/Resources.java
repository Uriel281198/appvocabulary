package sooyer.developer.com.palabrasandwords.Resources;

import java.util.ArrayList;
import java.util.List;

import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.R;

public class Resources {
    public static int soundsGlobal[ ]= {
            R.raw.arise,R.raw.awoke, R.raw.be,R.raw.bear,R.raw.beat,R.raw.become,
            R.raw.begin,R.raw.bend,R.raw.bet,R.raw.bid,R.raw.bind,R.raw.bite,
            R.raw.bleed,R.raw.bless,R.raw.blow,R.raw.breakk,R.raw.bring,R.raw.build,
            R.raw.burn,R.raw.burst,R.raw.buy,R.raw.can,R.raw.cast,R.raw.cath,
            R.raw.choose,R.raw.clap,R.raw.cling,R.raw.clothe,R.raw.come,R.raw.cost,
            R.raw.creep,R.raw.cut,R.raw.deal,R.raw.dig,R.raw.dive,R.raw.doo,
            R.raw.draw,R.raw.dream,R.raw.drink,R.raw.drive,R.raw.eat,R.raw.fall,
            R.raw.feed,R.raw.feel,R.raw.fight,R.raw.find,R.raw.fit,R.raw.flee,
            R.raw.fling,R.raw.fly,R.raw.forbid,R.raw.forecast,R.raw.foresee,R.raw.foretell,
    };

    public static int color[] = {R.drawable.gradienterojo_opaco,R.drawable.gradientazul_opaco,R.drawable.gradientgris_opaco,R.drawable.gradienteverde_opaco,R.drawable.gradientcgris};
    public static int coloText[] ={R.color.colorRosaOpaco,R.color.colorAzulOpaco,R.color.colorMoradoOpaco,R.color.colorVerdeOpaco,R.color.colorAZpaco};


    public static List getIrregular(){

        List<Board> lista = new ArrayList<>();
        lista.add(new Board("arise"	,"levantarse/surgir","arose","arisen","(aróus)","(arísen)",soundsGlobal[0],color[0],coloText[0]));
        lista.add(new Board("awake"	,"despertarse/despertar","awoke, awaked","awoken, awaked","(awóuk)","(awóuken)",soundsGlobal[1],color[0],coloText[0]));
        lista.add(new Board("BE",    "SER/ESTAR/EXISTIR", "was,were","been","(was,were)","(been)", soundsGlobal[2],color[0],coloText[0]));
        lista.add(new Board("bear",  "aguantar/soportar", "bore","born","(bor)","(born)", soundsGlobal[3], color[0],coloText[0]));
        lista.add(new Board("BEAT",  "BATIR/RITMO/GOLPEAR", "beat","beaten,beat","(bíit)","(bíiten)", soundsGlobal[4], color[0],      coloText[0]));
        lista.add(new Board("BECOME","VOLVERSE/CONVERTIRSE", "became", "become","(bikéim)","(bikám)",soundsGlobal[5],  color[0],      coloText[0]));

        lista.add(new Board("BEGIN", "EMPEZAR/COMENZAR", "began","begun","(bigáan)","(bigán)",soundsGlobal[6],color[1],     coloText[1]));
        lista.add(new Board("BEND",  "doblar/torcer", "bent", "bent","(bent)","(bent)",soundsGlobal[7], color[1],     coloText[1]));
        lista.add(new Board("BET",   "APUESTA/APOSTAR", "bet,betted","bet,betted","(bet)","(bet)", soundsGlobal[8], color[1],     coloText[1]));
        lista.add(new Board("bid",   "ofrecer/pujar", "bid","bid","(bid)","(bid)", soundsGlobal[9], color[1],     coloText[1]));
        lista.add(new Board("bind",   "atar/unir", "bound","bound","(báund)","(báund)", soundsGlobal[10], color[1],     coloText[1]));
        lista.add(new Board("BITE",  "morder/picar", "bit","bitten", "(bit)","(bíten)",soundsGlobal[11], color[1], coloText[1]));

        lista.add(new Board("bleed",  "sangrar", "bled","bled","(bled)","(bled)", soundsGlobal[12], color[2], coloText[2]));
        lista.add(new Board("bless",  "bendecir", "blessed, blest","blessed, blest","(bless)","(bless)", soundsGlobal[13], color[2], coloText[2]));
        lista.add(new Board("BLOW",  "SOPLO/VOLAR/SOPLAR", "blew","blown","(blú)","(blown)", soundsGlobal[14],color[2], coloText[2]));
        lista.add(new Board("BREAK", "DESCANSO/ROMPER", "broke","broken", "(bróuk)","(bróuken)",soundsGlobal[15], color[2], coloText[2]));
        lista.add(new Board("BRING", "TRAER/LLEVAR/PROVOCAR", "brought","brought", "(brot)","(brot)",soundsGlobal[16],color[2], coloText[2]));
        lista.add(new Board("BUILD", "CONSTRUIR/EDIFICAR", "built","built","(bilt)","(bilt)", soundsGlobal[17],color[2], coloText[2]));


        lista.add(new Board("burn", "quemar", "burnt","burnt","(bernt)","(bernt)", soundsGlobal[18],color[3], coloText[3]));
        lista.add(new Board("BURST", "REVENTAR/EXPLOTAR", "burst","burst", "(berst)","(berst)",soundsGlobal[19], color[3], coloText[3]));
        lista.add(new Board("BUY",   "COMPRAR/SOBORNAR", "bought","bought","(bot)","(bot)", soundsGlobal[20], color[3], coloText[3]));
        lista.add(new Board("CAN",   "PODER/SABER", "could","(been Participle)","(kud)","(benn participle)", soundsGlobal[21],color[3], coloText[3]));
        lista.add(new Board("cast",   "echar/emitir", "cast","cast","(kast)","(kast)", soundsGlobal[22], color[3], coloText[3]));
        lista.add(new Board("CATCH", "CAPTURA/COGER/ATRAPAR", "caught","caught","(kot)","(kot)", soundsGlobal[23], color[3], coloText[3]));

        lista.add(new Board("CHOOSE","ESCOGER/ELEGIR", "chose","chosen","(chóus)","(chóusen)", soundsGlobal[24], color[4], coloText[4]));
        lista.add(new Board("CLAP",  "APLAUDIR", "clung","clung","(klapt)","(klapt)", soundsGlobal[25],  color[4], coloText[4]));
        lista.add(new Board("CLING",  "agarrarse/aferrarse", "clung","clung","(klang)","(klang)", soundsGlobal[26],  color[4], coloText[4]));
        lista.add(new Board("clothe",  "vestir/revestir", "clad","clad","(klad)","(klad)", soundsGlobal[27],  color[4], coloText[4]));
        lista.add(new Board("COME",  "VEN/VENIR/LLEGAR", "came","come","(kéim)","(kam)", soundsGlobal[28],  color[4], coloText[4]));
        lista.add(new Board("COST",  "COSTO/COSTAR/PRECIO", "cost","cost","(kost)","(kost)", soundsGlobal[29],  color[4], coloText[4]));

        lista.add(new Board("creep",   "gatear/arrastrarse", "crept","crept","(krept)","(krept)", soundsGlobal[30], color[0], coloText[0]));
        lista.add(new Board("CUT",   "CORTAR/REDUCIR/RECORTAR", "CUT","CUT","(kat)","(kat)", soundsGlobal[31], color[0], coloText[0]));
        lista.add(new Board("DEAL",  "ACUERDO/NEGOCIAR", "dealt","dealt","(delt)","(delt)", soundsGlobal[32],   color[0], coloText[0]));
        lista.add(new Board("DIG",   "CAVAR/EXCAVAR/REMOVER", "dug","dug", "(dag)","(dag)",soundsGlobal[33],  color[0], coloText[0]));
        lista.add(new Board("DIVE",   "zambullirse/sumergirse", "dove","dove", "(dóuv)","(dóuv)",soundsGlobal[34],  color[0], coloText[0]));
        lista.add(new Board("DO",    "HACER/REALIZAR/ACTUAR", "did","done","(did)","(dan)", soundsGlobal[35],   color[0], coloText[0]));

        lista.add(new Board("DRAW",  "DIBUJAR/SACAR/sacar", "drew","drawn","(dru)","(dróon)", soundsGlobal[36], color[1], coloText[1]));
        lista.add(new Board("dream", "SOÑAR", "dreamt","dreamt","(dremt)","(dremt)", soundsGlobal[37], color[1], coloText[1]));
        lista.add(new Board("DRINK", "BEBER/TOMAR/EMPINAR", "drank","drunk","(draank)","(drank)", soundsGlobal[38],color[1], coloText[1]));
        lista.add(new Board("DRIVE", "conducir/ ir en coche", "drove","driven","(dróuv)","(dríven)", soundsGlobal[39], color[1], coloText[1]));
        lista.add(new Board("EAT",   "COMER/CONSUMIR/DEVORAR", "ate","eaten", "(éit)","(íiten)",soundsGlobal[40], color[1], coloText[1]));
        lista.add(new Board("FALL",  "CAER/BAJAR/OTOÑO", "fell","fallen", "(fel)","(fólen)",soundsGlobal[41], color[1], coloText[1]));

        lista.add(new Board("FEED",  "ALIMENTAR/DAR DE COMER", "fed","fed","(fed)","(fed)", soundsGlobal[42], color[2], coloText[2]));
        lista.add(new Board("FEEL",  "SENTIR/SENSACION/PALPAR", "felt","felt","(felt)","(felt)", soundsGlobal[43], color[2], coloText[2]));
        lista.add(new Board("FIGHT", "LUCHAR/COMBATIR", "fought","fought","(fot)","(fot)", soundsGlobal[44],  color[2], coloText[2]));
        lista.add(new Board("FIND",  "ENCONTRAR/HALLAR", "found","found","(fáund)","(fáund)", soundsGlobal[45],  color[2], coloText[2]));
        lista.add(new Board("FIT",  "encajar/quedar bien", "fit","fit","(fit)","(fit)", soundsGlobal[46],color[2], coloText[2]));
        lista.add(new Board("FLEE",  "huir/huir de", "fled","fled","(fled)","(fled)", soundsGlobal[47], color[2], coloText[2]));

        lista.add(new Board("fling",   "echar/arrojar", "flung","flung","(flang)","(flang)", soundsGlobal[48], color[3],  coloText[3]));
        lista.add(new Board("FLY",   "VOLAR/HUIR/PILOTEAR", "flew","flown","(flu)","(flóun)", soundsGlobal[49], color[3],  coloText[3]));
        lista.add(new Board("forbid",   "prohibir", "forbade","forbidden","(forbéid)","(forbíden)", soundsGlobal[50], color[3],  coloText[3]));
        lista.add(new Board("forecast","pronosticar/preveer", "forecast","forecast","(forkást)","(forkást)", soundsGlobal[51], color[3],  coloText[3]));
        lista.add(new Board("foresee","preveer", "foresaw","foreseen","(forsó)","(forsó)", soundsGlobal[52], color[3],  coloText[3]));
        lista.add(new Board("foretell","predecir", "foretold","foretold","(fortóuld)","(fortóuld)", soundsGlobal[53], color[3],  coloText[3]));








        /*
        lista.add(new Board("BITE",  "MORDEDURA/BOCADO", "I know","", soundsGlobal[6], color[1], coloText[1]));
        lista.add(new Board("BLOW",  "SOPLO/VOLAR/SOPLAR", "I know","", soundsGlobal[7], color[1], coloText[1]));
        lista.add(new Board("BREAK", "DESCANSO/ROMPER", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("BRING", "TRAER/LLEVAR/PROVOCAR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("BUILD", "CONSTRUIR/EDIFICAR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("BURST", "RAFAGA/EXPLOSION", "I know","", soundsGlobal[0], color[1], coloText[1]));

        lista.add(new Board("BUY",   "COMPRAR/SOBORNAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("CAN",   "PODER/SABER", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("CATCH", "CAPTURA/COGER/ATRAPAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("CHOOSE","ESCOGER/ELEGIR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("COME",  "VEN/VENIR/LLEGAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("COST",  "COSTO/COSTAR/PRECIO", "I know","", soundsGlobal[0], color[2], coloText[2]));

        lista.add(new Board("CUT",   "CORTAR/REDUCIR/RECORTAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("DEAL",  "ACUERDO/NEGOCIAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("DIG",   "CAVAR/EXCAVAR/REMOVER", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("DO",    "HACER/REALIZAR/ACTUAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("DRAW",  "DIBUJAR/SACAR/TRAZAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("DRINK", "DRINK/TOMAR/EMPINAR", "I know","", soundsGlobal[0], color[3], coloText[3]));

        lista.add(new Board("EAT",   "COMER/CONSUMIR/DEVORAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("FALL",  "CAER/BAJAR/OTOÑO", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("FEED",  "ALIMENTAR/DAR DE COMER", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("FEEL",  "SENTIR/SENSACION/PALPAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("FIGHT", "LUCHAR/COMBATIR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("FIND",  "ENCONTRAR/HALLAR", "I know","", soundsGlobal[0], color[4], coloText[4]));

        lista.add(new Board("FLY",   "VOLAR/HUIR/PILOTEAR", "I know","", soundsGlobal[0], color[0],  coloText[0]));
        lista.add(new Board("FORGET","OLVIDAR/DEJAR", "I know","", soundsGlobal[0], color[0],        coloText[0]));
        lista.add(new Board("FORGIVE","PERDONAR/DISCULPAR", "I know","", soundsGlobal[0], color[0],  coloText[0]));
        lista.add(new Board("FREEZE","CONGELAR/CONGELARSE", "I know","", soundsGlobal[0], color[0],  coloText[0]));
        lista.add(new Board("GET",   "OBTENER/CONSEGUIR", "I know","", soundsGlobal[0], color[0],    coloText[0]));
        lista.add(new Board("IS TIME OF TEST",  "GO TO TEST", "I know","", soundsGlobal[6], color[0], coloText[0]));
        lista.add(new Board("GIVE",  "DAR/OFRECER/PRESTAR", "I know","", soundsGlobal[0], color[0],  coloText[0]));
        lista.add(new Board("GO",    "IR/PASAR/SALIR", "I know","", soundsGlobal[0], color[1],       coloText[1]));
        lista.add(new Board("GROW",  "CRECER/CULTIVAR/CRIAR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("HANG",  "COLGAR/MANIR","", "", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("HAVE",  "TENER/HABER/POSEER", "I know","", soundsGlobal[0], color[1],    coloText[1]));
        lista.add(new Board("HEAR",  "OIR", "I know","", soundsGlobal[0], color[1], coloText[1]));

        lista.add(new Board("HIDE",  "ESCONDER/DISIMULAR", "I know","", soundsGlobal[0], color[1],   coloText[1]));
        lista.add(new Board("HIT",   "GOLPEAR/GOLPE/IMPACTO", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("HOLD",  "SONTENER/MANTENER", "I know","", soundsGlobal[0], color[2],        coloText[2]));
        lista.add(new Board("HURT",  "HERIR/DAÑO/LASTIMAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("KEEP",  "MANTENER/TENER/GUARDAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("KNOW",  "SABER/CONOCER", "I know","", soundsGlobal[0], color[2], coloText[2]));

        lista.add(new Board("LAY",   "TUMBAR A", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("LEAD",  "DIRIGIR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("LEAVE", "SALIR/DEJAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("LEND",  "PRESTAR/DAR/EMPRESTAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("LET",   "DEJAR/ALQUILER/PERMITIR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("LIE",   "MENTIR/EMBUSTE", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("LOSE",  "PERDER/SERVENCIDO", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("MAKE",  "HACER/EFECTUAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("MEAN",  "SIGNIFICAR/SUPONER", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("MEET", "CONOCER/REUNIRSE", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("MUST", "DEBER/TENER QUE","", "", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("PAY", "PAGAR/ABONAR/SALARIO", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("PUT", "PONER/COLOCAR/DEJAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("READ", "LEER/INTERPRETAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("RIDE", "MONTAR/PASEO/VIAJAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("RING", "SONAR/TOCAR/LLAMAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("RISE", "ASCENDER/SUBIR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("RUN", "CORRER/EJECUTAR", "","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("SAY", "DECIR/AFIRMAR/EXPRESAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("SEE", "VER/MIRAR/CONSULTAR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("SELL", "VENDER", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("SEND", "ENVIAR/MANDAR/EMITIR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("SET", "ESTABLECER/CONJUNTO", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("SHAKE", "SACUDIR/AGITAR/MENEAR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("SHINE", "BRILLAR/RESPLANDECER/LUCIR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("SHOOT", "DISPARAR/TIRAR/LANZAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("SHOW", "MOSTRAR/ESPECTACULO", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("SHRINK", "ENCOGER/CONTRAER", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("SHUT", "CERRAR/CERRARSE", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("SING", "CANTAR/SILBAR/ZUMBAR", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("SINK", "HUNDIR/CAER/HUNDIRSE", "I know","", soundsGlobal[0], color[2], coloText[2]));
        lista.add(new Board("SIT", "SENTARSE/QUEDARSE/POSAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("SLEEP", "DORMIR/ENTUMECERSE", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("SLIDE", "DESLIZARSE/DESLIZAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("SPEAK", "HABLAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("SPEND", "GASTAR/AGOTAR/PASAR", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("SPLIT", "DIVIDIRSE/PARTIR/DIVISION", "I know","", soundsGlobal[0], color[3], coloText[3]));
        lista.add(new Board("SPREAD", "DIFUNDIR/PROPAGAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("STAND", "ESTAR/AGUANTAR/TOLERAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("STEAL", "ROBAR/HURTAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("STICK", "PEGARSE/PEGAR/ADHERIRSE", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("SWEAR", "JURAR/MALDECIR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("SWIM", "NADAR", "I know","", soundsGlobal[0], color[4], coloText[4]));
        lista.add(new Board("TAKE", "TOMAR/LLEVAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("TEACH", "ENSEÑAR/DAR/SERPROFESOR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("TEAR", "RASGAR/ARRANCAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("TELL", "CONTAR/DECIR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("THINK", "PENSAR/CREER/CONSIDERAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("THROW", "LANZAR/TIRAR/ARROJAR", "I know","", soundsGlobal[0], color[0], coloText[0]));
        lista.add(new Board("UNDERSTAND", "ENTENDER/COMPRENDER", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("WAKE", "DESPERTAR/VELAR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("WEAR", "USAR/PONSERSE/VESTIR", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("WIN", "GANAR/ALCANZAR/VENCER", "I know","", soundsGlobal[0], color[1], coloText[1]));
        lista.add(new Board("WRITE", "ESCRIBIR/COMPONER", "I know","", soundsGlobal[0], color[1], coloText[1]));
*/
        return lista;
    }
}
