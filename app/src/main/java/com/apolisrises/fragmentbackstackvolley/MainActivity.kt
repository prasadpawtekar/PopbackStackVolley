package com.apolisrises.fragmentbackstackvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apolisrises.fragmentbackstackvolley.databinding.ActivityMainBinding
import com.apolisrises.fragmentbackstackvolley.fragments.CategoriesFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var categoryFragment: CategoriesFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryFragment = CategoriesFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, categoryFragment)
            .commit()

    }
}