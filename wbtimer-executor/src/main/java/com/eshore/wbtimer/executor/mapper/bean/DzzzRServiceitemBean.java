package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * ����Ϊ���ݿ��Ӧ��javabean���룬ͳһ���Զ��������ɣ��벻Ҫ�˹��޸� 
 *
 * @author hwe
 * @version
 * 
 */
@TableName("DZZZ_R_SERVICEITEM")
public class DzzzRServiceitemBean
{
	@TableId(value = "ID",type = IdType.AUTO)
	private Long id;
	private String serviceCode;    // �������
	private String dzzzName;       // ֤������
	private String dzzzCode;       // ֤�ձ���
	private Long status;           // ״̬
	private Date createDate;       // ����ʱ��
	private String remark;         // ��ע


	public Long getId() {
	    return id;
	}
	
	public void setId(Long id) {
	    this.id = id;
	}

	public String getServiceCode() {
	    return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
	    this.serviceCode = serviceCode;
	}

	public String getDzzzName() {
	    return dzzzName;
	}
	
	public void setDzzzName(String dzzzName) {
	    this.dzzzName = dzzzName;
	}

	public String getDzzzCode() {
	    return dzzzCode;
	}
	
	public void setDzzzCode(String dzzzCode) {
	    this.dzzzCode = dzzzCode;
	}

	public Long getStatus() {
	    return status;
	}
	
	public void setStatus(Long status) {
	    this.status = status;
	}

	public Date getCreateDate() {
	    return createDate;
	}
	
	public void setCreateDate(Date createDate) {
	    this.createDate = createDate;
	}

	public String getRemark() {
	    return remark;
	}
	
	public void setRemark(String remark) {
	    this.remark = remark;
	}

}

