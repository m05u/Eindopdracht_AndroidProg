package Models;

import java.util.ArrayList;

public class Links {
    public String mission_patch;
    public String mission_patch_small;
    public String reddit_campaign;
    public String reddit_launch;
    public String reddit_recovery;
    public String reddit_media;
    public String presskit;
    public String article_link;
    public String wikipedia;
    public String video_link;
    public String youtube_id;
    public ArrayList<String> flickr_images;

    @Override
    public String toString() {
        return "Links{" +
                "mission_patch='" + mission_patch + '\'' +
                ", mission_patch_small='" + mission_patch_small + '\'' +
                ", reddit_campaign='" + reddit_campaign + '\'' +
                ", reddit_launch='" + reddit_launch + '\'' +
                ", reddit_recovery='" + reddit_recovery + '\'' +
                ", reddit_media='" + reddit_media + '\'' +
                ", presskit='" + presskit + '\'' +
                ", article_link='" + article_link + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", video_link='" + video_link + '\'' +
                ", youtube_id='" + youtube_id + '\'' +
                ", flickr_images=" + flickr_images +
                '}';
    }
}
