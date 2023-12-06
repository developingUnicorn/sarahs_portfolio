<?php 

if(isset($_POST['submit'])){
	$name = $_POST['name'];
	$paintingID = $_POST['paintingID'];
	$mailFrom = $_POST['email'];
	$message = $_POST['message'];
	
	$mailTo = "sarah.emilia@outlook.com";
	$headers = "From: ".$mailFrom;
	$txt="Du har fått mail från".$name.".\n\n".$message;
	
	mail($mailTo, $paintingID, $txt, $headers);
	header("Location: index.php?mailsend");
}

?>
