<%@ include file="header.jsp" %>

<div id="fm-info"></div>
<div id="fm-info-name">niumei</div>
<div id="fm-info-intro">a programer</div>
<hr>
<div id="fm-question-list">
    <div class="fm-questions"><a href="#">what your name?</a>
        <hr>
    </div>
</div>


<script type="text/javascript">
    window.onload = function () {
        info_ajax();
    }


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
</script>
<%@ include file="footer.jsp" %>
