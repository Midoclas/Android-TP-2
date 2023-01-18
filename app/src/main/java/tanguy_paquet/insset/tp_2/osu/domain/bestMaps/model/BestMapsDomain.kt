package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.model

data class BestMapsDomain(
    val beatmap_id: String,
    val beatmapset_id: String,
    val score: String,
    val maxcombo: String,
    val count50: String,
    val count100: String,
    val count300: String,
    val countmiss: String,
    val perfect: String,
    val enabled_mods: String,
    val user_id: String,
    val date: String,
    val rank: String,
    val pp: String
)
