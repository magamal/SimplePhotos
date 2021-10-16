package com.magamal.simplephotos.ui.imageviewer

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.RecyclerView
import com.magamal.simplephotos.R
import com.magamal.simplephotos.extentions.loadImage
import com.simplephotos.presentation.models.photos.PhotoView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_large_image.view.*
import toast
import java.io.File
import java.io.FileOutputStream


/**
 * @author Mahmoud Gamal on 2/1/21.
 */
class LargeImageViewerAdapter : RecyclerView.Adapter<LargeImageViewerAdapter.ViewHolder>() {

    private val items = ArrayList<PhotoView>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_large_image, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].apply {
            holder.itemView.apply {
                imgPhoto.loadImage(thumbnailUrl)
            }
        }
    }

    fun addItem(items: List<PhotoView>?) {
        items?.let { items ->
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.apply {
                imgShare.setOnClickListener {
                    if (adapterPosition < 0)
                        return@setOnClickListener
                    shareItem(items[adapterPosition].thumbnailUrl, context)
                }
            }
        }


        private fun shareItem(url: String?, context: Context) {
            Picasso
                .get()
                .load(url)
                .into(object : com.squareup.picasso.Target {
                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        MimeTypeMap.getFileExtensionFromUrl(url)
                            .run {
                                if (trim().isEmpty())
                                    "png"
                                else
                                    this
                            }.run ext@{
                                bitmap?.let { bitmap ->
                                    shareBitmap(
                                        context = context,
                                        bitmap = bitmap,
                                        fileName = "${System.currentTimeMillis()}.${this@ext}"
                                    )
                                }
                            }
                    }

                    override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
                        e?.printStackTrace()
                        toast(R.string.something_wrong)
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                    }

                })
        }

        private fun shareBitmap(context: Context, bitmap: Bitmap, fileName: String) {
            try {
                context.apply context@{
                    val file = File(externalCacheDir, fileName)
                    val fOut = FileOutputStream(file)
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, fOut)
                    fOut.flush()
                    fOut.close()
                    Intent(Intent.ACTION_SEND).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        type = "image/*"
                        putExtra(
                            Intent.EXTRA_STREAM,
                            FileProvider.getUriForFile(
                                this@context, "$packageName.provider", file
                            )
                        )
                    }.let { intent ->
                        startActivity(
                            Intent.createChooser(
                                intent,
                                context.getString(R.string.choose_app)
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                toast(R.string.something_wrong)
            }
        }
    }
}