package billTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestStopCalc {

    public static void main(String[] args) throws Exception {
        System.out.println("중지금액결과 : " + dmdStopAmtProcess("20220125"
                ,"20220228"
                ,33000
                ,"BSCDT01"
                ,"25"));
    }

    public static int dmdStopAmtProcess(String sStopStDt, String sStopEdDt, int sRbillTgetAmt, String sDmdTgetBaseDdTp, String sRbillDmdDt)
            throws Exception {

        if (Integer.parseInt(sStopStDt) > Integer.parseInt(sStopEdDt)) {
            return 0;
        }

        int result = 0;
        String[] oriDtArr = DateUtil.getDiffDays(sStopStDt, sStopEdDt);
        String[] tmpDtArr = null;
        Map<String, Integer> monthMap = new HashMap<>();

        BigDecimal dayAmt = new BigDecimal("0"); //일일금액
        BigDecimal totalAmt = new BigDecimal("0"); //합계금액
        BigDecimal bigRbillTgetAmt = new BigDecimal(sRbillTgetAmt); //정기청구금액

        //1일부터 말일
        if ("BSCDT01".equalsIgnoreCase(sDmdTgetBaseDdTp)) {
            for (String str : oriDtArr) {
                String month = str.substring(0, 6);
                if (monthMap.containsKey(month)) {
                    totalAmt = totalAmt.add(dayAmt);
                } else {
                    BigDecimal dayCnt = new BigDecimal(DateUtil.getMonthDaysCount(month));
                    dayAmt = bigRbillTgetAmt.divide(dayCnt, 10, BigDecimal.ROUND_FLOOR);
                    totalAmt = totalAmt.add(dayAmt);
                    monthMap.put(month, 1);
                }
            }
        }
        //특정일부터 특정일-1일
        else {
            String tmpStDt = sStopStDt; //임시 시작일자
            String toYyMm = tmpStDt.substring(0, 6); //년월
            String beforeRbillDmdDt = "0" + (Integer.parseInt(sRbillDmdDt) - 1);
            beforeRbillDmdDt = beforeRbillDmdDt.substring(beforeRbillDmdDt.length() - 2, beforeRbillDmdDt.length());


            String rbillDt = toYyMm + sRbillDmdDt; //정기결제일자
            //초기설정
            if (Integer.parseInt(tmpStDt) < Integer.parseInt(rbillDt)) {
                tmpDtArr = DateUtil.getDiffDays((DateUtil.getCalcMonth(toYyMm, "MONTH", -1)) + sRbillDmdDt, DateUtil.getCalcDate(rbillDt, "DATE", -1)); //전월25일 ~ 당월24일까지
                BigDecimal bigTmpDtArrLength = new BigDecimal(tmpDtArr.length);

                dayAmt = bigRbillTgetAmt.divide(bigTmpDtArrLength, 10, BigDecimal.ROUND_FLOOR);
            }

            for (String str : oriDtArr) {
                if (Integer.parseInt(str) >= Integer.parseInt(rbillDt)) {
                    toYyMm = rbillDt.substring(0, 6);
                    tmpDtArr = DateUtil.getDiffDays(rbillDt, DateUtil.getCalcMonth(toYyMm, "MONTH", 1) + beforeRbillDmdDt); //전월25일 ~ 당월24일까지
                    BigDecimal bigTmpDtArrLength = new BigDecimal(tmpDtArr.length);

                    rbillDt = DateUtil.getCalcMonth(toYyMm, "MONTH", 1) + sRbillDmdDt;
                    dayAmt = bigRbillTgetAmt.divide(bigTmpDtArrLength, 10, BigDecimal.ROUND_FLOOR);
                    totalAmt = totalAmt.add(dayAmt);
                } else {
                    totalAmt = totalAmt.add(dayAmt);
                }
            }

        }
        totalAmt = totalAmt.setScale(-1, BigDecimal.ROUND_UP);
        result = totalAmt.intValue();
        result = (result / 10) * 10;

        return result;
    }

}
