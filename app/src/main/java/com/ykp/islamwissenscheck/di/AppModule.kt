package com.ykp.islamwissenscheck.di

import android.content.Context
import com.ykp.islamwissenscheck.network.QuestionApi
import com.ykp.islamwissenscheck.repository.DataStoreRepoImpl
import com.ykp.islamwissenscheck.repository.DatastoreRepo
import com.ykp.islamwissenscheck.repository.QuestionRepository
import com.ykp.islamwissenscheck.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi) = QuestionRepository(api)


    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }

    @Singleton
    @Provides
    fun providesDatastoreRepo(
        @ApplicationContext context: Context
    ): DatastoreRepo = DataStoreRepoImpl(context)
}