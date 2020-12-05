package com.example.Herbarium1818101;
public class Tanaman {
    private String _id, _nama, _spname,_manfaat;
    public Tanaman(String id, String nama, String spname, String manfaat) {
        this._id = id;
        this._nama = nama;
        this._spname = spname;
        this._manfaat = manfaat;
    }
    public Tanaman() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_spname() {
        return _spname;
    }
    public void set_spname(String _spname) {
        this._spname = _spname;
    }
    public String get_manfaat() {
        return _manfaat;
    }
    public void set_manfaat(String _manfaat) {
        this._manfaat = _manfaat;
    }
}

