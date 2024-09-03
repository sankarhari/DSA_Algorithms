package org.datastructure.linkedlist.impl;

import org.datastructure.linkedlist.Node;

public class DLLNode<T> extends Node {
    private T value;
    private DLLNode<T> previousNode;
    private DLLNode<T> nextNode;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void setPreviousNode(DLLNode<T> node){
        this.previousNode = node;
    }

    public DLLNode<T> getPreviousNode(){
        return this.previousNode;
    }

    public void setNextNode(DLLNode<T> node){
        this.nextNode = node;
    }

    public DLLNode<T> getNextNode(){
        return this.nextNode;
    }
}
