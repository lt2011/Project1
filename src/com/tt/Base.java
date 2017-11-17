package com.tt;

class Base {
    
    private String name = "base";

    public Base() {
        tellName();
        printName();
        myMethod();
    }
    
    public void tellName() {
        System.out.println("Base tell name: " + name);
    }
    
    public void printName() {
        System.out.println("Base print name: " + name);
    }
    public void myMethod() {
		System.out.println("Base method: " + name);
	}
}
