package com.example.apploja.CodigoGeral.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.apploja.CodigoGeral.Adapter.ProductAdapter
import com.example.apploja.CodigoGeral.viewModels.MainViewModel
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apploja.R
import com.example.apploja.configureToolbar

class HomeFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val listOfProducts = mainViewModel.getProducts()
        productAdapter = ProductAdapter(listOfProducts) {
            val bundle = bundleOf("data" to it)
            findNavController().navigate(R.id.action_homeFragment_to_productDetailActivity, bundle)
        }

        recycler.adapter = productAdapter
    }
}