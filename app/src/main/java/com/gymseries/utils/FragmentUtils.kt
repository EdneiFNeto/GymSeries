package com.gymseries.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentUtils {

    companion object{
        fun changeFragments(fragmentManager: FragmentManager, fragment: Fragment, tag: String, framelayout:Int) {
            fragmentManager
                .beginTransaction()
                .replace(framelayout, fragment, tag)
                .commitAllowingStateLoss()
        }
    }
}
