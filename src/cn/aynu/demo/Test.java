package cn.aynu.demo;

import java.util.LinkedList;
import java.util.List;

public class Test {

    private String[] a = new String[]{
            "{time:1}",
            "{time:5}",
            "{time:8}",
            "{time:11}",
            "{time:16}",
            "{time:17}",
            "{time:29}",
            "{time:34}",
            "{time:39}"};
    private int[] time_line = new int[]{3, 7, 12, 17, 19, 31, 40};

    public String[] result() {

        String[] strings = new String[time_line.length];

        List<Integer> list = new LinkedList<>();

        //切割字符串,并把数值添加到集合里
        for (int i = 0; i < a.length; i++) {
            Integer integ = Integer.valueOf(a[i].substring(6, a[i].length() - 1));
            list.add(integ);
        }

        //循环遍历time_line数组
        flag:for (int i = 0; i < time_line.length; i++) {

            int temp = time_line[i];

            for (int j = 0; j <= list.size()-2; j++) {
                //当该值在这个集合两个值之间的时候,做差比大小看哪个是最近的
                if(temp > list.get(j) && temp < list.get(j+1)){
                    int value = Math.abs(temp - list.get(j)) < (Math.abs(list.get(j+1) - temp)) ? j : j+1;
                    strings[i] = "{line:" + time_line[i] +",time:"+list.get(value)+"}";
                    //移除该值
                    list.remove(value);
                    //跳出循环继续遍历time_line数组
                    continue flag;
                }else if(temp == list.get(j)){//当该值跟集合中的数值相等时
                    strings[i] = "{line:" + time_line[i] +",time:"+list.get(j)+"}";
                    list.remove(j);
                    continue flag;
                }else if(temp <= list.get(0)){//当该值小于等于该集合的最小的值还小的时候
                    strings[i] = "{line:" + time_line[i] +",time:"+list.get(0)+"}";
                    list.remove(0);
                    continue flag;
                }else if(temp >= list.get(list.size()-1)){//当该值大于等于该集合的最大值的时候
                    strings[i] = "{line:" + time_line[i] +",time:"+list.get(list.size()-1)+"}";
                    list.remove(list.size()-1);
                    continue flag;
                }
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        Test test = new Test();
        String[] result = test.result();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
