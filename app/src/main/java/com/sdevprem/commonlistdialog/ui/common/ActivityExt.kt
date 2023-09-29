package com.sdevprem.commonlistdialog.ui.common

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

inline fun <reified T : DialogFragment> FragmentActivity.lazyDialogFragment(
    tag : String,
    crossinline dialogFactory : () -> T
) = lazy {
    //if the dialog is already present in the fragment manager
    //then return that dialog
    //else use the dialogFactory to create new instance
    supportFragmentManager.findFragmentByTag(tag) as? T ?: dialogFactory()
}