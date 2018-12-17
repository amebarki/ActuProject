package com.sample.actuproject.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sample.actuproject.R
import com.sample.actuproject.data.model.Actu
import com.squareup.picasso.Picasso


class ActuAdapter(
    private var actuList: List<Actu>,
    var visibility: Int,
    private val clickListener: (String, Int, Boolean) -> Unit
) : androidx.recyclerview.widget.RecyclerView.Adapter<ActuViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): ActuViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_actu, viewGroup, false)
        return ActuViewHolder(view)
    }

    override fun onBindViewHolder(actuViewHolder: ActuViewHolder, position: Int) {


        val actu = actuList[position]
        actuViewHolder.bind(actu, position, clickListener)
    }

    override fun getItemCount(): Int {
        return actuList.size
    }


}


class ActuViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.actu_title_text_view) as TextView
    private val descriptionTextView: TextView = itemView.findViewById(R.id.actu_description_text_view) as TextView
    private val publishedTextView: TextView = itemView.findViewById(R.id.actu_published_text_view) as TextView
    private val pictureImageView: ImageView = itemView.findViewById(R.id.actu_image_card) as ImageView

    fun bind(actu: Actu, position: Int, clickListener: (String, Int, Boolean) -> Unit) {
        titleTextView.text = actu.title
        descriptionTextView.text = actu.description
        publishedTextView.text = actu.published_at.toString()
        Picasso.with(pictureImageView.context).load(actu.picture_url).centerCrop().fit().into(pictureImageView)
        titleTextView.setOnClickListener { clickListener(actu.title, position, false) }

    }
}