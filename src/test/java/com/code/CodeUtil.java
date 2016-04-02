package com.code;

import codeGenerate.def.CodeResourceUtil;
import codeGenerate.def.FtlDef;
import codeGenerate.factory.CodeGenerateFactory;
/**
 * 
 * @author lintu5.com
 *
 */

public class CodeUtil {

/*	public static void main(String[] args) {
		 *//** 此处修改成你的 表名 和 中文注释***//*
		 String tableName="comic"; //
		 String codeName ="漫画";//中文注释  当然你用英文也是可以的 
		 String entityPackage ="admin";//实体包
		 String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
		CodeGenerateFactory.codeGenerate(tableName, codeName,entityPackage,keyType);
	}
	*/
	public static void main(String[] args) {

		config();
//		System.out.println(CodeGenerateFactory.getProjectPath());
	
	}

	private static void config() {
		/** 此处修改成你的 表名 和 中文注释***/
		 String tableName="td_menu"; 
		 String codeName ="系统菜单栏";//中文注释 
		 String entityPackage ="";//实体包
		 String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
		CodeGenerateFactory.codeGenerate(tableName, codeName,entityPackage,keyType);
	}
	
	
}
