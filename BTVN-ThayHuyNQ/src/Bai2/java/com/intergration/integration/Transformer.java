package com.intergration.integration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;

@Component
public class Transformer {

    public String transform(String filePath) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        String str = Normalizer.normalize(content, Normalizer.Form.NFKD);
        String regex = "[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+";

        String myStr = new String(str.replaceAll(regex, "").getBytes("ascii"), "ascii");
        myStr = myStr.toUpperCase();
        return myStr;

    }
}
