package uk.co.kmsomers.neverhaveiever;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import uk.co.kmsomers.neverhaveiever.questions_screen.QuestionsContract;
import uk.co.kmsomers.neverhaveiever.questions_screen.QuestionsModel;
import uk.co.kmsomers.neverhaveiever.questions_screen.QuestionsPresenter;

/**
 * Created by kizer on 11/03/2018.
 */

public class QuestionsScreenTest {

    @Mock
    private QuestionsContract.View view;

    @Mock
    private QuestionsModel model;

    private QuestionsPresenter presenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new QuestionsPresenter(model);
        presenter.attach(view);
    }

    @Test
    public void initialiseTest(){
        presenter.initialise("test");
        Mockito.verify(model).getQuestions("test");
    }

    @Test
    public void startTest(){
        String[] questions = {"question 1", "question 2"};
        Mockito.when(model.getQuestions("initialise")).thenReturn(questions);
        Mockito.when(model.getStatusBarColour()).thenReturn(1);
        Mockito.when(model.getViewColour("initialise")).thenReturn(2);
        Mockito.when(model.getCategoryIcon("initialise")).thenReturn(3);

        presenter.initialise("initialise");
        presenter.start("default question");
        Mockito.verify(view).initialiseViews();
        Mockito.verify(view).showAd();
        Mockito.verify(view).setCategoryTitle("initialise");
        Mockito.verify(view).setStatusBarColour(1);
        Mockito.verify(view).setViewColours(2);
        Mockito.verify(view).setIcon(3);
        Mockito.verify(view).setQuestion("default question");
    }

    @Test
    public void nextButtonPressed(){
        String[] questions = {"question 1", "question 2"};
        Mockito.when(model.getQuestions("initialise")).thenReturn(questions);
        presenter.initialise("initialise");

        presenter.nextButtonPressed();
        Mockito.verify(view).setQuestion("question 1");

        presenter.nextButtonPressed();
        Mockito.verify(view).setQuestion("question 2");
    }

    @Test
    public void instructionsPressed(){
        Mockito.when(model.getViewColour("test")).thenReturn(1);
        presenter.initialise("test");
        presenter.instructionsPressed();
        Mockito.verify(model).getViewColour("test");
        Mockito.verify(view).showInstructionDialog(1);
    }

}
