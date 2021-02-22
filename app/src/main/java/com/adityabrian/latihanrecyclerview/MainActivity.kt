package com.adityabrian.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/** INTERFACE ITU , implementasi dalam sebuah method yang harus tersedia dalam sebuah objek
 *  SUPAYA BIAR MEMUDAHKAN DAN Method TERLIHAT SIMPLE*/

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<SuperHero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_superhero.setHasFixedSize(true)
        list.addAll(getListSuperHero())
        rv_superhero.layoutManager = LinearLayoutManager(this)
        val superHeroAdapter = SuperHeroAdapter(list)
        rv_superhero.adapter = superHeroAdapter

        /** Terapkannya disini */
        superHeroAdapter.setOnItemWithCallback(object : SuperHeroAdapter.OnItemClickCallback {
            override fun onItemClick(data: SuperHero) {
                Toast.makeText(this@MainActivity, data.deskripsi, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getListSuperHero(): ArrayList<SuperHero> {
        val name = resources.getStringArray(R.array.data_name)
        val desc = resources.getStringArray(R.array.data_desc)

        val listSuperHero = ArrayList<SuperHero>()
        for (i in name.indices){
            val superhero =SuperHero(
                name[i],
                desc[i]
            )
            listSuperHero.add(superhero)
        }
        return listSuperHero
    }
}