package test.pradeep.pradeeptest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_landing.*
import test.pradeep.pradeeptest.Utils.MyRecyclerViewAdapter
import test.pradeep.pradeeptest.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {

    internal lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        setSupportActionBar(toolbar)
        setData()
    }

    private fun setData() {
        var videoModel = VideoModel()
        var list = ArrayList<VideoModel>()
        for (x in 0..20) {
            videoModel.url = "https://androidwave.com/media/androidwave-video-5.mp4"
            videoModel.name = "Video"+x
            list.add(videoModel)
        }
        binding.recyclerView.adapter = MyRecyclerViewAdapter(list, this)
    }
}
