package com.rss.rss;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by israe_000 on 5/4/2015.
 */
public class RssParserHandler extends DefaultHandler {

    private List<RssItem> rssItems;

    private RssItem currentItem;

    private boolean parsingTitle;

    private boolean parsingLink;

    RssParserHandler(){
        this.rssItems = new ArrayList<RssItem>();
    }

    public List<RssItem> getRssItems(){
        return this.rssItems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if("item".equals(qName)){
            currentItem = new RssItem();
        }
        else if("title".equals(qName)){
            parsingTitle = true;
        }
        else if("link".equals(qName)){
            parsingLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if("item".equals(qName)){
            rssItems.add(currentItem);
            currentItem = null;
        }
        else if("title".equals(qName)){
            parsingTitle = false;
        }
        else if("link".equals(qName)){
            parsingLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (parsingTitle) {
            if (currentItem != null)
                currentItem.setTitle(new String(ch, start, length));
        } else if (parsingLink) {
            if (currentItem != null) {
                currentItem.setLink(new String(ch, start, length));
                parsingLink = false;
            }
        }
    }
}
