package org.ifollowyou.hmk;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.ifollowyou.hmk.vo.Article;

import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) {
        try {
            //( 1 ) OBJECT --> XML
            FileWriter writer = new FileWriter("article.xml");

            // 不被建议使用静态方法
            //Marshaller.marshal(AppMapping.createArticle(), writer);

            Marshaller marshaller = new Marshaller(writer);
            marshaller.marshal(AppMapping.createArticle());
            writer.close();

            //( 2 ) XML --> OBJECT
            FileReader reader = new FileReader("article.xml");
            Article article = (Article) Unmarshaller.unmarshal(Article.class, reader);

            System.out.println(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
