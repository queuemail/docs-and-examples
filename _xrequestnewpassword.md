<h3>Please enter your email and click "Request New Password":</h3>

<!--RPP-->

<form action="#" method="post" class="wpcf7-form init" novalidate="novalidate" data-status="init">

  <p>
    <span>
      <input
        placeholder="Enter your email"
        style="padding:10px !important; width:100% !important"
        id="email"
        type="email"
        name="your-email"
        value=""
        size="80"
        aria-required="true"
        aria-invalid="false"
      />
    </span>
  </p>

  <p>
    <span>
      <input
        placeholder="Confirm your email"
        style="padding:10px !important; width:100% !important"
        id="email2"
        type="email"
        name="your-email2"
        value=""
        size="80"
        aria-required="true"
        aria-invalid="false"
      />
    </span>
  </p>

  <p>
    <div
      id="idrecap"
      class="g-recaptcha"
      data-sitekey="6LcIhKImAAAAADT1PcVk7CNyLn5goUuOKuUOj5Tb"
      data-callback="onRecaptchaSuccess"
      data-expired-callback="onRecaptchaResponseExpiry"
      data-error-callback="onRecaptchaError"
    ></div>
    <span id="msgrecap">
      (If reCAPTCHA does not appear, please <a style="cursor:pointer" onclick="reloadCaptcha();">click here</a>)
    </span>
  </p>

  <div
    id="msgsignUp"
    class="wpcf7-response-output"
    style="margin-top:20px; display:none; color:red !important"
    aria-hidden="true"
  ></div>

  <div style="width:100%; text-align:right !important;">
    <input
      id="wp-submit"
      type="button"
      onclick="requestNewPassword();"
      style="cursor:pointer; padding:10px !important; font-weight:bold !important; margin-top:10px !important"
      value="Request New Password"
    />
  </div>

</form>

<!--FIN RPP-->
