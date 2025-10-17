package com.example.listycity;

/**
 * class that defines a City object
 * contains getters for each Cities' city and province
 * @author macy [and lab TAs]
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }
    
    /**
     * helps with sorting list of Cities
     * @param o: object to compare to
     * @return -1 if the caller is greater than the city name field
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o; // typecasting
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
