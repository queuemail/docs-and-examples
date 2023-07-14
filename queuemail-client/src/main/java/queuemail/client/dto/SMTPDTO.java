package queuemail.client.dto;

import java.time.LocalDateTime;

public class SMTPDTO
{
    private String _id;

    private String idapp;

    private Integer priority;

    private String host;

    private Integer port;

    private String username;

    private String password;

    private Boolean auth;

    private Boolean starttls;

    private Boolean sslTls;

    private Boolean debug;

    private String defaultfromemail;

    private String defaultfromname;

    private Integer numerrors;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String status;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdapp() {
        return idapp;
    }

    public void setIdapp(String idapp) {
        this.idapp = idapp;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }



    public Boolean getSslTls() {
        return sslTls;
    }

    public void setSslTls(Boolean sslTls) {
        this.sslTls = sslTls;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public String getDefaultfromemail() {
        return defaultfromemail;
    }

    public void setDefaultfromemail(String defaultfromemail) {
        this.defaultfromemail = defaultfromemail;
    }

    public String getDefaultfromname() {
        return defaultfromname;
    }

    public void setDefaultfromname(String defaultfromname) {
        this.defaultfromname = defaultfromname;
    }

    public Integer getNumerrors() {
        return numerrors;
    }

    public void setNumerrors(Integer numerrors) {
        this.numerrors = numerrors;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getStarttls() {
        return starttls;
    }

    public void setStarttls(Boolean starttls) {
        this.starttls = starttls;
    }
}
