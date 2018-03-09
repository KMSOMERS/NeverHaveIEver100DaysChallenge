package uk.co.kmsomers.neverhaveiever.helpers;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.kmsomers.neverhaveiever.di.ActivityScoped;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 05/03/2018.
 */
@Module
public class HelpersModule {

    @ActivityScoped
    @Provides
    static SharedPreferencesHelper providesSharedPreferencesHelper(Context context){
        return new SharedPreferencesHelper(context);
    }

    @ActivityScoped
    @Provides
    static ResourcesHelper providesResourcesHelper(Context context){
        return new ResourcesHelper(context);
    }
}
