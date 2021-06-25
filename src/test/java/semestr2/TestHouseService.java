package semestr2;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TestHouseService {
    private Person person1 = new Person("Ivan","Ivanov", "Ivanovich", "01.02.2000");
    private Person person2 = new Person("Dmitry","Sidorov", "Olegovich", "30.12.1990");
    private Person person3 = new Person("Elena","Petrova", "Petrovna", "25.04.1974");
    private Person person4 = new Person("Denis","Sidorov", "Sergeevich", "18.12.1995");
    private Person person5 = new Person("Masha","Lukina", "Ivanovna", "25.04.2001");
    private ArrayList<Person> ownerFlat1 = new ArrayList<>();
    private ArrayList<Person> ownerFlat2 = new ArrayList<>();
    private ArrayList<Person> ownerFlat3 = new ArrayList<>();
    private ArrayList<Flat> listFlat = new ArrayList<>();

    @Test
    public void testSerializeAndDeserializeHouse() throws IOException, ClassNotFoundException {
        Collections.addAll(ownerFlat1, person1, person2);
        Collections.addAll(ownerFlat2, person3);
        Collections.addAll(ownerFlat3, person4, person5);
        Flat flat1 = new Flat(12, 2000, ownerFlat1);
        Flat flat2 = new Flat(10, 5000, ownerFlat2);
        Flat flat3 = new Flat(5, 3000, ownerFlat3);
        Collections.addAll(listFlat, flat1, flat2, flat3);
        House house = new House("10", "address", person4, listFlat);
        HouseService.serializeHouse(house, "test.txt");
        House house1 = HouseService.deserializeHouse("test.txt");
        assertEquals(house,house1);
    }

    @Test
    public void testSerializeAndDeserializeHouseString() throws IOException {
        Collections.addAll(ownerFlat1, person1, person2);
        Collections.addAll(ownerFlat2, person3);
        Collections.addAll(ownerFlat3, person4, person5);
        Flat flat1 = new Flat(12, 2000, ownerFlat1);
        Flat flat2 = new Flat(10, 5000, ownerFlat2);
        Flat flat3 = new Flat(5, 3000, ownerFlat3);
        Collections.addAll(listFlat, flat1, flat2, flat3);
        House house = new House("10", "address", person4, listFlat);
        String json = HouseService.serializeHouseString(house);
        House house1 = HouseService.deserializeHouseString(json);
        //System.out.println(json);
        assertEquals(house,house1);
    }
}
