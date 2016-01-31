package org.ifollowyou.spel.method;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Training {
    @Value("#{java.getName()}")
    private String javaTopic;

    @Value("#{listOfTopics.getTopicsList().size()}")
    private int totalTopics;

    @Value("#{java.getName().toUpperCase() == 'JavaThreads'.toUpperCase()}")
    private boolean hasThreadTutorial;

    @Value("#{listOfTopics.getTopicsList()[0]}")
    private Topic firstTopic;

    @Value("#{T(java.util.Arrays).asList(new org.ifollowyou.spel.method.Topic('Spring Data'), listOfTopics.getTopicsList()[0])}")
    private List<Topic> customTopics;        

    public String getJavaTopic() {
        return javaTopic;
    }

    public int getTotalTopics() {
        return totalTopics;
    }

    public boolean isHasThreadTutorial() {
        return hasThreadTutorial;
    }

    public Topic getFirstTopic() {
        return firstTopic;
    }

    public List<Topic> getCustomTopics() {
        return customTopics;
    }       

    public void setJavaTopic(String javaTopic) {
        this.javaTopic = javaTopic;
    }

    public void setTotalTopics(int totalTopics) {
        this.totalTopics = totalTopics;
    }

    public void setHasThreadTutorial(boolean hasThreadTutorial) {
        this.hasThreadTutorial = hasThreadTutorial;
    }

    public void setFirstTopic(Topic firstTopic) {
        this.firstTopic = firstTopic;
    }

    public void setCustomTopics(List<Topic> customTopics) {
        this.customTopics = customTopics;
    }

    public String toString() {
        return "Total topics: " + totalTopics + ", Java Topic: " + javaTopic
                + ", has thread tutorial: " + hasThreadTutorial
                + ", first topic: " + firstTopic + ", custom topics: "
                + customTopics;
    }
}
