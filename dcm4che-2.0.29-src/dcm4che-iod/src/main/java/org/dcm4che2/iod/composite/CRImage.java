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

package org.dcm4che2.iod.composite;

import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.iod.module.composite.ContrastBolusModule;
import org.dcm4che2.iod.module.composite.DeviceModule;
import org.dcm4che2.iod.module.cr.CRImageModule;
import org.dcm4che2.iod.module.cr.CRSeriesModule;
import org.dcm4che2.iod.module.lut.ModalityLutModule;
import org.dcm4che2.iod.module.lut.VoiLutModule;
import org.dcm4che2.iod.module.overlay.OverlayPlaneModule;
import org.dcm4che2.iod.validation.ValidationContext;
import org.dcm4che2.iod.validation.ValidationResult;

/**
 * @author gunter zeilinger(gunterze@gmail.com)
 * @version $Revision: 5516 $ $Date: 2007-11-23 12:42:30 +0100 (Fr, 23 Nov 2007) $
 * @since Jun 9, 2006
 *
 */
public class CRImage extends Image {

    protected final ContrastBolusModule contrastBolusModule;
    protected final DeviceModule deviceModule;
    protected final OverlayPlaneModule overlayPlaneModule;
    protected final ModalityLutModule modalityLUTModule;
    protected final VoiLutModule voiLUTModule;
    
    public CRImage(DicomObject dcmobj) {
        super(dcmobj, new CRSeriesModule(dcmobj), new CRImageModule(dcmobj));
        this.contrastBolusModule = new ContrastBolusModule(dcmobj);
        this.deviceModule = new DeviceModule(dcmobj);
        this.overlayPlaneModule = new OverlayPlaneModule(dcmobj);
        this.modalityLUTModule = new ModalityLutModule(dcmobj);
        this.voiLUTModule = new VoiLutModule(dcmobj);
    }

    public CRImage() {
        this(new BasicDicomObject());
    }


    @Override
    public void init() {
        super.init();
        contrastBolusModule.init();
        deviceModule.init();
        overlayPlaneModule.init();
        modalityLUTModule.init();
        voiLUTModule.init();
    }

    @Override
    public void validate(ValidationContext ctx, ValidationResult result) {
        super.validate(ctx, result);
        contrastBolusModule.validate(ctx, result);
        deviceModule.validate(ctx, result);
        overlayPlaneModule.validate(ctx, result);
        modalityLUTModule.validate(ctx, result);
        voiLUTModule.validate(ctx, result);
    }
    
    public final CRSeriesModule getCrSeriesModule() {
        return (CRSeriesModule) generalSeriesModule;
    }
    
    public final ContrastBolusModule getContrastBolusModule() {
        return contrastBolusModule;
    }

    public final DeviceModule getDeviceModule() {
        return deviceModule;
    }
    
    public final CRImageModule getCRImageModule() {
        return (CRImageModule) generalImageModule;
    }

    public final OverlayPlaneModule getOverlayPlaneModule() {
        return overlayPlaneModule;
    }

    public final ModalityLutModule getModalityLUTModule() {
        return modalityLUTModule;
    }
    
    public final VoiLutModule getVOILUTModule() {
        return voiLUTModule;
    }
}
