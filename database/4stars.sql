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
INSERT INTO `bankaccount` VALUES ('2212','setwe',0,'','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0se�\0\0\0sRGB\0�\�\�\0\0\0gAMA\0\0���a\0\0\0	pHYs\0\0\�\0\0\�\�o�d\0\0�IDATx^\�ݕ\� �ӌ�\��\�E*�\�.|�K\�2�3�\\�	�F��s���&\����\���]��5=�\�AMjzPӃ�\����5=�\�A\�qm�\�_�K1�f\�4|��v8�FÞ�\���h&���h�sT�j�C;�oD�riRbw\�r|��\�R�\�\���\�\���k*\�\�B\�\�W8j�Ġ\rqoG�j�\�-*���3,\��`9\�U\�!-�7�ilbavy\�\�Z=\�&C\�q�\�:,W\�%�\�\��5\�,\�(�\�6�d�^\�bPq�u�	jY!2\�\�/\�2��\�~r\�lX&�0����\�{{\�����d\�\�n(\'i���\�$�t#r�ڰ�h0c\Z6?\\�\�6�,uz�V^4�Q;�\�W\r\�~\�`\�\�{\�\�C\��\�K{_���\�X�R�\�᥆\�K�ܽV���+^�P;d�\�\�\�L\�RT\�\����5=�\�AMjzPӃ�\����5=�\�AMjzPӃ�\�8[su�v\0j\�mʎ�#�\�Y��Am�\���To\�]M�\�<��\�p\�3\�G�\�6K\�+m�2\�.�YF�J�{�L��S��\�\�59�P\�D9��t�\�c8��R\�W/=\�\�r8\"��z8\�C�Ƞ���t\�8olG�\��P�\�\��\�\�q\�\Zv�E!65�\�pUkx\��ɪ64<�IŽ�\������\�p	\�a)�2��\�\�\��\����8��\�1�\�g&\�\�ɳ�/�\�Փ\�Z�[&5=�\�AMjzPӃ�\����5=������\�	�6�Ȃ\0\0\0\0IEND�B`�',18),('00000aa','???',0,'','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0se�\0\0\0sRGB\0�\�\�\0\0\0gAMA\0\0���a\0\0\0	pHYs\0\0\�\0\0\�\�o�d\0\0�IDATx^\�ݕ\� �ӌ�\��\�E*�\�.|�K\�2�3�\\�	�F��s���&\����\���]��5=�\�AMjzPӃ�\����5=�\�A\�qm�\�_�K1�f\�4|��v8�FÞ�\���h&���h�sT�j�C;�oD�riRbw\�r|��\�R�\�\���\�\���k*\�\�B\�\�W8j�Ġ\rqoG�j�\�-*���3,\��`9\�U\�!-�7�ilbavy\�\�Z=\�&C\�q�\�:,W\�%�\�\��5\�,\�(�\�6�d�^\�bPq�u�	jY!2\�\�/\�2��\�~r\�lX&�0����\�{{\�����d\�\�n(\'i���\�$�t#r�ڰ�h0c\Z6?\\�\�6�,uz�V^4�Q;�\�W\r\�~\�`\�\�{\�\�C\��\�K{_���\�X�R�\�᥆\�K�ܽV���+^�P;d�\�\�\�L\�RT\�\����5=�\�AMjzPӃ�\����5=�\�AMjzPӃ�\�8[su�v\0j\�mʎ�#�\�Y��Am�\���To\�]M�\�<��\�p\�3\�G�\�6K\�+m�2\�.�YF�J�{�L��S��\�\�59�P\�D9��t�\�c8��R\�W/=\�\�r8\"��z8\�C�Ƞ���t\�8olG�\��P�\�\��\�\�q\�\Zv�E!65�\�pUkx\��ɪ64<�IŽ�\������\�p	\�a)�2��\�\�\��\����8��\�1�\�g&\�\�ɳ�/�\�Փ\�Z�[&5=�\�AMjzPӃ�\����5=������\�	�6�Ȃ\0\0\0\0IEND�B`�',21),('000003','???',0,'','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0se�\0\0\0sRGB\0�\�\�\0\0\0gAMA\0\0���a\0\0\0	pHYs\0\0\�\0\0\�\�o�d\0\0�IDATx^\�ݕ\� �ӌ�\��\�E*�\�.|�K\�2�3�\\�	�F��s���&\����\���]��5=�\�AMjzPӃ�\����5=�\�A\�qm�\�_�K1�f\�4|��v8�FÞ�\���h&���h�sT�j�C;�oD�riRbw\�r|��\�R�\�\���\�\���k*\�\�B\�\�W8j�Ġ\rqoG�j�\�-*���3,\��`9\�U\�!-�7�ilbavy\�\�Z=\�&C\�q�\�:,W\�%�\�\��5\�,\�(�\�6�d�^\�bPq�u�	jY!2\�\�/\�2��\�~r\�lX&�0����\�{{\�����d\�\�n(\'i���\�$�t#r�ڰ�h0c\Z6?\\�\�6�,uz�V^4�Q;�\�W\r\�~\�`\�\�{\�\�C\��\�K{_���\�X�R�\�᥆\�K�ܽV���+^�P;d�\�\�\�L\�RT\�\����5=�\�AMjzPӃ�\����5=�\�AMjzPӃ�\�8[su�v\0j\�mʎ�#�\�Y��Am�\���To\�]M�\�<��\�p\�3\�G�\�6K\�+m�2\�.�YF�J�{�L��S��\�\�59�P\�D9��t�\�c8��R\�W/=\�\�r8\"��z8\�C�Ƞ���t\�8olG�\��P�\�\��\�\�q\�\Zv�E!65�\�pUkx\��ɪ64<�IŽ�\������\�p	\�a)�2��\�\�\��\����8��\�1�\�g&\�\�ɳ�/�\�Փ\�Z�[&5=�\�AMjzPӃ�\����5=������\�	�6�Ȃ\0\0\0\0IEND�B`�',22),('f3','51',100,'','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0P\0\0\0P\0\0\0��\0\0N\�IDATx\�,�\�w���\�\��#{�^�]W+.�;��IHB\�\�\�\�\�\�\�\�CI��\r4ݽ\�:{\�3νc�\�sg�\�\�(\�S\�S�7�S��\�-\�Y)�e3^�\�Ds1Z�Yjo\�Q{/z\Zx\�[\�\�\�������\�F뵪�ωz��k㗙v~�᷁\n�5T\�[\��6T�?�\��u���:\�ӭ�1\�\�\�\�f^M5�v��\�\�y�\�ʛ�V\�N5�H\�ѓ\�\�TE\�U��h\�\�`	ory2Pȳ�^���|���#�<k\�\�h�޻�W\�M<�\�au��G\�Z}�\��13\�\��\�\r�6=��T?볽�Ow�:\�\�\�x;O&\�x<\�ɲ\�?kݼ�\�bNka����nz:Y\�\�b�G\��v2\�\�\�DWS�\�l\�Ne�8��\�l&Z�x\�R\�öֺ\�y\�\��FW-�{+����V�CU����\�Õ��l\�Gü[\�\�\�L���\�\�\�\"�1P\��\Z.\���Jޏ鵣\��>^\�۱j�\�ȯ3m��\�n~�(�݌t6\�\�DV�#yޖt\�0ٔFO�\�)�(���:Xë\�b�^���Z��%�W���t\�>\�\��\� \�s���\�\�A��s=��5��h����VV&�Y�cM�em��\�#\r<\Z�gY�4;\�\�\�p�Cm\�\r�1;\�\��@33�ML�62�5-lƻ�\�2��\�TY3u�,5d�^ϓZ�LO\r}�<\�m\�yO=��\�t��ǀV>�\�)\�W\�7+�\���\�z?,��v�����:��?\�\�ce�cTl\�/\�u_��U�~��ws-���gr��{.~�Z\�bmnL��	>w�zzF;�~���x^���Z\�~\�\'���\�z�xӞ˻1�>�\��x^\�=^�׳1\��өN��Y\�&`}��e�\�S�\�Sm\�\�P)O�Jxܕ\�j{\"�uQ�4\��+���2�\�Jx\�U���r\�˘\�\�Mt\�3\�Q�\\G�\�\�(d\�TqE)�\�1�F�\�e�\�ly٣7\�k\�Yo=uz\\\���/\�m_.�u�v����m�E�\�\�=�ky�N\�F��N���\���/��b\�{1\��t/��\�\�L\�\�cn\�-\��Z�r\�\�v\�\��	�+��p��\�\Z\�\"�m5/\���\�S\"�.��dZ��i\n��6�h\�\"�\�\n\r`��F\��d����r\�c\\\�\nw�!Ҟ�\0{6��^ȓJV*<yP\�JK\Z5�\�4E�\�\�J���ȕ\�Du��\�\�\�3]�\�XU[f��\�K	!�\�&��t7f)�y�\�.\�E�Ƭ�A,4\�~\��\n�\\�v��_{\r���]��\�\�\�E�9Y˿M�\�\'�Oi\�c\r�c�QzVλ\�<�co\'��{mt՗`je\�\r�\�έ���\�`y�\0������\��\�\�x^\�\�R}\"O$��y\�_\�/U�\�{>k�e \�SZ\�ī�i�\�/��\�\n�\';\�\��s\"YӨ�k��\�0Y��Pv<3IL\�%�̟\'Œ�*gVk}X.�g�6X`e1ZϬ�s�(�G�aL\�2�\�+C���f�4X,ʤ+Ƈ�kGh�{�A��9_\�e�5��&�L~\�#�\�*\�h�ޑ\�S\��Y�ƥ��߻\����\�o�Y�\�W\�.��.�9\�\�-�H\�8����H�H\�R�Qk$4$�+\�n\\�u;KS�o���\�6\�\�\"\�\�\�]\�˝3�q:��ɲ6\��J�p/\�\�~�GS:\�.��<Hk�?\r\�<\�h\"�\�9\�/�f�<F#[�ZWkM�,T\�0R�\�\�\�\\ꓣ���E�\�-3\�� 10�\�zip��+Ke�.�֨p\n\�Rds��&+�u>!���e�(�\�\0G��.2t߈Y�kT[_f-֞�E��\�\�\��L\�\0\�\�Bw�𴩄��<6��xݜΛ\�D�ٙ\�\�ҥ��M����4\�35�2-�{����[\�4Z�6\�\\�t\�\�\�\rn�9�݉�<��+�~\�־\�I�x\�c{�9��\���M>�C�ֹ�n+��\�,�\�1��LeX \r�\��PhgCgt �j�XoO\�is*\���\�N�+1���?ݹ��=\\g!��՚(6��P�e\�&\�i\�&x \��\�\�\"�.b^ 3�\�J\�l�\���B�K�[�\�\�8=�\�y�\��Z��tN\0�Ʀ�W�e2�\"�iT_t��%�U��6�g-\��֓\�?���\Z+\�_\Z\�*��&\�z7\"��dC\0�ֈ���\�\�p�\'7\�m0�n̝�[5?�p�g5�\�W��za�\�\��r�U\�\�\n�ʘ6���T\n\�jތ\��P\����O&GY\�\�?7^�\�\�\�tSO�Bu��<�K��\�\�W�rf�G\�}9[Qnw���\�f�)<j͡.ʋ7k�r\�~ih��,ȱ�ś4&�1R\�DI�\�\r,L�\�\�N�\�l\�%\�L\�r�̣8k\�Slyݔ\���j\�\�\�I���������5O!��f�K[�41C\�ÿ�^�nu���|12�7#e����V�48uAf\Z&v�ܺe�\�\��\�K\�\�ä�\�Fȱ�H����뻉5\�E~\�=V�Ky>(V�z>\"3_�\��r撲\��Ar���^,4\�Sw߁�fœ�XV�4-I��z1\"\�*��a�4�er��{Ƽy8\�p�3�*B�oH�+���\�,*�=�CSLOS`z��3�\�y��!3^��M��-�\�n\�\�z�y\�K������g83i\�?�{����Z.��֛q}�a�id(#\n�\�T~\�\�\�\����b���]n�c%�:^\���J��\�-7�E���\�M+g\\��\�\��N\�\�\�\�85\�;i5\�ð\�	�lk����4�]�\rx�\��rL!H\�`\\f2V\�Re/ľL\'K��Xh��\��>3�E�\n��͆\�Rc\�594E\���\�kE�n�a�-\�\�k̓7&ʼL�\�&���\0��/�2�R1W\'-\�\�\�\�Pa�VÅ!�I���Vש�:\�ؽctߓ�\�^\�Y\�-z�ɐۼm\�PP.��E%�\�\�HghDsxד\�{���4꽴\�Ѓe\n\����)�\��^\�<^+�e�\�cvǊ\�\�\')4=E��\�4��\�\�6\�,�\�r�ʛ?�s\�\0\�D\�\0��ɺWb����Ix.�Oք�\��s-�bL\'��/3ZQ�]\�J��-��\rʊq�U\�P\�˕y�ebCʯss%:k\�Ù-�eV~�<��\0/^,NR\�\��tG\�&���֌\��0�\�`A�!ƤR\�~�xsF�,Y1e\�۔!\�+�\Z{�5�s�2Sb仺h�\�H���M�l�f)(dgi\�<�\�\�냾�4\�VnF�7\�\�9����B�\�{^j\�\n�S�\�)�u�*1�\�\�>��l�\�췬�\�e�n?U��\�\�vA�2O\0\��|R.<^�\�\�\�b��i�4v�\"L�\�Ky����-��*�\Z\�|9j�b\�rC�\0�e�<��\�\�Q\�<�Y\�\��\�9��xX\�\�b�\�^\�V�rzX�=H��\rS]��\�j\�n0�\�*\0C`$[\�J�)�u��ŜZ�\��:_�\�3\�r�7і<p9\�\�s,�]aTl|�a\�\�h^t&*��ˠ\�H���\��~J�c�VNۼ鶿ʅߨ��P{x1\\ǫaUC\�$-�5��\�\�aj�\��\��.�s\�2y\�+\�,v�qe+%���R��V�\�3�������24\�.e��}\�%���\r0\�iO��D�\�Y��S��,\�&\�_�����EWA>�{zȗ\��w:n\�|�#K\�N\�\���\���-7nӌJÃ\�j\�qs��ܤ;Ǝ�,_�q([k�\�I�$\�\���G$\�?\���K�\r�\"o3r��F�X��\�����v8\�L�1\�9��SDx߯v\"\�x3�p=S/�m�\�u�~I����z�bs�^W��\�0\�T���-\�\�?\�pe�;达����\�\�t\�\�F�\�oH=�s�Azm\��žgr�ڼ_�s��O{U	K�//��\�]�O��֟�@s�KM	\�\nĶ%�n�\�\�$��𸿇��-�_\\d ��.<\�w�9؎�\�~�2BYl\�12�&�\��,�\�\���;ف�\\O�<j\�g�*]\Zx�\��t޿��\�U���x�u�\�: \0�9ļ\�1\��\�ό�f\�ˈ�<W޴Fo^=y7\�*\�:y�\�λ�~�m\�HW\�-�\�H^����`M,\r��#E�e�\�m�4����ҷ�\\����?Rzc/\�\�bQ�\���JS_L���ɰa�\�6N�\�=��mX\��%����BVj\Z)��E����d�5��� \�J\�D2\�y<\�E��6V�K�bM�Qn,��\�+C�-ʧ\';�\'ݍ$��jc\�áf\�\\/\�fJO�=	Vlyْ\�\�\�r\�u�0��N\�au���Z^�\�cN�!\�k��q��x�\�q��\�GX�1b9\�S\�\�x� ���λ\�:~y\�ʛ�ޯ��3\Z۩\Z}�\�M�2_\��bu\n�A2�z��ԛn�\�\�4\\��J���8�U\�\�\�4\�\�Cի\�\����\n\�SʄS\Ze�K^�g�I�_�OQ\�iŌ\\sXS5S�b�SM�^���:e��F3���r�|s�9.ִD\n�*�oe�MC\rd -��mm\\=#���\�Ŋa\�jJ\�:\�o�\�mK�u��0ܓ\�C}�3�7���J��1E\�O\�kq�\�#�\\Sĸ��E\�c�	�\�\�s,��\�\�\�\�<��go&�MV��\�]\�;x;_ϛ�6T\�\�6�r�Q\06�p�������<Mݝ�i������\�4ɍ댷ҫT�\�\��\�\�\�*\�gd �\�iC�tQ\�fc���\�ގh\�\�3y�|�VW[\�e\n��\�L��\�\�Rm$���\Z��\ruӠP\\fO[�}�c}XjNb�)�yeǱ�<F\�\�\��^\�T��\�^�\�ŖB�C_��Z��\04�my�کҧ�\�)k�\�:\�\�b��I3>G\�\���\\r/\�F;\�7;\�So#~�P\��>I��f���`�E	\�����o\Z\�D\�\�J\'o:x&&��oU\�o\�\�R#��;�VH��:C�\�^�/�H\���S&#�8�=\�7�\�-\�0T���FV&\�x4U\�Se��\�5<��W>T&+\�Xgt\\1��\�WX�\��؈�̷�\�,\0%3��Y\�\�T�P��^\'�җFkr s*\�\�Yʋ�\�\�3�+�\�\�ތw3\�¨�0g(Ԋ�P3�\�\����\�\�S�M\�.�\��B�\�~(\�MW	��5�Ƈ(9���k�(9����\�Ϻ\�I^	\�)\�SZb\�N�T��6\�׎D�5�>�\�\�o\�\�\n�}�6\���\�^\���|���\�n�\�A�� ��v�\��@�\��d\�=\�/le\�f/�\�\'x���\\Ƴ&�=.T�+T�+gCں&\0W�Ҩ�w�/1�2w[\�ܬ\�-Q_\�e.\�[�:�\�4Ƴf���!=\�`�����\n��ә�qo\�b^\�kL\�?\�UOkT\�C�,�5��(\�>��H\"F\"\�\�x�S��ўͿ���\�R\�8�\���/���y���YW19�d]?D�\�Vʮ\�\��\0�6\'�U\��:͊�yF\�N0�\�6<��v:N\��#LFx�kA�$&\�(�\�7�\\�>]4\\!n�-އ�k{\�wd�����l��\�_i���\�\�!����\n�l�gp`\�����3\n\�U\�\�i�#\�Iu,�G\Z�\�8r�\�vg�5^싣\�\�:mqf�S\�\�j�ztgu�2��RY+mo\�\�dF5�\Z�Κͫ�cr�v���\�9\�bNW�[~\�(\�n1P\��];�\�Nհ�tީ\�\�\�a���\'\����\�1w�uq\'9�)�b\�\�\����\�d\�\�`c6B��x�I\�c�˽{\�Q%3b<Ą�\�s9.ڔ$^I\���<\�k����gcD\�\�\��\�/\�\"\�\�N\n�>��Ƭ+Ho���dP�MӲ���/KP\�7��k\�R^+\��$hY`\�\�ƳR\�T�\ZC�F�IYN�c8Ǐ\�\�x\�T\�Ɠ\\�NP�\�\�\�T]�w\���[����)��+ɝ�w��A}9\�t��\�oG��pˋ�b��VW�v\��[�Ʈ5��m\�\�\�\�qG.k�AI4\�%\�\�Nү\��\�.�\�OH0d)&��\�Y\���\�3\�u�%��(Ș)׳\�\��\�\�A��KO��\�),�~uv�TL\'�\�Qb5ƩW~�\�ߖ\'�j!=\ZYŖUC�4�e�,�͓\�\\\�a\�#%���5�պԄ�\�_\0\n��\�\���\�\�T[�*_�V�⍂v](*��)�f�2���0���g�>���@�\�B\�\�\�m�\�\�\�t��5(|oy\�_ů�e�\�\�\�\�}�4�%�7ml4\'�D��֚�	\��\�\�n� \�\�nJ\�\���a�V\�鼳�y��\�}�^\�N�\�L*C._\�I�Xn¤�9\�,�\��g:\�\�\� c򑻗�0ܜ\�RO��b;+=U9]�LF��:�Նb�*����?\�Z\�����s\����Z�i����Hnk�~c�6��\Z�k�xP\�\�B��\0�e�%�\�6e\�N\�\�BK$s��\�\�	�J?&K���\��2Gf\�\�+t�S\r�����\\?�S`�7\�boK��\0�\�ׁ2�p�\�#O�W�XS\�/\�Ɨ�i�h\�\�q�\0�>,\�\�G\�������K{ȸz�J�c\�\�\�O�*׌\����\�M�\�l}�a�Sb\��c,��\��(\�ba�\����\�����Ж\�dg>���\�f�1�N_K�KSXi(\�q�b�F��\�\n�@�jX�\ZE�F[#,`�\n\�\'\�\�5\�У\�H\Z�W\�|�����\�7�\�\�\�\�ʄ�\�ʄQ,uEj�m���\�\�\�\�\�~\�K�ۑ\�bf\�3�c+�Yӗ\�JoF\0���b��ly\�_*\�\n`\�&\�)\���\�p� �g\�y�\��6�\r\'�͊��\'ы\�\�\�\�8N\�#�\�Sk8�\�{\\!�0\�WRt�0M\�\Zq\�\��;e\�U\���&{��\�ndB��Jw\�\�(4�>\�\�\�xsu4$E1��(mJc]���|a�����;s=W�\�\��3Yo\��6����\�\�r�/\n=��\�*��u_�<��]j�`�5���h11�Ů(e�P\��\rk�Xz]\�\�X�C���Ir�t�3��\�R|\�#��\�\��\�[\�ێL\�*Ҽ��\�)\�m_�\\X\'��5�\�F��\Z\�n��0\\K�\�Ebd\�ս�_\�O��]\�_\�Jڵd\\9@��~�LvRvkm\�{u;H�\�Z�2\�*x_1\�����.\Z��i��*~�v�p����\ZfjS���瑌쉲\�6֠\�O:\r+�ǚ�\��q[2�-Q���͑]��H�=�+���M�\�\�\�64��\r���aLv�)\'����j\"~OK\�L�z</�\�\�Muܼӧ\�#\�K�;\�[\0�@�{�D\0�\�	�\�\�wb\�k\���\�\�\�KQ�o\�hl^�n���\�?�V�\�Wp&\�\�81W�v\�0	\�we7�bd���d\\\�Aʥ�d\\�s[\�\"\�XuMc<ః)\�},9�\��gr\�\�)G�	we�A����Ɯ\�RIH6kb�ZO�\�V\�+\�=n˔6\'\�t\�[�ļIL\��b�@X,7���(ve��Y\�փ\�R\�hz3%@\'JݙѨo\�\�eA�\�kt��u\�\��\�\�\�Ҿdgz�\�k9\�-�\�O�` \�G\�!\0\�v(\��UkI\�v��b\�/��{\�g�r�L}Si�_\�]\�=(U��\�\�t��Y�\\�R\�CM��7\�s��.\��n��\n�Cd�\"��\no\�!\��V*\��\�i��	\��xe\�\�4g��\��\�Aw\�$�J[�\�J\�5�jS+�KJֵ٫�-j\r\�ֵ��\�,�i�b�6��\���\\-G-�dA:6�\��|�\�2��\\f�ܤmΔJ�|Y����0�\�\�Ux2Y\�θ�ձ��7���8;z¬h���+\�^�\�\�Ѕ�����9M�\�/\�\�\�\�y3T\�\�\�����!\�e$�\�A\��&^\�u�r��\��Y�\n\�3\Z��z\�c=��z�\�K{\�P\�(�uX\Z����\�)6\�F�\�n\�\��\�l��Q�C<�<ʢ�9*\�\�\��T\�\�G\�\�\�{��)���@X�t<\�V\Z��7��V�@��\��]\�+\�[W�X.\0yv,:�H!����G�\�b��\���l��\�ʼB�\��\�l�/3Ҿ	1tZ+p\�re$\�I\�+�%\�\�m�<hA[\�-\�#\�П\�$\0\���6�wu	�.��\�30��\�Cռ�\�\�H-�\�\�x6V\�s1oc\\~����oi�_�Gy���չ\�\�ߛ<Tc(t1#�\�ab\�\�I���\�\�?�}�g���|ӭ\�\�\�)#\�ǂ\�aV|�\�w�����Q\�tz\\\"\�\�6\"O|�j�/T3\�\�\r:\'\�\�H��el��jK[\�7�|\�ʣJ\�_�3�\�wYH�\�R�s����	,d;��\�̂\�yR,�\�ta:ͅ�|Of��\�r\�dE.b�#2��,�l\�=Ŗ{tDZ\�jNw�)=10Ɇ-/��y+\�}Q\�\�\�\��T\�Q��-\�\�p9/F�`�\�>��p\���2\�\�5�\�q^<\Ze\�a?\�z�\�\\;\�-��xZ{s?��\�k��pyE`\�\�N\��o(���vřA�]\�xf\�݈\�S\�0|\�;\�N\�h��.�c�DۙK�\�Ec\n\�-\�@iޚd\�Qk��pb\�C5�\�Z��@�-Yʶ\�a�5�Iw�M�f:ݚ��{L�Q�r<\�>i\�L\�(�\�x�4O\�dB�Ġ�\Z��i��b��\\ד�Tw�\�\�[t\�Z\�cΖg\n�\�+}٨	\��\npMz�%���E]y�#�\\L|6X�\�_!\��z�k�}\�\r�L n�\Z\0\�\\O��>\���\�Rʤ\�r\�\�+�<�O5�i`\�\�\�4\�\�i�\�M߽]\�\�ݬ}Ug�g\�\�̺�\�н�̸��\�\�\�\��\�&ز�ʶ�\�}�\rzԜ!\���\�\�4�Y�\r�y\�u\�x�s�wYI�c&\�㑷ԍ\�0�l\�D�=\�b\�H�-\�\��L\�e\r1g>ߑ\�|W9��ƛ�\��<%�E���\�y��ڌn�Kw�=\�	�\��:�g�?�	dM��q]�\�S��e�2`\��\�T�i=��l��z���\�=l,v�lu���Fx�<\�\�<^bM\0?mP8\�$\��<�cr\0�s\�j}C¥��.{h���\�\�O�\ZJ�t���w��%��Yt\�ǰt�\�d�7�3\�p�g�a-���\�\n\�I�\�\'�>�G��G,���(_�/M�\�\�e^t2\�C�&�_c$\�\�b\�p�%��b��\�ve6Ǚy�s.��2\�=F�<Q�\�\�t��\�Y�\�\'�\�~vg\�Wq�-ޑ��<�n<V\�{X\�\�\�\"/\��§\Z\�\r\�\�cU��\�^ve��\�Y�\�=\�UC)\�\�H�\�/�^.���\�0O�\�\�OW��Gx8ݩ�[J�\�=<\�\�$\�x�wh��\'\�\�.\no\�\�l?�3`u�n�=\����#_2~�[V=N2vw�\�i�c�w� �O\�\�^�\\3^U/F F+�\�{	@�L;�\�XJ�gF@M&X3c\�p\�M�}.\�p�^F#�K�\�e\�4\n|�0\�b\�=���ϛ6�צ ޞ\�JG�\"L���3\�Y.Z\�j\"2�\���?��Z\�ÚDtC��XY\�Iu�NX��m	\�\�ʹ��3k�\�\�\�הr\�\�\�-��I6�k��X�T�\�-�4\�\��{�8��8�������\�{q�Re�3\�և\�U{齽�ܣ_0r�sz~���i�\�\�a\�\�4%�?c\�d�V�x���\\�.[���Ь���B\090k\�:�\�D6ٜ�dK� FZ2,\�}�\��6�\��2\�\�fF92�sTc<V\�ĨFv�\��y\"TW��X�.�eO�ؑ%\�	̮tGZ\�\�eQ���X��8�\�@\�d\0k\��*�oZ�\�\�\'\rQ*��\�ĉrì\��2X�@]\�\�N�o/Od&OV6yu�I����\0�!H-%\�h�Z!\�v�y\�\"\�A�e�3M�u}\"~\�\������>=?dw�\�c_\�{�G�M�3\�r��\�\0V*\"X,�T\�aYxQ|.\�I\�jˬָ\�7�p[@Z0oŘ\0	`A�\���\"�.\�lw�&��4�]f \�Z\�\��\�\�P�/��d\��l\�L��;Ɋ�R��k�7�CR\�iʖ\�be� U�0J�\�����%�<щ�{k��y�\�\��Q}S�\�Q\�\�\�*^�\��t��u맊6��\�£\�V�iN\�W-\�\�\�v�Oo\�\�\�n�\�V\�W�M\�zg\'��U�G\Z�ż4p�\�\'�������\�9B��o\�\�xOK\'G\�\�}#���\nBd\0!,�3�͟\��\�d\�\\�9c���wf�)n�\�-G\�\�\�\�\�	1f ̄>?c�</\�\�oL�\0�#ԆF_scH��\�	�x3��o+Ƙ\�c�\"ʘ��\�t�\�`\�L�?SeA\�j$\�\�X���\�ư* �Kxh\�W�(#m\�F�\��\�\���f�B��B\�\�\�p-��l�g�b�\���\�&�khO�\'��!|\�\�\"�\�N\�.\�#\�\�vR.n\'\�x�\�x\'\�fI<�\r]Ǿ`^ଢ଼���C\�{�3:��H�@\�\��3\�b�bР\��,�3\�{�\�,�d}ժ9\� �\�&dñ\�G�3m%�3Ӻ\�X�\0\�\�	�I_\�M�|�\�$�T;&�=�&�Gާ\��&��\�\�oJ}\�M\Z��K\�U\�jB��\�\n�͖��\0f����&�X-�.W-��8+`?����ڸ&F>\�xo\�d�\�7Z�\r_�(\�<\�/\�ɰ\�S���ke��žR�b��|�`�}��\�M�2a\�\�\\\�J\�\�T\�vP`����_3 \0\�\�\��0u�3��~F�8�	C��Ƥ����뾱�I���\�\�i����sL�\�2�塪��K�0L[��1�qѸ�DX0i�`��\�rg1s<Q\Z�\�\�h�+�\�\�:\�q�:?\��n\�eC�\�uZ�E���X\�r�V��4��l�\�\�\r犃Y��-\�g�\���\�\�M׫�X��\�q��b�O\r V\��^�R\�\�$\�\�\�\�Ys6/�?\�\�X��\�S\�eF\�E�\�\�\��١@�y7vQz\���\�I\�m����D���\�c��r\�cVN|\�\��/:�%+�?f�\�\�n\���63l���ۻ�=��\�?Qi�\�\�0�\��\�\�5\�w\�nw��5f�/\�f\�b3\����e\"�.���e�ӛ|�bAg\�=\�\"m)��Iy�%�\�\�|c�}=z\�(&�ߠE\�2�\�\�h��w���-�\�\�Tˣ\�$4hթ*\�%�.\�=��,>�\��Qe�j��\�\rq\"�\�\�T\�,v��ܸ؝K�\�u\�\�\�\�A���T�I���\�\�?Ql���S?s�[J|Ę�[:)��~\�\�ɏ�:�)3F_�\�̧̝��N\���+/��\�C�5\\��\�\�\�n��&E�\ZE�w*�\�W�{\�Qq(ȘQøƙJ\�n3� m���\�\�D�x�\�E�XZ\�\�U����\�X�&C�<\��\"u�Wi\n1�3ȜS�}�\�8[¬bZyp�2J\�J�U+\�ץ(᧱���1C\�&\�ȊqO՛WkU��\�\�\�*\�\n�\�P�,�\�d�C\�_L�kM\'\�\�߳�\�;	8�Fry\�\��l�m���\���\�\�\�\�t\�s&O}΂��@\�|\�h�\\����?e�\��ܪ+{������۩R>,K��|\��h3\�F�6�\��!ڮ)|\�\�q2�.�ӊ+2��	����^c H\�q��hK\�MMk�0�M V��\�q�� Kb\�\�\��<u\n\�M\�\�f�ݠ)�&[\�\��\�Յ�F��{K�q�u�6�ŚT�\�\�9�s�syܪ�ג\�\�\��\�K�\��i<`�\Z�u?Q�z�����/�\�0��%ݿ�\��\����+I�y��+;I8�w2~N��\�<�cg�\���O6�x�#\�\�\�\�\�O6|x\�:���\n\�OA�l�\�\�6��\�I�F�X=��\�\�T}G�*a�\�7^�V#�w��Nid\�6A\�X]aft�\\�\�\�-NGh��@��˕\�Bo\�bF��1�\�O\�{i�\�\�\�`s\�-\Z�o\�*�j�5�-\�\�\�mb`Y�Jtsb\��Fs�*^@Jk\�Y�\�H6\�he�֚�����\��\�i�\�\\��W.T\�z\�Z�z{�\�~\�\�s\�9�x�t|\'^Gw\�~l^�vxr\�G�%�\�����ß\�~\��ž�\�r[8!#�9�)ʅG>#?�K�y\'��H��\��}N\�\�\�3��\�3_\�o�R��X�\\r�\�T*;֜��1#\�ՉT\���\��Ew\�\r�����iu8K�\�IZ=.Ѧ�\�dB\���ݹ@�\�i��\�%��RfJc�\�~�uLi�#.�`Nkv3\�40V�ƱT���J+\�Y1��1���T1L�ܐ.]\�8��y5x�=[n,Pۊ�X�-_+�e��%ܕ�{	8���c{��Ƿ�t\�\'\�E\��Oi<!�Q�9��\Zߚ���\�Oԋ?�\�\�ߙV�Y8��?$��$���H�vؾ/I\�kJ.O\�ٯ\�?�5�bc��P\�խ\n\��4\�_3*���ߺ�;\��U	\�\r���L�\�i\Z\�\�Pey���Gip=O�\�)\\�jR\�\�\�~I��\�qrn�.H\�Zʑ\�h�o\�\"���H1ʁ�b`�@��#G�X��T\"c�J�#g�ޒ-p2yfpZi\�c1�i�FW\�h�:��#�\'mbf�u].�ДNoJ0)�}|7�2�\�Nb��@\�\�\���sʏ�=����\�Q���,1�\��\�\Zٯh\��%��\�\�\�P�\�/\�\�]=���\�}\��\� ��\���(mH�)�\�G�o��\���\\b Ձ*�;�^�E,k�It\�\�~�F\��49��\��\nU\�HU����@ح=�\Z�H��%�n���V�Zk�o\n�;t�[*H�M���X\�F*T�2Y\�La(�E1*\�I,W��֔+�o���&bh#����\��瓎46dO��k�\�YlNc(/���HP��\�OmUhV|\�\�j��̽�R~\�3��*�Ɓ/)�ڎ~C\��\�\���/��U{��)\�A�e�\�MI�<�Z\"-�\��1\�>\�C\��\�gdH\�e&}�KY�2ґ\�kt�ˌ&i^�zq�\�\�͋�\�w�^7�%��@\�\�\�8J��)�lOР�m�\���_�}\�p,c��aY��c�$��\�`fO\�*��e�\n\�\�x\r�\�[sX�A��dl^3|$\�}�\�V5�\Z\��|�40K\�cļ�\�$��c\��d\�:C�\�.\�D��v�t\��N��\�Ȕ�����k�?#E>m\�\�T\���1�\�\�W�\��+���\�0s�\�Lk&�\�英�\�\�2y\nҹ�gȱ?K�2[�\�yBN\� �쏤h���oѕ\�IY�I�\�h�Ƶ\�\�\�FoS��\�f5\�PK\�׿W\�{�\�;{�3�\�>&�����V�O��.s=\'\�&�K\�#\�\�ub0ş\�`FU�&\r�(_�,\�(+.7\'3\'�]\�\��ފ!\�H3\�T��\�\�\�GՆ�����\��f\�TƊ\"\�65\"\��\�\�_\�^\�O���&�R~A�F�\�\�\�\��19b^Ď���\�C\�v���CQٯ^�{����#�Y\��vLe���\�Upv\���bP�}Y�t�\�\�\Zw�\Z5��;�\�k��9ѡ�R\�N�\�:Ş.�\�j�\�\�[\�\�%}��\��%\�\�B\�3�X�\��lϓ$�(H7�X\�8ub\�����\�׉r/�����n*\�\�L�	Ĵ`�s9t��(`jU�o��,˩�+�Y1�\�\��\�\�Ge�-3�\�V�HS\��\n\�H7>C\�����v�8�\�\�Cߐx�kb},\'���\�L���Dn�wRv�;y\���\�R\"M+\�������\�_1�h���N�d�h�-c\�Cɶ�;Пn\�@��tב�h{镀R�k�i4\'IC�Hu\���\�ӒhK�L�:ڒ\���4�L˃�\�=F�\�Y�MNp��>\�Ϋ����6Ȃv\�\�i`��`�yK�\�=r�(sw�\�ێ�C<d�\�L�l�h`㴘4�\�\\AsE�\�K#5\�K\�,��R\Z\�\\IS\�2��L�\0T\���&\\=Mȥ#D]:D\�\�\�e\"\�!�W�K\�g\����}��Gk\�\�\�\��y��F�\����\'��{��&վ�$K&�lK�f$ކ�ڑձdG1\�>#2�A�\�k\'��M\��s4;��\�͘r_k(�����ߖ&\��\�\�8i\����@��>�\n)ʈ�\�g�cu���\�\�ȻqSM�5�3���P5\�熂�L$\��6�\�\�w�\�6�\�\�A�����8�X�\�\�Lg�3�#P�/�\�0[ \������d�B\�S\�LyS5q��Ey݈�\�R?�#�rݐ=�����3V\�\��Ҋ\���v��\�%S\��\�\����]��v\�1�~����L�\�1\"3�2|S�l#c��;ܚ\��FX1nCw�z�\�uJ��ɴ�J�\\�1\���U\�L(	�KM�\r�\�ghKTXNs&6\�OW�n�t\�I7�|n��:\�g��]�nK�\�-Rm��\�hE��9%�6\����>\�B\�Ey\�M�)0��\�wa2֏��P\�3��\��a2ۓ�<O���/f�,�y�o�B���7�Q�5��\�%�\�\�\��h>�>!x\�$��7\"Z\���#�\�l\�����\�sr\�\�9\Z\�ܝ��A�K̥\�2\'�J��eϴ\�6w��\�{4K\�Ōz��4�]�U=�\������ZZ�\�jJ��U\Z�\�m�R\�kL��>{\�}\n��\�}WcmIe\�]|\�\�\�逝�ERn\�@=�4X![��A\�\�$0\�T綌\�j��\r>�\�j+�l��p�\�\�Eϻ\�&���R}��\�Ú�{�Ź���1�\�	\�x�7ㅾL���%j5�L\�&0�j�nu	�\�;9���?\�m��xo��\���J\�w��o��?�w\"~�\�\�\���\�m��t���s�4\�y\�\�9�L�\�\�\�L�Z2�:��Պ�˰\�ئ�\�\��\"l5jV\Zas�VsM�@�1\'\�ۂw\�@��8��\�[�\�\� .��,\�\�dz�P\�gB~�=\\��qt�\�\�6�\�.\�o\�VZYeK���2���^��\�G���̸�v_�1ݱwi��A���,oҠ�n2\0\�+\�`P#ݓ\�Gg���.\�\�T\�\�rS�\��0�\�\�dQcj+C\n\�\n��G��0\�\�Cܷ����\�o	���\'�-|\�� \�#A`���I;?\"g\�_)\��\�W\\&\�_d\Z�Ҽ\�&�	��oi#-�\�\�\�*\�:ң���~K�\rU��0#F90\�\�*���ᯈ\�\�l��\�B\�\�gy�\\/s<�/crׂ[ַ�\���]ۇ\�IM�\�H�\�k��\�kC���-�~�\�U:}\�)L��k]e\�p�1\�Z�aFk�=\r�c�լ�\�O��?;���09_�\0w�O�ؗ\�`v0\�\��\\F�)Gj����\�[��{\��O��ﶏ	\���n? L��\�p�\�D\����\�2�l����c\n\�\�{�B�\�F\�X��6Оiߘ6{ ْ\�8kj�-�\�fTz\�*�Z�\�\��!�L)�P	�\'\�ل{\�Nr\�\��v��y\�\�뾙\"�1N67\�\rq\'>\�	;7\�<.�V�\�1\���ʛ�\�B;�]o�\�x�-U6\�h�Ho\�uF#�\��L�Ĵ3��4\��i��#΋\��Q\�k���;Ώ>E��\�@2�hM��G\�؟JoN=y�t��\�bMЅS�\���m\�]\�i\��/�,LZ�\�#\"���\�\��\�o�j�\�嗢?�D�z\�\�\�U.3�\�h�\�i\��\�\�\�b����rTKj�\�\�Q\r�^G\n\�@eiT�\�ur\\M(�$+\��{W0�tc\�x*(\�x9\�\�pK\�ܾA�@��\�\�S\��yr\�ƒ$cb̎P|W�\�.n\�S\'cR��[\�\�\�\�y�	d�X8�Q4��YЫ��J\�b�\���\�\�OU�5�n\�z\�\�C{�7=I�[�/�i!���Б\�OG�?�	��\�vt/[?�U�\�\�S��|A��$t\�\'iLv}&\0?&n�\�H\��\0x:6]�\�U\�j~��~�kIF\\�+\�ߡ8C�\�9ޢ,Ȏ$7�ex\�A�e>֔I�4��\�$\�\"�\�\�hq�+&g�jzo\'3\�\�\�\�}W�;X�\�\0?B\�T\�\0w\���C\���\�q\�{�X�y�R�\�m�QU�\��,��\�����E�}%�nFtk����Q/�$\�\�!vrg;\�C�\�h�\��R\�) ]�1nJ\�\�4�{\�8/	�#�Ꝟ68^6\�|\�7XH\����4�>\�{AbY�t0`\�x\���\�ݟ�^�\�#�\r\0n�������Ps\�c���q\�x�.tĨYD;\���jNC\�=��a\�-Iv�!\��.\�nv�\�\�\�\�@��\'�\�	t��\�\�N�r\�@b\�|\�O�&5*\'x\��]2�����\�\�Ֆ{�Og\\���H�>w\�W\�\�4%WF�\�Ȗ6�3t��`*�:�\n�\�7\�FFC̵\�W(v�D�Jw�\0\�	�3D��ݥ9\�I6nG�F��ϝ*\'ʴkޮ�x8�\�q�D\�{ܽp���\�\�Op[\�N�rWM��~b�߮/��{� V�0fǇj$���#u\�P{\�3�O|\'�u���ғ\�A��\�\�Hs���4�&ʃtMD���X\�@�60\�\�/\'����\�O\0z�\�\�\�\��{�x����EY^�E\Z[<|\�\�\�)��y\�JP�\��\rRIq1&K\r&]M&?ڕ�� �4Z��]=o\�\�\"�\���L�\�y�T������\\�EI�\�\�*]�\�4�\\b(薢����\Z\����\�E��7�r&_ڑ\�\�H���n��<\�\�\�\�\��q��8��g\\��\�\��F��dS}��\�;���D��#b���H�K���h\�\'��ۣ\�.	�P\���6ҕ\���һ{�]v\�(r��^�Wa=\�\�g{B��vq%Y#DJ���NxxZclu�;�f$ƇP��AMQ��	�G���\ZDx��jb�z��mN\�}\�\�3�\�HV�ɍ��,ӏbU\�-��\�\�,\�n���\�`�5�1�ޗ\�q�@�*M��6\�!\0ݯ\�K�z�e@\�\�\�r�\��w�p�O��v\�\�MYʓ��$;9\�|�\�8�c;\�{vqa\�\�\��5\�}�\�w�b\"7v\��vb�϶��(��be�Bu�ZI\��OIK��S/��\r?\�S�7H�\�I�6�\�ˑhs,dRާ��&�y�H\�����&+2�\�\�(2c\�I��?\�d�M\\l �\�\�g�R��Lav4�\�)d\�Ǔ��@A���~���\�J�\�Q�ZPq�7Ū�Ue)lɱ>M�\�I��\�m��f\��\n=�\��,��(\�\�{\�\�I��!\�K��\n\r:�ֱ\Z}�\�\�:ݢ\��.��=\�^\�\�{P(\03`��\rf\�O�0\��Fb\�\�?\�a)Ɯ\��gw~\�\�m_`�\�\�;�$p�\�r\�qSF��\�\Z�\Z�+\�z{Q\�\�F���d\�C\�Ӈ\n\��T�H\�\�L;�=9&G(\r�#XK\n	$+ڗ���c#����� ()��\�d�3�I��%.\�M\��QD]^uEє\�RV�@UA(�9�dg���(@=�/\r��8�\�\�8�+\�\�\�w\�0u�\�\��2�\�\���\�\�\"9V�ĸK\�=C�n�\�.0\�xQ ^a��F}N3\�r�2u\�2GK��\�K=�\�<\�\�W��\�fg\�\�\�g\��\�7�\�K�|�\�~�H ~ĩ\��ƙ\�?\���=ڻ#��\�\�`��[\���9�?|��O_�1ov��) �*\�\�R@�����.\"@�\�D��)\�Ǿ��\�\�a\��\�%D\�V�D_c\Z\�\��T\�琐�JTQ9U�TT\�\�T$\�)=�g�Q�J�:QV\0e�!J�#(+�%+\'�t�vF�YYA\�+�Ƥ���\�\�3{��7Rw��\�\�\�r\�#8%�U�ϒy\�\�\���^\�=�צ\�z\�\�gݞ$\���2\�eٺ�AΔzj\�\�\�\0	��[�\�\�m\��\�\���\�\���\��^���5ǿ���[���ǿsv\�W\�Q\�N���\�\�\��-�Z��~Rm�\�ނ\�s\��p�+L�\�P-c����#_�=d�\�\�FKj<\�ѡ\�&G\�^�K[}.�u\�TU\�*ӫJ)x	\n�>�i.��6����SHL�\"=ۇ�\�PRS�H\�\"5;�̜0���� 29�p12Q\�m�srY��\�yn^<�񹓘\�\����.q7O�!э�~�\�\�\�\�2?��?\����4\�\�\�\�<\�\�\'�\�9Ҕ�2�\�e�D�x`t�\�9\�6#v\�?\�O\�}Ŷ�\�o�槯>e�\0ݾc�\0�\\���\�FI��!6:�+9��K\\�c�4�2ϻ\�����i2;A\���\n\�TFR��M6=A�\�y\Z3\�\�I�8-��\�lj��ix3���\��\\\n\�S��q\'�o(�v 7\'� 5,\�m�\�]������|j+M��?n\�VM;��s\��\0IH�\�`��I�6�1Nm�\�n�\�\�\�;S\�]35�[�3��\�o�����t\�{����YQ��\�dOF���ws�\"��n��v�\nwfi.+H��x<�\�j%\�\�h�\�^F\�1�L��\��\�C\�\�쎅�8�>���\�\�7z]\�cܙ/(sMs_kky�Jm�Te\nK�oi�ǅ\�a\�&:m&�b�\�\�MP#\�t�4w�\������27��\�o\�\�l�??;\��߾8�Mߩr}\Z\n�\�D��n�\���\�S�yum�\�\���\�\�c~��9��\��	��/\�?\�\�}i��x\�b=ͽ~\�-s���On���\�\��7瘺4\�\�v֚<V\�:8\�\��\�:�k�\�\�`�\�-��68��P\�\�!\�W9�`Y\�͔Y\�Ors�\�\�Z��OKq���g\�>6�|;\�\�xI\�zM�\��	���5Ɖ\�\�+�a\��%}n�\�\��X	xl\�|\�\�+-F|==\�:\�\�wv��(��I�W���\�&��\�\'��\�{�\�2�)>\���0ͳ\�G�\�\���׻���]~}x�_5^�ﭰS�\�u�\0\��\��#~�\�)��\�\����\�귃6~:^\�����y\�M�y��G���۬�4N���p�\�\��\��j�\�\�u�\�=\�\�\�_qt�~�5ͱ>\�\�ˣ��X\��j]\�/l\�\"��\�\��z��*\�2�\�p,\�\�\�\�D>-\r��\�\0w&���ԉ6\�\�g��\�\�+\��5<>+��W�\�{�:	\�\r�K\0\Zpk�\�\�\�D$\�\�� Qg\'Y��k\�����}\��}~\�}|΃Ѣ\�~E\�\�1�\�}�\�\�\�2%7��z�t(͗y+�=|W�_�qk��\�:\�\�KC\�,Vy�2\�#��_>\�@~z\�\�o�p�j�G\��D��\��K\���E�k<W�y��	�\�{���{{[\�\�\�\�W3E^]lp�8\�ӱA�\�y��nV�f66r6\�D\r�Zy/�9�,s�\�\�\�@������v\�\�{W�M\Z�ba�\�@�`uw���1��qs�8΀[4a��H{�ۥ���.vl��C:\�-�:�i܃v+w�1~�\�\�\�\�|��\�o\���\��|�\��X�\��a�\�\�\�E�\�,3n�.X�Pv�\�R\�B-db<\�f2\�`$\�d�`�Q\�L\�2��wUͶ\Z�{|�O\��\��Zc#t�_�9\�\�_���J\�����F繒�s\��\�V�%�y�\�y�8\�a��U�˖to#n\�[�U�\�A\�|򧩥���f\��\��\�S2�2�}Y�\Z��8�\���El�Y1q�׎\�eƢ,\��y\�m�]�uJ��+⸤�v�ҨѶh��v\�\�\�~�\�hg�\\�\�Y\�\�_w�\��\\E\0���{�р�����\�`�i\�\�\�E)��͌�餕!�7\�5\��33��\�X/zU�.rQ.�\Z9\�v-½U����j��]�������X�zW��>�����Qrqꡌ\�jS��\��1«�6jyn6+,U\�\\N�\�T�\�l\�n\�͍l@+ȕl��jU��K׸5\\�/;��w��\n��%\�\�&�5]į�u\�u]NӉy�\�>��N��Scl3\��Z�Z.6��p�\��P�W3}���VN������qIf|,\rRlP�H3��?��Q��._Λ9h\�\0+>��\'��\�\�\�\�M�腔��P7sq#�\�\�h\�+#	\'Mm\�L\�\�\�OUe?.�\��qC9���&\�	7Gb�z�9ť�:��CLD�ܟ��8O�2X`l�Τ\�ǚ��[�N�ȑ��<J��bFQc��d����\�\�6�O]&04�#7 66����\�w\��9���l�v�eXݸ\�\�6�]\�\�\�sJ3�\�`��VgJ�\�j�Nr�w�����sԈɭ$a����&+\�/3��Ǘ+����[#ˑnU\�zcT4\�y#\��\�\���J\Z&��\�,�]y��{��trw8|\�Х��ޘ�\�@�>%�͹\"�\�oL2;Qg�Q�\�W� 7�:\�O-_\�\�ϒ�]]���zޥ\�\�|�ő!nW\�\�gr O �\�\�;\"\0��UG\n4_���\��\�w\n�/^f��Y\ZhV�3�\�1��N���ج�5k�;N�\�e��/\�E�׷6x>\�`.\���\�XUNU\��E\���i��!\�\��>^��s\�({Yi]��6n\n�K	�Y�L�B2LY25�p0\�\�`�u�!�>\�`Gys1i��ߖ�^̙�.	9\�u��F\�N\�	?\�K���~y���!�Լ!\�2I\�\�:\�\�j*˄\"Ǣ��2�j~�\�@��b\�f�\�\�ƾ^�K\�q�k�ӽ�\�q<A\�dS4%�,ج\�1�\�\�]�v���U���9��v�t\�\�\�(�6\�w��4�ˆ����\�\��&kL�m�\��|Y/�\�(�ɪ\�\��b\�\�@��\�բ������/\�{2,��XI�%5\ni�\\���>\�d�Ay\�i\�<gX��\�j\�K\'�y�\Zd\'\��Q��#G3b!\�2?^\�\�\�H�\�Z��v<ew1&#؟e�Zd$����jh\�CVU�~*�e\�4K�#,�KL\���hK4�-ڋ/���BA<���\�j\�d:�u�@3�Nc�v�,k<�iUW�(l��7�\�P���_\�66�dgN�c ǒtnM\Z�P\�_*d%��e���\�Ÿ9��\\pSU��(\�Ĝ7�%^Mf���\n�89%�K�>�\�R\���\�,\�1MO�\0\�c[\�\r:4�n\��~n\����N\�U�\�A�\�TIf0VJbT��u\�[,L\�4�fR\Z]�\�4w��\�\��Ko�_\�x��ZD(���N\�\n��8_����x9lN��\�\�,&c�F�]@�\�\�\�ܡf҃\�҆M\0\�<b��MNlW6tj�\��8��	.�V�JŘ�X��3Zf0#\�0�&��&�2\�\�h�B\�MEh<\�aK.�d\"\�ɸ�\�$\"D\�Y�C5Ja�Ĩ���I�d\�g`\�\�A=j!q��xh�}\�B����#�\�3�\�r>N�rH����]E\�Bww���S0�\�\�}�nU,C�y�����\�u��zBx5\��\�\�\�\�\�\rJ˜�|>�\ZEW8�;\�n6\��\�� m�/V�FYy\�\"\0-\�\�f:lf�~\�&\�=]��;�WQ/\�43���\"@M\Z8�����H�LX�\��w�\�ʵת	�TOKJ\r��D\�\�zNM�\�^#ΰX�K\�HH\�\�f\�Q\��.*!Sa\�\�n\�o�V?�\�\�f��\���7\�l��\��)�\�\\��x<&:�Nc\�j\'-4����g\�\nk\�9\�w<��I\'\�c&!���\�\�ӈ95n>\�U@c���\�\�Z^��+\�\�b3t\�\��F\�9�\�XMm\�,���(L�\r0���mWK�Y0��\�0��\�nBN�ik+xw\�(<\�S����&)\�¤\"Zz��6>\�v��{\�ne\\\nʌ�2��q_;\�\Z\�\��쳐{H䲔�Fv\�\�N�@�K��j�.\Z�v\��ʪ�\�1+��Yǐ,z��Zu��\�\�>N�B\�\���\�x���\�j�؟��\�w���?\�\�v��2�Sce�y}�\�\�\�\�i5c�\�a\�fK\�ɲ+\�Y�<�(&�4M�:��\�ف��M�i�5\�FmP�Q�4���\rtY[\�\�{N��x���ݍS\�b\�i#��(�7\�	II}� 1��8�\�lD`V��;H�.&5bi��r�@\�s�\��he�>ű�\�)�\��K\�\�d`\�{��\��&\�\�H�M���O@�L�m2X���	�\�lƳ\��>����}�S\�$\0\0\0\0IEND�B`�',23);
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
INSERT INTO `customer` VALUES ('sdsdfte','东方闪电','',0,'','ok??','','',0,0,0,'',1,1),('','','',0,'','ok??','','',0,0,0,'',1,2);
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
INSERT INTO `goodsclasslist` VALUES (1,'root','�\�\0sr\0po.goods.GoodsClassPO\0\0\0\0\0\0\0\0I\0idZ\0isLeafI\0upperClassid[\0\nimageBytest\0[BL\0lowerClassesidt\0Ljava/util/ArrayList;L\0namet\0Ljava/lang/String;xp\0\0\0\0\0\0psr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0\0w\0\0\0\0xt\0root');
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
