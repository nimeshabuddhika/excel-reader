package com.github.nimeshabuddhika;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @author Nimesha Buddhika on 8/28/2019 10:59 AM
 */
public class Test {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        //InputStream targetStream = new FileInputStream(new File("C:\\Users\\Nimesha Buddhika\\Downloads\\temp_file.xlsx"));

        URL url = new URL("https://s3.us-south.objectstorage.softlayer.net/etihad/temp_file.xlsx");
        InputStream inputStream = url.openStream();
        ExcelReader reader = new ExcelReader();

        List<ImageDto> fileList = reader.read(ImageDto.class, inputStream);
        System.out.println(fileList.size());

        fileList.forEach(m ->
                System.out.println(m)
        );
    }
}
