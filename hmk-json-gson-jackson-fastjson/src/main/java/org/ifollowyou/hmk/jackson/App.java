package org.ifollowyou.hmk.jackson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.ifollowyou.hmk.Article;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.ifollowyou.hmk.ArticleFactory.createArticle;

public class App {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            //POJO to JSON
            mapper.writeValue(new File("article.json"), createArticle());
            System.out.println("json created!");

            //JSON to POJO
            Article article = mapper.readValue(new File("article.json"), Article.class);
            System.out.println(article);

            //"Raw" Data Binding Example
            Map<String, Object> articleMap = mapper.readValue(new File("article.json"), Map.class);
            System.out.println(articleMap);

            //Data binding Collection<E>
            List<Article> articles = new LinkedList<Article>();

            articles.add(createArticle());
            articles.add(createArticle());

            mapper.writeValue(new File("articles.json"), articles);

            //( 1 ) Collection<Map>
            List result = mapper.readValue(new File("articles.json"), List.class);
            System.out.println(result.get(0).getClass());
            System.out.println(result);

            //( 2 ) Collection<Artilce>
            result = mapper.readValue(new File("articles.json"), new TypeReference<List<Article>>() {
            });
            System.out.println(result.get(0).getClass());
            System.out.println(result);

            System.out.println("---------------------------------------------------------");
            //Tree
            ObjectNode objectRoot = (ObjectNode) mapper.readTree(new File("article.json"));
            Iterator<String> fields = objectRoot.fieldNames();
            String field = "";
            while (fields.hasNext()) {
                field = fields.next();
                System.out.println("field: " + field);
            }
            System.out.println("---------------------------------------------------------");

            ArrayNode arrayRoot = (ArrayNode) mapper.readTree(new File("articles.json"));

            Iterator<JsonNode> elements = arrayRoot.elements();
            JsonNode element;

            while (elements.hasNext()) {
                element = elements.next();
                fields = element.fieldNames();
                field = "";
                while (fields.hasNext()) {
                    field = fields.next();
                    System.out.println("field: " + field);
                }

            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}