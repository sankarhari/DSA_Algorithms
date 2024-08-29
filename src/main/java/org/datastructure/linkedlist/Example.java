package org.datastructure.linkedlist;

import org.datastructure.linkedlist.impl.SLLNode;
import org.datastructure.linkedlist.impl.SinglyLinkedList;

import java.util.List;

public class Example {


    public static void main(String[] args){
        SinglyLinkedList<Integer> testSLL = new SinglyLinkedList<Integer>();

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

        testSLL.insertAfter(3, newNode4);
        System.out.println("\nList size: " + testSLL.size());
        testSLL.print();
        output = testSLL.toList();
        System.out.println(output);
    }
}
