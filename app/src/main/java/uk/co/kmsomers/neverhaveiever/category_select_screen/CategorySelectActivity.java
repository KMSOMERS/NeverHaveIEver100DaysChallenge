package uk.co.kmsomers.neverhaveiever.category_select_screen;

import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import uk.co.kmsomers.neverhaveiever.AppConstants;
import uk.co.kmsomers.neverhaveiever.R;
import uk.co.kmsomers.neverhaveiever.questions_screen.QuestionsActivity;

public class CategorySelectActivity extends DaggerAppCompatActivity implements CategorySelectContract.View {

    @Inject
    CategorySelectContract.Presenter presenter;

    private Button btnSexAndRelationships;
    private Button btnWorkAndSchool;
    private Button btnWeird;
    private Button btnDrinking;
    private Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        presenter.attach(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void setStatusBarColour(int colour) {
        int statusBarColour = ResourcesCompat.getColor(getResources(), colour, null);
        getWindow().setStatusBarColor(statusBarColour);
    }

    @Override
    public void setupViews() {
        btnSexAndRelationships = findViewById(R.id.btnSexAndRelationships);
        btnWorkAndSchool = findViewById(R.id.btnWorkAndSchool);
        btnWeird = findViewById(R.id.btnWeird);
        btnDrinking = findViewById(R.id.btnDrinking);
        btnRandom = findViewById(R.id.btnRandom);

        btnSexAndRelationships.setOnClickListener(addCategoryOnClickListner(AppConstants.CATEGORY_SEX_AND_RELATIONSHIPS));
        btnWorkAndSchool.setOnClickListener(addCategoryOnClickListner(AppConstants.CATEGORY_WORK_AND_SCHOOL));
        btnWeird.setOnClickListener(addCategoryOnClickListner(AppConstants.CATEGORY_WEIRD));
        btnDrinking.setOnClickListener(addCategoryOnClickListner(AppConstants.CATEGORY_DRINKING));
        btnRandom.setOnClickListener(addCategoryOnClickListner(AppConstants.CATEGORY_RANDOM));
    }

    private View.OnClickListener addCategoryOnClickListner(final String category){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.categoryButtonPressed(category);
            }
        };
    }

    @Override
    public void intentToQuestions(String category) {
        startActivity(QuestionsActivity.getQuestionsActivityIntent(this, category));
    }
}
