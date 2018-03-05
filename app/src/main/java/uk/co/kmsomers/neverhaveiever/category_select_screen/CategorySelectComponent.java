package uk.co.kmsomers.neverhaveiever.category_select_screen;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.kmsomers.neverhaveiever.di.HelpersModule;

/**
 * Created by kizer on 05/03/2018.
 */

@Singleton
@Component(modules = {CategorySelectModule.class, HelpersModule.class})
public interface CategorySelectComponent {
    void inject(CategorySelectActivity activity);
}
