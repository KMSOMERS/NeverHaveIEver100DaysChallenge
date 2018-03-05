package uk.co.kmsomers.neverhaveiever.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.kmsomers.neverhaveiever.helpers.SharedPreferencesHelper;

/**
 * Created by kizer on 05/03/2018.
 */

@Singleton
@Module
public class HelpersModule {

    public final Context context;

    public HelpersModule(Context context){
        this.context = context;
    }

    @Provides
    public Context providesContext(){
        return context;
    }

    @Provides
    public SharedPreferencesHelper providesSharedPreferencesHelper(Context context){
        return new SharedPreferencesHelper(context);
    }

}
