package org.ifollowyou.spel.method;

import java.util.ArrayList;
import java.util.List;

public class ListOfTopics {
    private String name;
    
    private List<Topic> topicsList = new ArrayList<Topic>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public List<Topic> getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(List<Topic> topicsList) {
        this.topicsList = topicsList;
    }

    public String toString() {
        return name + topicsList;
    }    
}
