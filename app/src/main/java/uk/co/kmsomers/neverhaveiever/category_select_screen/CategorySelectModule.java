package uk.co.kmsomers.neverhaveiever.category_select_screen;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 05/03/2018.
 */

@Singleton
@Module
public class CategorySelectModule {

    public final CategorySelectContract.View view;

    public CategorySelectModule(CategorySelectContract.View view){
        this.view = view;
    }

    @Provides
    public CategorySelectContract.View providesCategorySelectView(){
        return view;
    }

    @Provides
    public CategorySelectModel providesCategorySelectModel(SharedPreferencesHelper sharedPreferencesHelper){
        return new CategorySelectModel(sharedPreferencesHelper);
    }

    @Provides
    public CategorySelectContract.Presenter providesCategorySelectPresenter(CategorySelectContract.View view,
                                                                            CategorySelectModel model){
        return new CategorySelectPresenter(view, model);
    }

}
