package org.datastructure.linkedlist.impl;

public class SLLNode<T>{
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
