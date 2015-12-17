package org.ifollowyou.hmk;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;
import org.ifollowyou.hmk.vo.Article;

import java.io.*;


public class AppMapping {
    private static final String XML_MAPPING = "file:mapping.xml";
    private static final String XML_OUTPUT = "mapped_article.xml";

    public static void main(String[] args) {
        try {
            //Load Mapping
            Mapping mapping = new Mapping();
            mapping.loadMapping(XML_MAPPING);
            XMLContext context = new XMLContext();
            context.addMapping(mapping);

            //( 1 ) OBJECT --> XML

            //1.1 Prepare file writer
            Writer writer = new FileWriter(XML_OUTPUT);

            //1.2 Create a new Marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setWriter(writer);

            //1.3 Marshal "map" to xml
            marshaller.marshal(createArticle());

            //1.4
            writer.close();


            //( 2 ) XML --> OBJECT

            //2.1 Prepare file writer
            Reader reader = new FileReader(XML_OUTPUT);

            //2.2 Create a new Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setClass(Article.class);

            //2.3 Unmarshal "map" to Object
            Article article = (Article) unmarshaller.unmarshal(reader);

            //2.4
            reader.close();

            System.out.println(article);

        } catch (IOException | MappingException | MarshalException | ValidationException e) {
            e.printStackTrace();
        }
    }

    public static Article createArticle() {
        Article article = new Article();

        article.setTitle("Castor - Java Object to XML & XML to Object Mapping");
        article.setUrl("http://hmkcode.com/castor-java-object-xml");
        article.addCategory("Java");
        article.addTag("Java");
        article.addTag("Castor");
        article.addTag("XML");
        article.addTag("Marshalling");
        article.addTag("Unmarshalling");

        return article;
    }
}
