package com.agung.uts

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.agung.uts.adapter.HospitalDataAdapter
import com.agung.uts.databinding.ActivityMain2Binding
import com.agung.uts.databinding.ActivityMainBinding
import com.agung.uts.entity.Hospital
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var hospitals=ArrayList<Hospital>()
    val hospitalDataAdapter=HospitalDataAdapter(hospitals)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager= GridLayoutManager(this,2)
        binding.hospitalRV.adapter=hospitalDataAdapter
        binding.hospitalRV.layoutManager=layoutManager
        hospitalDataAdapter.setHospitalDataListener(object:HospitalDataAdapter.HospitalDataListener{
            override fun cardClicked(hospital: Hospital) {
                val webUri= Uri.parse("https://www.google.com/maps/search/?api=1&query=${hospital.lokasi.lat},${hospital.lokasi.lon}")
                val intent=Intent(Intent.ACTION_VIEW,webUri)
                    startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        if (menu != null) {
            val search=menu.findItem(R.id.app_bar_search)
            val searchView=search.actionView as SearchView;
            val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//            (menu.findItem(R.id.app_bar_search).actionView as SearchView).apply {
//                // Assumes current activity is the searchable activity
//                setSearchableInfo(searchManager.getSearchableInfo(componentName))
//                setIconifiedByDefault(false) // Do not iconify the widget; expand it by default
//            }
            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    var list: List<Hospital> = hospitals.filter { s -> s.nama == p0 }
                    val intent=Intent(this@MainActivity,ActivityMain2Binding::class.java)
                    Toast.makeText(this@MainActivity,list[0].nama,Toast.LENGTH_SHORT).show()
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return true
                }

            })
        };
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout->{
                val intent=Intent(this@MainActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }R.id.app_bar_search->{
                R.id.app_bar_search
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onStart() {
        super.onStart()
        fetchHospitalData()
    }
    private fun fetchHospitalData(){
        val inputStream=assets.open("rs.json")
        val reader= JsonReader(InputStreamReader(inputStream,"UTF-8"))
        val gson= Gson()
        val data=gson.fromJson<Array<Hospital>>(reader,Array<Hospital>::class.java)
        hospitals.clear()
        hospitals.addAll(data)
        hospitalDataAdapter.notifyItemChanged(0)
    }
}