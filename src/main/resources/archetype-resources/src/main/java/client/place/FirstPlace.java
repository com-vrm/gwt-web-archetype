package ${package}.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class FirstPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<FirstPlace> {

        @Override
        public FirstPlace getPlace(String token) {
            return new FirstPlace();
        }

        @Override
        public String getToken(FirstPlace place) {
            return null;
        }

    }

}
