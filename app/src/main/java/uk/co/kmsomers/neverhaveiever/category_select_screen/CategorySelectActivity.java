package uk.co.kmsomers.neverhaveiever.category_select_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import uk.co.kmsomers.neverhaveiever.R;
import uk.co.kmsomers.neverhaveiever.di.HelpersModule;

public class CategorySelectActivity extends AppCompatActivity implements CategorySelectContract.View {

    @Inject
    CategorySelectContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerCategorySelectComponent.builder()
                .categorySelectModule(new CategorySelectModule(this))
                .helpersModule(new HelpersModule(this))
                .build()
                .inject(this);
    }


}
