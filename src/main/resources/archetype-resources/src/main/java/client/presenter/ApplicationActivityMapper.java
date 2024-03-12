package ${package}.client.presenter;

import ${package}.client.place.SecondPlace;
import ${package}.client.place.FirstPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

public class ApplicationActivityMapper implements ActivityMapper {

    private final ActivityFactory factory;

    @Inject
    public ApplicationActivityMapper(ActivityFactory factory) {
        this.factory = factory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof FirstPlace) {
            return factory.buildFirstPresenter((FirstPlace) place);
        }
        else if (place instanceof SecondPlace) {
            return factory.buildSecondPresenter((SecondPlace) place);
        }

        return null;
    }

    public interface ActivityFactory {

        FirstPresenter buildFirstPresenter(FirstPlace place);

        SecondPresenter buildSecondPresenter(SecondPlace place);

    }

}
