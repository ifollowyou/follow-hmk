package org.ifollowyou.spel.property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tutorial {
    public static final String MAIN_TOPIC = "SpringEL";
    private String name;    
    private List<String> defaultTopics = new ArrayList<>();
    private Map<String, String> hotTopics = new HashMap<String, String>();
    private Integer tutorialPrice;
    private Tutorial programmingTutorial;    

    public Tutorial(){}
    
    public Tutorial(String name, List<String> topicsList){
        this.name = name;
        this.defaultTopics = topicsList;
    }
    
    public Tutorial(List<String> topicsList){
        this.defaultTopics = topicsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public List<String> getDefaultTopics() {
        return defaultTopics;
    }

    public void setDefaultTopics(List<String> topicsList) {
        this.defaultTopics = topicsList;
    }

    public String toString() {
        return name + defaultTopics;
    }

    public Map<String, String> getHotTopics() {
        return hotTopics;
    }

    public void setHotTopics(Map<String, String> hotTopics) {
        this.hotTopics = hotTopics;
    }

    public Integer getTutorialPrice() {
        return tutorialPrice;
    }

    public void setTutorialPrice(Integer tutorialPrice) {
        this.tutorialPrice = tutorialPrice;
    }       
    
    public Tutorial getProgrammingTutorial() {
        return programmingTutorial;
    }

    public void setProgrammingTutorial(Tutorial programmingTutorial) {
        this.programmingTutorial = programmingTutorial;
    }
}
