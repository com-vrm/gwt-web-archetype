package ${package}.client.place;

import ${package}.client.ioc.ApplicationInjector;
import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

import static ${package}.client.place.ApplicationPlaceHistoryMapper.ApplicationPlaceTokenizers;

public interface ApplicationPlaceHistoryMapper
        extends PlaceHistoryMapperWithFactory<ApplicationPlaceTokenizers> {

    @Inject
    @Override
    void setFactory(ApplicationPlaceTokenizers factory);

    @ImplementedBy(ApplicationInjector.class)
    interface ApplicationPlaceTokenizers {

        SecondPlace.Tokenizer secondTokenizer();
        FirstPlace.Tokenizer firstTokenizer();

    }

}
