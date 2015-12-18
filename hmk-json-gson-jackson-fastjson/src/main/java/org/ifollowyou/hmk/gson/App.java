package org.ifollowyou.hmk.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ifollowyou.hmk.Article;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import static org.ifollowyou.hmk.ArticleFactory.createArticle;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();

        List<Article> articles = new LinkedList<>();

        articles.add(createArticle());
        articles.add(createArticle());

        // Java --> JSON
        String json = gson.toJson(articles);
        System.out.println("toJson: " + json);


        // JSON --> Java
        List list = gson.fromJson(json, List.class);
        System.out.println("fromJson: " + list);
        System.out.println("Class Type: " + list.get(0).getClass());

        // JSON --> Java "Get the actual type"
        Type type = new TypeToken<List<Article>>() {
        }.getType();
        list = gson.fromJson(json, type);
        System.out.println("fromJson: " + list);
        System.out.println("Class Type: " + list.get(0).getClass());
    }
}