package org.ifollowyou.hmk;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
public class Article {

    private String title;
    private String url;
    private List<String> categories;
    private List<String> tags;


    public void addCategory(String category) {
        if (this.categories == null)
            this.categories = new LinkedList<>();
        this.categories.add(category);
    }

    public void addTag(String tag) {
        if (this.tags == null)
            this.tags = new LinkedList<>();

        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return "Article [title=" + title + ", url=" + url + ", categories="
                + categories + ", tags=" + tags + "]";
    }


}
