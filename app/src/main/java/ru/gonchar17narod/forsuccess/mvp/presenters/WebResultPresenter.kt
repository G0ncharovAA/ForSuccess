package ru.gonchar17narod.forsuccess.mvp.presenters

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.gonchar17narod.forsuccess.mvp.views.WebResultView


@InjectViewState
class WebResultPresenter: MvpPresenter<WebResultView>()  {


    private var webState: Bundle? = null


    fun saveState(state: Bundle){
        webState = state
    }

    fun stateNotSaved():Boolean{
        if(webState == null) return true

        viewState.restoreWebState(webState)
        return false
    }
}