window.onload = function checkForm() {
    var btnCheck = document.getElementById('btnCheck');
    btnCheck.onclick = function(e) {
        /*
            如果以下表单有一个不符合，则不允许提交表单
         */

        e = e || window.event;
        $(document).ready(function () {
            function validateForm(){
                if(checkNickname()&&checkPassword()&&checkRePassword()&&checkName()&&checkClassroom()&&checkPhone()){
                    alert("恭喜您！注册成功！");
                }
            }
        });
        function checkNickname() {
            var name = document.getElementById("loginName").value;
            if (name.length <= 0) {
                alert("请输入登录名称");
                return false;
            }
            else return true;
        }
        function checkPassword(){
            var ps = document.getElementById("loginPassword").value;
            {
                if (ps.length <= 0) {
                    alert("请输入密码");
                    return false;
                }
                else return true;
            }
        }

        function checkRePassword(){
            var reps = document.getElementById("rePassword").value;
            if (ps != reps) {
                alert("两次输入的密码不同");
                return false;
            }
            else return true;
        }
        function checkPhone(){
            var ph = document.getElementById("phone").value;
            if (!/^1(3|4|5|6|7|8|9)\d{9}$/.test(ph)) {
                alert("电话格式不对");
                return false;
            }
            else return true;
        }
        function checkName(){
            var stn = document.getElementById("stuName").value;
            if (stn.length <= 0)
            {
                alert("请输入姓名");
                return false;
            }
            else return true;
        }
        function checkClassroom(){
            var cla = document.getElementById("classRoom").value;
            if (cla.length <= 0)
            {
                alert("请输入班级");
                return false;
            }
            else return true;
        }

    }

}


