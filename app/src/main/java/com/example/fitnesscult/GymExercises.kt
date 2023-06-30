package com.example.fitnesscult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class GymExercises : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_exercises)


        webView = findViewById(R.id.gymExerciseWebView)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                // This code block will execute after the WebView finishes loading the playlist URL.
                // You can use it to do additional customization or interaction with the WebView.
            }
        }

        webView.loadUrl("https://youtube.com/playlist?list=PLM9Ml8lOpxYDK8FQoUVhDJumH9aqdr0FK")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
