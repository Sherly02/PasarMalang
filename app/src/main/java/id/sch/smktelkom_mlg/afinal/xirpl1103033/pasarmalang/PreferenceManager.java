package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang;

/**
 * Created by win 10 on 5/30/2018.
 */

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String FIRST_LAUNCH = "firstLaunch";
    private static final String PREFERENCE = "Javapapers";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;
    Context context;
    int MODE = 0;

    public PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE, MODE);
        spEditor = sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        spEditor.putBoolean(FIRST_LAUNCH, isFirstTime);
        spEditor.commit();
    }

    public boolean FirstLaunch() {
        return sharedPreferences.getBoolean(FIRST_LAUNCH, true);
    }
}
