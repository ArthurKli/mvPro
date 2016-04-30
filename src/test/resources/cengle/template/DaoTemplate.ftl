package ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end;


import com.admin.annotation.MyBatisDao;
import com.admin.dao.base.CrudDao;
import com.admin.bean.${className};

/**
 * 
 * <br>
 * <b>功能：</b>${className}Dao<br>
 */
 @MyBatisDao
public interface ${className}Dao extends CrudDao<${className}> {
	
	
}
