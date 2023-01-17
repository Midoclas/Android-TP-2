package tanguy_paquet.insset.tp_2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.ActivityRecyclerViewBinding
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.model.ProfileUi
import tanguy_paquet.insset.tp_2.viewmodel.BestViewModel
import tanguy_paquet.insset.tp_2.viewmodel.ProfileViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var bestAdapter: OsuBestAdaptor
    private lateinit var profileAdapter: OsuProfileAdaptor
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var bestViewModel: BestViewModel
    private lateinit var profileViewModel: ProfileViewModel


    private val BestListObserver = Observer<List<MyObjectForRecyclerView>> {
        bestAdapter.submitList(it)
    }
    private val ProfileListObserver = Observer<List<ProfileUi>> {
        profileAdapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bestViewModel = ViewModelProvider(this)[BestViewModel::class.java]
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        // Create the instance of adapter
        bestAdapter = OsuBestAdaptor()
        profileAdapter = OsuProfileAdaptor()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerViewProfile.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = bestAdapter
        binding.recyclerViewProfile.adapter = profileAdapter

        binding.addItemButton.setOnClickListener { addBestMaps() }
        binding.deleteAllItemButton.setOnClickListener { deleteBestMaps() }

    }

    private fun addBestMaps() {
        bestViewModel.insertOsuBest("4717982")
        addProfile()
    }

    private fun deleteBestMaps() {
        bestViewModel.deleteAllBest()
    }

    private fun addProfile() {
        profileViewModel.insertOsuProfile("4717982")
    }


    override fun onStart() {
        super.onStart()
        bestViewModel.mBestLiveData.observe(this, BestListObserver)
        profileViewModel.mProfileLiveData.observe(this, ProfileListObserver)
    }


    override fun onStop() {
        super.onStop()
        bestViewModel.mBestLiveData.removeObserver(BestListObserver)
        profileViewModel.mProfileLiveData.removeObserver(ProfileListObserver)
    }
}