package org.datastructure.linkedlist;

import junit.framework.TestCase;
import org.datastructure.linkedlist.impl.SLLNode;
import org.datastructure.linkedlist.impl.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class SingleLinkedListTest extends TestCase {

    public SinglyLinkedList<Integer> createList(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();

        SLLNode<Integer> node5 = new SLLNode<>();
        node5.setValue(5);
        sll.add(node5);

        SLLNode<Integer> node3 = new SLLNode<>();
        node3.setValue(3);
        sll.insertAtEnd(node3);

        SLLNode<Integer> node12 = new SLLNode<>();
        node12.setValue(12);
        sll.insertAtBeginning(node12);

        SLLNode<Integer> node20 = new SLLNode<>();
        node20.setValue(20);
        sll.insertAfter(1, node20);

        SLLNode<Integer> node10 = new SLLNode<>();
        node10.setValue(10);
        sll.insertAtEnd(node10);
        return sll;
    }

    public void testInsertOperation(){
        List<Integer> expected = List.of(12,20,5,3,10);

        SinglyLinkedList<Integer> sll = createList();

        List<Integer> output = sll.toList();

        assertIterableEquals(expected, output);
    }

    public void testDeleteOperation(){

        List<Integer> expected = List.of(5,3);

        SinglyLinkedList<Integer> sll = createList();

        sll.deleteNode(1);

        sll.deleteNode(0);

        sll.deleteNode(2);

        List<Integer> output = sll.toList();

        assertIterableEquals(expected, output);
    }

}
