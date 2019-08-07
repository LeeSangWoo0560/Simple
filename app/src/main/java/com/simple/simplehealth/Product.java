package com.simple.simplehealth;

public class Product {

    private String _id;
    private String _weight;
    private String _hour;
    private String _minute;
    private String _health;

    public Product() {

    }

    public Product(String id, String weight, String hour, String minute, String health){
        this._id = id;
        this._weight = weight;
        this._hour = hour;
        this._minute = minute;
        this._health = health;

    }

    public Product(String id){
        this._id = id;

    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_weight() {
        return _weight;
    }

    public void set_weight(String _weight) {
        this._weight = _weight;
    }

    public String get_hour() {
        return _hour;
    }

    public void set_hour(String _hour) {
        this._hour = _hour;
    }

    public String get_minute() {
        return _minute;
    }

    public void set_minute(String _minute) {
        this._minute = _minute;
    }

    public String get_health() {
        return _health;
    }

    public void set_health(String _health) {
        this._health = _health;
    }
}
