package com.test;

import com.alibaba.fastjson.JSON;

/***/
public class bean {
    private String style = "onlySwap";
    private String showStyle = "table";
    private String step  ="8";
    private boolean isShowDate = true;
    private String swapTime = "20";
    private String animateType= "down";
    private String showTime = "5";
    private String callTimes ="1";
    private String callRate ="-1";
    private String footerMsg = "请按秩序就诊，过号病人到医生处重新排队候诊。";
    private boolean isShowPatientsGH  = true;
    private boolean networkCompatibleMode = true;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getShowStyle() {
        return showStyle;
    }

    public void setShowStyle(String showStyle) {
        this.showStyle = showStyle;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public boolean isShowDate() {
        return isShowDate;
    }

    public void setShowDate(boolean showDate) {
        isShowDate = showDate;
    }

    public String getSwapTime() {
        return swapTime;
    }

    public void setSwapTime(String swapTime) {
        this.swapTime = swapTime;
    }

    public String getAnimateType() {
        return animateType;
    }

    public void setAnimateType(String animateType) {
        this.animateType = animateType;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(String callTimes) {
        this.callTimes = callTimes;
    }

    public String getCallRate() {
        return callRate;
    }

    public void setCallRate(String callRate) {
        this.callRate = callRate;
    }

    public String getFooterMsg() {
        return footerMsg;
    }

    public void setFooterMsg(String footerMsg) {
        this.footerMsg = footerMsg;
    }

    public boolean isShowPatientsGH() {
        return isShowPatientsGH;
    }

    public void setShowPatientsGH(boolean showPatientsGH) {
        isShowPatientsGH = showPatientsGH;
    }

    public boolean isNetworkCompatibleMode() {
        return networkCompatibleMode;
    }

    public void setNetworkCompatibleMode(boolean networkCompatibleMode) {
        this.networkCompatibleMode = networkCompatibleMode;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new bean()));
    }
}
