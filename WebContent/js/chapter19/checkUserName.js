function checkName() {
	// 获得文本框的值
	var name = document.getElementById("u1").value;
	
	var xhr = createXMLHttp();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				
				var data = xhr.responseText;
				
				if(data == 1){
					document.getElementById("s1").innerHTML = "<font color='green'>用户名可用</font>";
					document.getElementById("sub1").disabled = false;
					
				} else if(data == 2) {
					document.getElementById("s1").innerHTML = "<font color='red'>用户名不不不可用</font>";
					document.getElementById("sub1").disabled = true;
				}
			}
		}
	}
	
	xhr.open("GET","/InterestingJavaEE/CheckUserNameServlet?name="+name,true);
	xhr.send(null);
}

function createXMLHttp() {
	var xmlHttp;
	try { // Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {// Internet Explorer
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}

	return xmlHttp;
}