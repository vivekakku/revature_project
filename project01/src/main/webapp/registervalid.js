form.addEventListener('submit', function (e) {
    e.preventDefault()
	alert("check1");
    checkInputs()
    if ( 
        document.getElementById("errorCustid").innerText === "" &&
        document.getElementById("errorCustName").innerText === "" &&
        document.getElementById("errorCustGender").innerText === "" &&
        document.getElementById("errorEmailid").innerText === "" &&
        document.getElementById("errorPhoneNumber").innerText === "" &&
        document.getElementById("errorCustPassword").innerText === ""
    ) {
        console.log("no errors");
        let url = "http://localhost:8080/project01/banker";
        fetch(url, {
            method: 'post',
            body: JSON.stringify({
                cust_id: document.getElementById('cust_id').value,
                cust_name: document.getElementById('cust_name').value,
                cust_gender: document.getElementById('cust_gender').value,
                cust_emailId: document.getElementById('cust_emailId').value,
                cust_phno: document.getElementById('cust_phno').value,
                cust_pwd: document.getElementById('cust_pwd').value
                
            }),
            headers: {
                'content-type': 'application/json; charset=UTF-8',
            }
        })
            .then(function (response) {
                alert("success");
                console.log("success");
                var results = document.getElementById('results')
                results.innerHTML = `<p>You have Succesfully Registered with dbs bank V2.0 </p>
    <p><a href='/project01'>Click Here to LOGIN</a></p>`})
    } else {
        console.log("errors");
        var results = document.getElementById('results')
        results.innerHTML = `<p>Registration failed Please Try Again</p>`
    }


    function checkInputs() {

    	 const cust_id= document.getElementById('cust_id').value;
    	 const cust_name= document.getElementById('cust_name').value;
    	 const  cust_gender= document.getElementById('cust_gender').value;
    	 const cust_emailId= document.getElementById('cust_emailId').value;
    	 const cust_phno= document.getElementById('cust_phno').value;
    	 const cust_pwd= document.getElementById('cust_pwd').value

        let errorCustid = "";
        let errorCustName = "";
        let errorCustGender ="";
        let errorEmailid = "";
        let errorPhoneNumber = "";
        let errorCustPassword = "";
       
        if (isValidCustId(cust_id)) {
        	errorCustid = "Firstname Cannot be Empty"
        } else {
        	errorCustid = "";
        }
        if (isValidCustName(cust_name)) {
        	errorCustName = "Lastname Cannot be Empty"
        } else {
        	errorCustName = "";
        }
        if (isValidCustGender(cust_gender)) {
        	errorCustGender = "Emailid Cannot be Empty"
        } else {
        	errorCustGender = "";
        }
        if (isValidCustEmailId(cust_emailId)) {
        	errorEmailid = "Mobilenumber Cannot be Empty"
        } else {
        	errorEmailid = "";
        }
        if (isValidCustGender(cust_gender)) {
        	errorPhoneNumber = "gender Cannot be Empty"
        } else {
        	errorPhoneNumber = "";
        }
        if (isValidCustPwd(cust_pwd)) {
        	errorCustPassword = "Password Cannot be Empty"
        } else {
        	errorCustPassword = "";
        }
        document.getElementById("errorCustid").innerText = errorCustid;
        document.getElementById("errorCustName").innerText = errorCustName;
        document.getElementById("errorCustGender").innerText = errorCustGender;
        document.getElementById("errorEmailid").innerText = errorEmailid;
        document.getElementById("errorPhoneNumber").innerText = errorPhoneNumber;
        document.getElementById("errorCustPassword").innerText = errorCustPassword;

        return (errorCustid === 0 && errorCustName.length === 0 && errorCustGender.length === 0
            && errorEmailid === 0 && errorPhoneNumber.length === 0 && errorCustPassword.length === 0);
    }
    function isValidCustId(cust_id) {
        return cust_id === "" || cust_id.length < 5;
    }
    function isValidCustName(cust_name) {
        return cust_name === "" || cust_name.length < 5;
    }
    function isValidCustGender(cust_gender) {
        return cust_gender === "" || cust_gender.length < 5;
    }
    function isValidCustEmailId(cust_emailId) {
        return cust_emailId === "" || cust_emailId.length < 10;
    }
    function isValidCustPhno(cust_phno) {
        return cust_phno === "" || cust_phno.length < 5;
    }
    function isValidCustPwd(cust_pwd) {
        return cust_pwd === "" || cust_pwd.length < 5;
    }

    

})


