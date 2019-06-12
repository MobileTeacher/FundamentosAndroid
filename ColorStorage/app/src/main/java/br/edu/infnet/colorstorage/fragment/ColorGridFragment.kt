package br.edu.infnet.colorstorage.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.colorstorage.ColorAdapter
import br.edu.infnet.colorstorage.R
import br.edu.infnet.colorstorage.model.MyColor
import kotlinx.android.synthetic.main.fragment_color_grid.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ColorGridFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }
    private fun setUpRecyclerView(){
        activity?.let{activity->
            val colors = listOf<MyColor>(
                    MyColor(3278374),
                    MyColor(4220107),
                    MyColor(457220109),
                    MyColor(4220107),
                    MyColor(457220109)
            )
            color_grid.adapter = ColorAdapter(colors)
            color_grid.layoutManager = GridLayoutManager(activity, 3)
        }
    }


}
