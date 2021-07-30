package com.example.githubapi

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.githubapi.utils.Utils
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val title=intent.getStringExtra(Utils.title)
       // val description=intent.getStringExtra(Utils.descripton)
        val url=intent.getStringExtra(Utils.url)
        val image=intent.getStringExtra(Utils.image)

        text_title_detailed.text=title
       // text_desc_detailed.text=description
        Glide.with(this).load(image).into(imageView2)


        webView = findViewById(R.id.web_view_detalied)
        webView.settings.setJavaScriptEnabled(true)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}