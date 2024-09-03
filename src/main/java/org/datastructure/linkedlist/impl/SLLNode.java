package org.datastructure.linkedlist.impl;

import org.datastructure.linkedlist.Node;

public class SLLNode<T> extends Node {
    private T value;
    private SLLNode<T> nextNode;

    public void setValue(T value){
        this.value = value;
    }

    public void setNextNode(SLLNode<T> node){
        this.nextNode = node;
    }

    public T getValue(){
        return this.value;
    }

    public SLLNode<T> getNextNode(){
        return this.nextNode;
    }
}
