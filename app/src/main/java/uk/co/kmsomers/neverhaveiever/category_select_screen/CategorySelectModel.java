package uk.co.kmsomers.neverhaveiever.category_select_screen;

import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 05/03/2018.
 */

public class CategorySelectModel {

    private SharedPreferencesHelper sharedPreferencesHelper;

    public CategorySelectModel(SharedPreferencesHelper sharedPreferencesHelper){
        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    public int getStatusBarColour(){
        return sharedPreferencesHelper.getStatusBarColour();
    }
}
