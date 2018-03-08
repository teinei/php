<?php
$oldguess = isset($_POST['guess'])?$_POST['guess']:' ';
?>

<p>Guessing game</p>
<form method="post" >
	<p>input guess
	<input type="text" name="guess" id="guess"
		size="40" 
	 	value="<?= htmlentities($oldguess) ?> "
		/></p>
	<!-- 
	html injection:
	we type:
	"><b>die</b>
	or
	  "<button>text</button> 
	 -->
	<input type="submit"/>

</form>
<?= htmlentities($oldguess) ?>
<br>
<?php echo(htmlentities($oldguess));?>