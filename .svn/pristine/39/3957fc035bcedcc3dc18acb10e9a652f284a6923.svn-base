package com.eshore.wbtimer.executor.common.code.sms;

/**
 * SMSServiceCallbackHandler Callback class, Users can extend this class and
 * implement their own receiveResult and receiveError methods.
 */
public abstract class SMSServiceCallbackHandler {

    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the
     * NonBlocking Web service call is finished and appropriate method of this
     * CallBack is called.
     *
     * @param clientData
     *            Object mechanism by which the user can pass in user data that
     *            will be avilable at the time this callback is called.
     */
    public SMSServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public SMSServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */

    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for recvSMS method override this
     * method for handling normal response from recvSMS operation
     */
    public void receiveResultrecvSMS(
            SMSServiceStub.RecvSMSResponse result) {
    }

    /**
     * auto generated Axis2 Error handler override this method for handling
     * error response from recvSMS operation
     */
    public void receiveErrorrecvSMS(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendSMS method override this
     * method for handling normal response from sendSMS operation
     */
    public void receiveResultsendSMS(
            SMSServiceStub.SendSMSResponse result) {
    }

    /**
     * auto generated Axis2 Error handler override this method for handling
     * error response from sendSMS operation
     */
    public void receiveErrorsendSMS(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getReceipt method override this
     * method for handling normal response from getReceipt operation
     */
    public void receiveResultgetReceipt(
            SMSServiceStub.GetReceiptResponse result) {
    }

    /**
     * auto generated Axis2 Error handler override this method for handling
     * error response from getReceipt operation
     */
    public void receiveErrorgetReceipt(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendSurvey method override this
     * method for handling normal response from sendSurvey operation
     */
    public void receiveResultsendSurvey(
             SMSServiceStub.SendSurveyResponse result) {
    }

    /**
     * auto generated Axis2 Error handler override this method for handling
     * error response from sendSurvey operation
     */
    public void receiveErrorsendSurvey(Exception e) {
    }

}

