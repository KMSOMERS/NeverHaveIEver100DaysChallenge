package uk.co.kmsomers.neverhaveiever.questions_screen;

import javax.inject.Inject;

/**
 * Created by kizer on 09/03/2018.
 */

public class QuestionsPresenter implements QuestionsContract.Presenter{

    private QuestionsContract.View view;
    private QuestionsModel model;

    private int currentQuestionPosition = 0;
    private String[] questions;
    private String category;

    @Inject
    public QuestionsPresenter(QuestionsModel model){
        this.model = model;
    }

    @Override
    public void attach(QuestionsContract.View view) {
        this.view = view;
    }

    @Override
    public void initialise(String category) {
        this.category = category;
        questions = model.getQuestions(category);
    }

    @Override
    public void start(String defaultQuestion) {
        view.initialiseViews();
        view.showAd();
        view.setCategoryTitle(category);
        view.setStatusBarColour(model.getStatusBarColour());
        view.setViewColours(model.getViewColour(category));
        view.setIcon(model.getCategoryIcon(category));
        view.setQuestion(defaultQuestion);
    }

    @Override
    public void nextButtonPressed() {
        String question = questions[currentQuestionPosition];
        view.setQuestion(question);
        currentQuestionPosition = (currentQuestionPosition + 1) % questions.length;
    }

    @Override
    public void instructionsPressed() {
        view.showInstructionDialog(model.getViewColour(category));
    }
}
