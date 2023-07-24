### What happens if there are network outages or server downtime while calling QUEUEMAIL.DEV API?

The solution is to implement a local queue to store failed emails when QUEUEMAIL.DEV does not respond.

[Hardy client example](examples-hardyservice.md) shows you how to implement this local queue.

### How many requests can I do?

QUEUEMAIL.DEV servers implement protections against brute force or DDoS attacks so it is a good idea to space out your API requests by at least 1 second. No problem if you make more requests in 1 second, the protection system evaluates other parameters to find out if it is an attack or a normal use API but in any case we recommend that you always implement a [robust sending with local queue](examples-hardyservice.md) so that if at any moment your source IP is temporarily banned, local queue will take care to retry pending emails.

### Can I send emails using my custom domain email address?

* With free tier: 
    - You can use a SMTP server from your own domain and you can send without problems using addresses from that domain.

    Or..

    - Some SMTP servers like Gmail/Google allows you to send emails using your email address. Follow the instructions for each SMTP server to set up sending with your custom domain.

* With profesional custom Queuemail SMTP servers: We will send you instructions to make domain DNS zone changes in order you can send emails using your custom domain.

