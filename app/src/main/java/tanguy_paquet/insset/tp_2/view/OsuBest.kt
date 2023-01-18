package tanguy_paquet.insset.tp_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.BestRecyclerBinding
import tanguy_paquet.insset.tp_2.databinding.ItemCustomRecyclerHeaderBinding
import tanguy_paquet.insset.tp_2.model.*
import java.lang.RuntimeException
import java.time.format.DateTimeFormatter

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {

    override fun areItemsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}

class OsuBestAdaptor : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(
    diffItemUtils
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                OsuBestViewHolder(
                    BestRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.HEADER.type -> {
                OsuBestHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("Wrong view type received $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as OsuBestViewHolder).bind(getItem(position) as BestUi)
            MyItemType.HEADER.type -> (holder as OsuBestHeaderViewHolder).bind(getItem(position) as HeaderUi)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is BestUi -> MyItemType.ROW.type
            is HeaderUi -> MyItemType.HEADER.type
        }
    }
}

class OsuBestViewHolder(
    private val binding: BestRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {
    var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")

    fun bind(BestUi: BestUi) {
        Glide.with(itemView.context)
            .load("https://assets.ppy.sh/beatmaps/"+BestUi.beatmapset_id+"/covers/cover@2x.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.beatmapImage)

        binding.count50.text = BestUi.count50
        binding.count100.text = BestUi.count100
        binding.count300.text = BestUi.count300
        binding.countmiss.text = BestUi.countmiss
        binding.pp.text = BestUi.pp
        /*if (BestUi.perfect == "1") {
            Glide.with(itemView.context)
            .load("https://b.ppy.sh/thumb/"+BestUi.beatmap_id+"l.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.perfectImage)
        }
        binding.score.text = BestUi.beatmapset_id
        binding.maxcombo.text = BestUi.maxcombo
        binding.date.text = BestUi.date.format(formatter)
        binding.rank.text = BestUi.rank
        */
        /*Glide.with(itemView.context)
            .load("https://a.ppy.sh/4717982")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.itemRecyclerViewImage)*/
            
    }
}

class OsuBestHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(HeaderUi: HeaderUi) {
        binding.itemRecyclerViewHeader.text = HeaderUi.header
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1)
}
