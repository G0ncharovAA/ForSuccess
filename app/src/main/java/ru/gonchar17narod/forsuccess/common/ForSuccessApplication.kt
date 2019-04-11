package ru.gonchar17narod.forsuccess.common

import android.app.Application
import ru.gonchar17narod.forsuccess.di.ApiComponent
import ru.gonchar17narod.forsuccess.di.ApiModule
import ru.gonchar17narod.forsuccess.di.DaggerApiComponent

class ForSuccessApplication: Application() {


    companion object {
        lateinit var apiComponent: ApiComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule("https://itunes.apple.com/"))
            .build()
    }

}