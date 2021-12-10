package com.nl.component.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

fun FragmentContainerView.commitFragment(
    fragmentManager: FragmentManager,
    fragment: Fragment
) {
    fragmentManager
        .beginTransaction()
        .replace(id, fragment, fragment::javaClass.name)
        .commitNow()
}