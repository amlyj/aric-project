/**
 * Created by king-aric on 2016/7/10.
 */
/**
 * 秒杀逻辑实现
 * @type {{url: {}, detail: {}}}
 */
var SecKill={
    //ajax request url ,统一封装 ?+new Date().getTime();禁止缓存
    url:{
       time:function(){
           return "/now/time?"+new Date().getTime();
       },
        getSecKillUrl: function (stockId) {
            return "/"+stockId+"/secKillUrl?"+new Date().getTime();
        },
        executeSecKill: function (md5) {
            return  "/"+md5+"/executeSecKill?"+new Date().getTime();
        }
    },
    validate:function(vals){
        if(vals&&isNaN(vals)){
            return true;
        }else{
            return false;
        }
    },
    //计时方法
    countdown:function(stockId,now,start,end){
      var box=$("#secKill-box");
        if(now>end){
           box.html("秒杀结束。。。");
        }else if(now<start){
            var beginTime=new Date(start+1000);
            box.countdown(beginTime,function(envent){
                var format=envent.strftime("秒杀倒计时：%D天 %H时 %M分 %S秒");
                box.html(format);
            }).on('finish.countdown', function () {
                SecKill.executeSecKill(stockId,box);
            })
        }else{
          //进行中
            SecKill.executeSecKill(stockId,box)
        }
    },
    detail:{
        init:function(params){
            //获取cookie  var cook= $.cookie('key')
            var startTime=params['startTime'];
            var endTime=params['endTime'];
            var stockId=params['stockId'];
            var user=params['username'];
            var username= $.cookie('username');
            //判断cookie中是否存在当前登录的用户
            if(!SecKill.validate(username)||username!=user){
                var secKillValModel=$("#secKillValModel");
                //显示提示框
                secKillValModel.modal({
                    show:true, //是fade失效，显示弹出层
                    backdrop:'static', //禁止拖拽
                    keyboard:false //禁止关闭
                });
                $('#username-rep-Btn').click(function(){
                    var use=$('#username-rep').val();
                    if(SecKill.validate(use)&&use==user){
                        //写入cookie
                        $.cookie('username',use,{expires:7,path:'/'});
                        window.location.reload();
                    }else{
                        $('#username-rep-Val').hide()
                            .html('<label class="label label-danger">输入有误！</label>').show(300);
                    }
                });
            }
            $.get(SecKill.url.time(),{},function(result){
                 if(result && result.status){
                     SecKill.countdown(stockId,result.data,startTime,endTime);
                 }else{
                     console.log('error:'+result);
                 }
            })

        }


    },
    executeSecKill: function (stockId,node) {
         $("#glyphicon-time").hide();//隐藏时间图标
         node.hide().html('<button id="killBtn" class="btn btn-primary btn-lg">开始秒杀</button>');
         SecKill.getSecKillUrl(stockId,node);
    },
    getSecKillUrl: function (stockId,node) {
        $.ajax({
             url:SecKill.url.getSecKillUrl(stockId),
             type: "post",
             dataType:"json",
             success: function (result) {
               if(result && result.status){
                   var data=result.data;
                     if(data.expose){
                         //绑定一次点击秒杀按钮监听，防止多次触发
                         $("#killBtn").one("click",function () {
                             $(this).addClass("disabeld");//禁用
                             SecKill.doKill(data.md5,data.stockId,node);
                         });
                         node.show();
                     }else{
                         SecKill.countdown(data.stockId,data.now,data.start,data.end);
                     }
               }else{
                   console.log("error:"+result)
               }
             }
        });
    },
    doKill: function (md5,stockId,node) {
        $.ajax({
            url:SecKill.url.executeSecKill(md5),
            type: "post",
            dataType:"json",
            data:{'stockId':stockId},
            success: function (result) {
                if(result && result.status){
                   //alert(result.message);
                   node.html('<span class="label label-success">'+result.message+'</span>');
                }else{
                    node.html('<span class="label label-success">'+result.message+'</span>');
                    //alert(result.message)
                }
            }
        });
    }


}
