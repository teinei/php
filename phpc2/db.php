<!--
//create db
/*
//CREATE DATABASE phpc2;
GRANT ALL ON phpc2.* TO 'fred'@'localhost' IDENTIFIED BY 'zap';
GRANT ALL ON phpc2.* TO 'fred'@'127.0.0.1' IDENTIFIED BY 'zap';
//*/

//create table
/*
CREATE TABLE users (
   user_id INTEGER NOT NULL
     AUTO_INCREMENT KEY,
   name VARCHAR(128),
   email VARCHAR(128),
   password VARCHAR(128),
   INDEX(email)
) ENGINE=InnoDB CHARSET=utf8;
 */

//insert data
/*
INSERT INTO users (name,email,password) VALUES ('Chuck','csev@umich.edu','123');
INSERT INTO users (name,email,password) VALUES ('Glenn','gg@umich.edu','456');
*/
-->

<?php

$pdo = new PDO('mysql:host=localhost;port=3306;dbname=phpc2','fred','zap');
//in windows the port is 3306, in mac its 8889, mamp -> reference -> ports
$stmt = $pdo->query("SELECT * FROM users");
while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
	print_r($row);
	print "<br>";
}

?>
