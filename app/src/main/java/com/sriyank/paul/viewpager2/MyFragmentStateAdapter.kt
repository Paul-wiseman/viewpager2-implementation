package com.sriyank.viewpager.fragmentpager

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class MyFragmentStateAdapter(context: Context, val itemList: List<Foo>) : FragmentStateAdapter(context as FragmentActivity) {
    override fun getItemCount(): Int {
        return itemList.size

    }

    override fun createFragment(position: Int): Fragment {

        Log.i("createFragment", "$position")
        val foo = itemList[position]
        return SlideFragment(foo)

    }


}
