package ${package}.client.widget;

import ${package}.client.place.SecondPlace;
import ${package}.client.view.FirstView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FirstWidget extends Composite implements FirstView {

    private static final Binder BINDER = GWT.create(Binder.class);

    @UiField
    Button theButton;

    private Presenter presenter;

    public FirstWidget() {
        initWidget(BINDER.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("theButton")
    void handleButtonClick(ClickEvent event) {
        presenter.goTo(new SecondPlace("i.came.from.first.place"));
    }

    interface Binder extends UiBinder<Widget, FirstWidget> {

    }

}
