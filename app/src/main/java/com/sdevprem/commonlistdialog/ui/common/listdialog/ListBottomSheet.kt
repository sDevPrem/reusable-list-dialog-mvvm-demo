package com.sdevprem.commonlistdialog.ui.common.listdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sdevprem.commonlistdialog.databinding.FragmentListBottomSheetBinding

abstract class ListBottomSheet(
    title : String,
    lazyViewModel : Fragment.() -> Lazy<ListBottomSheetViewModel>
) : BottomSheetDialogFragment() {

    init {
        //title is not a complex type, so we can store it in the arguments
        arguments = Bundle().apply {
            putString(TITLE_KEY, title)
        }
    }

    private lateinit var binding : FragmentListBottomSheetBinding

    private val viewModel by lazyViewModel()
    private val adapter by lazy {
        ListBottomSheetAdapter(viewModel.list){}
    }

    private val title
        get() = arguments?.getString(TITLE_KEY) ?: ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentListBottomSheetBinding.inflate(
            inflater,
            container,
            false
        ).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        rvList.layoutManager = LinearLayoutManager(requireContext())
        rvList.adapter = adapter
        dialogTitle.text = title
    }
}

private const val TITLE_KEY = "list_bottom_sheet_title"