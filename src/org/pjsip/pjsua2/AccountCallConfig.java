/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class AccountCallConfig extends PersistentObject {
  private long swigCPtr;

  protected AccountCallConfig(long cPtr, boolean cMemoryOwn) {
    super(pjsua2JNI.AccountCallConfig_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AccountCallConfig obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_AccountCallConfig(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setHoldType(pjsua_call_hold_type value) {
    pjsua2JNI.AccountCallConfig_holdType_set(swigCPtr, this, value.swigValue());
  }

  public pjsua_call_hold_type getHoldType() {
    return pjsua_call_hold_type.swigToEnum(pjsua2JNI.AccountCallConfig_holdType_get(swigCPtr, this));
  }

  public void setPrackUse(pjsua_100rel_use value) {
    pjsua2JNI.AccountCallConfig_prackUse_set(swigCPtr, this, value.swigValue());
  }

  public pjsua_100rel_use getPrackUse() {
    return pjsua_100rel_use.swigToEnum(pjsua2JNI.AccountCallConfig_prackUse_get(swigCPtr, this));
  }

  public void setTimerUse(pjsua_sip_timer_use value) {
    pjsua2JNI.AccountCallConfig_timerUse_set(swigCPtr, this, value.swigValue());
  }

  public pjsua_sip_timer_use getTimerUse() {
    return pjsua_sip_timer_use.swigToEnum(pjsua2JNI.AccountCallConfig_timerUse_get(swigCPtr, this));
  }

  public void setTimerMinSESec(long value) {
    pjsua2JNI.AccountCallConfig_timerMinSESec_set(swigCPtr, this, value);
  }

  public long getTimerMinSESec() {
    return pjsua2JNI.AccountCallConfig_timerMinSESec_get(swigCPtr, this);
  }

  public void setTimerSessExpiresSec(long value) {
    pjsua2JNI.AccountCallConfig_timerSessExpiresSec_set(swigCPtr, this, value);
  }

  public long getTimerSessExpiresSec() {
    return pjsua2JNI.AccountCallConfig_timerSessExpiresSec_get(swigCPtr, this);
  }

  public void readObject(ContainerNode node) throws java.lang.Exception {
    pjsua2JNI.AccountCallConfig_readObject(swigCPtr, this, ContainerNode.getCPtr(node), node);
  }

  public void writeObject(ContainerNode node) throws java.lang.Exception {
    pjsua2JNI.AccountCallConfig_writeObject(swigCPtr, this, ContainerNode.getCPtr(node), node);
  }

  public AccountCallConfig() {
    this(pjsua2JNI.new_AccountCallConfig(), true);
  }

}
