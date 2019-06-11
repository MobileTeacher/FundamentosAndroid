package br.edu.infnet.bookerama.fragments


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.bookerama.BooksViewModel

import br.edu.infnet.bookerama.R
import br.edu.infnet.bookerama.models.Book
import kotlinx.android.synthetic.main.fragment_add_book.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AddBookFragment : Fragment() {

    private lateinit var booksViewModel: BooksViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity?.let {
        booksViewModel = ViewModelProviders
                                .of(it)
                                .get(BooksViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_add_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListeners()
    }

    fun setUpListeners(){
        add_button.setOnClickListener {
            val author = author_edittext.text.toString()
            val title = title_edittext.text.toString()
            author_edittext.setText("")
            title_edittext.setText("")
            val book = Book(author, title)
            booksViewModel.addNewBook(book)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = AddBookFragment()
    }
}
