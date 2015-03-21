package com.changh.sccms.until;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p>Title: </p>
 * <p>Description: </p>


 not attributable
 * @version 1.0
 */

public class MyBeanUtils
    extends org.apache.commons.beanutils.BeanUtils {

  private static void convert(Object dest, Object orig) throws
      IllegalAccessException, InvocationTargetException {

      // Validate existence of the specified beans
      if (dest == null) {
          throw new IllegalArgumentException
              ("No destination bean specified");
      }
      if (orig == null) {
          throw new IllegalArgumentException("No origin bean specified");
      }

      // Copy the properties, converting as necessary
      if (orig instanceof DynaBean) {
          DynaProperty origDescriptors[] =
              ( (DynaBean) orig).getDynaClass().getDynaProperties();
          for (int i = 0; i < origDescriptors.length; i++) {
              String name = origDescriptors[i].getName();
              if (PropertyUtils.isWriteable(dest, name)) {
                  Object value = ( (DynaBean) orig).get(name);
                  try {
                      copyProperty(dest, name, value);
                  }
                  catch (Exception e) {
                      ; // Should not happen
                  }

              }
          }
      }
      else if (orig instanceof Map) {
          Iterator names = ( (Map) orig).keySet().iterator();
          while (names.hasNext()) {
              String name = (String) names.next();
              if (PropertyUtils.isWriteable(dest, name)) {
                  Object value = ( (Map) orig).get(name);
                  try {
                      copyProperty(dest, name, value);
                  }
                  catch (Exception e) {
                      ; // Should not happen
                  }

              }
          }
      }
      else
      /* if (orig is a standard JavaBean) */
      {
          PropertyDescriptor origDescriptors[] =
              PropertyUtils.getPropertyDescriptors(orig);
          for (int i = 0; i < origDescriptors.length; i++) {
              String name = origDescriptors[i].getName();
//              String type = origDescriptors[i].getPropertyType().toString();
              if ("class".equals(name)) {
                  continue; // No point in trying to set an object's class
              }
              if (PropertyUtils.isReadable(orig, name) &&
                  PropertyUtils.isWriteable(dest, name)) {
                  try {
                      Object value = PropertyUtils.getSimpleProperty(orig, name);
                      copyProperty(dest, name, value);
                  }
                  catch (java.lang.IllegalArgumentException ie) {
                      ; // Should not happen
                  }
                  catch (Exception e) {
                      ; // Should not happen
                  }

              }
          }
      }

  }

  
  /**
	 * 瀵硅薄鎷疯礉
	 * 鏁版嵁瀵硅薄绌哄�涓嶆嫹璐濆埌鐩爣瀵硅薄
	 * 
	 * @param dataObject
	 * @param toObject
	 * @throws NoSuchMethodException
	 * copy
	 */
  public static void copyBeanNotNull2Bean(Object databean,Object tobean)throws Exception
  {
	  PropertyDescriptor origDescriptors[] =
          PropertyUtils.getPropertyDescriptors(databean);
      for (int i = 0; i < origDescriptors.length; i++) {
          String name = origDescriptors[i].getName();
//          String type = origDescriptors[i].getPropertyType().toString();
          if ("class".equals(name)) {
              continue; // No point in trying to set an object's class
          }
          if (PropertyUtils.isReadable(databean, name) &&
              PropertyUtils.isWriteable(tobean, name)) {
              try {
                  Object value = PropertyUtils.getSimpleProperty(databean, name);
                  if(value!=null){
                	    copyProperty(tobean, name, value);
                  }
              }
              catch (java.lang.IllegalArgumentException ie) {
                  ; // Should not happen
              }
              catch (Exception e) {
                  ; // Should not happen
              }

          }
      }
  }
  
  
  /**
   * 鎶妎rig鍜宒est鐩稿悓灞炴�鐨剉alue澶嶅埗鍒癲est涓�
   * @param dest
   * @param orig
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  public static void copyBean2Bean(Object dest, Object orig) throws Exception {
      convert(dest, orig);
  }

  public static void copyBean2Map(Map map, Object bean){
	PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);
	for (int i =0;i<pds.length;i++)
	{
		PropertyDescriptor pd = pds[i];
		String propname = pd.getName();
		try {
			Object propvalue = PropertyUtils.getSimpleProperty(bean,propname);
			map.put(propname, propvalue);
		} catch (IllegalAccessException e) {
			//e.printStackTrace();
		} catch (InvocationTargetException e) {
			//e.printStackTrace();
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
		}
	}
  }

  /**
   * 灏哅ap鍐呯殑key涓嶣ean涓睘鎬х浉鍚岀殑鍐呭澶嶅埗鍒癇EAN涓�
   * @param bean Object
   * @param properties Map
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  public static void copyMap2Bean(Object bean, Map properties) throws
      IllegalAccessException, InvocationTargetException {
      // Do nothing unless both arguments have been specified
      if ( (bean == null) || (properties == null)) {
          return;
      }
      // Loop through the property name/value pairs to be set
      Iterator names = properties.keySet().iterator();
      while (names.hasNext()) {
          String name = (String) names.next();
          // Identify the property name and value(s) to be assigned
          if (name == null) {
              continue;
          }
          Object value = properties.get(name);
          try {
              Class clazz = PropertyUtils.getPropertyType(bean, name);
              if (null == clazz) {
                  continue;
              }
              String className = clazz.getName();
              if (className.equalsIgnoreCase("java.sql.Timestamp")) {
                  if (value == null || value.equals("")) {
                      continue;
                  }
              }
              setProperty(bean, name, value);
          }
          catch (NoSuchMethodException e) {
              continue;
          }
      }
  }
  

  /**
   * 鑷姩杞琈ap key鍊煎ぇ鍐�
   * 灏哅ap鍐呯殑key涓嶣ean涓睘鎬х浉鍚岀殑鍐呭澶嶅埗鍒癇EAN涓�
   * @param bean Object
   * @param properties Map
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  public static void copyMap2Bean_Nobig(Object bean, Map properties) throws
      IllegalAccessException, InvocationTargetException {
      // Do nothing unless both arguments have been specified
      if ( (bean == null) || (properties == null)) {
          return;
      }
      // Loop through the property name/value pairs to be set
      Iterator names = properties.keySet().iterator();
      while (names.hasNext()) {
          String name = (String) names.next();
          // Identify the property name and value(s) to be assigned
          if (name == null) {
              continue;
          }
          Object value = properties.get(name);
//----------------------------------------------------------------
//update-begin--Author:Quainty  Date:20130520 for锛欽DBC鏂瑰紡璋冪敤
          // 鍛藉悕搴旇澶у皬鍐欏簲璇ユ晱鎰�鍚﹀垯鍙栦笉鍒板璞＄殑灞炴�)
          //name = name.toLowerCase();
          try {
        	  if (value == null) {	// 涓嶅厜Date绫诲瀷锛屽ソ澶氱被鍨嬪湪null鏃朵細鍑洪敊
                  continue;	// 濡傛灉涓簄ull涓嶇敤璁�(瀵硅薄濡傛灉鏈夌壒娈婂垵濮嬪�涔熷彲浠ヤ繚鐣欙紵)
              }
              Class clazz = PropertyUtils.getPropertyType(bean, name);
              if (null == clazz) {	// 鍦╞ean涓繖涓睘鎬т笉瀛樺湪
                  continue;
              }
              String className = clazz.getName();
              // 涓存椂瀵圭瓥锛堝鏋滀笉澶勭悊榛樿鐨勭被鍨嬭浆鎹㈡椂浼氬嚭閿欙級
              if (className.equalsIgnoreCase("java.util.Date")) {
                  value = new java.util.Date(((java.sql.Timestamp)value).getTime());// wait to do锛氳矊浼兼湁鏃跺尯闂, 寰呰繘涓�纭
              }
//              if (className.equalsIgnoreCase("java.sql.Timestamp")) {
//                  if (value == null || value.equals("")) {
//                      continue;
//                  }
//              }
//update-end--Author:Quainty  Date:20130520 for锛欽DBC鏂瑰紡璋冪敤
//----------------------------------------------------------------
              setProperty(bean, name, value);
          }
          catch (NoSuchMethodException e) {
              continue;
          }
      }
  }

  /**
   * Map鍐呯殑key涓嶣ean涓睘鎬х浉鍚岀殑鍐呭澶嶅埗鍒癇EAN涓�
   * 瀵逛簬瀛樺湪绌哄�鐨勫彇榛樿鍊�
   * @param bean Object
   * @param properties Map
   * @param defaultValue String
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  public static void copyMap2Bean(Object bean, Map properties, String defaultValue) throws
      IllegalAccessException, InvocationTargetException {
      // Do nothing unless both arguments have been specified
      if ( (bean == null) || (properties == null)) {
          return;
      }
      // Loop through the property name/value pairs to be set
      Iterator names = properties.keySet().iterator();
      while (names.hasNext()) {
          String name = (String) names.next();
          // Identify the property name and value(s) to be assigned
          if (name == null) {
              continue;
          }
          Object value = properties.get(name);
          try {
              Class clazz = PropertyUtils.getPropertyType(bean, name);
              if (null == clazz) {
                  continue;
              }
              String className = clazz.getName();
              if (className.equalsIgnoreCase("java.sql.Timestamp")) {
                  if (value == null || value.equals("")) {
                      continue;
                  }
              }
              if (className.equalsIgnoreCase("java.lang.String")) {
                  if (value == null) {
                      value = defaultValue;
                  }
              }
              setProperty(bean, name, value);
          }
          catch (NoSuchMethodException e) {
              continue;
          }
      }
  }
  
  public MyBeanUtils() {
    super();
  }
}
