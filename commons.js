const MAIN_URL_API = "https://api.queuemail.dev/api";

let isRecaptchaValidated = false;
let captchatoken = '';

function signUp()
{
    let email = document.getElementById("email").value;
    let email2 = document.getElementById("email2").value;

    document.getElementById("msgsignUp").style.display = 'block';

	if(email.length==0 || email2.length==0)
	{
		document.getElementById("msgsignUp").innerHTML = 'You must enter and repeat your email.';
		return;
	}

	if(!validateEmail(email))
	{
		document.getElementById("msgsignUp").innerHTML = 'Please, enter a valid email address.';
		return;
	}

	if(email.trim().toLowerCase() != email2.trim().toLowerCase())
	{
		document.getElementById("msgsignUp").innerHTML = 'Emails do no match.';
		return;
	}
    
    if(!isRecaptchaValidated)
	{
		document.getElementById("msgsignUp").innerHTML = 'Please, validate catcha!.';
		return;
	}


    email = email.trim().toLowerCase();

    document.getElementById('wp-submit').disabled = true;
    const oldvalue = document.getElementById('wp-submit').value; 
    document.getElementById('wp-submit').value = ". . .";

    let formData = new FormData();
	formData.append("email", email);
	formData.append("captchatoken", captchatoken);

	let r = new XMLHttpRequest();
	r.open("POST", MAIN_URL_API + "/auth/signup", true);
	r.send(formData); 
	
	r.onreadystatechange = function () 
	{
		if (r.readyState == 4) 
		{
			document.getElementById('wp-submit').disabled = false;
			document.getElementById('wp-submit').value = oldvalue;

			if (r.status == 200)
			{
				document.getElementById("msgsignUp").innerHTML = 'We have sent you an email with instructions. Please, check your <b>junk mail / SPAM folder</b> too!.';
			}
			else if (r.status == 406)
			{
				document.getElementById("msgsignUp").innerHTML = 'This email is already registered. If you don\'t remember your password, please, <a href="/xrequestnewpassword">try to request a new password</a>.';
			}
			else
			{
				document.getElementById("msgsignUp").innerHTML = 'Sorry, can not sign up at this time. Please, try <a href="#" onclick="javascript:location.reload();">reloading this page</a> and revalidating captcha.';
			}
		}            
	};

}


function requestNewPassword()
{
    let email = document.getElementById("email").value;
    let email2 = document.getElementById("email2").value;

    document.getElementById("msgsignUp").style.display = 'block';

	if(email.length==0 || email2.length==0)
	{
		document.getElementById("msgsignUp").innerHTML = 'You must enter and repeat your email.';
		return;
	}

	if(!validateEmail(email))
	{
		document.getElementById("msgsignUp").innerHTML = 'Please, enter a valid email address.';
		return;
	}

	if(email.trim().toLowerCase() != email2.trim().toLowerCase())
	{
		document.getElementById("msgsignUp").innerHTML = 'Emails do no match.';
		return;
	}
    
    if(!isRecaptchaValidated)
	{
		document.getElementById("msgsignUp").innerHTML = 'Please, validate catcha!.';
		return;
	}


    email = email.trim().toLowerCase();

    document.getElementById('wp-submit').disabled = true;
    const oldvalue = document.getElementById('wp-submit').value; 
    document.getElementById('wp-submit').value = ". . .";

    let formData = new FormData();
	formData.append("username", email);
	formData.append("captchatoken", captchatoken);

	let r = new XMLHttpRequest();
	r.open("POST", MAIN_URL_API + "/auth/requestRememberPassword", true);
	r.send(formData); 
	
	r.onreadystatechange = function () 
	{
		if (r.readyState == 4) 
		{
			document.getElementById('wp-submit').disabled = false;
			document.getElementById('wp-submit').value = oldvalue;

			if (r.status == 200)
			{
				document.getElementById("msgsignUp").innerHTML = 'We have sent you an email with instructions. Please, check your <b>junk mail / SPAM folder</b> too!.';
			}
			else if (r.status == 406)
			{
				document.getElementById("msgsignUp").innerHTML = 'This user must be activated first.';
			}
			else
			{
				document.getElementById("msgsignUp").innerHTML = 'Sorry, can not sign up at this time. Please, try <a href="#" onclick="javascript:location.reload();">reloading this page</a> and revalidating captcha.';
			}
		}            
	};

}

function validateEmail(email) {
    const re =
      /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  }

function onRecaptchaSuccess() {
  captchatoken = grecaptcha.getResponse();
	isRecaptchaValidated = true;
	document.getElementById("msgsignUp").style.display = 'block';
	document.getElementById("msgsignUp").innerHTML = 'Captcha validated correctly.';
}

function onRecaptchaError() {
	isRecaptchaValidated = false;
	document.getElementById("msgsignUp").style.display = 'block';
	document.getElementById("msgsignUp").innerHTML = 'You must validate captcha.';
}

function onRecaptchaResponseExpiry() {
	isRecaptchaValidated = false;
	document.getElementById("msgsignUp").style.display = 'block';
	document.getElementById("msgsignUp").innerHTML = 'Captcha expired. Try again, please.';
  }


  function reloadCaptcha()
  {
      grecaptcha.render('idrecap', { 
				'sitekey' : '6LcIhKImAAAAADT1PcVk7CNyLn5goUuOKuUOj5Tb', 
				'callback' : onRecaptchaSuccess,
                'expired-callback' : onRecaptchaResponseExpiry,
                'error-callback' : onRecaptchaError
			});    

        document.getElementById("msgrecap").style.display = 'none';
  }
