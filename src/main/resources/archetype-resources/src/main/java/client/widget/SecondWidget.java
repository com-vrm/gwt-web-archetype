package ${package}.client.widget;

import ${package}.client.view.SecondView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SecondWidget extends Composite implements SecondView {

    private static final Binder BINDER = GWT.create(Binder.class);

    @UiField
    Label greeting;

    private Presenter presenter;

    public SecondWidget() {
        initWidget(BINDER.createAndBindUi(this));
    }

    @Override
    public void setGreeting(String greeting) {
        this.greeting.setText(greeting);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    interface Binder extends UiBinder<Widget, SecondWidget> {

    }

}
