package org.datastructure.linkedlist.impl;

import org.datastructure.linkedlist.ListOperations;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> implements ListOperations<DLLNode<T>, T> {
    private DLLNode<T> headNode;
    private DLLNode<T> tailNode;
    private int size = 0;
    
    @Override
    public void add(DLLNode<T> node) {
        insertAtEnd(node);
    }

    @Override
    public void insertAtBeginning(DLLNode<T> node){
        if(this.headNode == null){
            this.tailNode = node;
        }
        else{
            node.setNextNode(this.headNode);
            this.headNode.setPreviousNode(node);
        }
        this.headNode = node;
        this.size++;
    }

    @Override
    public void insertAtEnd(DLLNode<T> node) {
        if (this.headNode == null) {
            this.headNode = node;
        } else {
            this.tailNode.setNextNode(node);
            node.setPreviousNode(this.tailNode);
        }
        this.tailNode = node;
        this.size++;
    }

    @Override
    public void insertAfter(int position, DLLNode<T> node){
        if(position > this.size){
            System.out.println("Invalid Position. List size is: " + this.size);
        }
        else if(position == 0)
        {
            this.headNode.setPreviousNode(node);
            node.setNextNode(this.headNode);
            this.headNode = node;
            this.size++;
        }
        else
        {
            int counter = 0;
            DLLNode<T> currentNode = this.headNode;
            DLLNode<T> prevNode = null;
            while(counter <= this.size + 1){
                if(counter == position)
                {
                    prevNode.setNextNode(node);
                    node.setPreviousNode(prevNode);
                    node.setNextNode(currentNode);
                    currentNode.setPreviousNode(node);
                    this.size++;
                    break;
                }
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
                counter++;
            }
        }
    }

    @Override
    public void deleteNode(int position){
        if(position > this.size - 1){
            System.out.println("Invalid Position. List size is: " + this.size);
        }
        else if(position == 0)
        {
            this.headNode = this.headNode.getNextNode();
            this.headNode.setPreviousNode(null);
            this.size--;
        }
        else
        {
            int counter = 0;
            DLLNode<T> currentNode = this.headNode;
            DLLNode<T> prevNode = null;
            while(counter <= this.size){
                if(counter == position)
                {
                    prevNode.setNextNode(currentNode.getNextNode());
                    if(currentNode.getNextNode() != null) {
                        currentNode.getNextNode().setPreviousNode(prevNode);
                    }
                    else
                    {
                        this.tailNode = prevNode;
                    }
                    this.size--;
                    break;
                }
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
                counter++;
            }
        }
    }

    @Override
    public boolean search(T value){
        if(this.headNode == null){
            return false;
        }
        else {
            boolean isNextNode = true;
            DLLNode<T> current = this.headNode;
            while (isNextNode) {
                if(current.getValue() == value){
                    return true;
                }
                current = current.getNextNode();
                if (current == null) {
                    isNextNode = false;
                }
            }
            return false;
        }
    }

    @Override
    public int size(){
        return this.size;
    }


    @Override
    public void print(){
        if(this.headNode == null){
            System.out.println("List is empty");
        }
        else {
            DLLNode<T> currentNode = this.headNode;
            System.out.print("NULL <-> ");
            while(true)
            {
                System.out.print(currentNode.getValue() + " <-> ");
                currentNode = currentNode.getNextNode();
                if(currentNode == null)
                {
                    System.out.println("NULL");
                    break;
                }
            }
        }
    }

    public void printReverse(){
        if(this.headNode == null){
            System.out.println("List is empty");
        }
        else {
            DLLNode<T> currentNode = this.tailNode;
            System.out.print("NULL <-> ");
            while(true)
            {
                System.out.print(currentNode.getValue() + " <-> ");
                currentNode = currentNode.getPreviousNode();
                if(currentNode == null)
                {
                    System.out.println("NULL");
                    break;
                }
            }
        }
    }

    @Override
    public List<T> toList(){
        List<T> output = new ArrayList<>();
        DLLNode<T> currentNode = this.headNode;
        while(true)
        {
            output.add(currentNode.getValue());
            currentNode = currentNode.getNextNode();
            if(currentNode == null)
            {
                break;
            }
        }
        return output;
    }

    public List<T> toReverseList(){
        List<T> output = new ArrayList<>();
        DLLNode<T> currentNode = this.tailNode;
        while(true)
        {
            output.add(currentNode.getValue());
            currentNode = currentNode.getPreviousNode();
            if(currentNode == null)
            {
                break;
            }
        }
        return output;
    }
}
