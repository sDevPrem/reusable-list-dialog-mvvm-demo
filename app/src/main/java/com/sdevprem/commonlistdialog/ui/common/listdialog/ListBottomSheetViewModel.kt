package com.sdevprem.commonlistdialog.ui.common.listdialog

interface ListBottomSheetViewModel {
    val list : List<String>
    fun onListItemClick(pos: Int)
}