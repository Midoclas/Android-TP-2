package tanguy_paquet.insset.tp_2.osu.domain.profile.model

data class ProfileDomain(
    val user_id: String,
    val username: String,
    val level: String,
    val accuracy: String,
    val count_rank_ss: String,
    val count_rank_ssh: String,
    val count_rank_s: String,
    val count_rank_sh: String,
    val count_rank_a: String,
    val country: String,
    val pp_rank: String,
    val pp_country_rank: String
)
