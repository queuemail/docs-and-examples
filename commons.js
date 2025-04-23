const MAIN_URL_API = "https://api.queuemail.dev/api";

let isRecaptchaValidated = false;
let captchatoken = '';

function signUp() {
    let email = document.getElementById("email").value;
    let email2 = document.getElementById("email2").value;

    document.getElementById("msgsignUp").style.display = 'block';

    if (email.length === 0 || email2.length === 0) {
        document.getElementById("msgsignUp").innerHTML = 'Please enter and confirm your email address.';
        return;
    }

    if (!validateEmail(email)) {
        document.getElementById("msgsignUp").innerHTML = 'Please enter a valid email address.';
        return;
    }

    if (email.trim().toLowerCase() !== email2.trim().toLowerCase()) {
        document.getElementById("msgsignUp").innerHTML = 'The email addresses do not match.';
        return;
    }

    if (!isRecaptchaValidated) {
        document.getElementById("msgsignUp").innerHTML = 'Please complete the CAPTCHA verification.';
        return;
    }

    email = email.trim().toLowerCase();

    document.getElementById('wp-submit').disabled = true;
    const oldvalue = document.getElementById('wp-submit').value;
    document.getElementById('wp-submit').value = "...";

    let formData = new FormData();
    formData.append("email", email);
    formData.append("captchatoken", captchatoken);

    let r = new XMLHttpRequest();
    r.open("POST", MAIN_URL_API + "/auth/signup", true);
    r.send(formData);

    r.onreadystatechange = function () {
        if (r.readyState === 4) {
            document.getElementById('wp-submit').disabled = false;
            document.getElementById('wp-submit').value = oldvalue;

            if (r.status === 200) {
                document.getElementById("msgsignUp").innerHTML = 'An email with instructions has been sent. Please also check your <b>spam or junk folder</b>.';
            } else if (r.status === 406) {
                document.getElementById("msgsignUp").innerHTML = 'This email is already registered. If you forgot your password, please <a href="/xrequestnewpassword">request a new one here</a>.';
            } else {
                document.getElementById("msgsignUp").innerHTML = 'Unable to sign up at the moment. Please <a href="#" onclick="javascript:location.reload();">reload the page</a> and try again.';
            }
        }
    };
}

function requestNewPassword() {
    let email = document.getElementById("email").value;
    let email2 = document.getElementById("email2").value;

    document.getElementById("msgsignUp").style.display = 'block';

    if (email.length === 0 || email2.length === 0) {
        document.getElementById("msgsignUp").innerHTML = 'Please enter and confirm your email address.';
        return;
    }

    if (!validateEmail(email)) {
        document.getElementById("msgsignUp").innerHTML = 'Please enter a valid email address.';
        return;
    }

    if (email.trim().toLowerCase() !== email2.trim().toLowerCase()) {
        document.getElementById("msgsignUp").innerHTML = 'The email addresses do not match.';
        return;
    }

    if (!isRecaptchaValidated) {
        document.getElementById("msgsignUp").innerHTML = 'Please complete the CAPTCHA verification.';
        return;
    }

    email = email.trim().toLowerCase();

    document.getElementById('wp-submit').disabled = true;
    const oldvalue = document.getElementById('wp-submit').value;
    document.getElementById('wp-submit').value = "...";

    let formData = new FormData();
    formData.append("username", email);
    formData.append("captchatoken", captchatoken);

    let r = new XMLHttpRequest();
    r.open("POST", MAIN_URL_API + "/auth/requestRememberPassword", true);
    r.send(formData);

    r.onreadystatechange = function () {
        if (r.readyState === 4) {
            document.getElementById('wp-submit').disabled = false;
            document.getElementById('wp-submit').value = oldvalue;

            if (r.status === 200) {
                document.getElementById("msgsignUp").innerHTML = 'An email with instructions has been sent. Please also check your <b>spam or junk folder</b>.';
            } else if (r.status === 406) {
                document.getElementById("msgsignUp").innerHTML = 'This account must be activated before requesting a password reset.';
            } else {
                document.getElementById("msgsignUp").innerHTML = 'Unable to process your request. Please <a href="#" onclick="javascript:location.reload();">reload the page</a> and try again.';
            }
        }
    };
}

function validateEmail(email) {
    const re =
        /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function onRecaptchaSuccess() {
    captchatoken = grecaptcha.getResponse();
    isRecaptchaValidated = true;
    document.getElementById("msgsignUp").style.display = 'block';
    document.getElementById("msgsignUp").innerHTML = 'CAPTCHA successfully verified.';
}

function onRecaptchaError() {
    isRecaptchaValidated = false;
    document.getElementById("msgsignUp").style.display = 'block';
    document.getElementById("msgsignUp").innerHTML = 'CAPTCHA verification failed. Please try again.';
}

function onRecaptchaResponseExpiry() {
    isRecaptchaValidated = false;
    document.getElementById("msgsignUp").style.display = 'block';
    document.getElementById("msgsignUp").innerHTML = 'CAPTCHA expired. Please verify again.';
}

function reloadCaptcha() {
    grecaptcha.render('idrecap', {
        'sitekey': '6LcIhKImAAAAADT1PcVk7CNyLn5goUuOKuUOj5Tb',
        'callback': onRecaptchaSuccess,
        'expired-callback': onRecaptchaResponseExpiry,
        'error-callback': onRecaptchaError
    });

    document.getElementById("msgrecap").style.display = 'none';
}
