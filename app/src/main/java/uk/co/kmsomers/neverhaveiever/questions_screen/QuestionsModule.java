package uk.co.kmsomers.neverhaveiever.questions_screen;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import uk.co.kmsomers.neverhaveiever.di.ActivityScoped;
import uk.co.kmsomers.neverhaveiever.helpers.ResourcesHelper;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 09/03/2018.
 */

@Module
public abstract class QuestionsModule {

    @ActivityScoped
    @Provides
    static QuestionsModel providesQuestionsModel(SharedPreferencesHelper sharedPreferencesHelper,
                                                 ResourcesHelper resourcesHelper){
        return new QuestionsModel(sharedPreferencesHelper, resourcesHelper);
    }

    @ActivityScoped
    @Binds
    abstract QuestionsContract.Presenter questionsPresenter(QuestionsPresenter presenter);

}
