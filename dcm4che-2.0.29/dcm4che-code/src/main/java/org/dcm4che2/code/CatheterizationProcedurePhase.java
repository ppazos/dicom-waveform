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
 * Java(TM), available at http://sourceforge.net/projects/dcm4che.
 *
 * The Initial Developer of the Original Code is
 * Agfa HealthCare.
 * Portions created by the Initial Developer are Copyright (C) 2010
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 * See listed authors below.
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

package org.dcm4che2.code;

/**
 * CID 3250 Catheterization Procedure Phase.
 *
 * @author Gunter Zeilinger <gunterze@gmail.com>
 * @version $Rev: 13502 $ $Date:: 2010-06-09#$
 * @since Jun 2, 2010
 */
public class CatheterizationProcedurePhase {

  /** (G-7299, SRT, "Cardiac catheterization bailout phase") */
  public static final String CardiacCatheterizationBailoutPhase = "G-7299\\SRT";

  /** (G-7293, SRT, "Cardiac catheterization baseline phase") */
  public static final String CardiacCatheterizationBaselinePhase = "G-7293\\SRT";

  /** (G-7294, SRT, "Cardiac catheterization image acquisition phase") */
  public static final String CardiacCatheterizationImageAcquisitionPhase = "G-7294\\SRT";

  /** (G-7295, SRT, "Cardiac catheterization intervention phase") */
  public static final String CardiacCatheterizationInterventionPhase = "G-7295\\SRT";

  /** (G-729B, SRT, "Cardiac catheterization post contrast phase") */
  public static final String CardiacCatheterizationPostContrastPhase = "G-729B\\SRT";

  /** (G-7298, SRT, "Cardiac catheterization post-intervention phase") */
  public static final String CardiacCatheterizationPostInterventionPhase = "G-7298\\SRT";

  /** (G-7296, SRT, "Cardiac catheterization pre-intervention phase") */
  public static final String CardiacCatheterizationPreInterventionPhase = "G-7296\\SRT";

  /** (G-929D, SRT, "Cardiac catheterization test/challenging phase") */
  public static final String CardiacCatheterizationTestChallengingPhase = "G-929D\\SRT";

  /** (G-7297, SRT, "Cardiac catheterization therapy phase") */
  public static final String CardiacCatheterizationTherapyPhase = "G-7297\\SRT";

  /** (P1-3160A, SRT, "Catheterization of both left and right heart with graft") */
  public static final String CatheterizationOfBothLeftAndRightHeartWithGraft = "P1-3160A\\SRT";

  /** (P1-3160B, SRT, "Catheterization of both left and right heart without graft") */
  public static final String CatheterizationOfBothLeftAndRightHeartWithoutGraft = "P1-3160B\\SRT";

  /** (P1-31604, SRT, "Catheterization of left heart") */
  public static final String CatheterizationOfLeftHeart = "P1-31604\\SRT";

  /** (P1-31602, SRT, "Catheterization of right heart") */
  public static final String CatheterizationOfRightHeart = "P1-31602\\SRT";

  /** (P2-71317, SRT, "Drug Infusion Challenge") */
  public static final String DrugInfusionChallenge = "P2-71317\\SRT";

  /** (P2-71310, SRT, "Exercise challenge") */
  public static final String ExerciseChallenge = "P2-71310\\SRT";

  /** (F-01604, SRT, "Resting State") */
  public static final String RestingState = "F-01604\\SRT";

  /** (P1-31612, SRT, "Transseptal catheterization") */
  public static final String TransseptalCatheterization = "P1-31612\\SRT";
}
