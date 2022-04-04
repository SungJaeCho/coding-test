package billTest;

import java.math.BigDecimal;

public class TestTermin01 {

    public static void main(String[] args) {
//        	BigDecimal dayAmt = new BigDecimal("0"); //하루 금액
//      		BigDecimal totAmt = new BigDecimal("0"); //합
//      		BigDecimal bigRbillTgetAmt = new BigDecimal(rbillTgetAmt); //합
//
//      		if("BSCDT01".equalsIgnoreCase(dmdTgetBaseDdTp)){
//      			for(String str : oriDtArr){
//      				String month = str.substring(0, 6);
//      				if(monthMap.containsKey(month)){
//      					totAmt = totAmt.add(dayAmt);
//      				} else {
//      					BigDecimal bigDayCnt = new BigDecimal(DateUtil.getMonthDaysCount(month));
//      					dayAmt = bigRbillTgetAmt.divide(bigDayCnt, 10, BigDecimal.ROUND_FLOOR);
//      					totAmt = totAmt.add(dayAmt);
//      					monthMap.put(month, 1);
//      				}
//      			}
//      		} else {
//      			String tmpStDt = stDate; //임시 시작일자
//      			String toYyMm = tmpStDt.substring(0, 6); //년월
//      			String beforeRbillDmdDt = "0"+String.valueOf(Integer.parseInt(rbillDmdDt)-1);
//      			beforeRbillDmdDt = beforeRbillDmdDt.substring(beforeRbillDmdDt.length()-2, beforeRbillDmdDt.length());
//
//
//      			String rbillDt = toYyMm + rbillDmdDt; //정기결제일자
//      			//초기설정
//      			if(Integer.parseInt(tmpStDt) < Integer.parseInt(rbillDt)){
//      				tmpDtArr = DateUtil.getDiffDays((DateUtil.getCalcMonth(toYyMm,"MONTH",-1))+rbillDmdDt, DateUtil.getCalcDate(rbillDt,"DATE",-1)); //전월25일 ~ 당월24일까지
//      				BigDecimal bigTmpDtArrLength = new BigDecimal(tmpDtArr.length);
//
//      				dayAmt = bigRbillTgetAmt.divide(bigTmpDtArrLength, 10, BigDecimal.ROUND_FLOOR);
//      			}
//
//      			for(String str : oriDtArr){
//      				if(Integer.parseInt(str) >= Integer.parseInt(rbillDt)){
//      					toYyMm = rbillDt.substring(0,6);
//      					tmpDtArr = DateUtil.getDiffDays(rbillDt, DateUtil.getCalcMonth(toYyMm,"MONTH",1) + beforeRbillDmdDt); //전월25일 ~ 당월24일까지
//      					BigDecimal bigTmpDtArrLength = new BigDecimal(tmpDtArr.length);
//
//      					rbillDt = DateUtil.getCalcMonth(toYyMm,"MONTH",1) + rbillDmdDt;
//      					dayAmt = bigRbillTgetAmt.divide(bigTmpDtArrLength, 10, BigDecimal.ROUND_FLOOR);
//      					totAmt = totAmt.add(dayAmt);
//      				} else {
//      					totAmt = totAmt.add(dayAmt);
//      				}
//      			}
//
//      		}
//      		totAmt = totAmt.setScale(-1, BigDecimal.ROUND_UP);
//      		result = totAmt.intValue();
//      		result = (result/10) * 10;
    }

}
