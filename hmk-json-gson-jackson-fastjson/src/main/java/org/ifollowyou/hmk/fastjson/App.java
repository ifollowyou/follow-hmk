package org.ifollowyou.hmk.fastjson;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.ifollowyou.hmk.Article;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.ifollowyou.hmk.ArticleFactory.createArticle;

public class App {

    public static void main(String[] args) throws IOException {

        String fileName = "article.json";

        // 将对象输出JSON文本
        JSONWriter jsonWriter = new JSONWriter(new FileWriter(fileName));
        // 美化JSON格式
        jsonWriter.config(SerializerFeature.PrettyFormat, true);
        jsonWriter.writeObject(createArticle());
        jsonWriter.flush();
        jsonWriter.close();

        // 将JSON文本转换为具体对象
        JSONReader jsonReader = new JSONReader(new FileReader(fileName));
        Article article = jsonReader.readObject(Article.class);
        jsonReader.close();
        System.out.println(article);

        // 将JSON文本转换为Map对象
        jsonReader = new JSONReader(new FileReader(fileName));
        Map<String, Object> articleMap = jsonReader.readObject(Map.class);
        System.out.println(articleMap);

        // 输出集合对象到JSON文本中
        List<Article> articles = new LinkedList<>();
        articles.add(createArticle());
        articles.add(createArticle());

        fileName = "articles.json";
        jsonWriter = new JSONWriter(new FileWriter(fileName));
        jsonWriter.config(SerializerFeature.PrettyFormat, true);
        jsonWriter.writeValue(articles);
        jsonWriter.flush();
        jsonWriter.close();

        // 读取集合数据普通类型
        jsonReader = new JSONReader(new FileReader(fileName));
        List result = jsonReader.readObject(List.class);
        jsonReader.close();
        System.out.println(result.get(0).getClass());
        System.out.println(result);

        // 读取集合数据为具体类型
        jsonReader = new JSONReader(new FileReader(fileName));
        result = jsonReader.readObject(new TypeReference<List<Article>>(){});
        jsonReader.close();
        System.out.println(result.get(0).getClass());
        System.out.println(result);
    }
}
