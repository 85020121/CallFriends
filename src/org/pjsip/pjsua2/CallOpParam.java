/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class CallOpParam {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CallOpParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CallOpParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_CallOpParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setOpt(CallSetting value) {
    pjsua2JNI.CallOpParam_opt_set(swigCPtr, this, CallSetting.getCPtr(value), value);
  }

  public CallSetting getOpt() {
    long cPtr = pjsua2JNI.CallOpParam_opt_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CallSetting(cPtr, false);
  }

  public void setStatusCode(pjsip_status_code value) {
    pjsua2JNI.CallOpParam_statusCode_set(swigCPtr, this, value.swigValue());
  }

  public pjsip_status_code getStatusCode() {
    return pjsip_status_code.swigToEnum(pjsua2JNI.CallOpParam_statusCode_get(swigCPtr, this));
  }

  public void setReason(String value) {
    pjsua2JNI.CallOpParam_reason_set(swigCPtr, this, value);
  }

  public String getReason() {
    return pjsua2JNI.CallOpParam_reason_get(swigCPtr, this);
  }

  public void setOptions(long value) {
    pjsua2JNI.CallOpParam_options_set(swigCPtr, this, value);
  }

  public long getOptions() {
    return pjsua2JNI.CallOpParam_options_get(swigCPtr, this);
  }

  public void setTxOption(SipTxOption value) {
    pjsua2JNI.CallOpParam_txOption_set(swigCPtr, this, SipTxOption.getCPtr(value), value);
  }

  public SipTxOption getTxOption() {
    long cPtr = pjsua2JNI.CallOpParam_txOption_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SipTxOption(cPtr, false);
  }

  public CallOpParam(boolean useDefaultCallSetting) {
    this(pjsua2JNI.new_CallOpParam__SWIG_0(useDefaultCallSetting), true);
  }

  public CallOpParam() {
    this(pjsua2JNI.new_CallOpParam__SWIG_1(), true);
  }

}
