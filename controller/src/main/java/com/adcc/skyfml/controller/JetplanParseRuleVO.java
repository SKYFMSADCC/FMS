package com.adcc.skyfml.service;

import java.util.List;


/**
 *
 * <P>FileName: CptInfoVO.java
 * @author GuoXY
 * <P>CreateTime: 2014-06-06
 * <P>Description: 航路点基础信息表对象
 * <P>Version: v1.0
 * <P>History: 
 * @param <T>
 */
public class JetplanParseRuleVO {
    // 航班号获取对应的节点路径
    private String flightIdPath;
    // 航班号获取对应属性名
    private String flightIdAttribute;

    // 机尾号获取对应的节点路径
    private String aircraftIdPath;
    // 机尾号获取对应属性名
    private String aircraftIdAttribute;

    // 飞行计划ID获取对应的节点路径
    private String planIdPath;
    // 飞行计划ID获取对应属性名
    private String planIdAttribute;


    // 计划生成时间获取对应的节点路径
    private String planDatePath;
    // 计划生成时间获取对应属性名
    private String planDateAttribute;


    // 起飞机场获取对应的节点路径
    private String depPath;
    // 起飞机场获取对应的属性名
    private String depAttribute;

    // 落地机场获取对应的节点路径
    private String arrPath;
    // 落地机场获取对应的属性名
    private String arrAttribute;



    // 航路点位置信息 获取对应的节点路径
    private String cptPosPath;
    // 航路点位置信息 获取对应的属性名
    private String cptPosAttribute;

    // 经度获取对应的节点路径
    private String lonPath;
    // 经度获取对应的属性名
    private String lonAttribute;

    // 纬度获取对应的节点路径
    private String latPath;
    // 纬度获取对应的属性名
    private String latAttribute;


    // 航路点风温信息 获取对应的节点路径
    private String cptWindTempPath;
    // 航路点风温信息 获取对应的属性名
    private String cptWindTempAttribute;

    // 风向获取对应的节点路径
    private String windDirPath;
    // 风向获取对应的属性名
    private String windDirAttribute;

    // 风速获取对应的节点路径
    private String windVelPath;
    // 风速获取对应的属性名
    private String windVelAttribute;

    // 风温获取对应的节点路径
    private String windTepPath;
    // 风温获取对应的属性名
    private String windTepAttribute;

    // 高度层获取对应的节点路径
    private String altPath;
    // 高度层获取对应的属性名
    private String altAttribute;


    public String getFlightIdPath() {
        return flightIdPath;
    }
    public void setFlightIdPath(String flightIdPath) {
        this.flightIdPath = flightIdPath;
    }
    public String getFlightIdAttribute() {
        return flightIdAttribute;
    }
    public void setFlightIdAttribute(String flightIdAttribute) {
        this.flightIdAttribute = flightIdAttribute;
    }
    public String getAircraftIdPath() {
        return aircraftIdPath;
    }
    public void setAircraftIdPath(String aircraftIdPath) {
        this.aircraftIdPath = aircraftIdPath;
    }
    public String getAircraftIdAttribute() {
        return aircraftIdAttribute;
    }
    public void setAircraftIdAttribute(String aircraftIdAttribute) {
        this.aircraftIdAttribute = aircraftIdAttribute;
    }
    public String getPlanIdPath() {
        return planIdPath;
    }
    public void setPlanIdPath(String planIdPath) {
        this.planIdPath = planIdPath;
    }
    public String getPlanIdAttribute() {
        return planIdAttribute;
    }
    public void setPlanIdAttribute(String planIdAttribute) {
        this.planIdAttribute = planIdAttribute;
    }
    public String getPlanDatePath() {
        return planDatePath;
    }
    public void setPlanDatePath(String planDatePath) {
        this.planDatePath = planDatePath;
    }
    public String getPlanDateAttribute() {
        return planDateAttribute;
    }
    public void setPlanDateAttribute(String planDateAttribute) {
        this.planDateAttribute = planDateAttribute;
    }
    public String getCptPosPath() {
        return cptPosPath;
    }
    public void setCptPosPath(String cptPosPath) {
        this.cptPosPath = cptPosPath;
    }
    public String getCptPosAttribute() {
        return cptPosAttribute;
    }
    public void setCptPosAttribute(String cptPosAttribute) {
        this.cptPosAttribute = cptPosAttribute;
    }
    public String getLonPath() {
        return lonPath;
    }
    public void setLonPath(String lonPath) {
        this.lonPath = lonPath;
    }
    public String getLonAttribute() {
        return lonAttribute;
    }
    public void setLonAttribute(String lonAttribute) {
        this.lonAttribute = lonAttribute;
    }
    public String getLatPath() {
        return latPath;
    }
    public void setLatPath(String latPath) {
        this.latPath = latPath;
    }
    public String getLatAttribute() {
        return latAttribute;
    }
    public void setLatAttribute(String latAttribute) {
        this.latAttribute = latAttribute;
    }
    public String getDepPath() {
        return depPath;
    }
    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }
    public String getDepAttribute() {
        return depAttribute;
    }
    public void setDepAttribute(String depAttribute) {
        this.depAttribute = depAttribute;
    }
    public String getArrPath() {
        return arrPath;
    }
    public void setArrPath(String arrPath) {
        this.arrPath = arrPath;
    }
    public String getArrAttribute() {
        return arrAttribute;
    }
    public void setArrAttribute(String arrAttribute) {
        this.arrAttribute = arrAttribute;
    }
    public String getCptWindTempPath() {
        return cptWindTempPath;
    }
    public void setCptWindTempPath(String cptWindTempPath) {
        this.cptWindTempPath = cptWindTempPath;
    }
    public String getCptWindTempAttribute() {
        return cptWindTempAttribute;
    }
    public void setCptWindTempAttribute(String cptWindTempAttribute) {
        this.cptWindTempAttribute = cptWindTempAttribute;
    }
    public String getWindDirPath() {
        return windDirPath;
    }
    public void setWindDirPath(String windDirPath) {
        this.windDirPath = windDirPath;
    }
    public String getWindDirAttribute() {
        return windDirAttribute;
    }
    public void setWindDirAttribute(String windDirAttribute) {
        this.windDirAttribute = windDirAttribute;
    }
    public String getWindVelPath() {
        return windVelPath;
    }
    public void setWindVelPath(String windVelPath) {
        this.windVelPath = windVelPath;
    }
    public String getWindVelAttribute() {
        return windVelAttribute;
    }
    public void setWindVelAttribute(String windVelAttribute) {
        this.windVelAttribute = windVelAttribute;
    }
    public String getWindTepPath() {
        return windTepPath;
    }
    public void setWindTepPath(String windTepPath) {
        this.windTepPath = windTepPath;
    }
    public String getWindTepAttribute() {
        return windTepAttribute;
    }
    public void setWindTepAttribute(String windTepAttribute) {
        this.windTepAttribute = windTepAttribute;
    }
    public String getAltPath() {
        return altPath;
    }
    public void setAltPath(String altPath) {
        this.altPath = altPath;
    }
    public String getAltAttribute() {
        return altAttribute;
    }
    public void setAltAttribute(String altAttribute) {
        this.altAttribute = altAttribute;
    }

}
