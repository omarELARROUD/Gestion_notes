<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:date="http://exslt.org/dates-and-times"
>

    <xsl:template match="/student">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="carte" page-height="5.4cm" page-width="8.5cm" margin-top="2.5mm" margin-bottom="2mm" margin-left="5mm" margin-right="5mm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="carte">
                <fo:flow flow-name="xsl-region-body" >
                    <fo:block>
                        <fo:table height="1cm" width="100%">
                            <fo:table-column
                                             column-width="10%"/>
                            <fo:table-column
                                             column-width="80%"/>
                            <fo:table-column
                                             column-width="10%"/>
                            <fo:table-body>
                                <fo:table-cell column-number="1" text-align="right">
                                    <fo:block>
                                        <fo:external-graphic height="0.1cm" width="1cm" content-height="1cm"
                                                         content-width="1cm" src="url('src/main/db/images/uae.png')"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell column-number="2"  >
                                    <fo:block-container space-before="1cm" width="100%" font-size="7px" text-align="center" color="#0C2158">
                                        <fo:block>Université Abdelmaled Essadi</fo:block>
                                        <fo:block>Ecole national des sciences appliquées</fo:block>
                                        <fo:block>de Tanger</fo:block>

                                    </fo:block-container>
                                </fo:table-cell>
                                <fo:table-cell text-align="left" column-number="3">
                                    <fo:block>
                                        <fo:external-graphic height="0.1cm" width="1cm" content-height="1cm"
                                                         content-width="1cm" src="url('src/main/db/images/ensat.jpg')"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block border-bottom-width="1px" width="2.5cm" border-bottom-style="solid" border-color="#e08128" margin-top="4mm"/>
                    <fo:block space-before="0.2cm" font-size="9px" text-align="center" color="#0C2158">Carte D'Etudiant</fo:block>
                    <fo:table height="1cm" space-before="0.5cm" width="100%">
                        <fo:table-column
                                column-width="25%"/>
                        <fo:table-column
                                column-width="50%"/>
                        <fo:table-column
                                column-width="25%"/>
                        <fo:table-footer>
                            <fo:table-cell column-number="2" text-align="center" >
                                <fo:block-container width="100%" font-size="5px" text-align="center" color="#0C2158">
                                    <fo:block>Première Inscription : <xsl:value-of select="@Inscription"/> </fo:block>
                                </fo:block-container>
                            </fo:table-cell>
                        </fo:table-footer>
                        <fo:table-body>
                            <fo:table-cell column-number="1">
                                <fo:block>
                                    <fo:block> <fo:external-graphic height="2.1cm" width="1.5cm" content-height="2.1cm"
                                        content-width="1.5cm" src="url({Photo})"/></fo:block>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell  column-number="2"  >
                                <fo:block-container  font-size="8px" text-align="left" color="#0C2158" margin-top="4mm">
                                    <fo:block> <xsl:value-of select="FirstName"/> </fo:block>
                                    <fo:block> <xsl:value-of select="LastName"/> </fo:block>
                                    <fo:block> <xsl:value-of select="@Capoge"/> </fo:block>
                                </fo:block-container>
                            </fo:table-cell>
                            <fo:table-cell text-align="left" column-number="3">
                                <fo:block space-start="4cm">
                                    <fo:external-graphic height="1.5cm" width="1.5cm" content-height="1.5cm"
                                                         content-width="1.5cm" src="url('src/main/db/images/qrcode.png')"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-body>

                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>