package org.ifollowyou.hmk.xstream.vo;

import com.thoughtworks.xstream.annotations.*;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@XStreamAlias("article")
@Getter
@Setter
public class Article {

    @XStreamAsAttribute
    private String title;

    @XStreamAlias("address")
    private String url;

    @XStreamConverter(value = BooleanConverter.class, booleans = {false}, strings = {"yes", "no"})
    private boolean published;

    @XStreamOmitField
    private List<String> categories;

    @XStreamImplicit(itemFieldName = "tag")
    private List<String> tags;

    public void addCategory(String category) {
        if (this.categories == null)
            this.categories = new LinkedList<String>();
        this.categories.add(category);
    }

    public void addTag(String tag) {
        if (this.tags == null)
            this.tags = new LinkedList<String>();

        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return "Article [title=" + title + ",\nurl=" + url + ",\npublished="
                + published + ",\ncategories=" + categories + ",\ntags=" + tags
                + "]";
    }


}
