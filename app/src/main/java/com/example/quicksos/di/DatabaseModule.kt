package com.example.quicksos.di

import android.content.Context
import androidx.room.Room
import com.example.quicksos.data.db.database.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideContactsDatabase(@ApplicationContext context: Context): ContactsDatabase {
        return Room.databaseBuilder(
            context,
            ContactsDatabase::class.java,
            "contacts_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideContactDao(contactsDatabase: ContactsDatabase) = contactsDatabase.contactDao()
}