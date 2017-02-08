/**
 * Created by king-aric on 2016/7/9.
 */
function  validate_input_(e) {
    if(e.value==""){
        $("#"+e.id+"_0x0000val").remove()
        $(e).after("<span id='"+e.id+"_0x0000val' " +
        "style='color:red'>输入内容不能为空！</span>");
        return false;
    }else{
        if (e.getAttribute('val_null')=='false'){
            var reg = rule(e.getAttribute('val_rule'))
            if (!reg.test(e.value)) {
                $("#"+e.id+"_0x0000val").remove()
                if(e.getAttribute('val_msg')==null||e.getAttribute('val_msg')==undefined)
                    e.setAttribute('val_msg','输入内容不合法！')
                $(e).after("<span id='"+e.id+"_0x0000val' style='color:red'>"
                +e.getAttribute('val_msg')+"</span>");
                return false;
            }
        }
        $("#"+e.id+"_0x0000val").remove()
        return true;
    }
    function rule(type){
        if(type==null||type==undefined){
            console.log("validate rule (val_rule='') is not null!")
            return ;
        }
        if(type=='number'){return /^[0-9]{1,8}$/ }
        if(type=='phone'){ return  /^1[3|4|5|7|8]\d{9}$/}
        if(type=='float'){return /^\d+(\.\d+)?$/}
        if(type=='ip'){return /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/}
        if(type=='phone&tel'){return /^1[3|4|5|7|8]\d{9}$|^(\d{3,4}-)?\d{7,8}/}

    }

}

function login() {
    $.ajax({
        url: "/login",
        type: "get",
        dataType: "json",
        data: $("#loginForm").serialize(),
        success: function (data) {
            if (data && data.status && data.code == 0 ) {
                if (data.responseCode==0X0002) {
                    window.location.href =data.data;
                }else{
                    window.location.href = "/welcome"
                }

            }
        },
        error: function (error) {
            alert(error)
        }
    })
}

function changeLocale(lang) {
    $.ajax({
        url: "/common/changeLocale",
        type: "get",
        data: {
            "locale": lang
        },
        success: function (data) {
            window.location.reload();
        },error: function (e) {
            console.log(e)
        }
    });
}
