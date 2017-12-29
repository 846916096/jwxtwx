package cn.edu.hbmy.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.github.pagehelper.Page;

/**
 * 
 * 对象转换工具类 <br/>
 * Created: 2017年9月28日 上午10:47:05 <br/> 
 * 
 * @author zhengjian 
 * @version 1.0
 * @since JDK 1.7
 */
public class BeanUtil {
	/**
	 * 
	 * 对象转换,将源对象转换为目标对象<br/><br/>
	 * 转换的属性必须为双方都拥有相同getter和setter的属性,且数据类型相同.此方法不会处理空属性<br/><br/>
	 * @param r 源对象
	 * @param t 目标对象
	 * @return 返回转换之后的对象
	 * @throws RuntimeException
	 */
	public static <R,T> T beanConvert(R r,Class<T> t) throws RuntimeException{
		return beanConvert(r,t,false);
	}
	
	/**
	 * 
	 * 对象转换,将源对象转换为目标对象<br/><br/>
	 * 转换的属性必须为双方都拥有相同getter和setter的属性,且数据类型相同.<br/><br/>
	 * @param r 源对象
	 * @param t 目标对象
	 * @param nullHd 空属性处理(true:处理空属性,fasle:不处理空属性)
	 * @return 返回转换之后的对象
	 * @throws RuntimeException
	 */
	@SuppressWarnings({ "rawtypes"})
	public static <R,T> T beanConvert(R r,Class<T> t,boolean nullHd) throws RuntimeException{
		T ti;
		try {
			ti = t.newInstance();
			if(r instanceof Map){
				Map m = (Map)r;
				org.apache.commons.beanutils.BeanUtils.populate(ti, m);
			}else{
				if(nullHd)
					BeanUtils.copyProperties(r, ti,getNullPropertyNames(r));
				else
					BeanUtils.copyProperties(r, ti);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return ti;
	}
	/**
	 * 对象列表转换
	 * @param resource 源列表
	 * @param t 转换列表元素类型
	 * @return 转换之后匹配类型的列表
	 * @throws RuntimeException 
	 */
	public static <R,T> List<T> listConvert(List<R> resource, Class<T> t) throws RuntimeException {
		List<T> ts = new ArrayList<T>();
		if(resource.getClass().getName().equals(Page.class.getName())){//兼容pageHelper分页
			ts = new Page<T>();
			BeanUtils.copyProperties(resource, ts);
		}
		for(R r : resource){
			ts.add(beanConvert(r,t));
		}
		return ts;
	}
	/**
	 * 获取值为空的属性列表
	 * @param source 源对象
	 * @return 属性值为空(null或"")的属性名数组
	 */
	public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || "".equals(srcValue)) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
