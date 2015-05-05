package com.rss.rss;

import android.content.Context;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by israe_000 on 5/4/2015.
 */
public class RssReader {

    private String rssUrl;
    Context context;

    RssReader(String rssUrl){
        this.rssUrl = rssUrl;
    }

    public List<RssItem> getItems() throws Exception {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        RssParserHandler handler = new RssParserHandler();

        saxParser.parse(rssUrl, handler);

        return handler.getRssItems();
    }
}
