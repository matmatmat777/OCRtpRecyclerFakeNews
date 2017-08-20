package com.example.mathieu.openclassroomexorecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class ReadNewsActivity extends AppCompatActivity {
    public static final String ARTICLE_TITLE = "title";
    public static final String ARTICLE_HTML_CONTENT = "htmlContent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_read_news);

        String title = getIntent().getStringExtra(ARTICLE_TITLE);
        String htmlContent = getIntent().getStringExtra(ARTICLE_HTML_CONTENT);

        setTitle(title);

        WebView webView = (WebView) findViewById(R.id.webView);

        webView.loadData(htmlContent, "text/html; charset=UTF-8", null);


    }

}
