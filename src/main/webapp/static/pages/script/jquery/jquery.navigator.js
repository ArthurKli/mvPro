/**
 * jQuery导航组件
 * 
 * @author zhuxiaoqi
 */
;(function ($) {
    var objId = '', navNum = 10000;
    //内部方法
    $.extend({
        createNavigator : function(obj, data, prepend) {
            objId = obj.attr('id');
            var level = 1;
            var floatToLeft = false;
            var rootUL = $('<ul class="dropdown" >');
            $.each(data.subMenu, function(index, list) {
            	if (index < 8) {
            		floatToLeft = false;
            	} else {
            		floatToLeft = true;
            	}
            	rootUL.append($.createList(list, level, index,floatToLeft));
            });
            obj.append(rootUL);
           
        },
        //遍历子菜单
        foreachNav  : function(level, data,floatToLeft) {
            if(data.subMenu && data.subMenu!=('' || [] || {} )) {
                var container;
                level++;
                var container = $('<ul style="width:130px;">');
                $.each(data.subMenu, function(index,list){
                	if (floatToLeft){
                	  if (!container.hasClass("floatLeft")){
                		  container.addClass("floatLeft");  
                	  }
                    }
                	container.append($.createList(list, level, index,floatToLeft));
                });
                // 按美工的原型在二级菜单加入DIV
                if(level == "2") {
                	container.addClass("sub_menu");
                    container = $("<div/>").addClass("picmenu1").append(container);
                }
            }
            return container;
        },
        
        createList     : function(list, level, index,floatToLeft) {
            //是否第一个
            var isFirstLi   = index == 0 ? ' first' : '';
            //元素属性
            var elementId = list.id ? list.code : navNum++;
            var attributes  = {
                id          :  elementId,
                href        : 'javascript: defaultMenuActionHanler("' + list.action +'","'  + elementId + '");',          // list.action ? list.action : '#',
                content     : list.caption ? (list.caption.length > 7 ? list.caption.substr(0,7) + '...' : list.caption) : ' ',
                title       : (level != 1) && list.caption ? list.caption: '', 
                img         : list.img ? list.img : null,
                style       : list.style ? ' style="'+ list.style +'"' : '',
                click       : list.click ? ' onclick="'+ list.click +'"' : '',
                current     : list.current ? ' current' : ''
            };
             
            if (determinateGreenChannel){
            	determinateGreenChannel(list);
            };
            
            if (etaxGlobal && etaxGlobal.urlAtions){
            	if (list.action){
                  etaxGlobal.urlAtions.push(list.action);
            	}
            }         
            var li = $('<li levelIndex ="' + index + '" level ="' +level +'"></li>').addClass("picmenu");//.attr("id", objId + '_li_' + attributes.id)
            			
            var content = $("<a/>").attr("id", attributes.id).attr("href", attributes.href).attr("title",attributes.title)
            			.append(attributes.img ? $.createImg(attributes.img) : attributes.content)
            			.appendTo(li);
            if(list.subMenu && list.subMenu.length > 0) {
            	level >= "2" ? !floatToLeft ? li.addClass("sub_menu2li"):li.addClass("sub_menu2li_left"): null; //!floatToLeft ?
            	var div = $('<div level ="' + (level + 1)  + '"></div>');
            	div.append($.foreachNav(level, list,floatToLeft));
            	li.append(div);
            }
            return li;
        },
        
        createImg : function(c) {
        	return $("<img/>").attr("src", c.out).hover(function() {
        		$(this).attr("src", c.over);
        	}, function() {
        		$(this).attr("src", c.out);
        	});
        }
        
        
    });
    
    //对外公布的对象定义
    $.fn.extend({
    	etaxNavigator  : function(data, type, prepend){
            //初始化列表
            var self = $(this);
            //创建菜单
            $.createNavigator(self, data, prepend);
            //菜单弹出事件
            $('li',self).hover(function(){
                $(this).children('ul').addClass('show').prev('.nav-in').addClass('show');
            },function(){
                $(this).children('ul').removeClass('show').prev('.nav-in').removeClass('show');
            });
            
            var overFn = function() {
                $(this).addClass("hover");
                $('ul:first',this).css('visibility', 'visible');
            };
            var outFn = function(){
                $(this).removeClass("hover");
                $('ul:first',this).css('visibility', 'hidden');
            };

            if($.fn.hoverIntent) {
            	self.find("ul.dropdown li").hoverIntent({
            		over : overFn, 
            		out : outFn,
            		timeout : 300
            	});
            } else {
                self.find("ul.dropdown li").hover(overFn, outFn);
            }
            
          //处理菜单层overflow的情况
            $('div[level="3"],div[level="4"],div[level="5"]').each(function(index){
            	var jq= $(this);
            	var levelIndex = jq.parent().attr("levelIndex");
            	var level = jq.attr("level");
            	var childLi = jq.find('li[level="' + level +'"]');
            	var ParentDivHeight = 689 - jq.parent().offset().top;
                style_top = childLi.length * 24 - ParentDivHeight + 40;
                if (style_top > 0){
            	   jq.css("top","-" + (style_top + 20) + "px");
                }
            	var ja = jq.parent().find(':first');
            	if (ja.length === 1 && ja[0].tagName === 'A' && level > 3){
            		if (!ja.parent().hasClass("sub_menu2li_left")){
            			// TO DO 左边扩展菜单图片
            		    ja.css('background-image','url(../style/images-swzj-01/style-menu-01/menu02li.gif)');
            		    ja.css('background-position','right center');
            		} else{
            		   ja.css('background-image','url(../style/images-swzj-01/style-menu-01/menu02li.gif)');
               		   ja.css('background-position','left center');           			
            		}
            		ja.css('background-repeat','no-repeat');
            	}
            });
            if ($(document).height() <= 689){
         	  $('html').css("overflow-y","hidden");
         	}	
        }
    });
})(jQuery);

// 点击菜单默认处理
function defaultMenuActionHanler(action,elementId){
	if  (!(typeof doMenuAction == "undefined")){
	  doMenuAction(action,elementId);
	} else {
	   //window.location.href = action;
		window.open(action); 
	  
	}	
} 

