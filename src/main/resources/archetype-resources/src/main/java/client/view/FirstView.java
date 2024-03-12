package ${package}.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface FirstView extends IsWidget {

    void setPresenter(Presenter presenter);

    interface Presenter {

        void goTo(Place place);

    }

}
