package test.pradeep.pradeeptest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_landing.*
import test.pradeep.pradeeptest.Utils.MyRecyclerViewAdapter
import test.pradeep.pradeeptest.databinding.ActivityLandingBinding


class LandingActivity : AppCompatActivity() {

    internal lateinit var binding: ActivityLandingBinding
    var list = ArrayList<VideoModel>()
    var filterList = ArrayList<VideoModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        setSupportActionBar(toolbar)
        setData()
    }

    private fun setData() {

        for (x in 0..20) {
            var videoModel = VideoModel()
            if (x % 2 == 0)
                videoModel.url = "https://androidwave.com/media/androidwave-video-5.mp4"
            else
                videoModel.url = "https://androidwave.com/media/androidwave-video-6.mp4"
            videoModel.name = "Video" + "$x"
            list.add(videoModel)
            filterList.add(videoModel)
        }
        binding.recyclerView.adapter = MyRecyclerViewAdapter(filterList, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val searchViewItem = menu!!.findItem(R.id.app_bar_search)
        val searchView = MenuItemCompat.getActionView(searchViewItem) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterList.clear()
                list.forEachIndexed { index, videoModel ->
                    if (list[index].name!!.toLowerCase().equals(query.toLowerCase().trim())) {
                        filterList.add(list[index])
                    }
                }
                binding.recyclerView.adapter = MyRecyclerViewAdapter(filterList, applicationContext)
                searchView.clearFocus()
                return false

            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}
