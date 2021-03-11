package com.chelios.currencyconverter.main

import com.chelios.currencyconverter.data.models.CurrencyResponse
import com.chelios.currencyconverter.util.Resource

interface MainRepository {

    suspend fun getRates(base: String): Resource<CurrencyResponse>
}