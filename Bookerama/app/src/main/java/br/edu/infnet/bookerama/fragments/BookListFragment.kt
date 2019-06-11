package br.edu.infnet.bookerama.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.bookerama.BookAdapter
import br.edu.infnet.bookerama.BooksViewModel

import br.edu.infnet.bookerama.R
import kotlinx.android.synthetic.main.fragment_book_list.*


/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BookListFragment : Fragment() {

    private lateinit var booksViewModel: BooksViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        activity?.let {
            booksViewModel = ViewModelProviders
                    .of(it)
                    .get(BooksViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
        setUpRecyclerView()
    }

    fun setUpRecyclerView(){
        // Configurando a RecyclerView
        books_list.adapter = BookAdapter(booksViewModel.liveBooks.value ?: listOf())
        // da forma à RecyclerView
        activity?.let {
        books_list.layoutManager = LinearLayoutManager(it)
        books_list.addItemDecoration(DividerItemDecoration(it, DividerItemDecoration.VERTICAL))
        }
    }

    private fun subscribe(){
        booksViewModel.liveBooks.observe(this, Observer {newBooksList->
            //books_list.adapter = BookAdapter(newBooksList ?: listOf())
            val bookAdapter = books_list.adapter as? BookAdapter
            bookAdapter?.updateData(newBooksList ?: listOf())

        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = BookListFragment()
    }
}
