package com.rss.rss;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;

/**
 * Created by israe_000 on 5/4/2015.
 */
public class ListListener implements OnItemClickListener {

    List<RssItem> rssItems;
    Activity activity;

    public ListListener(List<RssItem> rssItems, Activity activity){
        this.rssItems = rssItems;
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(rssItems.get(position).getLink()));

        activity.startActivity(intent);
    }
}
