package uk.co.kmsomers.neverhaveiever.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 07/03/2018.
 */


@Module
public abstract class ApplicationModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);
}