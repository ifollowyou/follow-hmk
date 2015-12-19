package org.ifollowyou.hmk.upload.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;


@JsonIgnoreProperties({"content"})
@Setter
@Getter
public class FileMeta {

    private String fileName;
    private String fileSize;
    private String fileType;
    private String twitter;
    private InputStream content;

    @Override
    public String toString() {
        return "FileMeta [fileName=" + fileName + ", fileSize=" + fileSize
                + ", fileType=" + fileType + "]";
    }

}
