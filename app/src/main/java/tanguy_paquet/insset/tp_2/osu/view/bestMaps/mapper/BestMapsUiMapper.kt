package tanguy_paquet.insset.tp_2.osu.view.bestMaps.mapper

import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.model.BestMapsUi

fun List<BestMapsRoom>.fromDomainToUi(): List<BestMapsUi> {
    var result = asSequence().map {
        BestMapsUi(
            beatmap_id = it.beatmap_id,
            score = it.score,
            maxcombo = it.maxcombo,
            count50 = it.count50,
            count100 = it.count100,
            count300 = it.count300,
            countmiss = it.countmiss,
            perfect = it.perfect,
            enabled_mods = it.enabled_mods,
            date = it.date,
            rank = it.rank,
            pp = it.pp,
            beatmapset_id = it.beatmapset_id
        )
    }.toList()

    //result.add(HeaderUi("Profile"))
    return result
}