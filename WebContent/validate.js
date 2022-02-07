

function validates(){
	var Username = document.form.uname.value;
	var Email = document.form.email.value;
	var Password1 = document.form.pass.value;
	var Password2 = document.form.pass2.value;
	
	if(Username==null || Username=="")
	{
		alert("User Name should not be empty");
		document.form.uname.focus();
		return false;
	}
	
	else if(Email==null || Email=="")
	{
		alert("Email should not be empty");
		document.form.email.focus();
		return false;
	}
	
	else if(Password1==null || Password1=="")
	{
		alert("Password 1 should not be empty");
		document.form.pass.focus();
		return false;
	}
	
	else if(Password2==null || Password2=="")
	{
		alert("Confirm your password");
		document.form.pass2.focus();
		return false;
	}
	
	
	else if(Password2!=Password1)
	{
		alert("Your password is not matching");
		document.form.pass2.focus();
		return false;
	}
	
	
}