using System;
using System.Globalization;

namespace DateTimeCalculator
{
	public class DateTimeCalculator
	{

		public void SubtractDates(DateTime d1, DateTime d2)
		{
			var span = new TimeSpan(d2.Ticks - d1.Ticks);
			var difference = Convert.ToInt64(span.TotalDays);
			Console.WriteLine("Difference between {0} and {1} is {2} days", d2, d1, difference);
		}

		public DateTime AddDaysTo(DateTime date,long n)
        {
			var result = date.AddDays(n);
			return DateTime.Parse(result.ToString("yyyy-MM-dd"));
        }

		public DateTime SubtractDaysFrom(DateTime date,long n)
        {
			return AddDaysTo(date, -n);
        }

		public DateTime Today()
        {
			return DateTime.Today;
        }

		public DateTime Tomorrrow()
        {
			return AddDaysTo(Today(), 1);
        }

		public DateTime DayAfterTomorrrow()
		{
			return AddDaysTo(Today(), 2);
		}

		public DateTime Yesterday()
        {
			return SubtractDaysFrom(Today(), 1);
        }

		public DateTime DayBeforeYesterday()
		{
			return SubtractDaysFrom(Today(), 2);
		}

		public string GetMonthName(DateTime date)
        {
			return CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(date.Month);
		}
		public string CurrentMonth()
        {
			return GetMonthName(DateTime.Now);
        }

		public string NextMonth()
		{
			return GetMonthName(DateTime.Now.AddMonths(1));
		}

		public string LastMonth()
        {
			return DateTime.Now.AddMonths(-1).ToString("MMMM");
		}

		public int NextYear()
        {
			return DateTime.Now.Year + 1;
        }

		public int LastYear()
        {
			return DateTime.Now.Year - 1;
        }

		public string DayOfWeek(DateTime date)
        {
			return CultureInfo.CurrentCulture.DateTimeFormat.GetDayName(date.DayOfWeek);
        }

		public int WeekNumber(DateTime date)
        {
			return CultureInfo.CurrentCulture.Calendar.GetWeekOfYear(date, CalendarWeekRule.FirstFourDayWeek, System.DayOfWeek.Monday);
        }
	}
}

/*



}

public MyDate yesterday()
{
	return subtractDaysFrom(new MyDate(), 1);
}

public MyDate dayBeforeYesterday()
{
	return subtractDaysFrom(new MyDate(), 2);
}

public String nextMonth()
{
	return Month.of(new MyDate().date.getMonthValue() + 1).toString();
}

public String lastMonth()
{
	return Month.of(new MyDate().date.getMonthValue() - 1).toString();
}

public int nextYear()
{
	return (new MyDate().date.getYear() + 1);
}

public int lastYear()
{
	return (new MyDate().date.getYear() - 1);
} */
