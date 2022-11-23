package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class FileServiceImpl implements FileService{
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File fileLocation = new File("src/main/resources/uploaded.txt");
      //  String path = currentDir.getAbsolutePath();
      //  String fileLocation = path.substring(0, path.length()-1)+"uploadedFile.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
        fileOutputStream.write(buffer);

    }
}
