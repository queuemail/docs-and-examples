package queuemail.client.dto;


import java.time.LocalDateTime;

public class LogDTO
{
    private String to;
    private String resultcode;
    private LocalDateTime when;

    private String _id;

    private String idsending;

    private String idsmtp;

    private String idapp;

    private LocalDateTime created;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
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

    public String getIdsmtp() {
        return idsmtp;
    }

    public void setIdsmtp(String idsmtp) {
        this.idsmtp = idsmtp;
    }

    public String getIdapp() {
        return idapp;
    }

    public void setIdapp(String idapp) {
        this.idapp = idapp;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
