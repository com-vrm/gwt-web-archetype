package ${package}.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface SecondView extends IsWidget {

    void setGreeting(String greeting);
    void setPresenter(Presenter presenter);

    interface Presenter {

    }

}
