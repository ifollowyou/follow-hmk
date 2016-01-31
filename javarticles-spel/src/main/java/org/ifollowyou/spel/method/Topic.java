package org.ifollowyou.spel.method;

public class Topic {
    private String name;
    
    public Topic(){}

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }
}
