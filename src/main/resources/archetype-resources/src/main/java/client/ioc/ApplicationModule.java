package ${package}.client.ioc;

import ${package}.client.place.FirstPlace;
import ${package}.client.place.DefaultPlace;
import ${package}.client.place.ApplicationPlaceHistoryMapper;
import ${package}.client.presenter.ApplicationActivityMapper;
import ${package}.client.presenter.ApplicationActivityMapper.ActivityFactory;
import ${package}.client.view.SecondView;
import ${package}.client.view.FirstView;
import ${package}.client.widget.SecondWidget;
import ${package}.client.widget.FirstWidget;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

public class ApplicationModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class)
                .to(SimpleEventBus.class)
                .in(Singleton.class);

        bind(Place.class)
                .annotatedWith(DefaultPlace.class)
                .to(FirstPlace.class);

        bind(PlaceHistoryMapper.class).to(ApplicationPlaceHistoryMapper.class);
        bind(ActivityMapper.class).to(ApplicationActivityMapper.class);

        install(new GinFactoryModuleBuilder().build(ActivityFactory.class));

        // Views
        bind(FirstView.class).to(FirstWidget.class);
        bind(SecondView.class).to(SecondWidget.class);
    }

    @Singleton
    @Provides
    PlaceController placeController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Singleton
    @Provides
    ActivityManager activityManager(ActivityMapper mapper,
                                    EventBus eventBus) {
        return new ActivityManager(mapper, eventBus);
    }

    @Singleton
    @Provides
    PlaceHistoryHandler historyHandler(EventBus eventBus,
                                       PlaceHistoryMapper mapper,
                                       PlaceController placeController,
                                       @DefaultPlace Place place) {
        PlaceHistoryHandler handler = new PlaceHistoryHandler(mapper);
        handler.register(placeController, eventBus, place);

        return handler;
    }

}
