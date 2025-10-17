package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * class that keeps track of each Cities
 * @author macy [and lab TAs]
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    
    /**
     * adds City to list if City does not exist
     * @param city: given City to add
     * @throws IllegalArgumentException error if list already contains given City
     */
    public void add(City city) {
        if (cities.contains(city)) {  // checks whether the list contains the given city
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    
    /**
     * returns sorted list of Cities
     * @return returns sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    
    /**
     * returns Boolean of whether given City already exist in list
     * @param city: given City of what to check in the list
     * @return returns Boolean
     */
    public boolean hasCity(City city) {
        boolean cityExists = false; // boolean to return
        if (cities.contains(city)) {
            cityExists = true;
        }
        return cityExists;
    }
    
    /**
     * deletes a City from the list
     * @param city: given City of what to remove from list
     * @throws IllegalArgumentException error if list already contains given City
     */
    public void deleteCity(City city) {
        // deletes city if in list
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else { // throws an Exception if the given City is not in the list
            throw new IllegalArgumentException("This city does not exist! Please try again.");
        }
    }
    
    /**
     * counts how many Cities are in the list
     * @return returns the number of items in the list
     */
    public int countCities() {
        return cities.size();
    }
}