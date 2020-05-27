package sooyer.developer.com.palabrasandwords.Common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.List;

import sooyer.developer.com.palabrasandwords.Models.Board;
import sooyer.developer.com.palabrasandwords.R;

/**
 * Created by Uriel on 24/05/2019.
 */

public class Common {

    public static final String LANGUAGE_PAIR =  "en-es";
    public static Boolean istrue = true;
    public static Boolean showTraslate = true;
    public static int  colorTheme ;

    public static void changeThemeGlobal(Context context) {
        switch (colorTheme){
            case 1:
                context.setTheme(R.style.RedThme);
                break;
            case 2:
                context.setTheme(R.style.AppTheme);
                break;
            case 3:
                context.setTheme(R.style.GreenThme);
                break;
            default:
                context.setTheme(R.style.AppTheme);
                break;
        }
    }


}
