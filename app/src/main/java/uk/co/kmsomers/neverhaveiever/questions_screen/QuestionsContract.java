package uk.co.kmsomers.neverhaveiever.questions_screen;

/**
 * Created by kizer on 09/03/2018.
 */

public interface QuestionsContract {

    interface View {
        void initialiseViews();

        void setViewColours(int colour);

        void setCategoryTitle(String title);

        void setStatusBarColour(int colour);

        void showAd();

        void setIcon(int icon);

        void setQuestion(String question);

        void showInstructionDialog(int colour);
    }

    interface Presenter {
        void initialise(String category);

        void start(String defaultQuestion);

        void attach(QuestionsContract.View view);

        void nextButtonPressed();

        void instructionsPressed();
    }

}
