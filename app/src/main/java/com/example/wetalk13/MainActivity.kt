package com.example.wetalk13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wetalk13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvBookListAdapter = BookListAdapter()

        binding.rvBookList.layoutManager = LinearLayoutManager(this)
        binding.rvBookList.adapter = rvBookListAdapter

        rvBookListAdapter.addBookList(BookListDummy.bookList)
    }
}