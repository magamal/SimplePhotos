package com.magamal.simplephotos.ui.albumdetails

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magamal.simplephotos.R
import com.magamal.simplephotos.base.BaseFragment
import com.magamal.simplephotos.base.GenericRecyclerViewAdapter
import com.magamal.simplephotos.extentions.addTextWatcher
import com.magamal.simplephotos.extentions.loadImage
import com.magamal.simplephotos.extentions.toGone
import com.magamal.simplephotos.extentions.toVisible
import com.simplephotos.presentation.models.album.AlbumView
import com.simplephotos.presentation.models.photos.PhotoView
import com.simplephotos.presentation.viewmodels.AlbumDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_album_details.*
import kotlinx.android.synthetic.main.item_photo.view.*
import toast

/**
 * @author Mahmoud Gamal on 16/10/2021.
 */
@AndroidEntryPoint
class AlbumDetailsFragment : BaseFragment() {

    private val viewModel: AlbumDetailsViewModel by viewModels()

    private lateinit var album: AlbumView
    lateinit var callback: Callback

    companion object {
        private const val ALBUM_ARG = "album"
        private const val NUM_OF_ITEMS_IN_ROW = 3
        fun newInstance(album: AlbumView): AlbumDetailsFragment =
            AlbumDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ALBUM_ARG, album)
                }
            }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_album_details

    override fun setupData() {
        album = arguments?.getParcelable(ALBUM_ARG)
            ?: throw IllegalArgumentException("Album can not be null")
    }

    override fun fetchData() {
        album.id?.let(viewModel::getPhotos)
    }

    override fun setupViews() {
        toolbar.title = album.title
        recyclerViewPhotos.apply {
            layoutManager = GridLayoutManager(context, NUM_OF_ITEMS_IN_ROW)
            adapter = photosAdapter
        }

        etSearchInput.addTextWatcher { newText ->
            if (newText.isNullOrEmpty()) {
                photosAdapter.setItems(viewModel.getLastFetchedPhotos())
            } else {
                val filteredList = viewModel.getFilteredPhotos(newText)
                photosAdapter.setItems(filteredList)
                if (filteredList.isNullOrEmpty())
                    toast(R.string.no_data_found)
            }
        }
    }

    override fun setupObservers() {
        viewModel.observeOnPhotos(
            owner = this,
            onLoading = {
                progressAlbums.toVisible()
            },
            onError = { throwable ->
                progressAlbums.toGone()
                toast(getMessageForThrowable(throwable))
            },
            onNewData = { newData, allData ->
                progressAlbums.toGone()
                photosAdapter.setItems(allData)
            }
        )
    }


    private val photosAdapter by lazy {
        object : GenericRecyclerViewAdapter<PhotoView>() {

            override fun getLayoutId(): Int = R.layout.item_photo

            override fun bindData(holder: RecyclerView.ViewHolder, position: Int, item: PhotoView) {
                holder.itemView.imgPhoto.loadImage(item)
                holder.itemView.setOnClickListener {
                    onItemClicked(items, position)
                }
            }

            private fun onItemClicked(items: ArrayList<PhotoView>, position: Int) {
                callback.onPhotoClicked(items, position)
            }
        }
    }

    interface Callback {
        fun onPhotoClicked(list: List<PhotoView>, scrollToPosition: Int)
    }

}