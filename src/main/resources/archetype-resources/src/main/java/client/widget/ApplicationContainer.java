package ${package}.client.widget;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ApplicationContainer extends Composite implements HasOneWidget {

    private static final Binder BINDER = GWT.create(Binder.class);

    @UiField
    LayoutPanel display;

    @Inject
    public ApplicationContainer(ActivityManager activityManager) {
        initWidget(BINDER.createAndBindUi(this));
        activityManager.setDisplay(this);
    }

    @Override
    public void setWidget(IsWidget widget) {
        setWidget(widget == null ? null : widget.asWidget());
    }

    @Override
    public Widget getWidget() {
        return display.getWidgetCount() == 0 ? null : display.getWidget(0);
    }

    @Override
    public void setWidget(Widget widget) {
        display.clear();
        if (widget != null) {
            display.add(widget);
        }
    }

    interface Binder extends UiBinder<Widget, ApplicationContainer> {

    }

}
