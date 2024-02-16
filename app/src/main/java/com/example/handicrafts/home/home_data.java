package com.example.handicrafts.home;

public class home_data {



        //it should match the json class names
        public String product_id;
        public String images;
        public String name;
        public String price;
        public String discount;
        public String description;
        public String content_review;
        public String state;
        public String city;

        public int fav;

        public int discount_logo;

        public home_data(String product_id, String images, String name, String price, String discount, String description, String content_review, String state, String city, int fav, int discount_logo) {
            this.product_id = product_id;
            this.images = images;
            this.name = name;
            this.price = price;
            this.discount = discount;
            this.description = description;
            this.content_review = content_review;
            this.state = state;
            this.city = city;
            this.fav = fav;
            this.discount_logo = discount_logo;
        }

        public int getFav() {
            return fav;
        }

        public void setFav(int fav) {
            this.fav = fav;
        }

        public int getDiscount_logo() {
            return discount_logo;
        }

        public void setDiscount_logo(int discount_logo) {
            this.discount_logo = discount_logo;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getContent_review() {
            return content_review;
        }

        public void setContent_review(String content_review) {
            this.content_review = content_review;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

