############################################################################### 
 
###########Define Variables######## 
 
$fromaddress ="IRIS_UIUX_QA@optum.com"
$toaddress = "yogesh_bhatt2@optum.com , din_dayal@optum.com"
#$bccaddress = "krishnamohan_j@optum.com , sandeep_jain_2@optum.com " 
#$CCaddress = "Mahsh.Sharma@labtest.com" 
$Subject = "Test Execution Report" 
$body = get-content \DD\Automation\GitAutomationFramework\ORx_iris_uiux_qe\other-files\mailBody.html 
$attachment = "C:\DD\Automation\GitAutomationFramework\ORx_iris_uiux_qe\test-output\UiUxTestCasesReport.html" 
$smtpserver = "ctc-smtp-relay-ose.optum.com"
 
#################################### 
 
$message = new-object System.Net.Mail.MailMessage 
$message.From = $fromaddress 
$message.To.Add($toaddress) 
#$message.CC.Add($CCaddress) 
#$message.Bcc.Add($bccaddress) 
$message.IsBodyHtml = $True 
$message.Subject = $Subject 
$attach = new-object Net.Mail.Attachment($attachment) 
$message.Attachments.Add($attach) 
$message.body = $body 
$smtp = new-object Net.Mail.SmtpClient($smtpserver) 
$smtp.Send($message) 
 
#################################################################################