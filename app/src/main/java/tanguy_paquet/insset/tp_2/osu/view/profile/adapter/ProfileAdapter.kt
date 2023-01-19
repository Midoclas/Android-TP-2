package tanguy_paquet.insset.tp_2.view.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tanguy_paquet.insset.tp_2.R
import tanguy_paquet.insset.tp_2.databinding.ItemProfileRecyclerBinding
import tanguy_paquet.insset.tp_2.osu.view.profile.model.ProfileUi

private val diffItemUtils = object : DiffUtil.ItemCallback<ProfileUi>() {

    override fun areItemsTheSame(oldItem: ProfileUi, newItem: ProfileUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProfileUi, newItem: ProfileUi): Boolean {
        return oldItem == newItem
    }
}

class ProfileAdapter : ListAdapter<ProfileUi, ProfileViewHolder>(
    diffItemUtils
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            ItemProfileRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProfileViewHolder(
    private val binding: ItemProfileRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ProfileUi: ProfileUi) {
        binding.pseudo.text = ProfileUi.username
        binding.userId.text = ProfileUi.user_id
        binding.scoreSS.text = ProfileUi.count_rank_ss
        binding.scoreS.text = ProfileUi.count_rank_s
        binding.scoreSSH.text = ProfileUi.count_rank_ssh
        binding.scoreSH.text = ProfileUi.count_rank_sh
        binding.scoreA.text = ProfileUi.count_rank_a
        Glide.with(itemView.context)
            .load("https://a.ppy.sh/"+ProfileUi.user_id)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.avatar)
            
    }
}