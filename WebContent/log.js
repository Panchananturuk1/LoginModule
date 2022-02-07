function validates(){
	var Username = document.form.uname.value;

	var Password1 = document.form.pass.value;

	
	if(Username==null || Username=="")
	{
		alert("User Name should not be empty");
		document.form.uname.focus();
		return false;
	}
	
	else if(Password1==null || Password1=="")
	{
		alert("Password 1 should not be empty");
		document.form.pass.focus();
		return false;
	}
}