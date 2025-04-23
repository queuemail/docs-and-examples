## ❓ Frequently Asked Questions

---

### ⚠️ What happens if there are network outages or QUEUEMAIL.DEV is temporarily unavailable?

To ensure reliability during outages or temporary API downtimes, we recommend implementing a **local queue** that stores emails and retries them later when the service is back online.

You can see a practical implementation of this in the  
👉 [Hardy Client Example](examples-hardyservice.md)

---

### 📈 How many API requests can I make?

QUEUEMAIL.DEV uses built-in protections against brute force and DDoS attacks.

- While it’s generally safe to make **more than one request per second**, we **recommend spacing out your requests** by at least 1 second.
- The system analyzes various parameters to distinguish normal usage from potential abuse.

**Best practice:**  
Always implement a [robust sending mechanism with a local queue](examples-hardyservice.md).  
If your IP gets temporarily blocked, the local queue will automatically retry sending the pending emails.

---

### 📬 Can I send emails using my own domain?

#### ✅ Free Tier

You have two options:

1. **Use your own SMTP server** for your domain — you can freely send emails using addresses from that domain.

2. **Use third-party SMTP providers** (like Gmail/Google) that support custom "From" addresses.  
   Follow their specific configuration instructions to enable sending from your domain.

#### 🚀 Professional Queuemail SMTP

With a custom plan using Queuemail’s professional SMTP servers, you’ll receive instructions for configuring your **domain’s DNS settings** (e.g., SPF, DKIM, DMARC).  
This allows you to send authenticated emails from your custom domain with full compliance.

---
