
## 💻 Hardy Client: A Robust Java Client for the QUEUEMAIL.DEV API

### 📌 What if QUEUEMAIL.DEV is temporarily unavailable?

In scenarios such as **network outages** or **API downtime**, your application should gracefully handle failed requests.  
A recommended approach is to implement a **local fallback queue** to store emails that couldn't be sent and retry them later.

---

### ⚙️ Project Setup (Spring Boot)

In this example, we'll use a Spring Boot project similar to  
👉 [queuemail-client: A basic Java client for the QUEUEMAIL.DEV API](https://github.com/queuemail/docs-and-examples/tree/main/queuemail-client)

In your `application.properties` file, configure the following credentials:

```
queuemail.username=******
queuemail.password=******
queuemail.idapp=******
```

- `username` and `password`: Your QUEUEMAIL.DEV account credentials  
- `idapp`: The ID of the app you’ll be using (create it via the [Apps Endpoint](api-apps.md))

---

Create the following DTO to handle email log data returned by QUEUEMAIL:

```
package miapp.queuemail.dto;

import java.time.LocalDateTime;

public class LogDTO {

    private String to;
    private String resultcode;
    private LocalDateTime when;

    private String _id;
    private String idsending;
    private String idsmtp;
    private String idapp;
    private LocalDateTime created;

    // Getters and Setters

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
```

This DTO represents the response from the login endpoint:

```
package miapp.queuemail.dto;

public class LoginResponseDTO {

    private String token;
    private String role;
    private String userId;
    private String username;
    private String clientId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
```

Used for capturing the full result of a send operation, including logs and tracking:

```
package miapp.queuemail.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendingResultDTO {

    private String id;
    private String status;
    private LocalDateTime inittime;
    private LocalDateTime logsdeleledby;
    private List<String> attachments;

    private List<String> blacklisted;
    private List<String> autoblacklisted;
    private List<String> notvalidrecipients;

    private List<LogDTO> log;
    private List<TrackingDTO> opened;
    private LocalDateTime finishtime;

    private String error;
    private Boolean localqueued;

    public SendingResultDTO() {}

    public SendingResultDTO(String id, String status, LocalDateTime inittime, LocalDateTime logsdeleledby,
                            List<String> attachments, List<String> blacklisted, List<String> autoblacklisted,
                            List<String> notvalidrecipients, List<LogDTO> log, List<TrackingDTO> opened,
                            LocalDateTime finishtime, String error) {
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
        this.localqueued = false;
    }

    public SendingResultDTO(String error) {
        this.error = error;
        this.localqueued = false;
    }

    public SendingResultDTO(String error, Boolean localqueued) {
        this.error = error;
        this.localqueued = localqueued;
    }

    // Getters and Setters omitted for brevity (see original for full list)
}
```

Represents open or click tracking events tied to a specific email send operation:

```
package miapp.queuemail.dto;

import java.time.LocalDateTime;

public class TrackingDTO {

    private String email;
    private LocalDateTime when;
    private String _id;
    private String idsending;
    private String idmailing;
    private String type; // OPEN or CLICK
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
```

Next, we'll define two entities to store failed emails in a local queue: 

```
package miapp.queuemail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "queuemails")
public class QueueEmail
{
    @Id
    private String _id;

    private String idapp;

    private String idmailing;

    private String from;

    private String fromname;

    private String to;

    private String toname;

    private String ccs;

    private String bccs;

    private String replyto;

    private String subject;

    private String subjectencoding;

    private String body;

    private String bodyencoding;

    private String mimetype;

    private String attachmentstype;

    private List<String> urlattachments;

    private Boolean includetracking;

    private Boolean includeUnregisterLink;

    private LocalDateTime senddate;

    private Integer numretries;

    private LocalDateTime created;

    private LocalDateTime modified;


    public QueueEmail()
    {
        this.numretries = 0;
        this.created = this.modified = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueueEmail that = (QueueEmail) o;

        return _id.equals(that._id);
    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

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

    public String getIdmailing() {
        return idmailing;
    }

    public void setIdmailing(String idmailing) {
        this.idmailing = idmailing;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getCcs() {
        return ccs;
    }

    public void setCcs(String ccs) {
        this.ccs = ccs;
    }

    public String getBccs() {
        return bccs;
    }

    public void setBccs(String bccs) {
        this.bccs = bccs;
    }

    public String getReplyto() {
        return replyto;
    }

    public void setReplyto(String replyto) {
        this.replyto = replyto;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectencoding() {
        return subjectencoding;
    }

    public void setSubjectencoding(String subjectencoding) {
        this.subjectencoding = subjectencoding;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyencoding() {
        return bodyencoding;
    }

    public void setBodyencoding(String bodyencoding) {
        this.bodyencoding = bodyencoding;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public String getAttachmentstype() {
        return attachmentstype;
    }

    public void setAttachmentstype(String attachmentstype) {
        this.attachmentstype = attachmentstype;
    }

    public Boolean getIncludetracking() {
        return includetracking;
    }

    public void setIncludetracking(Boolean includetracking) {
        this.includetracking = includetracking;
    }

    public Boolean getIncludeUnregisterLink() {
        return includeUnregisterLink;
    }

    public void setIncludeUnregisterLink(Boolean includeUnregisterLink) {
        this.includeUnregisterLink = includeUnregisterLink;
    }

    public LocalDateTime getSenddate() {
        return senddate;
    }

    public void setSenddate(LocalDateTime senddate) {
        this.senddate = senddate;
    }

    public Integer getNumretries() {
        return numretries;
    }

    public void setNumretries(Integer numretries) {
        this.numretries = numretries;
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

    public List<String> getUrlattachments() {
        return urlattachments;
    }

    public void setUrlattachments(List<String> urlattachments) {
        this.urlattachments = urlattachments;
    }
}
```


```
package miapp.queuemail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "queuemails_attachments")
public class QueueEmailAttachment
{
    @Id
    private String _id;

    private String idemail;

    private String filepath;

    private Boolean removeAfterSent;


    public QueueEmailAttachment()
    {
        this.removeAfterSent = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueueEmailAttachment that = (QueueEmailAttachment) o;

        return _id.equals(that._id);
    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdemail() {
        return idemail;
    }

    public void setIdemail(String idemail) {
        this.idemail = idemail;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Boolean getRemoveAfterSent() {
        return removeAfterSent;
    }

    public void setRemoveAfterSent(Boolean removeAfterSent) {
        this.removeAfterSent = removeAfterSent;
    }
}
```

Next, we'll define repositories for these entities:

```
package miapp.queuemail.repositories;

import miapp.queuemail.model.QueueEmail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QueueEmailsRepository extends MongoRepository<QueueEmail, String>
{

	List<QueueEmail> findAll();
}
```


```
package miapp.queuemail.repositories;

import miapp.queuemail.model.QueueEmailAttachment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueEmailAttachmentsRepository extends MongoRepository<QueueEmailAttachment, String>
{

	@Query("{ 'idemail' : ?0 }")
	List<QueueEmailAttachment> findByEmail(String idemail);

	@Query(value="{'idemail' : ?0}", delete = true)
	public void deleteByEmail(String idemail);
}

```

Now we'll implement the service layer, featuring two API endpoints (login and send emails) and a scheduled task to handle the local queue processing:


```
package miapp.queuemail.dev.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import miapp.queuemail.repositories.QueueEmailAttachmentsRepository;
import miapp.queuemail.repositories.QueueEmailsRepository;
import miapp.queuemail.model.QueueEmail;
import miapp.queuemail.model.QueueEmailAttachment;
import miapp.queuemail.dto.LoginResponseDTO;
import miapp.queuemail.dto.SendingResultDTO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



@Service
public class QueuemailHardyService
{
    private static final String API_MAIN_URL = "https://api.queuemail.dev/api";

    @Value("${queuemail.username}")
    private String username;

    @Value("${queuemail.password}")
    private String password;

    @Value("${queuemail.idapp}")
    private String idapp;

    final QueueEmailsRepository queueEmailsRepository;
    final QueueEmailAttachmentsRepository queueEmailAttachmentsRepository;

    public QueuemailHardyService(QueueEmailsRepository queueEmailsRepository, QueueEmailAttachmentsRepository queueEmailAttachmentsRepository)
    {
        this.queueEmailsRepository = queueEmailsRepository;
        this.queueEmailAttachmentsRepository = queueEmailAttachmentsRepository;
    }


    public LoginResponseDTO login() throws Exception
    {
        try
        {
            HttpResponse response = Request.Post(API_MAIN_URL + "/auth/login").bodyForm(Form.form()
                    .add("username", username)
                    .add("password", password)
                    .build()).execute().returnResponse();

            if (response.getStatusLine().getStatusCode() == 200)
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                LoginResponseDTO res =  mapper.readValue(response.getEntity().getContent(), LoginResponseDTO.class);
                return res;
            }
            else if (response.getStatusLine().getStatusCode() == 403)
            {
                throw new Exception("USER_PASSWORD_NOT_VALID");
            }
            else
            {
                throw new Exception("ERROR_LOGIN");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }
    }

    public SendingResultDTO sendEmail(String token,
                                      String from, String fromname, String to, String toname,
                                      String ccs, String bccs, String replyto,
                                      String subject, String subjectencoding, String body, String bodyencoding,
                                      String mimetype,
                                      List<File> attachments,
                                      List<String> urlattachments,
                                      String attachmenttype,
                                      Boolean includetracking,
                                      Boolean includeunregisterlink,
                                      Boolean localqueue,
                                      Boolean removeAttachmentsAfterSent)
    {
        try
        {
            final SendingResultDTO[] res = new SendingResultDTO[1];

            if(token==null) token = this.login().getToken();
            if(token==null)
            {
                return new SendingResultDTO("AUTH_ERROR",
                        this.queueEmail(idapp,
                                from, fromname, to, toname,
                                ccs, bccs, replyto,
                                subject, subjectencoding, body, bodyencoding,
                                mimetype,
                                attachments,
                                urlattachments,
                                attachmenttype,
                                includetracking,
                                includeunregisterlink,
                                localqueue,
                                removeAttachmentsAfterSent));
            }

            HttpPost httppost = new HttpPost(API_MAIN_URL + "/private/emails/send");
            httppost.addHeader("Authorization", "Bearer " + token);

            MultipartEntityBuilder mpeb = MultipartEntityBuilder.create();

            if(attachments!=null && attachments.size()>0)
                for(File mf : attachments)
                {
                    mpeb.addPart("attachments", new FileBody(mf));
                }

            mpeb.addPart("idapp", new StringBody(idapp, ContentType.TEXT_PLAIN));
            if(from!=null) mpeb.addPart("from", new StringBody(from, ContentType.TEXT_PLAIN));
            if(fromname!=null) mpeb.addPart("fromname", new StringBody(fromname, ContentType.TEXT_PLAIN));
            if(to!=null) mpeb.addPart("tos", new StringBody(to, ContentType.TEXT_PLAIN));
            if(toname!=null) mpeb.addPart("tonames", new StringBody(toname, ContentType.TEXT_PLAIN));
            if(ccs!=null) mpeb.addPart("ccs", new StringBody(ccs, ContentType.TEXT_PLAIN));
            if(bccs!=null) mpeb.addPart("bccs", new StringBody(bccs, ContentType.TEXT_PLAIN));
            if(replyto!=null) mpeb.addPart("replyto", new StringBody(replyto, ContentType.TEXT_PLAIN));
            if(subject!=null) mpeb.addPart("subject", new StringBody(subject, ContentType.TEXT_PLAIN));
            if(subjectencoding!=null) mpeb.addPart("subjectencoding", new StringBody(subjectencoding, ContentType.TEXT_PLAIN));
            if(body!=null) mpeb.addPart("body", new StringBody(body, ContentType.TEXT_PLAIN));
            if(bodyencoding!=null) mpeb.addPart("bodyencoding", new StringBody(bodyencoding, ContentType.TEXT_PLAIN));
            if(mimetype!=null) mpeb.addPart("mimetype", new StringBody(mimetype, ContentType.TEXT_PLAIN));
            if(attachmenttype!=null) mpeb.addPart("attachmenttype", new StringBody(attachmenttype, ContentType.TEXT_PLAIN));
            if(urlattachments!=null) mpeb.addPart("urlattachments", new StringBody(String.join(",", urlattachments), ContentType.TEXT_PLAIN));
            if(includetracking!=null) mpeb.addPart("includetracking", new StringBody(""+includetracking, ContentType.TEXT_PLAIN));
            if(includeunregisterlink!=null) mpeb.addPart("includeunregisterlink", new StringBody(""+includeunregisterlink, ContentType.TEXT_PLAIN));

            HttpEntity reqEntity = mpeb.build();
            httppost.setEntity(reqEntity);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new JavaTimeModule());

            try(CloseableHttpClient client = HttpClientBuilder.create().build())
            {
                client.execute(httppost, response -> {
                    if (response.getStatusLine().getStatusCode() == 200)
                    {
                        if(removeAttachmentsAfterSent!=null && removeAttachmentsAfterSent==true)
                            for(File file : attachments) try { file.delete(); } catch (Exception e) { e.printStackTrace();}

                        res[0] = mapper.readValue(response.getEntity().getContent(), SendingResultDTO.class);
                    }
                    else if (response.getStatusLine().getStatusCode() == 401)
                    {
                        res[0] = new SendingResultDTO("Not authorized", false);
                    }
                    else if (response.getStatusLine().getStatusCode() == 403)
                    {
                        res[0] = new SendingResultDTO("Credentials not valid", false);
                    }
                    else if (response.getStatusLine().getStatusCode() == 406)
                    {
                        String responseString = "";
                        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                        String readLine;
                        while (((readLine = br.readLine()) != null)) responseString += readLine;
                        br.close();
                        res[0] = new SendingResultDTO(responseString,
                        this.queueEmail(idapp,
                                from, fromname, to, toname,
                                ccs, bccs, replyto,
                                subject, subjectencoding, body, bodyencoding,
                                mimetype,
                                attachments,
                                urlattachments,
                                attachmenttype,
                                includetracking,
                                includeunregisterlink,
                                localqueue==null?false:localqueue,
                                removeAttachmentsAfterSent==null?false:removeAttachmentsAfterSent));
                    }
                    else
                    {
                        res[0] = new SendingResultDTO("ERROR_SENDING_EMAIL",
                        this.queueEmail(idapp,
                                from, fromname, to, toname,
                                ccs, bccs, replyto,
                                subject, subjectencoding, body, bodyencoding,
                                mimetype,
                                attachments,
                                urlattachments,
                                attachmenttype,
                                includetracking,
                                includeunregisterlink,
                                localqueue==null?false:localqueue,
                                removeAttachmentsAfterSent==null?false:removeAttachmentsAfterSent));
                    }

                    return res[0];
                });


            } catch (Exception e) { throw e; }

            return res[0];
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new SendingResultDTO("GENERAL_ERROR",
                    this.queueEmail(idapp,
                            from, fromname, to, toname,
                            ccs, bccs, replyto,
                            subject, subjectencoding, body, bodyencoding,
                            mimetype,
                            attachments,
                            urlattachments,
                            attachmenttype,
                            includetracking,
                            includeunregisterlink,
                            localqueue==null?false:localqueue,
                            removeAttachmentsAfterSent==null?false:removeAttachmentsAfterSent));
        }
    }


    private boolean queueEmail(String idapp,
                            String from, String fromname, String to, String toname,
                            String ccs, String bccs, String replyto,
                            String subject, String subjectencoding, String body, String bodyencoding,
                            String mimetype,
                            List<File> attachments,
                            List<String> urlattachments,
                            String attachmenttype,
                            Boolean includetracking,
                            Boolean includeunregisterlink,
                            Boolean localqueue,
                            Boolean removeAttachmentsAfterSent)
    {
        try
        {
            if(!localqueue) return  false;

            QueueEmail queueEmail = new QueueEmail();
            queueEmail.setIdapp(idapp);
            queueEmail.setFrom(from);
            queueEmail.setFromname(fromname);
            queueEmail.setTo(to);
            queueEmail.setToname(toname);
            queueEmail.setCcs(ccs);
            queueEmail.setBccs(bccs);
            queueEmail.setReplyto(replyto);
            queueEmail.setSubject(subject);
            queueEmail.setSubjectencoding(subjectencoding);
            queueEmail.setBody(body);
            queueEmail.setBodyencoding(bodyencoding);
            queueEmail.setMimetype(mimetype);
            queueEmail.setUrlattachments(urlattachments);
            queueEmail.setAttachmentstype(attachmenttype);
            queueEmail.setIncludetracking(includetracking);
            queueEmail.setIncludeUnregisterLink(includeunregisterlink);
            queueEmail = this.queueEmailsRepository.save(queueEmail);

            if (attachments != null && attachments.size() > 0)
                for (File file : attachments) {
                    QueueEmailAttachment queueEmailAttachment = new QueueEmailAttachment();
                    queueEmailAttachment.setIdemail(queueEmail.get_id());
                    queueEmailAttachment.setFilepath(file.getAbsolutePath());
                    queueEmailAttachment.setRemoveAfterSent(removeAttachmentsAfterSent);
                    this.queueEmailAttachmentsRepository.save(queueEmailAttachment);
                }

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Scheduled(fixedRate = 1000*60*5) // 5 minutes
    public void processQueuedEmails()
    {
        try
        {
            List<QueueEmail> pendingemails = this.queueEmailsRepository.findAll(); //TODO: improve sorting in order to better selection based on created or numretries
            if(pendingemails==null || pendingemails.size()==0) return;

            System.out.println("\n" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " - Procesing queued email.");

            String token = this.login().getToken();
            if(token==null) throw new Exception("NO VALID TOKEN");

            for(QueueEmail queueEmail : pendingemails)
            {
                try
                {
                    List<File> attachments = null;
                    List<QueueEmailAttachment> qattachments = this.queueEmailAttachmentsRepository.findByEmail(queueEmail.get_id());
                    if(qattachments!=null && qattachments.size()>0)
                    {
                        attachments = new ArrayList<>(qattachments.size());
                        for(QueueEmailAttachment queueEmailAttachment : qattachments)
                            attachments.add(new File(queueEmailAttachment.getFilepath()));
                    }

                    SendingResultDTO sendingResultDTO = this.sendEmail(token,
                            queueEmail.getFrom(), queueEmail.getFromname(),  queueEmail.getTo(), queueEmail.getToname(),
                            queueEmail.getCcs(), queueEmail.getBccs(), queueEmail.getReplyto(),
                            queueEmail.getSubject(), queueEmail.getSubjectencoding(), queueEmail.getBody(), queueEmail.getBodyencoding(),
                            queueEmail.getMimetype(),
                            attachments,
                            queueEmail.getUrlattachments(),
                            queueEmail.getAttachmentstype(),
                            queueEmail.getIncludetracking(),
                            queueEmail.getIncludeUnregisterLink(),
                            false, //at queue process do not queue up again!
                            null);

                    if(sendingResultDTO==null || sendingResultDTO.getStatus()==null || sendingResultDTO.getError()!=null)
                    {
                        queueEmail.setNumretries(queueEmail.getNumretries()+1);
                        queueEmail.setModified(LocalDateTime.now());
                        this.queueEmailsRepository.save(queueEmail);
                    }
                    else
                    {
                        this.queueEmailsRepository.delete(queueEmail);
                        try
                        {
                            if(qattachments!=null && qattachments.size()>0)
                            {
                                for(QueueEmailAttachment queueEmailAttachment : qattachments)
                                   if(queueEmailAttachment.getRemoveAfterSent())
                                       new File(queueEmailAttachment.getFilepath()).delete();
                            }
                        }
                        catch (Exception e) { e.printStackTrace(); }
                        this.queueEmailAttachmentsRepository.deleteByEmail(queueEmail.get_id());
                    }
                }
                catch (Exception e)
                {
                    try { queueEmail.setNumretries(queueEmail.getNumretries()+1); queueEmail.setModified(LocalDateTime.now()); this.queueEmailsRepository.save(queueEmail); } catch (Exception ee) {}
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

```

At this stage, the implementation is complete and ready to replace our existing email delivery mechanism:

```
SendEmail.send( fromemail, toemail, subject, body );
````

with a more reliable implementation:

```
        @Autowired
        QueuemailHardyService queuemailHardyService;

        [...]

		SendingResultDTO sendingResultDTO = this.queuemailHardyService.sendEmail(null, fromemail, "Mi name",  toemail, "Your name", null, null, fromemail,
				subject, "UTF-8", body, "UTF-8", "text/html",
				null, null, null,
				true, false,
				true, null);

		if(sendingResultDTO==null || (sendingResultDTO.getLocalqueued()!=null && sendingResultDTO.getLocalqueued()==false) )
		{
			SendEmail.send( fromemail, toemail, subject, body ); // we will send using usual way as failover
		}
```
This approach allows for enhanced monitoring of email statuses, error codes, and retry attempts. The number of retries for each email in the local queue can be configured via the *SendingResultDTO.numretries* field.


