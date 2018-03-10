package uk.co.kmsomers.neverhaveiever.helpers;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import uk.co.kmsomers.neverhaveiever.AppConstants;
import uk.co.kmsomers.neverhaveiever.R;
import uk.co.kmsomers.neverhaveiever.utils.CommonUtils;

/**
 * Created by kizer on 09/03/2018.
 */

public class ResourcesHelper {

    private Context context;

    public ResourcesHelper(Context context){
        this.context = context;
    }

    public int getCategoryColour(String category){
        switch (category){
            case AppConstants.CATEGORY_SEX_AND_RELATIONSHIPS:
                return R.color.material_pink_500;
            case AppConstants.CATEGORY_DRINKING:
                return R.color.material_light_green_500;
            case AppConstants.CATEGORY_WEIRD:
                return R.color.material_deep_purple_500;
            case AppConstants.CATEGORY_WORK_AND_SCHOOL:
                return R.color.material_blue_500;
            case AppConstants.CATEGORY_RANDOM:
                return R.color.material_amber_500;
            default: return R.color.material_pink_500;
        }
    }

    public int getCategoryIcon(String category){
        switch (category){
            case AppConstants.CATEGORY_SEX_AND_RELATIONSHIPS:
                return R.drawable.ic_heart;
            case AppConstants.CATEGORY_DRINKING:
                return R.drawable.ic_beer;
            case AppConstants.CATEGORY_WEIRD:
                return R.drawable.ic_weird;
            case AppConstants.CATEGORY_WORK_AND_SCHOOL:
                return R.drawable.ic_school;
            case AppConstants.CATEGORY_RANDOM:
                return R.drawable.ic_question;
            default: return R.drawable.ic_question;
        }
    }

    public String[] getCategoryQuestions(String category){
        switch (category){
            case AppConstants.CATEGORY_SEX_AND_RELATIONSHIPS:
                return CommonUtils.randomiseQuestions(context.getResources().getStringArray(R.array.category_sex_and_relationshps), context.getString(R.string.game_instruction));
            case AppConstants.CATEGORY_DRINKING:
                return CommonUtils.randomiseQuestions(context.getResources().getStringArray(R.array.category_drinking), context.getString(R.string.game_instruction));
            case AppConstants.CATEGORY_WEIRD:
                return CommonUtils.randomiseQuestions(context.getResources().getStringArray(R.array.category_weird), context.getString(R.string.game_instruction));
            case AppConstants.CATEGORY_WORK_AND_SCHOOL:
                return CommonUtils.randomiseQuestions(context.getResources().getStringArray(R.array.category_work_and_school), context.getString(R.string.game_instruction));
            case AppConstants.CATEGORY_RANDOM:
                String[] sexAndRelationshipsQuestions = context.getResources().getStringArray(R.array.category_sex_and_relationshps);
                String[] drinkingQuestions = context.getResources().getStringArray(R.array.category_drinking);
                String[] animalsQuestions = context.getResources().getStringArray(R.array.category_work_and_school);
                String[] familyQuestions = context.getResources().getStringArray(R.array.category_weird);
                String[] allQuestions = CommonUtils.concatenate(CommonUtils.concatenate(sexAndRelationshipsQuestions, drinkingQuestions),
                                                CommonUtils.concatenate(animalsQuestions, familyQuestions));
                return CommonUtils.randomiseQuestions(allQuestions, context.getString(R.string.game_instruction));
        }
        return new String[0];
    }

}
