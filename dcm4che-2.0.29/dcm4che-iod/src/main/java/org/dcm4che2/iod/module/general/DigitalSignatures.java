/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is part of dcm4che, an implementation of DICOM(TM) in
 * Java(TM), hosted at http://sourceforge.net/projects/dcm4che.
 *
 * The Initial Developer of the Original Code is
 * Gunter Zeilinger, Huetteldorferstr. 24/10, 1150 Vienna/Austria/Europe.
 * Portions created by the Initial Developer are Copyright (C) 2002-2005
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 * Gunter Zeilinger <gunterze@gmail.com>
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

package org.dcm4che2.iod.module.general;

import java.util.Date;

import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomElement;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.data.VR;
import org.dcm4che2.iod.module.Module;
import org.dcm4che2.iod.module.macro.Code;

/**
 * @author gunter zeilinger(gunterze@gmail.com)
 * @version $Revision: 720 $ $Date: 2006-11-26 18:40:54 +0100 (So, 26 Nov 2006) $
 * @since Jun 16, 2006
 *
 */
public class DigitalSignatures extends Module {

    public DigitalSignatures(DicomObject dcmobj) {
        super(dcmobj);
    }

    public DigitalSignatures() {
        super(new BasicDicomObject());
    }

    public static DigitalSignatures[] toDigitalSignatures(DicomElement sq) {
        if (sq == null || !sq.hasItems()) {
            return null;
        }
        DigitalSignatures[] a = new DigitalSignatures[sq.countItems()];
        for (int i = 0; i < a.length; i++) {
            a[i] = new DigitalSignatures(sq.getDicomObject(i));
        }
        return a;
    }

    public int getMACIDNumber() {
        return dcmobj.getInt(Tag.MACIDNumber);
    }
    
    public void setMACIDNumber(int i) {
        dcmobj.putInt(Tag.MACIDNumber, VR.US, i);
    }
    
    public String getDigitalSignatureUID() {
        return dcmobj.getString(Tag.DigitalSignatureUID);
    }
    
    public void setDigitalSignatureUID(String s) {
        dcmobj.putString(Tag.DigitalSignatureUID, VR.UI, s);
    }

    public Date getDigitalSignatureDateTime() {
        return dcmobj.getDate(Tag.DigitalSignatureDateTime);
    }
    
    public void setDigitalSignatureDateTime(Date d) {
        dcmobj.putDate(Tag.DigitalSignatureDateTime, VR.DT, d);
    }
    
    public String getCertificateType() {
        return dcmobj.getString(Tag.CertificateType);
    }
    
    public void setCertificateType(String s) {
        dcmobj.putString(Tag.CertificateType, VR.CS, s);
    }

    public byte[] getCertificateOfSigner() {
        return dcmobj.getBytes(Tag.CertificateOfSigner);
    }
    
    public void setCertificateOfSigner(byte[] b) {
        dcmobj.putBytes(Tag.CertificateOfSigner, VR.OB, b);
    }

    public byte[] getSignature() {
        return dcmobj.getBytes(Tag.Signature);
    }
    
    public void setSignature(byte[] b) {
        dcmobj.putBytes(Tag.Signature, VR.OB, b);
    }

    public String getCertifiedTimestampType() {
        return dcmobj.getString(Tag.CertifiedTimestampType);
    }
    
    public void setCertifiedTimestampType(String s) {
        dcmobj.putString(Tag.CertifiedTimestampType, VR.CS, s);
    }

    public byte[] getCertifiedTimestamp() {
        return dcmobj.getBytes(Tag.CertifiedTimestamp);
    }
    
    public void setCertifiedTimestamp(byte[] b) {
        dcmobj.putBytes(Tag.CertifiedTimestamp, VR.OB, b);
    }
    
    public Code getDigitalSignaturePurposeCode() {
        DicomObject item = dcmobj.getNestedDicomObject(Tag.DigitalSignaturePurposeCodeSequence);
        return item != null ? new Code(item) : null;
    }
    
    public void setDigitalSignaturePurposeCode(Code code) {
        updateSequence(Tag.DigitalSignaturePurposeCodeSequence, code);
    }
}
