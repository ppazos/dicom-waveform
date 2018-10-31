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

package org.dcm4che2.net;

import java.io.IOException;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.data.VR;

/**
 * @author gunter zeilinger(gunterze@gmail.com)
 * @version $Revision: 835 $ $Date: 2007-06-27 05:49:29 +0200 (Mi, 27 Jun 2007) $
 * @since Mar 5, 2006
 *
 */
public class DicomServiceException extends IOException {
    
    private static final long serialVersionUID = -5858536886871974350L;

    final DicomObject rsp;
    private DicomObject data;
    
    public DicomServiceException(DicomObject rq, int status) {
        super();
        rsp = CommandUtils.mkRSP(rq, status);
    }

    public DicomServiceException(DicomObject rq, int status, String message) {
        super(message);
        rsp = CommandUtils.mkRSP(rq, status);
        if (message != null && message.length() > 64)
            message = message.substring(0, 64);
        setErrorComment(message);
    }

    public void setErrorComment(String val) {
        rsp.putString(Tag.ErrorComment, VR.LO, val);        
    }
    
    public void setErrorID(int val) {
        rsp.putInt(Tag.ErrorID, VR.US, val);        
    }
    
    public final DicomObject getCommand() {
        return rsp;
    }

    public final DicomObject getDataset() {
        return data;
    }

    public final void setData(DicomObject data) {
        this.data = data;
    }

}