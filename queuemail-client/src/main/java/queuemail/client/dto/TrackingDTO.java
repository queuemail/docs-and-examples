package queuemail.client.dto;


import java.time.LocalDateTime;

public class TrackingDTO
{
    private String email;
    private LocalDateTime when;

    private String _id;

    private String idsending;

    private String idmailing;

    private String type; //OPEN, CLICK

    private String url;

    private LocalDateTime created;

    private String ip;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdsending() {
        return idsending;
    }

    public void setIdsending(String idsending) {
        this.idsending = idsending;
    }

    public String getIdmailing() {
        return idmailing;
    }

    public void setIdmailing(String idmailing) {
        this.idmailing = idmailing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
