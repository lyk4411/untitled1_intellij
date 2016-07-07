package com.wenhuisoft.snmp3;

/**
 * Created by lyk on 2016/7/7.
 */

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.*;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;


public class SnmpPoc {

    private Snmp snmp = null;

    private Address targetAddress = null;

    private TransportMapping transport = null;

    private String username = "user1";
    private String authPassword = "password1";
    private String privPassword = "password2";


    public static void main(String[] args) {


        SnmpPoc poc = new SnmpPoc();


        try {
            poc.init();


            poc.sendV1Trap();


            poc.sendV2cTrap();


            poc.sendV3TrapNoAuthNoPriv();


            poc.sendV3Auth();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void init() throws IOException {
        targetAddress = GenericAddress.parse("udp:127.0.0.1/162");
        transport = new DefaultUdpTransportMapping();
        snmp = new Snmp(transport);
        transport.listen();
    }


    public ResponseEvent sendV1Trap() throws IOException {
        PDUv1 pdu = new PDUv1();
        VariableBinding v = new VariableBinding();
        v.setOid(SnmpConstants.sysName);
        v.setVariable(new OctetString("Snmp Trap V1 Test"));
        pdu.add(v);
        pdu.setType(PDU.V1TRAP);


// set target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(targetAddress);
// retry times when commuication error
        target.setRetries(2);
// timeout
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version1);
// send pdu, return response
        return snmp.send(pdu, target);
    }


    public ResponseEvent sendV2cTrap() throws IOException {


        PDU pdu = new PDU();
        VariableBinding v = new VariableBinding();
        v.setOid(SnmpConstants.sysName);
        v.setVariable(new OctetString("Snmp Trap V2 Test"));
        pdu.add(v);
        pdu.setType(PDU.TRAP);


// set target
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(targetAddress);


// retry times when commuication error
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
// send pdu, return response
        return snmp.send(pdu, target);


    }


    public ResponseEvent sendV3TrapNoAuthNoPriv() throws IOException {
        SNMP4JSettings.setExtensibilityEnabled(true);
        SecurityProtocols.getInstance().addDefaultProtocols();


        UserTarget target = new UserTarget();
        target.setVersion(SnmpConstants.version3);


        try {
            transport = new DefaultUdpTransportMapping();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        byte[] enginId = "TEO_ID".getBytes();
        USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
                enginId), 500);
        SecurityModels secModels = SecurityModels.getInstance();
        if (snmp.getUSM() == null) {
            secModels.addSecurityModel(usm);
        }


        target.setSecurityLevel(SecurityLevel.NOAUTH_NOPRIV);


        target.setAddress(targetAddress);


        ScopedPDU pdu = new ScopedPDU();
        pdu.setType(PDU.NOTIFICATION);
        VariableBinding v = new VariableBinding();
        v.setOid(SnmpConstants.sysName);
        v.setVariable(new OctetString("Snmp Trap V3 Test"));
        pdu.add(v);


        snmp.setLocalEngine(enginId, 500, 1);
        return snmp.send(pdu, target);
    }


    public ResponseEvent sendV3Auth() throws IOException {
        SNMP4JSettings.setExtensibilityEnabled(true);
        SecurityProtocols.getInstance().addDefaultProtocols();


        UserTarget target = new UserTarget();
        target.setSecurityName(new OctetString(username));
        target.setVersion(SnmpConstants.version3);


        try {
            transport = new DefaultUdpTransportMapping();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        byte[] enginId = "TEO_ID".getBytes();
        USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
                enginId), 500);
        SecurityModels secModels = SecurityModels.getInstance();
        synchronized (secModels) {
            if (snmp.getUSM() == null) {
                secModels.addSecurityModel(usm);
            }


            snmp.getUSM().addUser(
                    new OctetString(username),
                    new OctetString(enginId),
                    new UsmUser(new OctetString(username), AuthMD5.ID,
                            new OctetString(authPassword), Priv3DES.ID,
                            new OctetString(privPassword)));
            target.setSecurityLevel(SecurityLevel.AUTH_PRIV);


            target.setAddress(targetAddress);


            ScopedPDU pdu = new ScopedPDU();
            pdu.setType(PDU.NOTIFICATION);
            VariableBinding v = new VariableBinding();
            v.setOid(SnmpConstants.sysName);
            v.setVariable(new OctetString("Snmp Trap V3 Test"));
            pdu.add(v);


            snmp.setLocalEngine(enginId, 500, 1);
            return snmp.send(pdu, target);
        }
    }
}