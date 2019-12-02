package com.erookies.add

import com.erookies.add.bean.AddEntry

/**
 * Create by Cchanges.
 * Time: 2019-12-01
 */
private val map = mapOf(
    AddEntry.CAR to 1,
    AddEntry.MOVIE to 2,
    AddEntry.EAT to 3,
    AddEntry.GAME to 4,
    AddEntry.SING to 5,
    AddEntry.OTHER to 6
)

fun string2Int(kind : String) = map[kind] ?: 0

fun int2String(int : Int) :String {
    map.keys.forEach {
        if (map[it] == int) {
            return it
        }
    }
    return ""
}