package app.strategies;


import app.models.Country;
import app.models.Map;

import java.util.List;


public abstract class Strategy {
    protected Map map;

    public Strategy(Map map){
        this.map = map;
    }

    abstract public Map solve();


    /**
     * Checks to see if all neighbours
     * have at least one domain value
     *
     * @param neighbours
     * @return
     */
    protected boolean haveADomainValue(List<Country> neighbours){
        for(Country neighbour : neighbours){
            if(neighbour.getDomain().isEmpty()){
                return false;
            }
        }

        return true;
    }
}
