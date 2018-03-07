package uk.co.kmsomers.neverhaveiever.category_select_screen;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import uk.co.kmsomers.neverhaveiever.R;

public class CategorySelectActivity extends DaggerAppCompatActivity implements CategorySelectContract.View {

    @Inject
    CategorySelectContract.Presenter presenter;

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.attach(this);
        presenter.start();
    }

    @Override
    public void setupViews() {
        tvTest = findViewById(R.id.tvTest);
        tvTest.setText("PRESENTER IS INJECTED AND WORKING");
    }
}
