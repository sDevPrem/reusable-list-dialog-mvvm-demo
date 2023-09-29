package com.sdevprem.commonlistdialog.ui.books

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sdevprem.commonlistdialog.R
import com.sdevprem.commonlistdialog.ui.authors.AuthorsActivity
import com.sdevprem.commonlistdialog.ui.common.dismissIfShowing
import com.sdevprem.commonlistdialog.ui.common.lazyDialogFragment
import com.sdevprem.commonlistdialog.ui.common.listdialog.ListBottomSheet
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BooksActivity : AppCompatActivity() {
    private val viewModel : BooksViewModel by viewModels()
    private val listBottomSheet by lazyDialogFragment(BOOKS_BOTTOM_SHEET_TAG){
        BookListBottomSheet()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.choose_author_btn).setOnClickListener {
            //if the parent is fragment : use childFragmentManager
            startActivity(Intent(this,AuthorsActivity::class.java))
        }

        findViewById<Button>(R.id.choose_btn).setOnClickListener {
            //if the parent is fragment : use childFragmentManager
            listBottomSheet.show(supportFragmentManager,BOOKS_BOTTOM_SHEET_TAG)
        }

        lifecycleScope.launch {
            viewModel.bookSelectEvent.collectLatest {

                findViewById<TextView>(R.id.selected_item).text =
                    "You have selected ${it.name} by ${it.author}"

                listBottomSheet.dialog.dismissIfShowing()
            }
        }
    }

   class BookListBottomSheet: ListBottomSheet(
        title = "Choose Book",
       //if the parent is a fragment : use requireParentFragment()
        lazyViewModel = { viewModels<BooksViewModel>({ requireActivity() }) }
   )
}

private const val BOOKS_BOTTOM_SHEET_TAG = "books_bottom_sheet"