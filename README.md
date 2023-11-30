# AzureCosmosDbDemo
Sample Project of working/usage of Azure Cosmos Db Emulator for local development
Follow below steps :-
1.	Download Azure Cosmos DB emulator from link: Click here to download Azure Cosmos DB Emulator.
  a.	After successful installation of Azure Cosmos DB Emulator, Path will be like e.g.  “C:\Program Files\Azure Cosmos DB Emulator”.
  b.	Open command prompt to path where Azure Cosmos DB Emulator is installed and execute this command > “Microsoft.Azure.Cosmos.Emulator.exe /GenCert”.
  c.	Azure Cosmos DB Emulator generated successfully.
2.	Press “Windows+R” then type “mmc”. 
  a.	Console1 window will pop-up. In File tab, click on  “Add/Remove snap-in”. 
  b.	Other window will pop-up, select Certificates from Available snap-ins then click on “Add >”. 
  c.	It will ask for account, select “Computer account”, click on Next, then tik “Local Computer” and Finish.
  d.	Click on “OK”, then Certificates (Local Computer) will appear in Console Root. Deep down in Personal Folder within Certificates and look for certificates whose Friendly Name is “DocumentDbEmulatorCertificate” OR “CosmosEmulatorSecrets”.
  e.	Right click on one of the certificate, You will find export option under All tasks. Choose “do not export the private key”, then Choose File Formate as “DER encoded binary X 509(.CER), then give any comfortable name to cert file. That file will saved in
      “C:\Windows\System32\ourCertFile.cer”
  f.	Azure Cosmos DB Emulator SSL certificate is exported successfully, now need to add to JVM.
4.	Copy that exported certificate file to your JVM compiler folder e.g. “C:\Program Files\Java\jre1.8.0_333\lib\security” OR “C:\Program Files\Java\jdk1.8.0_333\jre\lib\security” OR whichever java version you are using, and paste it.
  a.	Open command prompt as Administrator to that path and execute this command > “keytool -import -keystore cacerts  -alias {ourCertFile/AnyComfortableName} -file ourCertFile.cer”.
  b.	Then it will ask for password = “changeit”, for confirmation type “yes” or ‘y’ and press enter.
  c.	Your Certificate added to keystore successfully.
      Now you will be able to do operations on Azure Cosmos DB Emulator and can be used for local development purpose.


