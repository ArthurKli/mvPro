package ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end;


import com.kli.annotation.MyBatisDao;
import com.kli.dao.base.CrudDao;
import com.kli.bean.${className};

/**
 * 
 * <br>
 * <b>功能：</b>${className}Dao<br>
 */
 @MyBatisDao
public interface ${className}Dao extends CrudDao<${className}> {
	
	
}
