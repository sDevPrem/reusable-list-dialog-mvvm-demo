package com.sdevprem.commonlistdialog.ui.books

import androidx.lifecycle.ViewModel
import com.sdevprem.commonlistdialog.data.AppRepository
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheetViewModel

class BooksViewModel : ViewModel(), ListBottomSheetViewModel{
    private val bookList = AppRepository.books

    override val list: List<String> = bookList.map {
        "${it.name} by ${it.author}"
    }

}