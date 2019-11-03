# Telecoms-Command-Control


<p style="color: red; font-weight: bold">>>>>>  gd2md-html alert:  ERRORs: 0; WARNINGs: 0; ALERTS: 15.</p>
<ul style="color: red; font-weight: bold"><li>See top comment block for details on ERRORs and WARNINGs. <li>In the converted Markdown or HTML, search for inline alerts that start with >>>>>  gd2md-html alert:  for specific instances that need correction.</ul>

<p style="color: red; font-weight: bold">Links to alert messages:</p><a href="#gdcalert1">alert1</a>
<a href="#gdcalert2">alert2</a>
<a href="#gdcalert3">alert3</a>
<a href="#gdcalert4">alert4</a>
<a href="#gdcalert5">alert5</a>
<a href="#gdcalert6">alert6</a>
<a href="#gdcalert7">alert7</a>
<a href="#gdcalert8">alert8</a>
<a href="#gdcalert9">alert9</a>
<a href="#gdcalert10">alert10</a>
<a href="#gdcalert11">alert11</a>
<a href="#gdcalert12">alert12</a>
<a href="#gdcalert13">alert13</a>
<a href="#gdcalert14">alert14</a>
<a href="#gdcalert15">alert15</a>

<p style="color: red; font-weight: bold">>>>>> PLEASE check and correct alert issues and delete this message and the inline alerts.<hr></p>




<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report0.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report0.png "image_tooltip")


**Telecommunication Assignment 1            Command & Control Documentation**

**Name :  Alan Abraham**

**Student Number: 18322576**

**Lab Group: A2**

**Demonstrator: Ali Talpur**

**CONTENTS**

**1 Introduction......................................................................................................... **

**2 Implementation...................................................................................................**

**3 Theory…..............................................................................................................**

**3 Reflection............................................................................................................**

**_Introduction_**

The aim of this assignment was to create a command and control protocol which had the ability to send and receive packets which contain  certain data while learning about socket and threads. In my implementation the four actors that played a part in the main process are namely the C&C server , Broker, Worker1 and Worker2. My implementation of this command and control network allows the C&C server to send a package containing the work description to the broker and the broker being able to relay it to the workers. The workers can then agree or disagree to do the work and sends a package relaying said message back to the broker.



<p id="gdcalert2" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report1.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert3">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report1.png "image_tooltip")


**_Implementation_**

As opposed to other students doing this module I decided to take a simpler approach to this assignment. I make use of four main actors or classes in this assignment. These actors are C&C server, broker, worker1 and worker2 as mentioned above.

Each  actor sends packets and receive packets from each other. I will go into detail about these actors and how I implemented them below.

**_C&C Server (Client Class)_**

The C&C Server stands for the Command and Control Server and in this case I consider it a client. In this assignment the Command and Control Server sends a packet to the broker. This packet contains the work description that is to be sent to the workers. The methods that this class uses are OnReceipt(), Start() and the Main.

The class also contains the constructor for the C&C Server terminal and initialises this terminal in the main.



<p id="gdcalert3" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report2.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert4">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report2.png "image_tooltip")


Above: Image of GUI for C&C Server

_OnReceipt(Packet):_

This function takes a packet that the C&C server receives as a parameter and sends a response to the broker. The response is sent in a packet to the broker and its “OK” technically it’s a form of acknowledgment from the server to the broker that tells the broker that the server did receive the message.



<p id="gdcalert4" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report3.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert5">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report3.png "image_tooltip")


_Start():_

This function initialises the C&C server and it also throws exceptions. When the user types in the terminal it takes input and sends it to the broker as a packet and then it prints out that the packet has been sent successfully if it is received by the broker.



<p id="gdcalert5" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report4.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert6">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report4.png "image_tooltip")
 

_Main()_

This is the main method of the C&C server. This method initialises the terminal for the C&C server within a try-catch statement. When the program ends the main also prints out “Program Completed”.



<p id="gdcalert6" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report5.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert7">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report5.png "image_tooltip")


**_Broker _**

The broker class receives messages from the server and sends those messages to the worker  classes and the workers reply with their availability, port number and worker name. The broker class contains the methods OnReceipt(),Start() and the Main method.



<p id="gdcalert7" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report6.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert8">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report6.png "image_tooltip")


_OnReceipt(Packet)_

This function takes a packet that broker receives from the server as a parameter and sends it to the workers. The work description is sent in a packet from  the broker to  the workers and then the broker receives information from the workers consisting of the workers name, port and availability to work.



<p id="gdcalert8" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report7.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert9">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report7.png "image_tooltip")


_Start()_

This function initialises the broker and it also throws exceptions. When the user types in the terminal it takes input and sends it to the workers as a packet and then it prints out that the packet has been sent successfully if it is received by the workers



<p id="gdcalert9" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report8.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert10">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report8.png "image_tooltip")
.

Main()

This is the main method of the broker class.This method initialises the terminal for the broker within a try-catch statement. When the program ends the main also prints out “Program Completed”.



<p id="gdcalert10" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report9.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert11">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report9.png "image_tooltip")


**_Workers_**

The worker class does work and replies to the broker by sending acknowledgements such as sending worker name,port and availability to work.This class is what I struggled the most on because I couldn’t get the workers to actually do any work which caused a lot of disappointment for myself.



<p id="gdcalert11" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report10.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert12">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report10.png "image_tooltip")
     

<p id="gdcalert12" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report11.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert13">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report11.png "image_tooltip")


_OnReceipt(Packet)_

This function takes a packet that worker receives from the broker as a parameter and sends it to the workers. The work description is sent in a packet from  the broker to  the workers. This function allows the workers to receive the work description and other messages from the broker.



<p id="gdcalert13" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report12.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert14">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report12.png "image_tooltip")


_Start()_

This function initialises the worker class and it also throws exceptions. When the user types in the terminal it takes input and sends it to the broker as a packet and then it prints out that the packet has been sent successfully if it is received by the broker.The packet contains the worker name, port and availability to work.



<p id="gdcalert14" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report13.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert15">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report13.png "image_tooltip")


 Above: Start() method of Worker Class

Main()

This is the main method of the worker class.This method initialises the terminal for the worker within a try-catch statement. When the program ends the main also prints out “Program Completed”.



<p id="gdcalert15" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/Telecoms-Report14.png). Store image on your image server and adjust path/filename if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert16">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/Telecoms-Report14.png "image_tooltip")


**_Theory_**

Where a sender sends data packets to a receiver. Our requirement is that all of the packets fed into the sender must be successfully received by the receiver and arranged in the correct order. The sender can send packets sequentially knowing that they will be received. The task is to develop a system to guarantee that they are received without ﬂaw

**_ Acknowledgements_**

A  solution to the problem that we have could be to only allow the sender to send a single packet at a time. After sending a packet the sender will wait for acknowledgement that the packet was received before sending the next packet. These acknowledgements can be done with ACK packets. The Receiver will send one of these ACK’s upon the receipt of a packet. Acknowledgments were another part of my protocol that I could have improved. I spent so long on the project that by the time I went to fix this it was too difficult to change all of the code.

**_Stop and Wait ARQ_**

If I had not made such mistakes as I mentioned above I would have  finished a fully functional system that solves our problem. This protocol is known as Stop and Wait ARQ (automatic repeat-request). A downside of stop and wait is that the sender must wait around for an ACK before it can send the next packet. The packet rate is limited directly by latency. 

**_Reflection_**

In conclusion I believe I could have improved upon this protocol if I had not made certain mistakes or even if I had some more extra time. However, I have learned more about sockets, threads and the different types of ARQ due to this assignment and I am content that I was able to create this protocol to the best of my ability.
