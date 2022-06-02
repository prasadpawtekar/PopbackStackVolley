package com.apolisrises.fragmentbackstackvolley.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.apolisrises.fragmentbackstackvolley.R
import com.apolisrises.fragmentbackstackvolley.adapters.CategoryAdapter
import com.apolisrises.fragmentbackstackvolley.data.CategoriesResponse
import com.apolisrises.fragmentbackstackvolley.databinding.FragmentCategoriesBinding
import com.google.gson.Gson

class CategoriesFragment: Fragment() {
    lateinit var binding: FragmentCategoriesBinding
    lateinit var queue: RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        queue = Volley.newRequestQueue(requireContext())
        binding.rvCategories.layoutManager = GridLayoutManager(requireContext(), 2)
        loadCategories()


        return binding.root
    }

    private fun loadCategories() {

        val request = StringRequest(
            "https://psmobitech.com/myshop/index.php/Category",
            {
                val response = Gson().fromJson(it, CategoriesResponse::class.java)
                val adapter = CategoryAdapter(response.categories)
                binding.rvCategories.adapter = adapter

                adapter.setOnCategorySelectedListener { category, position ->

                    val subCatFragment = SubCategoriesFragment()
                    val bundle = Bundle()
                    bundle.putString("category_id", category.category_id)
                    subCatFragment.arguments = bundle

                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, subCatFragment)
                        .addToBackStack("sc")  // Here we set name to fragment to added
                        .commit()
                }
            },
            {
                Toast.makeText(requireContext(), "Error is: $it", Toast.LENGTH_SHORT).show()
                it.toString()
            }
        )

        queue.add(request)
    }
}