package tanguy_paquet.insset.tp_2.osu.data.bestMaps.mapper

import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRetrofit
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom

fun ArrayList<BestMapsRetrofit>.toRoom(): List<BestMapsRoom> {
    return map {
        BestMapsRoom(
            beatmap_id = it.beatmap_id,
            score = it.score,
            maxcombo = it.maxcombo,
            count50 = it.count50,
            count100 = it.count100,
            count300 = it.count300,
            countmiss = it.countmiss,
            perfect = it.perfect,
            enabled_mods = it.enabled_mods,
            user_id = it.user_id,
            date = it.date,
            rank = it.rank,
            pp = it.pp.toFloat().toInt()
        )
    }
}