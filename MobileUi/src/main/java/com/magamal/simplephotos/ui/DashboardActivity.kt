package com.magamal.simplephotos.ui

import com.magamal.simplephotos.base.ActivityFragmentContainer
import com.magamal.simplephotos.ui.albumdetails.AlbumDetailsFragment
import com.magamal.simplephotos.ui.imageviewer.ImageViewerFragment
import com.magamal.simplephotos.ui.userprofile.UserProfileFragment
import com.simplephotos.presentation.models.album.AlbumView
import com.simplephotos.presentation.models.photos.PhotoView
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
@AndroidEntryPoint
class DashboardActivity : ActivityFragmentContainer<UserProfileFragment>(),
    UserProfileFragment.Callback, AlbumDetailsFragment.Callback {

    override fun createFragmentInstance(): UserProfileFragment =
        UserProfileFragment().apply {
            callback = this@DashboardActivity
        }

    override fun onAlbumClicked(album: AlbumView) {
        addFragment(AlbumDetailsFragment.newInstance(album).apply {
                callback = this@DashboardActivity
            }
        )
    }

    override fun onPhotoClicked(list: List<PhotoView>, scrollToPosition: Int) {
        addFragment(
            ImageViewerFragment.newInstance(list, scrollToPosition)
        )
    }
}