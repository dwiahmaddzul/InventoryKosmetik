package com.example.inventorykosmetik;
public class Kosmetik {
    private String _id, _nama, _bpom,_stok;
    public Kosmetik(String id, String nama, String bpom, String stok) {
        this._id = id;
        this._nama = nama;
        this._bpom = bpom;
        this._stok = stok;
    }
    public Kosmetik() {
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
    public String get_bpom() {
        return _bpom;
    }
    public void set_bpom(String _bpom) {
        this._bpom = _bpom;
    }
    public String get_stok() {
        return _stok;
    }
    public void set_stok(String _stok) {
        this._stok = _stok;
    }
}

