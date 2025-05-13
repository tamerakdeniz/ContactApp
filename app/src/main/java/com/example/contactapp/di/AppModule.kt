package com.example.contactapp.di

import com.example.contactapp.data.datasource.KisilerDataSource
import com.example.contactapp.data.repo.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton

    fun provideKisilerRepository(kisilerDataSource: KisilerDataSource) : KisilerRepository {
        return KisilerRepository(kisilerDataSource)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource() : KisilerDataSource {
        return KisilerDataSource()
    }



}