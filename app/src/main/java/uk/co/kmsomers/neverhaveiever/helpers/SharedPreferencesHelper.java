package uk.co.kmsomers.neverhaveiever.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import uk.co.kmsomers.neverhaveiever.AppConstants;
import uk.co.kmsomers.neverhaveiever.R;

/**
 * Created by kizer on 05/03/2018.
 */

@Singleton
public class SharedPreferencesHelper {

    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context){
        this.sharedPreferences = context.getSharedPreferences(AppConstants.SHARED_PREFERENCES_CATEGORY, Context.MODE_PRIVATE);
    }

    public void setStatusBarColour(String category){
        switch (category){
            case AppConstants.CATEGORY_SEX_AND_RELATIONSHIPS:
                saveStatusBarColour(R.color.material_pink_700);
                break;
            case AppConstants.CATEGORY_DRINKING:
                saveStatusBarColour(R.color.material_light_green_700);
                break;
            case AppConstants.CATEGORY_WEIRD:
                saveStatusBarColour(R.color.material_deep_purple_700);
                break;
            case AppConstants.CATEGORY_WORK_AND_SCHOOL:
                saveStatusBarColour(R.color.material_blue_700);
                break;
            case AppConstants.CATEGORY_RANDOM:
                saveStatusBarColour(R.color.material_amber_700);
                break;
        }
    }

    private void saveStatusBarColour(int colour){
        sharedPreferences.edit()
                .putInt(AppConstants.SHARED_PREFERNECES_CATEGORY_COLOUR, colour)
                .apply();
    }


    public int getStatusBarColour(){
        return sharedPreferences.getInt(AppConstants.SHARED_PREFERNECES_CATEGORY_COLOUR, R.color.material_pink_700);
    }

}
