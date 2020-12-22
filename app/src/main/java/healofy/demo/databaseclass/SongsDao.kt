package healofy.demo.databaseclass

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SongsDao {

    @Insert
    fun insertData(songsDB: SongsDB)

    @Query("SELECT * FROM songs_db")
    fun getSongs(): LiveData<List<SongsDB>>


}