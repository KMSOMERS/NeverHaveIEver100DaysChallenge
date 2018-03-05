package uk.co.kmsomers.neverhaveiever.category_select_screen;

/**
 * Created by kizer on 05/03/2018.
 */

public class CategorySelectPresenter implements CategorySelectContract.Presenter {

    private CategorySelectContract.View view;
    private CategorySelectModel model;

    public CategorySelectPresenter(CategorySelectContract.View view, CategorySelectModel model){
        this.view = view;
        this.model = model;
    }

}
