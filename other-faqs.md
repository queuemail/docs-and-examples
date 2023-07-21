### What happens if there are network outages or server downtime while calling QUEUEMAIL.DEV API?

The solution is to implement a local queue to store failed emails when QUEUEMAIL.DEV does not respond.

[Hardy client example](examples-hardyservice.md) shows you how to implement this local queue.


### Can I send emails using my custom domain email address?

* With free tier: 
    - You can use a SMTP server from your own domain and you can send without problems using addresses from that domain.

    Or..

    - Some SMTP servers like Gmail/Google allows you to send emails using your email address. Follow the instructions for each SMTP server to set up sending with your custom domain.

* With profesional custom Queuemail SMTP servers: We will send you instructions to make domain DNS zone changes in order you can send emails using your custom domain.

