/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjmedia_srtp_use {
  public final static pjmedia_srtp_use PJMEDIA_SRTP_DISABLED = new pjmedia_srtp_use("PJMEDIA_SRTP_DISABLED");
  public final static pjmedia_srtp_use PJMEDIA_SRTP_OPTIONAL = new pjmedia_srtp_use("PJMEDIA_SRTP_OPTIONAL");
  public final static pjmedia_srtp_use PJMEDIA_SRTP_MANDATORY = new pjmedia_srtp_use("PJMEDIA_SRTP_MANDATORY");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjmedia_srtp_use swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjmedia_srtp_use.class + " with value " + swigValue);
  }

  private pjmedia_srtp_use(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjmedia_srtp_use(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjmedia_srtp_use(String swigName, pjmedia_srtp_use swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjmedia_srtp_use[] swigValues = { PJMEDIA_SRTP_DISABLED, PJMEDIA_SRTP_OPTIONAL, PJMEDIA_SRTP_MANDATORY };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

