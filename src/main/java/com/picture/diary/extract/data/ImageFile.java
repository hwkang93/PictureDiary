package com.picture.diary.extract.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.File;

@Builder
@AllArgsConstructor
@Getter
public class ImageFile {

    private String fileName;
    private Extensions extension;
    private long fileSize;

    private String filePath;
    private ImageMetadata imageMetadata;

    public ImageFile(File file) {
        String fileName = file.getName();

        this.fileName = fileName;
        this.extension = Extensions.findOf(fileName);
        this.fileSize = file.length();
        this.filePath = file.getPath();
    }
    
    public void changeFilePath(String path) {
    	this.filePath = path;
    }
}
