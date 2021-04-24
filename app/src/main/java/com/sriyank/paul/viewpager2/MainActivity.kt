package com.sriyank.paul.viewpager2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.sriyank.viewpager.Countries
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

        setupSimpleSpinner()
        setupCustomSpinner()
    }

    fun setupCustomSpinner(){
        val adapter = CountryArrayAdapter(this, Countries.list!!)
        findViewById<Spinner>(R.id.customSpinner).adapter = adapter
    }
    fun setupSimpleSpinner(){
        val  adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(R.id.simpleSpinner).adapter = adapter
        findViewById<Spinner>(R.id.simpleSpinner).onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(this@MainActivity, "Selected", Toast.LENGTH_SHORT).show()
            }

        }
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