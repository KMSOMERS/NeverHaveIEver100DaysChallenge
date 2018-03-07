package uk.co.kmsomers.neverhaveiever.category_select_screen;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import uk.co.kmsomers.neverhaveiever.di.ActivityScoped;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 05/03/2018.
 */

@Module
public abstract class CategorySelectModule {

    @ActivityScoped
    @Provides
    static CategorySelectModel providesCategorySelectModel(SharedPreferencesHelper sharedPreferencesHelper){
        return new CategorySelectModel(sharedPreferencesHelper);
    }

    @ActivityScoped
    @Binds
    abstract CategorySelectContract.Presenter providesCategorySelectPresenter(CategorySelectPresenter presenter);

}
