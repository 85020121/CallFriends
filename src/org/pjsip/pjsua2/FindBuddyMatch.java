/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class FindBuddyMatch {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected FindBuddyMatch(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(FindBuddyMatch obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_FindBuddyMatch(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    pjsua2JNI.FindBuddyMatch_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    pjsua2JNI.FindBuddyMatch_change_ownership(this, swigCPtr, true);
  }

  public boolean match(String token, Buddy buddy) {
    return (getClass() == FindBuddyMatch.class) ? pjsua2JNI.FindBuddyMatch_match(swigCPtr, this, token, Buddy.getCPtr(buddy), buddy) : pjsua2JNI.FindBuddyMatch_matchSwigExplicitFindBuddyMatch(swigCPtr, this, token, Buddy.getCPtr(buddy), buddy);
  }

  public FindBuddyMatch() {
    this(pjsua2JNI.new_FindBuddyMatch(), true);
    pjsua2JNI.FindBuddyMatch_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

}
