package ru.gb.homework2;

import lombok.extern.java.Log;

@Log
public class MyLinkedList {

        private ListNode head;

        // Добавление элемента в конец списка
        public void add(int val) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }

        // Удаление элемента из списка
        public void remove(int val) {
            if (head == null) {
                return;
            }
            if (head.data == val) {
                head = head.next;
                return;
            }
            ListNode current = head;
            while (current.next != null) {
                if (current.next.data == val) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }

        // Обход списка
        public void traverse() {
            ListNode current = head;
            while (current != null) {
                log.info(String.valueOf(current.data));
                current = current.next;
            }
        }
    }


