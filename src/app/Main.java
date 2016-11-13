package app;

import app.models.Map;
import app.models.MapGenerator;
import app.strategies.StrategyType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Map map = MapGenerator.exampleMap();
        List<String> colors = new ArrayList<>(Arrays.asList("red", "green", "blue"));

        //MapColoring mapColoring = new MapColoring(map, colors, StrategyType.FORWARDCHECKING);
        MapColoring mapColoring = new MapColoring(map, colors, StrategyType.ARCCONSISTENCY);
        mapColoring.colorMap();
    }
}
