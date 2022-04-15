package cn.edu.heuet.login.bean;

import java.io.Serializable;

/**
 * Shared实例
 */
public class Shared implements Serializable {
    private long id;
    private long oid;
    private long hid;
    private int status;
    private String community;
    private String location;
    private String shared_start_time;
    private String shared_end_time;
    private String license_plates;
    private String hire_start_time;
    private String hire_end_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public long getHid() {
        return hid;
    }

    public void setHid(long hid) {
        this.hid = hid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShared_start_time() {
        return shared_start_time;
    }

    public void setShared_start_time(String shared_start_time) {
        this.shared_start_time = shared_start_time;
    }

    public String getShared_end_time() {
        return shared_end_time;
    }

    public void setShared_end_time(String shared_end_time) {
        this.shared_end_time = shared_end_time;
    }

    public String getLicense_plates() {
        return license_plates;
    }

    public void setLicense_plates(String license_plates) {
        this.license_plates = license_plates;
    }

    public String getHire_start_time() {
        return hire_start_time;
    }

    public void setHire_start_time(String hire_start_time) {
        this.hire_start_time = hire_start_time;
    }

    public String getHire_end_time() {
        return hire_end_time;
    }

    public void setHire_end_time(String hire_end_time) {
        this.hire_end_time = hire_end_time;
    }
}
