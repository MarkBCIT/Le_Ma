package ca.bcit.ass1.le_ma;

import java.util.ArrayList;
import java.util.HashMap;

public class Country {

    private String Name;
    private String Capital;
    private String Region;
    private String Population;
    private String Area;
    private String Borders;
    private String Flag;

    public static HashMap<String, ArrayList<Country>> continents = new HashMap<>();
    public static String[] LIST_CONTINENTS = {"Africa", "Americas", "Asia", "Europe", "Oceania"};

    public Country(String name, String capital, String region, String population, String area, String borders, String flag) {
        Name = name;
        Capital = capital;
        Region = region;
        Population = population;
        Area = area;
        Borders = borders;
        Flag = flag;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getBorders() {
        return Borders;
    }

    public void setBorders(String borders) {
        Borders = borders;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String toString() {
        return Name;
    }
}
