package tanguy_paquet.insset.tp_2.view

import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tanguy_paquet.insset.tp_2.databinding.ActivityRecyclerViewBinding
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.viewmodel.ProfileViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionAdapter
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var viewModel: ProfileViewModel

    private val profileListObserver = Observer<List<MyObjectForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

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
        viewModel.insertOsuProfileByUserId("4717982")
    }

    private fun deleteAndroidVersion() {
        viewModel.deleteAllAndroidVersion()
    }


    override fun onStart() {
        super.onStart()
        viewModel.mProfileLiveData.observe(this, profileListObserver)
    }


    override fun onStop() {
        super.onStop()
        viewModel.mProfileLiveData.removeObserver(profileListObserver)
    }
}