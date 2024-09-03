package org.datastructure.example;

import org.datastructure.linkedlist.impl.DLLNode;
import org.datastructure.linkedlist.impl.DoublyLinkedList;
import org.datastructure.linkedlist.impl.SLLNode;
import org.datastructure.linkedlist.impl.SinglyLinkedList;

import java.util.List;

public class LinkedListExample {


    public static void main(String[] args){
        SinglyLinkedList<Integer> testSLL = new SinglyLinkedList<>();

        List<Integer> output;

        testSLL.print();

        SLLNode<Integer> newNode = new SLLNode<>();
        newNode.setValue(10);

        SLLNode<Integer> newNode2 = new SLLNode<>();
        newNode2.setValue(40);

        SLLNode<Integer> newNode3 = new SLLNode<>();
        newNode3.setValue(50);

//
        testSLL.insertAtBeginning(newNode3);
        testSLL.insertAtEnd(newNode2);
        testSLL.add(newNode);


        output = testSLL.toList();
        System.out.println(output);

        System.out.println("Search 30: " + testSLL.search(30));
        System.out.println("List size: " + testSLL.size());
        testSLL.print();

        testSLL.deleteNode(0);
        System.out.println("\nList size: " + testSLL.size());
        testSLL.print();

        SLLNode<Integer> newNode4 = new SLLNode<>();
        newNode4.setValue(13);

        System.out.println("\n\n==========Double Linked List==============\n\n");

        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();

        testDLL.print();

        DLLNode<Integer> newNd= new DLLNode<>();
        newNd.setValue(10);

        DLLNode<Integer> newNd2 = new DLLNode<>();
        newNd2.setValue(40);

        DLLNode<Integer> newNd3 = new DLLNode<>();
        newNd3.setValue(50);

        testDLL.add(newNd);
        testDLL.add(newNd3);
        testDLL.insertAtBeginning(newNd2);

        testDLL.print();
        testDLL.printReverse();
        System.out.println(testDLL.toList());

        DLLNode<Integer> nd5 = new DLLNode<>();
        nd5.setValue(30);

        testDLL.insertAfter(1, nd5);

        testDLL.print();
        testDLL.printReverse();
        System.out.println("List size: " + testDLL.size());

        System.out.println("Searching 60: " +testDLL.search(30));
        System.out.println("Searching 60: " +testDLL.search(60));

        testDLL.deleteNode(1);

        testDLL.print();
        testDLL.printReverse();
        System.out.println("List size: " + testDLL.size());

    }
}
