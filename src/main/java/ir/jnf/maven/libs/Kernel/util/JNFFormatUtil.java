/**
 *
 */
package ir.jnf.maven.libs.Kernel.util;

import ir.jnf.maven.libs.Kernel.convertor.NumberPlus;

import java.io.Serializable;

import org.joda.time.DateTime;

/**
 * @author eae966
 *
 */
public class JNFFormatUtil implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5235649938845671352L;
	private static final String[] persianMonthName = { "فروردين", "ارديبهشت",
			"خرداد", "تير", "مرداد", "شهريور", "مهر", "آبان", "آذر", "دی",
			"بهمن", "اسفند" };
	private static final String[] persianWeekDays = { "شنبه", "یک‌شنبه",
			"دوشنبه", "سه‌شنبه", "چهارشنبه", "پنج‌شنبه", "جمعه" };
	private static final String[] georgianMonthPersianName = { "ژانویه",
			"فوریه", "مارس", "آوریل", "مه", "ژوئن", "ژوئیه", "اوت", "سپتامبر",
			"اکتبر", "نوامبر", "دسامبر" };
	private static final String[] georgianMonthEnglishName = { "January",
			"February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private static final String[] georgianMonthEnglishShortName = { "Jan",
			"Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
			"Nov", "Dec" };
	private static final String[] dayStatusEnglish = { "AM", "PM" };
	private static final String[] dayStatusPersian = { "قبل از ظهر",
			"بعد از ظهر" };

	/**
	 *
	 */
	public JNFFormatUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String format(DateTime dt, String format) {
		String result = "";
		try {
			int j = 0;
			while (j < format.length()) {
				if ((format.length() - j >= 5)
						&& format.substring(j, j + 5).equals("PYYYY")) {
					NumberPlus np = new NumberPlus(dt.getYear());
					result += np.getPersian();
					j = j + 5;
				}

				else if ((format.length() - j >= 5)
						&& format.substring(j, j + 5).equals("EYYYY")) {
					result += dt.getYear();
					j = j + 5;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PYY")) {
					NumberPlus np = new NumberPlus(String.valueOf(dt.getYear())
							.substring(2));
					result += np.getPersian(2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EYY")) {
					result += String.valueOf(dt.getYear()).substring(2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PMM")) {
					NumberPlus np = new NumberPlus(dt.getMonthOfYear());
					result += np.getPersian(2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EMM")) {
					result += JNFStringUtil.fillStringFromFirstToFixSize(
							dt.getMonthOfYear(), '0', 2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PMF")) {
					result += persianMonthName[dt.getMonthOfYear() - 1];
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EMF")) {
					result += georgianMonthPersianName[dt.getMonthOfYear() - 1];
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EME")) {
					result += georgianMonthEnglishName[dt.getMonthOfYear() - 1];
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EMS")) {
					result += georgianMonthEnglishShortName[dt.getMonthOfYear() - 1];
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PDW")) {
					result += persianWeekDays[dt.getDayOfWeek() - 1];
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PDD")) {
					NumberPlus np = new NumberPlus(dt.getDayOfMonth());
					result += np.getPersian(2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PDY")) {
					NumberPlus np = new NumberPlus(dt.getDayOfYear());
					result += np.getPersian();
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EDD")) {
					result += JNFStringUtil.fillStringFromFirstToFixSize(
							dt.getDayOfMonth(), '0', 2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EDY")) {
					result += dt.getDayOfYear();
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Phh")) {
					NumberPlus np = new NumberPlus(dt.getHourOfDay());
					result += np.getPersian(2);
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Ehh")) {
					result += JNFStringUtil.fillStringFromFirstToFixSize(
							dt.getHourOfDay(), '0', 2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PHH")) {
					int hour = dt.getHourOfDay();
					if (hour > 12)
						hour = hour - 12;
					NumberPlus np = new NumberPlus(hour);
					result += np.getPersian(2);
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EHH")) {
					int hour = dt.getHourOfDay();
					if (hour > 12)
						hour = hour - 12;
					result += JNFStringUtil.fillStringFromFirstToFixSize(hour,
							'0', 2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Pmm")) {
					NumberPlus np = new NumberPlus(dt.getMinuteOfHour());
					result += np.getPersian(2);
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Emm")) {
					result += JNFStringUtil.fillStringFromFirstToFixSize(
							dt.getMinuteOfHour(), '0', 2);
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Pss")) {
					NumberPlus np = new NumberPlus(dt.getSecondOfMinute());
					result += np.getPersian(2);
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Ess")) {
					result += JNFStringUtil.fillStringFromFirstToFixSize(
							dt.getSecondOfMinute(), '0', 2);
					j = j + 3;
				}

				else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Pms")) {
					NumberPlus np = new NumberPlus(dt.getMillisOfSecond());
					result += np.getPersian();
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("Ems")) {
					result += dt.getMillisOfSecond();
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("PDS")) {
					if (dt.getHourOfDay() <= 12)
						result += dayStatusPersian[0];
					else
						result += dayStatusPersian[1];
					j = j + 3;
				} else if ((format.length() - j >= 3)
						&& format.substring(j, j + 3).equals("EDS")) {
					if (dt.getHourOfDay() <= 12)
						result += dayStatusEnglish[0];
					else
						result += dayStatusEnglish[1];
					j = j + 3;
				}

				else {
					result += format.charAt(j);
					j++;
				}
			}
		} catch (Exception e) {
			result = "NA";
		}
		return result;

	}

}
