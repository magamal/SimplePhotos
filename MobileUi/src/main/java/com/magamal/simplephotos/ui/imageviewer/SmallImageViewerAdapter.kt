package com.magamal.simplephotos.ui.imageviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.magamal.simplephotos.R
import com.magamal.simplephotos.extentions.loadImage
import com.simplephotos.presentation.models.photos.PhotoView
import kotlinx.android.synthetic.main.item_small_image.view.*

/**
 * @author Mahmoud Gamal on 2/1/21.
 */
class SmallImageViewerAdapter(val callback: Callback) :
    RecyclerView.Adapter<SmallImageViewerAdapter.ViewHolder>() {

    private val items = ArrayList<PhotoView>()
    private var selectedPosition = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_small_image, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].apply {
            holder.itemView.apply {
                imgUnit.loadImage(thumbnailUrl)
                backgroundTintList = if (selectedPosition == position) {
                    ContextCompat.getColorStateList(context, R.color.white)
                } else {
                    ContextCompat.getColorStateList(context, R.color.colorAccent)
                }
            }
        }
    }

    fun addItem(items: List<PhotoView>?) {
        items?.let { items ->
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }

    fun selectPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.apply {
                setOnClickListener {
                    if (adapterPosition < 0)
                        return@setOnClickListener
                    callback.selectPosition(position = adapterPosition)
                }
            }
        }
    }

    interface Callback {
        fun selectPosition(position: Int)
    }
}