package uk.co.kmsomers.neverhaveiever.category_select_screen;

/**
 * Created by kizer on 05/03/2018.
 */

public interface CategorySelectContract {

    interface View {
        void setupViews();

        void setStatusBarColour(int colour);

        void intentToQuestions(String category);
    }

    interface Presenter {
        void attach(View view);

        void initialiseViews();

        void start();

        void categoryButtonPressed(String category);
    }

}
