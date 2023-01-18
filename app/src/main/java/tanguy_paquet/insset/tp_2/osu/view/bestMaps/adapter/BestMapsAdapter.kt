package tanguy_paquet.insset.tp_2.view.bestMaps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.BestRecyclerBinding
import tanguy_paquet.insset.tp_2.databinding.ItemCustomRecyclerHeaderBinding
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.model.BestMapsUi
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.model.BestMapsUiObject
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.model.HeaderUi
import java.lang.RuntimeException
import java.time.format.DateTimeFormatter

private val diffItemUtils = object : DiffUtil.ItemCallback<BestMapsUiObject>() {

    override fun areItemsTheSame(oldItem: BestMapsUiObject, newItem: BestMapsUiObject): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BestMapsUiObject, newItem: BestMapsUiObject): Boolean {
        return oldItem == newItem
    }
}

class BestMapsAdapter : ListAdapter<BestMapsUiObject, RecyclerView.ViewHolder>(
    diffItemUtils
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                BestMapsViewHolder(
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
            MyItemType.ROW.type -> (holder as BestMapsViewHolder).bind(getItem(position) as BestMapsUi)
            MyItemType.HEADER.type -> (holder as OsuBestHeaderViewHolder).bind(getItem(position) as HeaderUi)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is BestMapsUi -> MyItemType.ROW.type
            is HeaderUi -> MyItemType.HEADER.type
        }
    }
}

class BestMapsViewHolder(
    private val binding: BestRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {
    var formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")

    fun bind(BestMapsUi: BestMapsUi) {
        Glide.with(itemView.context)
            .load("https://assets.ppy.sh/beatmaps/"+BestMapsUi.beatmapset_id+"/covers/cover@2x.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.beatmapImage)

        binding.count50.text = BestMapsUi.count50
        binding.count100.text = BestMapsUi.count100
        binding.count300.text = BestMapsUi.count300
        binding.countmiss.text = BestMapsUi.countmiss
        binding.pp.text = BestMapsUi.pp
        /*if (BestMapsUi.perfect == "1") {
            Glide.with(itemView.context)
            .load("https://b.ppy.sh/thumb/"+BestMapsUi.beatmap_id+"l.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.perfectImage)
        }
        binding.score.text = BestMapsUi.beatmapset_id
        binding.maxcombo.text = BestMapsUi.maxcombo
        binding.date.text = BestMapsUi.date.format(formatter)
        binding.rank.text = BestMapsUi.rank
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
