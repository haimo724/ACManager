
var test=window.location.href
if(test!='http://localhost:8080/login.html'&&test!='http://localhost:8080/register.html'&&test!='http://localhost:8080/mlogin.html'){
    if(localStorage['userId']==null){
        // alert("尚未登录，请先登录！")
        // window.location.href='/login.html'
    }
}

