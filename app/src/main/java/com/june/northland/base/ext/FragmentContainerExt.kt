package com.june.northland.base.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

fun FragmentContainerView.commitFragment(
    fragmentManager: FragmentManager,
    containerId: Int,
    fragment: Fragment
) {
    fragmentManager
        .beginTransaction()
        .replace(containerId, fragment, fragment::javaClass.name)
        .commitNow()
}