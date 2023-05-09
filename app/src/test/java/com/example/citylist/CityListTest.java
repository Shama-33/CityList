package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities('c').size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities('c').size());
        assertTrue(cityList.getCities('c').contains(city));
    }

    /**
     * test delete method
     */
    @Test
    public void testDelete()
    {
        CityList cityList=new CityList();

        //add new cities
        City city1=new City("Dhaka","Dhaka");
        City city2=new City("Bagerhat","Khulna");
        City city3=new City("Gazipur","Dhaka");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        //delete method call
        cityList.delete(city1);
        assertTrue(!cityList.getCities('c').contains(city1));


    }


    /**
     * method to test count
     */
    @Test
    public void testCount()
    {
        CityList cityList=new CityList();

        //add new cities
        City city1=new City("Dhaka","Dhaka");
        City city2=new City("Bagerhat","Khulna");
        City city3=new City("Gazipur","Dhaka");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        assertEquals(3,cityList.count());

        //delete method call
        cityList.delete(city1);
        assertEquals(2,cityList.count());
        // assertTrue(!cityList.getCities().contains(city1));


    }


    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }


    /**
     * method to test delete exception
     */
    @Test
    public void testDeleteException()
    {
        CityList cityList=new CityList();

        //add new cities
        City city1=new City("Dhaka","Dhaka");
        City city2=new City("Bagerhat","Khulna");
        City city3=new City("Gazipur","Dhaka");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        //delete method call
        cityList.delete(city1);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });

    }


    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities('c').get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities('c').get(1)));
    }


    /**
     * test sort
     */

    @Test
    public void testModifiedGetCities() {
        CityList cityList = new CityList();
        City city1=new City("ZZyx","AABC");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities('c').get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities('c').get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities('c').get(1)));

        assertEquals(0, city.compareTo(cityList.getCities('p').get(1)));
        assertEquals(0, city1.compareTo(cityList.getCities('p').get(0)));
    }

}
