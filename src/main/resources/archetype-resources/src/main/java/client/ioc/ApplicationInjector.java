package ${package}.client.ioc;

import ${package}.client.ApplicationEntryPoint;
import ${package}.client.place.ApplicationPlaceHistoryMapper.ApplicationPlaceTokenizers;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ ApplicationModule.class })
public interface ApplicationInjector extends Ginjector, ApplicationPlaceTokenizers {

    void inject(ApplicationEntryPoint entryPoint);

}
