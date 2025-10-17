package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test the methods for list of Cities
 * @author macy [and lab TAs]
 */
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    
    /**
     * tests the add method from the CityList class
     * tests whether the new City was successfully added into the list of Cities
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    
    /**
     * tests whether the City that the user intended to add to the list of Cities already exists
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    
    /**
     * tests whether City list is sorted or not
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList(); // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
                                            // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0))); // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city); // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    
    /**
     * tests whether or not the list has the given City
     * test both cases?
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = cityList.getCities().get(0);
        if (edmonton.getCityName().equals("Edmonton") && edmonton.getProvinceName().equals("Alberta")) {
            assertTrue(cityList.hasCity(edmonton)); // sees whether it contains Edmonton
        }
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }
    
    /**
     * tests whether the given City was deleted
     */
    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City edmonton = cityList.getCities().get(0);
        assertEquals(1, cityList.getCities().size()); // counts how many cities in list
        cityList.deleteCity(edmonton);
        assertEquals(0, cityList.getCities().size());
    }
    
    /**
     * tests whether deleteCity() method's Exception is thrown
     */
    @Test
    void testDeleteCityException() {
        CityList cityList = mockCityList();
        City edmonton = cityList.getCities().get(0);
        assertEquals(1, cityList.getCities().size()); // counts how many cities in list
        City city = new City("Regina", "Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city); // checks if city that does not exist in list throws an exception
        });
        assertEquals(1, cityList.getCities().size()); // should still be one because nothing was deleted
    }
    
    /**
     * tests whether the given amount of Cities in the list is correct
     */
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City yellowknife = new City("Yellowknife", "Northwest Territories");
        cityList.add(yellowknife);
        assertEquals(2, cityList.countCities());
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.add(charlottetown);
        assertEquals(3, cityList.countCities());
        City regina = new City("Regina", "Saskatchewan");
        cityList.add(regina);
        assertEquals(4, cityList.countCities());
        // deletes City to see if counts right
        // (since we've already tested whether deleteCity works right)
        cityList.deleteCity(regina);
        assertEquals(3, cityList.countCities());
    }
    
}