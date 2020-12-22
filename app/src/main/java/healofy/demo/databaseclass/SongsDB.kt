package healofy.demo.databaseclass

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs_db")
class SongsDB {

    @PrimaryKey(autoGenerate = true)
    var songsId: Long = 0L

    @ColumnInfo(name = "album")
    var album: String? = null

    @ColumnInfo(name = "artist")
    var artist: String? = null

    @ColumnInfo(name = "name")
    var name: String? = null
}