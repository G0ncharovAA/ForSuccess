package ru.gonchar17narod.forsuccess.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.gonchar17narod.forsuccess.api.AppleApiService
import ru.gonchar17narod.forsuccess.common.ForSuccessApplication
import ru.gonchar17narod.forsuccess.mvp.models.AppleResults
import ru.gonchar17narod.forsuccess.mvp.views.ListOfResultsView
import javax.inject.Inject

@InjectViewState
class ListOfResultsPresenter(): MvpPresenter<ListOfResultsView>() {


    private lateinit var result: AppleResults

    @Inject
    lateinit var appleApiService: AppleApiService

    init {
       ForSuccessApplication.apiComponent.inject(this)
    }

    fun askForSearch(string: String){
        viewState.showProgress()
        appleApiService.search("software", string).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                showResult(result)
            }, { error ->
                showError(error)
            })


      /*  val apiService = AppleApiService.create()
        apiService.search("software", string).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                    result ->
                showResult(result)
            }, { error ->
                showError(error)
            })*/
    }

    fun showResult(result: AppleResults){
        this.result = result
        viewState.hideProgress()
        viewState.showResultsList(this.result.results)
    }

    fun showError(error: Throwable){
        viewState.hideProgress()
        viewState.showError(error)
    }

    fun hideError(error: Throwable){
        viewState.hideError(error)
    }
}