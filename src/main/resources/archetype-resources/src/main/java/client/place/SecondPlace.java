package ${package}.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SecondPlace extends Place {

    private final String greeting;

    public SecondPlace(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }


    @Prefix("the-pre-fix")
    public static class Tokenizer implements PlaceTokenizer<SecondPlace> {

        @Override
        public SecondPlace getPlace(String token) {
            return new SecondPlace(token);
        }

        @Override
        public String getToken(SecondPlace place) {
            return place.greeting;
        }

    }

}
