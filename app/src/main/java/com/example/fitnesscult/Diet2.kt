package com.example.fitnesscult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
class Diet2 : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet2)


        webView = findViewById(R.id.diet2WebView)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                // This code block will execute after the WebView finishes loading the playlist URL.
                // You can use it to do additional customization or interaction with the WebView.
            }
        }

        webView.loadUrl("https://youtube.com/playlist?list=PLM9Ml8lOpxYAhOM8BaGIfRQZlhFGSYOrf")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
