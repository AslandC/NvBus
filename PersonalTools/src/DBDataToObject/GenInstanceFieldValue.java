package DBDataToObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将数据库查到的值赋值给VO对象
 *
 */
public class GenInstanceFieldValue {
	
	public static void main(String[] args) {
		GenInstanceFieldValue test = new GenInstanceFieldValue();
		
		//将数据库中查到的值赋值给DTO
		List<Object[]> dbDataList = new ArrayList<Object[]>();
		Object[] array1 = new Object[20];
		array1[0] = Long.valueOf(3);
		array1[1] = "aa";
		array1[2] = "bb";
		Object[] array2 = new Object[20];
		array2[0] = Long.valueOf(4);
		array2[1] = "ggg";
		array2[2] = "jjj";
		
		dbDataList.add(array1);
		dbDataList.add(array2);
		test.autoFillDBDataToObj(Organization.class, dbDataList);
		
		//生成类中属性全为public的字段的set方法
		//test.genSetters4Public(Organization.class, "dto", "arrayName");
		
		//生成类中属性全为private的字段的set方法
		//test.genSetters4Private(Organization.class, "dto", "arrayName");
	}
	
	/**
	 * 通过反射自动将数据库中查出的array数据赋值给对象种对应字段
	 * @param dbDataList
	 */
	public void autoFillDBDataToObj(Class classs, List<Object[]> dbDataList) {
		//基本数据类型  此数组的顺序不可改变
		final String[] typeArray = {"boolean", "byte", "char", "double", "float", "int", "long", "short"};
		Arrays.sort(typeArray);
		int index = 0;//字段类型在基本数据类型数组中的下标
		
		//多条数据
		for (Object[] objects : dbDataList) {
			Object[] array = objects;
			Object obj = null;
			try {
				obj = classs.newInstance();//获取对象实体
				Field[] fields = classs.getDeclaredFields();//获取字段
				for (int i = 0; i < fields.length - 1; i++) {//根据VO字段进行赋值
				//for (int i = 0; i < array.length; i++) {//根据array数组进行赋值
					Field field = fields [i];
					field.setAccessible(true);//属性为private需设置为true
					try {
						String type = field.getType().toString();
						
						//处理基本数据类型，控制无法赋null
						index = Arrays.binarySearch(typeArray, type);
						switch (index) {
						case 0:
							//boolean
							field.set(obj, false);
							break;
						case 1:
							//byte
							field.set(obj, (byte)0);
							break;
						case 2:
							//char
							field.set(obj, '\u0000');
							break;
						case 3:
							//double
							field.set(obj, 0.0d);
							break;
						case 4:
							//float
							field.set(obj, 0.0f);
							break;
						case 5:
							//int
							field.set(obj, 0);
							break;
						case 6:
							//long
							field.set(obj, 0L);
							break;
						case 7:
							//short
							field.set(obj, (short)0);
							break;
						default:
							//对象类型
							field.set(obj, array[i]);
							break;
						} 
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			
			
			//输出每个对象被赋值之后的对象各字段的值，以便确认是否正确
			Field[] fields = classs.getDeclaredFields();
			for (int i = 0; i < fields.length - 1; i++) {
				fields[i].setAccessible(true);
				try {
					System.out.println(fields[i].getName() + " = " + fields[i].get(obj));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			System.out.println("-------------------------分割线-------------------------");
		}
	}
	
	/**
	 * 给公有声明的属性赋值
	 * @param classs：类的class对象
	 * @param instanceName：将要被赋值的对象名称
	 * @param arrayName：数组名称
	 */
	public void genSetters4Private(Class classs, String instanceName, String arrayName){
		Field[] fields = classs.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			String type = field.getType().toString();
			if(type.contains("java.")){
				type = type.substring(type.lastIndexOf(".") + 1, type.length());
			}else{
				type = type.substring(0, 1).toUpperCase() + type.substring(1, type.length());
			}
			
			StringBuffer str = new StringBuffer();
			str.append(instanceName).append(".set").append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1, fieldName.length())).append("(")
				.append("(").append(type).append(") ")
				.append(arrayName).append("[").append(i).append("]);");
			System.out.println(str.toString());
		}
	}
	
	/**
	 * 
	 * @param classs：类的class对象
	 * @param instanceName：将要被赋值的对象名称
	 * @param arrayName：数组名称
	 */
	public void genSetters4Public(Class classs, String instanceName, String arrayName){
		Field[] fields = classs.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			String type = field.getType().toString();
			if(type.contains("java.")){
				type = type.substring(type.lastIndexOf(".") + 1, type.length());
			}else{
				type = type.substring(0, 1).toUpperCase() + type.substring(1, type.length());
			}
			
			StringBuffer str = new StringBuffer();
			str.append(instanceName).append(".")
				.append(fieldName)
				.append(" = (").append(type).append(") ")
				.append(arrayName).append("[").append(i).append("];");
			System.out.println(str.toString());
		}
	}

}
