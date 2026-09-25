package com.example.quizgame.data

import com.example.quizgame.domain.QuizRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesQuizRepository(
        gson: Gson
    ): QuizRepository {
        return FakeQuizRepository(gson)
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson().newBuilder().create()
    }
}