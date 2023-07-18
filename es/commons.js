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
		document.getElementById("msgsignUp").innerHTML = 'Debes escribir y repetir tu email.';
		return;
	}

	if(!validateEmail(email))
	{
		document.getElementById("msgsignUp").innerHTML = 'Por favor, escribe una dirección de emial válida.';
		return;
	}

	if(email.trim().toLowerCase() != email2.trim().toLowerCase())
	{
		document.getElementById("msgsignUp").innerHTML = 'Las direcciones de email no coinciden.';
		return;
	}
    
    if(!isRecaptchaValidated)
	{
		document.getElementById("msgsignUp").innerHTML = 'Por favor, valida el captcha!.';
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
				document.getElementById("msgsignUp").innerHTML = 'Te hemos enviado un email con instrucciones. Por favor, comprueba también la <b>carpeta de correo no deseado / SPAM</b>.';
			}
			else if (r.status == 406)
			{
				document.getElementById("msgsignUp").innerHTML = 'Este email ya ha sido registrado. Si no recuerdas tu contraseña, por favor, <a href="/es/xrequestnewpassword">intenta pedir una nueva contraseña</a>.';
			}
			else
			{
				document.getElementById("msgsignUp").innerHTML = 'Lo sentimos, no puedes registrarte en este momento. Por favor, intenta <a href="#" onclick="javascript:location.reload();">recargar la página</a> y re-validar el captcha.';
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
		document.getElementById("msgsignUp").innerHTML = 'Debes escribir y repetir tu email.';
		return;
	}

	if(!validateEmail(email))
	{
		document.getElementById("msgsignUp").innerHTML = 'Por favor, escribe una dirección de emial válida.';
		return;
	}

	if(email.trim().toLowerCase() != email2.trim().toLowerCase())
	{
		document.getElementById("msgsignUp").innerHTML = 'Las direcciones de email no coinciden.';
		return;
	}
    
    if(!isRecaptchaValidated)
	{
		document.getElementById("msgsignUp").innerHTML = 'Por favor, valida el captcha!.';
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
				document.getElementById("msgsignUp").innerHTML = 'Te hemos enviado un email con instrucciones. Por favor, comprueba también la <b>carpeta de correo no deseado / SPAM</b>.';
			}
			else if (r.status == 406)
			{
				document.getElementById("msgsignUp").innerHTML = 'Debes activar el usuario primero.';
			}
			else
			{
				document.getElementById("msgsignUp").innerHTML = 'Lo sentimos, no puedes registrarte en este momento. Por favor, intenta <a href="#" onclick="javascript:location.reload();">recargar la página</a> y re-validar el captcha.';
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
	document.getElementById("msgsignUp").innerHTML = 'Captcha validado correctamente.';
}

function onRecaptchaError() {
	isRecaptchaValidated = false;
	document.getElementById("msgsignUp").style.display = 'block';
	document.getElementById("msgsignUp").innerHTML = 'Debes validar el captcha.';
}

function onRecaptchaResponseExpiry() {
	isRecaptchaValidated = false;
	document.getElementById("msgsignUp").style.display = 'block';
	document.getElementById("msgsignUp").innerHTML = 'Captcha caducado. Intenta validarlo de nuevo, por favor.';
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
