package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        List<String> fileData = new ArrayList<>();
        try (FileInputStream fileStream = new FileInputStream(file)) {
            fileData = Arrays.asList( new String(fileStream.readAllBytes()).split("\n"));
        } catch (IOException e) {
            return profile;
        }
        try {
            profile.setName(fileData.get(0).split("[ :]")[2].trim());
            profile.setAge(Integer.parseInt(fileData.get(1).split("[ :]")[2].trim()));
            profile.setEmail(fileData.get(2).split("[ :]")[2].trim());
            profile.setPhone(Long.parseLong(fileData.get(3).split("[ :]")[2].trim()));
        }
        catch (NumberFormatException e){
            return profile;
        }
        return profile;
    }
}
