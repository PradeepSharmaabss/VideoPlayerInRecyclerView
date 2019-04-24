package test.pradeep.pradeeptest;

import android.databinding.BindingAdapter;
import android.util.Log;

import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

public class VideoAdapter {

    @BindingAdapter({"videoUrl"})
    public static void setImageUrl(SimpleExoPlayerView view, String url) {
        Log.e("videoAdapter called",url);
        VideoPlayerActivity.getInstance().playVideo(view,url);
    }
}
