package br.edu.infnet.bookerama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import br.edu.infnet.bookerama.database.allBooks
import kotlinx.android.synthetic.main.fragment_book_list.*

class MainActivity : AppCompatActivity() {

    val books = allBooks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurando a RecyclerView
        books_list.adapter = BookAdapter(books)
        // da forma à RecyclerView
        books_list.layoutManager = LinearLayoutManager(this)
        books_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }





}
