package com.pyb.jsoup.article.model;

public class ArticleModel {
    /**
     * 标题
     */
    private  String title;
    /**
     * 内容
     */
    private  String content;
    /**
     * 图片URL 字符串 逗号分割
     */
    private  String  imageurls;
    /**
     * 作者
     */
    private  String  author;
    /**
     * 发表日期
     */
    private  String  datestr;
    /**
     * 所属页
     */
    private  String  page;
    /**
     * 总页
     */
    private  String  totalpage;
    /**
     * 来源URL
     */
    private  String  sourceurl;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageurls() {
        return imageurls;
    }

    public void setImageurls(String imageurls) {
        this.imageurls = imageurls;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatestr() {
        return datestr;
    }

    public void setDatestr(String datestr) {
        this.datestr = datestr;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }
}
