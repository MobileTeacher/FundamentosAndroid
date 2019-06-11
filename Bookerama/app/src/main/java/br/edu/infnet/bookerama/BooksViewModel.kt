package br.edu.infnet.bookerama

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.edu.infnet.bookerama.database.allBooks
import br.edu.infnet.bookerama.models.Book

class BooksViewModel: ViewModel() {

    val liveBooks = MutableLiveData<List<Book>>().apply { value = allBooks }

    fun addNewBook(book: Book){
        liveBooks.value = liveBooks.value?.plus(book)
    }

}