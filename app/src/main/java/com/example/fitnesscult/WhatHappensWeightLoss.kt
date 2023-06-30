package com.example.fitnesscult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WhatHappensWeightLoss : AppCompatActivity() {

    private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_happens_weight_loss)


        webView = findViewById(R.id.whatHappensWebView)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                // This code block will execute after the WebView finishes loading the playlist URL.
                // You can use it to do additional customization or interaction with the WebView.
            }
        }

        webView.loadUrl("https://www.youtube.com/playlist?list=PLM9Ml8lOpxYDJsKbWFf6P_ni7hwh0amaQ")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
