package ${package}.client.presenter;

import ${package}.client.place.SecondPlace;
import ${package}.client.view.SecondView;
import ${package}.client.view.SecondView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class SecondPresenter extends AbstractActivity
        implements Presenter {

    @Inject
    SecondView view;

    private final SecondPlace place;

    @Inject
    public SecondPresenter(@Assisted SecondPlace place) {
        this.place = place;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view);
        view.setGreeting(place.getGreeting());
    }

}
