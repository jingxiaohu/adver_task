package com.pyb.jsoup.article.model;

import com.pyb.bean.Wp_post_jxh;
import com.pyb.bean.Wp_posts;

public class WpPostModel {
    /**
     * 获取 Wp_posts
     * @return
     */
    public static Wp_posts getWp_posts(){
        Wp_posts wp_posts = new Wp_posts();
        wp_posts.setPost_author(1);//作者ID
        return  wp_posts;
    }

    /**
     * 获取 Wp_posts
     * @return
     */
    public static Wp_post_jxh getWp_post_jxh(){
        Wp_post_jxh wp_post_jxh = new Wp_post_jxh();
//        wp_post_jxh.setCategory_id();
        return  wp_post_jxh;
    }
}
