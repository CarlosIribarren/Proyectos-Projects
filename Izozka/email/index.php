<?php

require_once('class.phpmailer.php');
include("class.smtp.php"); // optional, gets called from within class.phpmailer.php if not already loaded


    $nameField = "EMAIL DE PRUEBA 1";
    $emailField = "izozkadenda@gmail.com";
    $messageField = "mezua";
    $phoneField = "654";
    $cityField = "irun";

$mail = new PHPMailer(true); // the true param means it will throw exceptions on errors, which we need to catch

$mail->IsSMTP(); // telling the class to use SMTP

$body .= $nameField;

try {
     //$mail->Host       = "mail.gmail.com"; // SMTP server
      $mail->SMTPDebug  = 2;                     // enables SMTP debug information (for testing)
      $mail->SMTPAuth   = true;                  // enable SMTP authentication
      $mail->SMTPSecure = "ssl";                 // sets the prefix to the servier
      $mail->Host       = "smtp.gmail.com";      // sets GMAIL as the SMTP server
      $mail->Port       = 465;   // set the SMTP port for the GMAIL server
      $mail->SMTPKeepAlive = true;
      $mail->Mailer = "smtp";
      $mail->Username   = "izozkadenda@gmail.com";  // GMAIL username
      $mail->Password   = "pelotapaleta";            // GMAIL password
      $mail->AddAddress('xibo73@hotmail.com', 'xi');
      $mail->AddAddress('izozkadenda@gmail.com', 'abc');
      $mail->SetFrom('izozkadenda@gmail.com', 'Izozka Pagina Web');
      $mail->Subject = 'Izozka - Mensaje de Contacto ';
      $mail->AltBody = 'To view the message, please use an HTML compatible email viewer!'; // optional - MsgHTML will create an alternate automatically
      $mail->MsgHTML($body);
      $mail->Send();
      echo "Message Sent OK</p>\n";
} catch (phpmailerException $e) {
      echo $e->errorMessage(); //Pretty error messages from PHPMailer
} catch (Exception $e) {
      echo $e->getMessage(); //Boring error messages from anything else!
}

?>
