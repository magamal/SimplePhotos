package com.magamal.simplephotos.ui.userprofile

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magamal.simplephotos.R
import com.magamal.simplephotos.base.BaseFragment
import com.magamal.simplephotos.base.GenericRecyclerViewAdapter
import com.magamal.simplephotos.extentions.toGone
import com.magamal.simplephotos.extentions.toVisible
import com.simplephotos.presentation.models.album.AlbumView
import com.simplephotos.presentation.viewmodels.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user_profile.*
import kotlinx.android.synthetic.main.item_album.view.*
import toast


/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
@AndroidEntryPoint
class UserProfileFragment : BaseFragment() {

    private val viewModel: UserProfileViewModel by viewModels()

    var callback: Callback? = null

    override fun getLayoutRes(): Int = R.layout.fragment_user_profile

    override fun fetchData() {
        viewModel.fetchData()
    }

    override fun setupViews() {
        recyclerViewAlbums.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = albumsAdapter
        }
    }

    override fun setupObservers() {
        setupUserObserver()
        setupAlbumsObserver()
    }

    private fun setupAlbumsObserver() {
        viewModel.observeOnAlbum(
            owner = this,
            onLoading = {
                progressAlbums.toVisible()
            },
            onError = { throwable ->
                progressAlbums.toGone()
                toast(getMessageForThrowable(throwable))
            },
            onNewData = { newItems, allItems ->
                progressAlbums.toGone()
                albumsAdapter.setItems(allItems)
            }
        )
    }

    private fun setupUserObserver() {
        viewModel.observeOnUser(
            owner = this,
            onLoading = {
                progressUser.toVisible()
            },
            onError = { throwable ->
                progressUser.toGone()
                toast(getMessageForThrowable(throwable))
            }, onNewData = { user ->
                progressUser.toGone()
                user.apply {
                    tvUserName.text = name
                    address?.apply {
                        tvAddress.text = String.format(
                            getString(R.string.address_format),
                            street, suite, city, zipcode
                        )
                    }
                }
            }
        )
    }


    private val albumsAdapter by lazy {
        object : GenericRecyclerViewAdapter<AlbumView>() {
            override fun bindData(holder: RecyclerView.ViewHolder, position: Int, item: AlbumView) {
                holder.itemView.apply {
                    tvAlbumTitle.text = item.title ?: ""
                    setOnClickListener {
                        onItemClicked(item)
                    }
                }
            }

            private fun onItemClicked(item: AlbumView) {
                callback?.onAlbumClicked(item)
            }

            override fun getLayoutId(): Int = R.layout.item_album
        }
    }

    interface Callback {
        fun onAlbumClicked(album: AlbumView)
    }
}