<h1>Week 3 Graded Quiz: Interactive Web Pages</h1>


<form action="">
<h2>1</h2>
<p>
What is the purpose of initializing the global image variables to null in the green screen
web page?
</p>
<input type="radio" name="q1" value="1"/>
The code can check if the image is null before processing it.<br>
<input type="radio" name="q1" value="2"/>
Global variables must be initialized when they are declared.<br>
<input type="radio" name="q1" value="3"/>
The code clears the canvas before performing the green screen algorithm.<br>

<h2>2</h2>
<p>
You would like to display an alert message if the image variable for the foreground image
fgImage is not loaded. Which two of the following expressions evaluate to true if the
image is not ready?
</p>
<input type="checkbox" name="q2c1" value="1"/>
fgImage == null<br>
<input type="checkbox" name="q2c2" value="1"/>
!fgImage.complete()<br>
<input type="checkbox" name="q2c3" value="1"/>
fgImage != null<br>
<input type="checkbox" name="q2c4" value="1"/>
fgImage.complete()<br>

<input type="submit"/>
</form>


<?php
	$point=0;
	print_r($_GET);
	if($_GET[q1]==1){
		//
		$point++;
	}
	if($_GET[q2c1]==1&&$_GET[q2c2]==1){
		$point++;
	}
	echo "<br>point is: ";
	print($point);
	//
	//if(isset($_GET)){unset($_GET);}
?>
