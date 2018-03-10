package uk.co.kmsomers.neverhaveiever.questions_screen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import uk.co.kmsomers.neverhaveiever.AppConstants;
import uk.co.kmsomers.neverhaveiever.BuildConfig;
import uk.co.kmsomers.neverhaveiever.R;
import uk.co.kmsomers.neverhaveiever.di.DaggerAppComponent;
import uk.co.kmsomers.neverhaveiever.utils.FadingTextView;

public class QuestionsActivity extends DaggerAppCompatActivity implements QuestionsContract.View {

    @Inject
    QuestionsContract.Presenter presenter;

    private ImageView ivInstructions;
    private ImageView ivCategoryIcon;

    private TextView tvCategoryTitle;
    private FadingTextView ftvQuestion;

    private Button btnNext;
    private Button btnQuit;

    private TextToSpeech textToSpeech;
    private AdView avQuestions;

    public static Intent getQuestionsActivityIntent(Context context, String category){
        Intent questionsIntent = new Intent(context, QuestionsActivity.class);
        questionsIntent.putExtra(AppConstants.QUESTIONS_INTENT_CATEGORY, category);
        return questionsIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Bundle bundle = getIntent().getExtras();

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });

        presenter.attach(this);
        presenter.initialise(bundle.getString(AppConstants.QUESTIONS_INTENT_CATEGORY));
        presenter.start(getString(R.string.game_instruction));
    }

    @Override
    public void initialiseViews() {
        ivInstructions = findViewById(R.id.ivInstructions);
        ivInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.instructionsPressed();
            }
        });

        ivCategoryIcon = findViewById(R.id.ivCategoryIcon);
        tvCategoryTitle = findViewById(R.id.tvCategoryTitle);
        ftvQuestion = findViewById(R.id.tvQuestion);

        ftvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.nextButtonPressed();
            }
        });

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.nextButtonPressed();
            }
        });

        btnQuit = findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Consider moving to presenter?
                onBackPressed();
            }
        });
    }

    @Override
    public void showAd() {
        avQuestions = findViewById(R.id.avQuestions);
        AdRequest adRequest = new AdRequest.Builder().build();
        avQuestions.loadAd(adRequest);
    }

    @Override
    public void setViewColours(int colour) {
        btnNext.setBackgroundColor(ResourcesCompat.getColor(getResources(), colour, null));
        btnQuit.setBackgroundColor(ResourcesCompat.getColor(getResources(), colour, null));
        ftvQuestion.setTextColor(ResourcesCompat.getColor(getResources(), colour, null));
        tvCategoryTitle.setTextColor(ResourcesCompat.getColor(getResources(), colour, null));
        Drawable instructionsIcon = getDrawable(R.drawable.ic_help);
        instructionsIcon.setTint(ResourcesCompat.getColor(getResources(), colour, null));
        ivInstructions.setImageDrawable(instructionsIcon);
    }

    @Override
    public void setCategoryTitle(String title) {
        tvCategoryTitle.setText(title);
    }

    @Override
    public void setStatusBarColour(int colour) {
        int statusBarColour = ResourcesCompat.getColor(getResources(), colour, null);
        getWindow().setStatusBarColor(statusBarColour);
    }

    @Override
    public void setIcon(int icon) {
        ivCategoryIcon.setImageDrawable(ResourcesCompat.getDrawable(getResources(), icon, null));
    }

    @Override
    public void setQuestion(String question) {
        String fullQuestion =  getString(R.string.never_have_I_ever_question, question);
        ftvQuestion.show();
        ftvQuestion.setText(fullQuestion);
        textToSpeech.speak(fullQuestion, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    public void showInstructionDialog(final int textColour) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.instructions_title);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //To dismiss
            }
        });
        builder.setMessage(R.string.quiz_instructions);

        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ResourcesCompat.getColor(getResources(), textColour, null));
            }
        });
        dialog.show();
    }
}
