package ru.gb.homework2;

import lombok.extern.java.Log;

@Log
public class Test {
    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();
        MyArrayList<String> list2 = new MyArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i);
            list2.add("word"+i);
        }

        list1.remove(5);

       list1.traverse();

       list2.set(0,"other word");

        list2.remove(4);

       log.info(String.valueOf(list2.size()));

        for (int i = 0; i < list2.size(); i++) {
            log.info(list2.get(i));
        }
    }

}
