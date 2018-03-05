package uk.co.kmsomers.neverhaveiever.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import uk.co.kmsomers.neverhaveiever.AppConstants;

/**
 * Created by kizer on 05/03/2018.
 */

public class SharedPreferencesHelper {

    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context){
        this.sharedPreferences = context.getSharedPreferences(AppConstants.SHARED_PREFERENCES_CATEGORY, Context.MODE_PRIVATE);
    }

    public void setStatusBarColour(int colour){
        sharedPreferences.edit()
                .putInt(AppConstants.SHARED_PREFERNECES_CATEGORY_COLOUR, colour)
                .apply();
    }

    public int getStatusBarColour(){
        return sharedPreferences.getInt(AppConstants.SHARED_PREFERNECES_CATEGORY_COLOUR, 0);
    }

}
