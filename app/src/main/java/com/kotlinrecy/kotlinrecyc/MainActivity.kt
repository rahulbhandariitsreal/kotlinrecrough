package com.kotlinrecy.kotlinrecyc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)


        WindowCompat.setDecorFitsSystemWindows(window, false)


       val vaccinelist= ArrayList<Myvaccine>()
        vaccinelist.add(Myvaccine("Coronoflox",R.drawable.aiwriting))
        vaccinelist.add(Myvaccine("Flixme",R.drawable.audiomusic))
        vaccinelist.add(Myvaccine("Convo",R.drawable.codegenerator))
        vaccinelist.add(Myvaccine("Detox",R.drawable.copy))
        vaccinelist.add(Myvaccine("Poly",R.drawable.durable))
        vaccinelist.add(Myvaccine("Noly",R.drawable.fliki))
        vaccinelist.add(Myvaccine("Gelloy",R.drawable.genmo))


        myAdapter= MyAdapter(this,vaccinelist)

        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.adapter=myAdapter

        setview(recyclerView)


    }

    fun setview(view: View) {

        ViewCompat.setOnApplyWindowInsetsListener(view) {view ,windowsInsets ->

            val insets=windowsInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin=insets.top
            }


WindowInsetsCompat.CONSUMED
        }

    }
    fun setviewme(view: View) {

        //assigning margin /padding to views to not overlap the system bars and guestre

        ViewCompat.setOnApplyWindowInsetsListener(view) { view,
                                                          windowsInsets ->
            val insets = windowsInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                bottomMargin = insets.bottom
                topMargin=insets.top
            }
            //floatingActionButton.updatePadding(insets.left,insets.top,insets.right,insets.bottom)
            WindowInsetsCompat.CONSUMED
        }
    }
}