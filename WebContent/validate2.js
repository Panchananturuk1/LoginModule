

function validates(){
	var Username = document.form.uname.value;
	var Email = document.form.email.value;
	var Password1 = document.form.pass.value;
	var Password2 = document.form.pass2.value;
	//var Password3 = document.form.pass3.value;
	var Gender = document.form.gen.value;
	var intrest = document.form.Interest.value;
//	var Gender2 = document.getEelementById(gens).value;
	
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
	
	
//	 if ( ( form.gen[0].checked == false ) && ( form.gen[1].checked == false ) ) 
//	  {
//	  alert ( "Please choose your Gender: Male or Female" ); 
//	  return false;
//	  }
	
	
	else if(Gender==null || Gender=="")
	{
		alert("Gender select");
		return false;
	}
	
	
	else if(intrest=="-1")
	{
		alert("Please select Field of interest");
		return false;
	}
	
	
	
	
	
	
	
}