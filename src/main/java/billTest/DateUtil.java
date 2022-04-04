package billTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	/**
	 * Description	현재일자
	 * @param
	 * @return      YYYYMMDD
	 */
   public static String getTodate() {

    	String result = "";
		Calendar cal = new GregorianCalendar();
    	int iYYYY    = cal.get(Calendar.YEAR);
		int iMM      = cal.get(Calendar.MONTH)+1;
		int iDD      = cal.get(Calendar.DATE);

		result = String.format("%04d%02d%02d", iYYYY,iMM,iDD);

		return result;
    }

	/**
	 * Description	현재일자
	 * @param
	 * @return      YYYYMM
	 */
   public static String getTodateMonth() {

   		String result = "";
		Calendar cal = new GregorianCalendar();
		int iYYYY    = cal.get(Calendar.YEAR);
		int iMM      = cal.get(Calendar.MONTH)+1;

		result = String.format("%04d%02d", iYYYY,iMM);

		return result;
   }



	/**
	 * Description	현재일자 (구분자 설정)
	 * @param       sDeli : 구분자
	 * @return      YYYY-MM-DD
	 */
   public static String getTodate(String sDeli) {

	   	String result = "";
		Calendar cal = new GregorianCalendar();
	   	int iYYYY    = cal.get(Calendar.YEAR);
		int iMM      = cal.get(Calendar.MONTH)+1;
		int iDD      = cal.get(Calendar.DATE);

		result = String.format("%04d%s%02d%s%02d", iYYYY,sDeli,iMM,sDeli,iDD);

		return result;
   }

    /**
	 * Description	일자계산
	 * @param       sYYYYMMDD : 기준일자
	 *              sGBN      : DATE-일, MONTH-월, YEAR-년
	 *              iVALUE    : sGBN을 iVALUE 만큼 이동한 일자
	 * @return      YYYYMMDD
	 */
    public static String getCalcDate(String sYYYYMMDD, String sGBN, int iVALUE) {

        String result = "";
        String sYYYY  = sYYYYMMDD.substring(0, 4);
        String sMM    = sYYYYMMDD.substring(4, 6);
        String sDD    = sYYYYMMDD.substring(6, 8);
        Calendar cal  = Calendar.getInstance();

        cal.set( Integer.parseInt(sYYYY), Integer.parseInt(sMM) -1 ,Integer.parseInt(sDD)) ;

        if     (sGBN.equals("DATE"))	cal.add(Calendar.DATE , iVALUE);
        else if(sGBN.equals("MONTH"))	cal.add(Calendar.MONTH, iVALUE);
        else if(sGBN.equals("YEAR"))	cal.add(Calendar.YEAR , iVALUE);

        int iYYYY = cal.get(Calendar.YEAR);
        int iMM   = cal.get(Calendar.MONTH)+1;
        int iDD   = cal.get(Calendar.DATE);

        result = String.format("%04d%02d%02d", iYYYY, iMM, iDD);

        return result;
    }

    /**
	 * Description	일자계산 (구분자 설정)
	 * @param       sYYYYMMDD : 기준일자
	 *              sGBN      : DATE-일, MONTH-월, YEAR-년
	 *              iVALUE    : sGBN을 iVALUE 만큼 이동한 일자
	 *              sDeli     : 구분자
	 * @return      YYYYMMDD
	 */
	public static String getCalcDate(String sYYYYMMDD, String sGBN, int iVALUE, String sDeli) {

		String result = "";

		sYYYYMMDD = sYYYYMMDD.replaceAll( "/", "" ).replaceAll( "-", "" ).replaceAll( ":", "" );

		if( sYYYYMMDD.length() != 8 )
        	result = sYYYYMMDD;
	    else {

	        String sYYYY  = sYYYYMMDD.substring(0, 4);
	        String sMM    = sYYYYMMDD.substring(4, 6);
	        String sDD    = sYYYYMMDD.substring(6, 8);
	        Calendar cal  = Calendar.getInstance();

	        cal.set( Integer.parseInt(sYYYY), Integer.parseInt(sMM) -1 ,Integer.parseInt(sDD)) ;

	        if     (sGBN.equals("DATE"))	cal.add(Calendar.DATE , iVALUE);
	        else if(sGBN.equals("MONTH"))	cal.add(Calendar.MONTH, iVALUE);
	        else if(sGBN.equals("YEAR"))	cal.add(Calendar.YEAR , iVALUE);

	        int iYYYY = cal.get(Calendar.YEAR);
	        int iMM   = cal.get(Calendar.MONTH)+1;
	        int iDD   = cal.get(Calendar.DATE);

		    result = String.format("%04d%s%02d%s%02d", iYYYY,sDeli,iMM,sDeli,iDD);
	    }

	    return result;
	}

	/**
	 * Description	일자계산2 (구분자 설정)
	 * @param       sYYYYMMDD : 기준일자
	 *              sGBN      : DATE-일, MONTH-월, YEAR-년
	 *              iVALUE    : sGBN을 iVALUE 만큼 이동한 일자
	 *              sDeli     : 구분자
	 * @return      YYYYMMDD + 1
	 */
	public static String getCalcDate2(String sYYYYMMDD, String sGBN, int iVALUE, String sDeli) {

		String result = "";

		sYYYYMMDD = sYYYYMMDD.replaceAll( "/", "" ).replaceAll( "-", "" ).replaceAll( ":", "" );

		if( sYYYYMMDD.length() != 8 )
        	result = sYYYYMMDD;
	    else {

	        String sYYYY  = sYYYYMMDD.substring(0, 4);
	        String sMM    = sYYYYMMDD.substring(4, 6);
	        String sDD    = sYYYYMMDD.substring(6, 8);
	        Calendar cal  = Calendar.getInstance();

	        cal.set( Integer.parseInt(sYYYY), Integer.parseInt(sMM) -1 ,Integer.parseInt(sDD)) ;

	        if     (sGBN.equals("DATE"))	cal.add(Calendar.DATE , iVALUE);
	        else if(sGBN.equals("MONTH"))	cal.add(Calendar.MONTH, iVALUE);
	        else if(sGBN.equals("YEAR"))	cal.add(Calendar.YEAR , iVALUE);

	        int iYYYY = cal.get(Calendar.YEAR);
	        int iMM   = cal.get(Calendar.MONTH)+1;
	        int iDD   = cal.get(Calendar.DATE);

	        result = DateUtil.getCalcDate(String.format("%04d%s%02d%s%02d", iYYYY,sDeli,iMM,sDeli,iDD), "DATE", 1, "-" );

		    //result = String.format("%04d%s%02d%s%02d", iYYYY,sDeli,iMM,sDeli,iDD);
	    }

	    return result;


	}

	/**
	 * Description	년월계산
	 * @param       sYYYYMM : 기준년월
	 *              sGBN    : MONTH-월, YEAR-년
	 *              iVALUE  : sGBN을 iVALUE 만큼 이동한 월
	 * @return      YYYYMM
	 */
    public static String getCalcMonth(String sYYYYMM, String sGBN, int iVALUE)
    {
        String result = "";
        String sYYYY = sYYYYMM.substring(0, 4);
        String sMM   = sYYYYMM.substring(4, 6);
        Calendar cal = Calendar.getInstance();

        cal.set( Integer.parseInt(sYYYY), Integer.parseInt(sMM) -1 ,1) ;

        if     (sGBN.equals("MONTH"))	cal.add(Calendar.MONTH, iVALUE);
        else if(sGBN.equals("YEAR"))	cal.add(Calendar.YEAR , iVALUE);

        int iYYYY = cal.get(Calendar.YEAR);
        int iMM   = cal.get(Calendar.MONTH)+1;

        result = String.format("%04d%02d", iYYYY, iMM);

        return result;
    }

    /**
	 * Description	현재시간
	 * @param
	 * @return      yyyyMMddhhmmss
	 */
	public static String getCurrentFullTimeStamp() {

		Calendar cal = Calendar.getInstance();

		return String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", cal);
	}

	/**
	 * Description	요일명
	 * @param       sYYYYMMDD : 기준일자
	 * @return      WEEK_NM
	 */
    public static String getWeekName(String sYYYYMMDD) {

    	String[] WEEK_NM = {"", "일", "월", "화", "수", "목", "금", "토"};
    	String result = "";

    	int iYYYY  = Integer.parseInt(sYYYYMMDD.substring(0, 4));
		int iMM    = Integer.parseInt(sYYYYMMDD.substring(4, 6))-1;
		int iDD    = Integer.parseInt(sYYYYMMDD.substring(6, 8));

		Calendar cal = new GregorianCalendar(iYYYY, iMM, iDD);
		int iweek = cal.get(Calendar.DAY_OF_WEEK); // 1:일 ~ 7:토

		result = WEEK_NM[iweek];

		return result;
    }

	 /**
	  * 두날짜 사이의 일수를 리턴
	  * @param fromDate yyyyMMdd 형식의 시작일
	  * @param toDate yyyyMMdd 형식의 종료일
	  * @return 두날짜 사이의 일수
	  */
	 public static int getDiffDayCount(String fromDate, String toDate) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		 try {
			  return (int) ((sdf.parse(toDate).getTime() - sdf.parse(fromDate).getTime()) / 1000 / 60 / 60 / 24);
		 } catch (Exception e) {
			  return 0;
		 }

	 }

	 /**
	  * 시작일부터 종료일까지 사이의 날짜를 배열에 담아 리턴
	  * ( 시작일과 종료일을 모두 포함한다 )
	  * @param fromDate yyyyMMdd 형식의 시작일
	  * @param toDate yyyyMMdd 형식의 종료일
	  * @return yyyyMMdd 형식의 날짜가 담긴 배열
	  */
	 public static String[] getDiffDays(String fromDate, String toDate) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		  Calendar cal = Calendar.getInstance();

		  try {
			  cal.setTime(sdf.parse(fromDate));
		  } catch (Exception e) {
		  }

		  int count = getDiffDayCount(fromDate, toDate);

		  // 시작일부터
		  cal.add(Calendar.DATE, -1);

		  // 데이터 저장
		  ArrayList<String> list = new ArrayList<String>();

		  for (int i = 0; i <= count; i++) {
			  cal.add(Calendar.DATE, 1);

			  list.add(sdf.format(cal.getTime()));
		  }

		  String[] result = new String[list.size()];

		  list.toArray(result);

		  return result;
	 }

	 /**
	  * 해당월의 종료일 구하기
	  * @param toDate yyyyMMdd 형식의 종료일
	  * @return yyyyMMdd 형식의 날짜 String
	  * @throws ParseException
	  */
	 public static String getEndDate(String yyyyMM){

		//"yyyyMMdd"형식의 데이터포맷의 틀을 만든다.
		SimpleDateFormat transeDate = new SimpleDateFormat("yyyyMM");
		//String의 날짜를 Date로 형변환
		Date tdate;
		int endDay = 0;
		String result = "";
		try {
			tdate = transeDate.parse(yyyyMM);
			//Calendar형으로 시스템날짜를 가져온다.
			Calendar cal = Calendar.getInstance();
			//Date형의 입력받은 날짜를 Calendar형으로 변환한다.
			cal.setTime(tdate);

			//cal.add(Calendar.MONTH, 1);
			//int endDay = cal.getMaximum(Calendar.DAY_OF_MONTH);

			//입력받은 날짜의 그달의 마지막일을 구한다.
			endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			result = yyyyMM + String.valueOf(endDay);

		}
		catch (ParseException e) {
			e.printStackTrace();

		}
		return result;
	 }

	 /**
	  * 해당월의 일수 구하기
	  * @param toDate yyyyMMdd 형식의 종료일
	  * @return 일수 int
	  * @throws exception
	  */
	 public static int getMonthDaysCount(String yyyyMM){

		//String의 날짜를 Date로 형변환
		String startDate = yyyyMM + "01";
		String endDate = "";
		int result = 0;
		try {
			endDate = getEndDate(yyyyMM);
			result = getDiffDays(startDate, endDate).length;
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	 }

	 /**
	  * 일자사이의 월 구하기
	  * @param toDate yyyyMMdd 형식의 시작/종료일
	  * @return List<String> yyyyMM
	  * @throws exception
	  */
	 public static List<String> getMonthList(String startDate, String endDate) {
		List<String> result = new ArrayList<>();

		int sy = Integer.parseInt(startDate.substring(0, 4));
		int sm = Integer.parseInt(startDate.substring(4, 6));
		int ey = Integer.parseInt(endDate.substring(0, 4));
		int em = Integer.parseInt(endDate.substring(4, 6));

		int period = (ey - sy) * 12 + (em - sm);
		if(period == 0)
			result.add(startDate.substring(0, 6));
		else {
			result.add(startDate.substring(0, 6));
			for(int i = 0; i < period; i++) {
				if(sm == 12) {
					sy++;
					sm = 1;
				}
				else {
					sm++;
				}
				if(sm < 10) {
					result.add(String.valueOf(sy) + "0" + String.valueOf(sm));
				}
				else {
					result.add(String.valueOf(sy) + String.valueOf(sm));
				}
			}
		}
		return result;
	 }

	 public static String minuteCalc(int value) {
		 String today = null;
		 Date date = new Date();
		 // 포맷변경 ( 년월일 시분초)
		 SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.MINUTE, value);
		 today = sdformat.format(cal.getTime());
		 return today;
	 }

	 /**
	  * String Date 포맷
	  * @param yyyyMMdd, yyyyMMddHHmmss 형식
	  * @return yyyy년MM월dd일, yyyy년MM월dd일 HH:mm:ss
	  */
	 public static String stringDateFormat(String date) {
		 if(date == null) {
			 return null;
		 }
		 String result = "";
		 if(date.length() == 14) {
			 result = date.substring(0, 4) + "년" + date.substring(4, 6) + "월" + date.substring(6, 8) + "일 " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":" + date.substring(12, 14);
		 } else if(date.length() == 8) {
			 result = date.substring(0, 4) + "년" + date.substring(4, 6) + "월" + date.substring(6, 8) + "일";
		 }
		 return result;
	 }

	 public static String stringDateFormat(String date, String charater) {
		 if(date == null) {
			 return null;
		 }
		 String result = "";
		 if(date.length() == 14) {
			 result = date.substring(0, 4) + charater + date.substring(4, 6) + charater + date.substring(6, 8) + charater + date.substring(8, 10) + ":" + date.substring(10, 12) + ":" + date.substring(12, 14);
		 } else if(date.length() == 8) {
			 result = date.substring(0,4) + charater + date.substring(4,6) + charater + date.substring(6,8);
		 }
		 return result;
	 }

}
