package cl.valentina.pruebasejemplos.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.valentina.pruebasejemplos.R
import cl.valentina.pruebasejemplos.room.StockProductosEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<StockProductosEntity>? = null
    fun setListData(listData: List<StockProductosEntity>?) {
        this.listData = listData
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)

    }

    override fun getItemCount(): Int {
        if(listData == null ) return 0
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imagen = view.imageViewProducto
    val idProducto = view.textViewID
    val nombreProducto= view.tvNombreProducto
    val descripcion = view.tvDescripcion
    val precio = view.tvPrecio
    val cantidadProducto = view.tvCantidadStock

        fun bind(data:StockProductosEntity) {
            nombreProducto.text = data.nombre
            descripcion.text = data.descripcion
            precio.text = data.precio
            idProducto.text = data.id.toString()
            cantidadProducto.text = data.cantidad.toString()

            Glide.with(imagen)
                .load(data.url)
                .into(imagen)

        }

    }
}
