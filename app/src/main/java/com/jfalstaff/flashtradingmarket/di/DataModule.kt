package com.jfalstaff.flashtradingmarket.di

import android.app.Application
import androidx.room.Room
import com.jfalstaff.flashtradingmarket.data.database.UserDao
import com.jfalstaff.flashtradingmarket.data.database.UserDataBase
import com.jfalstaff.flashtradingmarket.data.network.ApiFactory
import com.jfalstaff.flashtradingmarket.data.network.ApiService
import com.jfalstaff.flashtradingmarket.data.repository.RepositoryImpl
import com.jfalstaff.flashtradingmarket.data.repository.UserRepositoryImpl
import com.jfalstaff.flashtradingmarket.domain.IRepository
import com.jfalstaff.flashtradingmarket.domain.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindUserRepository(impl: UserRepositoryImpl): IUserRepository

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): IRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideDataBase(
            application: Application
        ): UserDao {
            return Room.databaseBuilder(
                application,
                UserDataBase::class.java,
                DATABASE_NAME
            ).build().userDao()
        }

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.api
        }
    }
}