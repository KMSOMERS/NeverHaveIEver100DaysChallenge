package uk.co.kmsomers.neverhaveiever.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import uk.co.kmsomers.neverhaveiever.category_select_screen.CategorySelectActivity;
import uk.co.kmsomers.neverhaveiever.category_select_screen.CategorySelectModule;
import uk.co.kmsomers.neverhaveiever.helpers.HelpersModule;

/**
 * Created by kizer on 07/03/2018.
 */

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {CategorySelectModule.class, HelpersModule.class})
    abstract CategorySelectActivity categorySelectActivity();
}
