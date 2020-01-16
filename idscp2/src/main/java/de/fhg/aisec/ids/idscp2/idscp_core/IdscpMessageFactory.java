package de.fhg.aisec.ids.idscp2.idscp_core;

import com.google.protobuf.ByteString;
import de.fhg.aisec.ids.messages.IDSCPv2.*;

import java.util.Arrays;

public class IdscpMessageFactory {

    public static IdscpMessage getIdscpHelloMessage(byte[] dat, String[] supportedRatSuite, String[] expectedRatSuite){
        IdscpDat idscpDat = IdscpDat.newBuilder()
                .setToken(ByteString.copyFrom(dat))
                .build();

        IdscpHello idscpHello = IdscpHello.newBuilder()
                .setVersion(2)
                .setDynamicAttributeToken(idscpDat)
                .addAllExpectedRatSuite(Arrays.asList(expectedRatSuite))
                .addAllSupportedRatSuite(Arrays.asList(supportedRatSuite))
                .build();

        return IdscpMessage.newBuilder()
                .setType(IdscpMessage.Type.IDSCP_HELLO)
                .setIdscpHello(idscpHello)
                .build();
    }

    public static IdscpMessage getIdscpCloseMessage(){
        return IdscpMessage.newBuilder()
                . setType(IdscpMessage.Type.IDSCP_CLOSE)
                .setIdscpClose(IdscpClose.newBuilder().build())
                .build();
    }

    public static IdscpMessage getIdscpErrorMessage(String msg, String code){
        IdscpError idscpError = IdscpError.newBuilder()
                .setErrorMsg(msg)
                .setErrorCode(code)
                .build();

        return IdscpMessage.newBuilder()
                . setType(IdscpMessage.Type.IDSCP_ERROR)
                .setIdscpError(idscpError)
                .build();
    }

    public static IdscpMessage getIdscpDatExpiredMessage(){
        return IdscpMessage.newBuilder()
                . setType(IdscpMessage.Type.IDSCP_DAT_EXPIRED)
                .setIdscpDatExpired(IdscpDatExpired.newBuilder().build())
                .build();
    }

    public static IdscpMessage getIdscpDatMessage(byte[] dat){
        IdscpDat idscpDat = IdscpDat.newBuilder()
                .setToken(ByteString.copyFrom(dat))
                .build();

        return IdscpMessage.newBuilder()
                . setType(IdscpMessage.Type.IDSCP_DAT)
                .setIdscpDat(idscpDat)
                .build();
    }

    public static IdscpMessage getIdscpReRatMessage(String cause){
        IdscpReRat idscpReRat = IdscpReRat.newBuilder()
                .setCause(cause)
                .build();

        return IdscpMessage.newBuilder()
                . setType(IdscpMessage.Type.IDSCP_RE_RAT)
                .setIdscpReRat(idscpReRat)
                .build();
    }

    public static IdscpMessage getIdscpDataMessage(byte[] data){
        IdscpData idscpData = IdscpData.newBuilder()
                .setData(ByteString.copyFrom(data))
                .build();

        return IdscpMessage.newBuilder()
                . setType(IdscpMessage.Type.IDSCP_DATA)
                .setIdscpData(idscpData)
                .build();
    }

}