package com.sonn.son.memozzang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by son on 2016-06-08.
 */
public class VideoPlayActivity extends Activity{
    VideoView mVideoView;
    String mVideoUri;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Window win = getWindow();
        win.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.video_playing_activity);

        setVideoView();

        setMediaController();

    }

    public void setVideoView()
    {
        mVideoView = (VideoView)findViewById(R.id.video_playing_videoView);

        Intent intent = getIntent();
        mVideoUri = intent.getStringExtra(BasicInfo.KEY_URI_VIDEO);
        mVideoView.setVideoPath(mVideoUri);
    }

    public void setMediaController()
    {
        MediaController mediaController = new MediaController(VideoPlayActivity.this);
        mVideoView.setMediaController(mediaController);
        mVideoView.start();
    }
}
