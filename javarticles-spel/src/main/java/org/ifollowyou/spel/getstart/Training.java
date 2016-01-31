package org.ifollowyou.spel.getstart;

import org.springframework.beans.factory.annotation.Value;

public class Training {
    private Topic topic;
    
    @Value("#{tutorial.topicsList[0]}")
    private Topic defaultTopic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    
    public Topic getDefaultTopic() {
        return defaultTopic;
    }
}
