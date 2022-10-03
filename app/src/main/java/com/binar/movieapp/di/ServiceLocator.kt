package com.binar.movieapp.di

import android.content.Context
import com.binar.movieapp.data.local.database.AppDatabase
import com.binar.movieapp.data.local.database.user.UserDao
import com.binar.movieapp.data.local.database.user.UserDataSource
import com.binar.movieapp.data.local.database.user.UserDataSourceImpl
import com.binar.movieapp.data.local.preference.UserPreference
import com.binar.movieapp.data.local.preference.UserPreferenceDataSource
import com.binar.movieapp.data.local.preference.UserPreferenceDataSourceImpl
import com.binar.movieapp.data.repository.LocalRepository
import com.binar.movieapp.data.repository.LocalRepositoryImpl

object ServiceLocator {

    private fun provideUserPreference(context: Context): UserPreference {
        return UserPreference(context)
    }

    private fun provideUserPreferenceDataSource(context: Context): UserPreferenceDataSource {
        return UserPreferenceDataSourceImpl(provideUserPreference(context))
    }

    private fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    private fun provideUserDao(context: Context): UserDao {
        return provideAppDatabase(context).userDao()
    }

    private fun provideUserDataSource(context: Context): UserDataSource {
        return UserDataSourceImpl(provideUserDao(context))
    }

    fun provideServiceLocator(context: Context): LocalRepository {
        return LocalRepositoryImpl(
            provideUserPreferenceDataSource(context),
            provideUserDataSource(context)
        )
    }
}