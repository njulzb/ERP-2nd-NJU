-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: 4stars
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bankaccount`
--

DROP TABLE IF EXISTS `bankaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bankaccount` (
  `id` varchar(80) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `moneyLeft` double NOT NULL DEFAULT '0',
  `password` varchar(50) DEFAULT NULL,
  `imgByte` blob,
  `lintNum` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`lintNum`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankaccount`
--

LOCK TABLES `bankaccount` WRITE;
/*!40000 ALTER TABLE `bankaccount` DISABLE KEYS */;
INSERT INTO `bankaccount` VALUES ('2212','setwe',0,'','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0seú\0\0\0sRGB\0®\Î\é\0\0\0gAMA\0\0±üa\0\0\0	pHYs\0\0\Ã\0\0\Ã\Ço¨d\0\0½IDATx^\íšİ•\Â …ÓŒ¤\ëğ\ØE*ğ\Õ.|°K\Ù2ó3™\\†	 F÷ºs¾‡½&\ÜÀ€›\æòó] ¦5=¨\éAMjzPÓƒš\Ôô ¦5=¨\éA\íqm†\Ø_£K1·f\×4|ø v8ŸFÃ\é¡‘õh&¤ü‚h›sTj“C;–oD¨riRbw\Âr|şª\áRŸ\Â\ìûòƒ™\î\Øÿ¥k*\Ê\íB\Æ\êW8j›Ä \rqoGújˆ\Ã-*­„¯3,\Ùô`9\êU\â!-¹7´ilbavy\Ó\ÄZ=\Ô&C\Ûqœ\Û:,W\ì†%\ã\Í†5\Æ,\İ(µ\Ö6‘d©^\êbPq·u¦	jY!2\ã\Ñ/\Ò2ù·\Í~r\ÎlX&0¥«µ\á{{\Êµƒöd\Ş\æ£n(\'i¸¢\ï$¨t#r¢Ú°®h0c\Z6?\\µ\Ã6†,uzºV^4ªQ;ˆ\áW\r\é~\Ï`\å\Ä{\Ö\ÓC\Éµ\ÃK{_ö›ó\æXúR\Úá¥†\ÃKõÜ½V§™+^¡P;d\Õ\Ì\ÛL\ÂRT\á¡\Ôô ¦5=¨\éAMjzPÓƒš\Ôô ¦5=¨\éAMjzPÓƒú\í8[su»v\0j\ØmÊŠ#’\ÃY—òAmó½†\ÕöšTo\ì]M›\Æ<†½\Ìp\Ï3\çG‘\Ô6K\Ã+m¢2\Ü.“YF¸Jò{õL†»SºŸ\å¸\à59üP\ÛD9¬»t¹\Êc8ŠÁR\êW/=\Ï\Ïr8\"¶»z8\ëCœÈ ¶‰†t\ê8olGµ\áôP‚\Ø\Úğ\Õ\Êq\Ö\ZvE!65£\ÎpUkx\ÎóÉª64<™IÅ½“\ë«‘’òó\Ãp	\äa)®2¬§\Ã\Ô\Ùò\æ†£À°8‰ñ\à1¬\çg&\ê\áÉ³ÿ/‘\ÃÕ“\ÖZù[&5=¨\éAMjzPÓƒš\Ôô ¦5=¨¹¹üü\á	¸6¾È‚\0\0\0\0IEND®B`‚',18),('00000aa','???',0,'','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0seú\0\0\0sRGB\0®\Î\é\0\0\0gAMA\0\0±üa\0\0\0	pHYs\0\0\Ã\0\0\Ã\Ço¨d\0\0½IDATx^\íšİ•\Â …ÓŒ¤\ëğ\ØE*ğ\Õ.|°K\Ù2ó3™\\†	 F÷ºs¾‡½&\ÜÀ€›\æòó] ¦5=¨\éAMjzPÓƒš\Ôô ¦5=¨\éA\íqm†\Ø_£K1·f\×4|ø v8ŸFÃ\é¡‘õh&¤ü‚h›sTj“C;–oD¨riRbw\Âr|şª\áRŸ\Â\ìûòƒ™\î\Øÿ¥k*\Ê\íB\Æ\êW8j›Ä \rqoGújˆ\Ã-*­„¯3,\Ùô`9\êU\â!-¹7´ilbavy\Ó\ÄZ=\Ô&C\Ûqœ\Û:,W\ì†%\ã\Í†5\Æ,\İ(µ\Ö6‘d©^\êbPq·u¦	jY!2\ã\Ñ/\Ò2ù·\Í~r\ÎlX&0¥«µ\á{{\Êµƒöd\Ş\æ£n(\'i¸¢\ï$¨t#r¢Ú°®h0c\Z6?\\µ\Ã6†,uzºV^4ªQ;ˆ\áW\r\é~\Ï`\å\Ä{\Ö\ÓC\Éµ\ÃK{_ö›ó\æXúR\Úá¥†\ÃKõÜ½V§™+^¡P;d\Õ\Ì\ÛL\ÂRT\á¡\Ôô ¦5=¨\éAMjzPÓƒš\Ôô ¦5=¨\éAMjzPÓƒú\í8[su»v\0j\ØmÊŠ#’\ÃY—òAmó½†\ÕöšTo\ì]M›\Æ<†½\Ìp\Ï3\çG‘\Ô6K\Ã+m¢2\Ü.“YF¸Jò{õL†»SºŸ\å¸\à59üP\ÛD9¬»t¹\Êc8ŠÁR\êW/=\Ï\Ïr8\"¶»z8\ëCœÈ ¶‰†t\ê8olGµ\áôP‚\Ø\Úğ\Õ\Êq\Ö\ZvE!65£\ÎpUkx\ÎóÉª64<™IÅ½“\ë«‘’òó\Ãp	\äa)®2¬§\Ã\Ô\Ùò\æ†£À°8‰ñ\à1¬\çg&\ê\áÉ³ÿ/‘\ÃÕ“\ÖZù[&5=¨\éAMjzPÓƒš\Ôô ¦5=¨¹¹üü\á	¸6¾È‚\0\0\0\0IEND®B`‚',21),('000003','???',0,'','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0seú\0\0\0sRGB\0®\Î\é\0\0\0gAMA\0\0±üa\0\0\0	pHYs\0\0\Ã\0\0\Ã\Ço¨d\0\0½IDATx^\íšİ•\Â …ÓŒ¤\ëğ\ØE*ğ\Õ.|°K\Ù2ó3™\\†	 F÷ºs¾‡½&\ÜÀ€›\æòó] ¦5=¨\éAMjzPÓƒš\Ôô ¦5=¨\éA\íqm†\Ø_£K1·f\×4|ø v8ŸFÃ\é¡‘õh&¤ü‚h›sTj“C;–oD¨riRbw\Âr|şª\áRŸ\Â\ìûòƒ™\î\Øÿ¥k*\Ê\íB\Æ\êW8j›Ä \rqoGújˆ\Ã-*­„¯3,\Ùô`9\êU\â!-¹7´ilbavy\Ó\ÄZ=\Ô&C\Ûqœ\Û:,W\ì†%\ã\Í†5\Æ,\İ(µ\Ö6‘d©^\êbPq·u¦	jY!2\ã\Ñ/\Ò2ù·\Í~r\ÎlX&0¥«µ\á{{\Êµƒöd\Ş\æ£n(\'i¸¢\ï$¨t#r¢Ú°®h0c\Z6?\\µ\Ã6†,uzºV^4ªQ;ˆ\áW\r\é~\Ï`\å\Ä{\Ö\ÓC\Éµ\ÃK{_ö›ó\æXúR\Úá¥†\ÃKõÜ½V§™+^¡P;d\Õ\Ì\ÛL\ÂRT\á¡\Ôô ¦5=¨\éAMjzPÓƒš\Ôô ¦5=¨\éAMjzPÓƒú\í8[su»v\0j\ØmÊŠ#’\ÃY—òAmó½†\ÕöšTo\ì]M›\Æ<†½\Ìp\Ï3\çG‘\Ô6K\Ã+m¢2\Ü.“YF¸Jò{õL†»SºŸ\å¸\à59üP\ÛD9¬»t¹\Êc8ŠÁR\êW/=\Ï\Ïr8\"¶»z8\ëCœÈ ¶‰†t\ê8olGµ\áôP‚\Ø\Úğ\Õ\Êq\Ö\ZvE!65£\ÎpUkx\ÎóÉª64<™IÅ½“\ë«‘’òó\Ãp	\äa)®2¬§\Ã\Ô\Ùò\æ†£À°8‰ñ\à1¬\çg&\ê\áÉ³ÿ/‘\ÃÕ“\ÖZù[&5=¨\éAMjzPÓƒš\Ôô ¦5=¨¹¹üü\á	¸6¾È‚\0\0\0\0IEND®B`‚',22),('f3','51',100,'','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0ò­\0\0N\ÍIDATx\Ú,¼\åw”ù¾\í\Ëû#{¯^«]W+.;‡„IHB\Ü\İ\İ\İ\İ\İ\İ\İCI€ \r4İ½\Ö:{\ï3Î½cœ\ásg¥\ï‹\ß(\ÉS\ÔSó7¿Sª\î-\ÓY)Œe3^›\ËDs1Z«Yjo\äQ{/z\Zx\Ó[\Ç\ï\åü«¯œÿ®\á¿FëµªøÏ‰zş˜kã—™v~©á·\nş5T\Ã[\İş6TÁ?‡\Ëøu¸‚÷:\îÓ­ü1\Û\Æ\Û\éf^M5óv¦‹\ß\æºy³\ĞÊ›¹V\ŞN5ñH\ïÑ“\ã\ÇTE\ÃU¼›h\à\İ`	ory2PÈ³¡^¶ğ|¨—#<k\â\Åh©Ş»œW\ãM<›\éau±ŸG\ãZ}¬\Í²13\Ä\Óù\Ï\r°6=ÀúT?ë³½¬Ow°:\Õ\Î\Æx;O&\Úx<\ÑÉ²\î?kİ¼\îbNka°›¥şnz:Y\ê\ëb±G\Ïõv2\İ\×\ÆDWSı\Íl\ÏNe¼8“ñ\Æl&Zòx\ØR\ÆÃ¶Öº\ëy\Ş\ÛÀFW-¯{+ù­¯šVñCUü—Àù\ßÃ•¼›l\á·GÃ¼[\ì\ã\ÍL“À«\æ\×\î\"ş1P\Äÿ\Z.\á÷¡JŞéµ£\Õü>^\ËÛ±j\ØÈ¯3mü¯\Ån~(óİŒt6\â\íDV¨#yŞ–t\å„0Ù”FO¾\ë)¼(µü:XÃ«\îb­^õ•ñZû¥%–W™¬t\ä°>\Ó\Êú\Â \Ës½¬´\Õ\ÙA°§s=­“5õh²‰µ©VV&šY­cMŸem¨š\Ç#\r<\Z©gY›4;\Ü\Ê\ÂpóCm\Ì\r´1;\Ø\Æô@33ıML÷62£5-lÆ»«\Ù2š“\ÎTY3u¹,5d³^Ï“ZLO\r}<\ím\âyO=¿ô\èt—òÇ€V>ÿ\ì)\äW\İ7+¦\Ì÷ğ\ëz?,÷òv¼·ƒ•:®œ?\à\ïceücTl\ì/\âu_¿Uñ~®™ws-¼™­gr¨{.~˜Z\ÚbmnL¤³	>w¹zzF;ñ¹~€…ªx^ö—óZ\Ì~\Ù\'ğô¾\ÏzŠxÓË»1¶>’\Õúx^\è=^×³1\ÕÁÓ©N‹Y\î‰&`}ªe\×S\×Sm\È\ÚP)OºJxÜ•\Êj{\"«uQ¬4\Æñ¨+¥2–\ÛJx\ØUÁƒör\ÛË˜\Ñ\ÆMt\ä3\ÕQÀ\\Gñ\æš\é(d\ËTqE)´\Å1“F»\ãe†\ÃlyÙ£7\èk\æYo=uz\\\Ãñ/\ám_.¿uùv¨÷£m¶EŒ\ê\à·=üky”N\è¾Fú½Nô·\Ş÷ñ®/÷b\æ{1\ïõt/ôš\ä\äL\Ì\í¸cn\Å-\ãó¸Z›r\í\Øv\Î\íÿ	—+§ğ¾pŒ«\Ó\Z\İ\"m5/\Â¹\ÑS\"ğ¤.’‰dZ‚¬i\n·¦6Â®h\Ú\"ı\è\n\r`¥«F\àµğd¬õÁr\êc\\\é\nw¦!Òš\0{6‡³^È“JV*<yP\ÌJK\Z5¡\Î4E»\Ó\âJ¯­È•\ÈDu³±\Ì\Ô\Æ3]“\ÈXU[fŠ³\éK	!ú\Æ&£™t7f)Âœ§y¼\ì.\çE·Æ¬¿A,4\ì~\Ïû\nõ\\¾v¿ˆ_{\rÀˆ‰]ù¼\ê\É\çEŸ9YË¿Mó\Ö\'ùOi\Ñc\rüc²QzVÎ»\î<co\'ª¤{mtÕ—`je\Ç\r±\ïÎ­›„¸\Ú`yş\0·ş€ı±­\Øÿ\ã\ãx^\Ø\ÃR}\"O$¯«y\İ_\Å/U¼\Ö{>kˆe \ÑSZ\ÜÄ«…i\Í/ğû\Ò\n¯\';\Å\Òºs\"YÓ¨®kóõ\ä0Y“ÁPv<3IL\ä%ñ¤ÌŸ\'Å’Š*gVk}X.÷gª6X`e1ZÏ¬¦s¬(‘G¥aL\å2­\ã§+C˜­Šf¼4X,Ê¤+Æ‡økGhº{œA»ô9_\äe²5¿¶&óL~\Ù#‘\î*\ç™h¼Ş‘\ÇS\Ñ÷YƒÆ¥¥˜ß»\ÅÀö›\ÊoYü\ŞW\Ì.÷ó¥.ş9\×\É-öH\Å8öº¯H¼H\ÆR«Qk$4$†+\Ön\\¾u;KSœoÀò\ä6\Ì\í\"\è\â\Ï]\ŞË3»q:¿ŸÉ²6\ŞóJp/\æ\Ë~GS:\İ.¤<Hk¸?\r\á<\èh\"ù\Ê9\â/fµ<F#[ÀZWkM±,T\æ0R’\Æ\Ã\ê\\ê“£¨´»E‘\Ã-3\îÀ 10Œ\Åzip+Ke°.ŸÖ¨p\n\î™Rdsƒ¾&+üu>!Œû³eº(\æ\0GŠ¬.2tßˆY¿kT[_f-Ö§Eş¼\ë¯\ä­\Äó•L\Ä\0\à\ã®Bw–ğ´©„µú<6š²xİœÎ›\æDşÙ™\Æ\ïÒ¥¡’M ş­û4\Ş35ü2-{¿•©¼[\æ4Z¦6\î\\¶t\Ä\ä\æ\rnŸ9ˆİ‰±<´•+»~\âÖ¾\ïI¸x\Ïc{±9¹›\Ùú¬M>“C¿Ö¹Œn+¥­\å,”\Æ1ŸLeX \r±\á¬ôPhgCgt ¯j£XoO\æis*\á÷˜\ÌN§+1†™ò‚?İ¹½‰=\\g!Á›Õš(6¦ˆPe\Ğ&\Æi\â&x \çı\Ç\ì\"±.b^ 3•\ÑJ\ál™\Ô·ÀB‹K´[¥\Û\á8=\×yŸ\áÁZº«tN\0öÆ¦šWıe2–\"iT_t”ò¨%›Uø°6g-\ÉüÖ“\Æ?¤‹ÿ\Z+\â_\Z\Õ*‚ü&\íz7\"¨dC\0¾Öˆ¿’ \×\æpó¾\'7\Ìm0¿nÌƒ[5?“pùg5²\áWza¥\î\×ğ¸rˆU\È\ã‘\nÊ˜6•T\n\ÌjŞŒ\ÕğP\Æ÷úÁO&GY\é\å?7^°\Ş\Ù\ÎtSOªBu‰<¯K—\İ\çW÷rfŒG\Ã}9[Qnw“—«\Ìfˆ)<jÍ¡.Ê‹7kór\ï~ih¥÷,È±¸Å›4&¸1R\ÊDI£\å\r,L¦\É\ÏN¼\Äl\Ğ%\æL\èr¾Ì£8k\ÖSlyİ”\Ãûj\Ş\é¤\ÑI¿‘ƒ½“«¾ˆ5O!µfğK[¦41C\î›Ã¿†^¿nuÿ·±|12—7#eúÀ•¼V48uAf\Z&vşÜºe\É\É¸\ßK\Ù\ÍÃ¤\ßFÈ±¯H¾º‹œë»‰5\ÙE~\à=V‡Ky>(V”z>\"3_Œ\Õò‹ræ’²\ã«ñAr¥¡µ^,4\ÔSwßùfÅ“úXV›4-IŒ¦z1\"\É*”a¶4er‰¬{Æ¼y8\Íp‚3*B™oH +Á‹±\Ò,*ƒ=™CSLOS`z“÷3´\ÆyŠ!3^¡˜M¶õ-ò\ín\Ğ\ïzšy\ÏKº½À´¿¿g83i\Ë?¤{¿ô–òZ.ø«Ö›q}aƒid(#\n¼\ÎT~\í\É\ä½\Æö÷Ábş¡ş]nıc%ü:^\ÈùJÀ¿\Ğ-7üE¢‘\ÏM+g\\®\Å\æÀN\Î\î£\Ñ\ê85\Æ;i5\ÙÃ°\Ó	šlk¼ƒ±†4…]¦\rx¡\ÌörL!H\É`\\f2V\ÊRe/Ä¾L\'Kš£Xh­¥\Éù>3­E¬\n‡Í†\ÃRc\ã594E\Åğş\åkE•nˆa¿-\Î\ÒkÍƒ7&Ê¼L€\Ì&—º\0ş÷/¿2¡R1W\'-\Í\Ò\å\ÊPa VÃ…!†IŠ•‰V×©³:\ÊØ½ctß“‘\Ø^\âY\à-zÉÛ¼m\ÊPP.’‹E%¼\Ï\ÓHghDsx×“\Î{ô›4ê½´\éĞƒe\n\Ï¼—û)ü\ê±Á^\Ë<^+«e¤\ÆcvÇŠ\Ì\Û\')4=Eô¹\í4› \ë\ê6\Ö,³\êr”Ê›?s\ç\0\ÕD\Ö\0ıÉºWbğó¨Ix.†OÖ„ñ\âÁs-bL\'¿¬/3ZQ¢]\ÎJ´-‰‡\rÊŠqŒU\çP\ÄË•yšebCÊ¯ss%:k\ÜÃ™-ôeV~º<›ò\0/^,NR\ä\çÁtG\Ë&€­ÖŒ\äú0˜\Ä`A˜!Æ¤R\à~ŸxsFı,Y1e\ŞÛ”!\Û+ü\Z{5¯sñ2Sbä»ºhş\èH•¦ˆMùlôf)(dgi\É<”\Ñ\Şëƒ¾Ÿ4\ÜVnFš7\ã\Ú9÷ª¿B¯\Ñ{^j\ì\nóSœ\Í)¹uŒ*1®\è\æ>š¯l§\íì·¬š\íeÁn?U··\Ò\évA•2O\0\Öğ|R.<^·\É\ä\Çbù‹i±4v¡\"L²\ÒKyÿõş-şŠ*±\Z\í|9jób\ŞrC¼\0³e <ó\Ò\âQ\Ê<½Y\è\à÷\Å9†£xX\â\Ëb\Õ^\æŒVòrzXº=H¾£\rS]ü¡\ãj\İn0˜\æ*\0C`$[\æJ³)õu¦ÀÅœZ‡\Ëô:_û\Î3\ãr…7Ñ–<p9\Ã\ì½s,º]aTl|”a\Ç\ë†h^t&*¦ñË \ŞH­À¨\ßğ~J­cºVNÛ¼é¶¿Ê…ß¨¯¾P{x1\\Ç«aUC\Ù$-²5·¦\æ\Öaj¯\ï ñ\Öº.Às\ß2y\í+\Æ,vqe+%·÷³RŸ¬V¡\è3õ§û¾ó¤‡24\İ.e†’}\á%®¬\r0\âiO…’D®\ÉY–¤Sñ,\×&\Ò_ÀÿóÿEWA>{zÈ—\Üõw:n\Å|#K\ÙN\æ\Æğÿ\ßÿ -7nÓŒJÃƒ\ëj\Ñqs´ºÜ¤;Æş,_q([kò\èI$\Ë\á™¦G$\ä?\ë®òK²\r¯\"o3r÷¶FŒXŸ¦\ßöıöûv8\ÉL¨1\Ë9ö¼SDxß¯v\"\ãx3¢p=S/±m“\Ûuñ~I»¦ğ«˜óz´bsô^W¨’\Õ0\ŞTˆ£-\å\Æ?\Ópe¦;è¾¾¦§ÿ\ê\×t\İ\ØFô\ÉoH=õs¥Azm\ç“Å¾grûÚ¼_ús©ò½O{U	KŠ//Ÿ­\Ğ]™O¯˜ÖŸ•@s¨KM	\Ì\nÄ¶%‹n…\ë\ì$öğ¸¿‡‡-¼_\\d ò….<\Èw§9Øµ\Ş~º2BYl\Õ12ª&™\ßò,\×\é· ;Ù¡\\O¶<j\Îg®*]\Zx\ËótŞ¿ÀŒ\×Uû«‘xŠu§\é²:Â \0¶9Ä¼\Ë1\æª\ãÏŒ¹f\ĞËˆµ<WŞ´Fo^=y7\Ù*\à:y½\ÒÎ»µ~Ÿm\ÓHW\Ë-ƒ\ÔH^¨¿š¨`M,\rô´#E‘eÀ\ìm·4®·¢öÒ·´\\ş‰Šó?Rzc/\Ó\îbQ¾\ë¦ş­JS_L‰‰òÉ°a„\Ë6N£\Û=Š­mX\ë %À•ş¼BVj\Z)´¿Eœ½À‹dº5ùŒ \æJ\ÔD2\ây<\ĞE¡6V¬KûbMµQn,–û\Ğ+C™-Ê§\';’\'İ$™‘jc\ÉÃ¡f\Ú\\/\ÑfJOœ=	VlyÙ’\Ï\Ë\Ör\î›uõ0¹·N\Òau–«ó´Z^ \í®cNõ!\Ğk¶q‡¬xŸ\âq˜‹\îGXñ1b9\àS\Ş\çx£ ú»¢Î»\é:~y\ĞÊ›õŞ¯ˆ‰3\ZÛ©\Z}ø\ÆMı2_\Ëúbu\nÀA2z“ıÔ›n§\å\Æ4\\ıJ£¯©8÷U\Æ\Û\é4\ß\ÃCÕ«\ç\ãµ½†§\n\åSÊ„S\ZeƒK^ªg÷Iø_¬OQ\âiÅŒ\\sXS5SÀb­SMª^’¥:e·†F3­¦›r|s˜9.Ö´D\n´*¹oeğŸMC\rd -’—mm\\=#÷õ£\ÈÅŠa\ÓjJ\ä:\Ão³\åmK¿u²®0Ü“\èC}3•7©²¸J±…1E\×O\Ñkq–\Û#´\\SÄ¸±ŸE\Çc¼	¿\Ì\ã€s,‹‘\îŸ\à±\Û\Æ<Œøgo&¿MVˆ…\í¼]\í;x;_Ï›¹6T\é\Ï6ñr±Q\06ğp¶‘„»§¨·<MİŸi¼úõ¾¡ú\Â4ÉëŒ·Ò«T°\Ú\Ç¹\ï\Ã\é*\Ögd “\å¬iCtQ\Ífc¸ˆ\ÔŞh\ì\Ò3yó|•VW[\æe\n³õ\ŞL·²\Ô\ÇRm$³µ¹\Z½\ruÓ P\\fO[À}šc}XjNb¦)™yeÇ±†<F\ã\Â\ÅÀ^\ÊTõŠ\î^ \ËÅ–BùC_˜…Z…\04€myüÚ©Ò§¼\Ö)k¯\à­:\î»\æbšıI3>G\Ù\Åô˜\\r/\åF;\è7;\ÈSo#~P\àö>I¿ùf­°`ŠE	\ìˆ¿‰…o\Z\ÄD\é\áJ\'o:x&&¾˜oU\áo\ç\ÙR#—;¨VH®·:C¹\É^ª/ÿH\Õù¿S&#©8ó=\Í7·\Ñ-\Ù0T±‰FV&\Ëx4U\ÊSe¿§\ã5<™ªW>T&+\×Xgt\\1¥’\ßWX•\Ö‡ØˆÌ·±\Ğ,\0%3“•Y\Ò\ÆT™P^\'úÒ—Fkr s*\Ó\ÍYÊ‹©\×\ç3’+“\é¢\ÒŞŒw3\ÂÂ¨ó0g(ÔŠP3º\Â\ÄÀ¼ÿ\ì\ËS‡M\ç.…\áöB…\â~(\áMW	ª5™Æ‡(9¿ƒ¦kû(9÷­£±\ÚÏº\ÏI^	\Ä)\ÇSZb\ÙNŒTŸ6\ç×Dş5¥>¼\Ô\Âo\Ë\İ\n«}ü6\ÓÁ›\Ù^\Í÷ğ|±‹\Ånú\ÕA‹¯ óüv²\Ïü@\Ñ÷d\ë=\Ê/le\Ìf/ó\î\'x®¶ó\\Æ³&¦=.T•+T•+gCÚº&\0W«Ò¨òw /1˜2w[\êÜ¬\é-Q_\ëe.\×[Á:š\å4Æ³fµˆ‘!=\ë`­¿›‰\n¯Ó™¢qo\Éb^\ÍkL\ã?\ÑUOkT\ËC½,÷5«¹(\Ï>‰H\"F\"\ï\Ñx›S¶üÑÍ¿º³•\ïR\Ô8´\Úø£/—÷ƒy›ÁùYW19d]?D¾\ÑVÊ®\í¦\Îô\0ƒ6\'³U\Èõ:ÍŠûyF\íN0£\ç6<˜v:N\Ëı#LFxÿkA¶$&\Î(Œ\Î7ò\\ >]4\\!n¥-Ş‡¼k{\Úwdü’˜l´\Ô_i¤¿¥\ç\Ş!´À¾\nl‚gp`\ÃõÁ—Š3\n\êU\Ö\×iğ±§#\ĞIu,†G\Zù\É8rŒ\Ïvg±5^ì‹£\Ä\é:mqf†S\å\Îj›ztgu™2–›RY+mo\Ñ\ÊdF5‘\ZÿÎšÍ«ôcrövŸ»ô\Å9\ĞbNW [~\í(\à·n1P\ìû];ı\ÏNÕ°–tŞ©\ç¾\é\Éa£»\'\Ùô§¸\É1w’uq\'9·)·b\Ä\æ\Ó÷³\ìd\Ä\ã`c6B¯³x…I\ëcôË½{\ïQ%3b<Ä„¡\í¬s9.Ú”$^I\Ã©•<\èkşø‘gcD\Æ\Å\Èó\Ò/\í\"\ë\êN\nõ>õ®Æ¬+Hoô•ñdPùMÓ²¡øò¬/KP\ç7ªók\ËR^+\à™$hY`\Í\×Æ³R\ÂT¹\ZC F±IYN±c8Ç\Å\æx\æT\×Æ“\\™NP·\Í\Ó\ÊT]„w\ãùú[ºú²)‹£+É¾wºµA}9\Şt¦¹\ÑoG‹´pË‹¶b›VW¿v\çò[—Æ®5›·m\é¼\ê\Ì\àqG.kªAI4\ß%\æ\ÜNÒ¯\í¥ø\Ú.º\ÍOH0d)&úœ\ãY\è¸Ÿ\Ï3\çuƒ%ù(È˜)×³\Ô\Ú \â\îAš÷KO‰’\å),¨~uv¸TL\'ù\ÆQb5Æ©W~¢\Ëß–\'j!=\ZYÅ–UC¥4¬e¸,šÍ“\Ñ\\\éa\ë#%¬¥ó¸5‰ÕºÔ„ó \Î_\0\nœ†\Ö\îû³\Ô\ÉT[¬*_¸V â‚v](*ü˜)öf®2©º0™¨õg¼>†¶ª@º\ËB\é\Ï\Öm†\í\é\Şt¨ú5(|oy\Õ_Å¯½e›\à½\ï\Í\ç}—4°%›7ml4\'óDº°Öšº	\àƒ\Ú\Òn \á\ânJ\ä\ÆõªaV\Çé¼³Ÿy´\æ}^\âN«\ÓL*C._\áI¸XnÂ¤ÿ9\ê,¦\Éög:\ì\Ğ\á cò‘»—‡0Üœ\ÍRO…²b;+=U9]¢LFõ :Õ†b±*‡µü?\ÔZ\Õ¯Šs\ÅÀ¨Z®i¼õ§óHnkø~c¡6”¹\Z–küxP\å\ÇB¥\0ôe¾%”\é6e\ÂN\Ó\ÌBK$sõ\Ì\Ö	¸J?&K¼˜­\Öı2Gf\Ë\Ü+t§S\r¥·À\\?ºS`š7\íboK¼ƒ\0ª\ä×2¹p¾\Ì#OúWªXS\Ä/\ÒÆ—­i¼h\Í\åq‹\0”>,\Ë\âG\Òıˆ»²Ÿ¤K{È¸z€J³c\Ô\Ş\ÚO«*×Œ\ÃºõÁ\ËM\Ğl}”a—Sb\â­c,£\Ïş(\ÍbaŸ\í­Œ©\ïö„š°Ğ–\Ædg>ú˜›\îf±1›N_KúKSXi(\ãq§b–F÷‰\á\nô@±jX¾\ZE¶F[#,`Ÿ\n\Ğ\'\Ò\í5\ÉĞ£\æH\Z˜W\È|•·ú­·\êœ7“\å\ê\Å\ê¾Ê„ó\ÍÊ„Q,uEjœmšƒ™\î\Û\ä\Ä\å~\ÎKÛ‘\Åbf\î3šc+öYÓ—\åJoF\0½™şb¢í©®ly\İ_*\à\n`\Ş&\ë)\Ö—ğ¶\Ûp‘ ‡g\íy›\×ü6º\r\'˜ÍŠô±\'Ñ‹\ã\Ã\Ä\İ8N\æ#˜\ìSk8 \Ğ{\\!ü0\ÙWRtó0M\Ö\Zq\Ç\ãô;e\ÒU\Ãıø&{œ\índBı™Jw\Õ\Ò(4±>\Õ\Í\Æxsu4$E1Ÿ(mJc]³¡ó|a¸ «”ğ´;s=Wˆ\Ş\è»3Yo\Óø6†«…˜\ç\Ërµ/\n=˜‹\æ*¼¬u_£<¯‘]j‹`¶5Œ¹h11œÅ®(eÀP\æ¢\rk¦Xz]\ì\ÃXC™öŠIrùtú3ı´\ÔR|\è#·¼\Ò\Èş\Ñ[\ÈÛL\Ş*Ò¼“¿\ï)\åm_±\\X\'¬“5¸\ŞF¯\Z\İnô–0\\KŒ\åEbd\âÕ½¤_\İOşù]\ä_\ŞJÚµd\\9@ñ~òLvRvkm\Ö{u;H•\ÕZ2\â¬*x_1\Åù„ú÷.\Z£œió•*~Œvóp¼—¥†\ZfjS˜©Œç‘Œì‰²\ê†6Ö \ËO:\r+‡Çš”\çòq[2«-Q’™ Í‘]®ò‘‘HóŠ=˜+ü³¢M–\ë\Ö\Ğ64¦ó\r†‹ªaLv„)\'†ˆõÁj\"~OK\ÇL—z</ó\Ü\éMuÜ¼Ó§\Õ#\éKó¡;\Ó[\0ú@ö{·D\0¾\Ó	½\Õ\ãwb\ák\íö›\Ş\â\ÍKQ†o\âhl^•n¡\Ğ?©V¾\ÊWp&\Ú\ì81W“v\á0	\çwe7¹bdöµıd\\\ÚAÊ¥d\\“s[\î\"\×XuMc<à°ƒ)\ç},9¤\Õúgr\ì¯\Ğ)G¬	we¡Aı¼­’Æœ\ŞRIH6kbşZO®\ÆV\ã+\Æ=nË”6\'\Ìt\Ö[³Ä¼IL\Ëõb—@X,7Œ®À(ve¦ÀY\İÖƒ\ÉR\Ãhz3%@\'Jİ™Ñ¨o\ê \ÌeA€\Ïktôºu\â©\Æò\İ\ä\ÚÒ¾dgz’\îk9\Ğ-÷\íOó` \ÇG\Ó!\0\ßv(\Â¾UkI\ãvù­b\Ë/ğ•À{\İgør¨L}Si¿_\å]\Ï=(Uşª\ã\Åt³ªY³\\°R\ã—CM´‘7\Îsı±.\éòn¸‡\n³Cd›\"õò\no\î!\çúV*\Í÷\Òi½	\ç¬xe\Ì\í4g¿§\Ãÿ\ÍAw\Å$™J[ı\åJ\Ã5¬jS+¬KJÖµÙ«Š-j\r\ëÖµ¥°\Ú,³iŒb¹6˜õ\ß³\\-G-ñdA:6•\ãÀ|\Ó2‚©\\fòÜ¤mî› Î”J«|Y¬ğ•şù0­\×\ÌUx2Y\ìÎ¸Õ±ı¯7Á8;zÂ¬h°¢+\Ñ^‘\Æ\ÓĞ…•ÿšù½9Mœ\Ë/\Ò\Ã\è¯\Êy3T\Å\Û\áÿÿû‡!\Ãe$õ\ÎA\Ã‘&^\Ìuğr©—\×¤Y³\n\Æ3\Z»¾z\êc=ˆ¸zˆ\èK{\ÉP\Ã(½uX\Z¹—¢«\Û)6\ÙF\én\Ê\Ì÷\Ğl±“Q§C<ğ<Ê¢÷9*\î\ì£\èüT\Ü\ŞG\Ö\İ\ä{šˆ)‘›¿@X’t<\èV\Z€7£•V›@§\Øò¸]\î+\í[WüX.\0yv,:ñ H!ºÀ‰ùG–\àbÀ\Óı©lš\éÊ¼B¶\Ø\ël¹/3Ò¾	1tZ+p\Ñre$\×I\ã+ö%\Ø\Ñm«<hA[\È-\Ú#\ïĞŸ\á$\0\ë“ù­6šwu	Š.™¼\ê30¯’\×CÕ¼¬\â\ÍH-¯\Æ\êx6V\Ãs1oc\\~¶—‹oi”_–Gyõ ŸÕ¹\Î\Íß›<Tc(t1#ò\Úab\å\ÒIöˆ\Ò\Æ?“}ûgº“|Ó­\Ô\İ\Ş)#\ÙÇ‚\ÇaV|\èw”›ŸşŠQ\ëƒtz\\\"\ê\ê6\"O|Áj®/T3\×\Û\r:\'\ç\íH•öelôjK[\â7|\ØÊ£J\é_¡3‹\ÙwYH¿\ËRºs™÷˜•	,d;³’\ëÌ‚\ÆyR,œ\Èta:Í…¹|Ofš¸\Ér\ÆdE.bŸ#2,l\Ê=Å–{tDZ\ÑjNw¸)=10É†-/«ƒy+\á}Q\É\Ó\Ã\Éğ²£T\æQ¨±-\ä\Õp9/F«`õ\æ¸>¬p\İü²2\Ê\Ë5­\Õq^<\Ze\ãa?\ëzş\Ù\\;\Ë-ù”xZ{s?—ö\ák´pyE`\Ş\ØN\Úõo(¾¹vÅ™A‡]\Ìxf\Üİˆ\êS\ß0|\í;\æN\Òh±›.»cŠDÛ™K´\æEc\n\ë-\Ò@iŞšd\çQk¦Àpb\àC5†\ÕZƒû@ò-YÊ¶\äaŠ5‹Iw™Mµf:İš¹Œ{L‹Q“r<\ã>i\ÎL\Ë(¦\Şx™4O\ídBÄ •\Zı‘i b‹£\\×“¾Tw›\Î\è[t\ÇZ\ĞcÎ–g\n\Ï+}Ù¨	\İü\npMzò´%§ªE]y›#ô\\L|6X©\ä_!\Öñz®k“}\Ï\ròL n¬\Z\0\Ü\\Oô²>\ÖÀ£\îRÊ¤\ár\é\à+û<·O5Œi`\Ê\Õ\ï4\Î\Ûi²\ÚMß½]\Ú\ïİ¬}Ug¾g\à\ì—Ìºü\ÌĞ½Ì¸¢\ê\Â\Ò\Ëı\Ì&Ø²¡Ê¶¢\Ñ}¤\rzÔœ!\à’\ã\Ô4¢Y«\r“y\Èu\Ğx²s©wYI±c&\êã‘·Ô\ï0l\ÅD†=\ãb\ÕHº-\Ã\éöL\Êe\r1g>ß‘\é|W9´§Æ›…\çş<%ıE¾ôú\Êy¥…ÚŒnKw¼=\í	÷\Øò¸:ˆg›?®	dMıñq]´\êSŠúe†2`\Ï\ËTi=–Ál•óz²…—\Ó=l,vñluˆ§Fx²<\È\ã<^bM\0?mP8\Î$\Æü<÷cr\0¯s\ßj}CÂ¥­Š.{h™ô\ß\ÛOŸ\ZJ‡t±ôôwûœ%»ŸYt\ÙÇ°t²\Çd½7·3\ìp”g•a-‡õ\Ù\n\ÊI¬\Ô\'ğ >šGšG,•úğ(_™/MÀ\Ä\Şe^t2\âC&ú_c$\ì\Ãb\Îp‚%£©b—\Ïve6Ç™y±s.û2\ß=FŠ<Q \î’\Ét—ø\ÒY \Ì\'­\ì~vg\ßWq¢-Ş‘ö¶<”n<V\×{X\è\Å\Ã\"/\ÖõÂ§\Z\ë\r\í\êcU¢\æ^ve±¡\ÑY•\ë=\éUC)\ç\ÙHı\æ/¬^.õğü\á0Oñ\ì\áOW´–Gx8İ©[J\×=<\Ï\ï$\Şxñ—whœ¿\'\æ\â.\no\ì¡\Şl?÷3`u”n‹=\äü–±#_2~õ[V=N2vw¶\Çiğc·wñ ôO\ê\ã^¢\\3^U/F F+ó©\ï{	@òL;–\ÒXJ¶gF@M&X3c\Åp\ĞMú}.\Òp^F#­K–\Öe\É4\n|™0\èb\Ş=¤—ùÏ›6×¦ Ş\ëJG¦\"L“–3\İY.Z\îj\"2‘\Íı£?ú°Z\äÃšDtCôXY\êIuˆNXŒˆm	\ë\ÄÍ´ÿ¤3kó\ê\È\Ã×”r\ä\ç\æ-ÀµI6kŒ‡XT¯\í-¥4\È\ïó{ˆ8¿ƒ8£­øŸù˜\Ë{qöReú3\İÖ‡\éU{é½½‡Ü£_0røsz~ÀŠóiº\î\ìa\Â\á4%‡?c\Ôd£Vûxš¯\\£.[­¬©Ğ¬¡û°B\090k\Ğ:\æŒD6Ùœ©dK¦ FZ2,\àº}\éñ6¦\Åñ2\í\îfF92©sTc<V\äÄ¨Fv¨\Ô“y\"TW¡«X§.œeOØ‘%\æ	Ì®tGZ\ã\ï²eQóı X…»8€\å’@\íd\0k\å¬*­oZ²\É\Ä\'\rQ*ö±\êÄ‰rÃ¬\Íı2X§@]\Ã\ã™No/Od&OV6yu¬I¿†¦¤\0¯!H-%\ÌhşZ!\çv‘y\í \"\ËA¨eñ3M·u}\"~\Ê\Øş˜½½—>=?dw‚\Òc_\Ñ{şG†M·3\êrµ\Ü\0V*\"X,‹T\ÎaYxQ|.\ÛI\ÎjË¬Ö¸\Ø7p[@Z0oÅ˜\0	`A·\éö»\"ğ.\Ñlw‘&›³4º]f \ŞZ\æ\âªğ\ì\ÉP¾/¹ôd\İól\èL±¢;ÉŠ™R—ÀkŠ7§CR\ĞiÊ–\Ùbe  U˜0J•\ëª–¤…«%ş<Ñ‰­{k¬½y¼\É\Æ±Q}S¾\ŞQ\Ì\Ë\Ş*^\Öñt¬…uë§Š6º\ßÂ£\ÑV†iN\ÆW-\Å\ë\ÌvüOo\Å\ï\Ün‚\ÕV\ÒW¹M\Ğzg\'·UğG\ZÅ¼4pù\è\'Œœøœ¹»‡\é·9Bùño\è\ÑxOK\'G\ê\ä}#–”ó\nBd\0!,•3¯ÍŸ\Êò\Úd\Ş\\¢9c±·¤wfŒ)nŒ\Ë-G\Ã\Í\Ã\Ì\é	1f Ì„>?cú</\Ğ\ãoL¿\0î‰°¡#Ô†F_scH´“\Î	¬x3º£o+Æ˜\Ñcø\"Ê˜\ët†\Ü`\ËL?SeA\Ìj$\æ«\âX¨–«\ÕÆ°* —Kxh\æW(#m\ÔFğ\ÄÀ\Æ\Æ¶fóB¦òB\Õ\î\åp-“õl¸g“b¥\áû‹\á&–khO÷\'ğò!|\Î\ì\"ø\ÌN\Â.\î#\â\ÂvR.n\'\Ïx§\Æx\'\ÍfI<ù\r]Ç¾`^à­ø”‘C\Ò{ü3:®üH«@\í\Úÿ3\æb¤bĞ \éº,÷3\â{‹\å,…d}Õª9\Ã •\í&dÃ±\ÖG˜3m%½3Óº\ÅX„\0\Ô\ê	¿I_\äM|‡\Ñ$­T;&³=•&öGŞ§\Úù&÷¯\Ò\ìoJ}\ØM\Zÿ«K\á¹U\ÑjB§\ë\n½Í–ùœ\0fµƒ•†&°X-.W-ª‘8+`?¨ˆ›Ú¸&F>\Öxo\Èd\Ë7Z•\r_ø(\î<\î/\æÉ°\á—S•›õke¨‘Å¾Ršbˆ¸|`£}„Ÿ\ŞM„2a\æ\İ\\\ÛJ\î\ÕT\ívP`¼‹¬ƒ_3 \0\ç\Ì\ÃŸ0uò3†~Fï™¯™8ş	C‡şÆ¤‚ø¸€ë¾±ƒI›½´\ë\ßiº±ŸûsL‡\Û2“å¡ª¦ñKó0L[° 1©qÑ¸DX0iÁ`œı\Ñrg1s<Q\Z™\ê\Ìhš+ı\É\Ä:\ĞqŸ:?\êın\ÑeCµ\×uZ€E™«X\Ğr›Vÿ›4«‘l\Ó\é\rçŠƒY’»-\Õg¼\êşƒ\Æ\ÄM×«¢X«\äq¥²b™O\r V\Åğ¬^¦R\Ç\ã¦$\Ö\Ú\Ò\ÔYs6/­?\î¯\ä¡X¹ \ÈS\äeF\ÔE\í\Ù\íÙ¡@ıy7vQz\İÀÀ\ïI\Õmü±¿“D€ÿœ\ÙcŸ°r\ìcVN|\Æ\à‰/:ı%+§?fò˜Œ\ä\Ún\Æš©63lºÁÛ»©=÷µ\Æ?Qiò\ç\Õ0¼\Ì£\Â\î5\×w\Ónw”5fˆ/\Ñf\Îb3\ÊÀ³e\"ñ.£‰Œe¸Ó›|óbAg\Ì=\ê\"m)÷¼Iyˆ%÷\Ï\Ó|c“}=z\Ü(&úß E\ß2–\é\Ëh’w¡Ÿœ-–\Å\ÚTË£\Ú$4hÕ©*\Õ%±.\Æ=˜†,>\ëğQej”Á\ê\rq\"\å\ÆT\å´,v²¤Ü¸ØK²\Ãu\Ï\î\Ô\ÚA‘€T”I»²\Â\Ë?Qlº—S?sø[J|Ä˜À[:)À~\Ì\êÉ™:ş)3F_ğ\èÌ§Ìü‚N\Ã³”+/ö™\ì¦CÀ5\\ú‘\ê\ß\Ñn¶—&E\ZE¢w*®\í¢W½{\ÈQq(È˜QÃ¸Æ™J\Ûn3’ m”®\Ğ\ÑDšx\áE”XZ\Å\ÒU¶¢€›\ÄX&C<\Ëõ\"u¾Wi\n1¥3ÈœSš}®\ë±8[Â¬bZyp¾2J\ÙJ U+\Ù×¥(á§±¢õ¨1C\î›&\ÑÈŠqOÕ›WkUŸ”\Ã\Õ\Å*\Ø\nğ\ÍP›,ƒ\ÉdµC\å_LœkM\'\Ì\Âß³»\ä¾;	8§Fry\É\×ölmö…\ïÿŠ\Ô\Ã\ß\Ğt\äs&O}Î‚˜ö@\ãº|\âhŒ\\ø’‡§?eñ\Ô´Üª+{©¾´“†óÛ©R>,K‹õ|\Íùh3\ÙF6§\íö!Ú®)|\ß\Ôq2§.—ÓŠ+2•˜	¸ˆô‡^c H\îqhK\èMMk0£M V™’\áq›¢ Kb\î\ì§\Úı<u\n\äM\Ò\Åfï›´úİ )ğ&[\æ\Ôı\æÕ…§F—¤{K•q›uµ6™ÅšT–\ê\Ô9›s¢syÜªü×’\É\Ó\Æô\ÍKü\ëõi<`\Z’u?Q·z¬¿¯ªô/´\å0¥¿%İ¿‚\Çñ\à¹°+I¸y”+;I8øw2~NÁş\é<ôcgş\Îü‘O6¸xö#\Ö\Ï\Ï\Ì\éO6|x\æ:ş\n\ÃOA®l§\î\Ò6²”\ÓI¶F¿X=ºü\ì\×T}G*a\î7^øV#şwºœNid\Í6A\ìX]aftú\\¡\Ã\å-NGh÷¸@»§Ë•\ÛBo\ÒbF­1¾\×O\â{i¯\ä\ç\ê`s\è-\Zıo\Ñ*ójñ5¡-\è–\á\çmb`YˆJtsb\à‚Fs¾*^@Jk\ÓY®\×H6\åhe°Öš¦œ¾ù\Ãò§\çi‹\áº\\W.T\Åz\ÒZÀz{‘\Ê~\ä\Òs\Í9”xšt|\'^Gw\â~l^§vxr\áG¿%ñ\à—ü„†ÃŸ\Ò~\ìúÅ¾©\ãr[8!#™9ù)Ê…G>#?¤K·y\'¾¦Hº˜\â’}N\Æ\é¯\É3ú’\Â3_\êoŸR¢ªX¬\\rö\ïT*;Öœı1#\ÆÕ‰T\ë¢¬\é»Ew\à\rº¥™‡iu8K½\íIZ=.Ñ¦¦\ÒdB\Ôõıİ¹@‚\Ùi²µ\á%÷RfJc°\Í~·uLi¾#.`Nkv3\Â40V€Æ±T®‘¬J+\ÓY1°°1µ–T1L£Ü.]\Ô8·üy5x½=[n,PÛŠôX«-_+‡e±¶%Ü•¨{	8¼‹€c{€‘Ç·“t\ì\'\ÒE\ÑÁOi<!¦QŒ9ş­\ZßšŸÿª\ÛOÔ‹?£\ï\èß™V¤Y8ú?$şğ$øH¹vØ¾/I\ÒkJ.O\áÙ¯\È?õ5™bcŠ¢P\éÕ­\n\çû4\â_3* †•ßº”;\ÃˆU	\Û\r¿÷¹L‹\ëi\Z\í\ÎPey˜Š»Gip=O¾\ã)\\¯jR\ì\Î\ã~I™õ\æqrn¤.H\àZÊ‘\ïh”o\Ó\"™¯ˆH1Ê±b`´@Œ–#G±X¬ªT\"c¨J“#g²Ş’-p2yfpZi\âc1òi“FW\Úh¸:ü´#“\'mbf«u].¾Ğ”NoJ0)}|7±2ú\ÔNbü@\ê‘\ï\ÈøùsÊ‰=¾¢üğ\×Q€ø„,1«\äÀ\ç\ZÙ¯h\Şÿ%£‡\Å\Ê\ÃP±\ï/\äš\êƒ]=„¿ş\ß}\ß®\ã ¦ª\Æø”(mH˜)ú\èG”o¥ø\âôù\\b Õ*ÿ;º^£E,k“It\Ó\ä~F\Çó49¦\Íı\nU\çHUµô³¾@Ø­=˜\ZıHšõ%²nŠ©V´ZkŒo\n¼;t„[*H«M—‡¼X\İF*T‡2Y\ÆLa(óE1*\èI,W¤²Ö”+¦o‚¸¦&bh#«ş±œ\Úğµç“46dO¤—k’\âYlNc(/†Œ§HPŒó\âOmUhV|\Ñ\çjÿ’Ì½ŸR~\è3Šö*ğÆ/)»Ú~C\Íş\Ï\èüù/ŒüU{ÿ)\ãA¹e¥\ßMIÁ<õZ\"-õ\Şû1\Ş>\ÃC\Ëÿ\àgdH\Ëe&}ªKY¯2Ò‘\çktôËŒ&i^£zq‡\ï\ÍÍ‹\Êwµ^7ò%™Ÿ@\Ô\èš\İ8J„ù)²lOĞ ±mô\Õøú_§}\Óp,còüaY¨ˆc²$œ‰\Ò`fO\æ*¤‡e±\n\Ò\Êx\r†\ï[sX•A¬µdl^3|$\Ç}¨\ãV5ò\Z\âõ|¢40K\æ¢cÄ¼•\Æ$¤™c\Åñd\Ş:C‚\Ñ.\ÕD’Œvt\æ’Nö±\ïÈ”şú’Šƒkœ?#E>m\Ï\ÇT\íú”1±\á\ÄW´\íÿ+ûş\Æ0s›\ÅLk&²\íè‹±§\Ä\é2y\nÒ¹¶gÈ±?K¶2[š\ÍyBN\ï ùì¤hƒúƒoÑ•\áIY¤I\×h—Æµ\È\Ä\ÂFoS³\éf5\ëPK\É×¿W\í{ƒ\ä;{²3Á\â¶>&ûˆ½»V™OÀ.s=\'\Ö&„K\Û#\ì\éŒub0ÅŸ\á¬`FU‡&\r•(_¬,\Õ(+.7\'3\'—]\Ñ\í²òŞŠ!\ÂH3\×Tùş\ë\å\ÃGÕ†° ¿§\ê¹ƒf\ÔTÆŠ\"\È65\"\áü\Ş\Í_\â§^\ŞOœ˜—&ğR~AºF¶\à\ç\É\İ÷19b^Ä¿¾\ïC\Êvı•šCQÙ¯^{öı•ú#«Y\Ü€vLe«®¥\ÜUpv\Şü¾bP·}Y¶t§\Ù\Ó\ZwŸ\Z5‰¼;‡\é”k¦9Ñ¡†R\áNœ\Ã:Å.\Új¡\ã\Ì[\î\Ğ%}± \Ğñ%\Ò\ÄB\Ç3¸X\ãñlÏ“$¶(H7…X\ë8ub\Ã‡š±¥\Ö×‰r/½¡·­¡n*\Í\ŞL¦	Ä´`•s9t‰˜(`jUño¨•,Ë©—+¢Y1ô\å\Êğ\Í\ÛGeº-3ô\éV§HS\ã™‡\n\ÃH7>C\ÔùŸ‰½v€8…\ê\èCßxôkb},\'ıõ\ÜL¿ı¯DnÿwRvü;y\Ûş\â½R\"M+\ßõš÷ş…ú\Ó_1h®®«N›dÁhŠ-c\ê±CÉ¶¥;ĞŸn\Í@ºt×‘öh{é•€Rk—i4\'ICœHu\Õø±\ØÓ’hK–L¥:Ú’\æø»4˜LËƒ¤\İ=F¼\İY¬MNpûò>\ÜÎ«‚šŸ¦6È‚v\Õ\Ãi`‹ò`»yK‘\Ë=r(sw£\ÚÛºC<d÷\ŞL¤l‚h`ã´˜4“\Ì\\AsE¡\ÌK#5\îK\å¡,”±R\Z\Ê\\IS\å2¹øL…\0T\à”–&\\=MÈ¥#D]:D\Ø\Ñ\ïe\"\ß!ñWşK\Õg\ìÿ„”}Ÿ¿Gk\ç\ß\È\Øùy»şFş\Ï“ûó\'Š•{ş&Õ¾ñ$K&’lK²f$Ş†õÚ‘Õ±dG1\í>#2‹A\Õk\'£¸M\Óıs4;œ¦\ÊÍ˜r_k(­‹ƒ†ß–&\ŞÁ\É\ê8i\ÒÁ±¸@»>ğ\n)Êˆ\Ög¸cu™›¦\Ç\äÈ»qSM¶5¢3ø¶´P5\Îç†‚·L$\×ñ6ù\î\Òwª\í6™\Ø\àA½ƒ´Â‘¡8Xƒ\É\ŞLgù3›#Pó/”\Ñ0[ \àµ‚˜¬Œd²B\ÆS\ÏLyS5qŒ”Eyİˆ \ë§R?ö#‘rİ=Ÿ®•¼û3V\Ì\Î‰ÒŠ\Ûú²vşõ\Ï%S\È¸\Ù\Ûş‚]ÿƒv\Ã1~™ôûL¥\Ø1\"32|S¦l#c°¢;Üš\Şğ»FX1nCw€z«\×uJœÉ´½J¼\\¶1\Ø˜ˆU\ÙÂL(	¹KM¤\r¥\îghKTXNs&6\ÄOW¬n‘t\ëI7‰|nşù:\ég»¥]µnK­\ß-Rm®‘\ãhE«9%®6\Ôù‹>\ÎB\ÚEy\ÇM‚)0ƒ\éwa2Ö™ŒP\Æ3¼™\Íòa2Û“‰<O¦‹ƒ/f²,’y±o¾B®®Š7¤Q5¿ô\ç%­\ß\Ä\ïğh>»>!x\ë‡$şô7\"Z\Ôö¿#¦\Ål\Õ°š±\ïsr\ä\Ê9\Z\ëÜÿA¯KÌ¥\Ù2\'™J»«eÏ´\Ø6wÁ\è{4K\ïšÅŒz—«4º]¥U=¶\Ã÷®€µ¥ZZ—\íjJºûU\Z‚\Õm¯R\ëkL­>{\È}\n¼®\Ğ}WcmIe\Ô]|\ï\ã\éé€ùERn\ì¥@=»4X![¼A\æ\Ó$0\ëTç¶Œ\Äj®¥\r>¦\ìj+šl©óp \Î\İEÏ»\Ó&¡ôR}±¥\ÉÃš¿{ôÅ¹¨»1\áµ	\âx®7ã…¾Lˆ™³%j5¥L\Ô&0¢j˜nu	¿\ã;9±·Ÿ?\Ãmû‡xoû\àŸşJ\èwÿ¿oÿ¡?şw\"~ú\ï\Ä\îø€\ämÿ“t™¶÷s²4\Æy\Ò\Ä9ğL”\Ó\É\ÖL¦Z2©:®ñˆÕŠ»Ë°\ØØ¦‘\ê\ëú\"l5jV\ZasõVsM“@ñ1\'\×Û‚w\å@½¦8ÀŒ\ï[ø\Û\ß .À,\Ï\ëdz˜P\ìgB~ø=\\½qt·\Ã\î®6ÿ\Ú.\Òo\î¡VZYeK­¿¥2¡¢”^³¥\ËG´õ¿Ì¸Šv_´1İ±wi÷¿A©õŠ,oÒ ‘n2\0\ç+\Ñ`P#İ“\àGg”½‘.\Æ\ÈT\Æ\ärSŒ\çù0‘\ï\ËdQcj+C\n\å±\n¾G¶ª0\í¸\ëCÜ·„˜¼\ío	¨€ÿ\'¡-|\Ûÿ \ê§#A`¦ˆ•I;?\"g\ï_)\Şõ\ï›W\\&\ã_d\ZıÒ¼\É&”	‡¢oi#-ˆ\Ö\æ†\Ú*\Ü:Ò£û®‰~K¨\rU¾š0#F90\Æ\á*÷Œá¯ˆ\â\ïl¯\ëB\ì®\âgy‘\\/s<¬/cr×‚[Ö·±\Ñô¸]Û‡\×IM\ÚH…\á‚k £\ØkCş­-½~—\ØU:}\Ï)L‘k]e\Ğpñ1\ÚZúaFk=\rªc†Õ¬“\ëOö£?;œ‘´09_ˆ\0w§OúØ—\Ì`v0\Ò\Èş\\F•)Gj“¨ö\Ä[À¨{\îüO®ï¶	\Øú‘n? L¦´\İpû\ïD\ïù€„\İ2l²š¼óc\n\ä¾\å{şB›\ÅF\ÚXº“6Ğiß˜6{ Ù’\Ş8kjü-¤\åfTz\Û*¯Z‚\Ù\æªº!ğL)õP	´\'\ÜÙ„{\×Nr\Ç\ìşv¦„y\Ü\Ãë¾™\"‹1N67\É\rq\'>\È	;7\î‹<.öV›\Ù1\ÎüñÊ›–\ÒB;ò]o‘\îx™-U6\Çhò½Ho\ĞuF#Œ\éñ»LƒÄ´3øº4\Ï¬iŠñ¢#Î‹\Ö±Q\Ìkõ¦;Î>E\Ô@2ƒhM÷§G\ÚØŸJoN=yÁt†\ábMĞ…S¸\ìùm\áµ]\ài\íø/±,LZ²\ë#\"÷ü•\Ø\İ¿\ão¤j¥\éï©»?¡D§z\ß\ß\èU.3Œ\éhŠ\Ãi\îô\Ç\Ë\àb­µ¡¶rTKj‚\î‘\ï¥Q\r^G\n\Ä@eiT­\ßur\\M(ğ´$+\ØŸ{W0¹tc\Óx*(\Çx9\à\ãpK\îÜ¾A‚@÷·\Ç\ŞS\àùyr\ßÆ’$cbÌP|W±\ç.n\ÒS\'cR¥³[\ê\í\Ó\àyŒ	d·X8¬Q4–‹YĞ«ûõJ\é­b™\áÿ«\Ğ\åOU5n\Ôz\Ğ\áC{Œ7=Iú[Š/½i!ô¥†Ğ‘\èOGª?õ	›\ãvt/[?ÁUš\ç¼\íS¼÷|AŒ$t\ç\'iLv}&\0?&n÷\ßH\Øñ±\0x:6]\ËU\ïj~şˆ~ÿkIF\\’+\Òß¡8C±\Ñ9Ş¢,È$7Šex\ÕAŠe>Ö”I¯4±\î¶$\É\"½\ï\âhq™+&g¹jzo\'3\Â\İ\î\î}Wû;Xš\ä\0?B\ÄT\ç\0w\Ü½ñC\Óı¬\Éq\Ó{øXy—R®\Ûm±QU®\Óõ,ƒÁ\ç˜¿Á ÿEú}%²nFtk÷ú‚®Q/›$\Î\Í!vrg;\êC\åh\ÔøR\ä) ]¥1nJ\é\î4†{\é8/	¶#şê68^6\Â|\Ï7XH\Û¶ÿœ4–>\Ê{AbYt0`\Çx\íøŒ\àİŸ«^¿\ã#’\r\0nû»şºƒŸPs\àc™ƒıq\Êx‰.tÄ¨YD;\Ñ­¬jNC\Ä=’”a\í-Iv³!\Éı.\Ñnv„\Ù\Ø\í\è@ —\'÷\í	t·Á\Ù\æNr\Ø@b\Ã|\ÉOŠ&5*\'x\ïş]2ı½ğõ²\Â\ÖÕ–{šOg\\ ™ŠH…>w\ÈW\İ\Ë4%WFš\êÈ–6û3t»`*ğ:“\n‘\ã7\ÄFFCÌµ\ëW(v¿D£Jw¯\0\î	û3D¶úİ¥9\ØI6nGµF ÁÏ*\'Ê´kŞ®”x8‘\ïqŸD\×{Ü½p†»¾\æ\âOp[\ÙN¬rWMó€~bß®/ñ¨{¿ V¹0fÇ‡j$‘º÷#u\â¿P{\è3ªO|\'­u‘‘¹Ò“\èA»˜\İ\åHs„’‚4©&ÊƒtMD¬›½X\è@„60\Ì\Ç/\'üñõô\ÆO\0z»\İ\Å\Ù\Ş³{¦x…úEY^µE\Z[<|\å\Æ\Ş)û…y\æJPˆ\Ø£\rRIq1&K\r&]M&?Ú•œô ¶4Z¢]=o\Ø\í\"£\Şô¼L›\Çy†Tšû¼¯¨¥\\¢EI½\Û\ë*]\Æ4»\\b(è–¢‚À¼\Z\Ãÿ¸Á\ÍE¢ª7÷r&_Ú‘\ë\îHš³‰nŸ<\Ì\á\í\ç\ÈŸqü»8şıg\\ıñ\î\îúFŒüdS}·ÿ\á;şªşDú#b·ÿH™Kœô±h\ï\'”ŸÛ£\ê.	ñP\Ïõ 6Ò•\êğûÒ»{Š]v\ä(rø™^ÁWa=\Õ\İg{B½¼vq%Y#DJ¡¡NxxZclu;f$Æ‡PAMQ…©	„G»‘“\ZDx¤¡jb±zŸŒmN\â}\Ò\Ğ3ı\ÌHVƒÉµ¥,ÓbU\×-õö\Ğ\á,\İn—ô¾\È`À5‰1ıŞ—\éq¹@–*M»ş6\ä!\0İ¯\ÄKôzœe@\ã\Ş\îr–\êûw¨p»O®³v\Ê\ÕMYÊ“—û$;9\å|ó«\ç8²c;\Æ{vqa\ë\çœ\Şş5\ç¶}ƒ\ÑwŸb\"7v\ÚûvbÏ¶ÿ®(óñbe„Bu°ZI\ÈöOIKŒS/ª\r?\ØS7H‚\îI¥6¬\ÊË‘hs,dRŞ§÷’&öyºH\ïü‰òó&+2”\ä\è(2c\ÂIˆÀ?\Äd™M\\l ™\É\ág¦R”™Lav4\å)d\çÇ“Ÿ›@A¢¥¹~”“‘\àJ\âQ™ZPq¶7Åª·Ue)lÉ±>M«\İIú½\Îmşøf\Ä÷\n=¯\Éñ,½®(\Ô\ß{\Ä\ÊIµ€!\çKô¨\n\r:Ö±\Z}§\ã\Ô:İ¢\Âñ.•ª=\Å^\Ş\ä¹{P(\03`Œƒ\rf\çO´0\ŞñFb\Ş\É?\ä¬a)Æœ\Øúgw~\Ë\Ùm_`¥\Ç\î;¾$p÷\çr\éqSFôÀ\Ñ\Zõ\Z‹+\Ôz{Q\å\éF©«³d\ÅC\ÕÓ‡\n\çûT¸H\ç\ÌL;ö=9&G(\ró#XK\n	$+Ú—š¬²c#µ¢‰‹ ()‚¤\Üd¢3¢Iˆğ%.\ÌM\ÇùQD]^uEÑ”\ÅRVœ@UA(…9şdgú“›(@=©/\r£´8”\â\Ò8ª+\Ó\Ù\âw\í0u¶\Ç\éñ2¢\Ø\îµ©\Ü\é\"9V§Ä¸K\İ=C‡n‡\Ü.0\âxQ ^aøşF}N3\èr’2u\É2GKª•\ÚK=ô\á<\İ\ÅW²œ\îfg\Ç\Õ\Óg\Ùÿ\ã7ù\æK|÷\Ç~úH ~Ä©\ïÿÆ™\ï?\æø=Ú»#ø\í\ß`»÷[\îüø9¶?|ûO_­1ov±¡) €*\Õ\ÌR@®€¬Œ¦.\"@›\æD¢¥)\ÉÇ¾¡ô\ê\éa\É‘\ä%D\ÑVšD_c\Z\í\åùT\åç–JTQ9U…TT\ç\ÓT$\Ö)=”g‡Q–J©:QV\0eù!J‹#(+%+\'œtvF‚YYA\Ä+÷Æ¤ù“–\Æ\Û3{©´7Rw¼ˆ\Û\Õ\ãr\Í#8%ò®U÷Ï’y\ç\Ì\æ÷ ^\Ò=×¦\ãzîŸ¦\×\ágİ$\Åú¢2\ÒeÙº¥AÎ”zj\Ì\Ä\Â\0	·›[÷\á\ëm\Ûù\é§\Ùş÷\Ï\Øóı\×ø^€şğ5Ç¿ı‚½[·³ûÇ¿sv\×W\ÜQ\àNñöÀ\Ù\â\Øú-¦ZÁ‡~Rm¢\ØŞ‚\Ìs\Ûp¥+L¹\ÔP-cƒ¨Œğ#_=dÿ\ä\ßFKj<\éÑ¡\ä&G\Ó^K[}.u\åTU\æ“*Ó«J)x	\nø>§i.¦¡6‹‚’’SHLò\"=Û‡´\ìPRSıH\Í\"5;‚Ìœ0’¼÷ 29€p12Q\Ïm¹srY–§\Äyn^<†ñ¹“˜\Å\Ùø©ª.q7O“!Ñ¼~ˆ\Ê\Û\Ç\É2?¨‘?\ÍÀıƒ4\Ú\Ç\á\Ä<\Î\ì\'ø\î9Ò”»2½\íeñ®D¸x`tõ\ß9\Ë6#v\î?\ÄO\ß}Å¶¾\ã§o¾æ§¯>e‡\0İ¾c\0ü\\¬ü„\ÛFI‰!6:«+9¹õK\\¯c¬4“2Ï»\ÄùŠ’ûi2;A\×ı‹\n\ËTFR¨±M6=A©\íy\Z3\ã¨\ÍI¦8-ú\âljª³ix3¯º€\ìò\\\n\ÊS±¸q\'£o(‰v 7\' 5,\ïm\Ï]µÿ¯ƒó|j+M³¸?n\ÕVM;’•s\Î”\0IH€\È`’±IÁ6¦1Nmœ\ín»\İ\î\Ó;S\Ó]35µ[µ3»µ\Şoøğ–’®t\Ï{¸…¦YQº´\ŞdOFõ¥˜wsÿ\"÷Ÿn¬³v÷\nwfi.+H÷x<‘\ãj%\Æ\âhó\Õ^F\Ê1Lœı\Ñ£î¶®\ç–C\Ô\Âì…ù8‘>ù™\Ï\Í7z]\×cÜ™/(sMs_kkyJmšTe\nK®oi—Ç…\Ûa\Å&:m&¼bŸ\Û\ÒMP#\ì²t4w\Î÷Ÿ¿“û27¦\ßo\à\æl•??;\àŸß¾8‰Mß©r}\Z\nó\ëD„Ÿnÿ\æÿú\áS´yumš\Ï\Ï÷ù\é\Ãc~ÿö9ÿø\îõ	ûù/\ß?\æ\é«}i½ÿx\Äb=Í½~\ß-sôü»On°µ»\Ã\å¦7ç˜º4\Å\â•vÖš<V\Ë:8\Ş\æú\á:»k¬\İ\Û`ı\Ë-¶ö68µ»P\å\å¥!\ÌW9˜`Y\îÍ”Y\éOrs¸\È\İZõOKq±±—g\Ó>6ƒ|;\á\ÍxI\åzM–\Ãõ	®ªõ5Æ‰\Í\ã+a\ïŸÀ%}n\æ¶\áôX	xl\í|\Ò\í+-F|==\Ó:\Ö\áwv·™(ø©I¯W³üñ\î&ÿó\ã\'şù\Ã{õ\ì2­)>\Ì±¿0Í³\ÃGü\ïŸ\Şó÷×»üõù]~}x‡_5^Ÿï­°Sğ\Ëu•\0\İÿ\åó#~ı\á)¿ü\å¥\Äÿ˜‡\Ëê·ƒ6~:^\åø‡—¾y\ÈM±yûñG’Ÿ£Û¬®4N›¹ÿp\Ã\×÷\Øıj—\Õ\İu\Ş=\æ\á\×_qt¬~³5Í±>\Ì\ËË£¼¼X\ã‰Àj]\íº/l\å\"”‚\È\Ëóz‚›*\Ó2\Ïp,\Î\ï\ìŸ\ÕD>-\róò\Ê\0w&ŠŒÔ‰6\æ\Ôg°›\Ø\ë+\Øò5<>+·«W€\Ù{ğš:	\Ø\r±K\0\Zpk¼\İ\Ò\ÅD$\È\Øğ Qg\'Y·•k\Åÿ¸…½}\Äÿ}~\Í}|ÎƒÑ¢\Ü~E\Ñ\ä1—\Õ}ş\È\Ó\Ù2%7ÿ©zùt(Í—y+÷=|W°_÷qk¦—\Û:\Ï\ëKC\ì,Vyº2\Â#ı_>\É@~z\Ã\ËoŸpüj—G\îóD¦ò\àùK\Í‹±Ek<W´yöñ	û\Ç{¼øô{{[\Ü\Ø\ç\ÔW3E^]lp¼8\ÌÓ±A\êy¶²nV£f66r6\îD\rôZy/ı9œ,s­\×\É\Ş@„—‹“ü·v\å\ï{WøM\Zñba”\Ê@`uw±†«1µqsÿ8Î€[4aööH{ğ™Û¥¬ü.vl›­C:\Ù-¶:ğiÜƒv+wª1~œ\ï\å¨\ä\Í|·\ê¶o\æúù\íö|°\ËòXƒ\Ï¿a·\×\Ç\×E‡\Í,3n¾.XùPvò¡\åR\ÚB-db<\îf2\â`$\åd¹`»Q\â½L\á¯2‡wUÍ¶\Z¼{|…O\ï•û\Şí²¿Zc#t_¿9\à\Û_óö“J\îüú»–Fç¹’·s\ê±ô\ëV­%¨y\æy»8\Æa£ÀU™Ë–to#n\áª[U™\ìA\Ì|ò§©¥˜…¯f\ìğ½\Æö\ÏS2—2³}Y…\Zöò8¾\æ¾ñElµY1q—×\×eÆ¢,\è”öy\Ìm¯]€uJ»ñ+â¸¤‹v±Ò¨Ñ¶h…ıv\î\Ê\Ì~˜\Òhg\\‹\ÛY\×\É_wñ½¤\çõ\\E\0±¿{‡Ñ€…í¬ƒù¸‰\Ù`»i\Õ\Ä\ÖE)¥‰ÍŒé¤•!7\ê5\Ğõ33ª£\ÛX/zU÷.rQ.¾\Z9\Ëv-Â½Uµšõšj¨]­¿ıôˆÿøùX¡zW¡ú>Ÿ¶§¹Qrqê¡Œ\âjSš§\Ò»1Â«¥6jyn6+,U\Ë\\N†\ØTğ½\íl\çn\ÎÍl@+È•lŒõjUŒ”K×¸5\\¢/;€·w÷ğ\n®±%\é\ß&ˆ5]Ä¯ñu\Ëu]NÓ‰y¸\Å>—ùN§»Scl3\àZZ.6‡™pÀ\ÉúPW3}¼ôğ¬VN´°“õ³qIf|,\rRlPŒH3£º?¥Q–”._Î›9h\È\0+>\'¸¦\×\ï\ä\èM©è…”…•P7sq#›\å\Îh\Ó+#	\'Mm\ÆL\É\Í\ÕOUe?.³\ÑğqC9ùöµ&\å	7Gbœzµ9Å¥©:«£CLD’ÜŸ˜8O°2X`l°Î¤\×Çš£[®NÈ‘·«<J³bFQcº’d¹š¡‹\ã\Í6ôO]&04#7 66±µ³µ\á³w\ãş9¬ºól–veXİ¸\ä\Î6Œ]\Í\Ä\ásJ3ø\Õ`†‘VgJ¼\İjòNr³w±–‹³sÔˆÉ­$a’¡ıÁ&+\ì/3œñ°¦Ç—+’£¢…[#Ë‘nU\ÃzcT4\æ“y#\Ñª\ê\áñóJ\Z&®•\í,¤]y»¨{¸«trw8|\ÂĞ¥´•Ş˜\â@˜>%“Í¹\"§\îoL2;Qg½Q£î±\ĞW 7¹:\ÔO-_\â¢\×Ï’­]]µ›·zŞ¥\Ú\Ù|‘Å‘!nW\Ù\ëgr O ’\Å\İ;\"\0‡ˆUG\n4_¦„£\ÔÀ\àw\n´/^f™†Y\ZhVö3š\Ú1Š‘N—«œØ¬‘5k­;Nˆ\Ûe§¯/\ÊEõ×·6x>\×`.\æˆ­\ïXUNU\ÄˆE\è•ñôióó!\Ç\É‹>^¡–s\Ò({Yi]’”6n\n¨K	«Y…LˆB2LY25˜p0\à\é`±u©!®>\à`Gys1i§¨ß–™^Ì™¸.	9\êuˆ¡F\îN\Ò	?\ëK£œº~yœ™±!½Ô¼!\æ2I\å\Â:\Ú\Ùj*Ë„\"Ç¢˜²2òj~Œ\æ@™´b\Éf³\É\íŠÆ¾^¢K\áq¤k¸Ó½„\Óq<A\îdS4%À,Ø¬\ç1›\Ï\é¶]úv“½ƒU€ª®9¥‹v«t\Ï\ï\Æ(·6\éw¶½4’Ë†˜™¨ò\ä\Ú&kLûm¬\Äü|Y/°\×(“Éª\é\ä¼’b\ï\î@€½\éÕ¢›şş³ıº/\Ó{2,­§XI™%5\ni­\\”µ±>\æd˜Ay\ëi\æ<gX“ó\Îj\ÄK\'£y­\Zd\'\ÑÁQ¤‹#G3b!\à²2?^\á\Ô\ÜH™\éZ‘”v<ew1&#ØŸe§Zd$“  ñjh\ì¦CVU½~*ıe\Ñ4K£#,–KL\ëù±hK4-Ú‹/™û¸BA<© \Åj\Äd:§u§@3šNc²v,k<iUW¶(l÷¨7›\ÄP»³ _\ã66˜dgNñc Ç’tnM\ZöP\Ì_*d%™öe’–\æÅ¸9–¤\\pSUœ™(\ÈÄœ7ó%^Mf¹”µ\nÀ89%K²>’\áR\ÒÁ˜\ë,\Ë1MO›\0\í‘c[\è\r:4²n\æò~n\é»ûñN\é¿U¦\×A³\åTIf0VJbTµ²u\éƒ[,L\å³4ıfR\Z]·\Ø4w“ó\Ù\ÔñKoª_\éx‚¨ZD(Á—ÀN\ã\n‡ñ8_À£Ÿ£x9lN§\İ\í,&c›F¹]@\Æ\Ü\ĞÜ¡fÒƒ\ÅÒ†M\0\Ú<b ò MNlW6tj¼\ëù8³ƒ	.V˜JÅ˜ºX»¸3Zf0#\Û0&ŒŠ&±2\Æ\ÎhšB\ŞMEh<\ëaK.üd\"\ËÉ¸À\É$\"D\ÓYòC5Ja¦Ä¨š»I‘d\Øg`\Ğ\ÛA=j!q“xh¤}\ì”B¬÷š¸#ƒ\Ú3ş\Ær>N…rH³³³]E\ßBww—À²S0\Ã\Û}†nU,C÷y¹§™¸˜\åuûñzBx5\îŒ\İ\Å\í\Ã\â\rJËœø|>ü\ZEW8;\Çn6\êõ\à™ mŠ/V›FYy\Ï\"\0-\æ\Îf:lf~\Ö&\ê=]ºõ;¥WQ/\ã•43•‚¤\"@M\Z8•¹ˆ‰™H„LX›\é÷w»\ÉÊµ×ª	¦TOKJ\r‰ıD\Ò\ÍzNM©\ç^#Î°X–K\ÇHH\Ç\åf\ËQ\Êş.*!Sa\Ã\Şn\İo§V?÷\é\Ófõ‡\ì‹‘7\İlõ‡\Ïù)¥\İ\\—‰x<&:»Nc\ìj\'-4´€”¸g\Å\nk\×9\Îw<¹¦I\'\ê’c&!’‘¨\Ø\áÓˆ95n>\éU@c¨š¦\à\ÛZ^™€+\Ç\áb3t\Ñ\ÕşF\Ã9Œ\İXMm\é,ö–‘(L›\r0ôœÁmWK±Y0ö´\ã0Šù\ÆnBN…ik+xw\Ë(<\äS¤’•ó&)\ÄÂ¤\"Zz¯˜6>\év’ò{\é—ne\\\nÊŒı2ˆñ„‹q_;\Û\Z\å\Ëµì³{Hä²”²Fv\Ú\ÛNŸ@›K˜ûj¡.\Z¡v\Æ•Êª“\Ã1+…ˆYÇ,zˆûZu´›\é\á>NµB\í\éÿ\İx¨À\ìj—ØŸıƒ\Øw–¶ö?\Ğ\Óvš€2™Sceˆy}ğ \Æ\Ù\ê°\Ñi5c°\Èa\å–fK\ÏÉ²+\ÏYµ<(&§4M€:¿À\ÔÙ¡£M iœ5\ÊFmP·Q¬4œÁ \rtY[\Ç\Û{NÀóx­­°İS\Òb\îi#»ˆ(Œ7\Ë	II}± 1–ò8‰\ØlD`Vò‘ò;Hª.&5bi¿rÀ@\Ís\Ë…he¾>Å±¸\Ì)“\ÑøK\Ü\İd`\Ú{Š\ë£&\Ü\çHÿMú†‚O@¥Lôm2X—šŒ	Ÿ\álÆ³\Äô>ÿ¶´}¥S\Û$\0\0\0\0IEND®B`‚',23);
/*!40000 ALTER TABLE `bankaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashform`
--

DROP TABLE IF EXISTS `cashform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cashform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `transItemList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashform`
--

LOCK TABLES `cashform` WRITE;
/*!40000 ALTER TABLE `cashform` DISABLE KEYS */;
INSERT INTO `cashform` VALUES ('XJFYD-20171219-00001',45,1,'2017-12-19 08:57:58','2017-12-19 08:58:00','2017-12-19 08:57:58','2017-12-19 08:57:58','2017-12-19 08:57:58','0092',NULL,'',0,NULL,NULL),('XJFYD-20171219-00003',47,1,'2017-12-19 09:09:24','2017-12-19 09:09:33','2017-12-19 09:09:33','2017-12-19 09:09:24','2017-12-19 09:09:24','0092',NULL,'&20.0&2&1&20.0&2',0,NULL,NULL),('XJFYD-20171219-00006',50,1,'2017-12-19 11:24:42','2017-12-19 11:24:45','2017-12-19 11:24:45','2017-12-19 11:24:42','2017-12-19 11:24:42','0092',NULL,'0&20.0&2&10&20.0&2&10&20.0&2',0,NULL,NULL),('XJFYD-20171225-00001',51,1,'2017-12-25 04:37:02','2017-12-25 04:37:07','2017-12-25 04:37:07','2017-12-25 04:37:02','2017-12-25 04:37:02','0092',NULL,'0&20.0&2&10&20.0&2',0,NULL,NULL),('XJFYD-20171226-00001',53,0,'2017-12-26 12:02:54','2017-12-26 12:02:56','2017-12-26 12:02:54','2017-12-26 12:02:54','2017-12-26 12:02:54','0092',NULL,'',0,NULL,NULL);
/*!40000 ALTER TABLE `cashform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` varchar(40) DEFAULT NULL,
  `name` varchar(40) NOT NULL DEFAULT 'a',
  `kind` varchar(40) NOT NULL DEFAULT '1',
  `vip` int(11) NOT NULL DEFAULT '1',
  `phoneNumber` varchar(40) NOT NULL,
  `address` varchar(120) DEFAULT 'q',
  `postCode` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `receiveLimit` double NOT NULL,
  `receiveAmount` double NOT NULL,
  `payAmount` double NOT NULL,
  `defaultOperatorID` varchar(30) NOT NULL,
  `isUsing` int(11) NOT NULL DEFAULT '1',
  `LIne_number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('sdsdfte','ä¸œæ–¹é—ªç”µ','',0,'','ok??','','',0,0,0,'',1,1),('','','',0,'','ok??','','',0,0,0,'',1,2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerstrategylist`
--

DROP TABLE IF EXISTS `customerstrategylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerstrategylist` (
  `id` varchar(30) NOT NULL,
  `object` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerstrategylist`
--

LOCK TABLES `customerstrategylist` WRITE;
/*!40000 ALTER TABLE `customerstrategylist` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerstrategylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formid`
--

DROP TABLE IF EXISTS `formid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formid` (
  `date` date DEFAULT NULL,
  `formID` varchar(30) DEFAULT NULL,
  `num` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formid`
--

LOCK TABLES `formid` WRITE;
/*!40000 ALTER TABLE `formid` DISABLE KEYS */;
/*!40000 ALTER TABLE `formid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsclasslist`
--

DROP TABLE IF EXISTS `goodsclasslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodsclasslist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `object` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsclasslist`
--

LOCK TABLES `goodsclasslist` WRITE;
/*!40000 ALTER TABLE `goodsclasslist` DISABLE KEYS */;
INSERT INTO `goodsclasslist` VALUES (1,'root','¬\í\0sr\0po.goods.GoodsClassPO\0\0\0\0\0\0\0\0I\0idZ\0isLeafI\0upperClassid[\0\nimageBytest\0[BL\0lowerClassesidt\0Ljava/util/ArrayList;L\0namet\0Ljava/lang/String;xp\0\0\0\0\0\0psr\0java.util.ArrayListx\Ò™\Ça\0I\0sizexp\0\0\0\0w\0\0\0\0xt\0root');
/*!40000 ALTER TABLE `goodsclasslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodslist`
--

DROP TABLE IF EXISTS `goodslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodslist` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `object` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodslist`
--

LOCK TABLES `goodslist` WRITE;
/*!40000 ALTER TABLE `goodslist` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsstrategylist`
--

DROP TABLE IF EXISTS `goodsstrategylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodsstrategylist` (
  `id` varchar(30) NOT NULL,
  `object` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsstrategylist`
--

LOCK TABLES `goodsstrategylist` WRITE;
/*!40000 ALTER TABLE `goodsstrategylist` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsstrategylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `message` text,
  `operatorID` text,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `line_number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`line_number`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('ewaaadasa',NULL,'2017-12-23 16:23:13',1),('ewaaadasa',NULL,'2017-12-23 16:24:45',2),('ewafgaafdafsa',NULL,'2017-12-23 16:24:50',3),('AA','test','2017-12-24 17:50:37',4),('AA','test','2017-12-24 18:18:57',5),('AA','test','2017-12-24 18:18:57',6),('AA','test','2017-12-24 18:18:57',7),('AA','test','2017-12-24 18:18:58',8),('AA','test','2017-12-24 18:18:58',9),('AA','test','2017-12-24 18:18:58',10),('AA','test','2017-12-24 18:18:58',11),('AA','test','2017-12-24 18:18:58',12),('AA','test','2017-12-24 18:18:58',13),('AA','test','2017-12-24 18:18:58',14),('AA','test','2017-12-24 18:18:58',15),('AA','test','2017-12-24 18:18:58',16),('AA','test','2017-12-24 18:18:59',17),('AA','test','2017-12-24 18:18:59',18),('AA','test','2017-12-24 18:18:59',19),('AA','test','2017-12-24 18:18:59',20),('AA','test','2017-12-24 18:18:59',21),('AA','test','2017-12-24 18:18:59',22),('AA','test','2017-12-24 18:18:59',23),('AA','test','2017-12-24 18:18:59',24);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lossform`
--

DROP TABLE IF EXISTS `lossform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lossform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `itemsList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lossform`
--

LOCK TABLES `lossform` WRITE;
/*!40000 ALTER TABLE `lossform` DISABLE KEYS */;
INSERT INTO `lossform` VALUES ('test1',4,0,'2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'??',NULL),('fff',6,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test1',7,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test3',12,0,'2011-12-11 03:11:11','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','abc','ldddd','',0,'redpppo',NULL),('test1',13,0,'2011-12-11 03:11:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','xiaoLi','laowang','',0,'redo',NULL),('test1',14,0,'2011-12-11 03:11:11','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','xiaoLi','laowang','',0,'redo',NULL),('test1',15,0,'2011-12-11 03:11:11','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','xiaoLi','laowang','',0,'redo',NULL),('test1',16,0,'2011-12-11 03:11:11','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','xiaoLi','laowang','',0,'redo',NULL);
/*!40000 ALTER TABLE `lossform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `message` text,
  `senderID` text,
  `receiverID` text,
  `isRead` tinyint(1) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `readTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (0,'test','sd','wqeqweqweq',1,'2017-12-25 11:27:01','2017-12-25 11:27:01'),(2,'test','sd','wqeqweqweq',1,'2017-12-25 11:27:08','2017-12-25 11:27:08'),(3,'test','sd','wqeqweqweq',1,'2017-12-25 11:30:52','2017-12-25 11:30:52'),(4,'test','sd','wqeqweqweq',1,'2017-12-25 11:32:00','2017-12-25 11:32:00'),(5,'test','sd','wqeqweqweq',1,'2017-12-25 11:32:08','2017-12-25 11:32:08'),(6,'test','sd','wqeqweqweq',1,'2017-12-25 11:32:18','2017-12-25 11:32:18'),(7,'test','sd','wqeqweqweq',1,'2017-12-25 11:32:24','2017-12-25 11:32:24'),(8,'test','sd','wqeqweqweq',1,'2017-12-25 11:32:30','2017-12-25 11:32:30'),(9,'test','bbbb','wqeqweqweq',1,'2017-12-25 11:32:35','2017-12-25 11:32:35'),(10,'test','bbbb','wqeqweqweq',1,'2017-12-25 11:34:19','2017-12-25 11:34:19'),(11,'test','bbbb','wqeqweqweq',1,'2017-12-25 11:53:35','2017-12-25 11:53:35'),(12,NULL,'????','wqeqweqweq',1,'2017-12-25 18:17:57','2017-12-25 18:17:57'),(13,NULL,'????','qweqweqweqweqw',0,'2017-12-25 18:18:07','2017-12-25 18:18:07'),(14,'dsfsdfsdffgbdfsfbsf','SYSTEM','',0,'2017-12-25 18:18:53','2017-12-25 18:18:53');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overflowform`
--

DROP TABLE IF EXISTS `overflowform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `overflowform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `itemsList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overflowform`
--

LOCK TABLES `overflowform` WRITE;
/*!40000 ALTER TABLE `overflowform` DISABLE KEYS */;
INSERT INTO `overflowform` VALUES ('test1',4,0,'2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'??',NULL),('fff',6,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test1',7,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test3',12,0,'2011-12-11 03:11:11','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','abc','ldddd','',0,'redpppo',NULL),('test1',13,0,'2011-12-11 03:11:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','xiaoLi','laowang','',0,'redo',NULL),('test1',14,0,'2011-12-11 03:11:11','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','xiaoLi','laowang','',0,'redo',NULL),('test1',15,0,'2011-12-11 03:11:11','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','xiaoLi','laowang','',0,'redo',NULL),('test1',16,0,'2011-12-11 03:11:11','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','xiaoLi','laowang','',0,'redo',NULL);
/*!40000 ALTER TABLE `overflowform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payform`
--

DROP TABLE IF EXISTS `payform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `transItemList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payform`
--

LOCK TABLES `payform` WRITE;
/*!40000 ALTER TABLE `payform` DISABLE KEYS */;
INSERT INTO `payform` VALUES ('test1',4,0,'2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'??',NULL),('fff',6,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('FKD-2017',7,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test3',12,0,'2011-12-11 03:11:11','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','abc','ldddd','',0,'redpppo',NULL);
/*!40000 ALTER TABLE `payform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseform`
--

DROP TABLE IF EXISTS `purchaseform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `transItemList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  `storeHouse` varchar(60) DEFAULT NULL,
  `moneyPreDiscount` int(11) NOT NULL,
  `MoneyAfterDiscount` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `coupon` int(11) NOT NULL,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseform`
--

LOCK TABLES `purchaseform` WRITE;
/*!40000 ALTER TABLE `purchaseform` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchasereturnform`
--

DROP TABLE IF EXISTS `purchasereturnform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchasereturnform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `transItemList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  `storeHouse` varchar(60) DEFAULT NULL,
  `moneyPreDiscount` int(11) NOT NULL,
  `MoneyAfterDiscount` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `coupon` int(11) NOT NULL,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchasereturnform`
--

LOCK TABLES `purchasereturnform` WRITE;
/*!40000 ALTER TABLE `purchasereturnform` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchasereturnform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiptform`
--

DROP TABLE IF EXISTS `receiptform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receiptform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `transItemList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiptform`
--

LOCK TABLES `receiptform` WRITE;
/*!40000 ALTER TABLE `receiptform` DISABLE KEYS */;
/*!40000 ALTER TABLE `receiptform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salereturnform`
--

DROP TABLE IF EXISTS `salereturnform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salereturnform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `itemsList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salereturnform`
--

LOCK TABLES `salereturnform` WRITE;
/*!40000 ALTER TABLE `salereturnform` DISABLE KEYS */;
INSERT INTO `salereturnform` VALUES ('test1',4,0,'2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'??',NULL),('fff',6,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test1',7,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test3',12,0,'2011-12-11 03:11:11','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','abc','ldddd','',0,'redpppo',NULL),('test1',13,0,'2011-12-11 03:11:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','xiaoLi','laowang','',0,'redo',NULL),('test1',14,0,'2011-12-11 03:11:11','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','xiaoLi','laowang','',0,'redo',NULL),('test1',15,0,'2011-12-11 03:11:11','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','xiaoLi','laowang','',0,'redo',NULL),('test1',16,0,'2011-12-11 03:11:11','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','xiaoLi','laowang','',0,'redo',NULL);
/*!40000 ALTER TABLE `salereturnform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saleslipform`
--

DROP TABLE IF EXISTS `saleslipform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saleslipform` (
  `id` varchar(39) NOT NULL DEFAULT 'XJFYD-20171111-00001',
  `LIne_number` int(10) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `finallySaveTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `submitTime` timestamp NULL DEFAULT NULL,
  `passTime` timestamp NULL DEFAULT NULL,
  `rejectTime` timestamp NULL DEFAULT NULL,
  `operatorID` varchar(60) DEFAULT NULL,
  `customerID` varchar(80) DEFAULT NULL,
  `itemsList` varchar(3000) DEFAULT NULL,
  `sum` int(10) DEFAULT NULL,
  `rejectConment` varchar(500) DEFAULT NULL,
  `serialize` mediumblob,
  PRIMARY KEY (`LIne_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saleslipform`
--

LOCK TABLES `saleslipform` WRITE;
/*!40000 ALTER TABLE `saleslipform` DISABLE KEYS */;
INSERT INTO `saleslipform` VALUES ('test1',4,0,'2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'??',NULL),('fff',6,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test1',7,0,'2011-12-10 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','2017-11-27 16:00:00','xiaoLi','laowang','',0,'redo',NULL),('test3',12,0,'2011-12-11 03:11:11','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','2017-11-28 16:27:55','abc','ldddd','',0,'redpppo',NULL),('test1',13,0,'2011-12-11 03:11:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','2017-11-30 16:23:11','xiaoLi','laowang','',0,'redo',NULL),('test1',14,0,'2011-12-11 03:11:11','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','2017-11-30 16:24:50','xiaoLi','laowang','',0,'redo',NULL),('test1',15,0,'2011-12-11 03:11:11','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','2017-11-30 16:39:59','xiaoLi','laowang','',0,'redo',NULL),('test1',16,0,'2011-12-11 03:11:11','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','2017-11-30 16:44:27','xiaoLi','laowang','',0,'redo',NULL);
/*!40000 ALTER TABLE `saleslipform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `totalstrategylist`
--

DROP TABLE IF EXISTS `totalstrategylist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `totalstrategylist` (
  `id` varchar(30) NOT NULL,
  `object` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `totalstrategylist`
--

LOCK TABLES `totalstrategylist` WRITE;
/*!40000 ALTER TABLE `totalstrategylist` DISABLE KEYS */;
/*!40000 ALTER TABLE `totalstrategylist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlist`
--

DROP TABLE IF EXISTS `userlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlist` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlist`
--

LOCK TABLES `userlist` WRITE;
/*!40000 ALTER TABLE `userlist` DISABLE KEYS */;
INSERT INTO `userlist` VALUES ('161250040','hqj','161250040',2),('161250061','lyb','161250061',1),('161250063','lzb','161250063',3),('161250088','mxf','161250088',0);
/*!40000 ALTER TABLE `userlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-26 20:24:59
