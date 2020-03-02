package com.example.basedemo.javaTest;

public abstract class mHuman implements mInter {
    public void main(String[] args) {
        eat();
        mHuman human = new man();//抽象类实现
        human.eat();
        human.mm();
    }

    void mm() {

    }
}
