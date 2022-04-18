package com.example.mobilecw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ViewDatabase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_database)

        val tvDb = findViewById<TextView>(R.id.tvDb)
        tvDb.setText("")

        val db = Room.databaseBuilder(this, MovieDatabase ::class.java,"mydatabase").build()
        val movieDao = db.movieDao()


        runBlocking {
            launch {
                //tvDb.text = movieDao.getAll().toString()
                val movies: List<MovieEntity> = movieDao.getAll()
                for (M in movies) {
                    tvDb.append("\n ${M.title} ${M.year} ${M.rated} ${M.released} ${M.runtime} ${M.genre} ${M.director} ${M.writer} ${M.actors} ${M.plot}")
                }
            }
        }
    }
}
