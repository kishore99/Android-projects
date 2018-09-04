package com.example.kishore_yuva.lyrix.Widget;

import android.content.Intent;
import android.widget.RemoteViewsService;


public class LyricsWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new LyricsViewsFactory(this);
    }
}
