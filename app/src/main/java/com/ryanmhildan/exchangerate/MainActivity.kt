//Pengerjaan terakhir : 18/05/2025 19:50
//NIM                 : 10122475
//NAMA                : Ryan Muhammad Hildan
//KELAS               : PA-4

package com.ryanmhildan.exchangerate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanmhildan.exchangerate.adapter.ListCountryAdapter
import com.ryanmhildan.exchangerate.model.Country

class MainActivity : AppCompatActivity() {

    private lateinit var rvExchange: RecyclerView
    private val list = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvExchange = findViewById(R.id.rv_exchange)
        rvExchange.setHasFixedSize(true)

        list.addAll(getListCountry())
        showRecyclerList()

    }

    private fun getListCountry(): ArrayList<Country> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataBuy = resources.getStringArray(R.array.data_buy)
        val dataSell = resources.getStringArray(R.array.data_sell)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listCountry = ArrayList<Country>()
        for (i in dataName.indices) {
            val country = Country(dataName[i], dataBuy[i], dataSell[i], dataPhoto.getResourceId(i, -1))
            listCountry.add(country)
        }
        return listCountry
    }

    private fun showRecyclerList(){

        val listCountryAdapter = ListCountryAdapter(list){data ->
            showSelectedCountry(data)
        }

        listCountryAdapter.setOnItemClickCallback(object : ListCountryAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Country) {
                showSelectedCountry(data)
            }
        })

        rvExchange.layoutManager = LinearLayoutManager(this)
        rvExchange.adapter = listCountryAdapter
        rvExchange.setHasFixedSize(true)

    }

    private fun showSelectedCountry(country: Country){
//        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("COUNTRY_OBJECT", country)
        startActivity(intent)

    }

}