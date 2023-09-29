package com.sdevprem.commonlistdialog.ui.common.listdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sdevprem.commonlistdialog.databinding.FragmentListBottomSheetBinding

class ListBottomSheet : BottomSheetDialogFragment(){

    private lateinit var binding : FragmentListBottomSheetBinding
    private val adapter = ListBottomSheetAdapter{}

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
    }
}