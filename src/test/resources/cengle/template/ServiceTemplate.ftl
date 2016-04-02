package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end;

import org.springframework.stereotype.Service;
import com.kli.service.base.CrudService;
import com.kli.bean.${className};
import com.kli.dao.${className}Dao;


/**
 * 
 * <br>
 * <b>功能：</b>${className}Service<br>
 */
 @Service
public class ${className}Service extends CrudService<${className}Dao, ${className}> {

}
