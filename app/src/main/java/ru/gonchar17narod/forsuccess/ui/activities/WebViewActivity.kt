package ru.gonchar17narod.forsuccess.ui.activities

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_web_view.*
import ru.gonchar17narod.forsuccess.R
import ru.gonchar17narod.forsuccess.mvp.presenters.WebResultPresenter
import ru.gonchar17narod.forsuccess.mvp.views.WebResultView

class WebViewActivity : MvpActivity(), WebResultView {

    @InjectPresenter
    lateinit var webResultPresenter: WebResultPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        if(webResultPresenter.stateNotSaved()) webView.loadUrl(intent.getStringExtra("url"))
    }

    override fun onDestroy() {
        val state = Bundle()
        webView.saveState(state)
        webResultPresenter.saveState(state)
        super.onDestroy()
    }

    override fun restoreWebState(state: Bundle?) {
        webView.restoreState(state)
    }

    override fun onBackPressed() {
        if(webView.canGoBack())webView.goBack()
        else super.onBackPressed()
    }


}
