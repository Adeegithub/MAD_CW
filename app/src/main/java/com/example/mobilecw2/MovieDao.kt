package com.example.mobilecw2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface MovieDao {
    @Query("Select * from MovieEntity")
    suspend fun getAll():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(vararg movieEntity: MovieEntity)

//    @Insert
//    suspend fun insertAll(vararg movies: MovieEntity)

    @Query("DELETE FROM MovieEntity")
    suspend fun deleteAll()


    @Query("Select title from MovieEntity WHERE actors LIKE '%' || :value || '%' ")
    suspend fun findActors(value: String):List<String>

}