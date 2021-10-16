package com.magamal.simplephotos.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.magamal.simplephotos.R

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
abstract class ActivityFragmentContainer<T : BaseFragment> : AppCompatActivity() {

    private val fragment by lazy { createFragmentInstance() }

    abstract fun createFragmentInstance(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        setFirstFragment(fragment)
    }

    private fun setFirstFragment(fragment: T) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun addFragment(fragment: BaseFragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }
}