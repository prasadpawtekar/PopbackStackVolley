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
import com.apolisrises.fragmentbackstackvolley.adapters.SubCategoryAdapter
import com.apolisrises.fragmentbackstackvolley.data.SubcategoriesResponse
import com.apolisrises.fragmentbackstackvolley.databinding.FragmentSubcategoriesBinding
import com.google.gson.Gson

class SubCategoriesFragment: Fragment() {
    lateinit var binding: FragmentSubcategoriesBinding
    lateinit var queue: RequestQueue
    var category_id = "-1"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubcategoriesBinding.inflate(inflater, container, false)
        queue = Volley.newRequestQueue(requireContext())
        binding.rvSubCategories.layoutManager = GridLayoutManager(requireContext(), 2)

        category_id = arguments?.getString("category_id") ?: "-1"
        loadSubCategories()

        return binding.root
    }

    private fun loadSubCategories() {

        val request = StringRequest(
            "https://psmobitech.com/myshop/index.php/SubCategory?category_id=$category_id",
            {
                val response = Gson().fromJson(it, SubcategoriesResponse::class.java)
                val adapter = SubCategoryAdapter(response.subcategories)
                binding.rvSubCategories.adapter = adapter

                adapter.setOnSubCategorySelectedListener { category, position ->
                    val productsFragment = ProductsFragment()
                    val bundle = Bundle()

                    bundle.putString("subcategory_id", category.subcategory_id)
                    productsFragment.arguments = bundle
                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, productsFragment)
                        .addToBackStack("pf")
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