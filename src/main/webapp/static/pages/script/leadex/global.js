/*================
autho:komi 2014-2-27
================*/

$(function(){
	$(".ol-mainnav li").hover(
	   function(){
		 $(this).children("a").addClass("current");
		 $(this).children("ul").stop(true,true).slideDown();
		 },
	   function(){
		 $(this).children("a").removeClass("current");
		 $(this).children("ul").stop(true,true).slideUp(); 
		 }
		);

	$(window).scroll(function(){
		var st = $(this).scrollTop();
		if(st>683 && $(".float-max").length>0){
			  $(".float-max").fadeIn('fast');
			}else{
			  $(".float-max").fadeOut('fast');
			}
		});
		
	$(".ol-tab a").hover(function(){
		var index = 0;
		index = $(".ol-tab a").index(this);
		$(".market .f-ul").eq(index).show().siblings("ul").hide();
		});
	
}); // jq-end

//项目的详情页幻灯片====================================================================
$(document).ready(function (){
	
	//点击小图切换大图
	$("#thumbnail li a").click(function(){
		$(".zoompic img").hide().attr({ "src": $(this).attr("href"), "title": $("> img", this).attr("title"), "width":'680', "height":395});
		
		//$(".zoompic").append("<img  src='images/onsale.png'  class='onsale' >");
		
		$("#thumbnail li.current").removeClass("current");
		$(this).parents("li").addClass("current");
		return false;
	});
	$(".zoompic>img").load(function(){
		$(".zoompic>img:hidden").show();
	});
	
	//小图片左右滚动
	var $slider = $('.slider ul');
	var $slider_child_l = $('.slider ul li').length;
	var $slider_width = $('.slider ul li').width();
	$slider.width($slider_child_l * $slider_width);
	
	var slider_count = 0;
	
	if ($slider_child_l < 5) {
		$('#btn-right').css({cursor: 'auto'});
		$('#btn-right').removeClass("dasabled");
	}
	
	$('#btn-right').click(function() {
		if ($slider_child_l < 5 || slider_count >= $slider_child_l - 5) {
			return false;
		}
		
		slider_count++;
		$slider.animate({left: '-=' + $slider_width + 'px'}, 'fast');
		slider_pic();
	});
	
	$('#btn-left').click(function() {
		if (slider_count <= 0) {
			return false;
		}
		slider_count--;
		$slider.animate({left: '+=' + $slider_width + 'px'}, 'fast');
		slider_pic();
	});
	
	function slider_pic() {
		if (slider_count >= $slider_child_l - 5) {
			$('#btn-right').css({cursor: 'auto'});
			$('#btn-right').addClass("dasabled");
		}
		else if (slider_count > 0 && slider_count <= $slider_child_l - 5) {
			$('#btn-left').css({cursor: 'pointer'});
			$('#btn-left').removeClass("dasabled");
			$('#btn-right').css({cursor: 'pointer'});
			$('#btn-right').removeClass("dasabled");
		}
		else if (slider_count <= 0) {
			$('#btn-left').css({cursor: 'auto'});
			$('#btn-left').addClass("dasabled");
		}
	}
	
});

//=======================================================================================================================









