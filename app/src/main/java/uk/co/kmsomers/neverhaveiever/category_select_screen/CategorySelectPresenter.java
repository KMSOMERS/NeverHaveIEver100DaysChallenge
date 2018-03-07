package uk.co.kmsomers.neverhaveiever.category_select_screen;

import javax.inject.Inject;

/**
 * Created by kizer on 05/03/2018.
 */

public class CategorySelectPresenter implements CategorySelectContract.Presenter {

    private CategorySelectContract.View view;
    private CategorySelectModel model;

    @Inject
    public CategorySelectPresenter(CategorySelectModel model){
        this.model = model;
    }

    @Override
    public void attach(CategorySelectContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        view.setupViews();
    }
}
