package com.example.siddhiparekh11.androiddatabase;



public class Products {

    private int _id;
    private String _itemname;
    private String _itemdescription;
    private String _itemprice;
    private String _itemreview;

    public Products(String itemname,String itemdescription,String itemprice,String itemreview)
    {
        this._itemname=itemname;
        this._itemdescription=itemdescription;
        this._itemprice=itemprice;
        this._itemreview=itemreview;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_itemname(String _itemname) {
        this._itemname = _itemname;
    }

    public void set_itemdescription(String _itemdescription) {
        this._itemdescription = _itemdescription;
    }

    public void set_itemprice(String _itemprice) {
        this._itemprice = _itemprice;
    }

    public void set_itemreview(String _itemreview) {
        this._itemreview = _itemreview;
    }

    public int get_id() {
        return _id;
    }

    public String get_itemname() {
        return _itemname;
    }

    public String get_itemdescription() {
        return _itemdescription;
    }

    public String get_itemprice() {
        return _itemprice;
    }

    public String get_itemreview() {
        return _itemreview;
    }
}
