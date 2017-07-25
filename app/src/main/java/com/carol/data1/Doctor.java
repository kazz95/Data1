package com.carol.data1;

/**
 * Created by kazz95 on 12/07/2017.
 */

public class Doctor {


    private int _id;
    private String _doctorname ;
    private String _speciality;
    private String _phone ;
    private String _email ;
    public Doctor() {


    }



    public Doctor(String _doctorname, String _speciality, String _phone, String _email) {
        this._doctorname = _doctorname;
        this._speciality = _speciality ;
        this._phone = _phone ;
        this._email = _email ;
    }
    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public Doctor(String _doctorname) {
        this._doctorname = _doctorname;
    }



    public String get_speciality() {
        return _speciality;
    }

    public void set_speciality(String _speciality) {
        this._speciality = _speciality;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_doctorname() {
        return _doctorname;
    }

    public void set_doctorname(String _doctorname) {
        this._doctorname = _doctorname;
    }
}
