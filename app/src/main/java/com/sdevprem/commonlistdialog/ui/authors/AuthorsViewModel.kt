package com.sdevprem.commonlistdialog.ui.authors

import androidx.lifecycle.ViewModel
import com.sdevprem.commonlistdialog.data.AppRepository
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheetViewModel

class AuthorsViewModel : ViewModel(), ListBottomSheetViewModel{

    private val authorList = AppRepository.authors

    override val list: List<String> = authorList.map {
        it.name
    }
}