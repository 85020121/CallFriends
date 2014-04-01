/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class SipMediaType {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SipMediaType(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SipMediaType obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_SipMediaType(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(String value) {
    pjsua2JNI.SipMediaType_type_set(swigCPtr, this, value);
  }

  public String getType() {
    return pjsua2JNI.SipMediaType_type_get(swigCPtr, this);
  }

  public void setSubType(String value) {
    pjsua2JNI.SipMediaType_subType_set(swigCPtr, this, value);
  }

  public String getSubType() {
    return pjsua2JNI.SipMediaType_subType_get(swigCPtr, this);
  }

  public SipMediaType() {
    this(pjsua2JNI.new_SipMediaType(), true);
  }

}
