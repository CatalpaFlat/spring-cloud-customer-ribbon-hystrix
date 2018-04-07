package cn.catalpaflat.springcloud.model;

/**
 * @author CatalpaFlat
 * @date Created in 2018/4/7 下午5:10
 */
public class User {
    private String name;
    private String uuid;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
