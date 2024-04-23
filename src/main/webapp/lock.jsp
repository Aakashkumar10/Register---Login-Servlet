<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lock</title>
<link
	href="https://fonts.googleapis.com/css2?family=Quicksand:wght@500&amp;display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Cedarville+Cursive&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./style.css" type="text/css" />
<%
//Set a boolean by check authentication
boolean auth = false;
//create Http Session Object
HttpSession sess = request.getSession(false);
//Check Session
if (sess != null) {
	//Check if logindetail exists in session
	String logindetail = (String) session.getAttribute("logindetail");
	if (logindetail != null) {
		//Set auth to true
		auth = true;
	}
} else {
	//Set auth to False
	auth = false;
}
%>
<%
if (auth) {
	out.print("<style type=\"text/css\">"
	+ ".vault-door-outer.vault-door-outer:hover .vault-door-lock-shadow {width: 40%;margin: 44% 6.5%;transition: all 0.5s ease-out;}.vault-door-outer.vault-door-outer:hover .piston {width: 70%;margin-left: 14%;margin-right: 5%;transition: all 0.5s ease-out;}.vault-door-outer.vault-door-outer:hover .vault-door-handle {transform: rotate(-180deg);transition: all 1s ease-in-out;}</style>");
}
%>
</head>
<body>

 <div class="main" style="flex-direction: column;justify-content:space-around">
                <h5 style="position: absolute;bottom:0;right:0;z-index:5;color:#000;" id="topic"></h5>
    
        <a href="index.html" style="position: absolute;bottom:0;left:0;z-index:5" id="topic">Return to Home</a>
        <div class="status">
            <h1>
              <% 
              //if authorised, Show it is open else Close
              if(auth)
                  {
                  out.print("Your vault is Open"); 
                  }
              else{
                  out.print("Your Vault is Closed");
              }
              %>
            </h1>
        </div>
        <div class="vault-door-outer active">
            <div class="vault-door-inner">
                <div class="vault-door-lock-shadow">
                </div>
                <div class="vault-door-lock-wrapper">
                    <div class="vault-door-lock vault-door-circle">
                    </div>
                    <div class="vault-door-lock vault-door-pistons">
                        <div class="piston piston1">
                        </div>
                        <div class="piston piston2">
                        </div>
                        <div class="piston piston3">
                        </div>
                        <div class="piston piston4">
                        </div>
                    </div>
                </div>
                <div class="vault-door-handle-shadow">
                </div>
                <div class="vault-door-handle-long-shadow">
                </div>
                <div class="vault-door-handle">
                    <div class="handle-bar bar1">
                    </div>
                    <div class="handle-bar bar2">
                    </div>
                </div>
            </div>
        </div>
        <div class="msg">
        <% 
            //if authorised, Provide option to Close Vault else Open Vault
              if(auth)
                  {
                  out.print("<a href=\"LogoutServlet\">Close Vault</a>"); 
                  }
              else{
                  out.print("<a href=\"login.html\">Open Vault</a>");
              }
              %>
        </div>
    </div>
    </div>


</body>
</html>