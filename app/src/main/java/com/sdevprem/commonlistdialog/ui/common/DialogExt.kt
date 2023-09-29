package com.sdevprem.commonlistdialog.ui.common

import android.app.Dialog

fun Dialog?.dismissIfShowing(){
    if(this != null && isShowing)
        dismiss()
}