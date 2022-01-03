package ru.gb;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Box<T extends Fruit> {
    private ArrayList<T> fruitList;

    public Box(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public float boxWeight() {
        float sum = 0;
        for (int i = 0; i < fruitList.size(); i++) {
            sum += fruitList.get(i).getWeight();
        }
        return sum;
    }

    public boolean compare(Box box) {
        return this.boxWeight() == box.boxWeight();
    }

    public void addBox(Box box) {
        /**
         * сравниваем принадлежность элементов листа объекта из параметров с принадлежностью элементов текущего листа
         * если оба принадлежат к одному и тому же классу то добавляем элемент из одного листа в другой и из
         * листа-источника удаляем элемент который передали.
         * Если совпадений нет то очищаем лист-источник полностью.
         */
        if (box.getFruitList().get(0) instanceof Orange && this.fruitList.get(0) instanceof Orange) {
            for (int i = 0; i < box.getFruitList().size(); ) {
                addFruit((T) box.getFruitList().get(i));
                box.removeFruitFromList(i);
            }
        } else if (box.getFruitList().get(0) instanceof Apple && this.fruitList.get(0) instanceof Apple) {
            for (int i = 0; i < box.getFruitList().size(); ) {
                addFruit((T) box.getFruitList().get(i));
                box.removeFruitFromList(i);
            }
        } else {
            box.getFruitList().removeAll(box.getFruitList());
        }
    }

    public void addFruit(T fruit) {
        // добавление элемента в лист
        this.fruitList.add(fruit);
    }

    public void removeFruitFromList(int index) {
        // удаление элемента из листа
        fruitList.remove(index);
    }
}

