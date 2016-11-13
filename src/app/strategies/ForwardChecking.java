package app.strategies;

import app.models.Country;
import app.models.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristian on 13.11.2016.
 */
public class ForwardChecking extends Strategy {
    public ForwardChecking(Map map){
        super(map);
    }

    public Map solve(){
        return this.backtrackingWithForwardChecking(map);
    }

    /**
     * Backtracking with forward checking
     *
     * @param map
     * @return
     */
    private Map backtrackingWithForwardChecking(Map map){
        if(map.assignmentComplete()){
            return map;
        }

        Country country = map.selectUnassignedCountry();

        List<String> domain = new ArrayList<>(country.getDomain());
        for(String color : domain){
            if(country.canHaveColor(color)){
                // set color and forward check on domains
                country.setColor(color);
                List<Country> unassignedNeighbours = country.getUnassignedNeighbours();
                for(Country neighbour : unassignedNeighbours){
                    neighbour.removeColorFromDomain(color);
                }

                // we proceed only if we all neighbours have
                // at least one value in the domain
                if(this.haveADomainValue(unassignedNeighbours)){
                    Map result = backtrackingWithForwardChecking(map);
                    if(result != null) return result;
                }

                // backtrack
                country.setColor(null);
                for(Country neighbour : unassignedNeighbours){
                    neighbour.addColorToDomain(color);
                }
            }
        }

        return null;
    }
}
