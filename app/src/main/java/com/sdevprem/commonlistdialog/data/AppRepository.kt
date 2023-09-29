package com.sdevprem.commonlistdialog.data

import com.sdevprem.commonlistdialog.data.model.Author
import com.sdevprem.commonlistdialog.data.model.Book

object AppRepository {
    val books
        get() = listOf(
            Book(id = 0, name = "Pennyroyal Academy Series", author = "M.A. Larson"),
            Book(id = 1, name = "Gifted Clans Series", author = "Graci Kim"),
            Book(id = 2, name = "The Secrets of the Immortal Nicholas Flamel Series", author = "Graci Kim"),
            Book(id = 3, name = "An Epic Series of Failures Series", author = "Chris Rylander"),
            Book(id = 4, name = "The Inheritance Cycle Series", author = "Christopher Paolini"),
            Book(id = 5, name = "The Uncommoners Series", author = "Jennifer Bell"),
            Book(id = 6, name = "Miss Peregrine's Peculiar Children Series", author = "Ransom Riggs"),
            Book(id = 7, name = "His Dark Materials Series", author = "Philip Pullman"),
            Book(id = 8, name = "Dragon Keepers Series", author = "Kate Klimo"),
            Book(id = 9, name = "The Forgotten Five Series", author = "Lisa McMann"),
        )

    val authors
        get() = listOf(
            Author(id = 0, name = "M.A. Larson"),
            Author(id = 1, name = "Graci Kim"),
            Author(id = 2, name = "Graci Kim"),
            Author(id = 3, name = "Chris Rylander"),
            Author(id = 4, name = "Christopher Paolini"),
            Author(id = 5, name = "Jennifer Bell"),
            Author(id = 6, name = "Ransom Riggs"),
            Author(id = 7, name = "Philip Pullman"),
            Author(id = 8, name = "Kate Klimo"),
            Author(id = 9, name = "Lisa McMann"),
        )
}