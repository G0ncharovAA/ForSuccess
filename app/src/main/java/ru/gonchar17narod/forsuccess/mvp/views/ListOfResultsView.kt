package ru.gonchar17narod.forsuccess.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.gonchar17narod.forsuccess.mvp.models.AppleResults

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ListOfResultsView: MvpView {

    fun showProgress();

    fun hideProgress();

    fun showResultsList(resultsList: List<AppleResults.Result>)

    fun showError(error: Throwable)

    fun hideError(error: Throwable)
}