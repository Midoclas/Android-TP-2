package tanguy_paquet.insset.tp_2.osu.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tanguy_paquet.insset.tp_2.databinding.ActivityRecyclerViewBinding
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.model.BestMapsUiObject
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.viewModel.BestViewModel
import tanguy_paquet.insset.tp_2.osu.view.profile.model.ProfileUi
import tanguy_paquet.insset.tp_2.osu.view.profile.viewModel.ProfileViewModel
import tanguy_paquet.insset.tp_2.view.bestMaps.adapter.BestMapsAdapter
import tanguy_paquet.insset.tp_2.view.profile.adapter.ProfileAdapter

class OsuMainActivity: AppCompatActivity() {
    private lateinit var bestAdapter: BestMapsAdapter
    private lateinit var profileAdapter: ProfileAdapter
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var bestViewModel: BestViewModel
    private lateinit var profileViewModel: ProfileViewModel


    private val bestMapsListObserver = Observer<List<BestMapsUiObject>> {
        bestAdapter.submitList(it)
    }
    private val profileListObserver = Observer<List<ProfileUi>> {
        profileAdapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bestViewModel = ViewModelProvider(this)[BestViewModel::class.java]
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        // Create the instance of adapter
        bestAdapter = BestMapsAdapter()
        profileAdapter = ProfileAdapter()

        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerViewProfile.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        binding.recyclerView.adapter = bestAdapter
        binding.recyclerViewProfile.adapter = profileAdapter

        binding.addItemButton.setOnClickListener { init() }
        binding.deleteAllItemButton.setOnClickListener { deleteBestMaps() }

    }

    @SuppressLint("CheckResult")
    override fun onStart() {
        super.onStart()
        init()

        intent.getStringExtra("username")
            ?.let { profileViewModel.mProfileLiveData(it).observe(this, profileListObserver) }
        bestViewModel.mBestLiveData.observe(this, bestMapsListObserver)

    }


    override fun onStop() {
        super.onStop()
        bestViewModel.mBestLiveData.removeObserver(bestMapsListObserver)
        intent.getStringExtra("username")
            ?.let { profileViewModel.mProfileLiveData(it).removeObserver(profileListObserver) }
    }

    private fun init() {
        bestViewModel.deleteAllBest()
        intent.getStringExtra("username")?.let { bestViewModel.insertBestMaps(it) }
        intent.getStringExtra("username")?.let { profileViewModel.insertOsuProfile(it) }
    }

    private fun deleteBestMaps() {
        bestViewModel.deleteAllBest()
        profileViewModel.deleteProfile()
    }
}