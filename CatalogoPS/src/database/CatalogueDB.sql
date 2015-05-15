-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: CatalogueDB
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `Customers`
--

DROP TABLE IF EXISTS `Customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customers` (
  `customerID` int(9) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `deliveringAddress` varchar(70) NOT NULL,
  `mailAddress` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customers`
--

LOCK TABLES `Customers` WRITE;
/*!40000 ALTER TABLE `Customers` DISABLE KEYS */;
INSERT INTO `Customers` VALUES (1,'1234','Nicholas','Little','83 Grover Hill','little0@ftc.gov','2-(551)472-6653'),(2,'1234','Earl','Gonzales','23 Caliangt Trail','egonzales1@xinhuanet.com','6-(952)990-9163'),(3,'1234','Russell','Romero','71 Declaration Junction','rromero2@rambler.ru','6-(189)921-7237'),(4,'1234','Matthew','Daniels','39 Hansons Terrace','mdaniels3@acquirethisname.com','8-(771)883-9146'),(5,'1234','Katherine','Lee','3236 Aberg Plaza','klee4@cyberchimps.com','5-(726)998-3567'),(6,'1234','Peter','Watson','66 Barby Point','pwatson5@vinaora.com','3-(846)412-2136'),(7,'1234','Kathy','Watson','1 Mandrake Road','kwatson6@google.com.br','4-(052)754-6784'),(8,'1234','Jason','Wilson','79175 Starling Trail','jwilson7@diigo.com','9-(771)422-2425'),(9,'1234','Kathleen','Lane','9 Division Circle','klane8@usda.gov','4-(890)497-2963'),(10,'1234','Christopher','Harrison','712 Center Avenue','charrison9@com.com','5-(279)208-4837'),(11,'1234','Justin','Adams','86494 Sheridan Avenue','jadamsa@cdbaby.com','3-(493)708-1965'),(12,'1234','Robert','Smith','354 Fuller Parkway','rsmithb@miitbeian.gov.cn','4-(481)449-9976'),(13,'1234','Steven','Stone','91 Acker Way','sstonec@delicious.com','4-(435)812-7243'),(14,'1234','Brenda','Payne','27 Summit Court','bpayned@networksolutions.com','2-(960)538-6905'),(15,'1234','Linda','Walker','85867 Twin Pines Road','lwalkere@studiopress.com','9-(988)097-5962'),(16,'1234','Fred','Gutierrez','77 2nd Junction','fgutierrezf@state.gov','7-(350)624-2924'),(17,'1234','Bonnie','Black','78913 Pawling Way','bblackg@networksolutions.com','4-(683)107-6109'),(18,'1234','Gary','Daniels','1824 Judy Plaza','gdanielsh@linkedin.com','7-(636)787-7240'),(19,'1234','Edward','Russell','9123 Kropf Center','erusselli@friendfeed.com','3-(913)208-4954'),(20,'1234','Kathleen','Cole','56 Duke Road','kcolej@marriott.com','9-(546)739-9058'),(21,'1234','Kelly','Pierce','5 Warner Circle','kpiercek@liveinternet.ru','7-(815)808-3482'),(22,'1234','David','Sanders','69 Westport Street','dsandersl@un.org','7-(229)369-9027'),(23,'1234','Paul','Daniels','2 Muir Center','pdanielsm@java.com','4-(116)178-0040'),(24,'1234','Anne','Cole','1037 Warner Junction','acolen@bluehost.com','6-(247)121-0412'),(25,'1234','Andrew','Garza','92316 Prairie Rose Junction','agarzao@last.fm','2-(979)870-6771'),(26,'1234','Willie','Peters','7495 Raven Hill','wpetersp@networkadvertising.org','5-(015)915-4533'),(27,'1234','Tina','Brooks','98 Algoma Plaza','tbrooksq@icq.com','5-(664)414-3433'),(28,'1234','Phyllis','Burke','7 Schiller Parkway','pburker@addthis.com','4-(813)451-8147'),(29,'1234','Harold','Dean','7 Lake View Way','hdeans@g.co','3-(290)225-1959'),(30,'1234','Janet','Wells','11 Chinook Terrace','jwellst@slideshare.net','2-(733)757-7900'),(31,'1234','Betty','Bennett','9709 Golf View Alley','bbennettu@cocolog-nifty.com','2-(157)219-3622'),(32,'1234','Judy','Torres','3904 Village Street','jtorresv@linkedin.com','8-(962)590-3170'),(33,'1234','Thomas','Garcia','946 Maple Wood Hill','tgarciaw@noaa.gov','0-(943)110-1144'),(34,'1234','Albert','Rose','121 Almo Place','arosex@cdbaby.com','0-(554)239-1110'),(35,'1234','Earl','Harris','5462 Mariners Cove Lane','eharrisy@amazon.de','7-(780)813-0963'),(36,'1234','Joyce','Carr','1 Schurz Terrace','jcarrz@1und1.de','1-(134)221-7393'),(37,'1234','Charles','Bennett','03319 Hollow Ridge Plaza','cbennett10@taobao.com','2-(793)123-3663'),(38,'1234','Teresa','Harris','7 Carpenter Center','tharris11@cnbc.com','8-(913)164-3005'),(39,'1234','Jane','Thomas','1 Mitchell Center','jthomas12@weebly.com','1-(401)639-4728'),(40,'1234','Kenneth','Anderson','8 Dapin Park','kanderson13@rediff.com','8-(998)713-1766'),(41,'1234','Carolyn','Stewart','04329 Cody Street','cstewart14@behance.net','0-(765)121-7369'),(42,'1234','Deborah','Bennett','722 Sycamore Road','dbennett15@cdbaby.com','2-(310)523-0403'),(43,'1234','Kenneth','Fields','278 Sunfield Alley','kfields16@w3.org','9-(176)949-0481'),(44,'1234','Debra','Burton','42135 Bayside Point','dburton17@imgur.com','9-(421)353-4301'),(45,'1234','Robin','Myers','54748 Sunbrook Plaza','rmyers18@state.tx.us','7-(374)700-7961'),(46,'1234','Gloria','Clark','749 Cordelia Crossing','gclark19@cpanel.net','5-(622)175-0389'),(47,'1234','Larry','Howell','004 Hoffman Alley','lhowell1a@samsung.com','9-(656)401-9629'),(48,'1234','Ernest','Watson','67981 Sunbrook Parkway','ewatson1b@discovery.com','8-(153)207-6904'),(49,'1234','Robert','Lane','9 Hooker Avenue','rlane1c@reference.com','0-(600)317-5070'),(50,'1234','Wayne','Baker','78 Lighthouse Bay Court','wbaker1d@yolasite.com','6-(566)948-7051'),(51,'1234','Melissa','Flores','77 Macpherson Place','mflores1e@cisco.com','8-(070)335-7854'),(52,'1234','Jeffrey','Bradley','270 Valley Edge Junction','jbradley1f@time.com','2-(594)750-7491'),(53,'1234','George','Hall','731 Gateway Drive','ghall1g@privacy.gov.au','5-(468)963-1138'),(54,'1234','Jane','Kelley','510 Hayes Court','jkelley1h@howstuffworks.com','3-(971)840-5630'),(55,'1234','Jonathan','Crawford','55580 Village Green Alley','jcrawford1i@cmu.edu','5-(464)126-0403'),(56,'1234','Kelly','Knight','3 Commercial Avenue','kknight1j@gnu.org','6-(581)602-0666'),(57,'1234','Christopher','Harvey','0 Vernon Way','charvey1k@feedburner.com','2-(560)056-0497'),(58,'1234','Cynthia','Watkins','6743 Morningstar Point','cwatkins1l@sciencedirect.com','6-(347)683-6524'),(59,'1234','Carl','Snyder','77 Talmadge Park','csnyder1m@harvard.edu','0-(458)501-8772'),(60,'1234','Ralph','Cook','4805 Londonderry Pass','rcook1n@wikispaces.com','9-(078)829-6321'),(61,'1234','Emily','Henderson','8148 Reindahl Road','ehenderson1o@bluehost.com','1-(830)445-7505'),(62,'1234','Donna','Cook','8268 Jana Avenue','dcook1p@washingtonpost.com','0-(840)339-6426'),(63,'1234','Henry','Hansen','7384 Manitowish Point','hhansen1q@webnode.com','0-(276)966-5716'),(64,'1234','Billy','Mcdonald','4 Morrow Lane','bmcdonald1r@bigcartel.com','5-(851)778-1597'),(65,'1234','Martha','Brooks','201 Mandrake Lane','mbrooks1s@seesaa.net','6-(136)388-5602'),(66,'1234','Bonnie','Hudson','1 Katie Parkway','bhudson1t@adobe.com','4-(672)839-2770'),(67,'1234','Sarah','Gomez','06267 Lunder Court','sgomez1u@samsung.com','9-(838)120-2137'),(68,'1234','Sarah','Fernandez','6496 Vernon Avenue','sfernandez1v@youku.com','9-(457)585-9177'),(69,'1234','Henry','Dixon','0298 Waubesa Pass','hdixon1w@shinystat.com','9-(801)731-1667'),(70,'1234','Alice','Richards','31793 Monterey Terrace','arichards1x@mashable.com','2-(086)905-3488'),(71,'1234','Katherine','Foster','32 Memorial Center','kfoster1y@bloglovin.com','3-(309)360-5405'),(72,'1234','Steven','Austin','56 Corry Crossing','saustin1z@google.ru','7-(362)128-8264'),(73,'1234','Jason','Wells','4 Hermina Crossing','jwells20@huffingtonpost.com','0-(575)098-8047'),(74,'1234','Dorothy','Wilson','38 Talisman Hill','dwilson21@webnode.com','3-(153)508-2082'),(75,'1234','Jonathan','Lopez','54698 Acker Alley','jlopez22@ebay.co.uk','8-(767)829-4398'),(76,'1234','Eric','Rice','83 Coolidge Trail','erice23@github.io','0-(941)772-0952'),(77,'1234','John','Phillips','96 Anzinger Junction','jphillips24@feedburner.com','0-(859)956-0034'),(78,'1234','Susan','Hill','862 Boyd Terrace','shill25@latimes.com','6-(886)292-9722'),(79,'1234','Carl','Sims','807 Utah Drive','csims26@howstuffworks.com','0-(203)517-9707'),(80,'1234','Steve','Gonzales','091 Sugar Avenue','sgonzales27@google.cn','6-(655)688-5668'),(81,'1234','Jacqueline','Larson','432 Morrow Alley','jlarson28@canalblog.com','0-(154)483-8812'),(82,'1234','Terry','Torres','96 Cardinal Terrace','ttorres29@springer.com','3-(413)219-2476'),(83,'1234','Heather','Dixon','438 Dexter Court','hdixon2a@ucsd.edu','7-(705)758-0084'),(84,'1234','Jacqueline','Rose','67 Marquette Place','jrose2b@infoseek.co.jp','4-(394)041-0077'),(85,'1234','Louis','Burns','2971 Harper Court','lburns2c@scribd.com','4-(005)513-1895'),(86,'1234','George','Powell','3552 Roth Street','gpowell2d@seattletimes.com','2-(303)031-3417'),(87,'1234','Henry','Fields','3116 Lyons Hill','hfields2e@alexa.com','2-(446)583-0644'),(88,'1234','Bruce','Flores','0461 Cordelia Place','bflores2f@arizona.edu','3-(042)116-7584'),(89,'1234','Raymond','Carroll','339 Helena Crossing','rcarroll2g@washington.edu','5-(734)467-3205'),(90,'1234','Deborah','Reid','373 Packers Park','dreid2h@dot.gov','3-(079)537-6029'),(91,'1234','Angela','Knight','7807 Di Loreto Road','aknight2i@xinhuanet.com','7-(631)379-1275'),(92,'1234','Kimberly','Gonzales','371 Pankratz Center','kgonzales2j@example.com','7-(055)064-4408'),(93,'1234','Patrick','King','5877 Morrow Parkway','pking2k@bbc.co.uk','2-(634)166-6929'),(94,'1234','Michael','Schmidt','68 Main Avenue','mschmidt2l@nationalgeographic.com','2-(369)545-8158'),(95,'1234','Denise','Jenkins','1280 Warrior Plaza','djenkins2m@ted.com','7-(225)267-2548'),(96,'1234','Antonio','Stanley','70978 Schiller Street','astanley2n@fastcompany.com','1-(552)675-0927'),(97,'1234','Julia','Woods','63 Kedzie Point','jwoods2o@nifty.com','0-(476)308-3622'),(98,'1234','Jeremy','Sullivan','6232 Northport Park','jsullivan2p@mac.com','9-(215)244-3263'),(99,'1234','Melissa','Sanders','00 Nobel Street','msanders2q@1und1.de','7-(791)588-8344'),(100,'1234','Stephanie','Jacobs','60472 Charing Cross Crossing','sjacobs2r@ezinearticles.com','2-(850)853-4499');
/*!40000 ALTER TABLE `Customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrderRecords`
--

DROP TABLE IF EXISTS `OrderRecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OrderRecords` (
  `orderID` int(9) NOT NULL,
  `orderRecordID` int(3) NOT NULL,
  `productID` int(9) NOT NULL,
  `numItems` int(3) NOT NULL,
  PRIMARY KEY (`orderID`,`orderRecordID`),
  KEY `productID` (`productID`),
  CONSTRAINT `orderrecords_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `Orders` (`orderID`),
  CONSTRAINT `orderrecords_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `Products` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrderRecords`
--

LOCK TABLES `OrderRecords` WRITE;
/*!40000 ALTER TABLE `OrderRecords` DISABLE KEYS */;
INSERT INTO `OrderRecords` VALUES (1,1,43,8),(5,1,169,7),(6,1,78,6),(8,1,176,5),(10,1,95,5),(19,1,10,7),(20,1,79,5),(21,1,54,6),(23,1,77,3);
/*!40000 ALTER TABLE `OrderRecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `orderID` int(9) NOT NULL,
  `customerID` int(9) NOT NULL,
  `date` date NOT NULL,
  `totalPrice` decimal(9,2) NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customers` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (1,87,'2014-05-14',3.00),(2,37,'2014-08-10',1.00),(3,31,'2015-03-05',10.00),(4,38,'2014-08-08',5.00),(5,54,'2014-08-19',2.00),(6,10,'2014-05-21',4.00),(7,79,'2015-04-29',6.00),(8,36,'2014-05-05',1.00),(9,20,'2015-03-18',4.00),(10,72,'2014-06-19',1.00),(11,40,'2014-12-13',9.00),(12,34,'2014-09-29',7.00),(13,29,'2015-02-16',6.00),(14,60,'2014-09-05',3.00),(15,27,'2015-04-22',7.00),(16,53,'2015-02-08',8.00),(17,22,'2014-09-09',10.00),(18,2,'2014-05-31',2.00),(19,45,'2014-09-24',4.00),(20,55,'2014-06-05',1.00),(21,79,'2014-06-17',1.00),(22,73,'2014-07-10',7.00),(23,5,'2015-02-17',4.00),(24,59,'2014-12-25',4.00),(25,6,'2015-01-28',9.00),(26,96,'2015-01-08',8.00),(27,24,'2014-10-02',7.00),(28,22,'2015-02-24',2.00),(29,5,'2014-12-22',8.00),(30,30,'2014-12-08',3.00);
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProductTypes`
--

DROP TABLE IF EXISTS `ProductTypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProductTypes` (
  `productTypeID` int(11) NOT NULL,
  `clothes` varchar(45) NOT NULL,
  `colour` varchar(30) NOT NULL,
  `style` varchar(30) NOT NULL,
  `image` varchar(60) NOT NULL,
  `size` varchar(3) NOT NULL,
  PRIMARY KEY (`productTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProductTypes`
--

LOCK TABLES `ProductTypes` WRITE;
/*!40000 ALTER TABLE `ProductTypes` DISABLE KEYS */;
INSERT INTO `ProductTypes` VALUES (1,'underpants','grey','simple','path','XL'),(2,'underpants','white','striped','path','L'),(3,'underpants','grey','striped','path','XXL'),(4,'shocks','white','striped','path','XXL'),(5,'underpants','red','striped','path','XXL'),(6,'underpants','yellow','simple','path','XL'),(7,'underpants','grey','striped','path','XL'),(8,'underpants','white','simple','path','XL'),(9,'shocks','white','striped','path','XL'),(10,'shirt','white','striped','path','XXL'),(11,'underpants','white','simple','path','L'),(12,'underpants','white','simple','path','L'),(13,'underpants','yellow','simple','path','XXL'),(14,'shocks','white','simple','path','XXL'),(15,'sweater','grey','striped','path','S'),(16,'underpants','yellow','striped','path','XL'),(17,'sweater','yellow','striped','path','L'),(18,'shocks','grey','simple','path','XXL'),(19,'underpants','white','simple','path','L'),(20,'sweater','yellow','simple','path','XXL'),(21,'sweater','grey','striped','path','XL'),(22,'underpants','grey','simple','path','XXL'),(23,'shocks','white','striped','path','XXL'),(24,'underpants','white','simple','path','XXL'),(25,'shocks','white','striped','path','M'),(26,'underpants','grey','striped','path','XXL'),(27,'underpants','white','striped','path','S'),(28,'underpants','white','simple','path','XXL'),(29,'underpants','white','simple','path','XXL'),(30,'sweater','grey','simple','path','XXL'),(31,'underpants','white','simple','path','XL'),(32,'underpants','red','simple','path','XXL'),(33,'underpants','white','striped','path','L'),(34,'sweater','grey','simple','path','XXL'),(35,'sweater','white','simple','path','M'),(36,'shirt','white','simple','path','XL'),(37,'underpants','grey','simple','path','XL'),(38,'shocks','white','striped','path','XL'),(39,'shocks','yellow','striped','path','XXL'),(40,'underpants','yellow','striped','path','XL'),(41,'underpants','white','striped','path','XL'),(42,'sweater','grey','striped','path','XXL'),(43,'underpants','grey','simple','path','XL'),(44,'trousers','white','striped','path','XXL'),(45,'shirt','white','simple','path','XL'),(46,'sweater','yellow','striped','path','XXL'),(47,'sweater','grey','simple','path','XXL'),(48,'underpants','white','striped','path','XXL'),(49,'shocks','white','striped','path','XXL'),(50,'underpants','white','simple','path','XXL'),(51,'shocks','white','simple','path','XXL'),(52,'underpants','grey','striped','path','XL'),(53,'shocks','white','striped','path','XXL'),(54,'sweater','white','striped','path','XXL'),(55,'shocks','white','striped','path','XL'),(56,'shocks','grey','simple','path','XXL'),(57,'underpants','white','simple','path','XXL'),(58,'underpants','white','striped','path','XXL'),(59,'underpants','grey','striped','path','XXL'),(60,'underpants','white','striped','path','S'),(61,'shocks','brown','striped','path','XXL'),(62,'sweater','grey','simple','path','XXL'),(63,'shocks','white','striped','path','XXL'),(64,'shocks','white','simple','path','XL'),(65,'sweater','white','striped','path','XXL'),(66,'shocks','white','simple','path','L'),(67,'shirt','white','striped','path','XXL'),(68,'underpants','white','striped','path','S'),(69,'t-shirt','white','simple','path','XXL'),(70,'shirt','grey','simple','path','XL'),(71,'underpants','blue','simple','path','XL'),(72,'shirt','white','simple','path','XXL'),(73,'underpants','white','striped','path','S'),(74,'underpants','white','striped','path','XXL'),(75,'underpants','grey','striped','path','XL'),(76,'shocks','grey','striped','path','XL'),(77,'shirt','grey','simple','path','XL'),(78,'sweater','white','simple','path','XXL'),(79,'underpants','grey','striped','path','XL'),(80,'underpants','grey','striped','path','XXL'),(81,'underpants','white','simple','path','XXL'),(82,'underpants','brown','striped','path','XXL'),(83,'underpants','white','striped','path','S'),(84,'underpants','grey','simple','path','S'),(85,'underpants','grey','simple','path','XXL'),(86,'shocks','yellow','simple','path','M'),(87,'underpants','grey','simple','path','XL'),(88,'shocks','white','simple','path','XL'),(89,'trousers','white','striped','path','S'),(90,'underpants','white','simple','path','XL'),(91,'underpants','brown','simple','path','XXL'),(92,'shocks','white','simple','path','XXL'),(93,'underpants','white','simple','path','XXL'),(94,'t-shirt','white','striped','path','XXL'),(95,'shirt','white','striped','path','L'),(96,'sweater','yellow','striped','path','L'),(97,'underpants','white','simple','path','XXL'),(98,'underpants','white','striped','path','XXL'),(99,'underpants','grey','simple','path','XL'),(100,'underpants','grey','simple','path','XXL');
/*!40000 ALTER TABLE `ProductTypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Products`
--

DROP TABLE IF EXISTS `Products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Products` (
  `productID` int(9) NOT NULL,
  `productTypeID` int(9) NOT NULL,
  `brand` varchar(25) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Products`
--

LOCK TABLES `Products` WRITE;
/*!40000 ALTER TABLE `Products` DISABLE KEYS */;
INSERT INTO `Products` VALUES (1,44,'asics','rellenar',8.64,5),(2,100,'trango','rellenar',27.03,13),(3,84,'puma','rellenar',25.61,10),(4,76,'pull&bear','rellenar',25.47,1),(5,96,'qechua','rellenar',17.73,4),(6,80,'qechua','rellenar',29.55,14),(7,31,'qechua','rellenar',19.52,2),(8,27,'qechua','rellenar',23.36,14),(9,1,'puma','rellenar',1.75,4),(10,64,'domyos','rellenar',12.98,11),(11,44,'trango','rellenar',15.81,14),(12,14,'trango','rellenar',2.57,1),(13,11,'trango','rellenar',5.30,5),(14,95,'puma','rellenar',21.19,3),(15,42,'trango','rellenar',4.74,14),(16,97,'trango','rellenar',3.24,15),(17,30,'qechua','rellenar',11.87,7),(18,22,'qechua','rellenar',11.10,10),(19,16,'asics','rellenar',20.64,2),(20,74,'trango','rellenar',17.17,11),(21,74,'trango','rellenar',15.50,6),(22,23,'trango','rellenar',2.32,3),(23,52,'trango','rellenar',3.96,8),(24,17,'qechua','rellenar',6.10,7),(25,82,'trango','rellenar',25.52,8),(26,70,'trango','rellenar',24.91,2),(27,86,'qechua','rellenar',3.94,15),(28,52,'trango','rellenar',24.51,10),(29,42,'trango','rellenar',22.19,6),(30,6,'puma','rellenar',26.32,13),(31,83,'trango','rellenar',11.90,6),(32,51,'nike','rellenar',26.14,1),(33,41,'trango','rellenar',17.59,10),(34,76,'puma','rellenar',10.77,4),(35,67,'qechua','rellenar',16.42,5),(36,2,'puma','rellenar',14.91,4),(37,73,'qechua','rellenar',13.91,15),(38,29,'trango','rellenar',25.17,5),(39,36,'asics','rellenar',1.14,12),(40,57,'qechua','rellenar',2.68,10),(41,81,'qechua','rellenar',8.48,8),(42,63,'qechua','rellenar',10.77,1),(43,16,'qechua','rellenar',28.24,3),(44,22,'trango','rellenar',17.50,6),(45,52,'trango','rellenar',12.23,15),(46,41,'trango','rellenar',15.58,8),(47,87,'trango','rellenar',4.49,15),(48,43,'trango','rellenar',24.78,11),(49,51,'trango','rellenar',16.22,14),(50,93,'trango','rellenar',15.06,6),(51,35,'qechua','rellenar',9.73,15),(52,79,'asics','rellenar',5.31,7),(53,13,'trango','rellenar',9.24,8),(54,30,'qechua','rellenar',11.98,14),(55,88,'qechua','rellenar',14.00,13),(56,67,'asics','rellenar',23.06,10),(57,25,'trango','rellenar',21.02,4),(58,90,'trango','rellenar',6.96,1),(59,49,'asics','rellenar',10.08,7),(60,15,'qechua','rellenar',15.16,10),(61,19,'trango','rellenar',26.91,6),(62,21,'qechua','rellenar',22.97,8),(63,63,'trango','rellenar',5.38,10),(64,94,'asics','rellenar',28.06,3),(65,81,'qechua','rellenar',21.09,9),(66,35,'pull&bear','rellenar',13.38,2),(67,54,'domyos','rellenar',6.32,8),(68,4,'pull&bear','rellenar',3.02,13),(69,86,'trango','rellenar',25.74,8),(70,5,'trango','rellenar',22.11,13),(71,62,'trango','rellenar',25.93,15),(72,3,'asics','rellenar',11.20,9),(73,21,'trango','rellenar',15.40,8),(74,36,'qechua','rellenar',23.25,5),(75,55,'trango','rellenar',4.36,12),(76,39,'qechua','rellenar',19.75,9),(77,25,'qechua','rellenar',9.30,14),(78,20,'nike','rellenar',21.72,4),(79,44,'trango','rellenar',7.99,4),(80,97,'qechua','rellenar',22.01,7),(81,11,'qechua','rellenar',8.67,7),(82,82,'qechua','rellenar',12.70,4),(83,45,'asics','rellenar',11.03,1),(84,27,'trango','rellenar',8.08,3),(85,62,'trango','rellenar',11.40,4),(86,80,'trango','rellenar',20.60,11),(87,34,'trango','rellenar',5.82,2),(88,81,'trango','rellenar',18.67,5),(89,21,'asics','rellenar',18.61,4),(90,91,'trango','rellenar',13.13,4),(91,70,'qechua','rellenar',25.89,8),(92,94,'qechua','rellenar',6.71,4),(93,3,'trango','rellenar',3.16,8),(94,48,'trango','rellenar',5.58,7),(95,99,'qechua','rellenar',29.63,5),(96,88,'domyos','rellenar',28.51,4),(97,24,'asics','rellenar',28.51,2),(98,70,'trango','rellenar',10.92,4),(99,54,'trango','rellenar',24.45,5),(100,68,'trango','rellenar',27.64,9),(101,42,'qechua','rellenar',14.91,3),(102,58,'domyos','rellenar',24.75,3),(103,51,'trango','rellenar',12.95,2),(104,26,'asics','rellenar',27.26,6),(105,51,'qechua','rellenar',12.96,12),(106,71,'qechua','rellenar',18.74,14),(107,17,'asics','rellenar',12.53,2),(108,39,'qechua','rellenar',9.70,12),(109,51,'puma','rellenar',27.37,9),(110,61,'trango','rellenar',12.73,7),(111,69,'trango','rellenar',29.72,9),(112,49,'asics','rellenar',1.95,5),(113,10,'qechua','rellenar',17.19,1),(114,56,'trango','rellenar',22.30,8),(115,84,'qechua','rellenar',16.85,3),(116,48,'trango','rellenar',20.82,8),(117,23,'trango','rellenar',2.61,6),(118,27,'asics','rellenar',17.01,15),(119,77,'trango','rellenar',29.19,10),(120,99,'qechua','rellenar',14.56,6),(121,46,'asics','rellenar',14.25,13),(122,4,'domyos','rellenar',23.12,7),(123,13,'asics','rellenar',15.33,14),(124,44,'pull&bear','rellenar',1.82,10),(125,94,'trango','rellenar',21.57,3),(126,84,'qechua','rellenar',3.76,9),(127,61,'puma','rellenar',25.01,5),(128,52,'qechua','rellenar',18.10,10),(129,100,'trango','rellenar',5.20,14),(130,69,'domyos','rellenar',3.19,10),(131,96,'qechua','rellenar',17.00,10),(132,44,'qechua','rellenar',2.63,9),(133,55,'qechua','rellenar',9.63,3),(134,89,'asics','rellenar',16.56,5),(135,61,'qechua','rellenar',28.34,12),(136,71,'trango','rellenar',29.14,2),(137,66,'trango','rellenar',16.12,14),(138,44,'qechua','rellenar',7.43,4),(139,66,'asics','rellenar',22.43,6),(140,46,'qechua','rellenar',7.16,2),(141,33,'qechua','rellenar',20.93,12),(142,27,'qechua','rellenar',20.96,4),(143,7,'qechua','rellenar',28.64,6),(144,6,'qechua','rellenar',14.91,4),(145,26,'asics','rellenar',16.45,3),(146,10,'qechua','rellenar',7.84,8),(147,20,'trango','rellenar',1.52,6),(148,17,'trango','rellenar',27.10,13),(149,81,'nike','rellenar',10.24,4),(150,34,'puma','rellenar',18.97,6),(151,42,'trango','rellenar',10.73,4),(152,35,'puma','rellenar',5.72,15),(153,85,'asics','rellenar',7.31,6),(154,93,'trango','rellenar',22.91,10),(155,13,'trango','rellenar',12.39,15),(156,50,'trango','rellenar',25.76,10),(157,10,'qechua','rellenar',2.23,14),(158,78,'pull&bear','rellenar',24.32,10),(159,73,'trango','rellenar',28.26,11),(160,48,'puma','rellenar',12.88,6),(161,9,'qechua','rellenar',28.29,2),(162,72,'trango','rellenar',9.00,14),(163,38,'trango','rellenar',13.80,5),(164,38,'qechua','rellenar',10.02,11),(165,19,'asics','rellenar',11.29,8),(166,43,'asics','rellenar',23.80,5),(167,31,'nike','rellenar',5.67,11),(168,11,'trango','rellenar',5.55,11),(169,46,'qechua','rellenar',10.02,14),(170,30,'trango','rellenar',29.25,6),(171,19,'qechua','rellenar',19.70,2),(172,2,'trango','rellenar',3.91,11),(173,78,'trango','rellenar',6.50,12),(174,69,'trango','rellenar',23.74,12),(175,26,'qechua','rellenar',1.19,8),(176,40,'qechua','rellenar',1.81,3),(177,73,'trango','rellenar',6.68,13),(178,79,'asics','rellenar',27.72,7),(179,21,'qechua','rellenar',17.06,14),(180,43,'puma','rellenar',2.72,2),(181,96,'qechua','rellenar',7.05,5),(182,37,'trango','rellenar',23.26,13),(183,1,'trango','rellenar',14.84,3),(184,69,'trango','rellenar',4.14,13),(185,3,'trango','rellenar',28.47,4),(186,27,'pull&bear','rellenar',21.55,4),(187,96,'trango','rellenar',17.51,15),(188,84,'asics','rellenar',1.65,10),(189,89,'asics','rellenar',2.86,2),(190,64,'trango','rellenar',3.52,7),(191,18,'asics','rellenar',29.95,10),(192,22,'puma','rellenar',16.36,2),(193,33,'trango','rellenar',1.82,10),(194,30,'qechua','rellenar',22.33,14),(195,70,'puma','rellenar',8.32,10),(196,79,'puma','rellenar',25.22,4),(197,78,'trango','rellenar',10.87,7),(198,26,'trango','rellenar',11.68,9),(199,85,'trango','rellenar',10.76,6),(200,100,'trango','rellenar',19.50,9);
/*!40000 ALTER TABLE `Products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ShoppingCart`
--

DROP TABLE IF EXISTS `ShoppingCart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ShoppingCart` (
  `customerID` int(9) NOT NULL,
  `productID` int(9) NOT NULL,
  `numItems` int(3) NOT NULL,
  PRIMARY KEY (`customerID`,`productID`),
  KEY `productID` (`productID`),
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customers` (`customerID`),
  CONSTRAINT `shoppingcart_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `Products` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ShoppingCart`
--

LOCK TABLES `ShoppingCart` WRITE;
/*!40000 ALTER TABLE `ShoppingCart` DISABLE KEYS */;
INSERT INTO `ShoppingCart` VALUES (2,63,10),(4,80,4),(6,193,8),(7,168,4),(12,116,7),(12,151,6),(13,158,6),(14,136,7),(14,146,4),(16,174,5),(17,50,10),(18,32,4),(19,88,4),(19,183,7),(20,19,2),(20,44,2),(20,108,10),(21,34,8),(21,40,8),(21,120,1),(24,143,6),(25,178,3),(26,99,1),(28,88,9),(29,74,2),(30,66,6),(30,187,1),(30,192,10),(31,74,9),(31,110,4),(31,134,6),(32,86,6),(32,93,8),(32,116,3),(32,136,5),(34,130,8),(37,67,1),(37,104,10),(37,160,5),(38,140,1),(40,56,1),(42,112,4),(45,131,4),(50,34,9),(50,52,6),(50,173,6),(51,155,5),(55,38,8),(56,51,9),(58,9,3),(59,165,4),(59,182,1),(59,187,4),(60,79,2),(60,87,10),(60,165,7),(60,170,5),(60,193,4),(62,164,9),(63,164,2),(66,168,2),(66,181,1),(68,12,10),(71,58,7),(71,157,8),(73,122,4),(73,150,5),(74,188,8),(75,107,7),(75,117,4),(75,194,8),(76,99,5),(77,7,3),(77,103,2),(78,125,6),(78,179,7),(79,56,3),(80,130,6),(81,20,7),(81,63,9),(81,97,2),(82,25,4),(82,133,1),(82,197,10),(85,55,7),(85,142,7),(85,164,6),(85,180,4),(85,192,1),(88,85,2),(88,88,3),(89,17,4),(90,15,1),(90,53,7),(90,61,2),(93,7,5),(94,46,8),(94,162,3),(99,2,10),(100,55,10);
/*!40000 ALTER TABLE `ShoppingCart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'CatalogueDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-15 18:50:16
