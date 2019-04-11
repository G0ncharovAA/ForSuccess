package ru.gonchar17narod.forsuccess.mvp.views

import android.os.Bundle
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WebResultView: MvpView {

    fun restoreWebState(state: Bundle?)

}