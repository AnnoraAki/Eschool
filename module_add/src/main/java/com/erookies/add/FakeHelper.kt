package com.erookies.add

import com.erookies.add.bean.AddEntry

/**
 * Create by Cchanges.
 * Time: 2019-11-01
 */
object FakeHelper {

    private val nameList = arrayListOf("cchanges", "endearment", "sleeply", "byebye")
    private val timeList = arrayListOf("2019.9.2", "2019.9.3", "2019.10.19", "2019.10,2")
    private val addressList = arrayListOf("堕落街", "红高粱", "兴业苑", "...")
    private val avatarList = arrayListOf(
        "http://p1.music.126.net/XLXcxAvGIFLF_cgWdgcjgg==/109951164444109270.jpg?param=180y180",
        "http://p4.music.126.net/BqgqU7AnQd_XkapiP7QOcA==/109951164377887905.jpg?param=200y200",
        "http://p3.music.126.net/1uNfDRqSVpcILX44nEefQg==/1389782706977947.jpg?param=200y200",
        "https://p2.music.126.net/gvv6g5eqy0Ks2i8QRpQjKA==/109951164419304857.jpg?param=525x10000"
    )

    fun fakeData(type: String): List<AddEntry> {
        val list = arrayListOf<AddEntry>()
        val size = (10 until 20).random()
        repeat(size) {
            list.add(
                AddEntry(
                    nickname = nameList[(0..3).random()],
                    time = timeList[(0..3).random()],
                    address = addressList[(0..3).random()],
                    avatar = avatarList[(0..3).random()],
                    tag = type
                )
            )
        }
        return list.toList()
    }
}