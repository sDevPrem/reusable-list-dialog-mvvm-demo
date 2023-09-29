package com.sdevprem.commonlistdialog.ui.authors

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.sdevprem.commonlistdialog.R
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheet

class AuthorsActivity : AppCompatActivity() {

    private val listBottomSheet = AuthorListBottomSheet()
    private val viewModel : AuthorsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.choose_author_btn).isVisible = false
        findViewById<TextView>(R.id.title).text = "Choose Author"

        findViewById<Button>(R.id.choose_btn).setOnClickListener {
            //if the parent is fragment : use childFragmentManager
            listBottomSheet.show(supportFragmentManager,"Authors List")
        }
    }

    class AuthorListBottomSheet: ListBottomSheet(
        title = "Choose Author",
        //if the parent is a fragment : use requireParentFragment()
        lazyViewModel = { viewModels<AuthorsViewModel>({ requireActivity() }) }
    )

}