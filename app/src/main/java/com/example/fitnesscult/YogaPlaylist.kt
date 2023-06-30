package com.example.fitnesscult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient


class YogaPlaylist : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_playlist)


        webView = findViewById(R.id.yogaPlaylist)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                // This code block will execute after the WebView finishes loading the playlist URL.
                // You can use it to do additional customization or interaction with the WebView.
            }
        }

        webView.loadUrl("https://youtube.com/playlist?list=PLM9Ml8lOpxYBgCU3dWDCmsmLVjW4KZmbZ")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
