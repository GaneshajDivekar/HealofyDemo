package healofy.demo.databaseclass

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [SongsDB::class], version = 1, exportSchema = false)
abstract class HealofyDB : RoomDatabase() {
    abstract fun songsDao(): SongsDao?
}