function questionsub(){

		if(document.getElementById('fm-question-title').value!=""&&document.getElementById('fm-question-content').value!=""){
		
		var request = new XMLHttpRequest();
		request.open("POST", "server.php");
		var data = "title=" + document.getElementById("fm-question-title").value 
		                  + "&content=" + document.getElementById("fm-question-content").value;
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		request.send(data);
		request.onreadystatechange = function() {
			if (request.readyState===4) {
				if (request.status===200) { 
					// document.getElementById("createResult").innerHTML = request.responseText;
				} else {
					alert("发生错误：" + request.status);
				}
			} 
		}

		var odiv1=document.createElement('div');
		var oparent=document.getElementById('fm-content');
		odiv1.className='fm-content-list';
		var odiv2=document.createElement('h3');
		var odiv3=document.createElement('a');
		odiv2.appendChild(odiv3);
		odiv1.appendChild(odiv2);
		var odiv4=document.createElement('div');
		odiv4.className='fm-content-username';
		odiv1.appendChild(odiv4);
		var odiv5=document.createElement('div');
		odiv5.className='fm-content-anwers';
		odiv1.appendChild(odiv5);
		oparent.insertBefore(odiv1,document.getElementsByClassName("fm-content-list")[0]);
		var divs1=document.getElementsByClassName("fm-content-list");
		odiv3.href='#';
		odiv3.id='fm-content-href'+divs1.length;
		odiv4.id='fm-content-username'+divs1.length;
		odiv5.id='fm-content-list'+divs1.length;

		console.log(odiv5.Id);
		console.log(divs1.length);
		document.getElementById('fm-content-href'+divs1.length).innerHTML=document.getElementById('fm-question-title').value;
		document.getElementById('fm-content-username'+divs1.length).innerHTML="牛妹";
		document.getElementById('fm-content-list'+divs1.length).innerHTML=document.getElementById('fm-question-content').value;
        document.getElementById('fm-content-title').value="";
        document.getElementById('fm-content-content').value="";

		
	}else{
		alert("can't null");
	}
}



function info_ajax(){
	/*
		var request = new XMLHttpRequest();
 	    request.open("GET","ajax.php");
     	request.send();
     	request.onreadystatechange=function(){
         	if(request.readyState===4){
             		if(request.status===200){
             		}else{
                 	alert("error: "+request.status);
             		}
         	}
    		}
	}*/
	for(i=0;i<7;i++){
		var list=document.getElementById('fm-question-list');
		var	div1=document.createElement('div');
			div1.className="fm-questions";
		var a1=document.createElement('a');
			a1.href="#";
			a1.innerHTML="提过的问题";
		var hr1=document.createElement('hr');	
			div1.appendChild(a1);
			div1.appendChild(hr1);
			list.appendChild(div1);
	}
}


function comment_ajax(){

	if(document.getElementById('fm-eassy-comments').value!=""){
		
		var request = new XMLHttpRequest();
		request.open("POST", "server.php");
		var data ="content=" + document.getElementById("fm-eassy-comments").value;
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		request.send(data);
		request.onreadystatechange = function() {
			if (request.readyState===4) {
				if (request.status===200) { 
					// document.getElementById("createResult").innerHTML = request.responseText;
				} else {
					alert("发生错误：" + request.status);
				}
			} 
		}
	}


		oparent=document.getElementById('fm-eassy-comment-list');
		odiv=document.createElement('div');
		odiv.Id="fm-eassy-comment-list";
	var	div1=document.createElement('div');
		div1.className="fm-eassy-comment-author";
	var	a1=document.createElement('a');
		a1.href="#";
		a1.innerHTML="niumei";
	var	div2=document.createElement('div');
		div2.className="fm-eassy-comment-content";
		div2.innerHTML=document.getElementById('fm-eassy-comments').value;
	var hr1=document.createElement('hr');
		odiv.appendChild(div1);
		odiv.appendChild(div2);
		div1.appendChild(a1);
		odiv.appendChild(hr1);
		oparent.appendChild(odiv);
}
