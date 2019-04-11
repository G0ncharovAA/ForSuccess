package ru.gonchar17narod.forsuccess.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_list.*
import ru.gonchar17narod.forsuccess.R
import ru.gonchar17narod.forsuccess.mvp.models.AppleResults
import ru.gonchar17narod.forsuccess.mvp.presenters.ListOfResultsPresenter
import ru.gonchar17narod.forsuccess.mvp.views.ListOfResultsView
import ru.gonchar17narod.forsuccess.ui.adapters.ResultsAdapter

class ListActivity: MvpActivity(), ListOfResultsView {

    @InjectPresenter
    lateinit var listOfResultsPresenter: ListOfResultsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list)

        myRecyclerView.setHasFixedSize(true)
        myRecyclerView.layoutManager = LinearLayoutManager(this);

        buttonSearch.setOnClickListener { listOfResultsPresenter.askForSearch(editSearch.text.toString()) }
    }


    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showResultsList(resultsList: List<AppleResults.Result>) {
        myRecyclerView.adapter = ResultsAdapter(resultsList)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
    }

    override fun hideError(error: Throwable) {}
}