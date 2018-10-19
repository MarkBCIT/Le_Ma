package ca.bcit.ass1.le_ma;

import java.util.ArrayList;
import java.util.HashMap;

public class Country {

    private String Name;
    private String alpha3Code;
    private String Capital;
    private String Region;
    private String Population;
    private String Area;
    private String[] Borders;
    private String Flag;

    public static HashMap<String, String> list_countries = new HashMap<>();
    public static HashMap<String, ArrayList<Country>> continents = new HashMap<>();
    public static String[] LIST_CONTINENTS = {"Africa", "Americas", "Asia", "Europe", "Oceania", "Polar"};

    public Country(String name, String alpha3Code, String capital, String region, String population, String area, String[] borders, String flag) {
        Name = name;
        this.alpha3Code = alpha3Code;
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

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
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

    public String getBordersString() {
        if (Borders.length == 0) {
            return "None";
        }

        String borders = list_countries.get(Borders[0]);
        for (int i = 1; i < Borders.length; i++) {
            borders += ", " + list_countries.get(Borders[i]);
        }
        return borders;
    }

    public String[] getBorders() {
        return Borders;
    }

    public void setBorders(String[] borders) {
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
