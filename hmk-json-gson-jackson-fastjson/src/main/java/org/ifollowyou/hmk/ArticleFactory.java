package org.ifollowyou.hmk;


public class ArticleFactory {

    public static Article createArticle() {

        Article article = new Article();

        article.setTitle("Jackson - Java to JSON & JSON to Java");
        article.setUrl("http://hmkcode.com/jackson-java-json");
        article.addCategory("Java");
        article.addTag("Java");
        article.addTag("Jackson");
        article.addTag("JSON");

        return article;
    }
}
