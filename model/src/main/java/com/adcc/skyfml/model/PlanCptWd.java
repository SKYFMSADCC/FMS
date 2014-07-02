package com.adcc.skyfml.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * <P>FileName: PlanCptWdVO.java
 * @author GuoXY
 * <P>CreateTime: 2014-06-06
 * <P>Description: 飞行计划航路点风温信息表
 * <P>Version: v1.0
 * <P>History:
 */
@Entity
@Table(name="PLAN_CPT_WD")
public class PlanCptWd implements Serializable {

    // 自增长主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // 航班号
    @Column(name = "flight_id", nullable = false, length=10)
    private String flightId;
    // 机尾号
    @Column(name = "aircraft_id", nullable = false, length=10)
    private String aircraftId;

    // 飞行计划ID
    @Column(name = "plan_id", length=10)
    private String planId;
    // 航路点名称
    @Column(name = "cpt_name", nullable = false, length=20)
    private String cptName;
    // 风向
    @Column(name = "wind_dir", nullable = false)
    private float windDir;
    // 风速
    @Column(name = "wind_vel", nullable = false)
    private float windVel;
    // 风温
    @Column(name = "wind_tep", nullable = false)
    private float windTep;
    // 计划生成时间
    // column实现了名称之间的转换，并添加约束，超过则报出异常
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "plan_date", nullable = false)
    private Date planDate;
    // 高度层
    @Column(nullable = false)
    private float alt;
    // 航空公司
    @Column(nullable = false, length=10)
    private String airlines;

    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    public String getAircraftId() {
        return aircraftId;
    }
    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public String getCptName() {
        return cptName;
    }
    public void setCptName(String cptName) {
        this.cptName = cptName;
    }
    public float getWindDir() {
        return windDir;
    }
    public void setWindDir(float windDir) {
        this.windDir = windDir;
    }
    public float getWindVel() {
        return windVel;
    }
    public void setWindVel(float windVel) {
        this.windVel = windVel;
    }
    public float getWindTep() {
        return windTep;
    }
    public void setWindTep(float windTep) {
        this.windTep = windTep;
    }
    public float getAlt() {
        return alt;
    }
    public void setAlt(float alt) {
        this.alt = alt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String toString() {
        return flightId + " @ " + aircraftId + " @ " + planId + " @ " + cptName + " @ "
                + windVel + " @ " + windTep + " @ " +
                alt + " @ " + airlines + " @ " + planDate + " @ " + windDir + " 。" ;
    }
}
