package com.funny.common.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun repalceFragment(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    frameId: Int,
    alive: Boolean = false
) {
    val transation = fragmentManager.beginTransaction()
    transation.replace(frameId, fragment)
    if (alive) {
        transation.addToBackStack(null)
    }
    transation.commitAllowingStateLoss()
}

fun <T : ViewModel> obtainViewModel(activity: FragmentActivity, cls: Class<T>): T {
    return ViewModelProviders.of(activity).get(cls)
}
