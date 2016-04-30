package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end;

import org.springframework.stereotype.Service;
import com.admin.service.base.CrudService;
import com.admin.bean.${className};
import com.admin.dao.${className}Dao;


/**
 * 
 * <br>
 * <b>功能：</b>${className}Service<br>
 */
 @Service
public class ${className}Service extends CrudService<${className}Dao, ${className}> {

}
