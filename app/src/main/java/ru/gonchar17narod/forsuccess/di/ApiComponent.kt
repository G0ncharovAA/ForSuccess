package ru.gonchar17narod.forsuccess.di

import dagger.Component
import ru.gonchar17narod.forsuccess.mvp.presenters.ListOfResultsPresenter
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(listOfResultsPresenter: ListOfResultsPresenter)
}