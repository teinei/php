<h1>week8 lecture2 html input types(count from lecture 0)</h1>
<h2>w8e2.1 password</h2>
<form method="post" action="">
	<p>Account:
	<input type="text" name="account" id="accnt" size="40"/>
	</p>
	<p>Password:
	<input type="password" name="pw" id="password" size="40"/>
	</p>
	
<h2>2.2 radio</h2>
<p>preferred time<br>
	<input type="radio" name="when" value="am">AM<br>
	<input type="radio" name="when" value="pm" checked>PM</p>

<h2>2.3 checkbox</h2>
<p>Class Taken:<br>
	<input type="checkbox" name="class1" value="502" checked/>
		502 Networked Tech<br>
	<input type="checkbox" name="class2" value="539" />
		539 App Engine</p>
	
<h2>2.4 select drop down</h2>
	<p>Which soda:<br>
	<select name="soda" id="">
		<option value="0" selected>---please select---</option>
		<option value="1">coke</option>
		<option value="3">pepsi</option>
	</select>
	
<h2>2.5 text area, block of text</h2>
<p>Tell us about yourself:<br>
	<textarea rows="10" cols="40" id="" name="about">
		I love building web sites in PHP.
	</textarea></p>
	
<h2>2.6 multiselect checkbox</h2>
<p><label for="innp09">Which are awesome</label><br>
<select multiple="multiple" name="code[]" id="inp09">
	<option value="py">Python</option>
	<option value="css">CSS</option>
	<option value="html">html</option> 
	<option value="java">Java</option>
</select>

<h2>2.7 submit</h2>
<p>
<input type="submit" name="dopost" value="submit" />
<input type="button" onclick="location.href='http://www.wa4e.com';return false;"
	value="escape"/></p>

</form>

<?php
print_r($_POST);
