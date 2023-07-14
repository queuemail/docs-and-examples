package queuemail.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties
public class AppDTO
{
    private String _id;

    private String iduser;

    private String name;

    private Boolean retaindata;

    private String strategy;

    private String originserver;

    private String origindomain;

    private String defaultfromemail;

    private String defaultfromname;

    private String testemail;

    private Long timebetweenemails;

    private Boolean useblacklist;

    private Boolean useautoblacklist;

    private String webhook_sending_finished;

    private String webhook_sending_error;

    private String webhook_tracking_opened;

    private String webhook_tracking_clicked;

    private String webhook_blacklisted_added;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String status;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRetaindata() {
        return retaindata;
    }

    public void setRetaindata(Boolean retaindata) {
        this.retaindata = retaindata;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getOriginserver() {
        return originserver;
    }

    public void setOriginserver(String originserver) {
        this.originserver = originserver;
    }

    public String getOrigindomain() {
        return origindomain;
    }

    public void setOrigindomain(String origindomain) {
        this.origindomain = origindomain;
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

    public String getTestemail() {
        return testemail;
    }

    public void setTestemail(String testemail) {
        this.testemail = testemail;
    }

    public Long getTimebetweenemails() {
        return timebetweenemails;
    }

    public void setTimebetweenemails(Long timebetweenemails) {
        this.timebetweenemails = timebetweenemails;
    }

    public Boolean getUseblacklist() {
        return useblacklist;
    }

    public void setUseblacklist(Boolean useblacklist) {
        this.useblacklist = useblacklist;
    }

    public Boolean getUseautoblacklist() {
        return useautoblacklist;
    }

    public void setUseautoblacklist(Boolean useautoblacklist) {
        this.useautoblacklist = useautoblacklist;
    }

    public String getWebhook_sending_finished() {
        return webhook_sending_finished;
    }

    public void setWebhook_sending_finished(String webhook_sending_finished) {
        this.webhook_sending_finished = webhook_sending_finished;
    }

    public String getWebhook_sending_error() {
        return webhook_sending_error;
    }

    public void setWebhook_sending_error(String webhook_sending_error) {
        this.webhook_sending_error = webhook_sending_error;
    }

    public String getWebhook_tracking_opened() {
        return webhook_tracking_opened;
    }

    public void setWebhook_tracking_opened(String webhook_tracking_opened) {
        this.webhook_tracking_opened = webhook_tracking_opened;
    }

    public String getWebhook_tracking_clicked() {
        return webhook_tracking_clicked;
    }

    public void setWebhook_tracking_clicked(String webhook_tracking_clicked) {
        this.webhook_tracking_clicked = webhook_tracking_clicked;
    }

    public String getWebhook_blacklisted_added() {
        return webhook_blacklisted_added;
    }

    public void setWebhook_blacklisted_added(String webhook_blacklisted_added) {
        this.webhook_blacklisted_added = webhook_blacklisted_added;
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
}
