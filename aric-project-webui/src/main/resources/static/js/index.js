/**
 * Created by Administrator on 2016/7/30.
 */

jQuery(document).ready(function() {
    addEventListener("load", function () {
        setTimeout(hideURLbar, 0); }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    }

    $(window).load(function () {
        $('.flexslider').flexslider({
            //动画
            animation: "slide",
            //轮播速度
            slideshowSpeed: 1000,
            //循环
            animationLoop: true,
            //鼠标悬浮 暂停
            pauseOnHover: true,
            start: function (slider) {
                $('body').removeClass('loading');
            }
        });
    });

})