package com.example.admin.mvp_master.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class MoiveBean {


    /**
     * rating : {"max":10,"average":6.4,"stars":"35","min":0}
     * reviews_count : 2
     * wish_count : 287
     * douban_site :
     * year : 1985
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1833242451.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1833242451.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1833242451.webp"}
     * alt : https://movie.douban.com/subject/1764798/
     * id : 1764798
     * mobile_url : https://movie.douban.com/subject/1764798/mobile
     * title : 黑神锅传奇
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1764798
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["动画","家庭","奇幻"]
     * collect_count : 207
     * casts : [{"alt":null,"avatars":null,"name":"Grant Bardsley","id":null},{"alt":null,"avatars":null,"name":"Susan Sheridan","id":null},{"alt":"https://movie.douban.com/celebrity/1049921/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13040.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13040.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13040.webp"},"name":"弗雷迪·琼斯","id":"1049921"},{"alt":"https://movie.douban.com/celebrity/1000316/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21484.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21484.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21484.webp"},"name":"奈杰尔·霍桑","id":"1000316"}]
     * current_season : null
     * original_title : The Black Cauldron
     * summary : 《黑神锅传奇》The Black Cauldron (Disney Gold Classic Collection) (1985)是迪斯尼经典动画里最另类的一部作品。剧情叙述一位名叫塔兰(Taran)的少年，为了维护家乡和平，而与魔王The Horned King对抗，阻止其利用黑神锅的魔力危害世人。本片也是迪士尼动画第一次利用计算机来辅助拍摄，不过只有短短几个画面而已。
     本片在某些地区上映时采用另一片名“Taran and the Magic Cauldron”，而且片中有一些迪士尼动画里少见的血腥画面，与以往迪士尼动画风格似乎有些不同，因此本片被定位为只针对青少年观众，迥异于其他适合阖家观赏的迪士尼电影。本片也是迪士尼动画第一次藉由电脑来辅助拍摄，不过只有短短几个画面而已，到了隔年的《妙妙探》，迪士尼才第一次用电脑制作出一个独立的场景。本片是迪士尼经典动画里最另类的一部作品，因为走的不是传统家庭路线，故迪士尼对本片是否要推出录影带一直心存观望，况且还有一些版权等的争议…不过经过内部几番沟通后，本片终于在1997年底首度在英国发行录影带，但是心细的影迷立刻发现有几幕被删掉了！为此还向迪士尼提出抗议…至于美国则在1998年首度发行录影带，发行的则是当初完整的版本。
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1037515/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"Ted Berman","id":"1037515"},{"alt":null,"avatars":null,"name":"Richard Rich","id":null}]
     * comments_count : 49
     * ratings_count : 167
     * aka : ["黑神魔","Taran and the Magic Cauldron"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 6.4
         * stars : 35
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1833242451.webp
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1833242451.webp
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1833242451.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * alt : null
         * avatars : null
         * name : Grant Bardsley
         * id : null
         */

        private Object alt;
        private Object avatars;
        private String name;
        private Object id;

        public Object getAlt() {
            return alt;
        }

        public void setAlt(Object alt) {
            this.alt = alt;
        }

        public Object getAvatars() {
            return avatars;
        }

        public void setAvatars(Object avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1037515/
         * avatars : {"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"}
         * name : Ted Berman
         * id : 1037515
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png
             * large : https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png
             * medium : https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }


    @Override
    public String toString() {
        return "MoiveBean{" +
                "rating=" + rating +
                ", reviews_count=" + reviews_count +
                ", wish_count=" + wish_count +
                ", douban_site='" + douban_site + '\'' +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", mobile_url='" + mobile_url + '\'' +
                ", title='" + title + '\'' +
                ", do_count=" + do_count +
                ", share_url='" + share_url + '\'' +
                ", seasons_count=" + seasons_count +
                ", schedule_url='" + schedule_url + '\'' +
                ", episodes_count=" + episodes_count +
                ", collect_count=" + collect_count +
                ", current_season=" + current_season +
                ", original_title='" + original_title + '\'' +
                ", summary='" + summary + '\'' +
                ", subtype='" + subtype + '\'' +
                ", comments_count=" + comments_count +
                ", ratings_count=" + ratings_count +
                ", countries=" + countries +
                ", genres=" + genres +
                ", casts=" + casts +
                ", directors=" + directors +
                ", aka=" + aka +
                '}';
    }


}
