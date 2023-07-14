package queuemail.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendingResultDTO
{
    String id;
    String status;
    LocalDateTime inittime;
    LocalDateTime logsdeleledby;
    List<String> attachments;


    List<String> blacklisted;
    List<String> autoblacklisted;
    List<String> notvalidrecipients;

    List<LogDTO> log;
    List<TrackingDTO> opened;
    LocalDateTime finishtime;

    String error;

    public SendingResultDTO() {
        super();
    }

    public SendingResultDTO(String id, String status, LocalDateTime inittime, LocalDateTime logsdeleledby, List<String> attachments, List<String> blacklisted, List<String> autoblacklisted, List<String> notvalidrecipients, List<LogDTO> log, List<TrackingDTO> opened, LocalDateTime finishtime, String error) {
        this.id = id;
        this.status = status;
        this.inittime = inittime;
        this.logsdeleledby = logsdeleledby;
        this.attachments = attachments;
        this.blacklisted = blacklisted;
        this.autoblacklisted = autoblacklisted;
        this.notvalidrecipients = notvalidrecipients;
        this.log = log;
        this.opened = opened;
        this.finishtime = finishtime;
        this.error = error;
    }

    public SendingResultDTO(String error)
    {
        this.error = error;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(List<String> blacklisted) {
        this.blacklisted = blacklisted;
    }

    public List<String> getAutoblacklisted() {
        return autoblacklisted;
    }

    public void setAutoblacklisted(List<String> autoblacklisted) {
        this.autoblacklisted = autoblacklisted;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getInittime() {
        return inittime;
    }

    public void setInittime(LocalDateTime inittime) {
        this.inittime = inittime;
    }

    public List<LogDTO> getLog() {
        return log;
    }

    public void setLog(List<LogDTO> log) {
        this.log = log;
    }

    public List<TrackingDTO> getOpened() {
        return opened;
    }

    public void setOpened(List<TrackingDTO> opened) {
        this.opened = opened;
    }

    public LocalDateTime getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(LocalDateTime finishtime) {
        this.finishtime = finishtime;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public List<String> getNotvalidrecipients() {
        return notvalidrecipients;
    }

    public void setNotvalidrecipients(List<String> notvalidrecipients) {
        this.notvalidrecipients = notvalidrecipients;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getLogsdeleledby() {
        return logsdeleledby;
    }

    public void setLogsdeleledby(LocalDateTime logsdeleledby) {
        this.logsdeleledby = logsdeleledby;
    }

    @Override
    public String toString() {
        return "SendingResultDTO{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", inittime=" + inittime +
                ", logsdeleledby=" + logsdeleledby +
                ", attachments=" + attachments +
                ", blacklisted=" + blacklisted +
                ", autoblacklisted=" + autoblacklisted +
                ", notvalidrecipients=" + notvalidrecipients +
                ", log=" + log +
                ", opened=" + opened +
                ", finishtime=" + finishtime +
                ", error='" + error + '\'' +
                '}';
    }
}
