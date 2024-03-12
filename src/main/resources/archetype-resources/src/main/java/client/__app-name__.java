package ${package}.client;

import ${package}.client.widget.ApplicationContainer;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;

public class ${app-name} {

    @Inject
    ApplicationContainer container;
    @Inject
    PlaceHistoryHandler historyHandler;

    void start() {
        RootLayoutPanel.get().add(container);
        historyHandler.handleCurrentHistory();
    }

}
