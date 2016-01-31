package org.ifollowyou.spel.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringElPropertyBean {
    @Value("#{currentTopics.tutorialPrice * 2}")
    private Integer intProperty;

    @Value("#{currentTopics.programmingTutorial.name}")
    private String programmingTutorial;
    
    @Value("#{currentTopics.defaultTopics.size()}")
    private int topicsCount;
    
    @Value("#{T(org.ifollowyou.spel.property.Tutorial).MAIN_TOPIC}")
    private String mainTopic;
    
    @Value("#{new org.ifollowyou.spel.property.Tutorial('Spring Tutorials', {'Spring EL Property', 'Spring Context'})}")
    private Tutorial tutorial;

    public Integer getIntProperty() {
        return intProperty;
    }

    public String getProgrammingTutorial() {
        return programmingTutorial;
    }

    public int getTopicsCount() {
        return topicsCount;
    }

    public String getMainTopic() {
        return mainTopic;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }          
}
