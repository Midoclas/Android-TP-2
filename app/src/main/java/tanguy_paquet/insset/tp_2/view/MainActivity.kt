package tanguy_paquet.insset.tp_2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tanguy_paquet.insset.tp_2.databinding.ActivityRecyclerViewBinding
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.model.ObjectDataHeaderSample
import tanguy_paquet.insset.tp_2.model.ObjectDataSample
import tanguy_paquet.insset.tp_2.view.AndroidVersionAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the instance of adapter
        adapter = AndroidVersionAdapter()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }

    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            ObjectDataSample("Galaxy M04", 100),
            ObjectDataSample("Galaxy Tab A7", 120),
            ObjectDataSample("Galaxy Tab Active4 Pro", 230),
            ObjectDataSample("Galaxy Z Flip4", 450),
            ObjectDataSample("Galaxy A13", 600),
            ObjectDataSample("Galaxy S20", 700),
            ObjectDataSample("Galaxy A33 5G", 750),
            ObjectDataSample("Galaxy F23", 900),
            ObjectDataSample("Iphone 9", 4000),
            ObjectDataSample("Iphone 10", 5500),
            ObjectDataSample("Iphone 11", 8000),
            ObjectDataSample("Iphone 12", 9999),
        ).groupBy {
            it.price > 1000
        }.forEach { (iphone, items) ->
            var final = ""
            final = if (iphone) {
                "Iphone"
            } else {
                "Android"
            }
            result.add(ObjectDataHeaderSample(final))
            result.addAll(items)
        }
        return result
    }
}
