package com.sdevprem.commonlistdialog.ui.authors

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.sdevprem.commonlistdialog.R
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheet

class AuthorsActivity : AppCompatActivity() {

    private val listBottomSheet = ListBottomSheet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.choose_author_btn).isVisible = false
        findViewById<TextView>(R.id.title).text = "Choose Author"

        findViewById<Button>(R.id.choose_btn).setOnClickListener {
            listBottomSheet.show(supportFragmentManager,"Authors List")
        }
    }
}