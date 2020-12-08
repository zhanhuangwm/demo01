package cn.aynu.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输出开始工作的时间，输入时间的格式：2020-03-21 14:23:31");
            String beginTime = scanner.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                Date begindate = format.parse(beginTime);
                String[] str = beginTime.split(" ");
                Date enddate;
                Date[] dates = new Date[6];
                dates[0] = format.parse(str[0] + " " + "8:00:00");
                dates[1] = format.parse(str[0] + " " + "9:00:00");
                dates[2] = format.parse(str[0] + " " + "12:00:00");
                dates[3] = format.parse(str[0] + " " + "14:00:00");
                dates[4] = format.parse(str[0] + " " + "15:00:00");
                dates[5] = format.parse(str[0] + " " + "18:00:00");

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(format.parse(beginTime));
                // 判断是星期几
                int week = calendar.get(Calendar.DAY_OF_WEEK);
                // 如果是星期日，星期一的11点结束
                if (week == 1) {
                    calendar.setTime(format.parse(str[0] + " " + "11:00:00"));
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    // 如果是星期六，星期一的11点结束
                } else if (week == 7) {
                    calendar.setTime(format.parse(str[0] + " " + "11:00:00"));
                    calendar.add(Calendar.DAY_OF_YEAR, 2);
                    // 当天8点前，11点结束
                } else if (begindate.before(dates[0]) || begindate.equals(dates[0])) {
                    calendar.setTime(format.parse(str[0] + " " + "11:00:00"));
                    // 8到9点间，直接加3小时
                } else if (begindate.after(dates[0]) && begindate.before(dates[1])
                        || begindate.equals(dates[1])) {
                    calendar.add(Calendar.HOUR, 3);
                    // 9点到12点间加5小时
                } else if (begindate.after(dates[1]) && begindate.before(dates[2])
                        || begindate.equals(dates[2])) {
                    calendar.add(Calendar.HOUR, 5);
                    // 12点到14点间，17点结束
                } else if (begindate.after(dates[2]) && begindate.before(dates[3])
                        || begindate.equals(dates[3])) {
                    calendar.setTime(format.parse(str[0] + " " + "17:00:00"));
                    // 14点到15点间，直接加3小时
                } else if (begindate.after(dates[3]) && begindate.before(dates[4])
                        || begindate.equals(dates[4])) {
                    calendar.add(Calendar.HOUR, 3);
                    // 15点到18点间，加17小时
                } else if (begindate.after(dates[4]) && begindate.before(dates[5])
                        || begindate.equals(dates[5])) {
                    calendar.add(Calendar.HOUR, 17);
                    // 18点到24点间，次日11点结束
                } else {
                    calendar.setTime(format.parse(str[0] + " " + "11:00:00"));
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                }

                // 再判断是星期几
                week = calendar.get(Calendar.DAY_OF_WEEK);
                // 如果是星期六，就在加2天
                if (week == 7) {
                    calendar.add(Calendar.DAY_OF_YEAR, 2);
                }

                System.out.println(format.format(calendar.getTime()));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
