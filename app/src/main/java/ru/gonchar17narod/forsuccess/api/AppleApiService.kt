package ru.gonchar17narod.forsuccess.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.gonchar17narod.forsuccess.mvp.models.AppleResults

interface AppleApiService {

    @GET("search")
    fun search(@Query("entity") entity: String,
               @Query("term") term: String):
             Observable<AppleResults>

}