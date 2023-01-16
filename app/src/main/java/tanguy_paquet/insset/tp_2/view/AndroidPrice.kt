package tanguy_paquet.insset.tp_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.ItemCustomRecyclerBinding
import tanguy_paquet.insset.tp_2.databinding.ItemCustomRecyclerHeaderBinding
import tanguy_paquet.insset.tp_2.model.*
import tanguy_paquet.insset.tp_2.viewmodel.ProfileViewModel
import java.lang.RuntimeException

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {

    override fun areItemsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}

class AndroidVersionAdapter : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(
    diffItemUtils
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                AndroidVersionViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.HEADER.type -> {
                AndroidVersionHeaderViewHolder(
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
            MyItemType.ROW.type -> (holder as AndroidVersionViewHolder).bind(getItem(position) as ProfileUi)
            MyItemType.HEADER.type -> (holder as AndroidVersionHeaderViewHolder).bind(getItem(position) as HeaderUi)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ProfileUi -> MyItemType.ROW.type
            is HeaderUi -> MyItemType.HEADER.type
        }
    }
}

class AndroidVersionViewHolder(
    private val binding: ItemCustomRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ProfileUi: ProfileUi) {
        binding.itemRecyclerViewPhoneName.text = ProfileUi.username
        binding.itemRecyclerViewPrice.text = ProfileUi.user_id
        binding.itemRecyclerViewSS.text = ProfileUi.count_rank_ss
        binding.itemRecyclerViewS.text = ProfileUi.count_rank_s
        binding.itemRecyclerViewSSH.text = ProfileUi.count_rank_ssh
        binding.itemRecyclerViewSH.text = ProfileUi.count_rank_sh
        binding.itemRecyclerViewA.text = ProfileUi.count_rank_a
        Glide.with(itemView.context)
            .load("https://a.ppy.sh/4717982")
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.itemRecyclerViewImage)
    }
}

class AndroidVersionHeaderViewHolder(
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
