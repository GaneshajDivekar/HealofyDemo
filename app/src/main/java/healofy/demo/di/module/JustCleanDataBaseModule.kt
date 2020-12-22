package healofy.demo.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import healofy.demo.databaseclass.HealofyDB
import healofy.demo.databaseclass.SongsDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class JustCleanDataBaseModule {

    @Provides
    @Singleton
    fun provideJustCleanDB(application: Application?): HealofyDB {
        return Room.databaseBuilder(application!!, HealofyDB::class.java, "Favorite Database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun providePostsDao(healofyDB: HealofyDB): SongsDao {
        return healofyDB.songsDao()!!
    }
}