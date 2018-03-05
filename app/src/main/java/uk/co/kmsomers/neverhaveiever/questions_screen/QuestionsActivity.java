package uk.co.kmsomers.neverhaveiever.questions_screen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uk.co.kmsomers.neverhaveiever.AppConstants;
import uk.co.kmsomers.neverhaveiever.R;

public class QuestionsActivity extends AppCompatActivity {

    public static Intent getQuestionsActivityIntent(Context context, String category){
        Intent questionsIntent = new Intent(context, QuestionsActivity.class);
        questionsIntent.putExtra(AppConstants.QUESTIONS_INTENT_CATEGORY, category);
        return questionsIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }
}
