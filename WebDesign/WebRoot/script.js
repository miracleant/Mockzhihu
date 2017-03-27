function initial(){
	add();
	if(document.getElementsByClassName("fm-content-list").length<7){
		add();
	}
}



function add(){

			// var request = new XMLHttpRequest();
		 //    request.open("GET","ajax.php");
		 //    request.send();
		 //    request.onreadystatechange=function(){
		 //        if(request.readyState===4){
		 //            if(request.status===200){
		 //                // document.getElementById("searchResult").innerHTML=request.responseText;
		 //            }else{
		 //                alert("error: "+request.status);
		 //            }
		 //        }
		 //    }


		var text="在GitHub上看到过一个开源项目（GitHub - lanbing510/DouBanSpider: 豆瓣读书的爬虫），那位老司机爬取了豆瓣读书上计算机相关分类的图书以及评分情况：计算机，机器学习，linux，android，数据库，互联网。"
		text+="牛妹筛选出评价人数较多的高分图书，供大家学习参考。"
		text+="再多说一句，编程的话还是要靠实践，不要买了很多书不看（捂脸哭 T_T），最好买一本看一本，同时别忘了到 牛客网-专业IT笔试面试备考平台,最全C++JAVA前端求职题库,全面提升IT编程能力 练习实践（ 咦，为啥我变成了广告狗=_=）";
	
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
		oparent.appendChild(odiv1);
		var divs1=document.getElementsByClassName("fm-content-list");
		odiv3.href='#';
		odiv3.id='fm-content-href'+divs1.length;
		odiv4.id='fm-content-username'+divs1.length;
		odiv5.id='fm-content-list'+divs1.length;

		console.log(odiv5.Id);
		console.log(divs1.length);
		document.getElementById('fm-content-href'+divs1.length).innerHTML="有哪些读了让人大快人心的书";
		document.getElementById('fm-content-username'+divs1.length).innerHTML="牛妹";
		document.getElementById('fm-content-list'+divs1.length).innerHTML=text;
}

function srcollCheck(){
	var divs=document.getElementsByClassName("fm-content-list");
	// console.log(divs.length);
	var divHeight=divs[divs.length-1].offsetTop;
	console.log(divHeight);
	var top = document.documentElement.scrollTop || document.body.scrollTop;		//滚动条到顶部的高度
	var winH = document.documentElement.clientHeight||document.body.clientHeight;	//可视窗口的高度

	if(divHeight<=top+winH){
		add();
	}
}


// login js start
function loginshow(){
	document.getElementById('fm-login').style.display="block";
	document.getElementById('fm-hidden').style.display="block";
}

function loginclose(){
	document.getElementById('fm-login').style.display="none";
	document.getElementById('fm-hidden').style.display="none";
}



function login_ajax(){
	var check=true;
	var user=document.getElementById("fm-login-user");
	var pasw=document.getElementById("fm-login-pasw");
	if(user.value==""){
		alert("username or password error!");
		user.focus();
		check=false;
	}
	else if(pasw.value.lenght<6){
		alert("username or password error!");	
		pasw.focus();
		check=false;
	}else{
		document.getElementById('fm-login').style.display="none";
		document.getElementById('fm-hidden').style.display="none";
		check=true;
	}
	if(check){
		    var request = new XMLHttpRequest();	
		    var username=document.getElementById("fm-login-user").value;
		    alert(username);
		    request.open("GET","ajax.php?username="+document.getElementById("fm-login-user").value&"password="+document.getElementById("fm-login-pasw"));
		    request.send();
		    request.onreadystatechange=function(){
		        if(request.readyState===4){
		            if(request.status===200){

		            }else{
		                alert("error: "+request.status);
		            }
		        }
		    }
		}
}





function reg_ajax(){
	var pasw1=document.getElementById("fm-reg-pasw1").value;
	var pasw2=document.getElementById("fm-reg-pasw2").value;
	if(pasw1!=pasw2){
		alert("password1 not equild password2")
	}else{
		var request = new XMLHttpRequest();
		request.open("POST", "server.php");
		var data = "username=" + document.getElementById("fm-reg-user").value 
		                  + "&password=" + document.getElementById("fm-reg-pasw1").value;
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
}


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
