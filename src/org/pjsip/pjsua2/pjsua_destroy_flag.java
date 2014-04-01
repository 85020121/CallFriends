/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjsua_destroy_flag {
  public final static pjsua_destroy_flag PJSUA_DESTROY_NO_RX_MSG = new pjsua_destroy_flag("PJSUA_DESTROY_NO_RX_MSG", pjsua2JNI.PJSUA_DESTROY_NO_RX_MSG_get());
  public final static pjsua_destroy_flag PJSUA_DESTROY_NO_TX_MSG = new pjsua_destroy_flag("PJSUA_DESTROY_NO_TX_MSG", pjsua2JNI.PJSUA_DESTROY_NO_TX_MSG_get());
  public final static pjsua_destroy_flag PJSUA_DESTROY_NO_NETWORK = new pjsua_destroy_flag("PJSUA_DESTROY_NO_NETWORK", pjsua2JNI.PJSUA_DESTROY_NO_NETWORK_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjsua_destroy_flag swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjsua_destroy_flag.class + " with value " + swigValue);
  }

  private pjsua_destroy_flag(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjsua_destroy_flag(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjsua_destroy_flag(String swigName, pjsua_destroy_flag swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjsua_destroy_flag[] swigValues = { PJSUA_DESTROY_NO_RX_MSG, PJSUA_DESTROY_NO_TX_MSG, PJSUA_DESTROY_NO_NETWORK };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

