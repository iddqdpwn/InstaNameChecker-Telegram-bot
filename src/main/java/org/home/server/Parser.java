package org.home.server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Parser {
    public static String getTitleFromUsername(String username) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.instagram.com/" + username).ignoreHttpErrors(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String title = doc.title();
        return title;
    }
}
