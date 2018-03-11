package uk.co.kmsomers.neverhaveiever;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import uk.co.kmsomers.neverhaveiever.category_select_screen.CategorySelectContract;
import uk.co.kmsomers.neverhaveiever.category_select_screen.CategorySelectModel;
import uk.co.kmsomers.neverhaveiever.category_select_screen.CategorySelectPresenter;

/**
 * Created by kizer on 11/03/2018.
 */

public class CategorySelectScreenTest {

    @Mock
    private CategorySelectContract.View view;

    @Mock
    private CategorySelectModel model;

    private CategorySelectPresenter presenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new CategorySelectPresenter(model);
        presenter.attach(view);
    }

    @Test
    public void initialiseViewsTest(){
        presenter.initialiseViews();
        Mockito.verify(view).setupViews();
    }

    @Test
    public void startTest(){
        Mockito.when(model.getStatusBarColour()).thenReturn(1);
        presenter.start();
        Mockito.verify(view).setStatusBarColour(1);
    }

    @Test
    public void categoryButtonPressedTest(){
        presenter.categoryButtonPressed("test");
        Mockito.verify(model).setActionBarColour("test");
        Mockito.verify(view).intentToQuestions("test");
    }

}
