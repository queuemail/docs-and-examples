package queuemail.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;
import queuemail.client.dto.*;
import queuemail.client.service.BasicService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class QueuemailClientApplication implements ApplicationRunner
{

    /* TO RUN, PLEASE, FIRST CONFIGURE THE ###VARS### BELOW: */

    @Autowired
    private BasicService basicService;

    public static void main(String[] args) {
        SpringApplication.run(QueuemailClientApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {

        try
        {
            // STEP 1 - LOGIN TO GET TOKEN
            String token = this.basicService.login().getToken();
            System.out.println("Using token: " + token);


            // STEP 2 - SELECT APP TO USE OR CREATE A NEW ONE
            String idapptouse = null;
            List<AppDTO> myapps = this.basicService.getApps(token);
            if(myapps==null || myapps.size()==0)
            {
                idapptouse = this.basicService.createApp(token, "MYAPP1", true, "PRIORITY", null, null,
                        null, null, null,
                        null, true, true,
                        null, null, null,
                        null, null).get_id();
                System.out.println("Using new app " + idapptouse);
            }
            else
            {
                idapptouse = myapps.get(0).get_id();
                System.out.println("Using app " + idapptouse);
            }

            // STEP 3 - IF NO SMTP, WE ADD A NEW ONE (AT LEAST) TO APP
            List<SMTPDTO> mysmtps = this.basicService.getSMTPs(token, idapptouse);
            if(mysmtps==null || mysmtps.size()==0)
            {
                this.basicService.createSMTP(token, idapptouse, 10, "smtp.gmail.com", 587, "###MYADDRESS###@gmail.com",
                        "###MYAPPLICATIONPASSWORD###", true, true,
                        false, false, null, null);
                System.out.println("Created new SMTP for idapp " + idapptouse);
            }
            else
            {
                idapptouse = myapps.get(0).get_id();
                System.out.println("There exists SMTPs for idapp " + idapptouse);
            }


            // AT THIS POINT WE CAN CREATE OTHER SMTP SERVERS ...


            // STEP 4 - WE SEND AN EMAIL USING OUR APP
            SendingResultDTO sendingResultDTO = this.basicService.sendEmail(token, idapptouse,
                    "###MYADDRESS###@gmail.com", "###MYNAME###",  "###RECCIPIENTADDRESS1###,###RECCIPIENTADDRESS2###", "###RECCIPIENTNAME1###,###RECCIPIENTNAME2###",
                    null, null, null,
                    "Queuemail-client test", "UTF-8", "Yes, this is <b>a moon</b> and <a href=\"https://docs.queuemail.dev\">this is a link</a>", "UTF-8",
                    "text/plain",
                    null,
                    new ArrayList<String>(Arrays.asList("https://cdn.jsdelivr.net/npm/docsify-darklight-theme@latest/icons/moon.svg")),
                    "FILE",
                    true,
                    true);


            System.out.println(sendingResultDTO.toString());



            // STEP 5 -  AT ANY TIME, WE CAN QUERY EMAIL INFO AND CARRY OUT ACTIONS ACCORDING TO IT (EXAMPLE IN A BLOCKING WAY, YOU CAN DEVELOP A NON-BLOCKING SOLUTION)
            while(true)
            {
                SendingResultDTO info = this.basicService.getEmailInfo(token, sendingResultDTO.getId());
                if(info!=null)
                {
                    if(info.getStatus().equals("Q"))
                        System.out.println("Email is already queued.");
                    else if(info.getStatus().equals("R"))
                        System.out.println("Email is been sending at now.");
                    else if(info.getStatus().equals("C"))
                    {
                        System.out.println("Email has been canceled.");
                        break;
                    }
                    else if(info.getStatus().equals("E"))
                    {
                        System.out.println("Email sent has failed.");
                        break;
                    }
                    else if(info.getStatus().equals("F"))
                    {
                        System.out.println("Email has been sent sucessfully.");
                        break;
                    }
                    else
                        System.out.println(info);
                }
                else
                {
                    System.out.println("Error getting email info");
                    break;
                }

                Thread.sleep(5000);

            }


            // STEP 6 - AT ANY TIME, WE CAN QUERY LOGS AND CARRY OUT ACTIONS ACCORDING TO THEM (EXAMPLE IN A BLOCKING WAY, YOU CAN DEVELOP A NON-BLOCKING SOLUTION)
            while(true)
            {
                List<LogDTO> logs = this.basicService.getLogs(token, sendingResultDTO.getId());
                if(logs!=null && logs.size()>0)
                {
                    boolean finished = false;
                    for(LogDTO log : logs)
                    {
                        if(log.getResultcode().equals("BLACKLISTED"))
                            System.out.println("Recipient " + log.getTo() + " has been blacklisted.");

                        else if(log.getResultcode().equals("AUTOBLACKLISTED"))
                            System.out.println("Recipient " + log.getTo() + " has been blacklisted.");

                        else if(log.getResultcode().equals("NO_EFFECTIVE_RECIPIENTS"))
                            System.out.println("No recipients to sent.");

                        else if(log.getResultcode().equals("OK"))
                        {
                            System.out.println("Email sent sucessfully to " + log.getTo());
                            finished = true;
                        }
                        else
                        {
                            if(log.getTo()==null) System.out.println(log.getResultcode());
                            else System.out.println(log.getTo() + ": " + log.getResultcode());
                            finished = true;
                        }
                    }
                    if(finished) break;
                }
                Thread.sleep(5000);
            }



            // STEP 7 - AT ANY TIME, WE CAN QUERY TRACKING INFO AND CARRY OUT ACTIONS ACCORDING TO THEM (EXAMPLE IN A BLOCKING WAY, YOU CAN DEVELOP A NON-BLOCKING SOLUTION)
            // OPEN / CLICK THE LINK IN AT LEAST A RECEIVED EMAIL TO BREAK THE LOOP. FOR OPEN DETECTION, MAIL CLIENT MUST HAVE ENABLED "SHOW IMAGES".
            while(true)
            {
                List<TrackingDTO> trackinglist = this.basicService.getTracking(token, sendingResultDTO.getId());
                if(trackinglist!=null && trackinglist.size()>0)
                {
                    boolean finished = false;
                    for(TrackingDTO tracking : trackinglist)
                    {
                        if(tracking.getType().equals("OPEN"))
                        {
                            System.out.println("Recipient " + tracking.getEmail() + " opened email.");
                            finished = true;
                        }
                        else if(tracking.getType().equals("CLICK"))
                        {
                            System.out.println("Recipient " + tracking.getEmail() + " has clicked " + tracking.getUrl());
                            finished = true;
                        }

                    }
                    if(finished) break;
                }
                Thread.sleep(5000);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }





    }


}
