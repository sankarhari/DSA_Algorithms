package org.datastructure.linkedlist;

import junit.framework.TestCase;
import org.datastructure.linkedlist.impl.DLLNode;
import org.datastructure.linkedlist.impl.DoublyLinkedList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DoublyLinkedListTest extends TestCase {

    public DoublyLinkedList<Integer> createList(){
        DoublyLinkedList<Integer> DLL = new DoublyLinkedList<>();

        DLLNode<Integer> node5 = new DLLNode<>();
        node5.setValue(5);
        DLL.add(node5);

        DLLNode<Integer> node3 = new DLLNode<>();
        node3.setValue(3);
        DLL.insertAtEnd(node3);

        DLLNode<Integer> node12 = new DLLNode<>();
        node12.setValue(12);
        DLL.insertAtBeginning(node12);

        DLLNode<Integer> node20 = new DLLNode<>();
        node20.setValue(20);
        DLL.insertAfter(1, node20);

        DLLNode<Integer> node10 = new DLLNode<>();
        node10.setValue(10);
        DLL.insertAtEnd(node10);
        return DLL;
    }

    public void testInsertOperation(){
        List<Integer> expected = List.of(12,20,5,3,10);

        DoublyLinkedList<Integer> DLL = createList();

        List<Integer> output = DLL.toList();

        assertIterableEquals(expected, output);
    }

    public void testDeleteOperation(){

        List<Integer> expected = List.of(5,3);

        DoublyLinkedList<Integer> DLL = createList();

        DLL.deleteNode(1);

        DLL.deleteNode(0);

        DLL.deleteNode(2);

        List<Integer> output = DLL.toList();

        assertIterableEquals(expected, output);
    }

    public void testReverseOperation(){
        List<Integer> expected = List.of(10,3,5,20,12);

        DoublyLinkedList<Integer> DLL = createList();

        List<Integer> output = DLL.toReverseList();

        assertIterableEquals(expected, output);
    }

}
