package app.models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cristian on 13.11.2016.
 */
final public class MapGenerator {
    private MapGenerator() {
        throw new AssertionError();
    }


    /**
     * An example map
     *
     * @return
     */
    static public Map exampleMap(){
        ArrayList<Country> countries = new ArrayList<>();

        Country WA = new Country("WA");
        Country NT = new Country("NT");
        Country SA = new Country("SA");
        Country Q = new Country("Q");
        Country NSW = new Country("NSW");
        Country V = new Country("V");
        Country T = new Country("T");

        // add neighbours
        WA.setNeighbours(NT, SA);
        Q.setNeighbours(SA, NT, NSW);
        NT.setNeighbours(SA, Q);
        SA.setNeighbours(WA, NT, Q, NSW, V);
        NSW.setNeighbours(SA, Q, V);
        V.setNeighbours(SA, NSW);
        T.setNeighbours();


        countries.addAll(Arrays.asList(WA, Q, NT, SA, NSW, V, T));
        return new Map(countries);
    }
}
