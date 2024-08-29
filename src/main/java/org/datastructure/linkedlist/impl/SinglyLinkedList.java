package org.datastructure.linkedlist.impl;

import org.datastructure.linkedlist.ListOperations;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> implements ListOperations<T> {
    private SLLNode<T> headNode;
    private SLLNode<T> endNode;
    private int size = 0;

    @Override
    public void add(SLLNode<T> node) {
        insertAtEnd(node);
    }

    @Override
    public void insertAtBeginning(SLLNode<T> node){

        if(this.headNode == null){
            this.endNode = node;
        }
        else {
            node.setNextNode(this.headNode);
        }
        this.headNode = node;
        this.size++;
    }

    @Override
    public void insertAtEnd(SLLNode<T> node){
        if(this.headNode == null){
            this.headNode = node;
        }
        else
        {
            this.endNode.setNextNode(node);
        }
        this.endNode = node;
        this.size++;
    }

    @Override
    public void insertAfter(int position, SLLNode<T> node){
        if(position > this.size){
            System.out.println("Invalid Position. List size is: " + this.size);
        }
        else if(position == 0)
        {
            node.setNextNode(this.headNode);
            this.headNode = node;
            this.size++;
        }
        else
        {
            int counter = 0;
            SLLNode<T> currentNode = this.headNode;
            SLLNode<T> prevNode = null;
            while(counter <= this.size + 1){
                if(counter == position)
                {
                    prevNode.setNextNode(node);
                    node.setNextNode(currentNode);
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
            this.size--;
        }
        else
        {
            int counter = 0;
            SLLNode<T> currentNode = this.headNode;
            SLLNode<T> prevNode = null;
            while(counter <= this.size){
                if(counter == position)
                {
                    prevNode.setNextNode(currentNode.getNextNode());
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
            SLLNode<T> current = this.headNode;
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
            SLLNode<T> current = this.headNode;
            while (true) {
                System.out.print(current.getValue() + " -> ");
                current = current.getNextNode();
                if (current == null) {
                    System.out.print("NULL");
                    break;
                }
            }
        }
    }

    @Override
    public List<T> toList(){
        List<T> output = new ArrayList<>();
        if(this.headNode != null){
            SLLNode<T> current = this.headNode;
            while (true) {
                output.add(current.getValue());
                current = current.getNextNode();
                if (current == null) {
                    break;
                }
            }
        }
        return output;
    }
}
