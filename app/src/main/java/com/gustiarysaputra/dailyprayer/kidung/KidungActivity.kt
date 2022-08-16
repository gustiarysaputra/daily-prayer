package com.gustiarysaputra.dailyprayer.kidung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gustiarysaputra.dailyprayer.R

class KidungActivity : AppCompatActivity() {

    private lateinit var kidungRecyclerView: RecyclerView
    private lateinit var kidungArrayList: ArrayList<KidungData>
    lateinit var title: Array<String>
    lateinit var urlYT: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kidung)

        kidungRecyclerView = findViewById(R.id.recycler_view_kidung)
        kidungRecyclerView.layoutManager = LinearLayoutManager(this)
        kidungRecyclerView.setHasFixedSize(true)

        kidungArrayList = arrayListOf<KidungData>()

        title = arrayOf(
            "Pupuh Ginada Linggar Petak",
            "Kidung Purwakaning",
            "kidung kawitan wargasari",
            "Kidung Pitra Yadnya",
            "Kidung Turun Tirta ",
            "KIDUNG LELAYUNGAN BALA UGU",
            "Kidung Sekar Gadung",
            "Pupuh Agal Sudamala",
            "kidung jagadhita",
            "Kidung Merdu Komala",
        )
        urlYT = arrayOf(
            "ECiuULAZ3ns",
            "7hFusk72oQA",
            "fSTMtBoLmF4",
            "0aoZrG2c9Wk",
            "G46gDhDtstg",
            "a0rjPqHFBUU",
            "LDvicQsx8qc",
            "QQeoFFTr1Zo",
            "nemEq5zRvYU",
            "qOYXorRg9sU",
        )
        getKidungData()
    }
    private fun getKidungData(){
        for (i in title.indices){
            val pray = KidungData(title[i], urlYT[i], "By Youtube")
            kidungArrayList.add(pray)
        }

        val adapter = KidungAdapter(kidungArrayList)
        kidungRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : KidungAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@KidungActivity, "$position", Toast.LENGTH_SHORT).show()
            }
        })
    }
}