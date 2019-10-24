package com.erookies.school.ui.fragment

import androidx.lifecycle.ViewModelProvider
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.data.factory.SearchPeopleFactory
import com.erookies.school.data.repository.SearchPeopleRepository
import com.erookies.school.data.viewModel.SPViewModel

/**
 * Create by Koalak.
 * Time: 2019-10-20
 */
class SearchPeopleFragment : BaseFragment() {
    private val viewModel = getViewmodel(SPViewModel::class.java)

    override fun getFactory(): ViewModelProvider.Factory? = SearchPeopleFactory(
        SearchPeopleRepository.getInstance())
}