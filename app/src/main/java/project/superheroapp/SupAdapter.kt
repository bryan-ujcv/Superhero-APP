package project.superheroapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.superheroapp2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cont.view.*

class SupAdapter : RecyclerView.Adapter<SupAdapter.SupHolder>() {
    var listaSuper= listOf<SupResponse.Superhero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cont,parent,false)
        return SupHolder(view)
    }

    override fun onBindViewHolder(holder: SupHolder, position: Int) {
        val idSup=listaSuper[position].getId()
        holder.itemId.text=listaSuper[position].name
        Picasso.get().load("").into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return listaSuper.size
    }

class SupHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

    private var view: View = v
    private var photo: Photo? = null

    init {
        v.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val context = itemView.context
        val showPhotoIntent = Intent(context, PhotoActivity::class.java)
        showPhotoIntent.putExtra(PHOTO_KEY, photo)
        context.startActivity(showPhotoIntent)

    }

    companion object {
        private val PHOTO_KEY = "PHOTO"
    }

    fun bindPhoto(photo: Photo) {
        this.photo = photo
        Picasso.with(view.context).load(photo.url).into(view.itemImage)
        view.itemDate.text = photo.humanDate
        view.itemDescription.text = photo.explanation
    }

}
}
