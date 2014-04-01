/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class SdpSession {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SdpSession(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SdpSession obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_SdpSession(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setWholeSdp(String value) {
    pjsua2JNI.SdpSession_wholeSdp_set(swigCPtr, this, value);
  }

  public String getWholeSdp() {
    return pjsua2JNI.SdpSession_wholeSdp_get(swigCPtr, this);
  }

  public void setPjSdpSession(SWIGTYPE_p_void value) {
    pjsua2JNI.SdpSession_pjSdpSession_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getPjSdpSession() {
    long cPtr = pjsua2JNI.SdpSession_pjSdpSession_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public SdpSession() {
    this(pjsua2JNI.new_SdpSession(), true);
  }

}
