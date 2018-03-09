package uk.co.kmsomers.neverhaveiever.questions_screen;

import javax.inject.Inject;

/**
 * Created by kizer on 09/03/2018.
 */

public class QuestionsPresenter implements QuestionsContract.Presenter{

    private QuestionsContract.View view;
    private QuestionsModel model;

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
    }

    @Override
    public void start() {
        view.initialiseViews();
        view.setStatusBarColour(model.getStatusBarColour(category));
        view.setViewColours(model.getViewColour(category));
        view.setIcon(model.getCategoryIcon(category));
    }

    @Override
    public void nextButtonPressed() {

    }

    @Override
    public void instructionsPressed() {

    }
}
