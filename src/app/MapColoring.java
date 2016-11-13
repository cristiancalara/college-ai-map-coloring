package app;

import app.models.Country;
import app.models.Map;
import app.strategies.ArcConsistency;
import app.strategies.ForwardChecking;
import app.strategies.Strategy;
import app.strategies.StrategyType;

import java.util.List;

/**
 * Created by cristian on 13.11.2016.
 */
class MapColoring {
    private Map initialMap;
    private List<String> colors;
    private StrategyType strategyType;

    MapColoring(Map initialMap, List<String> colors, StrategyType strategyType){
        this.initialMap = initialMap;
        this.colors = colors;
        this.strategyType = strategyType;

        // set the initial domains for each country
        initialMap.setCountriesDomain(colors);
    }

    /**
     * Colors the map using the given strategy,
     * and prints the result
     */
    void colorMap(){
        Strategy strategy;
        if(strategyType == StrategyType.ARCCONSISTENCY){
            strategy = new ArcConsistency(this.initialMap);
        } else {
            strategy = new ForwardChecking(this.initialMap);
        }

        Map result = strategy.solve();
        System.out.println(result);
    }
}
