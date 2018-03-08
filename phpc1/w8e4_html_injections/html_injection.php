<?php
$oldguess = isset($_POST['guess'])?$_POST['guess']:' ';
?>

<p>Guessing game</p>
<form method="post" >
	<p>input guess
	<input type="text" name="guess" id="guess"
		size="40" 
		value="<?=$oldguess?>"
		/></p>
	<!-- 
	html injection:
	we type:
	-----
	"><b>die</b>
	-----
	or
	-----
	"/><input type="submit">text</input>
	-----
	 -->
	<input type="submit"/>

</form>
<?= htmlentities($oldguess) ?>
<br>
<?php echo(htmlentities($oldguess));?>