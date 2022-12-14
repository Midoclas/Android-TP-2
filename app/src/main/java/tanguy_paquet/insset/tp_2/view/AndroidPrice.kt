package tanguy_paquet.insset.tp_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.databinding.ItemCustomRecyclerBinding
import tanguy_paquet.insset.tp_2.databinding.ItemCustomRecyclerHeaderBinding
import tanguy_paquet.insset.tp_2.model.ObjectDataHeaderSample
import tanguy_paquet.insset.tp_2.model.ObjectDataSample
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
            MyItemType.ROW.type -> (holder as AndroidVersionViewHolder).bind(getItem(position) as ObjectDataSample)
            MyItemType.HEADER.type -> (holder as AndroidVersionHeaderViewHolder).bind(getItem(position) as ObjectDataHeaderSample)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ObjectDataSample -> MyItemType.ROW.type
            is ObjectDataHeaderSample -> MyItemType.HEADER.type
        }
    }
}

class AndroidVersionViewHolder(
    private val binding: ItemCustomRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(objectDataSample: ObjectDataSample) {
        binding.itemRecyclerViewPhoneName.text = objectDataSample.name
        binding.itemRecyclerViewPrice.text = "${objectDataSample.price} €"
        Glide.with(itemView.context)
            .load(objectDataSample.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.itemRecyclerViewImage)
    }
}

class AndroidVersionHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSample: ObjectDataHeaderSample) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1)
}
