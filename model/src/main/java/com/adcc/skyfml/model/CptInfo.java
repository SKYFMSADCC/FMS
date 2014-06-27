package com.adcc.skyfml.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * <P>FileName: CptInfo.java
 * @author GuoXY
 * <P>CreateTime: 2014-06-06
 * <P>Description: 航路点基础信息表对象
 * <P>Version: v1.0
 * <P>History:
 */
@Entity
@Table(name="CPT_INFO")
public class CptInfo implements Serializable {
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
    // 部分航空公司飞行计划没有此数据，所以，不加非空约束
    // 飞行计划ID
    @Column(name = "plan_id", length=10)
    private String planId;
    // 航路点名称
    @Column(name = "cpt_name", nullable = false, length=20)
    private String cptName;
    // percision和scale约束仅对decimal类型字段有效，而我们的表定义的是numeric类型..
    // 经度
    @Column(nullable = false)
    private float lon;
    // 纬度
    @Column(nullable = false)
    private float lat;
    // 起飞机场
    @Column(nullable = false, length=10)
    private String dep;
    // 落地机场
    @Column(nullable = false, length=10)
    private String arr;
    // 计划生成时间
    // column实现了名称之间的转换，并添加约束，超过则报出异常
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "plan_date", nullable = false)
    private Date planDate;
    // 航空公司
    @Column(nullable = false, length=10)
    private String airlines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String toString() {
        return flightId + " @ " + aircraftId + " @ " + planId + " @ " + cptName + " @ " + lon + " @ "
                + lat + " @ " + dep + " @ " + arr + " @ " + planDate + " @ " + airlines + " 。" ;
    }
}
