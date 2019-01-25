//登录的方法
function login(){
    var loginName=$("#loginName").val();
    var password=$("#password").val();
    
    if(loginName == ""){
    	$("#loginTips").html("用户名或者密码不能为空");
    	return false;
    }
    if(loginName == ""){
    	$("#loginTips").html("用户名或者密码不能为空");
    	return false;
    }
    
    $.ajax({
        url:"loginMethod",
        method:"post",
        data:{
        	 loginName:loginName,
        	 password:password
        },
        dataType:"json",
        success:function(data){
            if(data.status==1){
              window.location.href="/";
       
            }else{
            	$("#loginTips").html(data.retMsg)
            }
        },
        error:function(){
        	alert("未知异常");
        }
    })
}