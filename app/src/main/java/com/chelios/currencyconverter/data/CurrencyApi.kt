package com.chelios.currencyconverter.data

import com.chelios.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/latest")
    suspend fun getRates(
        @Query("base") baseCurrency: String
    ): Response<CurrencyResponse>
}