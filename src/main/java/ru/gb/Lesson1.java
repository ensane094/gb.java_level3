package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson1 {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4};
        Lesson1 lesson1 = new Lesson1();
        lesson1.replaceElements(0, 1, array);
        ArrayList<Integer> list = lesson1.makeArrayList(array);

        ArrayList<Apple> appleList = new ArrayList<>(Arrays.asList(new Apple(), new Apple(), new Apple()));
        ArrayList<Orange> orangeList = new ArrayList<>(Arrays.asList(new Orange(), new Orange(), new Orange()));

        Box<Apple> appleBox = new Box<>(appleList);
        Box<Orange> orangeBox = new Box<>(orangeList);

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());

    }

    public <T> T replaceElements(int src_index, int destination_index, T[] array) {
        T place;
        if (destination_index <= array.length && destination_index >= 0) {
            place = array[destination_index];
            array[destination_index] = array[src_index];
            array[src_index] = place;
        }
        return (T) array;
    }

    public <T> ArrayList<T> makeArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

}
