## 🛑 Blacklist and Auto-Blacklist Features

The blacklist feature allows recipients to opt out of future emails by adding their email address to a blacklist.  
This prevents the associated app from sending them any more emails.

In addition, QUEUEMAIL.DEV supports **auto-blacklisting**:  
When the system detects that an email address consistently returns **permanent errors**, it will automatically be added to the app’s auto-blacklist.

---

### 📌 How It Works

- Each **App** can maintain both:
  - A **Blacklist** (manually opted out by the recipient)
  - An **Auto-Blacklist** (triggered by system-detected delivery failures)

---

### ✅ Activation

To enable these features, configure the following options when [creating or editing your app](api-apps.md):

- To enable manual blacklisting:  
  `useblacklist=true`

- To enable automatic blacklisting:  
  `useautoblacklist=true`
