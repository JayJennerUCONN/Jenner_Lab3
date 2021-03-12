package me.com.lab3.model;

public class Country {
    public String name;
    public String capital;
    public String region;
    public Country(String name, String capital, String region){
        this.name = name;
        this.capital = capital;
        this.region = region;
    }
    public String getName(){
        return this.name;
    }
    public String getCapital(){
        return this.capital;
    }
    public String getRegion(){
        return this.region;
    }
}
