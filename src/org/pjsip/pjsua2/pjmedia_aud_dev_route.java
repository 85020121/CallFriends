/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjmedia_aud_dev_route {
  public final static pjmedia_aud_dev_route PJMEDIA_AUD_DEV_ROUTE_DEFAULT = new pjmedia_aud_dev_route("PJMEDIA_AUD_DEV_ROUTE_DEFAULT", pjsua2JNI.PJMEDIA_AUD_DEV_ROUTE_DEFAULT_get());
  public final static pjmedia_aud_dev_route PJMEDIA_AUD_DEV_ROUTE_LOUDSPEAKER = new pjmedia_aud_dev_route("PJMEDIA_AUD_DEV_ROUTE_LOUDSPEAKER", pjsua2JNI.PJMEDIA_AUD_DEV_ROUTE_LOUDSPEAKER_get());
  public final static pjmedia_aud_dev_route PJMEDIA_AUD_DEV_ROUTE_EARPIECE = new pjmedia_aud_dev_route("PJMEDIA_AUD_DEV_ROUTE_EARPIECE", pjsua2JNI.PJMEDIA_AUD_DEV_ROUTE_EARPIECE_get());
  public final static pjmedia_aud_dev_route PJMEDIA_AUD_DEV_ROUTE_BLUETOOTH = new pjmedia_aud_dev_route("PJMEDIA_AUD_DEV_ROUTE_BLUETOOTH", pjsua2JNI.PJMEDIA_AUD_DEV_ROUTE_BLUETOOTH_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjmedia_aud_dev_route swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjmedia_aud_dev_route.class + " with value " + swigValue);
  }

  private pjmedia_aud_dev_route(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjmedia_aud_dev_route(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjmedia_aud_dev_route(String swigName, pjmedia_aud_dev_route swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjmedia_aud_dev_route[] swigValues = { PJMEDIA_AUD_DEV_ROUTE_DEFAULT, PJMEDIA_AUD_DEV_ROUTE_LOUDSPEAKER, PJMEDIA_AUD_DEV_ROUTE_EARPIECE, PJMEDIA_AUD_DEV_ROUTE_BLUETOOTH };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

