package billTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 일할계산 테스트 빅데시말 변환
public class Test02 {

    public static void main(String[] args) {

            String[] calcuData = calculationDay("20220"
                ,"25"
                ,"PAYMM02"
                , "BSCDT01"
                , null, null, 18000,
      				"N", "20220316"); // 일할계산 호출(시작일, 정기결제일, 청구대상월구분, 청구대상기준일구분)

        System.out.println("최종금액정보 = " + Arrays.toString(calcuData));

    }

    /**
     * <PRE>
     *
     * @param : startDt(결제시작일) , regDd(정기결제일) , dmdDgetMmTtp(청구대상월구분 PAYMM01
     *          전월 PAYMM02 당월, PAYMM03 익월) , dmdTgetBaseDdTp(청구대상기준일구분 BSCDT01
     *          1일기준, BSCDT02 청구일기준) , stopStDt(결제 중지 시작월) , stopEdDt(결제 중지
     *          종료월) , amt(1달 청구금액) , nextMmYn(익월여부) , toDate(오늘날짜)
     * @return : String[] 0번째 청구예정일자, 1번째 청구금액, 2번째 시작일자, 3번째 종료일자, 4번째 사용일수
     *
     * <PRE>
     * @Create : 2018.08.21. 오후 16:20:00
     * @Creator : 조성재
     * @Remark : 일할계산
     */
    public static String[] calculationDay(String startDt, String regDd, String dmdDgetMmTp, String dmdTgetBaseDdTp,
                                          String stopStDt, String stopEdDt, int amt, String nextMmYn, String toDate) {
        String[] result = new String[5];

        // 익월여부 Y일시 toDate를 다음달 1일로 설정
        if ("Y".equals(nextMmYn)) {
            toDate = DateUtil.getCalcMonth(toDate, "MONTH", 1) + "01";
        }

        String reqDt = toDate.substring(0, 6); // 청구대상년월
        String reqDate = reqDt + regDd; // 청구예정일자

        String beforeMm; // 전월
        String endDate = null; // 종료일

        int sumAmt = 0; // 계산금액

        boolean chk = true;
        String tempDt = reqDt;

        String[] tmpDtArr = null;
        String[] tempArr = null;

        BigDecimal dayAmt = new BigDecimal("0"); //하루 금액
        BigDecimal totAmt = new BigDecimal("0"); //합
        BigDecimal bigRbillTgetAmt = new BigDecimal(amt); // 청구금액

        // 청구년월이 중지월에 걸려있는지 체크 걸려있다면 청구년월+2개월 후 전월의 1달치를 청구
        if (stopStDt != null && stopEdDt != null && !"".equals(stopStDt) && !"".equals(stopEdDt)) {
            if (Integer.parseInt(stopStDt) <= Integer.parseInt(reqDt)
                    && Integer.parseInt(reqDt) <= Integer.parseInt(stopEdDt)) {
                int iVal = 1;
                if (dmdDgetMmTp == "PAYMM01") {
                    iVal = 2;
                }
                reqDt = DateUtil.getCalcMonth(stopEdDt, "MONTH", iVal);
                reqDate = reqDt + regDd; // 청구일세팅
                // System.out.println("중지월로인한 청구년월변경:"+reqDate);
                result[0] = reqDate;
                result[1] = String.valueOf(amt);

                if ("BSCDT01".equals(dmdTgetBaseDdTp)) { // 1일기준일시
                    startDt = reqDate.substring(0, 6) + "01";
                    endDate = DateUtil.getEndDate(reqDt);
                    tempArr = DateUtil.getDiffDays(startDt, endDate);
                } else if ("BSCDT02".equals(dmdTgetBaseDdTp)) { // 청구일 기준일시
                    startDt = DateUtil.getCalcMonth(reqDt, "MONTH", -1) + regDd;
                    endDate = DateUtil.getCalcDate(reqDate, "DATE", -1);
                    tempArr = DateUtil.getDiffDays(startDt, endDate);
                }

                result[2] = startDt;
                result[3] = endDate;
                result[4] = String.valueOf(tempArr.length);
                // 이후 바로 청구일과 금액을 리턴
                return result;
            }
        }

        Map<String, Integer> monthMap = new HashMap<>(); // 사용기간에 해당되는 월

		int i = 0;
        switch (dmdDgetMmTp) {
            case "PAYMM01":
                i = -1;
                break;
            case "PAYMM03":
                i = 1;
                break;
        }

        //공통부분
        while (chk) {
            beforeMm = DateUtil.getCalcMonth(reqDt, "MONTH", i); // 전월
            if ("BSCDT01".equals(dmdTgetBaseDdTp)) { // 결제일구분이 매월 1일일때
                endDate = DateUtil.getEndDate(beforeMm);
            } else if ("BSCDT02".equals(dmdTgetBaseDdTp)) {
                endDate = DateUtil.getCalcDate(beforeMm + regDd, "DATE", -1);
            }

            if (Integer.parseInt(startDt) > Integer.parseInt(endDate)
                    || Integer.parseInt(reqDate) <= Integer.parseInt(toDate)) { // 결제시작일이 종료일보다 크거나 청구예정일이 오늘일경우
                i++;
                tempDt = DateUtil.getCalcMonth(tempDt, "MONTH", 1);
                reqDate = tempDt + regDd;
            } else {
                chk = false;
            }
        }

        String[] oriDtArr = DateUtil.getDiffDays(startDt, endDate); //사용일자

        if ("BSCDT01".equalsIgnoreCase(dmdTgetBaseDdTp)) {
            for (String str : oriDtArr) {
                String month = str.substring(0, 6);
                if (monthMap.containsKey(month)) {
                    totAmt = totAmt.add(dayAmt);
                } else {
                    dayAmt = bigRbillTgetAmt.divide(new BigDecimal(DateUtil.getMonthDaysCount(month)), 10, BigDecimal.ROUND_FLOOR);
                    totAmt = totAmt.add(dayAmt);
                    monthMap.put(month, 1);
                }
            }
        } else {

            //청구일자 기준으로 한달치를 정함
//            String regStartDt = null;
//            String regEndtDt = null;
//
//            for(String str : oriDtArr) {
//                if(regEndtDt == null || Integer.parseInt(regEndtDt) < Integer.parseInt(str)) {
//
//                    String toYyMm = str.substring(0, 6); //년월
//                    String beforeRbillDmdDay = "0" + (Integer.parseInt(regDd) - 1); //이전청구기준일자 ex)24
//                    beforeRbillDmdDay = beforeRbillDmdDay.substring(beforeRbillDmdDay.length() - 2, beforeRbillDmdDay.length());
//                    String dmdDt = toYyMm + regDd;
//
//                    if(Integer.parseInt(dmdDt) <= Integer.parseInt(str)) {
//                        String afterYyMm = DateUtil.getCalcMonth(toYyMm,"MONTH",1); //명월
//                        regStartDt = toYyMm + regDd;
//                        regEndtDt = afterYyMm + beforeRbillDmdDay;
//                    } else {
//                        String beforeYyMm = DateUtil.getCalcMonth(toYyMm,"MONTH",-1); //전월
//                        regStartDt = beforeYyMm + regDd;
//                        regEndtDt = toYyMm + beforeRbillDmdDay;
//                    }
//
//                    tmpDtArr = DateUtil.getDiffDays(regStartDt, regEndtDt); //전월25일 ~ 당월24일까지
//                    dayAmt = bigRbillTgetAmt.divide(new BigDecimal(tmpDtArr.length), 10, BigDecimal.ROUND_FLOOR);
//                }
//                if(Integer.parseInt(regStartDt) <= Integer.parseInt(str)
//                        && Integer.parseInt(regEndtDt) >= Integer.parseInt(str)) {
//                    totAmt = totAmt.add(dayAmt);
//                }
//            }















            String tmpStDt = startDt; //임시 시작일자
            String toYyMm = tmpStDt.substring(0, 6); //년월
            String beforeRbillDmdDt = "0" + (Integer.parseInt(regDd) - 1);
            beforeRbillDmdDt = beforeRbillDmdDt.substring(beforeRbillDmdDt.length() - 2, beforeRbillDmdDt.length());

            String rbillDt = toYyMm + regDd; //정기결제일자
            //초기설정
            if (Integer.parseInt(tmpStDt) < Integer.parseInt(rbillDt)) {
                tmpDtArr = DateUtil.getDiffDays((DateUtil.getCalcMonth(toYyMm, "MONTH", -1)) + regDd, DateUtil.getCalcDate(rbillDt, "DATE", -1)); //전월25일 ~ 당월24일까지
                BigDecimal bigTmpDtArrLength = new BigDecimal(tmpDtArr.length);
                dayAmt = bigRbillTgetAmt.divide(bigTmpDtArrLength, 10, BigDecimal.ROUND_FLOOR);
            }

            for (String str : oriDtArr) {
                if (Integer.parseInt(str) >= Integer.parseInt(rbillDt)) {
                    toYyMm = rbillDt.substring(0, 6);
                    tmpDtArr = DateUtil.getDiffDays(rbillDt, DateUtil.getCalcMonth(toYyMm, "MONTH", 1) + beforeRbillDmdDt); //전월25일 ~ 당월24일까지
                    BigDecimal bigTmpDtArrLength = new BigDecimal(tmpDtArr.length);

                    rbillDt = DateUtil.getCalcMonth(toYyMm, "MONTH", 1) + regDd;
                    dayAmt = bigRbillTgetAmt.divide(bigTmpDtArrLength, 10, BigDecimal.ROUND_FLOOR);
                    totAmt = totAmt.add(dayAmt);
                } else {
                    totAmt = totAmt.add(dayAmt);
                }
            }

        }

        totAmt = totAmt.setScale(-1, BigDecimal.ROUND_UP);
        sumAmt = totAmt.intValue();
        sumAmt = (sumAmt / 10) * 10;

        System.out.println(sumAmt);
        System.out.println(oriDtArr.length);
        System.out.println(dmdDgetMmTp + ":" + dmdTgetBaseDdTp);
        System.out.println("사용일자:" + Arrays.toString(oriDtArr));
        System.out.println("청구예정일자:" + reqDate);


        result[0] = reqDate; //청구예정일자 겸 청구대상년월
        result[1] = String.valueOf(sumAmt);
        result[2] = startDt;
        result[3] = endDate;
        result[4] = String.valueOf(oriDtArr.length);

        return result;
    }

}
