package com.magamal.simplephotos.extentions

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Mahmoud Gamal on 2019-09-09.
 */
fun RecyclerView.addEndlessScroll(loadMore: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            recyclerView
                .takeIf { layoutManager is LinearLayoutManager && adapter?.itemCount != null }
                ?.run { layoutManager as LinearLayoutManager }
                ?.takeIf { linearLayoutManager -> linearLayoutManager.findLastCompletelyVisibleItemPosition() == adapter?.itemCount!! - 1 }
                ?.let { loadMore() }
        }
    })
}

fun NestedScrollView.addEndlessScroll(loadMore: () -> Unit) {
    setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { view, _, scrollY, _, oldScrollY ->
        view.getChildAt(view.childCount - 1)?.measuredHeight
            ?.takeIf { measuredHeight -> scrollY >= measuredHeight - view.measuredHeight && scrollY > oldScrollY }
            ?.run { loadMore() }
    })
}


fun RecyclerView.swipeOneByOne() {
    val snapHelperOneByOne = SnapHelperOneByOnes()
    snapHelperOneByOne.attachToRecyclerView(this)
}

class SnapHelperOneByOnes : LinearSnapHelper() {
    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager,
        velocityX: Int,
        velocityY: Int
    ): Int {
        if (layoutManager !is RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return RecyclerView.NO_POSITION
        }
        val currentView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
        val myLayoutManager = layoutManager as LinearLayoutManager
        val position1 = myLayoutManager.findFirstVisibleItemPosition()
        val position2 = myLayoutManager.findLastVisibleItemPosition()
        var currentPosition = layoutManager.getPosition(currentView)
        if (velocityX > 400) {
            currentPosition = position2
        } else if (velocityX < 400) {
            currentPosition = position1
        }
        return if (currentPosition == RecyclerView.NO_POSITION) {
            RecyclerView.NO_POSITION
        } else currentPosition
    }
}