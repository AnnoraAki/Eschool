package com.erookies.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.erookies.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.add_fragment_container.*

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
class AddEntryFragment : BaseFragment() {
    private val titleTag = "title"
    private lateinit var lists: List<AddEntry>
    var title = ""
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(titleTag, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_fragment_container, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lists = FakeHelper.fakeData(title)
        rv_entry.layoutManager = LinearLayoutManager(this.context)
        rv_entry.adapter = AddRecyclerViewAdapter(lists)
    }

    companion object {
        fun newInstance(str: String) = AddEntryFragment().apply {
            arguments = Bundle().apply {
                putString(titleTag, str)
            }
        }
    }
}