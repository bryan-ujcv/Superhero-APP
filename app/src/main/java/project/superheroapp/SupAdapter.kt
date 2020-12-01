package project.superheroapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.superheroapp2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cont.view.*

class SupAdapter : RecyclerView.Adapter<SupHolder>() {
    var listaSuper= listOf<SupResponse.Superhero>()


    override fun onBindViewHolder(holder: SupHolder, position: Int) {
        val idSup=listaSuper[position].getId()
        holder.itemId.text=listaSuper[position].name
        Picasso.get().load("").into(holder.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cont,parent,false)
        return SupHolder(view)

        override fun getItemCount(): Int {
            return listaSuper.size
    }

    }
}