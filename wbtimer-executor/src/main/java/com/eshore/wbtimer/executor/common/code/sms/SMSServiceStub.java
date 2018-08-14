package com.eshore.wbtimer.executor.common.code.sms;

import org.apache.axiom.om.impl.llom.OMSourcedElementImpl;
import org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter;

/**
 * SMSServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */

/*
 *  SMSServiceStub java implementation
 */

public class SMSServiceStub extends org.apache.axis2.client.Stub {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    // hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return Long.toString(System.currentTimeMillis())
                + "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {

        // creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("SMSService"
                + getUniqueSuffix());
        addAnonymousOperations();

        // creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[4];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "recvSMS"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "sendSMS"));
        _service.addOperation(__operation);

        _operations[1] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "getReceipt"));
        _service.addOperation(__operation);

        _operations[2] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "sendSurvey"));
        _service.addOperation(__operation);

        _operations[3] = __operation;

    }

    // populates the faults
    private void populateFaults() {

    }

    /**
     * Constructor that takes in a configContext
     */

    public SMSServiceStub(
            org.apache.axis2.context.ConfigurationContext configurationContext,
            String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public SMSServiceStub(
            org.apache.axis2.context.ConfigurationContext configurationContext,
            String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        // To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(
                configurationContext, _service);

        _serviceClient.getOptions().setTo(
                new org.apache.axis2.addressing.EndpointReference(
                        targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

    }

    /**
     * Default Constructor
     */
    public SMSServiceStub(
            org.apache.axis2.context.ConfigurationContext configurationContext)
            throws org.apache.axis2.AxisFault {

        this(configurationContext,
                "http://127.0.0.1:9090/WSInterface/services/SMSService.SMSServiceMultiPort");

    }

    /**
     * Default Constructor
     */
    public SMSServiceStub() throws org.apache.axis2.AxisFault {

        this(
                "http://127.0.0.1:9090/WSInterface/services/SMSService.SMSServiceMultiPort");

    }

    /**
     * Constructor taking the target endpoint
     */
    public SMSServiceStub(String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#recvSMS
     * @param recvSMSRequest0
     */

    public  SMSServiceStub.RecvSMSResponse recvSMS(

             SMSServiceStub.RecvSMSRequest recvSMSRequest0)

            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                    .createClient(_operations[0].getName());
            _operationClient
                    .getOptions()
                    .setAction(
                            "http://sms.protocol.intf.tisson.cn/SMSServicePortType/recvSMSRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
                    true);

            addPropertyToOperationClient(
                    _operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()), recvSMSRequest0,
                    optimizeContent(new javax.xml.namespace.QName(
                            "http://sms.protocol.intf.tisson.cn", "recvSMS")));

            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            // execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
                    .getEnvelope();

            Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                     SMSServiceStub.RecvSMSResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return ( SMSServiceStub.RecvSMSResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    // make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap
                                .get(faultElt.getQName());
                        Class exceptionClass = Class
                                .forName(exceptionClassName);
                        Exception ex = (Exception) exceptionClass
                                .newInstance();
                        // message class
                        String messageClassName = (String) faultMessageMap
                                .get(faultElt.getQName());
                        Class messageClass = Class
                                .forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod(
                                "setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#startrecvSMS
     * @param recvSMSRequest0
     */
    public void startrecvSMS(

             SMSServiceStub.RecvSMSRequest recvSMSRequest0,

            final SMSServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                .createClient(_operations[0].getName());
        _operationClient
                .getOptions()
                .setAction(
                        "http://sms.protocol.intf.tisson.cn/SMSServicePortType/recvSMSRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(
                _operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        // Style is Doc.

        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()), recvSMSRequest0,
                optimizeContent(new javax.xml.namespace.QName(
                        "http://sms.protocol.intf.tisson.cn", "recvSMS")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient
                .setCallback(new org.apache.axis2.client.async.AxisCallback() {
                    public void onMessage(
                            org.apache.axis2.context.MessageContext resultContext) {
                        try {
                            org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                                    .getEnvelope();

                            Object object = fromOM(
                                    resultEnv.getBody().getFirstElement(),
                                     SMSServiceStub.RecvSMSResponse.class,
                                    getEnvelopeNamespaces(resultEnv));
                            callback.receiveResultrecvSMS(( SMSServiceStub.RecvSMSResponse) object);

                        } catch (org.apache.axis2.AxisFault e) {
                            callback.receiveErrorrecvSMS(e);
                        }
                    }

                    public void onError(Exception error) {
                        if (error instanceof org.apache.axis2.AxisFault) {
                            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                            org.apache.axiom.om.OMElement faultElt = f
                                    .getDetail();
                            if (faultElt != null) {
                                if (faultExceptionNameMap.containsKey(faultElt
                                        .getQName())) {
                                    // make the fault by reflection
                                    try {
                                        String exceptionClassName = (String) faultExceptionClassNameMap
                                                .get(faultElt.getQName());
                                        Class exceptionClass = Class
                                                .forName(exceptionClassName);
                                        Exception ex = (Exception) exceptionClass
                                                .newInstance();
                                        // message class
                                        String messageClassName = (String) faultMessageMap
                                                .get(faultElt.getQName());
                                        Class messageClass = Class
                                                .forName(messageClassName);
                                        Object messageObject = fromOM(
                                                faultElt, messageClass, null);
                                        java.lang.reflect.Method m = exceptionClass
                                                .getMethod(
                                                        "setFaultMessage",
                                                        new Class[] { messageClass });
                                        m.invoke(
                                                ex,
                                                new Object[] { messageObject });

                                        callback.receiveErrorrecvSMS(new java.rmi.RemoteException(
                                                ex.getMessage(), ex));
                                    } catch (ClassCastException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    } catch (ClassNotFoundException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    } catch (NoSuchMethodException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    } catch (java.lang.reflect.InvocationTargetException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    } catch (IllegalAccessException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    } catch (InstantiationException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    } catch (org.apache.axis2.AxisFault e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorrecvSMS(f);
                                    }
                                } else {
                                    callback.receiveErrorrecvSMS(f);
                                }
                            } else {
                                callback.receiveErrorrecvSMS(f);
                            }
                        } else {
                            callback.receiveErrorrecvSMS(error);
                        }
                    }

                    public void onFault(
                            org.apache.axis2.context.MessageContext faultContext) {
                        org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                                .getInboundFaultFromMessageContext(faultContext);
                        onError(fault);
                    }

                    public void onComplete() {
                        try {
                            _messageContext.getTransportOut().getSender()
                                    .cleanup(_messageContext);
                        } catch (org.apache.axis2.AxisFault axisFault) {
                            callback.receiveErrorrecvSMS(axisFault);
                        }
                    }
                });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[0].getMessageReceiver() == null
                && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        // execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#sendSMS
     * @param sendSMSRequest2
     */

    public  SMSServiceStub.SendSMSResponse sendSMS(

             SMSServiceStub.SendSMSRequest sendSMSRequest2)

            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                    .createClient(_operations[1].getName());
            _operationClient
                    .getOptions()
                    .setAction(
                            "http://sms.protocol.intf.tisson.cn/SMSServicePortType/sendSMSRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
                    true);

            addPropertyToOperationClient(
                    _operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()), sendSMSRequest2,
                    optimizeContent(new javax.xml.namespace.QName(
                            "http://sms.protocol.intf.tisson.cn", "sendSMS")));

            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            // execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
                    .getEnvelope();

            Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                     SMSServiceStub.SendSMSResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return ( SMSServiceStub.SendSMSResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    // make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap
                                .get(faultElt.getQName());
                        Class exceptionClass = Class
                                .forName(exceptionClassName);
                        Exception ex = (Exception) exceptionClass
                                .newInstance();
                        // message class
                        String messageClassName = (String) faultMessageMap
                                .get(faultElt.getQName());
                        Class messageClass = Class
                                .forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod(
                                "setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#startsendSMS
     * @param sendSMSRequest2
     */
    public void startsendSMS(

             SMSServiceStub.SendSMSRequest sendSMSRequest2,

            final SMSServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                .createClient(_operations[1].getName());
        _operationClient
                .getOptions()
                .setAction(
                        "http://sms.protocol.intf.tisson.cn/SMSServicePortType/sendSMSRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(
                _operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        // Style is Doc.

        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()), sendSMSRequest2,
                optimizeContent(new javax.xml.namespace.QName(
                        "http://sms.protocol.intf.tisson.cn", "sendSMS")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient
                .setCallback(new org.apache.axis2.client.async.AxisCallback() {
                    public void onMessage(
                            org.apache.axis2.context.MessageContext resultContext) {
                        try {
                            org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                                    .getEnvelope();

                            Object object = fromOM(
                                    resultEnv.getBody().getFirstElement(),
                                     SMSServiceStub.SendSMSResponse.class,
                                    getEnvelopeNamespaces(resultEnv));
                            callback.receiveResultsendSMS(( SMSServiceStub.SendSMSResponse) object);

                        } catch (org.apache.axis2.AxisFault e) {
                            callback.receiveErrorsendSMS(e);
                        }
                    }

                    public void onError(Exception error) {
                        if (error instanceof org.apache.axis2.AxisFault) {
                            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                            org.apache.axiom.om.OMElement faultElt = f
                                    .getDetail();
                            if (faultElt != null) {
                                if (faultExceptionNameMap.containsKey(faultElt
                                        .getQName())) {
                                    // make the fault by reflection
                                    try {
                                        String exceptionClassName = (String) faultExceptionClassNameMap
                                                .get(faultElt.getQName());
                                        Class exceptionClass = Class
                                                .forName(exceptionClassName);
                                        Exception ex = (Exception) exceptionClass
                                                .newInstance();
                                        // message class
                                        String messageClassName = (String) faultMessageMap
                                                .get(faultElt.getQName());
                                        Class messageClass = Class
                                                .forName(messageClassName);
                                        Object messageObject = fromOM(
                                                faultElt, messageClass, null);
                                        java.lang.reflect.Method m = exceptionClass
                                                .getMethod(
                                                        "setFaultMessage",
                                                        new Class[] { messageClass });
                                        m.invoke(
                                                ex,
                                                new Object[] { messageObject });

                                        callback.receiveErrorsendSMS(new java.rmi.RemoteException(
                                                ex.getMessage(), ex));
                                    } catch (ClassCastException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    } catch (ClassNotFoundException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    } catch (NoSuchMethodException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    } catch (java.lang.reflect.InvocationTargetException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    } catch (IllegalAccessException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    } catch (InstantiationException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    } catch (org.apache.axis2.AxisFault e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSMS(f);
                                    }
                                } else {
                                    callback.receiveErrorsendSMS(f);
                                }
                            } else {
                                callback.receiveErrorsendSMS(f);
                            }
                        } else {
                            callback.receiveErrorsendSMS(error);
                        }
                    }

                    public void onFault(
                            org.apache.axis2.context.MessageContext faultContext) {
                        org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                                .getInboundFaultFromMessageContext(faultContext);
                        onError(fault);
                    }

                    public void onComplete() {
                        try {
                            _messageContext.getTransportOut().getSender()
                                    .cleanup(_messageContext);
                        } catch (org.apache.axis2.AxisFault axisFault) {
                            callback.receiveErrorsendSMS(axisFault);
                        }
                    }
                });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[1].getMessageReceiver() == null
                && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(_callbackReceiver);
        }

        // execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#getReceipt
     * @param getReceiptRequest4
     */

    public  SMSServiceStub.GetReceiptResponse getReceipt(

             SMSServiceStub.GetReceiptRequest getReceiptRequest4)

            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                    .createClient(_operations[2].getName());
            _operationClient
                    .getOptions()
                    .setAction(
                            "http://sms.protocol.intf.tisson.cn/SMSServicePortType/getReceiptRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
                    true);

            addPropertyToOperationClient(
                    _operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(
                    getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getReceiptRequest4,
                    optimizeContent(new javax.xml.namespace.QName(
                            "http://sms.protocol.intf.tisson.cn", "getReceipt")));

            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            // execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
                    .getEnvelope();

            Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                     SMSServiceStub.GetReceiptResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return ( SMSServiceStub.GetReceiptResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    // make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap
                                .get(faultElt.getQName());
                        Class exceptionClass = Class
                                .forName(exceptionClassName);
                        Exception ex = (Exception) exceptionClass
                                .newInstance();
                        // message class
                        String messageClassName = (String) faultMessageMap
                                .get(faultElt.getQName());
                        Class messageClass = Class
                                .forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod(
                                "setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#startgetReceipt
     * @param getReceiptRequest4
     */
    public void startgetReceipt(

             SMSServiceStub.GetReceiptRequest getReceiptRequest4,

            final SMSServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                .createClient(_operations[2].getName());
        _operationClient
                .getOptions()
                .setAction(
                        "http://sms.protocol.intf.tisson.cn/SMSServicePortType/getReceiptRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(
                _operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        // Style is Doc.

        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()), getReceiptRequest4,
                optimizeContent(new javax.xml.namespace.QName(
                        "http://sms.protocol.intf.tisson.cn", "getReceipt")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient
                .setCallback(new org.apache.axis2.client.async.AxisCallback() {
                    public void onMessage(
                            org.apache.axis2.context.MessageContext resultContext) {
                        try {
                            org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                                    .getEnvelope();

                            Object object = fromOM(
                                    resultEnv.getBody().getFirstElement(),
                                     SMSServiceStub.GetReceiptResponse.class,
                                    getEnvelopeNamespaces(resultEnv));
                            callback.receiveResultgetReceipt(( SMSServiceStub.GetReceiptResponse) object);

                        } catch (org.apache.axis2.AxisFault e) {
                            callback.receiveErrorgetReceipt(e);
                        }
                    }

                    public void onError(Exception error) {
                        if (error instanceof org.apache.axis2.AxisFault) {
                            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                            org.apache.axiom.om.OMElement faultElt = f
                                    .getDetail();
                            if (faultElt != null) {
                                if (faultExceptionNameMap.containsKey(faultElt
                                        .getQName())) {
                                    // make the fault by reflection
                                    try {
                                        String exceptionClassName = (String) faultExceptionClassNameMap
                                                .get(faultElt.getQName());
                                        Class exceptionClass = Class
                                                .forName(exceptionClassName);
                                        Exception ex = (Exception) exceptionClass
                                                .newInstance();
                                        // message class
                                        String messageClassName = (String) faultMessageMap
                                                .get(faultElt.getQName());
                                        Class messageClass = Class
                                                .forName(messageClassName);
                                        Object messageObject = fromOM(
                                                faultElt, messageClass, null);
                                        java.lang.reflect.Method m = exceptionClass
                                                .getMethod(
                                                        "setFaultMessage",
                                                        new Class[] { messageClass });
                                        m.invoke(
                                                ex,
                                                new Object[] { messageObject });

                                        callback.receiveErrorgetReceipt(new java.rmi.RemoteException(
                                                ex.getMessage(), ex));
                                    } catch (ClassCastException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    } catch (ClassNotFoundException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    } catch (NoSuchMethodException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    } catch (java.lang.reflect.InvocationTargetException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    } catch (IllegalAccessException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    } catch (InstantiationException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    } catch (org.apache.axis2.AxisFault e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorgetReceipt(f);
                                    }
                                } else {
                                    callback.receiveErrorgetReceipt(f);
                                }
                            } else {
                                callback.receiveErrorgetReceipt(f);
                            }
                        } else {
                            callback.receiveErrorgetReceipt(error);
                        }
                    }

                    public void onFault(
                            org.apache.axis2.context.MessageContext faultContext) {
                        org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                                .getInboundFaultFromMessageContext(faultContext);
                        onError(fault);
                    }

                    public void onComplete() {
                        try {
                            _messageContext.getTransportOut().getSender()
                                    .cleanup(_messageContext);
                        } catch (org.apache.axis2.AxisFault axisFault) {
                            callback.receiveErrorgetReceipt(axisFault);
                        }
                    }
                });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[2].getMessageReceiver() == null
                && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(_callbackReceiver);
        }

        // execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see  SMSService#sendSurvey
     * @param sendSurveyRequest6
     */

    public  SMSServiceStub.SendSurveyResponse sendSurvey(

             SMSServiceStub.SendSurveyRequest sendSurveyRequest6)

            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                    .createClient(_operations[3].getName());
            _operationClient
                    .getOptions()
                    .setAction(
                            "http://sms.protocol.intf.tisson.cn/SMSServicePortType/sendSurveyRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
                    true);

            addPropertyToOperationClient(
                    _operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(
                    getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    sendSurveyRequest6,
                    optimizeContent(new javax.xml.namespace.QName(
                            "http://sms.protocol.intf.tisson.cn", "sendSurvey")));

            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            // execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
                    .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
                    .getEnvelope();

            Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                     SMSServiceStub.SendSurveyResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return ( SMSServiceStub.SendSurveyResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    // make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap
                                .get(faultElt.getQName());
                        Class exceptionClass = Class
                                .forName(exceptionClassName);
                        Exception ex = (Exception) exceptionClass
                                .newInstance();
                        // message class
                        String messageClassName = (String) faultMessageMap
                                .get(faultElt.getQName());
                        Class messageClass = Class
                                .forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod(
                                "setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original
                        // Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see cn.tisson.intf.webservice.client.sms.SMSService#startsendSurvey
     * @param sendSurveyRequest6
     */
    public void startsendSurvey(

             SMSServiceStub.SendSurveyRequest sendSurveyRequest6,

            final SMSServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient
                .createClient(_operations[3].getName());
        _operationClient
                .getOptions()
                .setAction(
                        "http://sms.protocol.intf.tisson.cn/SMSServicePortType/sendSurveyRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(
                _operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        // Style is Doc.

        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()), sendSurveyRequest6,
                optimizeContent(new javax.xml.namespace.QName(
                        "http://sms.protocol.intf.tisson.cn", "sendSurvey")));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient
                .setCallback(new org.apache.axis2.client.async.AxisCallback() {
                    public void onMessage(
                            org.apache.axis2.context.MessageContext resultContext) {
                        try {
                            org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
                                    .getEnvelope();

                            Object object = fromOM(
                                    resultEnv.getBody().getFirstElement(),
                                     SMSServiceStub.SendSurveyResponse.class,
                                    getEnvelopeNamespaces(resultEnv));
                            callback.receiveResultsendSurvey(( SMSServiceStub.SendSurveyResponse) object);

                        } catch (org.apache.axis2.AxisFault e) {
                            callback.receiveErrorsendSurvey(e);
                        }
                    }

                    public void onError(Exception error) {
                        if (error instanceof org.apache.axis2.AxisFault) {
                            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                            org.apache.axiom.om.OMElement faultElt = f
                                    .getDetail();
                            if (faultElt != null) {
                                if (faultExceptionNameMap.containsKey(faultElt
                                        .getQName())) {
                                    // make the fault by reflection
                                    try {
                                        String exceptionClassName = (String) faultExceptionClassNameMap
                                                .get(faultElt.getQName());
                                        Class exceptionClass = Class
                                                .forName(exceptionClassName);
                                        Exception ex = (Exception) exceptionClass
                                                .newInstance();
                                        // message class
                                        String messageClassName = (String) faultMessageMap
                                                .get(faultElt.getQName());
                                        Class messageClass = Class
                                                .forName(messageClassName);
                                        Object messageObject = fromOM(
                                                faultElt, messageClass, null);
                                        java.lang.reflect.Method m = exceptionClass
                                                .getMethod(
                                                        "setFaultMessage",
                                                        new Class[] { messageClass });
                                        m.invoke(
                                                ex,
                                                new Object[] { messageObject });

                                        callback.receiveErrorsendSurvey(new java.rmi.RemoteException(
                                                ex.getMessage(), ex));
                                    } catch (ClassCastException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    } catch (ClassNotFoundException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    } catch (NoSuchMethodException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    } catch (java.lang.reflect.InvocationTargetException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    } catch (IllegalAccessException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    } catch (InstantiationException e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    } catch (org.apache.axis2.AxisFault e) {
                                        // we cannot intantiate the class -
                                        // throw the original Axis fault
                                        callback.receiveErrorsendSurvey(f);
                                    }
                                } else {
                                    callback.receiveErrorsendSurvey(f);
                                }
                            } else {
                                callback.receiveErrorsendSurvey(f);
                            }
                        } else {
                            callback.receiveErrorsendSurvey(error);
                        }
                    }

                    public void onFault(
                            org.apache.axis2.context.MessageContext faultContext) {
                        org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
                                .getInboundFaultFromMessageContext(faultContext);
                        onError(fault);
                    }

                    public void onComplete() {
                        try {
                            _messageContext.getTransportOut().getSender()
                                    .cleanup(_messageContext);
                        } catch (org.apache.axis2.AxisFault axisFault) {
                            callback.receiveErrorsendSurvey(axisFault);
                        }
                    }
                });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[3].getMessageReceiver() == null
                && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(_callbackReceiver);
        }

        // execute the operation client
        _operationClient.execute(false);

    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(
            org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
                    .next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }

    // http://127.0.0.1:9090/WSInterface/services/SMSService.SMSServiceMultiPort
    public static class SendSMSResponse implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "sendSMSResponse", "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for SessionId
         */

        protected long localSessionId;

        /**
         * Auto generated getter method
         *
         * @return long
         */
        public long getSessionId() {
            return localSessionId;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SessionId
         */
        public void setSessionId(long param) {

            this.localSessionId = param;

        }

        /**
         * field for ResultCode
         */

        protected String localResultCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getResultCode() {
            return localResultCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ResultCode
         */
        public void setResultCode(String param) {

            this.localResultCode = param;

        }

        /**
         * field for SuccessCount
         */

        protected int localSuccessCount;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getSuccessCount() {
            return localSuccessCount;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SuccessCount
         */
        public void setSuccessCount(int param) {

            this.localSuccessCount = param;

        }

        /**
         * field for FilterCount
         */

        protected int localFilterCount;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getFilterCount() {
            return localFilterCount;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            FilterCount
         */
        public void setFilterCount(int param) {

            this.localFilterCount = param;

        }

        /**
         * field for FilterArray
         */

        protected FilterArray localFilterArray;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localFilterArrayTracker = false;

        /**
         * Auto generated getter method
         *
         * @return FilterArray
         */
        public FilterArray getFilterArray() {
            return localFilterArray;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            FilterArray
         */
        public void setFilterArray(FilterArray param) {

            if (param != null) {
                // update the setting tracker
                localFilterArrayTracker = true;
            } else {
                localFilterArrayTracker = true;

            }

            this.localFilterArray = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    SendSMSResponse.this
                            .serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":sendSMSResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "sendSMSResponse", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "sessionId", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "sessionId");
                }

            } else {
                xmlWriter.writeStartElement("sessionId");
            }

            if (localSessionId == Long.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "sessionId cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSessionId));
            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter
                            .writeStartElement(prefix, "resultCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "resultCode");
                }

            } else {
                xmlWriter.writeStartElement("resultCode");
            }

            if (localResultCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localResultCode);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "successCount",
                            namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "successCount");
                }

            } else {
                xmlWriter.writeStartElement("successCount");
            }

            if (localSuccessCount == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "successCount cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSuccessCount));
            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "filterCount",
                            namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "filterCount");
                }

            } else {
                xmlWriter.writeStartElement("filterCount");
            }

            if (localFilterCount == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "filterCount cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localFilterCount));
            }

            xmlWriter.writeEndElement();
            if (localFilterArrayTracker) {
                if (localFilterArray == null) {

                    String namespace2 = "";

                    if (!namespace2.equals("")) {
                        String prefix2 = xmlWriter
                                .getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2, "filterArray",
                                    namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2,
                                    "filterArray");
                        }

                    } else {
                        xmlWriter.writeStartElement("filterArray");
                    }

                    // write the nil attribute
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localFilterArray.serialize(new javax.xml.namespace.QName(
                            "", "filterArray"), factory, xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "sessionId"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localSessionId));

            elementList.add(new javax.xml.namespace.QName("", "resultCode"));

            if (localResultCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localResultCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "successCount"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localSuccessCount));

            elementList.add(new javax.xml.namespace.QName("", "filterCount"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localFilterCount));
            if (localFilterArrayTracker) {
                elementList
                        .add(new javax.xml.namespace.QName("", "filterArray"));

                elementList.add(localFilterArray == null ? null
                        : localFilterArray);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static SendSMSResponse parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                SendSMSResponse object = new SendSMSResponse();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"sendSMSResponse".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (SendSMSResponse) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sessionId")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSessionId(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToLong(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "resultCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setResultCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "successCount")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSuccessCount(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToInt(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "filterCount")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setFilterCount(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToInt(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "filterArray")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if ("true".equals(nillableValue)
                                || "1".equals(nillableValue)) {
                            object.setFilterArray(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setFilterArray(FilterArray.Factory
                                    .parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class SendSMSRequest implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "sendSMSRequest", "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for AccountAuth
         */

        protected AccountAuth localAccountAuth;

        /**
         * Auto generated getter method
         *
         * @return AccountAuth
         */
        public AccountAuth getAccountAuth() {
            return localAccountAuth;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            AccountAuth
         */
        public void setAccountAuth(AccountAuth param) {

            this.localAccountAuth = param;

        }

        /**
         * field for SendNum
         */

        protected String localSendNum;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localSendNumTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSendNum() {
            return localSendNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SendNum
         */
        public void setSendNum(String param) {

            if (param != null) {
                // update the setting tracker
                localSendNumTracker = true;
            } else {
                localSendNumTracker = true;

            }

            this.localSendNum = param;

        }

        /**
         * field for SchdDate
         */

        protected String localSchdDate;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localSchdDateTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSchdDate() {
            return localSchdDate;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SchdDate
         */
        public void setSchdDate(String param) {

            if (param != null) {
                // update the setting tracker
                localSchdDateTracker = true;
            } else {
                localSchdDateTracker = true;

            }

            this.localSchdDate = param;

        }

        /**
         * field for RecvNumArray
         */

        protected RecvNumArray localRecvNumArray;

        /**
         * Auto generated getter method
         *
         * @return RecvNumArray
         */
        public RecvNumArray getRecvNumArray() {
            return localRecvNumArray;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNumArray
         */
        public void setRecvNumArray(RecvNumArray param) {

            this.localRecvNumArray = param;

        }

        /**
         * field for Content
         */

        protected String localContent;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getContent() {
            return localContent;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            Content
         */
        public void setContent(String param) {

            this.localContent = param;

        }

        /**
         * field for ReceiptFlag
         */

        protected int localReceiptFlag;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localReceiptFlagTracker = false;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getReceiptFlag() {
            return localReceiptFlag;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ReceiptFlag
         */
        public void setReceiptFlag(int param) {

            // setting primitive attribute tracker to true

            if (param == Integer.MIN_VALUE) {
                localReceiptFlagTracker = true;

            } else {
                localReceiptFlagTracker = true;
            }

            this.localReceiptFlag = param;

        }

        /**
         * field for BusiCode
         */

        protected String localBusiCode;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localBusiCodeTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getBusiCode() {
            return localBusiCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            BusiCode
         */
        public void setBusiCode(String param) {

            if (param != null) {
                // update the setting tracker
                localBusiCodeTracker = true;
            } else {
                localBusiCodeTracker = true;

            }

            this.localBusiCode = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    SendSMSRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                 MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":sendSMSRequest",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "sendSMSRequest", xmlWriter);
                }

            }

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            localAccountAuth.serialize(new javax.xml.namespace.QName("",
                    "accountAuth"), factory, xmlWriter);
            if (localSendNumTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "sendNum",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "sendNum");
                    }

                } else {
                    xmlWriter.writeStartElement("sendNum");
                }

                if (localSendNum == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localSendNum);

                }

                xmlWriter.writeEndElement();
            }
            if (localSchdDateTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "schdDate",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "schdDate");
                    }

                } else {
                    xmlWriter.writeStartElement("schdDate");
                }

                if (localSchdDate == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localSchdDate);

                }

                xmlWriter.writeEndElement();
            }
            if (localRecvNumArray == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "recvNumArray cannot be null!!");
            }
            localRecvNumArray.serialize(new javax.xml.namespace.QName("",
                    "recvNumArray"), factory, xmlWriter);

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "content", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "content");
                }

            } else {
                xmlWriter.writeStartElement("content");
            }

            if (localContent == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "content cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localContent);

            }

            xmlWriter.writeEndElement();
            if (localReceiptFlagTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "receiptFlag",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "receiptFlag");
                    }

                } else {
                    xmlWriter.writeStartElement("receiptFlag");
                }

                if (localReceiptFlag == Integer.MIN_VALUE) {

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(localReceiptFlag));
                }

                xmlWriter.writeEndElement();
            }
            if (localBusiCodeTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "busiCode",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "busiCode");
                    }

                } else {
                    xmlWriter.writeStartElement("busiCode");
                }

                if (localBusiCode == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localBusiCode);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "accountAuth"));

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            elementList.add(localAccountAuth);
            if (localSendNumTracker) {
                elementList.add(new javax.xml.namespace.QName("", "sendNum"));

                elementList.add(localSendNum == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localSendNum));
            }
            if (localSchdDateTracker) {
                elementList.add(new javax.xml.namespace.QName("", "schdDate"));

                elementList.add(localSchdDate == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localSchdDate));
            }
            elementList.add(new javax.xml.namespace.QName("", "recvNumArray"));

            if (localRecvNumArray == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "recvNumArray cannot be null!!");
            }
            elementList.add(localRecvNumArray);

            elementList.add(new javax.xml.namespace.QName("", "content"));

            if (localContent != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localContent));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "content cannot be null!!");
            }
            if (localReceiptFlagTracker) {
                elementList
                        .add(new javax.xml.namespace.QName("", "receiptFlag"));

                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localReceiptFlag));
            }
            if (localBusiCodeTracker) {
                elementList.add(new javax.xml.namespace.QName("", "busiCode"));

                elementList.add(localBusiCode == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localBusiCode));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static SendSMSRequest parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                SendSMSRequest object = new SendSMSRequest();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"sendSMSRequest".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (SendSMSRequest) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "accountAuth")
                            .equals(reader.getName())) {

                        object.setAccountAuth(AccountAuth.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sendNum")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setSendNum(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "schdDate")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setSchdDate(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNumArray")
                            .equals(reader.getName())) {

                        object.setRecvNumArray(RecvNumArray.Factory
                                .parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "content")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setContent(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "receiptFlag")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setReceiptFlag(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToInt(content));

                        } else {

                            object.setReceiptFlag(Integer.MIN_VALUE);

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                        object.setReceiptFlag(Integer.MIN_VALUE);

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "busiCode")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setBusiCode(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class RecvMessage implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * recvMessage Namespace URI = http://sms.protocol.intf.tisson.cn
         * Namespace Prefix = ns2
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for SendNum
         */

        protected String localSendNum;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSendNum() {
            return localSendNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SendNum
         */
        public void setSendNum(String param) {

            this.localSendNum = param;

        }

        /**
         * field for RecvNum
         */

        protected String localRecvNum;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getRecvNum() {
            return localRecvNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNum
         */
        public void setRecvNum(String param) {

            this.localRecvNum = param;

        }

        /**
         * field for Content
         */

        protected String localContent;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getContent() {
            return localContent;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            Content
         */
        public void setContent(String param) {

            this.localContent = param;

        }

        /**
         * field for RecvDate
         */

        protected String localRecvDate;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getRecvDate() {
            return localRecvDate;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvDate
         */
        public void setRecvDate(String param) {

            this.localRecvDate = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    RecvMessage.this.serialize(parentQName, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":recvMessage", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "recvMessage", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "sendNum", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "sendNum");
                }

            } else {
                xmlWriter.writeStartElement("sendNum");
            }

            if (localSendNum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "sendNum cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localSendNum);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "recvNum", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "recvNum");
                }

            } else {
                xmlWriter.writeStartElement("recvNum");
            }

            if (localRecvNum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRecvNum);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "content", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "content");
                }

            } else {
                xmlWriter.writeStartElement("content");
            }

            if (localContent == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "content cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localContent);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "recvDate", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "recvDate");
                }

            } else {
                xmlWriter.writeStartElement("recvDate");
            }

            if (localRecvDate == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "recvDate cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRecvDate);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "sendNum"));

            if (localSendNum != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSendNum));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "sendNum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "recvNum"));

            if (localRecvNum != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localRecvNum));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "content"));

            if (localContent != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localContent));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "content cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "recvDate"));

            if (localRecvDate != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localRecvDate));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "recvDate cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RecvMessage parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                RecvMessage object = new RecvMessage();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"recvMessage".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (RecvMessage) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sendNum")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSendNum(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNum")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setRecvNum(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "content")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setContent(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvDate")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setRecvDate(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class RecvSMSResponse implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "recvSMSResponse", "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for ResultCode
         */

        protected String localResultCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getResultCode() {
            return localResultCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ResultCode
         */
        public void setResultCode(String param) {

            this.localResultCode = param;

        }

        /**
         * field for ResultCount
         */

        protected int localResultCount;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getResultCount() {
            return localResultCount;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ResultCount
         */
        public void setResultCount(int param) {

            this.localResultCount = param;

        }

        /**
         * field for RecvMessageArray
         */

        protected RecvMessageArray localRecvMessageArray;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localRecvMessageArrayTracker = false;

        /**
         * Auto generated getter method
         *
         * @return RecvMessageArray
         */
        public RecvMessageArray getRecvMessageArray() {
            return localRecvMessageArray;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvMessageArray
         */
        public void setRecvMessageArray(RecvMessageArray param) {

            if (param != null) {
                // update the setting tracker
                localRecvMessageArrayTracker = true;
            } else {
                localRecvMessageArrayTracker = true;

            }

            this.localRecvMessageArray = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    RecvSMSResponse.this
                            .serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":recvSMSResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "recvSMSResponse", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter
                            .writeStartElement(prefix, "resultCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "resultCode");
                }

            } else {
                xmlWriter.writeStartElement("resultCode");
            }

            if (localResultCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localResultCode);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "resultCount",
                            namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "resultCount");
                }

            } else {
                xmlWriter.writeStartElement("resultCount");
            }

            if (localResultCount == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "resultCount cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localResultCount));
            }

            xmlWriter.writeEndElement();
            if (localRecvMessageArrayTracker) {
                if (localRecvMessageArray == null) {

                    String namespace2 = "";

                    if (!namespace2.equals("")) {
                        String prefix2 = xmlWriter
                                .getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2,
                                    "recvMessageArray", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2,
                                    "recvMessageArray");
                        }

                    } else {
                        xmlWriter.writeStartElement("recvMessageArray");
                    }

                    // write the nil attribute
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localRecvMessageArray.serialize(
                            new javax.xml.namespace.QName("",
                                    "recvMessageArray"), factory, xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "resultCode"));

            if (localResultCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localResultCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "resultCount"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localResultCount));
            if (localRecvMessageArrayTracker) {
                elementList.add(new javax.xml.namespace.QName("",
                        "recvMessageArray"));

                elementList.add(localRecvMessageArray == null ? null
                        : localRecvMessageArray);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RecvSMSResponse parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                RecvSMSResponse object = new RecvSMSResponse();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"recvSMSResponse".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (RecvSMSResponse) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "resultCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setResultCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "resultCount")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setResultCount(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToInt(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("",
                            "recvMessageArray")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if ("true".equals(nillableValue)
                                || "1".equals(nillableValue)) {
                            object.setRecvMessageArray(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setRecvMessageArray(RecvMessageArray.Factory
                                    .parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class ReceiptMessage implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * receiptMessage Namespace URI = http://sms.protocol.intf.tisson.cn
         * Namespace Prefix = ns2
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for SessionId
         */

        protected long localSessionId;

        /**
         * Auto generated getter method
         *
         * @return long
         */
        public long getSessionId() {
            return localSessionId;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SessionId
         */
        public void setSessionId(long param) {

            this.localSessionId = param;

        }

        /**
         * field for SendNum
         */

        protected String localSendNum;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSendNum() {
            return localSendNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SendNum
         */
        public void setSendNum(String param) {

            this.localSendNum = param;

        }

        /**
         * field for RecvNum
         */

        protected String localRecvNum;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getRecvNum() {
            return localRecvNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNum
         */
        public void setRecvNum(String param) {

            this.localRecvNum = param;

        }

        /**
         * field for SmStat
         */

        protected int localSmStat;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getSmStat() {
            return localSmStat;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SmStat
         */
        public void setSmStat(int param) {

            this.localSmStat = param;

        }

        /**
         * field for OrigStat
         */

        protected String localOrigStat;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getOrigStat() {
            return localOrigStat;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            OrigStat
         */
        public void setOrigStat(String param) {

            this.localOrigStat = param;

        }

        /**
         * field for ErrCode
         */

        protected String localErrCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getErrCode() {
            return localErrCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ErrCode
         */
        public void setErrCode(String param) {

            this.localErrCode = param;

        }

        /**
         * field for ReceiptDate
         */

        protected String localReceiptDate;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getReceiptDate() {
            return localReceiptDate;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ReceiptDate
         */
        public void setReceiptDate(String param) {

            this.localReceiptDate = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    ReceiptMessage.this.serialize(parentQName, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":receiptMessage",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "receiptMessage", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "sessionId", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "sessionId");
                }

            } else {
                xmlWriter.writeStartElement("sessionId");
            }

            if (localSessionId == Long.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "sessionId cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSessionId));
            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "sendNum", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "sendNum");
                }

            } else {
                xmlWriter.writeStartElement("sendNum");
            }

            if (localSendNum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "sendNum cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localSendNum);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "recvNum", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "recvNum");
                }

            } else {
                xmlWriter.writeStartElement("recvNum");
            }

            if (localRecvNum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRecvNum);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "smStat", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "smStat");
                }

            } else {
                xmlWriter.writeStartElement("smStat");
            }

            if (localSmStat == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "smStat cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSmStat));
            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "origStat", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "origStat");
                }

            } else {
                xmlWriter.writeStartElement("origStat");
            }

            if (localOrigStat == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "origStat cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localOrigStat);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "errCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "errCode");
                }

            } else {
                xmlWriter.writeStartElement("errCode");
            }

            if (localErrCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "errCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localErrCode);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "receiptDate",
                            namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "receiptDate");
                }

            } else {
                xmlWriter.writeStartElement("receiptDate");
            }

            if (localReceiptDate == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "receiptDate cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localReceiptDate);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "sessionId"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localSessionId));

            elementList.add(new javax.xml.namespace.QName("", "sendNum"));

            if (localSendNum != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSendNum));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "sendNum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "recvNum"));

            if (localRecvNum != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localRecvNum));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "smStat"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localSmStat));

            elementList.add(new javax.xml.namespace.QName("", "origStat"));

            if (localOrigStat != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localOrigStat));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "origStat cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "errCode"));

            if (localErrCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localErrCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "errCode cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "receiptDate"));

            if (localReceiptDate != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localReceiptDate));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "receiptDate cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ReceiptMessage parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                ReceiptMessage object = new ReceiptMessage();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"receiptMessage".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (ReceiptMessage) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sessionId")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSessionId(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToLong(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sendNum")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSendNum(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNum")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setRecvNum(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "smStat")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSmStat(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToInt(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "origStat")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setOrigStat(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "errCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setErrCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "receiptDate")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setReceiptDate(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class GetReceiptRequest implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "getReceiptRequest",
                "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for AccountAuth
         */

        protected AccountAuth localAccountAuth;

        /**
         * Auto generated getter method
         *
         * @return AccountAuth
         */
        public AccountAuth getAccountAuth() {
            return localAccountAuth;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            AccountAuth
         */
        public void setAccountAuth(AccountAuth param) {

            this.localAccountAuth = param;

        }

        /**
         * field for SendNum
         */

        protected String localSendNum;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localSendNumTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSendNum() {
            return localSendNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SendNum
         */
        public void setSendNum(String param) {

            if (param != null) {
                // update the setting tracker
                localSendNumTracker = true;
            } else {
                localSendNumTracker = true;

            }

            this.localSendNum = param;

        }

        /**
         * field for RecvNum
         */

        protected String localRecvNum;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localRecvNumTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getRecvNum() {
            return localRecvNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNum
         */
        public void setRecvNum(String param) {

            if (param != null) {
                // update the setting tracker
                localRecvNumTracker = true;
            } else {
                localRecvNumTracker = true;

            }

            this.localRecvNum = param;

        }

        /**
         * field for BusiCode
         */

        protected String localBusiCode;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localBusiCodeTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getBusiCode() {
            return localBusiCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            BusiCode
         */
        public void setBusiCode(String param) {

            if (param != null) {
                // update the setting tracker
                localBusiCodeTracker = true;
            } else {
                localBusiCodeTracker = true;

            }

            this.localBusiCode = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GetReceiptRequest.this.serialize(MY_QNAME, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":getReceiptRequest",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "getReceiptRequest", xmlWriter);
                }

            }

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            localAccountAuth.serialize(new javax.xml.namespace.QName("",
                    "accountAuth"), factory, xmlWriter);
            if (localSendNumTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "sendNum",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "sendNum");
                    }

                } else {
                    xmlWriter.writeStartElement("sendNum");
                }

                if (localSendNum == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localSendNum);

                }

                xmlWriter.writeEndElement();
            }
            if (localRecvNumTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "recvNum",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "recvNum");
                    }

                } else {
                    xmlWriter.writeStartElement("recvNum");
                }

                if (localRecvNum == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localRecvNum);

                }

                xmlWriter.writeEndElement();
            }
            if (localBusiCodeTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "busiCode",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "busiCode");
                    }

                } else {
                    xmlWriter.writeStartElement("busiCode");
                }

                if (localBusiCode == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localBusiCode);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "accountAuth"));

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            elementList.add(localAccountAuth);
            if (localSendNumTracker) {
                elementList.add(new javax.xml.namespace.QName("", "sendNum"));

                elementList.add(localSendNum == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localSendNum));
            }
            if (localRecvNumTracker) {
                elementList.add(new javax.xml.namespace.QName("", "recvNum"));

                elementList.add(localRecvNum == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localRecvNum));
            }
            if (localBusiCodeTracker) {
                elementList.add(new javax.xml.namespace.QName("", "busiCode"));

                elementList.add(localBusiCode == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localBusiCode));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetReceiptRequest parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                GetReceiptRequest object = new GetReceiptRequest();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"getReceiptRequest".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (GetReceiptRequest) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "accountAuth")
                            .equals(reader.getName())) {

                        object.setAccountAuth(AccountAuth.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sendNum")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setSendNum(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNum")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setRecvNum(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "busiCode")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setBusiCode(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class ReceiptMessageArray implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * receiptMessageArray Namespace URI =
         * http://sms.protocol.intf.tisson.cn Namespace Prefix = ns2
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for ReceiptMessage This was an Array!
         */

        protected ReceiptMessage[] localReceiptMessage;

        /**
         * Auto generated getter method
         *
         * @return ReceiptMessage[]
         */
        public ReceiptMessage[] getReceiptMessage() {
            return localReceiptMessage;
        }

        /**
         * validate the array for ReceiptMessage
         */
        protected void validateReceiptMessage(ReceiptMessage[] param) {

            if ((param != null) && (param.length < 1)) {
                throw new RuntimeException();
            }

        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ReceiptMessage
         */
        public void setReceiptMessage(ReceiptMessage[] param) {

            validateReceiptMessage(param);

            this.localReceiptMessage = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param
         *            ReceiptMessage
         */
        public void addReceiptMessage(ReceiptMessage param) {
            if (localReceiptMessage == null) {
                localReceiptMessage = new ReceiptMessage[] {};
            }

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
                    .toList(localReceiptMessage);
            list.add(param);
            this.localReceiptMessage = (ReceiptMessage[]) list
                    .toArray(new ReceiptMessage[list.size()]);

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    ReceiptMessageArray.this.serialize(parentQName, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":receiptMessageArray",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "receiptMessageArray", xmlWriter);
                }

            }

            if (localReceiptMessage != null) {
                for (int i = 0; i < localReceiptMessage.length; i++) {
                    if (localReceiptMessage[i] != null) {
                        localReceiptMessage[i].serialize(
                                new javax.xml.namespace.QName("",
                                        "receiptMessage"), factory, xmlWriter);
                    } else {

                        throw new org.apache.axis2.databinding.ADBException(
                                "receiptMessage cannot be null!!");

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "receiptMessage cannot be null!!");

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localReceiptMessage != null) {
                for (int i = 0; i < localReceiptMessage.length; i++) {

                    if (localReceiptMessage[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("",
                                "receiptMessage"));
                        elementList.add(localReceiptMessage[i]);
                    } else {

                        throw new org.apache.axis2.databinding.ADBException(
                                "receiptMessage cannot be null !!");

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "receiptMessage cannot be null!!");

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ReceiptMessageArray parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                ReceiptMessageArray object = new ReceiptMessageArray();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"receiptMessageArray".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (ReceiptMessageArray) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("",
                            "receiptMessage").equals(reader.getName())) {

                        // Process the array and step past its final element's
                        // end.
                        list1.add(ReceiptMessage.Factory.parse(reader));

                        // loop until we find a start element that is not part
                        // of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement()
                                    && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                // two continuous end elements means we are
                                // exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("",
                                        "receiptMessage").equals(reader
                                        .getName())) {
                                    list1.add(ReceiptMessage.Factory
                                            .parse(reader));

                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility to convert and set the
                        // array

                        object.setReceiptMessage((ReceiptMessage[]) org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToArray(ReceiptMessage.class, list1));

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class RecvNumArray implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * recvNumArray Namespace URI = http://sms.protocol.intf.tisson.cn
         * Namespace Prefix = ns2
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for RecvNum This was an Array!
         */

        protected String[] localRecvNum;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String[]
         */
        public String[] getRecvNum() {
            return localRecvNum;
        }

        /**
         * validate the array for RecvNum
         */
        protected void validateRecvNum(String[] param) {

            if ((param != null) && (param.length < 1)) {
                throw new RuntimeException();
            }

        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNum
         */
        public void setRecvNum(String[] param) {

            validateRecvNum(param);

            this.localRecvNum = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param
         *            java.lang.String
         */
        public void addRecvNum(String param) {
            if (localRecvNum == null) {
                localRecvNum = new String[] {};
            }

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
                    .toList(localRecvNum);
            list.add(param);
            this.localRecvNum = (String[]) list
                    .toArray(new String[list.size()]);

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    RecvNumArray.this
                            .serialize(parentQName, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":recvNumArray",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "recvNumArray", xmlWriter);
                }

            }

            if (localRecvNum != null) {
                namespace = "";
                boolean emptyNamespace = namespace == null
                        || namespace.length() == 0;
                prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);
                for (int i = 0; i < localRecvNum.length; i++) {

                    if (localRecvNum[i] != null) {

                        if (!emptyNamespace) {
                            if (prefix == null) {
                                String prefix2 = generatePrefix(namespace);

                                xmlWriter.writeStartElement(prefix2, "recvNum",
                                        namespace);
                                xmlWriter.writeNamespace(prefix2, namespace);
                                xmlWriter.setPrefix(prefix2, namespace);

                            } else {
                                xmlWriter.writeStartElement(namespace,
                                        "recvNum");
                            }

                        } else {
                            xmlWriter.writeStartElement("recvNum");
                        }

                        xmlWriter
                                .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(localRecvNum[i]));

                        xmlWriter.writeEndElement();

                    } else {

                        throw new org.apache.axis2.databinding.ADBException(
                                "recvNum cannot be null!!");

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localRecvNum != null) {
                for (int i = 0; i < localRecvNum.length; i++) {

                    if (localRecvNum[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("",
                                "recvNum"));
                        elementList
                                .add(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(localRecvNum[i]));
                    } else {

                        throw new org.apache.axis2.databinding.ADBException(
                                "recvNum cannot be null!!");

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RecvNumArray parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                RecvNumArray object = new RecvNumArray();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"recvNumArray".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (RecvNumArray) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNum")
                            .equals(reader.getName())) {

                        // Process the array and step past its final element's
                        // end.
                        list1.add(reader.getElementText());

                        // loop until we find a start element that is not part
                        // of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // Ensure we are at the EndElement
                            while (!reader.isEndElement()) {
                                reader.next();
                            }
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement()
                                    && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                // two continuous end elements means we are
                                // exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("", "recvNum")
                                        .equals(reader.getName())) {
                                    list1.add(reader.getElementText());

                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility to convert and set the
                        // array

                        object.setRecvNum((String[]) list1
                                .toArray(new String[list1.size()]));

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class RecvSMSRequest implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "recvSMSRequest", "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for AccountAuth
         */

        protected AccountAuth localAccountAuth;

        /**
         * Auto generated getter method
         *
         * @return AccountAuth
         */
        public AccountAuth getAccountAuth() {
            return localAccountAuth;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            AccountAuth
         */
        public void setAccountAuth(AccountAuth param) {

            this.localAccountAuth = param;

        }

        /**
         * field for SendNum
         */

        protected String localSendNum;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localSendNumTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSendNum() {
            return localSendNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SendNum
         */
        public void setSendNum(String param) {

            if (param != null) {
                // update the setting tracker
                localSendNumTracker = true;
            } else {
                localSendNumTracker = true;

            }

            this.localSendNum = param;

        }

        /**
         * field for RecvNum
         */

        protected String localRecvNum;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localRecvNumTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getRecvNum() {
            return localRecvNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNum
         */
        public void setRecvNum(String param) {

            if (param != null) {
                // update the setting tracker
                localRecvNumTracker = true;
            } else {
                localRecvNumTracker = true;

            }

            this.localRecvNum = param;

        }

        /**
         * field for BusiCode
         */

        protected String localBusiCode;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localBusiCodeTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getBusiCode() {
            return localBusiCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            BusiCode
         */
        public void setBusiCode(String param) {

            if (param != null) {
                // update the setting tracker
                localBusiCodeTracker = true;
            } else {
                localBusiCodeTracker = true;

            }

            this.localBusiCode = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    RecvSMSRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":recvSMSRequest",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "recvSMSRequest", xmlWriter);
                }

            }

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            localAccountAuth.serialize(new javax.xml.namespace.QName("",
                    "accountAuth"), factory, xmlWriter);
            if (localSendNumTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "sendNum",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "sendNum");
                    }

                } else {
                    xmlWriter.writeStartElement("sendNum");
                }

                if (localSendNum == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localSendNum);

                }

                xmlWriter.writeEndElement();
            }
            if (localRecvNumTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "recvNum",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "recvNum");
                    }

                } else {
                    xmlWriter.writeStartElement("recvNum");
                }

                if (localRecvNum == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localRecvNum);

                }

                xmlWriter.writeEndElement();
            }
            if (localBusiCodeTracker) {
                namespace = "";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "busiCode",
                                namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "busiCode");
                    }

                } else {
                    xmlWriter.writeStartElement("busiCode");
                }

                if (localBusiCode == null) {
                    // write the nil attribute

                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);

                } else {

                    xmlWriter.writeCharacters(localBusiCode);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "accountAuth"));

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            elementList.add(localAccountAuth);
            if (localSendNumTracker) {
                elementList.add(new javax.xml.namespace.QName("", "sendNum"));

                elementList.add(localSendNum == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localSendNum));
            }
            if (localRecvNumTracker) {
                elementList.add(new javax.xml.namespace.QName("", "recvNum"));

                elementList.add(localRecvNum == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localRecvNum));
            }
            if (localBusiCodeTracker) {
                elementList.add(new javax.xml.namespace.QName("", "busiCode"));

                elementList.add(localBusiCode == null ? null
                        : org.apache.axis2.databinding.utils.ConverterUtil
                        .convertToString(localBusiCode));
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RecvSMSRequest parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                RecvSMSRequest object = new RecvSMSRequest();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"recvSMSRequest".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (RecvSMSRequest) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "accountAuth")
                            .equals(reader.getName())) {

                        object.setAccountAuth(AccountAuth.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sendNum")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setSendNum(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNum")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setRecvNum(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "busiCode")
                            .equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if (!"true".equals(nillableValue)
                                && !"1".equals(nillableValue)) {

                            String content = reader.getElementText();

                            object.setBusiCode(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(content));

                        } else {

                            reader.getElementText(); // throw away text nodes if
                            // any.
                        }

                        reader.next();

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class AccountAuth implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * accountAuth Namespace URI = http://common.protocol.intf.tisson.cn
         * Namespace Prefix = ns1
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://common.protocol.intf.tisson.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for Account
         */

        protected String localAccount;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getAccount() {
            return localAccount;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            Account
         */
        public void setAccount(String param) {

            this.localAccount = param;

        }

        /**
         * field for Password
         */

        protected String localPassword;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getPassword() {
            return localPassword;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            Password
         */
        public void setPassword(String param) {

            this.localPassword = param;

        }

        /**
         * field for HashCode
         */

        protected String localHashCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getHashCode() {
            return localHashCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            HashCode
         */
        public void setHashCode(String param) {

            this.localHashCode = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    AccountAuth.this.serialize(parentQName, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://common.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":accountAuth", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "accountAuth", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "account", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "account");
                }

            } else {
                xmlWriter.writeStartElement("account");
            }

            if (localAccount == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "account cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localAccount);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "password", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "password");
                }

            } else {
                xmlWriter.writeStartElement("password");
            }

            if (localPassword == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "password cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localPassword);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "hashCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "hashCode");
                }

            } else {
                xmlWriter.writeStartElement("hashCode");
            }

            if (localHashCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "hashCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localHashCode);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "account"));

            if (localAccount != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localAccount));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "account cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "password"));

            if (localPassword != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localPassword));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "password cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "hashCode"));

            if (localHashCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localHashCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "hashCode cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static AccountAuth parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                AccountAuth object = new AccountAuth();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"accountAuth".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (AccountAuth) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "account")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setAccount(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "password")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setPassword(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "hashCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setHashCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class ExtensionMapper {

        public static Object getTypeObject(
                String namespaceURI, String typeName,
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {

            if ("http://sms.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "recvNumArray".equals(typeName)) {

                return RecvNumArray.Factory.parse(reader);

            }

            if ("http://sms.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "recvMessageArray".equals(typeName)) {

                return RecvMessageArray.Factory.parse(reader);

            }

            if ("http://sms.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "recvMessage".equals(typeName)) {

                return RecvMessage.Factory.parse(reader);

            }

            if ("http://sms.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "receiptMessageArray".equals(typeName)) {

                return ReceiptMessageArray.Factory.parse(reader);

            }

            if ("http://common.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "filterResult".equals(typeName)) {

                return FilterResult.Factory.parse(reader);

            }

            if ("http://sms.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "receiptMessage".equals(typeName)) {

                return ReceiptMessage.Factory.parse(reader);

            }

            if ("http://common.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "filterArray".equals(typeName)) {

                return FilterArray.Factory.parse(reader);

            }

            if ("http://common.protocol.intf.tisson.cn".equals(namespaceURI)
                    && "accountAuth".equals(typeName)) {

                return AccountAuth.Factory.parse(reader);

            }

            throw new org.apache.axis2.databinding.ADBException(
                    "Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class FilterArray implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * filterArray Namespace URI = http://common.protocol.intf.tisson.cn
         * Namespace Prefix = ns1
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://common.protocol.intf.tisson.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for FilterResult This was an Array!
         */

        protected FilterResult[] localFilterResult;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localFilterResultTracker = false;

        /**
         * Auto generated getter method
         *
         * @return FilterResult[]
         */
        public FilterResult[] getFilterResult() {
            return localFilterResult;
        }

        /**
         * validate the array for FilterResult
         */
        protected void validateFilterResult(FilterResult[] param) {

        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            FilterResult
         */
        public void setFilterResult(FilterResult[] param) {

            validateFilterResult(param);

            if (param != null) {
                // update the setting tracker
                localFilterResultTracker = true;
            } else {
                localFilterResultTracker = false;

            }

            this.localFilterResult = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param
         *            FilterResult
         */
        public void addFilterResult(FilterResult param) {
            if (localFilterResult == null) {
                localFilterResult = new FilterResult[] {};
            }

            // update the setting tracker
            localFilterResultTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
                    .toList(localFilterResult);
            list.add(param);
            this.localFilterResult = (FilterResult[]) list
                    .toArray(new FilterResult[list.size()]);

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    FilterArray.this.serialize(parentQName, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://common.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":filterArray", xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "filterArray", xmlWriter);
                }

            }
            if (localFilterResultTracker) {
                if (localFilterResult != null) {
                    for (int i = 0; i < localFilterResult.length; i++) {
                        if (localFilterResult[i] != null) {
                            localFilterResult[i]
                                    .serialize(new javax.xml.namespace.QName(
                                                    "", "filterResult"), factory,
                                            xmlWriter);
                        } else {

                            // we don't have to do any thing since minOccures is
                            // zero

                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException(
                            "filterResult cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localFilterResultTracker) {
                if (localFilterResult != null) {
                    for (int i = 0; i < localFilterResult.length; i++) {

                        if (localFilterResult[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("",
                                    "filterResult"));
                            elementList.add(localFilterResult[i]);
                        } else {

                            // nothing to do

                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException(
                            "filterResult cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static FilterArray parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                FilterArray object = new FilterArray();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"filterArray".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (FilterArray) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "filterResult")
                            .equals(reader.getName())) {

                        // Process the array and step past its final element's
                        // end.
                        list1.add(FilterResult.Factory.parse(reader));

                        // loop until we find a start element that is not part
                        // of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement()
                                    && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                // two continuous end elements means we are
                                // exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("",
                                        "filterResult")
                                        .equals(reader.getName())) {
                                    list1.add(FilterResult.Factory
                                            .parse(reader));

                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility to convert and set the
                        // array

                        object.setFilterResult((FilterResult[]) org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToArray(FilterResult.class, list1));

                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class GetReceiptResponse implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "getReceiptResponse",
                "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for ResultCode
         */

        protected String localResultCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getResultCode() {
            return localResultCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ResultCode
         */
        public void setResultCode(String param) {

            this.localResultCode = param;

        }

        /**
         * field for ResultCount
         */

        protected int localResultCount;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getResultCount() {
            return localResultCount;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ResultCount
         */
        public void setResultCount(int param) {

            this.localResultCount = param;

        }

        /**
         * field for ReceiptMessageArray
         */

        protected ReceiptMessageArray localReceiptMessageArray;

        /*
         * This tracker boolean wil be used to detect whether the user called
         * the set method for this attribute. It will be used to determine
         * whether to include this field in the serialized XML
         */
        protected boolean localReceiptMessageArrayTracker = false;

        /**
         * Auto generated getter method
         *
         * @return ReceiptMessageArray
         */
        public ReceiptMessageArray getReceiptMessageArray() {
            return localReceiptMessageArray;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ReceiptMessageArray
         */
        public void setReceiptMessageArray(ReceiptMessageArray param) {

            if (param != null) {
                // update the setting tracker
                localReceiptMessageArrayTracker = true;
            } else {
                localReceiptMessageArrayTracker = true;

            }

            this.localReceiptMessageArray = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    GetReceiptResponse.this.serialize(MY_QNAME, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":getReceiptResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "getReceiptResponse", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter
                            .writeStartElement(prefix, "resultCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "resultCode");
                }

            } else {
                xmlWriter.writeStartElement("resultCode");
            }

            if (localResultCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localResultCode);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "resultCount",
                            namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "resultCount");
                }

            } else {
                xmlWriter.writeStartElement("resultCount");
            }

            if (localResultCount == Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "resultCount cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localResultCount));
            }

            xmlWriter.writeEndElement();
            if (localReceiptMessageArrayTracker) {
                if (localReceiptMessageArray == null) {

                    String namespace2 = "";

                    if (!namespace2.equals("")) {
                        String prefix2 = xmlWriter
                                .getPrefix(namespace2);

                        if (prefix2 == null) {
                            prefix2 = generatePrefix(namespace2);

                            xmlWriter.writeStartElement(prefix2,
                                    "receiptMessageArray", namespace2);
                            xmlWriter.writeNamespace(prefix2, namespace2);
                            xmlWriter.setPrefix(prefix2, namespace2);

                        } else {
                            xmlWriter.writeStartElement(namespace2,
                                    "receiptMessageArray");
                        }

                    } else {
                        xmlWriter.writeStartElement("receiptMessageArray");
                    }

                    // write the nil attribute
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance", "nil",
                            "1", xmlWriter);
                    xmlWriter.writeEndElement();
                } else {
                    localReceiptMessageArray.serialize(
                            new javax.xml.namespace.QName("",
                                    "receiptMessageArray"), factory, xmlWriter);
                }
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "resultCode"));

            if (localResultCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localResultCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "resultCount"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localResultCount));
            if (localReceiptMessageArrayTracker) {
                elementList.add(new javax.xml.namespace.QName("",
                        "receiptMessageArray"));

                elementList.add(localReceiptMessageArray == null ? null
                        : localReceiptMessageArray);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetReceiptResponse parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                GetReceiptResponse object = new GetReceiptResponse();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"getReceiptResponse".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (GetReceiptResponse) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "resultCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setResultCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "resultCount")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setResultCount(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToInt(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("",
                            "receiptMessageArray").equals(reader
                            .getName())) {

                        nillableValue = reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "nil");
                        if ("true".equals(nillableValue)
                                || "1".equals(nillableValue)) {
                            object.setReceiptMessageArray(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setReceiptMessageArray(ReceiptMessageArray.Factory
                                    .parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class SendSurveyRequest implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "sendSurveyRequest",
                "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for AccountAuth
         */

        protected AccountAuth localAccountAuth;

        /**
         * Auto generated getter method
         *
         * @return AccountAuth
         */
        public AccountAuth getAccountAuth() {
            return localAccountAuth;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            AccountAuth
         */
        public void setAccountAuth(AccountAuth param) {

            this.localAccountAuth = param;

        }

        /**
         * field for SBLSH
         */

        protected String localSBLSH;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSBLSH() {
            return localSBLSH;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SBLSH
         */
        public void setSBLSH(String param) {

            this.localSBLSH = param;

        }

        /**
         * field for SXBM
         */

        protected String localSXBM;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSXBM() {
            return localSXBM;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SXBM
         */
        public void setSXBM(String param) {

            this.localSXBM = param;

        }

        /**
         * field for SXMC
         */

        protected String localSXMC;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSXMC() {
            return localSXMC;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SXMC
         */
        public void setSXMC(String param) {

            this.localSXMC = param;

        }

        /**
         * field for BMMC
         */

        protected String localBMMC;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getBMMC() {
            return localBMMC;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            BMMC
         */
        public void setBMMC(String param) {

            this.localBMMC = param;

        }

        /**
         * field for SQRMC
         */

        protected String localSQRMC;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getSQRMC() {
            return localSQRMC;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SQRMC
         */
        public void setSQRMC(String param) {

            this.localSQRMC = param;

        }

        /**
         * field for LXRXM
         */

        protected String localLXRXM;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getLXRXM() {
            return localLXRXM;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            LXRXM
         */
        public void setLXRXM(String param) {

            this.localLXRXM = param;

        }

        /**
         * field for LXRSJ
         */

        protected String localLXRSJ;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getLXRSJ() {
            return localLXRSJ;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            LXRSJ
         */
        public void setLXRSJ(String param) {

            this.localLXRSJ = param;

        }

        /**
         * field for HJSJ
         */

        protected String localHJSJ;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getHJSJ() {
            return localHJSJ;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            HJSJ
         */
        public void setHJSJ(String param) {

            this.localHJSJ = param;

        }

        /**
         * field for HJMC
         */

        protected String localHJMC;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getHJMC() {
            return localHJMC;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            HJMC
         */
        public void setHJMC(String param) {

            this.localHJMC = param;

        }

        /**
         * field for HJZT
         */

        protected String localHJZT;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getHJZT() {
            return localHJZT;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            HJZT
         */
        public void setHJZT(String param) {

            this.localHJZT = param;

        }

        /**
         * field for CONTENT
         */

        protected String localCONTENT;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getCONTENT() {
            return localCONTENT;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            CONTENT
         */
        public void setCONTENT(String param) {

            this.localCONTENT = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    SendSurveyRequest.this.serialize(MY_QNAME, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":sendSurveyRequest",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "sendSurveyRequest", xmlWriter);
                }

            }

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            localAccountAuth.serialize(new javax.xml.namespace.QName("",
                    "accountAuth"), factory, xmlWriter);

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "SBLSH", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "SBLSH");
                }

            } else {
                xmlWriter.writeStartElement("SBLSH");
            }

            if (localSBLSH == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "SBLSH cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localSBLSH);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "SXBM", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "SXBM");
                }

            } else {
                xmlWriter.writeStartElement("SXBM");
            }

            if (localSXBM == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "SXBM cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localSXBM);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "SXMC", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "SXMC");
                }

            } else {
                xmlWriter.writeStartElement("SXMC");
            }

            if (localSXMC == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "SXMC cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localSXMC);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "BMMC", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "BMMC");
                }

            } else {
                xmlWriter.writeStartElement("BMMC");
            }

            if (localBMMC == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "BMMC cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localBMMC);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "SQRMC", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "SQRMC");
                }

            } else {
                xmlWriter.writeStartElement("SQRMC");
            }

            if (localSQRMC == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "SQRMC cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localSQRMC);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "LXRXM", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "LXRXM");
                }

            } else {
                xmlWriter.writeStartElement("LXRXM");
            }

            if (localLXRXM == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "LXRXM cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localLXRXM);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "LXRSJ", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "LXRSJ");
                }

            } else {
                xmlWriter.writeStartElement("LXRSJ");
            }

            if (localLXRSJ == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "LXRSJ cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localLXRSJ);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "HJSJ", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "HJSJ");
                }

            } else {
                xmlWriter.writeStartElement("HJSJ");
            }

            if (localHJSJ == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "HJSJ cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localHJSJ);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "HJMC", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "HJMC");
                }

            } else {
                xmlWriter.writeStartElement("HJMC");
            }

            if (localHJMC == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "HJMC cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localHJMC);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "HJZT", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "HJZT");
                }

            } else {
                xmlWriter.writeStartElement("HJZT");
            }

            if (localHJZT == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "HJZT cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localHJZT);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "CONTENT", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "CONTENT");
                }

            } else {
                xmlWriter.writeStartElement("CONTENT");
            }

            if (localCONTENT == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "CONTENT cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localCONTENT);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "accountAuth"));

            if (localAccountAuth == null) {
                throw new org.apache.axis2.databinding.ADBException(
                        "accountAuth cannot be null!!");
            }
            elementList.add(localAccountAuth);

            elementList.add(new javax.xml.namespace.QName("", "SBLSH"));

            if (localSBLSH != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSBLSH));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "SBLSH cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "SXBM"));

            if (localSXBM != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSXBM));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "SXBM cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "SXMC"));

            if (localSXMC != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSXMC));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "SXMC cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "BMMC"));

            if (localBMMC != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localBMMC));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "BMMC cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "SQRMC"));

            if (localSQRMC != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSQRMC));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "SQRMC cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "LXRXM"));

            if (localLXRXM != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localLXRXM));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "LXRXM cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "LXRSJ"));

            if (localLXRSJ != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localLXRSJ));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "LXRSJ cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "HJSJ"));

            if (localHJSJ != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localHJSJ));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "HJSJ cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "HJMC"));

            if (localHJMC != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localHJMC));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "HJMC cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "HJZT"));

            if (localHJZT != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localHJZT));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "HJZT cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "CONTENT"));

            if (localCONTENT != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localCONTENT));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "CONTENT cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static SendSurveyRequest parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                SendSurveyRequest object = new SendSurveyRequest();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"sendSurveyRequest".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (SendSurveyRequest) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "accountAuth")
                            .equals(reader.getName())) {

                        object.setAccountAuth(AccountAuth.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "SBLSH")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSBLSH(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "SXBM")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSXBM(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "SXMC")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSXMC(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "BMMC")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setBMMC(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "SQRMC")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSQRMC(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "LXRXM")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setLXRXM(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "LXRSJ")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setLXRSJ(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "HJSJ")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setHJSJ(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "HJMC")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setHJMC(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "HJZT")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setHJZT(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "CONTENT")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setCONTENT(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class FilterResult implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * filterResult Namespace URI = http://common.protocol.intf.tisson.cn
         * Namespace Prefix = ns1
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://common.protocol.intf.tisson.cn")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for RecvNum
         */

        protected String localRecvNum;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getRecvNum() {
            return localRecvNum;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvNum
         */
        public void setRecvNum(String param) {

            this.localRecvNum = param;

        }

        /**
         * field for FilterCode
         */

        protected String localFilterCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getFilterCode() {
            return localFilterCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            FilterCode
         */
        public void setFilterCode(String param) {

            this.localFilterCode = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    FilterResult.this
                            .serialize(parentQName, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://common.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":filterResult",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "filterResult", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "recvNum", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "recvNum");
                }

            } else {
                xmlWriter.writeStartElement("recvNum");
            }

            if (localRecvNum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localRecvNum);

            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter
                            .writeStartElement(prefix, "filterCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "filterCode");
                }

            } else {
                xmlWriter.writeStartElement("filterCode");
            }

            if (localFilterCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "filterCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localFilterCode);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "recvNum"));

            if (localRecvNum != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localRecvNum));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "recvNum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("", "filterCode"));

            if (localFilterCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localFilterCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "filterCode cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static FilterResult parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                FilterResult object = new FilterResult();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"filterResult".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (FilterResult) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvNum")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setRecvNum(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "filterCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setFilterCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class SendSurveyResponse implements
            org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://sms.protocol.intf.tisson.cn", "sendSurveyResponse",
                "ns2");

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for SessionId
         */

        protected long localSessionId;

        /**
         * Auto generated getter method
         *
         * @return long
         */
        public long getSessionId() {
            return localSessionId;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            SessionId
         */
        public void setSessionId(long param) {

            this.localSessionId = param;

        }

        /**
         * field for ResultCode
         */

        protected String localResultCode;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public String getResultCode() {
            return localResultCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            ResultCode
         */
        public void setResultCode(String param) {

            this.localResultCode = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    SendSurveyResponse.this.serialize(MY_QNAME, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":sendSurveyResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "sendSurveyResponse", xmlWriter);
                }

            }

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, "sessionId", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "sessionId");
                }

            } else {
                xmlWriter.writeStartElement("sessionId");
            }

            if (localSessionId == Long.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException(
                        "sessionId cannot be null!!");

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localSessionId));
            }

            xmlWriter.writeEndElement();

            namespace = "";
            if (!namespace.equals("")) {
                prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter
                            .writeStartElement(prefix, "resultCode", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, "resultCode");
                }

            } else {
                xmlWriter.writeStartElement("resultCode");
            }

            if (localResultCode == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");

            } else {

                xmlWriter.writeCharacters(localResultCode);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("", "sessionId"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
                    .convertToString(localSessionId));

            elementList.add(new javax.xml.namespace.QName("", "resultCode"));

            if (localResultCode != null) {
                elementList
                        .add(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(localResultCode));
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                        "resultCode cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static SendSurveyResponse parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                SendSurveyResponse object = new SendSurveyResponse();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"sendSurveyResponse".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (SendSurveyResponse) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "sessionId")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setSessionId(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToLong(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "resultCode")
                            .equals(reader.getName())) {

                        String content = reader.getElementText();

                        object.setResultCode(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    public static class RecvMessageArray implements
            org.apache.axis2.databinding.ADBBean {
        /*
         * This type was generated from the piece of schema that had name =
         * recvMessageArray Namespace URI = http://sms.protocol.intf.tisson.cn
         * Namespace Prefix = ns2
         */

        private static String generatePrefix(
                String namespace) {
            if (namespace.equals("http://sms.protocol.intf.tisson.cn")) {
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil
                    .getUniquePrefix();
        }

        /**
         * field for RecvMessage This was an Array!
         */

        protected RecvMessage[] localRecvMessage;

        /**
         * Auto generated getter method
         *
         * @return RecvMessage[]
         */
        public RecvMessage[] getRecvMessage() {
            return localRecvMessage;
        }

        /**
         * validate the array for RecvMessage
         */
        protected void validateRecvMessage(RecvMessage[] param) {

            if ((param != null) && (param.length < 1)) {
                throw new RuntimeException();
            }

        }

        /**
         * Auto generated setter method
         *
         * @param param
         *            RecvMessage
         */
        public void setRecvMessage(RecvMessage[] param) {

            validateRecvMessage(param);

            this.localRecvMessage = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param
         *            RecvMessage
         */
        public void addRecvMessage(RecvMessage param) {
            if (localRecvMessage == null) {
                localRecvMessage = new RecvMessage[] {};
            }

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
                    .toList(localRecvMessage);
            list.add(param);
            this.localRecvMessage = (RecvMessage[]) list
                    .toArray(new RecvMessage[list.size()]);

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(
                javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = Boolean.TRUE
                        .equals(reader
                                .getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory)
                throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName) {

                public void serialize(
                        MTOMAwareXMLStreamWriter xmlWriter)
                        throws javax.xml.stream.XMLStreamException {
                    RecvMessageArray.this.serialize(parentQName, factory,
                            xmlWriter);
                }
            };
            return new OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {

            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace,
                            parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix,
                            parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sms.protocol.intf.tisson.cn");
                if ((namespacePrefix != null)
                        && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", namespacePrefix + ":recvMessageArray",
                            xmlWriter);
                } else {
                    writeAttribute("xsi",
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "type", "recvMessageArray", xmlWriter);
                }

            }

            if (localRecvMessage != null) {
                for (int i = 0; i < localRecvMessage.length; i++) {
                    if (localRecvMessage[i] != null) {
                        localRecvMessage[i]
                                .serialize(new javax.xml.namespace.QName("",
                                        "recvMessage"), factory, xmlWriter);
                    } else {

                        throw new org.apache.axis2.databinding.ADBException(
                                "recvMessage cannot be null!!");

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "recvMessage cannot be null!!");

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter
                    .getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix
                            + ":"
                            + org.apache.axis2.databinding.utils.ConverterUtil
                            .convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter
                            .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                    .convertToString(qname));
                }

            } else {
                xmlWriter
                        .writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not
                // possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite
                                    .append(prefix)
                                    .append(":")
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        } else {
                            stringToWrite
                                    .append(org.apache.axis2.databinding.utils.ConverterUtil
                                            .convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite
                                .append(org.apache.axis2.databinding.utils.ConverterUtil
                                        .convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
                javax.xml.stream.XMLStreamWriter xmlWriter,
                String namespace)
                throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil
                            .getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(
                javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localRecvMessage != null) {
                for (int i = 0; i < localRecvMessage.length; i++) {

                    if (localRecvMessage[i] != null) {
                        elementList.add(new javax.xml.namespace.QName("",
                                "recvMessage"));
                        elementList.add(localRecvMessage[i]);
                    } else {

                        throw new org.apache.axis2.databinding.ADBException(
                                "recvMessage cannot be null !!");

                    }

                }
            } else {

                throw new org.apache.axis2.databinding.ADBException(
                        "recvMessage cannot be null!!");

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
                    qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RecvMessageArray parse(
                    javax.xml.stream.XMLStreamReader reader)
                    throws Exception {
                RecvMessageArray object = new RecvMessageArray();

                int event;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader
                            .getAttributeValue(
                                    "http://www.w3.org/2001/XMLSchema-instance",
                                    "type") != null) {
                        String fullTypeName = reader
                                .getAttributeValue(
                                        "http://www.w3.org/2001/XMLSchema-instance",
                                        "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName
                                    .substring(fullTypeName.indexOf(":") + 1);

                            if (!"recvMessageArray".equals(type)) {
                                // find namespace for the prefix
                                String nsUri = reader
                                        .getNamespaceContext().getNamespaceURI(
                                                nsPrefix);
                                return (RecvMessageArray) ExtensionMapper
                                        .getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ
                    // normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()
                            && new javax.xml.namespace.QName("", "recvMessage")
                            .equals(reader.getName())) {

                        // Process the array and step past its final element's
                        // end.
                        list1.add(RecvMessage.Factory.parse(reader));

                        // loop until we find a start element that is not part
                        // of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement()
                                    && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                // two continuous end elements means we are
                                // exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("",
                                        "recvMessage").equals(reader.getName())) {
                                    list1.add(RecvMessage.Factory.parse(reader));

                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility to convert and set the
                        // array

                        object.setRecvMessage((RecvMessage[]) org.apache.axis2.databinding.utils.ConverterUtil
                                .convertToArray(RecvMessage.class, list1));

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an
                        // invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a
                        // trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                                "Unexpected subelement "
                                        + reader.getLocalName());

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }

        }// end of factory class

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.RecvSMSRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.RecvSMSRequest.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.RecvSMSResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.RecvSMSResponse.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.SendSMSRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.SendSMSRequest.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.SendSMSResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.SendSMSResponse.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.GetReceiptRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.GetReceiptRequest.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.GetReceiptResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.GetReceiptResponse.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.SendSurveyRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.SendSurveyRequest.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(
             SMSServiceStub.SendSurveyResponse param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {
            return param
                    .getOMElement(
                             SMSServiceStub.SendSurveyResponse.MY_QNAME,
                            org.apache.axiom.om.OMAbstractFactory
                                    .getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
             SMSServiceStub.RecvSMSRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
                    .getDefaultEnvelope();
            emptyEnvelope
                    .getBody()
                    .addChild(
                            param.getOMElement(
                                     SMSServiceStub.RecvSMSRequest.MY_QNAME,
                                    factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
             SMSServiceStub.SendSMSRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
                    .getDefaultEnvelope();
            emptyEnvelope
                    .getBody()
                    .addChild(
                            param.getOMElement(
                                     SMSServiceStub.SendSMSRequest.MY_QNAME,
                                    factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
             SMSServiceStub.GetReceiptRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
                    .getDefaultEnvelope();
            emptyEnvelope
                    .getBody()
                    .addChild(
                            param.getOMElement(
                                     SMSServiceStub.GetReceiptRequest.MY_QNAME,
                                    factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
             SMSServiceStub.SendSurveyRequest param,
            boolean optimizeContent) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
                    .getDefaultEnvelope();
            emptyEnvelope
                    .getBody()
                    .addChild(
                            param.getOMElement(
                                     SMSServiceStub.SendSurveyRequest.MY_QNAME,
                                    factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(org.apache.axiom.om.OMElement param,
                                    Class type, java.util.Map extraNamespaces)
            throws org.apache.axis2.AxisFault {

        try {

            if ( SMSServiceStub.RecvSMSRequest.class
                    .equals(type)) {

                return  SMSServiceStub.RecvSMSRequest.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.RecvSMSResponse.class
                    .equals(type)) {

                return  SMSServiceStub.RecvSMSResponse.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.SendSMSRequest.class
                    .equals(type)) {

                return  SMSServiceStub.SendSMSRequest.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.SendSMSResponse.class
                    .equals(type)) {

                return  SMSServiceStub.SendSMSResponse.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.GetReceiptRequest.class
                    .equals(type)) {

                return  SMSServiceStub.GetReceiptRequest.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.GetReceiptResponse.class
                    .equals(type)) {

                return  SMSServiceStub.GetReceiptResponse.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.SendSurveyRequest.class
                    .equals(type)) {

                return  SMSServiceStub.SendSurveyRequest.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( SMSServiceStub.SendSurveyResponse.class
                    .equals(type)) {

                return  SMSServiceStub.SendSurveyResponse.Factory
                        .parse(param.getXMLStreamReaderWithoutCaching());

            }

        } catch (Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }

}
