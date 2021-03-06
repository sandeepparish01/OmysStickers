package com.omys.stickerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.omys.stickerapp.modal.StickerPackInfoModal
import com.omys.stickerapp.modal.StickerPackModal

@Database(entities =
[StickerPackModal::class, StickerPackInfoModal::class], version = 1)
abstract class OmysDatabase : RoomDatabase() {

    abstract fun stickerPacksDatabase(): StickerPacksDao

    companion object {
        private var INSTANCE: OmysDatabase? = null
        private val DATABASE_NAME = "omys_stickers"

        fun getDatabase(context: Context?): OmysDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context?.applicationContext!!,
                        OmysDatabase::class.java, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE as OmysDatabase
        }
    }
}
