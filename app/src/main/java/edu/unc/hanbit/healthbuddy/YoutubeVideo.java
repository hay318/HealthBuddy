package edu.unc.hanbit.healthbuddy;

/**
 * Created by HanBit on 12/2/17.
 */

public class YoutubeVideo {
    String videoUrl;

    public YoutubeVideo(){

    }

    public YoutubeVideo(String videoUrl){
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
