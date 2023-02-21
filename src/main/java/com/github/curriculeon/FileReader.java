package com.github.curriculeon;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    private final String filename;

    public FileReader(String filename){
        this.filename = filename;
    }

    @Override
    public String toString(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        StringBuilder result = new StringBuilder();
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }catch(IOException e){
            throw new Error(e);
        }
        return result.toString();
    }

}

