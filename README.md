# <b>Communique</b>

Communique is a microservice responsible for any communication from the application to subscribers of the application or subscriber’s customers. The service is responsible for delivering any communication (both transactional and notification) emails/sms.

## Pre-requisites

**Application uses the below environment/platform**
- MySQL
- Java 8+
- Spring Boot
- Swagger2
- SendGrid Email API

## Clone

- Clone this repo to your local machine using `https://github.com/premkumarmcse/Spring-Boot.git`

## Usage

### Send Email API

> Use of this API is to send an email to single recipient

```
From Email Address: pkm@gmail.com
To: any single email address

i.e. "abc@gmail.com"
```

### Send Bulk Email API

> Use of this API is to send email to multiple recipients by seperating the email address by ';'

```
From Email Address: pkm@gmail.com
To: Multiple email address seperated by using ';'

i.e. "abc@gmail.com;ngk@gmail.com;grg@gmail.com"
```

### Update Email Limits API

> Use of this API is to update the maximum email limits

- For now, Admin users only able to change their maximum email limits which is predefined.

```
userName: Admin username
newMaxLimit: The new max email limits
```

## Credits

> Author

| <a href="https://github.com/aldrineeinsteen" target="_blank">**Aldrine Einsteen**</a> |
| :---: |
