package com.sriyank.viewpager.fragmentpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.sriyank.paul.viewpager2.R



class SlideFragment(private val foo: Foo) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          view.findViewById<TextView>(R.id.txvItem).text = foo.itemName
        view.findViewById<TextView>(R.id.txvItemDescription).text = foo.itemDescription
    }
}

