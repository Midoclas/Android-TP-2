package tanguy_paquet.insset.tp_2.osu.data.profile.mapper

import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRetrofit
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom

fun ArrayList<ProfileRetrofit>.toRoom(): List<ProfileRoom> {
    return map {
        ProfileRoom(
            user_id = it.user_id,
            username = it.username,
            level = it.level,
            accuracy = it.accuracy,
            count_rank_ss = it.count_rank_ss,
            count_rank_ssh = it.count_rank_ssh,
            count_rank_s = it.count_rank_s,
            count_rank_sh = it.count_rank_sh,
            count_rank_a = it.count_rank_a,
            country = it.country,
            pp_rank = it.pp_rank,
            pp_country_rank = it.pp_country_rank
        )
    }
}