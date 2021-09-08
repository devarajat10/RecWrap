package com.example.recwrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recwrap.adapter.SampleAdapter
import com.example.recwrap.databinding.ActivityMainBinding
import com.example.recwrap.model.PeopleModel
import com.example.recwrap.model.TeamsModel
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var mDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView<ViewDataBinding>(
            this,
            R.layout.activity_main
        ) as ActivityMainBinding

        val arrayList = getData()
        val arrayList2 = getData2()
        // Layout Manager
        mDataBinding.recylerview.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,false
        )

        // Adapter
        mDataBinding.recylerview.adapter = SampleAdapter(this, arrayList,arrayList2)


    }

    private fun getData(): ArrayList<PeopleModel> {
        val arrayList: ArrayList<PeopleModel> = ArrayList()
        arrayList.add(PeopleModel("CR7", "Man U"))
        arrayList.add(PeopleModel("Messi", "PSG"))
        arrayList.add(PeopleModel("Hazard", "Real madrid"))
        arrayList.add(PeopleModel("Haaland", "Dortmund"))
        arrayList.add(PeopleModel("Griezmann", "Atlético madrid"))

        return arrayList
    }

    private fun getData2(): ArrayList<TeamsModel> {
        val arrayList: ArrayList<TeamsModel> = ArrayList()
        arrayList.add(TeamsModel("England", "Man U"))
        arrayList.add(TeamsModel("France", "PSG"))
        arrayList.add(TeamsModel("Spain ", "Real madrid"))
        arrayList.add(TeamsModel("Germany", "Dortmund"))
        arrayList.add(TeamsModel("Spain", "Atlético madrid"))

        return arrayList
    }
}