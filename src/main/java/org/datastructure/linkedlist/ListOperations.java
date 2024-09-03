package org.datastructure.linkedlist;

import java.util.List;

public interface ListOperations<N extends Node, T>{

    //Insert Element to a Linked List
    void add(N node);
    void insertAtBeginning(N node);
    void insertAtEnd(N node);
    void insertAfter(int position, N newNode);

    //Delete Elements from a Linked List
    void deleteNode(int position);

    //Search Element from a Linked List
    boolean search(T value);

    int size();

    void print();

    List<T> toList();
}
