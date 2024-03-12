package ${package}.client;

import ${package}.client.ioc.ApplicationInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class ApplicationEntryPoint implements EntryPoint {

    @Inject
    AsyncProvider<${app-name}> appProvider;

    @Override
    public void onModuleLoad() {
        ApplicationInjector injector = GWT.create(ApplicationInjector.class);
        injector.inject(this);
        appProvider.get(new AsyncCallback<${app-name}>() {

            @Override
            public void onFailure(Throwable caught) {
                // TODO: Failed, do something
            }

            @Override
            public void onSuccess(${app-name} result) {
                result.start();
            }

        });
    }

}
