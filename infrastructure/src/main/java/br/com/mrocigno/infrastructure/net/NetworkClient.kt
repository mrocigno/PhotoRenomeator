package br.com.mrocigno.infrastructure.net

import android.content.Context
import br.com.mrocigno.infrastructure.R
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    inline fun <reified T> makeService(context: Context) : T{
        val client = OkHttpClient.Builder().apply {
            addInterceptor (HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
        return createRetrofit(context, client)
    }

    inline fun <reified T> createRetrofit(context: Context, okHttpClient: OkHttpClient): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(T::class.java)
    }

}