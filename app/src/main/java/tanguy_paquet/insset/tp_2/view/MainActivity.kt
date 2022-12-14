package tanguy_paquet.insset.tp_2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tanguy_paquet.insset.tp_2.databinding.ActivityRecyclerViewBinding
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.viewmodel.AndroidPriceViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var viewModel: AndroidPriceViewModel

    private val androidPriceListObserver = Observer<List<MyObjectForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AndroidPriceViewModel::class.java]

        // Create the instance of adapter
        adapter = AndroidVersionAdapter()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        binding.addItemButton.setOnClickListener { addRandomAndroidVersion() }
        binding.deleteAllItemButton.setOnClickListener { deleteAndroidVersion() }

    }

    private fun addRandomAndroidVersion() {
        val random = Random.nextInt(7, 12)
        var finalText = ""
        var finalUrl = ""

        if (random >= 10) {
            finalText = "Iphone"
            finalUrl = "data:image/jpeg;base64,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"
        } else {
            finalText = "Android"
            finalUrl = "data:image/jpeg;base64,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"
        }
        viewModel.insertAndroidVersion( "$finalText $random", random*100, finalUrl)
    }


    private fun deleteAndroidVersion() {
        viewModel.deleteAllAndroidVersion()
    }


    override fun onStart() {
        super.onStart()
        viewModel.androidVersionList.observe(this, androidPriceListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.androidVersionList.removeObserver(androidPriceListObserver)
    }
}