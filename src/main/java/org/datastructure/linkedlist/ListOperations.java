package org.datastructure.linkedlist;

import org.datastructure.linkedlist.impl.SLLNode;

import java.util.List;

public interface ListOperations<T> {

    //Insert Element to a Linked List
    void add(SLLNode<T> node);
    void insertAtBeginning(SLLNode<T> node);
    void insertAtEnd(SLLNode<T> node);
    void insertAfter(int position, SLLNode<T> newNode);

    //Delete Elements from a Linked List
    void deleteNode(int position);

    //Search Element from a Linked List
    boolean search(T value);

    int size();

    void print();

    List<T> toList();
}
