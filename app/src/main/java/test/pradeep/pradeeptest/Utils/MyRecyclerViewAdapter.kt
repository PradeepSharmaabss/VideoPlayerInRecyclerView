package test.pradeep.pradeeptest.Utils

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import test.pradeep.pradeeptest.R
import test.pradeep.pradeeptest.VideoModel
import test.pradeep.pradeeptest.VideoPlayerActivity
import test.pradeep.pradeeptest.databinding.ItemVideoBinding

class MyRecyclerViewAdapter(private val dataModelList: List<VideoModel>, private val context: Context) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemVideoBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_video, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.itemRowBinding.viewModel = dataModel
        holder.bind(dataModel)
    }


    override fun getItemCount(): Int {
        return dataModelList.size
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        VideoPlayerActivity.getInstance().stopVideo()
    }

    inner class ViewHolder(var itemRowBinding: ItemVideoBinding) : RecyclerView.ViewHolder(itemRowBinding.getRoot()) {
        fun bind(obj: Any) {
            itemRowBinding.executePendingBindings()
        }
    }
}


