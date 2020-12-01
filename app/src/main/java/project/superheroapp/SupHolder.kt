package project.superheroapp

import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

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