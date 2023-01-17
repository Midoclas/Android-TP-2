package tanguy_paquet.insset.tp_2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tanguy_paquet.insset.tp_2.databinding.ActivityRecyclerViewBinding
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.viewmodel.BestViewModel
import tanguy_paquet.insset.tp_2.viewmodel.ProfileViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var viewModel: BestViewModel


    private val profileListObserver = Observer<List<MyObjectForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[BestViewModel::class.java]

        // Create the instance of adapter
        adapter = AndroidVersionAdapter()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter

        binding.addItemButton.setOnClickListener { addBestMaps() }
        binding.deleteAllItemButton.setOnClickListener { deleteBestMaps() }

    }

    private fun addBestMaps() {
        viewModel.insertOsuBest("4717982")
    }

    private fun deleteBestMaps() {
        viewModel.deleteAllBest()
    }


    override fun onStart() {
        super.onStart()
        viewModel.mBestLiveData.observe(this, profileListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.mBestLiveData.removeObserver(profileListObserver)
    }
}