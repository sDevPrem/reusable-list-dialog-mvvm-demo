package com.sdevprem.commonlistdialog.ui.books

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sdevprem.commonlistdialog.R
import com.sdevprem.commonlistdialog.ui.authors.AuthorsActivity
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheet

class BooksActivity : AppCompatActivity() {
    private val listBottomSheet = ListBottomSheet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.choose_author_btn).setOnClickListener {
            startActivity(Intent(this,AuthorsActivity::class.java))
        }

        findViewById<Button>(R.id.choose_btn).setOnClickListener {
            listBottomSheet.show(supportFragmentManager,"Books List")
        }
    }
}