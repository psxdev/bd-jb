# bd-jb
bd-jb is a BD-JB reimplementation for prospero based on TheFlow's report and sleirsgoevy base code

By now only implemented:
- Vulnerability #2 to list /app0 content
- Added udp logs you can get it in your pc change host variable on MyXlet.java and use something like this on your pc/mac:
```
socat udp-recv:18194 stdout
```
Logs on your host
===========================
```
[HOST] debugnet listener up
[HOST] ready to have a lot of fun!!!
[PROSPERO][INFO] [+] UdpLogger initialized...
[PROSPERO][INFO] [+] Receive udp log in 192.168.1.12 with: socat udp-recv:18194 stdout
[PROSPERO][INFO] [+] bd-jb by bigboss based on TheFlow and sleirsgoevy implementation
[PROSPERO][INFO] [+] Escaping Java Sandbox...
[PROSPERO][INFO] [+] Creating File object with path /app0
[PROSPERO][INFO] [+] Creating FakeIxcProxy object...
[PROSPERO][INFO] [+] FakeIxcProxy object created...
[PROSPERO][INFO] [+] Invoking list method with pInvokeMethod...
[PROSPERO][INFO] cdc
[PROSPERO][INFO] psm
[PROSPERO][INFO] sce_sys
[PROSPERO][INFO] BdmvPlayerCore.elf
[PROSPERO][INFO] BdvdPlayerCore.elf
[PROSPERO][INFO] CapFont_MARU.cbf.GZ
[PROSPERO][INFO] CapSound.pcm
[PROSPERO][INFO] TA_AACS.sbin
[PROSPERO][INFO] UHDBdPlayerCore.elf
[PROSPERO][INFO] eboot.bin
[PROSPERO][INFO] libAacs.sprx
[PROSPERO][INFO] libBdplus.sprx
[PROSPERO][INFO] libCprm.sprx
[PROSPERO][INFO] libCss.sprx
```

 Screenshot
===========================
 <img align="left" src="https://github.com/psxdev/bd-jb/blob/master/screenshot.png">


 Change log
===========================
 - 18/06/2022 Initial public release 
 

  Credits
===========================
  
 - @TheOfficialFloW for his amazing presentation and all the research done
 - @sleirsgoevy for base code and helping with @zecoxao to fix the bracketgate :P 
 - @frangar @fjtrujy @psxdev aka "los nenes"
 

