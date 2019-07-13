package com.example.alc40challenge10app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlcActitvity extends AppCompatActivity {

    private WebView mAboutWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc_actitvity);
        mAboutWebView = findViewById(R.id.wbv_about_alc);
        mAboutWebView.getSettings().setJavaScriptEnabled(true);
        mAboutWebView.setWebViewClient(new WebViewClientUsingSsl());
        mAboutWebView.loadUrl("https://andela.com/alc/");

    }

    public class WebViewClientUsingSsl extends WebViewClient
    {
        @Override
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(AboutAlcActitvity.this);
            builder.setMessage("This " + error.getUrl() + getString(R.string.ssl_error_message));
            builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.proceed();
                }
            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.cancel();
                }
            });
            final AlertDialog dialog = builder.create();
            dialog.show();

        }
    }


}
