package leetcode.ordered_set.my_calendar_i;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author cy
 * @className MyCalendar
 * @description TODO
 * @date 2021/9/19 19:15
 */
public class MyCalendar {


    /**
     * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
     *
     * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
     *
     * The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end),
     * the range of real numbers x such that start <= x < end.
     *
     * Implement the MyCalendar class:
     *
     *     MyCalendar() Initializes the calendar object.
     *     boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking.
     *     Otherwise, return false and do not add the event to the calendar.
     *
     * Input
     * ["MyCalendar", "book", "book", "book"]
     * [[], [10, 20], [15, 25], [20, 30]]
     * Output
     * [null, true, false, true]
     *
     * Explanation
     * MyCalendar myCalendar = new MyCalendar();
     * myCalendar.book(10, 20); // return True
     * myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
     * myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
     */

    //Brute Force
//    List<int[]> calender;
//
//    public MyCalendar() {
//        calender = new ArrayList<>();
//    }
//
//    public boolean book(int start, int end) {
//        for(int[] iv: calender)
//        {
//            if(iv[0] < end && start < iv[1])
//            {
//                return false;
//            }
//        }
//        calender.add(new int[] {start, end});
//        return true;
//    }


    // balanced tree
    TreeMap<Integer,Integer> calender;

    public MyCalendar() {
        calender = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calender.floorKey(start);
        Integer next = calender.ceilingKey(start);
        if((prev == null || calender.get(prev) <= start) &&
                (next == null || end <= next))
        {
            calender.put(start,end);
            return true;
        }
        return false;
    }
}
