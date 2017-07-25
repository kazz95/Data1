package com.carol.data1;

/**
 * Created by kazz95 on 19/07/2017.
 */

public class Profile {
    private int _id;
    private String _profile;
    private String _dob;
    private String _phone;
    private String _email;
    private String _affectedEar;
    private String _other;
    {
}


       public Profile(String _profile, String _dob, String _phone, String _email, String _affectedEar, String _other)
        {
            this._profile = _profile;
            this._dob = _dob;
            this._phone = _phone;
            this._email = _email;
            this._affectedEar =_affectedEar;
            this._other = _other;


        }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_profile() {
        return _profile;
    }

    public void set_profile(String _profile) {
        this._profile = _profile;
    }

    public String get_dob() {
        return _dob;
    }

    public void set_dob(String _dob) {
        this._dob = _dob;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_affectedEar() {
        return _affectedEar;
    }

    public void set_affectedEar(String _affectedEar) {
        this._affectedEar = _affectedEar;
    }

    public String get_other() {
        return _other;
    }

    public void set_other(String _other) {
        this._other = _other;
    }


}
