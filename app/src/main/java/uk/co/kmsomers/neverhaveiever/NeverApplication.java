package uk.co.kmsomers.neverhaveiever;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import uk.co.kmsomers.neverhaveiever.di.DaggerAppComponent;

/**
 * Created by kizer on 07/03/2018.
 */

public class NeverApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
