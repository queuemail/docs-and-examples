package queuemail.client.service;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import queuemail.client.dto.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

@Service
@Component
public class BasicService
{
    private static final String API_MAIN_URL = "https://api.queuemail.dev/api";

    @Value("${queuemail.username}")
    private String username;

    @Value("${queuemail.password}")
    private String password;

    public LoginResponseDTO login() throws Exception
    {
        try
        {
            System.out.println("Login call...");
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


    public List<AppDTO> getApps(String token) throws Exception
    {
        try
        {
            System.out.println("Get apps call...");
            HttpResponse response = Request.Get(API_MAIN_URL + "/private/apps/findAll?page=0&size=100").addHeader("Authorization", "Bearer " + token).execute().returnResponse();

            if (response.getStatusLine().getStatusCode() == 200)
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new JavaTimeModule());
                RestResponsePageDTO<AppDTO> res =  mapper.readValue(response.getEntity().getContent(), new TypeReference<RestResponsePageDTO<AppDTO>>() {});
                return res.getContent();
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


    public AppDTO createApp(String token, String name, Boolean retaindata, String strategy, String originserver, String origindomain,
                            String defaultfromemail, String defaultfromname, String testemail,
                            Long timebetweenemails, Boolean useblacklist, Boolean useautoblacklist,
                            String webhook_sending_finished, String webhook_sending_error, String webhook_tracking_opened,
                            String webhook_tracking_clicked, String webhook_blacklisted_added) throws Exception
    {
        try
        {
            System.out.println("Create app call...");
            HttpResponse response = Request.Post(API_MAIN_URL + "/private/apps/save").addHeader("Authorization", "Bearer " + token).bodyForm(Form.form()
                    .add("name", name)
                    .add("retaindata", retaindata==null?null:(""+retaindata))
                    .add("strategy", strategy)
                    .add("originserver", originserver)
                    .add("origindomain", origindomain)
                    .add("defaultfromemail", defaultfromemail)
                    .add("defaultfromname", defaultfromname)
                    .add("testemail", testemail)
                    .add("timebetweenemails", timebetweenemails==null?null:(""+timebetweenemails))
                    .add("useblacklist", useblacklist==null?null:(""+useblacklist))
                    .add("useautoblacklist", useautoblacklist==null?null:(""+useautoblacklist))
                    .add("webhook_sending_finished", webhook_sending_finished)
                    .add("webhook_sending_error", webhook_sending_error)
                    .add("webhook_tracking_opened", webhook_tracking_opened)
                    .add("webhook_tracking_clicked", webhook_tracking_clicked)
                    .add("webhook_blacklisted_added", webhook_blacklisted_added)
                    .build()).execute().returnResponse();

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new JavaTimeModule());

            if (response.getStatusLine().getStatusCode() == 200)
            {
                AppDTO res =  mapper.readValue(response.getEntity().getContent(), AppDTO.class);
                return res;
            }
            else if (response.getStatusLine().getStatusCode() == 401)
            {
                throw new Exception("Not authorized");
            }
            else if (response.getStatusLine().getStatusCode() == 403)
            {
                throw new Exception("Credentials not valid");
            }
            else if (response.getStatusLine().getStatusCode() == 406)
            {
                String responseString = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String readLine;
                while (((readLine = br.readLine()) != null)) {
                    responseString += readLine;
                }
                br.close();
                throw new Exception(responseString);
            }
            else
            {
                throw new Exception("ERROR_CREATING_APP");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }
    }



    public List<SMTPDTO> getSMTPs(String token, String idapp) throws Exception
    {
        try
        {
            System.out.println("Get SMTP servers call...");
            HttpResponse response = Request.Get(API_MAIN_URL + "/private/smtps/findByApp?idapp=" + idapp).addHeader("Authorization", "Bearer " + token).execute().returnResponse();

            if (response.getStatusLine().getStatusCode() == 200)
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new JavaTimeModule());
                List<SMTPDTO> res =  mapper.readValue(response.getEntity().getContent(), new TypeReference<List<SMTPDTO>>() {});
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




    public void createSMTP(String token, String idapp, Integer priority, String host, Integer port, String username, String password, Boolean auth, Boolean starttls, Boolean sslTls, Boolean debug, String defaultfromemail, String defaultfromname) throws Exception
    {
        try
        {
            System.out.println("Create SMTP server call...");
            HttpResponse response = Request.Post(API_MAIN_URL + "/private/smtps/save").addHeader("Authorization", "Bearer " + token).bodyForm(Form.form()
                    .add("idapp", idapp)
                    .add("priority", priority==null?null:(""+priority))
                    .add("host", host)
                    .add("port", port==null?null:(""+port))
                    .add("username", username)
                    .add("password", password)
                    .add("auth", auth==null?null:(""+auth))
                    .add("starttls", starttls==null?null:(""+starttls))
                    .add("sslTls", sslTls==null?null:(""+sslTls))
                    .add("debug", debug==null?null:(""+debug))
                    .add("defaultfromemail", defaultfromemail)
                    .add("defaultfromname", defaultfromname)
                    .build()).execute().returnResponse();

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new JavaTimeModule());

            if (response.getStatusLine().getStatusCode() == 200)
            {
                SMTPDTO res =  mapper.readValue(response.getEntity().getContent(), SMTPDTO.class);
                return;
            }
            else if (response.getStatusLine().getStatusCode() == 401)
            {
                throw new Exception("Not authorized");
            }
            else if (response.getStatusLine().getStatusCode() == 403)
            {
                throw new Exception("Credentials not valid");
            }
            else if (response.getStatusLine().getStatusCode() == 406)
            {
                String responseString = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String readLine;
                while (((readLine = br.readLine()) != null)) {
                    responseString += readLine;
                }
                br.close();
                throw new Exception(responseString);
            }
            else
            {
                throw new Exception("ERROR_CREATING_SMTP");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }
    }



    public SendingResultDTO sendEmail(String token, String idapp,
                          String from, String fromname, String to, String toname,
                          String ccs, String bccs, String replyto,
                          String subject, String subjectencoding, String body, String bodyencoding,
                          String mimetype,
                          List<MultipartFile> attachments,
                          List<String> urlattachments,
                          String attachmenttype,
                          Boolean includetracking,
                          Boolean includeunregisterlink) throws Exception
    {
        final SendingResultDTO[] res = new SendingResultDTO[1];

        try
        {
            System.out.println("Send email call...");
            HttpPost httppost = new HttpPost(API_MAIN_URL + "/private/emails/send");
            httppost.addHeader("Authorization", "Bearer " + token);

            MultipartEntityBuilder mpeb = MultipartEntityBuilder.create();

            if(attachments!=null && attachments.size()>0)
                for(MultipartFile mf : attachments)
                {
                    mpeb.addPart("attachments", new FileBody(multipartToFile(mf)));
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
                        res[0] = mapper.readValue(response.getEntity().getContent(), SendingResultDTO.class);
                    }
                    else if (response.getStatusLine().getStatusCode() == 401)
                    {
                        res[0] = new SendingResultDTO("Not authorized");
                    }
                    else if (response.getStatusLine().getStatusCode() == 403)
                    {
                        res[0] = new SendingResultDTO("Credentials not valid");
                    }
                    else if (response.getStatusLine().getStatusCode() == 406)
                    {
                        String responseString = "";
                        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                        String readLine;
                        while (((readLine = br.readLine()) != null)) {
                            responseString += readLine;
                        }
                        br.close();
                        res[0] = new SendingResultDTO(responseString);
                    }
                    else
                    {
                        res[0] = new SendingResultDTO("ERROR_SENDING EMAIL");
                    }
                    return res[0];
                });

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }

        return res[0];
    }


    public SendingResultDTO getEmailInfo(String token, String idemail) throws Exception
    {
        try
        {
            System.out.println("Get email info call...");
            HttpResponse response = Request.Get(API_MAIN_URL + "/private/emails/info?idemail=" + idemail).addHeader("Authorization", "Bearer " + token).execute().returnResponse();

            if (response.getStatusLine().getStatusCode() == 200)
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new JavaTimeModule());
                SendingResultDTO res =  mapper.readValue(response.getEntity().getContent(), SendingResultDTO.class);
                return res;
            }
            else if (response.getStatusLine().getStatusCode() == 401)
            {
                throw new Exception("Not authorized");
            }
            else if (response.getStatusLine().getStatusCode() == 403)
            {
                throw new Exception("Credentials not valid");
            }
            else if (response.getStatusLine().getStatusCode() == 406)
            {
                String responseString = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String readLine;
                while (((readLine = br.readLine()) != null)) {
                    responseString += readLine;
                }
                br.close();
                throw new Exception(responseString);
            }
            else
            {
                throw new Exception("ERROR_GETTING_EMAIL_INFO");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }
    }


    public List<LogDTO> getLogs(String token, String idemail) throws Exception
    {
        try
        {
            System.out.println("Get email logs call...");
            HttpResponse response = Request.Get(API_MAIN_URL + "/private/logs/findByEMail?idemail=" + idemail).addHeader("Authorization", "Bearer " + token).execute().returnResponse();

            if (response.getStatusLine().getStatusCode() == 200)
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new JavaTimeModule());
                List<LogDTO> res =  mapper.readValue(response.getEntity().getContent(), new TypeReference<List<LogDTO>>() {});
                return res;
            }
            else if (response.getStatusLine().getStatusCode() == 401)
            {
                throw new Exception("Not authorized");
            }
            else if (response.getStatusLine().getStatusCode() == 403)
            {
                throw new Exception("Credentials not valid");
            }
            else if (response.getStatusLine().getStatusCode() == 406)
            {
                String responseString = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String readLine;
                while (((readLine = br.readLine()) != null)) {
                    responseString += readLine;
                }
                br.close();
                throw new Exception(responseString);
            }
            else
            {
                throw new Exception("ERROR_GETTING_LOGS");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }
    }



    public List<TrackingDTO> getTracking(String token, String idemail) throws Exception
    {
        try
        {
            System.out.println("Get tracking call...");
            HttpResponse response = Request.Get(API_MAIN_URL + "/private/tracking/findByEMail?idemail=" + idemail).addHeader("Authorization", "Bearer " + token).execute().returnResponse();

            if (response.getStatusLine().getStatusCode() == 200)
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new JavaTimeModule());
                List<TrackingDTO> res =  mapper.readValue(response.getEntity().getContent(), new TypeReference<List<TrackingDTO>>() {});
                return res;
            }
            else if (response.getStatusLine().getStatusCode() == 401)
            {
                throw new Exception("Not authorized");
            }
            else if (response.getStatusLine().getStatusCode() == 403)
            {
                throw new Exception("Credentials not valid");
            }
            else if (response.getStatusLine().getStatusCode() == 406)
            {
                String responseString = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String readLine;
                while (((readLine = br.readLine()) != null)) {
                    responseString += readLine;
                }
                br.close();
                throw new Exception(responseString);
            }
            else
            {
                throw new Exception("ERROR_GETTING_TRACKING");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("GENERAL_ERROR");
        }
    }



    //TO-DO: Must remove temporal files
    private static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+ UUID.randomUUID() + ".tmp");
        multipart.transferTo(convFile);
        return convFile;
    }

}
