package com.sdevprem.commonlistdialog.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdevprem.commonlistdialog.data.AppRepository
import com.sdevprem.commonlistdialog.data.model.Book
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheetViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel(), ListBottomSheetViewModel{

    private val _bookSelectEvent = MutableSharedFlow<Book>()
    val bookSelectEvent = _bookSelectEvent.asSharedFlow()
    private val bookList = AppRepository.books

    override val list: List<String> = bookList.map {
        "${it.name} by ${it.author}"
    }

    override fun onListItemClick(pos: Int) {
        viewModelScope.launch {
            _bookSelectEvent.emit(bookList[pos])
        }
    }

}