package org.example;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Boxes box1 = new Boxes(10,10,10);
        Boxes box2 = new Boxes(20,20,20);
        Boxes box3 = new Boxes(40,40,40);

        ArrayList <Boxes> boxList = new ArrayList<>();

        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);

        Main mn = new Main();
        System.out.println(mn.getBigBoxList(boxList).size());

    }

    public ArrayList<Boxes> getBigBoxList(ArrayList <Boxes> boxes){
        ArrayList <Boxes> bigBoxes = new ArrayList<>(boxes);
        ListIterator <Boxes> iterator = bigBoxes.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().getWidth()<= 30){
                iterator.remove();
            }
        }
        return bigBoxes;
    }
}