package com.example.testttapplication.di


import com.example.testttapplication.data.network.JokesApiService
import com.example.testttapplication.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * retrofit module to provide core network dependencies.
 */

val retrofitModule = module {

    fun provideNetworkService(retrofit: Retrofit): JokesApiService {
        return retrofit.create(JokesApiService::class.java)
    }

    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    factory { provideNetworkService(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideHttpLoggingInterceptor() }
    factory { provideRetrofit(get()) }
}
