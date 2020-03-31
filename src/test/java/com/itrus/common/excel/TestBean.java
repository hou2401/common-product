package com.itrus.common.excel;

import com.itrus.common.utils.excel.ExcelCell;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author hzq
 * @since 2020/3/30
 */
public class TestBean {
    @ExcelCell(index = 0)
    @ExcelCell.Valid(allowNull = false)
    private String account;
    @ExcelCell(index = 1)
    @ExcelCell.Valid(allowNull = false)
    private String name;
    @ExcelCell(index = 2)
    @ExcelCell.Valid(allowNull = false)
    private String phone;
    @ExcelCell(index = 3)
    private Date registerTime;
    @ExcelCell(index = 4)
    @ExcelCell.Valid(allowNull = false)
    private Integer status;
    @ExcelCell(index = 5)
    @ExcelCell.Valid(allowNull = false)
    private Integer totalCount;
    @ExcelCell(index = 6)
    @ExcelCell.Valid(allowNull = false)
    private Integer leaveCount;
    @ExcelCell.Valid(allowNull = false)
    @ExcelCell(index = 7)
    private Integer usedCount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(Integer leaveCount) {
        this.leaveCount = leaveCount;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public String toString(){
        return "account = " + account + ","
                +"name = " + name + ","
                +"phone = " + phone + ","
                +"registerTime = " + registerTime + ","
                +"status = " + status + ","
                +"totalCount = " + totalCount + ","
                +"leaveCount = " + leaveCount + ","
                +"usedCount = " + usedCount;
    }
}
