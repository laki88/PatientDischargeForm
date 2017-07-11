<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="xml" indent="yes"/>
    <xsl:variable name="base_path" select="/formData/base-path"/>
    <xsl:template match="/formData">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simple" page-height="29.7cm" page-width="21cm" margin-top=".5cm" margin-bottom=".5cm" margin-left=".5cm" margin-right=".5cm">
                    <fo:region-body region-name="xsl-region-body" margin-bottom=".5cm" margin-top="1cm"/>
                    <fo:region-before region-name="xsl-region-before" extent=".5cm" />
                    <fo:region-after region-name="xsl-region-after" extent=".5cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simple">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block font-size="10pt" font-weight="bold" text-align="center">
                        <![CDATA[
                        Department of Obstetrics & Gynecology
                        Professional Unit - Teaching Hospital,Anuradhapura
                        ]]>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                        </fo:block>
                </fo:static-content>
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block font-size="8pt" text-align="center">
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>

                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block break-after="page" font-size="8pt" linefeed-treatment="preserve">
                        <fo:table >
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Name of Patient : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="patientName"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Age : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="age"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Date of Admission : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="dateOfAdmission"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Date of Discharge : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="dateOfDischarge"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> G: <xsl:value-of select="g"/> P: <xsl:value-of select="p"/> C: <xsl:value-of select="c"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> POG : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="pog"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> BHT No: </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="bhtNo"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Blood Group : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="bloodGroup"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> Lower Segment Cesarean Section </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> <fo:external-graphic src="url('{$base_path}{/formData/elective}')" content-height="0.25cm"/> Elective </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <fo:external-graphic src="url('{$base_path}{/formData/emergency}')" content-height="0.25cm"/> Emergency </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Indication :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="indication"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Spinal Anaesthesia : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="spinalDr"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Surgeon :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="surgeon"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Assistant : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="assistant"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Procedure and Findings :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block><![CDATA[Incision : pfannenstiel Uneventful entry into the peritoneal cavity Bladder deflected by blunt dissection Routine LSCS done. Live non asphyxiated baby deliver. Liquor clear. Uterus, Tubes & Overies normal. Placenta complete. Uterus closed in two layers. Routine closure no. 2 vycryl to Rectus.]]>
                                            Skin closure with sub cut,
                                            <fo:external-graphic src="url('{$base_path}{/formData/monocryl}')" content-height="0.25cm"/>Monocryl <fo:external-graphic src="url('{$base_path}{/formData/interruptedNylon}')" content-height="0.25cm"/>Interrupted nylon <fo:external-graphic src="url('{$base_path}{/formData/staples}')" content-height="0.25cm"/>Staples
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Post op Instructions : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="postOpInstructions"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Date of Birth :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="dateOfBirth"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Time of Birth : </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="timeOfBirth"/> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Baby Boy/Girl :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="gender"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Birth Weight :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="birthWeight"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Apgar at Birth :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="apgarAtBirth"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Apgar at 5min :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="apgarAt5min"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Investigation :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="investigation"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> Contraceptive Advice :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="contraceptiveAdvice"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> HO/SHO :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> <xsl:value-of select="hoSho"/> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block>
                                            .……………………………………………………………………….
                                            <![CDATA[Dr. Nandana Hettigama,
                                            Senior Consultant Obstetrician & Gynaecologist,
                                            Professional Clinical Unit, Teaching hospital, Anuradhapura
                                            ]]>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="right">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="6pt" text-align="left">
                                        <fo:block> </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                        <!--<fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>-->
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>