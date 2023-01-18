package tanguy_paquet.insset.tp_2.osu.view.profile.mapper

import tanguy_paquet.insset.tp_2.osu.data.profile.model.UserIdRoom
import tanguy_paquet.insset.tp_2.osu.view.profile.model.UserIdUi

fun List<UserIdRoom>.fromDomainToUi(): List<UserIdUi> {
    var result = asSequence().map {
        UserIdUi(
            user_id = it.user_id,
        )
    }.toList()

    //result.add(HeaderUi("Profile"))
    return result
}