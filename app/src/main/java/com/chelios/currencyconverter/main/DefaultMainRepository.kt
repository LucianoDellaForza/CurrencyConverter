package com.chelios.currencyconverter.main

import com.chelios.currencyconverter.data.CurrencyApi
import com.chelios.currencyconverter.data.models.CurrencyResponse
import com.chelios.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor (
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(baseCurrency: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(baseCurrency)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}