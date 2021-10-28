package cl.valentina.pruebasejemplos.api


import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.valentina.pruebasejemplos.R
import kotlinx.android.synthetic.main.stock_productos_fragment.*


class StockProductosFragment : Fragment() {

    private lateinit var  factory: StockProductosViewModelFactory
    private lateinit var viewModel: StockProductosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stock_productos_fragment, container, false)

        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = StockProductosAPI()
        val repository = StockProductosRepository(api)
        factory = StockProductosViewModelFactory(repository)
        //viewModel = ViewModelProviders.of(this,factory).get(StockProductosViewModel::class.java)
        viewModel = ViewModelProvider(this,factory).get(StockProductosViewModel::class.java)
        viewModel.getStockProductos()
        viewModel.stocks.observe(viewLifecycleOwner, Observer { stocks ->
            recycler_view_stock_productos.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = StockProductosAdapter(stocks)
            }

        })
    }

}