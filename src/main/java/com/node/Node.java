package com.node;

public  class   Node<T> {

    private Node p;
    private Node lc;
    private Node rc;
    private T date;

    public void Node(Node l,Node r,T date){

    }

    public Node getP() {
        return p;
    }

    public void setP(Node p) {
        this.p = p;
    }

    public Node getLc() {
        return lc;
    }

    public void setLc(Node lc) {
        this.lc = lc;
    }

    public Node getRc() {
        return rc;
    }

    public void setRc(Node rc) {
        this.rc = rc;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
