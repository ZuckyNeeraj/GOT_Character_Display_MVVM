package com.example.got_app_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.got_app_mvvm.ViewModel.ItemViewModel
import com.example.got_app_mvvm.databinding.ActivityMainBinding
import com.example.got_app_mvvm.model.DataItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DataAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rv
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = MyLayoutManager(this)

        adapter = DataAdapter()
        recyclerView.adapter = adapter

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        itemViewModel.getItems().observe(this) { items ->
            adapter.setData(items as ArrayList<DataItem>?)
        }
    }
}
