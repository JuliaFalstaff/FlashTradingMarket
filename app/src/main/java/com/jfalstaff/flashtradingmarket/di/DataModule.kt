package com.jfalstaff.flashtradingmarket.di

import android.app.Application
import androidx.room.Room
import com.jfalstaff.data.network.ApiFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindUserRepository(impl: com.jfalstaff.data.repository.UserRepositoryImpl): com.jfalstaff.domain.IUserRepository

    @ApplicationScope
    @Binds
    fun bindRepository(impl: com.jfalstaff.data.repository.RepositoryImpl): com.jfalstaff.domain.IRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideDataBase(
            application: Application
        ): com.jfalstaff.data.database.UserDao {
            return Room.databaseBuilder(
                application,
                com.jfalstaff.data.database.UserDataBase::class.java,
                DATABASE_NAME
            ).build().userDao()
        }

        @ApplicationScope
        @Provides
        fun provideApiService(): com.jfalstaff.data.network.ApiService {
            return ApiFactory.api
        }
    }
}