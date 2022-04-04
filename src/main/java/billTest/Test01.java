package billTest;

import java.util.Arrays;

// 일할계산 테스트 빅데시말 변환
public class Test01 {

    public static void main(String[] args) {

		String[] calcuData = calculationDay("20220125"
          ,"25"
          ,"PAYMM02"
          , "BSCDT02"
          , null, null, 18000,
				"N", "20220316"); // 일할계산 호출(시작일, 정기결제일, 청구대상월구분, 청구대상기준일구분)

        System.out.println("최종금액정보 = " + Arrays.toString(calcuData));

    }

    /**
   	 * <PRE>
   	 *
   	 * @Create : 2018.08.21. 오후 16:20:00
   	 * @Creator : 조성재
   	 * @Remark : 일할계산
   	 * @param :
   	 *            startDt(결제시작일) , regDd(정기결제일) , dmdDgetMmTtp(청구대상월구분 PAYMM01
   	 *            전월 PAYMM02 당월, PAYMM03 익월) , dmdTgetBaseDdTp(청구대상기준일구분 BSCDT01
   	 *            1일기준, BSCDT02 청구일기준) , stopStDt(결제 중지 시작월) , stopEdDt(결제 중지
   	 *            종료월) , amt(1달 청구금액) , nextMmYn(익월여부) , toDate(오늘날짜)
   	 * @return : String[] 0번째 청구예정일자, 1번째 청구금액, 2번째 시작일자, 3번째 종료일자, 4번째 사용일수
   	 *
   	 *         <PRE>
   	 */
   	public static String[] calculationDay(String startDt, String regDd, String dmdDgetMmTp, String dmdTgetBaseDdTp,
   			String stopStDt, String stopEdDt, int amt, String nextMmYn, String toDate) {
   		String[] result = new String[5];

   		// String toDate = DateUtil.getTodate(); //오늘날짜
   		// 익월여부 Y일시 toDate를 다음달 1일로 설정
   		if ("Y".equals(nextMmYn)) {
   			toDate = DateUtil.getCalcMonth(toDate, "MONTH", 1) + "01";
   		}

   		String reqDt = toDate.substring(0, 6); // 청구대상년월

   		String reqDate = reqDt + regDd; // 청구예정일자

   		String beforeMm = null; // 전월
   		String endDate = null;

   		int sumAmt = 0; // 계산금액

   		boolean chk = true;
   		String tempDt = reqDt;

   		String[] tempArr = null;
   		int dtCnt = 0;

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

   		// 전월
   		if ("PAYMM01".equals(dmdDgetMmTp)) {

   			int i = -1;
   			while (chk) {

   				beforeMm = DateUtil.getCalcMonth(reqDt, "MONTH", i); // 전월
   				if ("BSCDT01".equals(dmdTgetBaseDdTp)) { // 결제일구분이 매월 1일일때
   					endDate = DateUtil.getEndDate(beforeMm);
   				} else if ("BSCDT02".equals(dmdTgetBaseDdTp)) {
   					endDate = DateUtil.getCalcDate(beforeMm + regDd, "DATE", -1);
   				}

   				if (Integer.parseInt(startDt) > Integer.parseInt(endDate)
   						|| Integer.parseInt(reqDate) <= Integer.parseInt(toDate)) { // 결제시작일이
   																					// 종료일보다
   																					// 크거나
   																					// 청구예정일이
   																					// 오늘일경우
   					i++;
   					tempDt = DateUtil.getCalcMonth(tempDt, "MONTH", 1);
   					reqDate = tempDt + regDd;
   				} else {
   					chk = false;
   					tempArr = DateUtil.getDiffDays(startDt, endDate);
   					dtCnt = DateUtil.getMonthDaysCount(startDt.substring(0, 6));
   					int dateCnt = 0;
   					if (tempArr.length == 1) {
   						sumAmt = sumAmt + (int) (amt * ((float) tempArr.length / dtCnt));
   					} else {
   						for (int j = 0; j < tempArr.length; j++) {
   							String[] tmpDtArr = null;
   							if (j == 0) {
   								dateCnt++;
   								continue;
   							} else {
   								if ((tempArr[j].substring(0, 6)).equals(tempArr[j - 1].substring(0, 6))
   										&& j + 1 != tempArr.length) { // 월이 같을경우
   									dateCnt++;
   								} else if (j + 1 == tempArr.length) { // 마지막일경우
   									dateCnt++;
   									tmpDtArr = DateUtil.getDiffDays(tempArr[j].substring(0, 6) + "01",
   											DateUtil.getEndDate(tempArr[j].substring(0, 6)));
   									if (dateCnt == tmpDtArr.length) { // 한달치
   										sumAmt = amt + sumAmt;
   									} else { // 한달치가 아닐경우
   										sumAmt = sumAmt + (int) (amt * (dateCnt / (float) tmpDtArr.length));
   									}
   								} else {
   									tmpDtArr = DateUtil.getDiffDays(tempArr[j - 1].substring(0, 6) + "01",
   											DateUtil.getEndDate(tempArr[j - 1].substring(0, 6)));
   									if (dateCnt == tmpDtArr.length) { // 한달치
   										sumAmt = amt + sumAmt;
   									} else { // 한달치가 아닐경우
   										sumAmt = sumAmt + (int) (amt * (dateCnt / (float) tmpDtArr.length));
   									}
   									dateCnt = 1;
   								}
   							}

   						}
   					}

   					sumAmt = (sumAmt / 10) * 10;
   					System.out.println(sumAmt);
   					System.out.println(tempArr.length);
   					System.out.println(dmdDgetMmTp + ":" + dmdTgetBaseDdTp);
   					System.out.println("사용일자:" + Arrays.toString(tempArr));
   					System.out.println("청구예정일자:" + reqDate);
   				}
   			}

   		} // 전월 종료
   			// 당월 시작
   		else if ("PAYMM02".equals(dmdDgetMmTp)) {

   			int i = 0;
   			while (chk) {

   				beforeMm = DateUtil.getCalcMonth(reqDt, "MONTH", i);
   				if ("BSCDT01".equals(dmdTgetBaseDdTp)) {
   					endDate = DateUtil.getEndDate(beforeMm);
   				} else if ("BSCDT02".equals(dmdTgetBaseDdTp)) {
   					endDate = DateUtil.getCalcDate(beforeMm + regDd, "DATE", -1);
   				}

   				if (Integer.parseInt(startDt) > Integer.parseInt(endDate)
   						|| Integer.parseInt(reqDate) <= Integer.parseInt(toDate)) { // 결제시작일이
   																					// 종료일보다
   																					// 크다면
   					i++;
   					tempDt = DateUtil.getCalcMonth(tempDt, "MONTH", 1);
   					reqDate = tempDt + regDd;
   				} else {
   					chk = false;
   					tempArr = DateUtil.getDiffDays(startDt, endDate);
   					dtCnt = DateUtil.getMonthDaysCount(startDt.substring(0, 6));
   					int dateCnt = 0;
   					if (tempArr.length == 1) {
   						sumAmt = sumAmt + (int) (amt * ((float) tempArr.length / dtCnt));
   					} else {
   						for (int j = 0; j < tempArr.length; j++) {
   							String[] tmpDtArr = null;
   							if (j == 0) {
   								dateCnt++;
   								continue;
   							} else {
   								if ((tempArr[j].substring(0, 6)).equals(tempArr[j - 1].substring(0, 6))
   										&& j + 1 != tempArr.length) { // 월이 같을경우
   									dateCnt++;
   								} else if (j + 1 == tempArr.length) { // 마지막일경우
   									dateCnt++;
   									tmpDtArr = DateUtil.getDiffDays(tempArr[j].substring(0, 6) + "01",
   											DateUtil.getEndDate(tempArr[j].substring(0, 6)));
   									if (dateCnt == tmpDtArr.length) { // 한달치
   										sumAmt = amt + sumAmt;
   									} else { // 한달치가 아닐경우
   										sumAmt = sumAmt + (int) (amt * (dateCnt / (float) tmpDtArr.length));
   									}
   								} else {
   									tmpDtArr = DateUtil.getDiffDays(tempArr[j - 1].substring(0, 6) + "01",
   											DateUtil.getEndDate(tempArr[j - 1].substring(0, 6)));
   									if (dateCnt == tmpDtArr.length) { // 한달치
   										sumAmt = amt + sumAmt;
   									} else { // 한달치가 아닐경우
   										sumAmt = sumAmt + (int) (amt * (dateCnt / (float) tmpDtArr.length));
   									}
   									dateCnt = 1;
   								}
   							}

   						}
   					}

   					sumAmt = (sumAmt / 10) * 10;
   					System.out.println(sumAmt);
   					System.out.println(tempArr.length);
   					System.out.println(dmdDgetMmTp + ":" + dmdTgetBaseDdTp);
   					System.out.println("사용일자:" + Arrays.toString(tempArr));
   					System.out.println("청구예정일자:" + reqDate);
   				}
   			}

   		} // 당월 종료
   			// 익월 시작
   		else if ("PAYMM03".equals(dmdDgetMmTp)) {

   			int i = 1;
   			while (chk) {

   				beforeMm = DateUtil.getCalcMonth(reqDt, "MONTH", i);
   				if ("BSCDT01".equals(dmdTgetBaseDdTp)) {
   					endDate = DateUtil.getEndDate(beforeMm);
   				} else if ("BSCDT02".equals(dmdTgetBaseDdTp)) {
   					endDate = DateUtil.getCalcDate(beforeMm + regDd, "DATE", -1);
   				}

   				if (Integer.parseInt(startDt) > Integer.parseInt(endDate)
   						|| Integer.parseInt(reqDate) <= Integer.parseInt(toDate)) { // 결제시작일이
   																					// 종료일보다
   																					// 크다면
   					tempDt = DateUtil.getCalcMonth(tempDt, "MONTH", i);
   					reqDate = tempDt + regDd;
   					i++;
   				} else {
   					chk = false;
   					tempArr = DateUtil.getDiffDays(startDt, endDate);
   					dtCnt = DateUtil.getMonthDaysCount(startDt.substring(0, 6));
   					int dateCnt = 0;
   					if (tempArr.length == 1) {
   						sumAmt = sumAmt + (int) (amt * ((float) tempArr.length / dtCnt));
   					} else {
   						for (int j = 0; j < tempArr.length; j++) {
   							String[] tmpDtArr = null;
   							if (j == 0) {
   								dateCnt++;
   								continue;
   							} else {
   								if ((tempArr[j].substring(0, 6)).equals(tempArr[j - 1].substring(0, 6))
   										&& j + 1 != tempArr.length) { // 월이 같을경우
   									dateCnt++;
   								} else if (j + 1 == tempArr.length) { // 마지막일경우
   									dateCnt++;
   									tmpDtArr = DateUtil.getDiffDays(tempArr[j].substring(0, 6) + "01",
   											DateUtil.getEndDate(tempArr[j].substring(0, 6)));
   									if (dateCnt == tmpDtArr.length) { // 한달치
   										sumAmt = amt + sumAmt;
   									} else { // 한달치가 아닐경우
   										sumAmt = sumAmt + (int) (amt * (dateCnt / (float) tmpDtArr.length));
   									}
   								} else {
   									tmpDtArr = DateUtil.getDiffDays(tempArr[j - 1].substring(0, 6) + "01",
   											DateUtil.getEndDate(tempArr[j - 1].substring(0, 6)));
   									if (dateCnt == tmpDtArr.length) { // 한달치
   										sumAmt = amt + sumAmt;
   									} else { // 한달치가 아닐경우
   										sumAmt = sumAmt + (int) (amt * (dateCnt / (float) tmpDtArr.length));
   									}
   									dateCnt = 1;
   								}
   							}

   						}
   					}

   					sumAmt = (sumAmt / 10) * 10;
   					System.out.println(sumAmt);
   					System.out.println(tempArr.length);
   					System.out.println(dmdDgetMmTp + ":" + dmdTgetBaseDdTp);
   					System.out.println("사용일자:" + Arrays.toString(tempArr));
   					System.out.println("청구예정일자:" + reqDate);
   				}
   			}

   		} // 익월 종료

   		result[0] = reqDate;
   		result[1] = String.valueOf(sumAmt);
   		result[2] = startDt;
   		result[3] = endDate;
   		result[4] = String.valueOf(tempArr.length);

   		return result;
   	}

}
