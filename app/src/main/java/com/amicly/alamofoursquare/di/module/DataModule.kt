package com.amicly.alamofoursquare.di.module

import android.content.Context
import android.content.SharedPreferences
import com.amicly.alamofoursquare.common.scheduler.AppSchedulerProvider
import com.amicly.alamofoursquare.common.scheduler.SchedulerProvider
import com.amicly.alamofoursquare.data.remote.FourSquareService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by darrankelinske on 2/11/18.
 */

@Module
class DataModule {
    private val PREFS_NAME = "AlamoPreferences"

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(context: Context): OkHttpClient {
        val httpCacheDirectory = File(context.cacheDir, "responses")
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(httpCacheDirectory, cacheSize.toLong())

        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(ResponseCacheInterceptor())
                .addInterceptor(ClientIdInterceptor())
                .cache(cache)
                .connectTimeout(33, TimeUnit.SECONDS)
                .readTimeout(33, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.foursquare.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, 0)
    }

    @Provides
    @Singleton
    internal fun provideSeatGeekService(retrofit: Retrofit): FourSquareService {
        return retrofit.create(FourSquareService::class.java)
    }
    @Provides
    @Singleton
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    private inner class ResponseCacheInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val request = originalRequest.newBuilder()
            val response = chain.proceed(request.build())
            return response.newBuilder()
                    .header("Cache-Control", "public, max-age=7777777")
                    .build()
        }
    }

    private inner class ClientIdInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            val httpUrl = request.url().newBuilder()
                    .addQueryParameter("client_id", "RV5EALWWU2UQEAXUQVIEKFSNJBI55PFPCMIGS2450YPFD0TZ")
                    .addQueryParameter("client_secret", "MVJONWL2OTLGKSO0U0KNCD1H2XJVPRW4IKBBKOFZ1AJ4TX4P")
                    .addQueryParameter("v", "20180323")
                    .build()
            request = request.newBuilder().url(httpUrl).build()
            return chain.proceed(request)
        }
    }
}
