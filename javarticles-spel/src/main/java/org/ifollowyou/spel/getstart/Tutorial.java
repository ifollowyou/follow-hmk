package org.ifollowyou.spel.getstart;

import java.util.ArrayList;
import java.util.List;

public class Tutorial {
    private String name;
    
    private List<?> topicsList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public List<?> getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(List<?> topicsList) {
        this.topicsList = topicsList;
    }

    public String toString() {
        return name + topicsList;
    }
    
}
