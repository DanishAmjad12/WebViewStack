package com.webviewstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebView
import android.webkit.WebViewClient


class MainActivity : AppCompatActivity() {

    private var url="https://www.amazon.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.loadUrl(url)

        webview.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

                view?.loadUrl(url)

                return  true
            }
            override fun onPageFinished(view: WebView, url: String) {

            }
        }

    }

    override fun onBackPressed() {
        if (checkIfPageCanGoBack())
            webview.goBack()
        else
            finish()
    }

    private fun checkIfPageCanGoBack(): Boolean {
        return webview.canGoBack()
    }
}
