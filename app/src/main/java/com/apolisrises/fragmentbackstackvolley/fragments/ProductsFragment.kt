package com.apolisrises.fragmentbackstackvolley.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.apolisrises.fragmentbackstackvolley.adapters.ProductsAdapter
import com.apolisrises.fragmentbackstackvolley.data.ProductsResponse
import com.apolisrises.fragmentbackstackvolley.databinding.FargmentProductsBinding
import com.google.gson.Gson

class ProductsFragment: Fragment() {
    lateinit var binding: FargmentProductsBinding
    var subCategoryId = "-1"
    lateinit var queue: RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FargmentProductsBinding.inflate(inflater, container, false)
        queue = Volley.newRequestQueue(requireContext())
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())

        subCategoryId = arguments?.getString("subcategory_id") ?: "-1"
        loadProducts()

        binding.btnGotoCategories.setOnClickListener {
            parentFragmentManager.popBackStack("sc", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        binding.btnGotoSubcategories.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }

    private fun loadProducts() {

        val request = StringRequest(
            "https://psmobitech.com/myshop/index.php/SubCategory/products/$subCategoryId",
            {
                val response = Gson().fromJson(it, ProductsResponse::class.java)
                val adapter = ProductsAdapter(response.products)
                binding.rvProducts.adapter = adapter
            },
            {
                Toast.makeText(requireContext(), "Error is: $it", Toast.LENGTH_SHORT).show()
                it.toString()
            }
        )

        queue.add(request)
    }
}