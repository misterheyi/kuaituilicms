/**
 * @title 时间工具类
 */
var TimeObjectUtil;
TimeObjectUtil = {
    /**
     * 获取当前时间毫秒数
     */
    getCurrentMsTime : function() {
        var myDate = new Date();
        return myDate.getTime();
    },
    /**
     * 毫秒转时间格式
     */
    longMsTimeConvertToDateTime : function(time) {
    	if(time==null) return "";
        var myDate = new Date(time);
        return this.formatterDateTime(myDate);
    },
    /**
     * 毫秒转日期格式(不含时间)
     */
    longMsTimeConvertToDate : function(time) {
    	if(time==null) return "";
        var myDate = new Date(time);
        return this.formatterDate(myDate);
    },
    /**
     * 毫秒转时间格式－－时间换行
     */
    longMsTimeConvertToDateTime2 : function(time) {
    	if(time==null)  return "";
        var myDate = new Date(time);
        return this.formatterDateTime2(myDate);
    },
    /**
     * 时间格式转毫秒
     */
    dateToLongMsTime : function(date) {
        var myDate = new Date(date);
        return myDate.getTime();
    },
    /**
     * 格式化日期（不含时间）
     */
    formatterDate : function(date) {
        var datetime = date.getFullYear()
                + "-"// "年"
                + ((date.getMonth() + 1) >= 10 ? (date.getMonth() + 1) : "0"
                        + (date.getMonth() + 1))
                + "-"// "月"
                + (date.getDate() < 10 ? "0" + date.getDate() : date
                        .getDate());        
        return datetime;
    },
    /**
     * 格式化日期（含时间"00:00:00"）
     */
    formatterDate2 : function(date) {
    	alert("date----"+date);
        var datetime = date.getFullYear()
                + "-"// "年"
                + ((date.getMonth() + 1) >= 10 ? (date.getMonth() + 1) : "0"
                        + (date.getMonth() + 1))
                + "-"// "月"
                + (date.getDate() < 10 ? "0" + date.getDate() : date
                        .getDate()) + " " + "00:00:00";
        return datetime;
    },
    /**
     * 格式化去日期（含时间）
     */
    formatterDateTime : function(date) {
        var datetime = date.getFullYear()
                + "-"// "年"
                + ((date.getMonth() + 1) >= 10 ? (date.getMonth() + 1) : "0"
                        + (date.getMonth() + 1))
                + "-"// "月"
                + (date.getDate() < 10 ? "0" + date.getDate() : date
                        .getDate())
                + " "
                + (date.getHours() < 10 ? "0" + date.getHours() : date
                        .getHours())
                + ":"
                + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date
                        .getMinutes())
                + ":"
                + (date.getSeconds() < 10 ? "0" + date.getSeconds() : date
                        .getSeconds());
        return datetime;
    },
    /**
     * 格式化去日期（含时间） --日期和时间换行显示
     */
    formatterDateTime2 : function(date) {
        var datetime = date.getFullYear()
                + "-"// "年"
                + ((date.getMonth() + 1) >= 10 ? (date.getMonth() + 1) : "0"
                        + (date.getMonth() + 1))
                + "-"// "月"
                + (date.getDate() < 10 ? "0" + date.getDate() : date
                        .getDate())
                + " "
                + (date.getHours() < 10 ? "0" + date.getHours() : date
                        .getHours())
                + ":"
                + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date
                        .getMinutes())
                + ":"
                + (date.getSeconds() < 10 ? "0" + date.getSeconds() : date
                        .getSeconds());
        return datetime;
    },
    /**
     * 时间比较{结束时间大于开始时间}
     */
    compareDateEndTimeGTStartTime : function(startTime, endTime) {
        return ((new Date(endTime.replace(/-/g, "/"))) > (new Date(
                startTime.replace(/-/g, "/"))));
    },
    /**
     * 验证开始时间合理性{开始时间不能小于当前时间{X}个月}
     */
    compareRightStartTime : function(month, startTime) {
        var now = formatterDayAndTime(new Date());
        var sms = new Date(startTime.replace(/-/g, "/"));
        var ems = new Date(now.replace(/-/g, "/"));
        var tDayms = month * 30 * 24 * 60 * 60 * 1000;
        var dvalue = ems - sms;
        if (dvalue > tDayms) {
            return false;
        }
        return true;
    },
    /**
     * 验证开始时间合理性{结束时间不能小于当前时间{X}个月}
     */
    compareRightEndTime : function(month, endTime) {
        var now = formatterDayAndTime(new Date());
        var sms = new Date(now.replace(/-/g, "/"));
        var ems = new Date(endTime.replace(/-/g, "/"));
        var tDayms = month * 30 * 24 * 60 * 60 * 1000;
        var dvalue = sms - ems;
        if (dvalue > tDayms) {
            return false;
        }
        return true;
    },
    /**
     * 验证开始时间合理性{结束时间与开始时间的间隔不能大于{X}个月}
     */
    compareEndTimeGTStartTime : function(month, startTime, endTime) {
        var sms = new Date(startTime.replace(/-/g, "/"));
        var ems = new Date(endTime.replace(/-/g, "/"));
        var tDayms = month * 30 * 24 * 60 * 60 * 1000;
        var dvalue = ems - sms;
        if (dvalue > tDayms) {
            return false;
        }
        return true;
    },
    /**
     * 获取最近几天[开始时间和结束时间值,时间往前推算]
     */
    getRecentDaysDateTime : function(day) {
        var daymsTime = day * 24 * 60 * 60 * 1000;
        var yesterDatsmsTime = this.getCurrentMsTime() - daymsTime;
        var startTime = this.longMsTimeConvertToDateTime(yesterDatsmsTime);
        var nowDate = this.formatterDate2(new Date());
        var obj = {
            startTime : startTime,
            endTime : nowDate
        };
        return obj;
    },
    /**
     * 获取最近几天[开始时间和结束时间值,时间往后推算]
     */
    getAfterDaysDate : function(day) {
        var daymsTime = day * 24 * 60 * 60 * 1000;
        var afterDatsmsTime = this.getCurrentMsTime() + daymsTime;
        var afterTime = this.longMsTimeConvertToDate(afterDatsmsTime);
        var startTime = this.formatterDate(new Date());
        var obj = {
            startTime : startTime,
            endTime : afterTime
        };
        return obj;
    },
    /**
     * 获取今天[开始时间和结束时间值]
     */
    getTodayDateTime : function() {
        var daymsTime = 24 * 60 * 60 * 1000;
        var tomorrowDatsmsTime = this.getCurrentMsTime() + daymsTime;
        var currentTime = this.longMsTimeConvertToDateTime(this.getCurrentMsTime());
        var termorrowTime = this.longMsTimeConvertToDateTime(tomorrowDatsmsTime);
        var obj = {
            startTime : currentTime,
            endTime : termorrowTime
        };
        return obj;
    },
    /**
     * 获取明天[开始时间和结束时间值]
     */
    getTomorrowDateTime : function() {
        var daymsTime = 24 * 60 * 60 * 1000;
        var tomorrowDatsmsTime = this.getCurrentMsTime() + daymsTime;
        var termorrowTime = this.longMsTimeConvertToDateTime(tomorrowDatsmsTime);
        var theDayAfterTomorrowDatsmsTime = this.getCurrentMsTime()+ (2 * daymsTime);
        var theDayAfterTomorrowTime = this.longMsTimeConvertToDateTime(theDayAfterTomorrowDatsmsTime);
        var obj = {
            startTime : termorrowTime,
            endTime : theDayAfterTomorrowTime
        };
        return obj;
    },
    /**
     * 获取时间间隔(天)
     */
    getDateDiff: function(startTime,endTime) {
    	var dates = parseInt(Math.abs((startTime - endTime))/(1000*60*60*24));
    	return dates;
    },
    /**
     * 获取时间间隔(小时)
     */
    getHouseDiff: function(startTime,endTime) {
    	var houses= parseInt(Math.abs((startTime - endTime))/(1000*60*60));
    	return houses;
    }
};