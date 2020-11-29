package ru.school.lesson3;

/*
  root
    |
    +-------+      +-----+
    | data  |      | data|
    | next  |--->  | next| --> null
    +-------+      +-----+
 */


public class LList<E> {
    private Node<E> root;

    public void add(E item) {
        Node tmpItem = new Node(item);
        Node lastItem = findLast();

        if (lastItem != null) {
            lastItem.next = tmpItem;
        } else {
            root = tmpItem;
        }
    }

    public E get(int id) {
        if (id < 0 || id > size()) {
            throw new IndexOutOfBoundsException(size()-1);
        }
        if (id == 0) {
            return root.data;
        }
        Node<E> current = root;
        for (int i = 1; i <= id; i++) {
            current = current.next;
        }
        return current.data;

    }

    public int size() {
        int size = 0;

        if (root == null)
            return 0;
        else {
            size = 1;

            Node<E> current = root;
            while (current.next != null) {
                size++;
                current = current.next;
            }
        }

        return size;
    }


    Node findLast() {
        if (root == null)
            return null;
        else {
            Node<E> current = root;

            while (current.next != null) {
                current = current.next;
            }

            return current;
        }
    }

    class Node<E> {
        public Node(E data) {
            this.data = data;
        }

        E data;
        Node next;
    }
}

