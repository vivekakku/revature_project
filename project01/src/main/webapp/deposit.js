form3.addEventListener('submit', function (e) {
    e.preventDefault()
    checkInputs()
    if (
        document.getElementById("errorAccountNumber").innerText === "" &&
        document.getElementById("errorAmount").innerText === ""
     
    ) {
        console.log("no errors");
        let url = "http://localhost:8080/project01/deposit";
        fetch(url, {
            method: 'post',
            body: JSON.stringify({
                cust_acc_no: document.getElementById('cust_acc_no').value,
                tamount: document.getElementById("tamount").value,

             
            }),
            headers: {
                'content-type': 'application/json; charset=UTF-8',
            }
        })
            .then(function (response) {
                alert("Amount Deposited successfully");
                console.log("success");
                var results = document.getElementById('results')
                results.innerHTML = `<p>You have Successfully Deposited to Account using dbs V2.0 Services</p><br>
              <p><a href='/project01/successt'>Click Here to View Your Transaction Details</a></p><br>
    <p><a href='/project01/index.html'>Click Here to go to MainMenu</a></p><br>
    `})
    } else {
        console.log("errors");
        var results = document.getElementById('results')
        results.innerHTML = `<p>Deposit failed Please Try Again</p>`
    }


    function checkInputs() {

        const cust_acc_no = document.getElementById('cust_acc_no').value;
        const tamount = document.getElementById('tamount').value;
    

        let errorAccountNumber = "";
        let errorAmount = "";
       
        if (isValidAccountNumber(cust_acc_no)) {
            errorAccountNumber = "Account Number Cannot be Empty"
        } else {
            errorAccountNumber = "";
        }
        if (isValidAmount(tamount)) {
            errorAmount = "Amount Cannot be Empty"
        }
        else {
            errorAmount = "";
        }
       
        document.getElementById("errorAccountNumber").innerText = errorAccountNumber;
        document.getElementById("errorAmount").innerText = errorAmount;


        return (errorAccountNumber.length === 0 && errorAmount.length === 0);
    }
    function isValidAccountNumber(cust_acc_no) {
        return cust_acc_no === "" || cust_acc_no.length < 2;
    }
    function isValidAmount(tamount) {
        return tamount === "" || tamount.length < 2;
    }
    
})


