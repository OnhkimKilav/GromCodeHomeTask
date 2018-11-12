package lesson35.hotel;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

/**
 * Created by Valik on 05.11.2018.
 */
public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    private Random random = new Random();
    public Hotel(String name, String country, String city, String street) {
        this.id = random.nextInt(MAX_VALUE);
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
