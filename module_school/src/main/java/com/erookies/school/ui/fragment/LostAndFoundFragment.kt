package com.erookies.school.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.R
import com.erookies.school.data.factory.LostAndFoundFactory
import com.erookies.school.data.repository.LostAndFoundRepository
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolFragmentLostFoundBinding

/**
 * Create by Koalak.
 * Time: 2019-10-20
 */
class LostAndFoundFragment : BaseFragment() {
    private val viewModel = getViewmodel(LostAndFoundViewModel::class.java)

    override fun getFactory(): ViewModelProvider.Factory? = LostAndFoundFactory(
        LostAndFoundRepository.getInstance())

    private lateinit var binding:SchoolFragmentLostFoundBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.school_fragment_lost_found,container,false)
        return binding.root
    }


}