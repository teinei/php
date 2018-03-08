<?php
//declare
$stuff = array("a","b");
echo $stuff[1];
//[1]=>"a" [2]=>"b"

$stuff = array("name"=>"Chunck","course"=>"wa4e");

//print array
print_r($stuff);
var_dump($stuff);

$va = array();
$va[]="hellow";
$va[]="world";

$za=array();
$za["name"]="chunck";
$za["course"]="wa4e";

//array functions
isset($va["key"]);
//return ture if key is set