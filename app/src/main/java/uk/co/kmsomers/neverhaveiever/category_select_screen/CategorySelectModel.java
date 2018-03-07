package uk.co.kmsomers.neverhaveiever.category_select_screen;

import javax.inject.Singleton;

import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 05/03/2018.
 */

@Singleton
public class CategorySelectModel {

    private SharedPreferencesHelper sharedPreferencesHelper;

    public CategorySelectModel(SharedPreferencesHelper sharedPreferencesHelper){
        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    public void setActionBarColour(String category){
        sharedPreferencesHelper.setStatusBarColour(category);
    }

    public int getStatusBarColour(){
        return sharedPreferencesHelper.getStatusBarColour();
    }
}
