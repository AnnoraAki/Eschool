package com.erookies.add

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
data class AddEntry(val tag: String = "", val time: String = "", val address: String = "") {
    companion object {
        const val CAR = "拼车"
        const val MOVIE = "电影"
        const val EAT = "约饭"
        const val GAME = "桌游"
        const val SING = "唱歌"
        const val OTHER = "其他"
    }
}