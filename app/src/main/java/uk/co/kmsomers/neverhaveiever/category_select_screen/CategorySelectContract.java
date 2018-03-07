package uk.co.kmsomers.neverhaveiever.category_select_screen;

/**
 * Created by kizer on 05/03/2018.
 */

public interface CategorySelectContract {

    interface View {
        void setupViews();
    }

    interface Presenter {
        void attach(View view);
        void start();
    }

}
