package com.sriyank.paul.viewpager2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.sriyank.viewpager.Item
import com.sriyank.viewpager.Items
import com.sriyank.viewpager.MyAdapter
import com.sriyank.viewpager.fragmentpager.FooItems
import com.sriyank.viewpager.fragmentpager.MyFragmentStateAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*the function call to create viewpager with a view*/
        setupViewPager()

        /*function call to create viewpager with fragments*/
        setupViewPagerWithFragment()
        Toast.makeText(this, "testing", Toast.LENGTH_SHORT).show()
    }

    fun setupViewPagerWithFragment(){
        val adapter = MyFragmentStateAdapter(this, FooItems.list!!)
        findViewById<ViewPager2>(R.id.viewPagerWithFragment).adapter =adapter
        findViewById<ViewPager2>(R.id.viewPagerWithFragment).orientation = ViewPager2.ORIENTATION_HORIZONTAL

        findViewById<ViewPager2>(R.id.viewPagerWithFragment).registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                    Toast.makeText(applicationContext, "$position selected", Toast.LENGTH_SHORT).show()

            }
        })

    }

    fun setupViewPager(){
        val adapter = MyAdapter(this, Items.list!!)
        findViewById<ViewPager2>(R.id.viewPager2).adapter = adapter
        findViewById<ViewPager2>(R.id.viewPager2).orientation= ViewPager2.ORIENTATION_HORIZONTAL


    findViewById<ViewPager2>(R.id.viewPager2).registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

        override fun onPageSelected(position:Int){
            super.onPageSelected(position)

            Toast.makeText(applicationContext, "$position selected", Toast.LENGTH_SHORT).show()

        }
    })
    }
}