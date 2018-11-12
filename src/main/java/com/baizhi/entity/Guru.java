package com.baizhi.entity;

public class Guru {
    private String id;
    private String headPic;
    private String name;
    private String status;
    private String sxs;

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", headPic='" + headPic + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", sxs='" + sxs + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSxs() {
        return sxs;
    }

    public void setSxs(String sxs) {
        this.sxs = sxs;
    }

    public Guru(String id, String headPic, String name, String status, String sxs) {
        this.id = id;
        this.headPic = headPic;
        this.name = name;
        this.status = status;
        this.sxs = sxs;
    }

    public Guru() {
    }
}
