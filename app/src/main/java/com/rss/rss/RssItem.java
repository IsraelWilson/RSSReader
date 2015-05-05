package com.rss.rss;

/**
 * Created by israe_000 on 5/4/2015.
 */
public class RssItem {

    String title;
    String link;

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getLink(){
        return this.link;
    }

    public void setLink(String link){
        this.link = link;
    }

    @Override
    public String toString(){
        return this.title;
    }
}
