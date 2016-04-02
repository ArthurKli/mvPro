/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	
	var finderSrc = "../static/ckfinder";
	// Define changes to default configuration here.
	// For the complete reference:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' }
	];
	config.toolbar =[
	                 ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	                 ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	                 ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	                 ['Link','Unlink','Anchor'],
	                 ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	                 '/',
	                 ['Styles','Format','Font','FontSize'],
	                 ['TextColor','BGColor'],
	                 ['Maximize', 'ShowBlocks','-','Source','-','Undo','Redo']
	              
	             ];

/*	// Remove some buttons, provided by the standard plugins, which we don't
	// need to have in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Se the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Make dialogs simpler.
	config.removeDialogTabs = 'image:advanced;link:advanced';*/
	
    //配置CKFinder
    config.filebrowserBrowseUrl = finderSrc + '/ckfinder.html';
    config.filebrowserImageBrowseUrl = finderSrc + '/ckfinder.html?Type=Images';
    config.filebrowserFlashBrowseUrl = finderSrc +  '/ckfinder.html?Type=Flash';
    config.filebrowserUploadUrl = finderSrc + '/core/connector/java/connector.java?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = finderSrc + '/core/connector/java/connector.java?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = finderSrc + '/core/connector/java/connector.java?command=QuickUpload&type=Flash';
    config.filebrowserWindowHeight='50%';//CKFinder浏览窗口高度,默认值70%，也可以赋像素值如：1000
    config.filebrowserWindowWidth='70%';//CKFinder浏览窗口宽度,默认值80%，也可以赋像素值
};
