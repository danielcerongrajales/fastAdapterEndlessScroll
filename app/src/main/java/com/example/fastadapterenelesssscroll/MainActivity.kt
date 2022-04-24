package com.example.fastadapterenelesssscroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastadapterenelesssscroll.databinding.ActivityMainBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter.Companion.items
import com.mikepenz.fastadapter.scroll.EndlessRecyclerOnScrollListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fastItemAdapter: GenericFastItemAdapter
    private lateinit var footerAdapter: GenericItemAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fastItemAdapter = FastItemAdapter()
        footerAdapter = items()

        fastItemAdapter.addAdapter(1, footerAdapter)

        val simpleItemList: MutableList<SimpleItem> = ArrayList()
        simpleItemList.add(SimpleItem("Yudi", "CoderJava"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        simpleItemList.add(SimpleItem("Setiawan", "CoderKotlin"))
        fastItemAdapter.add(simpleItemList)


        binding.recyclerView.adapter = fastItemAdapter
        val NEWITEMS: MutableList<SimpleItem> = ArrayList()
        NEWITEMS.add(SimpleItem("nuevo Yudi", "CoderJava"))
        NEWITEMS.add(SimpleItem("nuevo Setiawan", "CoderKotlin"))



        binding.recyclerView.layoutManager = LinearLayoutManager(this);





        binding.recyclerView.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener(footerAdapter) {
            override fun onLoadMore(currentPage: Int) {

                lifecycleScope.launch(Dispatchers.Main) {

                    footerAdapter.clear()
                    footerAdapter.add(ProgressItem())
                    delay(1000)
                    fastItemAdapter.add(NEWITEMS)
                }

            }
        })

    }
}