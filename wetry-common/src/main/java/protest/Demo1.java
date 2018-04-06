package protest;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Demo1 {
    //一个反射方法，将JobDO转换为Job，前者比后者类中只多了部分常量
    private static List<Job> transJobDOtoJob(List<JobDO> source) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (source == null || source.size() == 0) {
            return Collections.unmodifiableList(new ArrayList<Job>(0));
        }
        ArrayList<Job> list = new ArrayList<>(source.size());
        for (JobDO jobdo : source) {
            Field[] fields = jobdo.getClass().getFields();
            Job job = Job.class.newInstance();
            Method[] methods = job.getClass().getMethods();
            for (int i = 0; i < fields.length; i++) {
                //1、获取属性名
                String name = fields[i].getName();
                //2、调用元对象的gettter，填充目标对象的setter
                String getter = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                String setter = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

                String type = fields[i].getGenericType().toString(); // 获取属性的类型

                Method method = jobdo.getClass().getMethod(getter);
                if (method != null && type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = method;
                    String value = (String) m.invoke(jobdo); // 调用getter方法获取属性值
                    m = job.getClass().getMethod(setter, String.class);
                    m.invoke(job, value == null ? "" : value);
                } else if (method != null && type.equals("class java.lang.Integer")) {
                    Method m = method;
                    Integer value = (Integer) m.invoke(jobdo); // 调用getter方法获取属性值
                    m = job.getClass().getMethod(setter, Integer.class);
                    m.invoke(job, value);
                } else if (method != null && type.equals("class java.lang.Boolean")) {
                    Method m = method;
                    Boolean value = (Boolean) m.invoke(jobdo); // 调用getter方法获取属性值
                    m = job.getClass().getMethod(setter, Boolean.class);
                    m.invoke(job, value);
                } else if (method != null && type.equals("class java.lang.Long")) {
                    Method m = method;
                    Long value = (Long) m.invoke(jobdo); // 调用getter方法获取属性值
                    m = job.getClass().getMethod(setter, Long.class);
                    m.invoke(job, value);
                } else if (method != null && type.equals("class java.lang.Date")) {
                    Method m = method;
                    Date value = (Date) m.invoke(jobdo); // 调用getter方法获取属性值
                    m = job.getClass().getMethod(setter, Date.class);
                    m.invoke(job, value);
                } else if (method != null && "int".equals(type)) {
                }//属性增加了类型需增加类型判断
                list.add(job);
            }
        }
        return list;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JobDO j = new JobDO();
//        j.setAuditStatus(1);
//        j.setBrandId(123);
//        j.setDegree(1234213);
        List<Job> jobs = transJobDOtoJob(Lists.newArrayList(new JobDO[]{j}));
        for (Job job : jobs) {
            System.out.println(jobs.toString());
        }
    }
}
