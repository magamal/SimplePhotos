package com.magamal.simplephotos.ui.imageviewer

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magamal.simplephotos.R
import com.magamal.simplephotos.base.BaseFragment
import com.magamal.simplephotos.extentions.swipeOneByOne
import com.simplephotos.presentation.models.photos.PhotoView
import kotlinx.android.synthetic.main.fragment_image_viewer.*


/**
 * @author Mahmoud Gamal on 1/31/21.
 */
class ImageViewerFragment : BaseFragment(), SmallImageViewerAdapter.Callback {

    private var images: List<PhotoView>? = null
    private val largeAdapter by lazy { LargeImageViewerAdapter() }
    private val smallAdapter by lazy { SmallImageViewerAdapter(this) }

    companion object {
        private const val IMAGES_ARGS = "images_args"
        private const val POSITION_ARGS = "position_args"
        fun newInstance(images: List<PhotoView>, scrollToPosition: Int): ImageViewerFragment {
            return ImageViewerFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(IMAGES_ARGS, ArrayList(images))
                    putInt(POSITION_ARGS, scrollToPosition)
                }
            }
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_image_viewer

    override fun setupData() {
        images = arguments?.getParcelableArrayList(IMAGES_ARGS)
            ?: throw IllegalArgumentException("Images can not be null")
    }

    override fun setupViews() {
        setUpLargeRecyclerView()
        setUpSmallRecyclerView()
        selectPosition(arguments?.getInt(POSITION_ARGS) ?: 0)
    }

    private fun setUpLargeRecyclerView() {
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewFullImages.apply {
            layoutManager = linearLayoutManager
            adapter = largeAdapter
            largeAdapter.addItem(images)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    scrollToNewPosition(linearLayoutManager.findFirstVisibleItemPosition())

                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    scrollToNewPosition(linearLayoutManager.findFirstVisibleItemPosition())
                }
            })

            swipeOneByOne()
        }
    }

    private fun scrollToNewPosition(position: Int) {
        recyclerViewSmallImagesIndicator.smoothScrollToPosition(position)
        smallAdapter.selectPosition(position)
    }

    private fun setUpSmallRecyclerView() {
        recyclerViewSmallImagesIndicator.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = smallAdapter
            smallAdapter.addItem(images)
        }
    }

    override fun selectPosition(position: Int) {
        recyclerViewFullImages.smoothScrollToPosition(position)
        scrollToNewPosition(position)
    }
}