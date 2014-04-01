/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class SendTypingIndicationParam {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SendTypingIndicationParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SendTypingIndicationParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_SendTypingIndicationParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIsTyping(boolean value) {
    pjsua2JNI.SendTypingIndicationParam_isTyping_set(swigCPtr, this, value);
  }

  public boolean getIsTyping() {
    return pjsua2JNI.SendTypingIndicationParam_isTyping_get(swigCPtr, this);
  }

  public void setTxOption(SipTxOption value) {
    pjsua2JNI.SendTypingIndicationParam_txOption_set(swigCPtr, this, SipTxOption.getCPtr(value), value);
  }

  public SipTxOption getTxOption() {
    long cPtr = pjsua2JNI.SendTypingIndicationParam_txOption_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SipTxOption(cPtr, false);
  }

  public SendTypingIndicationParam() {
    this(pjsua2JNI.new_SendTypingIndicationParam(), true);
  }

}
