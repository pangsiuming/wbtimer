package com.eshore.wbtimer.executor.mapper.bean;

import java.util.Date;

/**
 * ����Ϊ���ݿ��Ӧ��javabean���룬ͳһ���Զ��������ɣ��벻Ҫ�˹��޸� 
 *
 * @author hwe
 * @version
 * 
 */
public class ServiceItemBean
{
	private Long serviceItemId;              // ��������
	private String serviceCode;              // �������
	private String name;                     // ��������
	private String serviceItemType;          // �������ͣ�����ֵ����
	private String authorityLevel;           // ���� Authority_Level ���롣
	private String status;                   // ����״̬������ֵ����
	private String version;                  // ����汾
	private String adminOrg;                 // ���ܲ���
	private String serviceAgent;             // �������壨���������
	private String serviceAgentType;         // �����������ͣ�����ֵ����
	private String serviceObject;            // �������
	private String serviceObjectType;        // ����������ͣ�����ֵ����
	private String legalBasis;               // ��������
	private String conditions;               // ��������
	private String charge;                   // �շ����ݺͱ�׼
	private String legalPeriod;              // ��������
	private String promisedPeriod;           // ��ŵ����
	private String submitDocuments;          // �ύ����
	private String forms;                    // ҵ����
	private String onlineProcess;            // ���ϰ�������
	private String windowProcess;            // ���ڰ�������
	private String powerProcess;             // Ȩ����������
	private String complaintPhone;           // �ල�绰
	private String sortOrder;                // ˳��š���������
	private String faq;                      // ��������
	private String onlineServiceUrl;         // ������������ַ
	private String consultServiceUrl;        // ҵ����ѯ������ַ
	private String resultQueryUrl;           // �������������ַ
	private String progressQueryUrl;         // ���Ȳ�ѯ������ַ
	private String payOnline;                // �Ƿ����Ͻɷ� ���μ�6 ProvideServiceType
	private String authentication;           // �Ƿ���Ҫ�����֤
	private String onlineDone;               // �Ƿ�����ȫ�̰��
	private String invest;                   // �Ƿ�Ͷ����������
	private String foreign;                  // �Ƿ���������
	private String provideGuide;             // �ṩ����ָ�Ϸ������������ ProvideServiceType ��
	private String provideForms;             // �ṩ������ط����飬���� ProvideServiceType ��
	private String provideConsult;           // �ṩ������ѯ������������� ProvideServiceType ��
	private String provideApply;             // �ṩ������������������� ProvideServiceType ��
	private String provideResult;            // �ṩ�������������������� ProvideServiceType ��
	private String provideProcess;           // �ṩ���Ȳ�ѯ������������� ProvideServiceType ��
	private String provideRate;              // �ṩ�Ǽ����۷������������ ProvideServiceType ��
	private String transportCount;           // ���ֳ�����������ֵ���� ���� TransportCount ���롣
	private String timeCost;                 // ����ʱ�䡣����������Ҫ��ʱ
	private String declareServiceLevel;      // �걨���ϰ�����ȣ�����ֵ���� ���� ServiceLevel ���롣
	private String approveServiceLevel;      // ��׼���ϰ�����ȣ�����ֵ�������� ServiceLevel ���롣
	private Date approveTime;                // ��׼ʱ��
	private String description;              // ��ע˵��
	private String extendProps;              // ��չ����
	private String creator;                  // ������
	private Date creationTime;               // ����ʱ��
	private String lastModificator;          // ����޸���
	private Date lastModificationTime;       // ����޸�ʱ��
	private String cityId;                   // ��������ʶ
	private String toExState;                //д���м��״̬
	private Date toExTime;                   //д���м��ʱ��
	private String applyType;                // ��ѡ����ѡֵ���Ÿ���        1�����  2��ŵ�� 3����� 4ת��� 5����� 6ת����
    private String serviceAgentCode;         //�����������
	private String legalPeriodType;          //���������������ͣ�1�ޣ�2�����գ�3��Ȼ��
	private String legalPeriodDay;           //����������������,����
	private String promisedPeriodType;       //��ŵ�������ͣ�1�ޣ�2�����գ�3��Ȼ��
	private String promisedPeriodDay;        //��ŵ������������,����
	private String feeType;                 //�Ƿ��շѣ�FEE_TYPE 1�� 0��
	private String havaFaq;                 //�Ƿ񳣼������� 1�� 0��
	private String timeCostGs;              //����ʱ���ʽ��#��������ҳ���޶���ʽʶ��
	private String realAdminOrg;            //ʵ�����ܻ�������������ã�
	private String fromServiceCode;         //�·���Դ�������
	
	private String orgName;
	private String catalogName;
	private String statusText;
	private String counts;
	private String cascadeCatalogCode;
	private String auditIsFinish ;			//ѭ������������˱��ص�ǰ�����Ƿ�����ս�
	
	private Long sysId;              		//���õ�ҵ��ϵͳ����ID
	private Long auditServiceId ;              		//��˲�ͨ��ʱ������ID������׷��չʾ������
	private String extend1;
	
	//ͳ�Ʒ�������
	private String param1;					
	private String param2;                  
	private String param3;
	private String param4;
	//�Ƿ��פ�������������
	private String sfjzfwdt;
	//��������� :���������: 1��������2�뽻����3ȫ����
	private String exchangeType;
	public String windowProcessPic;//��������ͼ
	public String onlineProcessPic;//��������ͼ
	

	private String mailType;//������ʽ
	private String lXRAddress;//��ϵ�˵�ַ
	private String lRXPostCode;//��������
	private String lXRXM;//�ռ�������
	private String lXRDHHM;//�ռ��˵绰����
	private String cLFS;//����ʽ
	private Date updateTime;//��������
	private String adminORGNAME;//������������
	private String admin_ORG; //�������ű���
	
	private String fjraddress;  //�����˵�ַ
	private String fjrxm;   //����������
	private String fjrdhhm;  //�����˵绰����
	private String ydyxm; //�ʵ�Ա����
	private String ydydh; //�ʵ�Ա�绰
	
	private String provideAPPYY;//APPԤԼ���
	private String appYYURL;//APPԤԼURL
	private String provideAPPSB;//APP������
	private String appSBURL;//APP���URL
	private String isPublic; //�Ƿ񷢲���������1�� 0��
	private byte[] appYyQrcode;//�ƶ�ԤԼ��ά��
	private byte[] appSbQrcode; //�ƶ�����ά��
	private String yyQrcodeStr;
	private String sbQrcodeStr;
	

	public String getMailType() {
		return mailType;
	}


	public void setMailType(String mailType) {
		this.mailType = mailType;
	}


	public String getlXRAddress() {
		return lXRAddress;
	}


	public void setlXRAddress(String lXRAddress) {
		this.lXRAddress = lXRAddress;
	}


	public String getlRXPostCode() {
		return lRXPostCode;
	}


	public void setlRXPostCode(String lRXPostCode) {
		this.lRXPostCode = lRXPostCode;
	}


	public String getlXRXM() {
		return lXRXM;
	}


	public void setlXRXM(String lXRXM) {
		this.lXRXM = lXRXM;
	}


	public String getlXRDHHM() {
		return lXRDHHM;
	}


	public void setlXRDHHM(String lXRDHHM) {
		this.lXRDHHM = lXRDHHM;
	}


	public String getcLFS() {
		return cLFS;
	}


	public void setcLFS(String cLFS) {
		this.cLFS = cLFS;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getAdminORGNAME() {
		return adminORGNAME;
	}


	public void setAdminORGNAME(String adminORGNAME) {
		this.adminORGNAME = adminORGNAME;
	}


	public String getAdmin_ORG() {
		return admin_ORG;
	}


	public void setAdmin_ORG(String admin_ORG) {
		this.admin_ORG = admin_ORG;
	}

	public String getWindowProcessPic() {
		return windowProcessPic;
	}

	public void setWindowProcessPic(String windowProcessPic) {
		this.windowProcessPic = windowProcessPic;
	}

	public String getOnlineProcessPic() {
		return onlineProcessPic;
	}

	public void setOnlineProcessPic(String onlineProcessPic) {
		this.onlineProcessPic = onlineProcessPic;
	}

	public String getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getSfjzfwdt() {
		return sfjzfwdt;
	}

	public void setSfjzfwdt(String sfjzfwdt) {
		this.sfjzfwdt = sfjzfwdt;
	}

	public Long getServiceItemId() {
	    return serviceItemId;
	}
	
	public void setServiceItemId(Long serviceItemId) {
	    this.serviceItemId = serviceItemId;
	}

	public String getServiceCode() {
	    return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
	    this.serviceCode = serviceCode;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}

	public String getServiceItemType() {
	    return serviceItemType;
	}
	
	public void setServiceItemType(String serviceItemType) {
	    this.serviceItemType = serviceItemType;
	}

	public String getAuthorityLevel() {
	    return authorityLevel;
	}
	
	public void setAuthorityLevel(String authorityLevel) {
	    this.authorityLevel = authorityLevel;
	}

	public String getStatus() {
	    return status;
	}
	
	public void setStatus(String status) {
	    this.status = status;
	}

	public String getVersion() {
	    return version;
	}
	
	public void setVersion(String version) {
	    this.version = version;
	}

	public String getAdminOrg() {
	    return adminOrg;
	}
	
	public void setAdminOrg(String adminOrg) {
	    this.adminOrg = adminOrg;
	}

	public String getServiceAgent() {
	    return serviceAgent;
	}
	
	public void setServiceAgent(String serviceAgent) {
	    this.serviceAgent = serviceAgent;
	}

	public String getServiceAgentType() {
	    return serviceAgentType;
	}
	
	public void setServiceAgentType(String serviceAgentType) {
	    this.serviceAgentType = serviceAgentType;
	}

	public String getServiceObject() {
	    return serviceObject;
	}
	
	public void setServiceObject(String serviceObject) {
	    this.serviceObject = serviceObject;
	}

	public String getServiceObjectType() {
	    return serviceObjectType;
	}
	
	public void setServiceObjectType(String serviceObjectType) {
	    this.serviceObjectType = serviceObjectType;
	}

	public String getLegalBasis() {
	    return legalBasis;
	}
	
	public void setLegalBasis(String legalBasis) {
	    this.legalBasis = legalBasis;
	}

	public String getConditions() {
	    return conditions;
	}
	
	public void setConditions(String conditions) {
	    this.conditions = conditions;
	}

	public String getCharge() {
	    return charge;
	}
	
	public void setCharge(String charge) {
	    this.charge = charge;
	}

	public String getLegalPeriod() {
	    return legalPeriod;
	}
	
	public void setLegalPeriod(String legalPeriod) {
	    this.legalPeriod = legalPeriod;
	}

	public String getPromisedPeriod() {
	    return promisedPeriod;
	}
	
	public void setPromisedPeriod(String promisedPeriod) {
	    this.promisedPeriod = promisedPeriod;
	}

	public String getSubmitDocuments() {
	    return submitDocuments;
	}
	
	public void setSubmitDocuments(String submitDocuments) {
	    this.submitDocuments = submitDocuments;
	}

	public String getForms() {
	    return forms;
	}
	
	public void setForms(String forms) {
	    this.forms = forms;
	}

	public String getOnlineProcess() {
	    return onlineProcess;
	}
	
	public void setOnlineProcess(String onlineProcess) {
	    this.onlineProcess = onlineProcess;
	}

	public String getWindowProcess() {
	    return windowProcess;
	}
	
	public void setWindowProcess(String windowProcess) {
	    this.windowProcess = windowProcess;
	}

	public String getPowerProcess() {
	    return powerProcess;
	}
	
	public void setPowerProcess(String powerProcess) {
	    this.powerProcess = powerProcess;
	}

	public String getComplaintPhone() {
	    return complaintPhone;
	}
	
	public void setComplaintPhone(String complaintPhone) {
	    this.complaintPhone = complaintPhone;
	}

	public String getSortOrder() {
	    return sortOrder;
	}
	
	public void setSortOrder(String sortOrder) {
	    this.sortOrder = sortOrder;
	}

	public String getFaq() {
	    return faq;
	}
	
	public void setFaq(String faq) {
	    this.faq = faq;
	}

	public String getOnlineServiceUrl() {
	    return onlineServiceUrl;
	}
	
	public void setOnlineServiceUrl(String onlineServiceUrl) {
	    this.onlineServiceUrl = onlineServiceUrl;
	}

	public String getConsultServiceUrl() {
	    return consultServiceUrl;
	}
	
	public void setConsultServiceUrl(String consultServiceUrl) {
	    this.consultServiceUrl = consultServiceUrl;
	}

	public String getResultQueryUrl() {
	    return resultQueryUrl;
	}
	
	public void setResultQueryUrl(String resultQueryUrl) {
	    this.resultQueryUrl = resultQueryUrl;
	}

	public String getProgressQueryUrl() {
	    return progressQueryUrl;
	}
	
	public void setProgressQueryUrl(String progressQueryUrl) {
	    this.progressQueryUrl = progressQueryUrl;
	}

	public String getPayOnline() {
	    return payOnline;
	}
	
	public void setPayOnline(String payOnline) {
	    this.payOnline = payOnline;
	}

	public String getAuthentication() {
	    return authentication;
	}
	
	public void setAuthentication(String authentication) {
	    this.authentication = authentication;
	}

	public String getOnlineDone() {
	    return onlineDone;
	}
	
	public void setOnlineDone(String onlineDone) {
	    this.onlineDone = onlineDone;
	}

	public String getInvest() {
	    return invest;
	}
	
	public void setInvest(String invest) {
	    this.invest = invest;
	}

	public String getForeign() {
	    return foreign;
	}
	
	public void setForeign(String foreign) {
	    this.foreign = foreign;
	}

	public String getProvideGuide() {
	    return provideGuide;
	}
	
	public void setProvideGuide(String provideGuide) {
	    this.provideGuide = provideGuide;
	}

	public String getProvideForms() {
	    return provideForms;
	}
	
	public void setProvideForms(String provideForms) {
	    this.provideForms = provideForms;
	}

	public String getProvideConsult() {
	    return provideConsult;
	}
	
	public void setProvideConsult(String provideConsult) {
	    this.provideConsult = provideConsult;
	}

	public String getProvideApply() {
	    return provideApply;
	}
	
	public void setProvideApply(String provideApply) {
	    this.provideApply = provideApply;
	}

	public String getProvideResult() {
	    return provideResult;
	}
	
	public void setProvideResult(String provideResult) {
	    this.provideResult = provideResult;
	}

	public String getProvideProcess() {
	    return provideProcess;
	}
	
	public void setProvideProcess(String provideProcess) {
	    this.provideProcess = provideProcess;
	}

	public String getProvideRate() {
	    return provideRate;
	}
	
	public void setProvideRate(String provideRate) {
	    this.provideRate = provideRate;
	}

	public String getTransportCount() {
	    return transportCount;
	}
	
	public void setTransportCount(String transportCount) {
	    this.transportCount = transportCount;
	}

	public String getTimeCost() {
	    return timeCost;
	}
	
	public void setTimeCost(String timeCost) {
	    this.timeCost = timeCost;
	}

	public String getDeclareServiceLevel() {
	    return declareServiceLevel;
	}
	
	public void setDeclareServiceLevel(String declareServiceLevel) {
	    this.declareServiceLevel = declareServiceLevel;
	}

	public String getApproveServiceLevel() {
	    return approveServiceLevel;
	}
	
	public void setApproveServiceLevel(String approveServiceLevel) {
	    this.approveServiceLevel = approveServiceLevel;
	}

	public Date getApproveTime() {
	    return approveTime;
	}
	
	public void setApproveTime(Date approveTime) {
	    this.approveTime = approveTime;
	}

	public String getDescription() {
	    return description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}

	public String getExtendProps() {
	    return extendProps;
	}
	
	public void setExtendProps(String extendProps) {
	    this.extendProps = extendProps;
	}

	public String getCreator() {
	    return creator;
	}
	
	public void setCreator(String creator) {
	    this.creator = creator;
	}

	public Date getCreationTime() {
	    return creationTime;
	}
	
	public void setCreationTime(Date creationTime) {
	    this.creationTime = creationTime;
	}

	public String getLastModificator() {
	    return lastModificator;
	}
	
	public void setLastModificator(String lastModificator) {
	    this.lastModificator = lastModificator;
	}

	public Date getLastModificationTime() {
	    return lastModificationTime;
	}
	
	public void setLastModificationTime(Date lastModificationTime) {
	    this.lastModificationTime = lastModificationTime;
	}

	public String getCityId() {
	    return cityId;
	}
	
	public void setCityId(String cityId) {
	    this.cityId = cityId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getCounts() {
		return counts;
	}

	public void setCounts(String counts) {
		this.counts = counts;
	}

	public String getCascadeCatalogCode() {
		return cascadeCatalogCode;
	}

	public void setCascadeCatalogCode(String cascadeCatalogCode) {
		this.cascadeCatalogCode = cascadeCatalogCode;
	}

	public String getAuditIsFinish() {
		return auditIsFinish;
	}

	public void setAuditIsFinish(String auditIsFinish) {
		this.auditIsFinish = auditIsFinish;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}
	
	public String getToExState() {
		return toExState;
	}

	public void setToExState(String toExState) {
		this.toExState = toExState;
	}

	public Date getToExTime() {
		return toExTime;
	}

	public void setToExTime(Date toExTime) {
		this.toExTime = toExTime;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getServiceAgentCode() {
		return serviceAgentCode;
	}

	public void setServiceAgentCode(String serviceAgentCode) {
		this.serviceAgentCode = serviceAgentCode;
	}

	public String getLegalPeriodType() {
		return legalPeriodType;
	}

	public void setLegalPeriodType(String legalPeriodType) {
		this.legalPeriodType = legalPeriodType;
	}

	public String getLegalPeriodDay() {
		return legalPeriodDay;
	}

	public void setLegalPeriodDay(String legalPeriodDay) {
		this.legalPeriodDay = legalPeriodDay;
	}

	public String getPromisedPeriodType() {
		return promisedPeriodType;
	}

	public void setPromisedPeriodType(String promisedPeriodType) {
		this.promisedPeriodType = promisedPeriodType;
	}

	public String getPromisedPeriodDay() {
		return promisedPeriodDay;
	}

	public void setPromisedPeriodDay(String promisedPeriodDay) {
		this.promisedPeriodDay = promisedPeriodDay;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getHavaFaq() {
		return havaFaq;
	}

	public void setHavaFaq(String havaFaq) {
		this.havaFaq = havaFaq;
	}

	public String getTimeCostGs() {
		return timeCostGs;
	}

	public void setTimeCostGs(String timeCostGs) {
		this.timeCostGs = timeCostGs;
	}

	public String getRealAdminOrg() {
		return realAdminOrg;
	}

	public void setRealAdminOrg(String realAdminOrg) {
		this.realAdminOrg = realAdminOrg;
	}
	public String getFromServiceCode() {
		return fromServiceCode;
	}

	public void setFromServiceCode(String fromServiceCode) {
		this.fromServiceCode = fromServiceCode;
	}

	public Long getSysId() {
		return sysId;
	}

	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	public Long getAuditServiceId() {
		return auditServiceId;
	}

	public void setAuditServiceId(Long auditServiceId) {
		this.auditServiceId = auditServiceId;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}


	public String getFjraddress() {
		return fjraddress;
	}


	public void setFjraddress(String fjraddress) {
		this.fjraddress = fjraddress;
	}


	public String getFjrxm() {
		return fjrxm;
	}


	public void setFjrxm(String fjrxm) {
		this.fjrxm = fjrxm;
	}


	public String getFjrdhhm() {
		return fjrdhhm;
	}


	public void setFjrdhhm(String fjrdhhm) {
		this.fjrdhhm = fjrdhhm;
	}


	public String getYdyxm() {
		return ydyxm;
	}


	public void setYdyxm(String ydyxm) {
		this.ydyxm = ydyxm;
	}


	public String getYdydh() {
		return ydydh;
	}


	public void setYdydh(String ydydh) {
		this.ydydh = ydydh;
	}


	public String getProvideAPPYY() {
		return provideAPPYY;
	}


	public void setProvideAPPYY(String provideAPPYY) {
		this.provideAPPYY = provideAPPYY;
	}


	public String getAppYYURL() {
		return appYYURL;
	}


	public void setAppYYURL(String appYYURL) {
		this.appYYURL = appYYURL;
	}


	public String getProvideAPPSB() {
		return provideAPPSB;
	}


	public void setProvideAPPSB(String provideAPPSB) {
		this.provideAPPSB = provideAPPSB;
	}

	public String getAppSBURL() {
		return appSBURL;
	}

	public void setAppSBURL(String appSBURL) {
		this.appSBURL = appSBURL;
	}

	public byte[] getAppYyQrcode() {
		return appYyQrcode;
	}


	public void setAppYyQrcode(byte[] appYyQrcode) {
		this.appYyQrcode = appYyQrcode;
	}


	public byte[] getAppSbQrcode() {
		return appSbQrcode;
	}


	public void setAppSbQrcode(byte[] appSbQrcode) {
		this.appSbQrcode = appSbQrcode;
	}


	public String getYyQrcodeStr() {
		return yyQrcodeStr;
	}


	public void setYyQrcodeStr(String yyQrcodeStr) {
		this.yyQrcodeStr = yyQrcodeStr;
	}


	public String getSbQrcodeStr() {
		return sbQrcodeStr;
	}


	public void setSbQrcodeStr(String sbQrcodeStr) {
		this.sbQrcodeStr = sbQrcodeStr;
	}


	public String getIsPublic() {
		return isPublic;
	}


	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

}

