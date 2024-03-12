package ${package}.client.presenter;

import ${package}.client.view.FirstView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class FirstPresenter extends AbstractActivity
        implements FirstView.Presenter {

    @Inject
    FirstView view;

    @Inject
    PlaceController placeController;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view);
    }

    @Override
    public void goTo(Place place) {
        placeController.goTo(place);
    }

}
