package com.sdevprem.commonlistdialog.ui.authors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdevprem.commonlistdialog.data.AppRepository
import com.sdevprem.commonlistdialog.data.model.Author
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheetViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AuthorsViewModel : ViewModel(), ListBottomSheetViewModel{

    private val _authorSelectEvent = MutableSharedFlow<Author>()
    val authorSelectEvent = _authorSelectEvent.asSharedFlow()

    private val authorList = AppRepository.authors

    override val list: List<String> = authorList.map {
        it.name
    }

    override fun onListItemClick(pos: Int) {
        viewModelScope.launch {
            _authorSelectEvent.emit(authorList[pos])
        }
    }

}