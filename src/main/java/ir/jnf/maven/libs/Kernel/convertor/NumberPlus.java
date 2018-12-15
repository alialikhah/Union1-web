package ir.jnf.maven.libs.Kernel.convertor;

import ir.jnf.maven.libs.Kernel.util.JNFCharUtil;
import ir.jnf.maven.libs.Kernel.util.JNFStringUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberPlus {
	private static final int convertNumber = 1728;
	public static final BigDecimal ONE = new BigDecimal(1);
	public static final BigDecimal TWO = new BigDecimal(2);
	public static final BigDecimal THREE = new BigDecimal(3);
	public static final BigDecimal FOUR = new BigDecimal(4);
	public static final BigDecimal FIVE = new BigDecimal(5);
	public static final BigDecimal SIX = new BigDecimal(6);
	public static final BigDecimal SEVEN = new BigDecimal(7);
	public static final BigDecimal EIGHTH = new BigDecimal(8);
	public static final BigDecimal NINE = new BigDecimal(9);
	public static final BigDecimal TEN = new BigDecimal(10);
	public static final BigDecimal ELEVEN = new BigDecimal(11);
	public static final BigDecimal TWELVE = new BigDecimal(12);
	public static final BigDecimal THIRTEEN = new BigDecimal(13);
	public static final BigDecimal FOURTEEN = new BigDecimal(14);
	public static final BigDecimal FIFTEEN = new BigDecimal(15);
	public static final BigDecimal SIXTEEN = new BigDecimal(16);
	public static final BigDecimal SEVENTEEN = new BigDecimal(17);
	public static final BigDecimal EIGHTHTEEN = new BigDecimal(18);
	public static final BigDecimal NINETEEN = new BigDecimal(19);
	public static final BigDecimal TWENTY = new BigDecimal(20);
	public static final BigDecimal THIRTY = new BigDecimal(30);
	public static final BigDecimal FORTY = new BigDecimal(40);
	public static final BigDecimal FIFTY = new BigDecimal(50);
	public static final BigDecimal SIXTY = new BigDecimal(60);
	public static final BigDecimal SEVENTY = new BigDecimal(70);
	public static final BigDecimal EIGHTY = new BigDecimal(80);
	public static final BigDecimal NINETY = new BigDecimal(90);
	public static final BigDecimal HUNDRED = new BigDecimal(100);
	public static final BigDecimal ONEHUNDRED = new BigDecimal(100);
	public static final BigDecimal TWOHUNDRED = new BigDecimal(200);
	public static final BigDecimal THREEHUNDRED = new BigDecimal(300);
	public static final BigDecimal FOURHUNDRED = new BigDecimal(400);
	public static final BigDecimal FIVEHUNDRED = new BigDecimal(500);
	public static final BigDecimal SIXHUNDRED = new BigDecimal(600);
	public static final BigDecimal SEVENHUNDRED = new BigDecimal(700);
	public static final BigDecimal EIGHTHUNDRED = new BigDecimal(800);
	public static final BigDecimal NINEHUNDRED = new BigDecimal(900);
	public static final BigDecimal THOUSAND = new BigDecimal(1000);
	public static final BigDecimal TWOTHOUSAND = new BigDecimal(2000);
	public static final BigDecimal THREETHOUSAND = new BigDecimal(3000);
	public static final BigDecimal FOURTHOUSAND = new BigDecimal(4000);
	public static final BigDecimal FIVETHOUSAND = new BigDecimal(5000);
	public static final BigDecimal SIXTHOUSAND = new BigDecimal(6000);
	public static final BigDecimal SEVENTHOUSAND = new BigDecimal(7000);
	public static final BigDecimal EIGHTHTHOUSAND = new BigDecimal(8000);
	public static final BigDecimal NINETHOUSAND = new BigDecimal(9000);
	public static final BigDecimal TENTHOUSAND = new BigDecimal(10000);
	private final DecimalFormatSymbols separateSymbol = new DecimalFormatSymbols(Locale.US);

	private final char[] value;

	private enum LangStat {
		PERSIAN, ENGLISH
	}

	public enum SepStat {
		COMMA, DOT, SLASH
	}

	@SuppressWarnings("unused")
	private NumberPlus() {
		this.value = new char[0];
	}

	public NumberPlus(String value) throws NumberFormatException {
		if (value == null)
			this.value = "0".toCharArray();
		else if (value.trim().isEmpty())
			this.value = "0".toCharArray();
		else {
			value = value.trim();
			value = value.replaceAll(",", "");
			this.value = value.toCharArray();
		}
	}

	public NumberPlus(Integer value) {
		this.value = String.valueOf(value).toCharArray();
	}

	public NumberPlus(Long value) {
		this.value = String.valueOf(value).toCharArray();
	}

	public NumberPlus(Float value) {
		this.value = String.valueOf(value).toCharArray();
	}

	public NumberPlus(Double value) {
		this.value = String.valueOf(value).toCharArray();
	}

	public NumberPlus(BigDecimal value) {
		this.value = String.valueOf(value).toCharArray();
	}

	public String getEnglish() {
		return getEnglish(value);
	}

	private String getEnglish(char[] charArr) {
		if (charArr[0] == '.')
			charArr = JNFCharUtil.addCharToFirstPosOfCharArray(charArr, '0');
		else if (charArr[0] == '-' && charArr[1] == '.')
			charArr = JNFCharUtil.addCharToCharArray(charArr, '0', 1);
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] >= 1776 && charArr[i] <= 1785) {
				charArr[i] = (char) (charArr[i] - convertNumber);
			}
		}

		return new String(charArr);
	}

	private String getSeparate(LangStat language) {
		separateSymbol.setDecimalSeparator('.');
		separateSymbol.setGroupingSeparator(',');

		DecimalFormat formatter = new DecimalFormat("", separateSymbol);

		String str = formatter.format(Double.parseDouble(getEnglish(value)));

		if (language == LangStat.PERSIAN)
			return getPersian(str.toCharArray());

		return str;
	}

	private String getSeparate(SepStat decimalSep, SepStat groupSep, LangStat language) {
		switch (decimalSep) {
		case COMMA:
			separateSymbol.setDecimalSeparator(',');
			break;
		case DOT:
			separateSymbol.setDecimalSeparator('.');
			break;
		case SLASH:
			separateSymbol.setDecimalSeparator('/');
			break;

		default:
			break;
		}

		switch (groupSep) {
		case COMMA:
			separateSymbol.setGroupingSeparator(',');
			break;
		case DOT:
			separateSymbol.setGroupingSeparator('.');
			break;
		case SLASH:
			separateSymbol.setGroupingSeparator('/');
			break;

		default:
			break;
		}

		DecimalFormat formatter = new DecimalFormat("", separateSymbol);

		String str = formatter.format(Double.parseDouble(getEnglish(value)));

		if (language == LangStat.PERSIAN)
			return getPersian(str.toCharArray());

		return str;
	}

	public String getEnglishSep() {
		return getSeparate(LangStat.ENGLISH);
	}

	public String getEnglishSep(SepStat decimalSep, SepStat groupSep) {
		return getSeparate(decimalSep, groupSep, LangStat.ENGLISH);
	}

	public String getPersian() {
		return getPersian(value);
	}

	public String getPersian(int count) {
		return JNFStringUtil.fillStringFromFirstToFixSize(getPersian(value), '۰', 2);
	}

	private String getPersian(char[] charArr) {
		if (charArr[0] == '.')
			charArr = JNFCharUtil.addCharToFirstPosOfCharArray(charArr, '0');
		else if (charArr[0] == '-' && charArr[1] == '.')
			charArr = JNFCharUtil.addCharToCharArray(charArr, '0', 1);
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] >= 48 && charArr[i] <= 57) {
				charArr[i] = (char) (charArr[i] + convertNumber);
			}
		}

		return new String(charArr);
	}

	public String getPersianSep() {
		return getSeparate(LangStat.PERSIAN);
	}

	public String getPersianSep(SepStat decimalSep, SepStat groupSep) {
		return getSeparate(decimalSep, groupSep, LangStat.PERSIAN);
	}

	public Integer getInteger() {
		return Double.valueOf(getEnglish(value)).intValue();
	}

	public Long getLong() {
		return Double.valueOf(getEnglish(value)).longValue();
	}

	public Double getDouble() {
		return Double.valueOf(getEnglish(value));
	}

	public Float getFloat() {
		return Float.valueOf(getEnglish(value));
	}

	public static String getPersianNumber(BigDecimal value) {
		NumberPlus np = new NumberPlus(value);
		return np.getPersianSep();
	}

	public static String getPersianNumber(Integer value) {
		NumberPlus np = new NumberPlus(value);
		return np.getPersianSep();
	}

	public static String getEnglishNumber(BigDecimal value) {
		NumberPlus np = new NumberPlus(value);
		return np.getEnglishSep();
	}

	public static BigDecimal getPercent(BigDecimal base, BigDecimal percent) {
		return base.multiply(percent).divide(HUNDRED);
	}

	public static BigDecimal getPercent(BigDecimal base, int percent) {
		return base.multiply(new BigDecimal(percent)).divide(HUNDRED);
	}

	public static BigDecimal getPercent(BigDecimal base, float percent) {
		return base.multiply(new BigDecimal(percent)).divide(HUNDRED);
	}

	public static BigDecimal getPercent(BigDecimal base, double percent) {
		return base.multiply(new BigDecimal(percent)).divide(HUNDRED);
	}

	public static BigDecimal subtractPercent(BigDecimal base, BigDecimal percent) {
		return base.subtract(getPercent(base, percent));
	}

	public static BigDecimal addPercent(BigDecimal base, BigDecimal percent) {
		return base.add(getPercent(base, percent));
	}

	public static BigDecimal subtractPercent(BigDecimal base, int percent) {
		return base.subtract(getPercent(base, percent));
	}

	public static BigDecimal addPercent(BigDecimal base, int percent) {
		return base.add(getPercent(base, percent));
	}

	public static BigDecimal subtractPercent(BigDecimal base, double percent) {
		return base.subtract(getPercent(base, percent));
	}

	public static BigDecimal addPercent(BigDecimal base, double percent) {
		return base.add(getPercent(base, percent));
	}

	public static BigDecimal subtractPercent(BigDecimal base, float percent) {
		return base.subtract(getPercent(base, percent));
	}

	public static BigDecimal addPercent(BigDecimal base, float percent) {
		return base.add(getPercent(base, percent));
	}
}
