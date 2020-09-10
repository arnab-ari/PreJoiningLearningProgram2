using System;

namespace DateTimeCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            var date1 = DateTime.Now;
            var date2 = new DateTime(2020, 12, 31);
            var dtc = new DateTimeCalculator();
            dtc.SubtractDates(date1, date2);
            Console.WriteLine(dtc.AddDaysTo(date1, 128));
            Console.WriteLine(date1.ToString("yyyy-MM-dd"));
            Console.WriteLine(dtc.CurrentMonth());
            Console.WriteLine(dtc.NextMonth());
            Console.WriteLine(dtc.LastMonth());
            Console.WriteLine(dtc.DayOfWeek(date1));
            Console.WriteLine(dtc.WeekNumber(date1));
        }
    }
}
