package uk.co.kmsomers.neverhaveiever.questions_screen;

import uk.co.kmsomers.neverhaveiever.helpers.ResourcesHelper;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 09/03/2018.
 */

public class QuestionsModel {

    private SharedPreferencesHelper sharedPreferencesHelper;
    private ResourcesHelper resourcesHelper;

    public QuestionsModel(SharedPreferencesHelper sharedPreferencesHelper, ResourcesHelper resourcesHelper){
        this.sharedPreferencesHelper = sharedPreferencesHelper;
        this.resourcesHelper = resourcesHelper;
    }

    public int getStatusBarColour(){
        return sharedPreferencesHelper.getStatusBarColour();
    }

    public int getViewColour(String category){
        return resourcesHelper.getCategoryColour(category);
    }

    public String[] getQuestions(String category){
        return resourcesHelper.getCategoryQuestions(category);
    }

    public int getCategoryIcon(String category){
        return resourcesHelper.getCategoryIcon(category);
    }

}
